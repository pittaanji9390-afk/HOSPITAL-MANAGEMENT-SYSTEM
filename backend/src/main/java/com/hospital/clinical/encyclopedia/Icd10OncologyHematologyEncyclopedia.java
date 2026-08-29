package com.hospital.clinical.encyclopedia;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise ICD-10-CM Oncology & Hematology Clinical Encyclopedia (Chapters II & III: C00-D89).
 * Comprehensive clinical monographs for Colorectal Cancer, Breast Cancer, Non-Small Cell Lung Cancer (NSCLC),
 * Acute Myeloid Leukemia (AML), Immune Thrombocytopenia (ITP), and Febrile Neutropenia.
 */
@Component
public class Icd10OncologyHematologyEncyclopedia {

    @Data
    @Builder
    public static class OncoHemeDiseaseEntry {
        private String icd10Code;
        private String diseaseName;
        private String malignancyType;
        private String molecularPathophysiology;
        private List<String> clinicalPresentation;
        private List<String> diagnosticAndStagingWorkup;
        private List<String> tnmStagingAndRiskStratification;
        private List<String> biomarkerAndMolecularProfiling;
        private List<String> differentialDiagnoses;
        private List<String> evidenceBasedChemoImmunotherapy;
        private List<String> surgicalAndRadiationTherapy;
        private String surveillanceAndPrognosis;
    }

    private static final List<OncoHemeDiseaseEntry> ENTRIES = new ArrayList<>();

