package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Clinical Decision Engine for Acute Pancreatitis, Biliary Obstruction & Peptic Ulcer Disease.
 * Production-grade medical knowledge models, diagnostic criteria, and evidence-based clinical protocols.
 */
@Component
public class GastroenterologyPancreatoBiliaryEngine {

    @Data
    @Builder
    public static class ClinicalMonograph {
        private String icdCode;
        private String conditionName;
        private String diagnosticCriteria;
        private String evidenceBasedTherapy;
    }

    private static final List<ClinicalMonograph> REGISTRY = new ArrayList<>();

    static {
        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("K85.90")
                .conditionName("Severe Acute Necrotizing Pancreatitis (Atlanta Revised)")
                .diagnosticCriteria("Serum Lipase > 3x ULN, persistent organ failure > 48 hours, > 30% pancreatic parenchymal necrosis on CECT")
                .evidenceBasedTherapy("Goal-directed Lactated Ringer fluid resuscitation (5-10 mL/kg/hr); Early enteral nasojejunal nutrition; Step-Up approach: Percutaneous drainage followed by minimally invasive retroperitoneal necrosectomy (VARD)")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("K80.00")
                .conditionName("Acute Calculous Cholecystitis with Choledocholithiasis")
                .diagnosticCriteria("Positive Murphy sign, gallbladder wall thickening > 4mm, dilated Common Bile Duct > 7mm")
                .evidenceBasedTherapy("Urgent Endoscopic Retrograde Cholangiopancreatography (ERCP with biliary sphincterotomy and stone extraction) followed by early Laparoscopic Cholecystectomy within 72h")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("K83.0")
                .conditionName("Acute Ascending Cholangitis (Tokyo Guidelines Grade III)")
                .diagnosticCriteria("Charcot Triad (Fever, RUQ pain, Jaundice) + Reynolds Pentad (Hypotension + Altered Mental Status)")
                .evidenceBasedTherapy("EMERGENT BILIARY DECOMPRESSION via ERCP or Percutaneous Transhepatic Biliary Drainage (PTBD) within 12 hours + IV Meropenem 1g q8h")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("K25.0")
                .conditionName("Acute Gastric Ulcer Bleeding (Forrest Class Ia / Ib)")
                .diagnosticCriteria("Active arterial spurting (Ia) or oozing (Ib) hemorrhage seen on emergency esophagogastroduodenoscopy (EGD)")
                .evidenceBasedTherapy("Dual endoscopic hemostasis (Epinephrine 1:10,000 injection + Thermocoagulation / Hemoclips) + IV Pantoprazole 80mg bolus then 8mg/hr continuous infusion for 72 hours")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("K50.0")
                .conditionName("Crohn Disease with Severe Ileocolic Stricture")
                .diagnosticCriteria("Transmural cobblestone mucosal ulceration, skip lesions, non-caseating granulomas, obstructive symptoms")
                .evidenceBasedTherapy("Induction therapy: Infliximab 5 mg/kg IV at 0, 2, 6 weeks + Azathioprine 2.0-2.5 mg/kg/day; Endoscopic balloon dilation or laparoscopic ileocecal resection for fibrotic strictures")
                .build());

    }

    public List<ClinicalMonograph> getAllMonographs() {
        return Collections.unmodifiableList(REGISTRY);
    }

    public Optional<ClinicalMonograph> findByCode(String icdCode) {
        if (icdCode == null) return Optional.empty();
        return REGISTRY.stream()
                .filter(m -> m.getIcdCode().equalsIgnoreCase(icdCode.trim()))
                .findFirst();
    }

    public List<ClinicalMonograph> searchByKeyword(String keyword) {
        if (keyword == null || keyword.isBlank()) return REGISTRY;
        String q = keyword.toLowerCase().trim();
        return REGISTRY.stream()
                .filter(m -> m.getIcdCode().toLowerCase().contains(q) ||
                             m.getConditionName().toLowerCase().contains(q) ||
                             m.getDiagnosticCriteria().toLowerCase().contains(q) ||
                             m.getEvidenceBasedTherapy().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }
}
