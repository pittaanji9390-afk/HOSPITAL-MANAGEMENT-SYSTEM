package com.hospital.staff;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DoctorLeaveRepository extends JpaRepository<DoctorLeave, Long> {
    List<DoctorLeave> findByDoctorIdAndStatus(Long doctorId, DoctorLeave.LeaveStatus status);

    @Query("SELECT COUNT(l) > 0 FROM DoctorLeave l WHERE l.doctor.id = :doctorId AND l.status = 'APPROVED' AND :date BETWEEN l.startDate AND l.endDate")
    boolean isDoctorOnLeave(@Param("doctorId") Long doctorId, @Param("date") LocalDate date);
}