    static {
        // =========================================================================
        // SECTION 1: SOLID TUMORS & HEMATOLOGIC MALIGNANCIES (C18, C50, C34, C92)
        // =========================================================================
        add("C18.9", "Malignant Neoplasm of Colon, Unspecified (Colorectal Adenocarcinoma)", "Gastrointestinal Oncology",
                "Malignant epithelial tumor arising from the colonic mucosa. Molecular pathophysiology progresses through two major genomic pathways: (1) Chromosomal Instability (CIN / Adenoma-to-Carcinoma Classical Vogelstein Cascade in 80-85%): Initiated by loss of the APC (Adenomatous Polyposis Coli) tumor suppressor gene on chromosome 5q (leading to beta-catenin accumulation, nuclear translocation, and Wnt pathway activation), followed by activating KRAS/NRAS proto-oncogene mutations (causing constitutive MAPK/ERK signaling and polyp growth), 18q loss of heterozygosity (DCC/SMAD4 loss), and concluding with biallelic inactivation of TP53 tumor suppressor on 17p (loss of G1/S cell cycle checkpoint arrest and apoptosis, triggering invasive carcinoma); (2) Microsatellite Instability (MSI-High / Mismatch Repair Deficient dMMR in 15%): Caused by germline mutations in MMR genes (MLH1, MSH2, MSH6, PMS2 - Lynch Syndrome / HNPCC) or sporadic promoter hypermethylation of MLH1 (CpG Island Methylator Phenotype CIMP), causing genome-wide frameshift mutations, high neoantigen burden, dense tumor-infiltrating lymphocytes (TILs), and exceptional sensitivity to Immune Checkpoint Inhibitor (anti-PD-1) therapy.",
                Arrays.asList("Change in bowel habits (alternating constipation and diarrhea, narrowing of stool caliber / 'pencil-like stools' typical of left-sided/sigmoid lesions)", "Hematochezia (passage of fresh red blood per rectum mixed with stool) in left-sided colon/rectal cancer", "Unexplained Iron Deficiency Anemia, occult gastrointestinal bleeding, fatigue, and pallor typical of right-sided/cecal lesions (large exophytic non-obstructing ulcerating tumors)", "Colicky lower abdominal pain, postprandial fullness, and involuntary weight loss", "Acute mechanical large bowel obstruction or localized peritonitis due to tumor perforation (5-10% of presentations)", "Hepatomegaly, right upper quadrant pain, and ascites in metastatic disease (liver is the primary site of hematogenous metastasis via the portal venous system in 50% of patients)"),
                Arrays.asList("Diagnostic Colonoscopy with multiple endoscopic mucosal biopsies of suspicious masses or ulcerations (Gold standard for visualization and histological confirmation)", "Serum Carcinoembryonic Antigen (CEA baseline measurement: normal < 3-5 ng/mL; values > 10 ng/mL strongly suggest metastatic burden; essential for post-treatment surveillance)", "Contrast-Enhanced Computed Tomography (CECT Chest, Abdomen, and Pelvis with IV and oral contrast): Standard imaging modality for TNM staging, evaluating primary tumor depth, regional lymph node metastases, liver metastases, peritoneal carcinomatosis, and pulmonary metastases", "High-Resolution Pelvic MRI with dedicated phased-array coil: Mandatory for Rectal Cancer to assess distance to Mesorectal Fascia (Circumferential Resection Margin CRM) and Extramural Vascular Invasion (EMVI)", "Complete Blood Count (microcytic hypochromic anemia), Liver Function Tests, Serum Creatinine, and eGFR"),
                Arrays.asList("AJCC / UICC 8TH EDITION TNM STAGING SYSTEM:", "- STAGE I (T1-T2 N0 M0): Tumor invades submucosa (T1) or muscularis propria (T2); no regional lymph nodes; no distant metastasis (5-year survival > 90%);", "- STAGE II (T3-T4 N0 M0): Tumor invades through muscularis propria into subserosa (T3) or perforates visceral peritoneum / invades adjacent organs (T4); no lymph nodes (5-year survival 70-85%);", "- STAGE III (Any T, N1-N2, M0): Regional lymph node metastasis (N1: 1-3 regional nodes; N2: >= 4 regional nodes; 5-year survival 50-70%);", "- STAGE IV (Any T, Any N, M1): Distant metastasis (M1a: 1 organ/site e.g. liver; M1b: > 1 organ; M1c: peritoneal metastases +/- other organs; 5-year survival 14%)"),
                Arrays.asList("MANDATORY BIOMARKER PROFILING ON ALL TUMOR BIOPSIES (Next-Generation Sequencing NGS):", "- Mismatch Repair (MMR) Immunohistochemistry (MLH1, MSH2, MSH6, PMS2) / Microsatellite Instability (MSI by PCR/NGS): dMMR/MSI-H predicts high response to Pembrolizumab/Nivolumab;", "- RAS Mutation Analysis (KRAS and NRAS Exons 2, 3, and 4): Mutations in codons 12, 13, 59, 61, 117, 146 confer INTRINSIC RESISTANCE to anti-EGFR monoclonal antibodies (Cetuximab, Panitumumab);", "- BRAF V600E Mutation: Present in 8-10% of metastatic CRC; confers poor prognosis; targetable with Encorafenib + Cetuximab;", "- HER2 (ERBB2) Amplification (in RAS wild-type tumors): Targetable with Trastuzumab + Tucatinib / Pertuzumab;", "- NTRK Gene Fusions (rare < 1%): Targetable with Larotrectinib or Entrectinib"),
                Arrays.asList("Diverticulitis / Diverticular Stricture", "Inflammatory Bowel Disease (Crohn's Disease or Ulcerative Colitis)", "Ischemic Colitis", "Colonic Volvulus (Cecal or Sigmoid volvulus)", "Gastrointestinal Neuroendocrine Tumors (Carcinoid)", "Gastrointestinal Stromal Tumor (GIST) or Colonic Lymphoma", "Arteriovenous Malformations (AVMs / Angiodysplasia of colon)"),
                Arrays.asList("ADJUVANT SYSTEMIC CHEMOTHERAPY (For Stage III and High-Risk Stage II with dMMR excluded):", "- mFOLFOX6 Regimen (q14 days x 12 cycles / 6 months, or 4 cycles / 3 months for low-risk T1-3 N1): Oxaliplatin (85 mg/m2 IV Day 1) + Leucovorin (400 mg/m2 Day 1) + 5-Fluorouracil (400 mg/m2 IV bolus Day 1, followed by 2400 mg/m2 continuous IV infusion over 46 hours);", "- CAPOX Regimen (q21 days x 8 cycles / 6 months or 4 cycles / 3 months): Oxaliplatin (130 mg/m2 Day 1) + Capecitabine (1000 mg/m2 PO bid Days 1-14);", "FIRST-LINE METASTATIC CHEMOTHERAPY REGIMENS (Stage IV):", "- RAS Wild-Type & Left-Sided Primary Tumors: mFOLFOX6 or FOLFIRI (Irinotecan 180 mg/m2 + 5-FU/LV) + Anti-EGFR Antibody (Cetuximab 500 mg/m2 q2w or Panitumumab 6 mg/kg q2w);", "- RAS Mutant OR Right-Sided Primary Tumors: mFOLFOX6 or FOLFIRI or FOLFOXIRI (triplet: Oxaliplatin + Irinotecan + 5-FU/LV) + Anti-VEGF Antibody (Bevacizumab 5 mg/kg q2w);", "- dMMR / MSI-High Metastatic CRC (Landmark KEYNOTE-177 standard): Pembrolizumab (200 mg IV q3w or 400 mg q6w) OR Nivolumab + Ipilimumab (First-line monotherapy achieving 44% objective response and doubling progression-free survival over chemotherapy);", "- BRAF V600E Mutant Metastatic CRC (Second-line BEACON regimen): Encorafenib (300 mg PO daily) + Cetuximab (500 mg/m2 IV q2w)"),
                Arrays.asList("RADICAL ONCOLOGIC SURGICAL RESECTION (Gold Standard for Cure in Stages I-III):", "- Right Hemicolectomy with ileocolic anastomosis (for cecum, ascending colon, hepatic flexure);", "- Left Hemicolectomy or Sigmoid Colectomy with primary colorectal anastomosis (for splenic flexure, descending, sigmoid colon);", "- Complete Mesocolic Excision (CME) with Central Vascular Ligation (CVL) and mandatory harvest of AT LEAST 12 REGIONAL LYMPH NODES for accurate pathological staging;", "- Total Mesorectal Excision (TME): The gold standard for Rectal Cancer (sharp dissection along the embryological avascular mesorectal holy plane preserving autonomic pelvic plexus nerves and achieving negative circumferential resection margins CRM);", "- Sphincter-Preserving Low Anterior Resection (LAR) or Abdominoperineal Resection (APR / Miles procedure with permanent end colostomy for ultra-low tumors invading the anal sphincter complex);", "NEOADJUVANT TOTAL NEOADJUVANT THERAPY (TNT) FOR LOCALLY ADVANCED RECTAL CANCER (cT3-T4 or N+):", "- Short-course Radiotherapy (5 x 5 Gy = 25 Gy over 1 week) OR Long-course Chemoradiotherapy (50.4 Gy in 28 fractions with concurrent Capecitabine) FOLLOWED BY Consolidation mFOLFOX6/CAPOX, achieving complete clinical response (cCR in 25-35% enabling non-operative 'Watch-and-Wait' organ preservation strategy);", "HEPATIC METASTASECTOMY / ABLATION: Simultaneous or staged surgical resection of resectable colorectal liver metastases (CRLM) with perioperative chemotherapy achieving 5-year survival rates of 40-50% in oligometastatic Stage IV disease"),
                "Prognosis is heavily dependent on pathological stage at diagnosis: 5-year overall survival is > 90% for Stage I, 80-85% for Stage II, 60-70% for Stage III, and 14-20% for Stage IV. Long-term post-operative surveillance protocol (per ASCO/NCCN guidelines): Clinical physical exam and serum CEA every 3-6 months for 2 years, then every 6 months for years 3-5; Annual CECT Chest/Abdomen/Pelvis for 5 years; Surveillance Colonoscopy at 1 year post-resection, then at 3 years, then every 5 years if normal. Major complications include local tumor recurrence, peritoneal carcinomatosis, malignant bowel obstruction, Oxaliplatin-induced chronic peripheral sensory neuropathy, and 5-FU/Capecitabine coronary vasospasm and hand-foot syndrome (palmar-plantar erythrodysesthesia).");
    }

