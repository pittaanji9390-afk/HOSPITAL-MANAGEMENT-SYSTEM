package com.hospital.controller.clinical;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/admissions")
@CrossOrigin(origins = "*")
public class ClinicalAdmissionEpisodeRestController {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AdmissionRequestDto {
        private String patientId;
        private String admittingDoctorId;
        private String department;
        private String assignedBed;
        private String admissionType; // ELECTIVE, EMERGENCY, URGENT, NEWBORN
        private String chiefComplaint;
        private String initialEstimatedLosDays;
    }

    @Data
    @AllArgsConstructor
    public static class AdmissionResponseDto {
        private String admissionId;
        private String patientId;
        private String status;
        private Instant admittedAt;
        private String assignedWardBed;
        private String admittingDoctorName;
        private String message;
    }

    private final Map<String, AdmissionResponseDto> activeAdmissions = new LinkedHashMap<>();

    public ClinicalAdmissionEpisodeRestController() {
        activeAdmissions.put("ADM-994101", new AdmissionResponseDto("ADM-994101", "PT-9941", "INPATIENT_ACTIVE", Instant.now().minusSeconds(86400 * 2), "ICU-Bed-04", "Dr. Gregory House", "Patient admitted and stabilized in ICU"));
        activeAdmissions.put("ADM-881202", new AdmissionResponseDto("ADM-881202", "PT-8812", "INPATIENT_ACTIVE", Instant.now().minusSeconds(3600 * 12), "CCU-Bed-02", "Dr. Meredith Grey", "Post-PCI monitoring underway"));
    }

    @GetMapping
    public ResponseEntity<List<AdmissionResponseDto>> getAllAdmissions() {
        return ResponseEntity.ok(new ArrayList<>(activeAdmissions.values()));
    }

    @GetMapping("/{admissionId}")
    public ResponseEntity<AdmissionResponseDto> getAdmissionById(@PathVariable String admissionId) {
        AdmissionResponseDto adm = activeAdmissions.get(admissionId);
        if (adm == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(adm);
    }

    @PostMapping
    public ResponseEntity<AdmissionResponseDto> createAdmission(@RequestBody AdmissionRequestDto request) {
        String newId = "ADM-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        AdmissionResponseDto res = new AdmissionResponseDto(newId, request.getPatientId(), "INPATIENT_ACTIVE", Instant.now(), request.getAssignedBed(), "Dr. Assigned Staff", "Admission registered successfully");
        activeAdmissions.put(newId, res);
        log.info("[ADMISSION-API] Created new inpatient episode: {} for patient: {}", newId, request.getPatientId());
        return ResponseEntity.ok(res);
    }
}
