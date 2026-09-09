package com.hospital.clinical;

import com.hospital.clinical.knowledge.ComprehensiveLoincTestDirectory;
import com.hospital.clinical.knowledge.Icd10ClinicalEncyclopedia;
import com.hospital.pharmacy.knowledge.ComprehensiveAtcDrugDirectory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ComprehensiveKnowledgeBasesTest {

    private final Icd10ClinicalEncyclopedia diseaseEncyclopedia = new Icd10ClinicalEncyclopedia();
    private final ComprehensiveAtcDrugDirectory atcDrugDirectory = new ComprehensiveAtcDrugDirectory();
    private final ComprehensiveLoincTestDirectory loincDirectory = new ComprehensiveLoincTestDirectory();

    @Test
    @DisplayName("Disease Encyclopedia: Should retrieve STEMI Anterior Wall with diagnostic criteria and first-line PCI guidelines")
    void testStemiAnteriorLookup() {
        Optional<Icd10ClinicalEncyclopedia.ClinicalDiseaseEntry> entry = diseaseEncyclopedia.findByCode("I21.0");
        assertTrue(entry.isPresent());
        assertEquals("ST-Elevation Myocardial Infarction (STEMI) of Anterior Wall", entry.get().getDiseaseName());
        assertEquals("Circulatory System", entry.get().getChapter());
        assertTrue(entry.get().getPathophysiology().contains("Left Anterior Descending"));
        assertFalse(entry.get().getDiagnosticCriteria().isEmpty());
    }

    @Test
    @DisplayName("Disease Encyclopedia: Should search chronic metabolic diseases")
    void testSearchDiabetes() {
        List<Icd10ClinicalEncyclopedia.ClinicalDiseaseEntry> list = diseaseEncyclopedia.search("Diabetes");
        assertFalse(list.isEmpty());
        assertTrue(list.stream().anyMatch(d -> d.getIcd10Code().startsWith("E10") || d.getIcd10Code().startsWith("E11")));
    }

    @Test
    @DisplayName("ATC Drug Directory: Should retrieve Telmisartan with pharmacokinetics, 24-hr half-life, and Black Box Warning")
    void testTelmisartanMonograph() {
        Optional<ComprehensiveAtcDrugDirectory.DrugMonograph> mono = atcDrugDirectory.findByAtcCode("C09CA07");
        assertTrue(mono.isPresent());
        assertEquals("Telmisartan", mono.get().getGenericName());
        assertTrue(mono.get().getEliminationHalfLife().contains("24 hours"));
        assertTrue(mono.get().getBlackBoxWarning().contains("FETAL TOXICITY"));
    }

    @Test
    @DisplayName("ATC Drug Directory: Should retrieve Paracetamol with N-Acetylcysteine specific antidote protocol")
    void testParacetamolAntidote() {
        Optional<ComprehensiveAtcDrugDirectory.DrugMonograph> mono = atcDrugDirectory.findByAtcCode("N02BE01");
        assertTrue(mono.isPresent());
        assertTrue(mono.get().getAntidoteAndOverdoseManagement().contains("N-ACETYLCYSTEINE"));
    }

    @Test
    @DisplayName("LOINC Directory: Should retrieve Serum Potassium with critical panic thresholds (2.8 and 6.2 mmol/L)")
    void testPotassiumLoinc() {
        Optional<ComprehensiveLoincTestDirectory.LoincTestEntry> test = loincDirectory.findByLoincCode("2823-3");
        assertTrue(test.isPresent());
        assertEquals(2.8, test.get().getCriticalLowAlert());
        assertEquals(6.2, test.get().getCriticalHighAlert());
        assertTrue(test.get().getPreAnalyticalHandling().contains("pseudohyperkalemia"));
    }

    @Test
    @DisplayName("LOINC Directory: Should retrieve Prothrombin Time INR with target therapeutic intervals")
    void testInrLoinc() {
        Optional<ComprehensiveLoincTestDirectory.LoincTestEntry> test = loincDirectory.findByLoincCode("5902-2");
        assertTrue(test.isPresent());
        assertEquals("INR (Ratio)", test.get().getStandardUnit());
        assertEquals(5.0, test.get().getCriticalHighAlert());
    }
}
