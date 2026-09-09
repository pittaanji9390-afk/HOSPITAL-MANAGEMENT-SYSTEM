package com.hospital.clinical;

import com.hospital.clinical.knowledge.AntimicrobialStewardshipEngine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DischargeSummaryAndInfectionControlTest {

    private final DischargeSummaryGenerator summaryGenerator = new DischargeSummaryGenerator();
    private final AntimicrobialStewardshipEngine amsEngine = new AntimicrobialStewardshipEngine();

    @Test
    @DisplayName("Discharge Summary: Should compile structured clinical narrative with medications and follow-up")
    void testGenerateDischargeSummaryDocument() {
        DischargeSummaryGenerator.DischargeMedication med1 = DischargeSummaryGenerator.DischargeMedication.builder()
                .drugName("Telmisartan 40mg")
                .dosage("1 Tab")
                .route("ORAL")
                .frequency("Once Daily (Morning)")
                .durationDays(30)
                .instructions("Take with water after breakfast")
                .build();

        DischargeSummaryGenerator.DischargeMedication med2 = DischargeSummaryGenerator.DischargeMedication.builder()
                .drugName("Atorvastatin 20mg")
                .dosage("1 Tab")
                .route("ORAL")
                .frequency("Once Daily (Night)")
                .durationDays(30)
                .instructions("Bedtime dose")
                .build();

        DischargeSummaryGenerator.DischargeSummaryPayload payload = DischargeSummaryGenerator.DischargeSummaryPayload.builder()
                .hospitalName("Apex Multi-Specialty Hospital")
                .hospitalAddress("100 Outer Ring Road, Bengaluru, Karnataka")
                .admissionNo("IPD-10001")
                .patientMrn("MRN-10001")
                .patientName("Anand Patil")
                .patientAge(44)
                .patientGender("MALE")
                .admissionDate(LocalDate.now().minusDays(3))
                .dischargeDate(LocalDate.now())
                .primaryDoctorName("Dr. Rajesh Sharma, MD, DM (Cardio)")
                .departmentName("Cardiology")
                .wardBed("CCU-301 / Bed 1")
                .primaryDiagnosis("Acute ST-Elevation Anterior Wall Myocardial Infarction (ICD-10: I21.0)")
                .secondaryDiagnoses(List.of("Essential Hypertension (I10)", "Dyslipidemia (E78.5)"))
                .admissionReasonAndHistory("Presented with severe retrosternal squeezing chest pain lasting 2 hours.")
                .hospitalCourseAndInterventions("Underwent emergency Primary PCI to LAD with 1x DES. Hemodynamically stable post-procedure.")
                .keyLabAndImagingResults(List.of("Peak Troponin I: 18.4 ng/mL", "Echocardiogram: LVEF 48%, Anterior wall hypokinesia"))
                .dischargeMedications(List.of(med1, med2))
                .dietaryAndPhysicalRestrictions(List.of("Low sodium diet (< 2g/day)", "Graduated walking program; avoid strenuous lifting for 2 weeks"))
                .followUpSchedule("Cardiology Outpatient Clinic on Day 7 (Dr. Rajesh Sharma)")
                .emergencyRedFlags(List.of("Recurrent chest pain / tightness", "Severe breathlessness or dizziness", "Cold sweats"))
                .build();

        String document = summaryGenerator.generateDischargeSummaryDocument(payload);

        assertNotNull(document);
        assertTrue(document.contains("APEX MULTI-SPECIALTY HOSPITAL"));
        assertTrue(document.contains("Anand Patil"));
        assertTrue(document.contains("Acute ST-Elevation Anterior Wall Myocardial Infarction"));
        assertTrue(document.contains("Telmisartan 40mg"));
        assertTrue(document.contains("EMERGENCY RED FLAGS"));
    }

    @Test
    @DisplayName("Infection Control: Should evaluate CDC CAUTI criteria when catheter > 2 days with fever and positive culture")
    void testCautiSurveillanceEvaluation() {
        AntimicrobialStewardshipEngine.HaiSurveillanceCase caseReport = amsEngine.evaluateCauti(
                4, // 4 days catheter in situ
                38.6, // Fever 38.6 C
                true,
                150000 // 1.5 x 10^5 CFU/mL E. coli
        );

        assertNotNull(caseReport);
        assertTrue(caseReport.isCriteriaMet());
        assertEquals("CAUTI", caseReport.getInfectionType());
        assertFalse(caseReport.getRecommendedBundleAudits().isEmpty());
    }

    @Test
    @DisplayName("Infection Control: Should retrieve pre-authorization rules for restricted antibiotics like Colistin")
    void testRestrictedAntibioticList() {
        List<AntimicrobialStewardshipEngine.RestrictedAntimicrobial> list = amsEngine.getRestrictedList();
        assertFalse(list.isEmpty());
        assertTrue(list.stream().anyMatch(a -> a.getAntibioticName().contains("Colistin") && a.isPreAuthorizationRequired()));
    }
}
