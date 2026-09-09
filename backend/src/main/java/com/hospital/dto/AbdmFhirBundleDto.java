package com.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AbdmFhirBundleDto {
    private String bundleId;
    private String abhaAddress;
    private String abhaNumber;
    private String resourceType; // DiagnosticReport, Prescription, DischargeSummary, ImmunizationRecord
    private String consentArtefactId;
    private LocalDateTime generatedTimestamp;
    private String digitalSignatureSha256;
    private List<String> fhirResourcePayloads;
}
