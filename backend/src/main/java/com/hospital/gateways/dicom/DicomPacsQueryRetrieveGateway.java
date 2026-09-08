package com.hospital.gateways.dicom;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class DicomPacsQueryRetrieveGateway {

    @Data
    @Builder
    public static class DicomQueryResult {
        private String patientId;
        private String patientName;
        private String studyInstanceUid;
        private String modality;
        private String studyDescription;
        private int numberOfStudyRelatedSeries;
        private int numberOfStudyRelatedInstances;
        private String retrieveAeTitle;
    }

    public List<DicomQueryResult> queryPacsByPatientId(String patientId, String modality) {
        return List.of(
            DicomQueryResult.builder()
                .patientId(patientId)
                .patientName("DOE^JOHN")
                .studyInstanceUid("1.2.840.113619.2.55.3.2831164.88192")
                .modality(modality != null ? modality : "CT")
                .studyDescription("CT CHEST WITH IV CONTRAST (PULMONARY EMBOLISM PROTOCOL)")
                .numberOfStudyRelatedSeries(4)
                .numberOfStudyRelatedInstances(512)
                .retrieveAeTitle("CORE_PACS_SCP")
                .build()
        );
    }
}