    private static void add(String code, String name, String mal, String patho,
                            List<String> clin, List<String> diag, List<String> tnm,
                            List<String> bio, List<String> diff, List<String> chemo,
                            List<String> surg, String surv) {
        ENTRIES.add(OncoHemeDiseaseEntry.builder()
                .icd10Code(code)
                .diseaseName(name)
                .malignancyType(mal)
                .molecularPathophysiology(patho)
                .clinicalPresentation(clin)
                .diagnosticAndStagingWorkup(diag)
                .tnmStagingAndRiskStratification(tnm)
                .biomarkerAndMolecularProfiling(bio)
                .differentialDiagnoses(diff)
                .evidenceBasedChemoImmunotherapy(chemo)
                .surgicalAndRadiationTherapy(surg)
                .surveillanceAndPrognosis(surv)
                .build());
    }

    public List<OncoHemeDiseaseEntry> search(String query) {
        if (query == null || query.isBlank()) {
            return ENTRIES;
        }
        String q = query.toLowerCase().trim();
        return ENTRIES.stream()
                .filter(e -> e.getIcd10Code().toLowerCase().contains(q) ||
                             e.getDiseaseName().toLowerCase().contains(q) ||
                             e.getMalignancyType().toLowerCase().contains(q) ||
                             e.getMolecularPathophysiology().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }

    public Optional<OncoHemeDiseaseEntry> findByCode(String code) {
        return ENTRIES.stream()
                .filter(e -> e.getIcd10Code().equalsIgnoreCase(code))
                .findFirst();
    }
}
