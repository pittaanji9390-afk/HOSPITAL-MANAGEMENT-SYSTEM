package com.hospital.pharmacy;

import com.hospital.pharmacy.knowledge.NationalDrugFormulary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class NationalDrugFormularyTest {

    private final NationalDrugFormulary formulary = new NationalDrugFormulary();

    @Test
    @DisplayName("Formulary: Should retrieve Telmisartan with ATC C09CA07 and pregnancy category D")
    void testTelmisartanLookup() {
        Optional<NationalDrugFormulary.DrugProduct> drug = formulary.findByCode("NDC-0078-0495");
        assertTrue(drug.isPresent());
        assertEquals("Telmisartan", drug.get().getGenericName());
        assertEquals("C09CA07", drug.get().getAtcCode());
        assertEquals("D", drug.get().getPregnancyCategory());
    }

    @Test
    @DisplayName("Formulary: Should verify Vancomycin requires mandatory trough monitoring")
    void testVancomycinTroughGuideline() {
        Optional<NationalDrugFormulary.DrugProduct> vanc = formulary.findByCode("NDC-0002-7510");
        assertTrue(vanc.isPresent());
        assertTrue(vanc.get().isHighAlertMedication());
        assertTrue(vanc.get().getRenalAdjustmentGuideline().contains("trough concentration"));
    }

    @Test
    @DisplayName("Formulary: Should flag Morphine as a controlled substance with active metabolite warnings")
    void testMorphineControlledSubstance() {
        Optional<NationalDrugFormulary.DrugProduct> morphine = formulary.findByCode("NDC-0074-3212");
        assertTrue(morphine.isPresent());
        assertTrue(morphine.get().isControlledSubstance());
        assertTrue(morphine.get().getRenalAdjustmentGuideline().contains("M6G"));
    }

    @Test
    @DisplayName("Formulary: Should search antidiabetic biguanide agents")
    void testSearchAntidiabetic() {
        List<NationalDrugFormulary.DrugProduct> results = formulary.search("Metformin");
        assertFalse(results.isEmpty());
        assertTrue(results.get(0).getRenalAdjustmentGuideline().contains("Lactic Acidosis"));
    }
}
