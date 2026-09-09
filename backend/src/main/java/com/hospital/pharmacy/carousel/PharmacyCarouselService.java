package com.hospital.pharmacy.carousel;

import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Inpatient Pharmacy Vertical Carousel & Pick-to-Light Orchestrator (e.g. Talyst AutoCarousel / Swisslog BoxPicker).
 * Rotates shelves to target pick window and illuminates bin LEDs for cart-fill batches.
 */
@Service
public class PharmacyCarouselService {

    public record CarouselBin(int carouselNumber, int shelfTier, int binPosition, String ndcCode, String drugName, int quantityOnHand, String lightDisplayColor) {}
    public record PickDirective(String pickId, String cartBatchId, CarouselBin bin, int qtyToPick, boolean confirmedByBarcode) {}

    private final Map<String, CarouselBin> inventoryBins = new ConcurrentHashMap<>();
    private final List<PickDirective> activePickQueue = Collections.synchronizedList(new ArrayList<>());

    public PharmacyCarouselService() {
        seedCarouselInventory();
    }

    private void seedCarouselInventory() {
        inventoryBins.put("00093-0145-01", new CarouselBin(1, 4, 12, "00093-0145-01", "Amoxicillin 500mg Caps", 1200, "#00FF00"));
        inventoryBins.put("00006-0749-54", new CarouselBin(1, 4, 13, "00006-0749-54", "Losartan Potassium 50mg", 950, "#00FF00"));
        inventoryBins.put("00069-3150-66", new CarouselBin(2, 2, 5, "00069-3150-66", "Atorvastatin Calcium 20mg", 1400, "#3388FF"));
        inventoryBins.put("00781-1506-10", new CarouselBin(2, 8, 1, "00781-1506-10", "Metformin HCl 500mg ER", 2100, "#FFFF00"));
    }

    public synchronized PickDirective queuePick(String batchId, String ndc, int quantity) {
        CarouselBin bin = inventoryBins.get(ndc);
        if (bin == null || bin.quantityOnHand() < quantity) {
            throw new IllegalStateException("Carousel bin depleted or missing for NDC: " + ndc);
        }
        PickDirective directive = new PickDirective(UUID.randomUUID().toString(), batchId, bin, quantity, false);
        activePickQueue.add(directive);
        return directive;
    }

    public synchronized PickDirective confirmPick(String pickId, String scannedNdc) {
        Optional<PickDirective> match = activePickQueue.stream().filter(p -> p.pickId().equals(pickId)).findFirst();
        if (match.isEmpty()) throw new IllegalArgumentException("Pick directive not in queue: " + pickId);

        PickDirective dir = match.get();
        if (!dir.bin().ndcCode().equals(scannedNdc)) {
            throw new IllegalArgumentException("Barcode mismatch during pick confirmation! Expected: " + dir.bin().ndcCode());
        }

        // Deduct quantity
        CarouselBin current = dir.bin();
        inventoryBins.put(current.ndcCode(), new CarouselBin(current.carouselNumber(), current.shelfTier(), current.binPosition(), current.ndcCode(), current.drugName(), current.quantityOnHand() - dir.qtyToPick(), current.lightDisplayColor()));
        
        PickDirective confirmed = new PickDirective(dir.pickId(), dir.cartBatchId(), dir.bin(), dir.qtyToPick(), true);
        activePickQueue.remove(dir);
        return confirmed;
    }

    public List<CarouselBin> listAllBins() {
        return new ArrayList<>(inventoryBins.values());
    }
}
