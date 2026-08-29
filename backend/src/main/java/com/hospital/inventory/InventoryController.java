package com.hospital.inventory;

import com.hospital.common.*;
import com.hospital.configuration.SequenceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "inventory_categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;
}

@Entity
@Table(name = "inventory_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryItem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 30)
    private String code;

    @Column(nullable = false, length = 100)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private InventoryCategory category;

    @Column(name = "unit_of_measure", nullable = false, length = 30)
    private String unitOfMeasure; // PCS, BOX, BOTTLE, ROLL, PACK, KG

    @Column(name = "current_stock", nullable = false)
    @Builder.Default
    private int currentStock = 0;

    @Column(name = "minimum_stock", nullable = false)
    @Builder.Default
    private int minimumStock = 10;

    @Column(name = "reorder_quantity", nullable = false)
    @Builder.Default
    private int reorderQuantity = 50;

    @Column(name = "unit_cost", nullable = false, precision = 12, scale = 2)
    @Builder.Default
    private BigDecimal unitCost = BigDecimal.ZERO;

    @Column(name = "is_active", nullable = false)
    @Builder.Default
    private boolean active = true;
}

@Entity
@Table(name = "stock_transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
class StockTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false)
    private InventoryItem item;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type", nullable = false, length = 30)
    private TransactionType transactionType;

    @Column(nullable = false)
    private int quantity;

    @Column(name = "unit_cost", nullable = false, precision = 12, scale = 2)
    private BigDecimal unitCost;

    @Column(name = "reference_type", length = 50)
    private String referenceType;

    @Column(name = "reference_id")
    private Long referenceId;

    @Column(columnDefinition = "TEXT")
    private String reason;

    @Column(name = "actor_id", nullable = false, length = 50)
    private String actorId;

    @Column(name = "created_at", nullable = false, updatable = false)
    @Builder.Default
    private Instant createdAt = Instant.now();

    public enum TransactionType {
        PURCHASE, CONSUMPTION, TRANSFER, ADJUSTMENT, RETURN, DISPOSAL
    }
}

@Repository
interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {
    Optional<InventoryItem> findByCode(String code);

    @Query("SELECT i FROM InventoryItem i WHERE i.active = true AND (" +
           "LOWER(i.name) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           "LOWER(i.code) LIKE LOWER(CONCAT('%', :query, '%')))")
    Page<InventoryItem> searchItems(@Param("query") String query, Pageable pageable);

    @Query("SELECT i FROM InventoryItem i WHERE i.currentStock <= i.minimumStock AND i.active = true")
    List<InventoryItem> findLowStockItems();
}

@Repository
interface StockTransactionRepository extends JpaRepository<StockTransaction, Long> {
    Page<StockTransaction> findByItemIdOrderByCreatedAtDesc(Long itemId, Pageable pageable);
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class InventoryItemDto {
    private Long id;
    private String code;
    private String name;
    private Long categoryId;
    private String categoryName;
    private String unitOfMeasure;
    private int currentStock;
    private int minimumStock;
    private int reorderQuantity;
    private BigDecimal unitCost;
    private boolean active;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class AdjustStockRequest {
    @NotNull(message = "Item ID is required")
    private Long itemId;
    @NotNull(message = "Transaction type is required")
    private StockTransaction.TransactionType transactionType;
    @NotNull(message = "Quantity is required")
    private int quantity;
    private String reason;
}

@Service
@RequiredArgsConstructor
class InventoryService {
    private final InventoryItemRepository itemRepository;
    private final StockTransactionRepository transactionRepository;

    @Transactional(readOnly = true)
    public PagedResponse<InventoryItemDto> getItems(String query, Pageable pageable) {
        Page<InventoryItem> page;
        if (query != null && !query.isBlank()) {
            page = itemRepository.searchItems(query, pageable);
        } else {
            page = itemRepository.findAll(pageable);
        }
        return PagedResponse.from(page.map(this::toDto));
    }

    @Transactional(readOnly = true)
    public List<InventoryItemDto> getLowStockItems() {
        return itemRepository.findLowStockItems().stream().map(this::toDto).toList();
    }

    @Transactional
    public InventoryItemDto adjustStock(AdjustStockRequest req, String actor) {
        InventoryItem item = itemRepository.findById(req.getItemId())
                .orElseThrow(() -> new ResourceNotFoundException("Inventory Item", "id", req.getItemId()));

        int delta = req.getQuantity();
        if (req.getTransactionType() == StockTransaction.TransactionType.CONSUMPTION || req.getTransactionType() == StockTransaction.TransactionType.DISPOSAL) {
            if (item.getCurrentStock() < delta) {
                throw new ConflictException("Insufficient stock. Current: " + item.getCurrentStock() + ", Required: " + delta);
            }
            item.setCurrentStock(item.getCurrentStock() - delta);
        } else {
            item.setCurrentStock(item.getCurrentStock() + delta);
        }

        itemRepository.save(item);

        StockTransaction transaction = StockTransaction.builder()
                .item(item)
                .transactionType(req.getTransactionType())
                .quantity(delta)
                .unitCost(item.getUnitCost())
                .reason(req.getReason())
                .actorId(actor)
                .build();
        transactionRepository.save(transaction);

        return toDto(item);
    }

    public InventoryItemDto toDto(InventoryItem i) {
        return InventoryItemDto.builder()
                .id(i.getId())
                .code(i.getCode())
                .name(i.getName())
                .categoryId(i.getCategory() != null ? i.getCategory().getId() : null)
                .categoryName(i.getCategory() != null ? i.getCategory().getName() : "General")
                .unitOfMeasure(i.getUnitOfMeasure())
                .currentStock(i.getCurrentStock())
                .minimumStock(i.getMinimumStock())
                .reorderQuantity(i.getReorderQuantity())
                .unitCost(i.getUnitCost())
                .active(i.isActive())
                .build();
    }
}

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
@Tag(name = "Central Inventory", description = "Medical supplies, stock ledger, stock adjustments, and low stock alerts")
public class InventoryController {
    private final InventoryService service;

    @GetMapping("/items")
    @Operation(summary = "Search inventory items with pagination")
    public ResponseEntity<ApiResponse<PagedResponse<InventoryItemDto>>> getItems(
            @RequestParam(required = false) String query,
            @PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.ok(service.getItems(query, pageable)));
    }

    @GetMapping("/low-stock")
    @Operation(summary = "Get list of supplies below safety threshold")
    public ResponseEntity<ApiResponse<List<InventoryItemDto>>> getLowStock() {
        return ResponseEntity.ok(ApiResponse.ok(service.getLowStockItems()));
    }

    @PostMapping("/adjust")
    @PreAuthorize("hasAuthority('PERM_INVENTORY_MANAGE') or hasRole('INVENTORY_MANAGER') or hasRole('SUPER_ADMIN')")
    @Operation(summary = "Record stock movement (Purchase, Consumption, Transfer, Adjustment)")
    public ResponseEntity<ApiResponse<InventoryItemDto>> adjustStock(@Valid @RequestBody AdjustStockRequest request) {
        return ResponseEntity.ok(ApiResponse.ok(service.adjustStock(request, "INVENTORY_MANAGER"), "Stock adjusted successfully"));
    }
}
