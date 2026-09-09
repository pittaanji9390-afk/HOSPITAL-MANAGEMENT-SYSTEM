package com.hospital.pharmacy.knowledge;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Pharmacological & WHO ATC Drug Monograph Knowledge Base.
 * Detailed clinical pharmacology, mechanism of action, pharmacokinetics,
 * CYP450 interactions, Black Box Warnings, and toxicological antidotes.
 */
@Component
public class ComprehensiveAtcDrugDirectory {

    @Data
    @Builder
    public static class DrugMonograph {
        private String atcCode;
        private String genericName;
        private String tradeNames;
        private String chemicalClass;
        private String mechanismOfAction;
        private String bioavailability;
        private String plasmaProteinBinding;
        private String eliminationHalfLife;
        private String primaryExcretionRoute;
        private String cyp450Metabolism; // e.g. CYP3A4 substrate, CYP2D6 inhibitor
        private List<String> approvedIndications;
        private List<String> absoluteContraindications;
        private String blackBoxWarning;
        private List<String> severeAdverseReactions;
        private String antidoteAndOverdoseManagement;
    }

    private static final List<DrugMonograph> MONOGRAPHS = new ArrayList<>();

    static {
        // ==========================================
        // ATC GROUP C: CARDIOVASCULAR SYSTEM
        // ==========================================
        add("C09CA07", "Telmisartan", "Micardis, Telma, Arbitel", "Angiotensin II Receptor Blocker (ARB)",
                "Selectively and irreversibly blocks the AT1 subtype of the angiotensin II receptor, preventing angiotensin II-mediated vasoconstriction, aldosterone secretion, and sympathetic activation. Also acts as a partial agonist of Peroxisome Proliferator-Activated Receptor gamma (PPAR-gamma).",
                "Approx 42% (Food reduces AUC by 6-20%)",
                "> 99.5% (Bound primarily to albumin and alpha-1-acid glycoprotein)",
                "Approx 24 hours (Longest half-life among all ARBs, providing sustained 24-hr BP control)",
                "Biliary and fecal excretion (> 97%); minimal renal elimination (< 1%)",
                "Metabolized via UGT1A3 glucuronidation; not significantly metabolized by CYP450 enzymes",
                Arrays.asList("Essential Hypertension", "Cardiovascular Risk Reduction in patients aged >= 55 unable to take ACE inhibitors", "Diabetic Nephropathy"),
                Arrays.asList("Pregnancy (Second and Third Trimesters - Fetal toxicity)", "Concomitant use with Aliskiren in patients with Diabetes Mellitus", "Severe Biliary Obstructive Disorders"),
                "BLACK BOX WARNING: FETAL TOXICITY - When pregnancy is detected, discontinue Telmisartan as soon as possible. Drugs that act directly on the renin-angiotensin system can cause oligohydramnios, fetal renal failure, craniofacial deformities, and neonatal death.",
                Arrays.asList("Hyperkalemia (especially with potassium-sparing diuretics)", "Symptomatic hypotension / Syncope", "Acute renal impairment in bilateral renal artery stenosis", "Angioedema (rare compared to ACE inhibitors)"),
                "Overdose leads to profound hypotension, tachycardia, or bradycardia. Management: Place patient in supine Trendelenburg position, administer IV Normal Saline boluses, monitor electrolytes. Not dialyzable.");

        add("C08CA01", "Amlodipine Besylate", "Norvasc, Amlong, Stamlo", "Dihydropyridine Calcium Channel Blocker",
                "Inhibits the transmembrane influx of extracellular calcium ions across L-type voltage-sensitive calcium channels into vascular smooth muscle and cardiac myocytes during depolarization, leading to peripheral arterial vasodilation and reduced total peripheral resistance.",
                "64% to 90% (High oral bioavailability unaffected by food intake)",
                "93% to 98% (Bound to circulating plasma proteins)",
                "30 to 50 hours (Permits once-daily dosing; extended in elderly and hepatic dysfunction)",
                "Renal (60% as metabolites, 10% unchanged) and biliary/fecal (20-25%)",
                "Extensively metabolized in the liver via CYP3A4 to inactive metabolites",
                Arrays.asList("Essential Hypertension", "Chronic Stable Angina Pectoris", "Vasospastic (Prinzmetal's) Angina", "Coronary Artery Disease"),
                Arrays.asList("Known hypersensitivity to dihydropyridines", "Severe cardiogenic shock", "Severe aortic stenosis with hemodynamic instability"),
                "None directly assigned, but use with extreme caution in heart failure (NYHA Class III-IV) and severe hepatic impairment.",
                Arrays.asList("Dose-dependent peripheral ankle edema (precapillary vasodilation)", "Reflex flushing and headache", "Gingival hyperplasia with long-term use", "Severe hypotension in overdose"),
                "Overdose produces refractory vasodilatory shock and conduction defects. Management: IV Calcium Gluconate (10-20 mL 10%), High-Dose Insulin Euglycemia Therapy (HIET: 1 unit/kg bolus + 0.5-1 unit/kg/hr infusion with D10W/D50W), and Norepinephrine infusion.");

        add("C10AA05", "Atorvastatin Calcium", "Lipitor, Atorva, Storvas", "HMG-CoA Reductase Inhibitor (Statin)",
                "Competitively and selectively inhibits 3-hydroxy-3-methylglutaryl-coenzyme A (HMG-CoA) reductase, the rate-limiting enzyme converting HMG-CoA to mevalonate in cholesterol biosynthesis. Increases hepatic LDL surface receptors, accelerating LDL clearance from circulation.",
                "Approx 14% (Extensive first-pass hepatic extraction)",
                ">= 98% (Bound to albumin and lipoproteins)",
                "Approx 14 hours (Inhibitory activity for HMG-CoA reductase persists for 20-30 hours due to active ortho- and parahydroxylated metabolites)",
                "Biliary elimination following hepatic metabolism (< 2% renal recovery)",
                "Major substrate of Cytochrome P450 CYP3A4 (High drug-drug interaction potential with Clarithromycin, Ketoconazole, Protease inhibitors, and Grapefruit juice)",
                Arrays.asList("Primary Hypercholesterolemia (Heterozygous familial and non-familial)", "Mixed Dyslipidemia (Fredrickson Type IIa/IIb)", "Primary Prevention of Major Adverse Cardiac Events (MACE)", "Secondary Prevention in established ASCVD (ACS, Post-PCI, Post-CABG)"),
                Arrays.asList("Active liver disease or unexplained persistent transaminase elevations (> 3x ULN)", "Pregnancy and Breastfeeding (Teratogenic)", "Concomitant use of strong CYP3A4 inhibitors (Cyclosporine, Gemfibrozil)"),
                "None directly assigned. Contraindicated in pregnancy.",
                Arrays.asList("Statin-Associated Muscle Symptoms (SAMS: Myalgia, Myopathy)", "Rhabdomyolysis with myoglobinuria and acute renal failure (CK > 10x ULN)", "Transaminitis / Drug-induced liver injury", "New-onset Type 2 Diabetes Mellitus (small dose-dependent risk)"),
                "No specific antidote for statin overdose. Discontinue immediately, hydrate aggressively with IV fluids and alkalinize urine (IV Sodium Bicarbonate) if rhabdomyolysis is present.");

        // ==========================================
        // ATC GROUP J: ANTI-INFECTIVES FOR SYSTEMIC USE
        // ==========================================
        add("J01CR02", "Amoxicillin and Clavulanic Acid", "Augmentin, Clavam, Curam", "Beta-Lactam + Beta-Lactamase Inhibitor",
                "Amoxicillin binds to penicillin-binding proteins (PBPs 1A, 1B, 2, 3), inhibiting bacterial cell wall peptidoglycan synthesis leading to osmotic lysis. Clavulanic acid acts as a suicide inhibitor of Class A serine beta-lactamases (TEM, SHV, CTX-M), restoring amoxicillin spectrum against beta-lactamase producing bacteria.",
                "Amoxicillin: ~75-80%; Clavulanate: ~60% (Rapidly absorbed; food enhances clavulanate absorption and reduces GI distress)",
                "Low protein binding (Amoxicillin ~18%, Clavulanic acid ~25%)",
                "Approx 1.0 to 1.3 hours in patients with normal renal function (Prolonged in renal failure)",
                "Renal tubular secretion and glomerular filtration (50-70% excreted unchanged in urine in first 6 hours)",
                "Minimal hepatic metabolism; not dependent on CYP450 pathways",
                Arrays.asList("Acute Bacterial Rhinosinusitis", "Community-Acquired Pneumonia", "Acute Otitis Media", "Skin and Soft Tissue Infections (Cellulitis, Animal Bites)", "Complicated Odontogenic Infections"),
                Arrays.asList("History of penicillin anaphylaxis / Type I IgE-mediated hypersensitivity", "History of Amoxicillin/Clavulanate-associated cholestatic jaundice or hepatic dysfunction"),
                "None directly assigned. Severe anaphylactic reactions occur in sensitized patients.",
                Arrays.asList("Gastrointestinal diarrhea (due to clavulanate motility stimulation)", "Cholestatic jaundice / acute hepatitis (more frequent in males and elderly)", "Clostridioides difficile-associated pseudomembranous colitis", "Maculopapular rash (100% incidence in infectious mononucleosis)"),
                "Overdose produces oliguric renal failure due to amoxicillin crystalluria. Management: IV hydration, maintain high urine output. Both amoxicillin and clavulanate are readily cleared by hemodialysis.");

        add("J01XA01", "Vancomycin Hydrochloride", "Vancocin, Vancogen", "Tricyclic Glycopeptide Antibiotic",
                "Binds with high affinity to the D-alanyl-D-alanine terminus of cell wall peptidoglycan pentapeptide precursors, preventing transglycosylase polymerization and cross-linking in Gram-positive bacterial cell walls.",
                "Oral: < 5% (Used orally ONLY for Clostridioides difficile enterocolitis); IV: 100%",
                "30% to 55% (Bound to serum albumin)",
                "4 to 6 hours in adults with normal renal function (Can extend to 7 to 10 days in anuric ESRD)",
                "Renal elimination (> 80-90% eliminated unchanged by glomerular filtration)",
                "No hepatic metabolism; no CYP450 involvement",
                Arrays.asList("Invasive Methicillin-Resistant Staphylococcus aureus (MRSA) bacteremia and endocarditis", "Hospital-Acquired and Ventilator-Associated Pneumonia (HAP/VAP)", "Complicated Osteomyelitis and Septic Arthritis", "Oral treatment of severe C. difficile colitis"),
                Arrays.asList("Known hypersensitivity to vancomycin"),
                "None directly assigned. Requires therapeutic drug monitoring (TDM: Target AUC/MIC 400-600 or Trough 15-20 mcg/mL in severe infections).",
                Arrays.asList("Vancomycin Infusion Reaction ('Red Man Syndrome' due to histamine degranulation from rapid infusion)", "Dose-dependent Nephrotoxicity (Acute tubular necrosis, synergistic with Pip-Tazo)", "Ototoxicity / Sensorineural hearing loss (especially with aminoglycosides)", "DRESS syndrome and neutropenia"),
                "Management: Stop infusion immediately. For infusion reaction: Slow infusion rate to >= 2 hours and pre-treat with IV Diphenhydramine. For nephrotoxicity: Discontinue drug, switch to Daptomycin or Linezolid. High-flux hemodialysis removes approx 20-30%.");

        // ==========================================
        // ATC GROUP N: NERVOUS SYSTEM
        // ==========================================
        add("N02BE01", "Paracetamol (Acetaminophen)", "Tylenol, Dolo, Calpol, Ofirmev", "Anilide Analgesic and Antipyretic",
                "Centrally inhibits prostaglandin synthesis by selective inhibition of Cyclooxygenase-3 (COX-3) and peroxidase component of COX-1/2 in the brain; stimulates descending serotonergic pain inhibitory pathways and interacts with the cannabinoid/vanilloid receptor system (via AM404 metabolite). Lacks peripheral anti-inflammatory activity.",
                "Oral: 70% to 90%; Rectal: 30% to 40%; IV: 100%",
                "10% to 25% at therapeutic concentrations",
                "1.5 to 2.5 hours in adults",
                "Renal (90-100% as glucuronide and sulfate conjugates; < 5% unchanged)",
                "Major hepatic pathway (85-90%) via Glucuronidation (UGT1A6) and Sulfation; minor pathway (5-10%) via CYP2E1 generating toxic metabolite N-acetyl-p-benzoquinone imine (NAPQI)",
                Arrays.asList("Mild to Moderate Nociceptive Pain", "Fever and Pyrexia Reduction in Adults and Children", "First-line baseline multimodal postoperative analgesia"),
                Arrays.asList("Severe active hepatic failure or decompensated cirrhosis", "Known hypersensitivity to acetaminophen"),
                "BLACK BOX WARNING: HEPATOTOXICITY - Acetaminophen has been associated with cases of acute liver failure, at times resulting in liver transplant and death. Most cases of liver injury are associated with the use of acetaminophen at doses that exceed 4000 milligrams per day.",
                Arrays.asList("Centrilobular hepatic necrosis (in overdose)", "Renal papillary necrosis with chronic high-dose abuse", "Rare severe cutaneous adverse reactions (Stevens-Johnson syndrome, TEN)"),
                "SPECIFIC ANTIDOTE: N-ACETYLCYSTEINE (NAC). Ingestions > 150 mg/kg: Obtain 4-hour serum paracetamol level plotted on the Rumack-Matthew Nomogram. Administer IV NAC (3-bag protocol: 150 mg/kg over 1 hr, then 50 mg/kg over 4 hrs, then 100 mg/kg over 16 hrs) to replenish hepatic glutathione stores.");

        add("N02AA01", "Morphine Sulfate", "Duramorph, MS Contin, Morcontin", "Natural Opium Phenanthrene Alkaloid",
                "Pure opioid receptor agonist with high affinity for the Mu-opioid receptor (MOR) in the central nervous system and spinal cord dorsal horn. Activates G-protein coupled receptors, inhibits adenylate cyclase, closes presynaptic voltage-gated calcium channels, and opens postsynaptic inward-rectifying potassium channels, blocking nociceptive neurotransmission.",
                "Oral: 20% to 40% (Subject to extensive first-pass metabolism); IV/SC: 100%",
                "30% to 35% (Bound to albumin)",
                "2 to 4 hours in adults",
                "Renal (90% as glucuronide conjugates; Morphine-6-Glucuronide is an active potent analgesic that accumulates in renal failure; Morphine-3-Glucuronide is neurotoxic)",
                "Hepatic glucuronidation primarily via UGT2B7; not dependent on CYP450 enzymes",
                Arrays.asList("Severe Acute Pain (Polytrauma, Burns, Postoperative)", "Pain associated with Acute Myocardial Infarction", "Chronic Severe Malignant Cancer Pain", "Acute Pulmonary Edema (reduces sympathetic preload and anxiety)"),
                Arrays.asList("Severe respiratory depression (RR < 10/min)", "Acute or severe bronchial asthma in an unmonitored setting", "Paralytic ileus or known mechanical bowel obstruction", "Concurrent use of MAO inhibitors within 14 days"),
                "BLACK BOX WARNING: ADDICTION, ABUSE, AND MISUSE; LIFE-THREATENING RESPIRATORY DEPRESSION; ACCIDENTAL INGESTION; NEONATAL OPIOID WITHDRAWAL SYNDROME; AND RISKS FROM CONCOMITANT USE WITH BENZODIAZEPINES OR OTHER CNS DEPRESSANTS.",
                Arrays.asList("Dose-dependent respiratory depression", "Profound sedation and coma", "Histamine release causing bronchospasm, flushing, and pruritus", "Severe constipation (decreased peristalsis)", "Miosis (pinpoint pupils)", "Nausea and vomiting via chemoreceptor trigger zone (CTZ) stimulation"),
                "SPECIFIC ANTIDOTE: NALOXONE HYDROCHLORIDE (Narcan). Administer 0.04 to 0.4 mg IV/IM/Intranasal, repeated q2-3 minutes until normal spontaneous ventilation is restored. Titrate carefully in opioid-dependent patients to prevent acute severe withdrawal and adrenergic storm.");
    }

