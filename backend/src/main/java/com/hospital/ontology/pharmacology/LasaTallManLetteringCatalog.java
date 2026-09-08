package com.hospital.ontology.pharmacology;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class LasaTallManLetteringCatalog {

    @Data
    @AllArgsConstructor
    public static class TallManPair {
        private String tallManNameA;
        private String tallManNameB;
        private String primaryIndicationA;
        private String primaryIndicationB;
    }

    private final List<TallManPair> pairs = new ArrayList<>();

    public LasaTallManLetteringCatalog() {
        pairs.add(new TallManPair("predniSONE", "prednisoLONE", "Systemic Corticosteroid", "Active metabolite corticosteroid"));
        pairs.add(new TallManPair("hydrOXYzine", "hydrALAzine", "Antihistamine / Anxiolytic", "Direct-acting vasodilator antihypertensive"));
        pairs.add(new TallManPair("vinBLAStine", "vinCRIStine", "Vinca Alkaloid (Bone marrow suppression)", "Vinca Alkaloid (Neurotoxicity, Fatal if intrathecal)"));
    }

    public List<TallManPair> getPairs() { return pairs; }
}
