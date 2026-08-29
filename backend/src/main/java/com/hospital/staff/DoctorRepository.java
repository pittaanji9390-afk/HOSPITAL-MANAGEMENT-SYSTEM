package com.hospital.staff;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findByLicenseNo(String licenseNo);
    Optional<Doctor> findByStaffId(Long staffId);
    List<Doctor> findByActiveTrue();
    List<Doctor> findByStaffDepartmentIdAndActiveTrue(Long departmentId);

    @Query("SELECT d FROM Doctor d JOIN d.staff s WHERE d.active = true AND (" +
           "LOWER(s.firstName) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           "LOWER(s.lastName) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           "LOWER(d.specialization) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           "LOWER(d.licenseNo) LIKE LOWER(CONCAT('%', :query, '%')))")
    Page<Doctor> searchDoctors(@Param("query") String query, Pageable pageable);
}
