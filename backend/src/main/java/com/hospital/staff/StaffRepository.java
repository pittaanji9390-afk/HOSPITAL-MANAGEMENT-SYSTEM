package com.hospital.staff;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    Optional<Staff> findByEmployeeNo(String employeeNo);
    Optional<Staff> findByUserId(Long userId);
    boolean existsByEmployeeNo(String employeeNo);
    List<Staff> findByDepartmentIdAndActiveTrue(Long departmentId);
    Page<Staff> findByActiveTrue(Pageable pageable);

    @Query("SELECT s FROM Staff s WHERE s.active = true AND (" +
           "LOWER(s.firstName) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           "LOWER(s.lastName) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           "LOWER(s.employeeNo) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           "LOWER(s.designation) LIKE LOWER(CONCAT('%', :query, '%')))")
    Page<Staff> searchStaff(@Param("query") String query, Pageable pageable);
}
