package com.hospital.ontology.operations;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.*;

@Component
public class PhysicianClinicalPrivilegingCatalog {

    @Data
    @AllArgsConstructor
    public static class ClinicalPrivilegeProfile {
        private String doctorId;
        private String specialty;
        private List<String> approvedCorePrivileges;
        private List<String> approvedSpecialPrivileges;
        private LocalDate privilegeExpirationDate;
        private boolean isFppeActive;
        private double oppeQualityScorePercent;
    }

    private final Map<String, ClinicalPrivilegeProfile> profiles = new LinkedHashMap<>();

    public PhysicianClinicalPrivilegingCatalog() {
        profiles.put("DR-7719", new ClinicalPrivilegeProfile("DR-7719", "Interventional Cardiology", List.of("General Inpatient Cardiology", "Diagnostic Coronary Angiogram", "Echocardiography TTE/TEE"), List.of("Percutaneous Coronary Intervention (PCI)", "TAVR", "Impella Insertion"), LocalDate.now().plusYears(2), false, 98.5));
        profiles.put("DR-8820", new ClinicalPrivilegeProfile("DR-8820", "Neurosurgery", List.of("Craniotomy for Trauma/Tumor", "Spinal Fusion", "Ventriculoperitoneal Shunt"), List.of("Stereotactic Radiosurgery", "Endovascular Aneurysm Coiling"), LocalDate.now().plusYears(2), false, 99.1));
    }

    public Optional<ClinicalPrivilegeProfile> getProfile(String docId) { return Optional.ofNullable(profiles.get(docId)); }
}
