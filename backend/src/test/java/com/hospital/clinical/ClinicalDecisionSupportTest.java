package com.hospital.clinical;

import com.hospital.clinical.cdss.ClinicalScoringCalculator;
import com.hospital.clinical.knowledge.ComprehensiveLoincTestDirectory;
import com.hospital.clinical.knowledge.DrugInteractionEngine;
import com.hospital.clinical.knowledge.Icd10ClinicalEncyclopedia;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ClinicalDecisionSupportTest {

    private final ClinicalScoringCalculator calculator = new ClinicalScoringCalculator();
    private final DrugInteractionEngine drugInteractionEngine = new DrugInteractionEngine();
    private final Icd10ClinicalEncyclopedia icd10Encyclopedia = new Icd10ClinicalEncyclopedia();
    private final ComprehensiveLoincTestDirectory loincDirectory = new ComprehensiveLoincTestDirectory();

    @Test
    @DisplayName("MEWS: Should calculate critical score and trigger Rapid Response Team when vitals are unstable")
    void testMewsCriticalScore() {
        ClinicalScoringCalculator.MewsInput input = ClinicalScoringCalculator.MewsInput.builder()
                .systolicBp(75)          // Score: 2
                .heartRate(135)          // Score: 3
                .respiratoryRate(24)     // Score: 2
                .tempCelsius(39.1)       // Score: 2
                .avpu(ClinicalScoringCalculator.AvpuScale.REACTS_TO_VOICE) // Score: 1
                .build();

        ClinicalScoringCalculator.MewsResult result = calculator.calculateMews(input);

        assertNotNull(result);
        assertEquals(10, result.getTotalScore());
        assertEquals("CRITICAL", result.getRiskLevel());
        assertTrue(result.getClinicalAction().contains("Rapid Response Team"));
    }

    @Test
    @DisplayName("MEWS: Normal vitals should score 0 with routine observation")
    void testMewsNormalScore() {
        ClinicalScoringCalculator.MewsInput input = ClinicalScoringCalculator.MewsInput.builder()
                .systolicBp(120)
                .heartRate(72)
                .respiratoryRate(16)
                .tempCelsius(36.8)
                .avpu(ClinicalScoringCalculator.AvpuScale.ALERT)
                .build();

        ClinicalScoringCalculator.MewsResult result = calculator.calculateMews(input);

        assertEquals(0, result.getTotalScore());
        assertEquals("LOW", result.getRiskLevel());
    }

    @Test
    @DisplayName("GCS: Should identify severe brain injury and indicate intubation when GCS <= 8")
    void testGcsSevereIntubation() {
        ClinicalScoringCalculator.GcsInput input = ClinicalScoringCalculator.GcsInput.builder()
                .eyeOpening(2)      // Eye opening to pain
                .verbalResponse(2)  // Incomprehensible sounds
                .motorResponse(3)   // Abnormal flexion (decorticate)
                .build();

        ClinicalScoringCalculator.GcsResult result = calculator.calculateGcs(input);

        assertEquals(7, result.getTotalGcs());
        assertEquals("SEVERE_BRAIN_INJURY", result.getInjuryClassification());
        assertTrue(result.isIntubationIndicated());
    }

    @Test
    @DisplayName("CURB-65: Should calculate high pneumonia mortality and recommend inpatient ICU admission")
    void testCurb65Score() {
        ClinicalScoringCalculator.Curb65Input input = ClinicalScoringCalculator.Curb65Input.builder()
                .confusion(true)
                .ureaMmolPerL(8.5)
                .respiratoryRate(32)
                .systolicBp(85)
                .diastolicBp(55)
                .age(72)
                .build();

        ClinicalScoringCalculator.Curb65Result result = calculator.calculateCurb65(input);

        assertEquals(5, result.getScore());
        assertTrue(result.getMortalityRisk().contains("HIGH"));
        assertTrue(result.getRecommendedDisposition().contains("ICU"));
    }

    @Test
    @DisplayName("CKD-EPI: Should calculate accurate eGFR without race coefficients")
    void testEgfrCalculation() {
        BigDecimal egfr = calculator.calculateEgfrCkdEpi(1.2, 55, false);
        assertNotNull(egfr);
        assertTrue(egfr.compareTo(BigDecimal.valueOf(60.0)) > 0);
    }

    @Test
    @DisplayName("CDSS: Should detect severe Warfarin + Aspirin major bleeding interaction")
    void testDrugInteractionDetection() {
        List<DrugInteractionEngine.DrugInteraction> interactions = drugInteractionEngine.checkInteractions(
                List.of("Warfarin", "Aspirin", "Paracetamol"));

        assertFalse(interactions.isEmpty());
        assertEquals(1, interactions.size());
        assertEquals(DrugInteractionEngine.Severity.MAJOR, interactions.get(0).getSeverity());
        assertTrue(interactions.get(0).getClinicalEffect().contains("hemorrhage"));
    }

    @Test
    @DisplayName("CDSS: Should detect absolute Simvastatin + Clarithromycin contraindication")
    void testDrugContraindicationDetection() {
        List<DrugInteractionEngine.DrugInteraction> interactions = drugInteractionEngine.checkInteractions(
                List.of("Simvastatin", "Clarithromycin"));

        assertFalse(interactions.isEmpty());
        assertEquals(DrugInteractionEngine.Severity.CONTRAINDICATED, interactions.get(0).getSeverity());
        assertTrue(interactions.get(0).getClinicalEffect().contains("rhabdomyolysis"));
    }

    @Test
    @DisplayName("ICD-10 Master: Should retrieve primary hypertension code I10")
    void testIcd10Lookup() {
        Optional<Icd10ClinicalEncyclopedia.DiseaseMonograph> entry = icd10Encyclopedia.findByCode("I10");
        assertTrue(entry.isPresent());
        assertTrue(entry.get().getConditionName().contains("Hypertension"));
    }

    @Test
    @DisplayName("LOINC Master: Should retrieve high-sensitivity cardiac troponin I test 42757-5")
    void testLoincLookup() {
        Optional<ComprehensiveLoincTestDirectory.LoincTestEntry> entry = loincDirectory.findByCode("42757-5");
        assertTrue(entry.isPresent());
        assertTrue(entry.get().getComponentName().contains("Troponin I"));
        assertEquals("ng/mL", entry.get().getStandardUnit());
    }
}
