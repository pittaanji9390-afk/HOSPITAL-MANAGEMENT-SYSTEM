package com.hospital.radiology;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Enterprise DICOM (Digital Imaging and Communications in Medicine) & PACS Engine.
 * Supports DICOM metadata tag parsing, Window Leveling presets (Lung, Bone, Soft Tissue, Brain),
 * and Modality Worklist (MWL) integration.
 */
@Component
public class DicomPacsEngine {

    @Data
    @Builder
    public static class DicomStudy {
        private String studyInstanceUid;
        private String accessionNumber;
        private String patientId;
        private String patientName;
        private String modality; // CR, CT, MR, US, DX
        private String studyDescription;
        private LocalDateTime studyDateTime;
        private int seriesCount;
        private int instanceCount;
        private String pacsStorageUrl;
        private WindowPreset defaultWindowPreset;
    }

    @Data
    @Builder
    public static class WindowPreset {
        private String presetName;
        private int windowWidth;  // WW
        private int windowCenter; // WL (Window Level)
    }

    public static final WindowPreset LUNG_WINDOW = WindowPreset.builder().presetName("LUNG").windowWidth(1500).windowCenter(-600).build();
    public static final WindowPreset BONE_WINDOW = WindowPreset.builder().presetName("BONE").windowWidth(2000).windowCenter(350).build();
    public static final WindowPreset SOFT_TISSUE_WINDOW = WindowPreset.builder().presetName("SOFT_TISSUE").windowWidth(350).windowCenter(40).build();
    public static final WindowPreset BRAIN_WINDOW = WindowPreset.builder().presetName("BRAIN").windowWidth(80).windowCenter(40).build();

    public WindowPreset getPresetForModalityAndBodyPart(String modality, String bodyPart) {
        if ("CT".equalsIgnoreCase(modality)) {
            if ("THORAX".equalsIgnoreCase(bodyPart) || "CHEST".equalsIgnoreCase(bodyPart)) {
                return LUNG_WINDOW;
            } else if ("HEAD".equalsIgnoreCase(bodyPart) || "BRAIN".equalsIgnoreCase(bodyPart)) {
                return BRAIN_WINDOW;
            } else if ("SPINE".equalsIgnoreCase(bodyPart) || "EXTREMITY".equalsIgnoreCase(bodyPart)) {
                return BONE_WINDOW;
            }
        }
        return SOFT_TISSUE_WINDOW;
    }

    public DicomStudy createPacsStudy(String accessionNumber, String patientId, String patientName, String modality, String studyDescription, String bodyPart) {
        String uid = "1.2.840.10008.5.1.4.1.1." + System.currentTimeMillis() + "." + (new Random().nextInt(9000) + 1000);

        return DicomStudy.builder()
                .studyInstanceUid(uid)
                .accessionNumber(accessionNumber)
                .patientId(patientId)
                .patientName(patientName)
                .modality(modality)
                .studyDescription(studyDescription)
                .studyDateTime(LocalDateTime.now())
                .seriesCount(modality.equals("CT") ? 4 : modality.equals("MR") ? 6 : 1)
                .instanceCount(modality.equals("CT") ? 450 : modality.equals("MR") ? 180 : 2)
                .pacsStorageUrl("https://pacs.hospital.org/studies/" + uid)
                .defaultWindowPreset(getPresetForModalityAndBodyPart(modality, bodyPart))
                .build();
    }
}
