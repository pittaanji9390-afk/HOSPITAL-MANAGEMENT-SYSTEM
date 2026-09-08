package com.hospital.ontology.nursing;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class NandaActivityRestCatalog {

    @Data
    @AllArgsConstructor
    public static class NandaDiagnosis {
        private String code;
        private String diagnosisName;
        private String domain;
        private String classNumber;
        private List<String> definingCharacteristics;
        private List<String> relatedFactors;
        private List<String> suggestedNicInterventions;
        private List<String> targetNocOutcomes;
    }

    private final Map<String, NandaDiagnosis> diagnoses = new LinkedHashMap<>();

    public NandaActivityRestCatalog() {
        diagnoses.put("00029", new NandaDiagnosis("00029", "Decreased Cardiac Output", "Activity/Rest", "4. Cardiovascular/Pulmonary",
            List.of("Cardiac index <2.2 L/min/m2", "Hypotension SBP <90", "Oliguria <0.5 mL/kg/h", "Elevated SVR >1400", "Cold clammy extremities"),
            List.of("Altered myocardial contractility (STEMI, CHF)", "Altered afterload/preload", "Arrhythmias (AFib with RVR, VT)"),
            List.of("Hemodynamic Management (4150)", "Cardiac Care: Acute (4040)", "Medication: Inotropes & Vasopressors (2300)"),
            List.of("Cardiac Pump Effectiveness (0400)", "Circulation Status (0401)", "Vital Signs (0802)")));

        diagnoses.put("00204", new NandaDiagnosis("00204", "Ineffective Peripheral Tissue Perfusion", "Activity/Rest", "4. Cardiovascular/Pulmonary",
            List.of("Diminished or absent peripheral pulses (dorsalis pedis)", "Capillary refill >3 seconds", "Claudication pain", "Pallor upon limb elevation"),
            List.of("Peripheral arterial disease (PAD)", "Diabetes mellitus microangiopathy", "Deep vein thrombosis", "Smoking history"),
            List.of("Circulatory Care: Arterial Insufficiency (4062)", "Foot Care (1660)", "Pain Management (1400)"),
            List.of("Tissue Perfusion: Peripheral (0407)", "Sensory Function: Cutaneous (2400)", "Wound Healing (1102)")));

        diagnoses.put("00092", new NandaDiagnosis("00092", "Activity Intolerance", "Activity/Rest", "2. Activity/Exercise",
            List.of("Exertional dyspnea", "Heart rate increase >20 bpm over resting", "Fatigue during minimal ADLs", "ECG ischemic changes on exertion"),
            List.of("Deconditioning from bedrest", "Imbalance between oxygen supply and demand (COPD, anemia)", "Heart failure NYHA III/IV"),
            List.of("Energy Management (0180)", "Exercise Promotion: Strength Training (0201)", "Cardiac Rehabilitation (4046)"),
            List.of("Activity Tolerance (0005)", "Endurance (0001)", "Self-Care: ADLs (0300)")));

        diagnoses.put("00095", new NandaDiagnosis("00095", "Insomnia", "Activity/Rest", "1. Sleep/Rest",
            List.of("Difficulty falling asleep >30 min", "Frequent nocturnal awakenings", "Non-restorative sleep", "Daytime drowsiness"),
            List.of("ICU delirium / continuous noise & alarms", "Unmanaged pain", "Anxiety / ICU stress", "Frequent vital check interruptions"),
            List.of("Sleep Enhancement (1850)", "Environmental Management: Quiet Night (6482)", "Relaxation Therapy (6040)"),
            List.of("Sleep (0004)", "Rest (0003)", "Comfort Status (2008)")));
    }

    public Optional<NandaDiagnosis> getByCode(String code) { return Optional.ofNullable(diagnoses.get(code)); }
    public List<NandaDiagnosis> getAllDiagnoses() { return new ArrayList<>(diagnoses.values()); }
}