    private static void add(String atc, String gen, String trade, String chem, String moa,
                            String bio, String prot, String hl, String exc, String cyp,
                            List<String> ind, List<String> contra, String bbw, List<String> adr, String ant) {
        MONOGRAPHS.add(DrugMonograph.builder()
                .atcCode(atc)
                .genericName(gen)
                .tradeNames(trade)
                .chemicalClass(chem)
                .mechanismOfAction(moa)
                .bioavailability(bio)
                .plasmaProteinBinding(prot)
                .eliminationHalfLife(hl)
                .primaryExcretionRoute(exc)
                .cyp450Metabolism(cyp)
                .approvedIndications(ind)
                .absoluteContraindications(contra)
                .blackBoxWarning(bbw)
                .severeAdverseReactions(adr)
                .antidoteAndOverdoseManagement(ant)
                .build());
    }

    public List<DrugMonograph> search(String query) {
        if (query == null || query.isBlank()) {
            return MONOGRAPHS;
        }
        String q = query.toLowerCase().trim();
        return MONOGRAPHS.stream()
                .filter(m -> m.getAtcCode().toLowerCase().contains(q) ||
                             m.getGenericName().toLowerCase().contains(q) ||
                             m.getTradeNames().toLowerCase().contains(q) ||
                             m.getChemicalClass().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }

    public Optional<DrugMonograph> findByAtcCode(String code) {
        return MONOGRAPHS.stream()
                .filter(m -> m.getAtcCode().equalsIgnoreCase(code))
                .findFirst();
    }
}
