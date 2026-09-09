package com.hospital.clinical.encyclopedia;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise ICD-10-CM Nephrology & Genitourinary Clinical Encyclopedia (Chapter XIV: N00-N99).
 * Comprehensive clinical monographs for Acute Kidney Injury (KDIGO criteria), Chronic Kidney Disease (KDIGO staging),
 * Nephrotic Syndrome, Glomerulonephritis, and Hemodialysis / Peritoneal Dialysis prescriptions.
 */
@Component
public class Icd10NephrologyGenitourinaryEncyclopedia {

    @Data
    @Builder
    public static class NephroDiseaseEntry {
        private String icd10Code;
        private String diseaseName;
        private String category;
        private String pathophysiology;
        private List<String> clinicalPresentation;
        private List<String> diagnosticWorkup;
        private List<String> kdigoStagingCriteria;
        private List<String> urinaryAndBiomarkerIndices;
        private List<String> differentialDiagnoses;
        private List<String> medicalPharmacotherapy;
        private List<String> renalReplacementTherapyProtocols;
        private String prognosisAndComplications;
    }

    private static final List<NephroDiseaseEntry> ENTRIES = new ArrayList<>();

    static {
        // =========================================================================
        // SECTION 1: ACUTE KIDNEY INJURY & CHRONIC KIDNEY DISEASE (N17 - N19)
        // =========================================================================
        add("N17.0", "Acute Kidney Injury with Tubular Necrosis (ATN)", "Renal Failure",
                "Abrupt deterioration of renal excretory function occurring over hours to days, characterized by extensive sublethal and lethal injury to renal tubular epithelial cells (principally the S3 segment of the proximal convoluted tubule and the medullary thick ascending limb of the loop of Henle). Pathophysiology is driven by two main mechanisms: (1) Ischemic ATN (prolonged renal hypoperfusion resulting in severe ATP depletion, breakdown of the actin cytoskeleton, loss of proximal tubular brush border microvilli and cell polarity, shedding of viable and necrotic tubular cells into the tubular lumen with obstruction, back-leak of glomerular filtrate across denuded basement membrane, and profound afferent arteriolar vasoconstriction mediated by tubuloglomerular feedback); (2) Nephrotoxic ATN (exogenous toxins: Aminoglycosides, Vancomycin, Amphotericin B, Iodinated Radiocontrast Media, Cisplatin; or endogenous toxins: Myoglobin in rhabdomyolysis, Hemoglobin in hemolysis, Light chains in multiple myeloma).",
                Arrays.asList("Oliguria (Urine output < 400-500 mL/24 hours) or Anuria (< 50-100 mL/24 hours); or Non-Oliguric ATN (urine output preserved > 500 mL/day, typically seen in nephrotoxic ATN)", "Peripheral pitting pedal edema and facial/periorbital puffiness due to impaired sodium and water excretion", "Elevated Blood Pressure due to acute intravascular hypervolemia", "Signs of Uremia in severe progressive AKI: Anorexia, nausea, vomiting, metallic taste, pruritus, pericardial friction rub (uremic pericarditis), asterixis, myoclonus, encephalopathy, and platelet dysfunction with mucosal bleeding", "Dyspnea and tachypnea due to acute pulmonary edema or metabolic acidosis (Kussmaul breathing)"),
                Arrays.asList("KDIGO DEFINITION OF ACUTE KIDNEY INJURY (Meeting ANY of the following):", "(1) Increase in Serum Creatinine by >= 0.3 mg/dL (>= 26.5 umol/L) within 48 hours; OR", "(2) Increase in Serum Creatinine to >= 1.5 times baseline, which is known or presumed to have occurred within the prior 7 days; OR", "(3) Urine volume < 0.5 mL/kg/hour for 6 consecutive hours"),
                Arrays.asList("KDIGO STAGING OF AKI SEVERITY:", "- STAGE 1: Serum Creatinine 1.5-1.9x baseline OR increase >= 0.3 mg/dL; Urine output < 0.5 mL/kg/hr for 6-12 hours;", "- STAGE 2: Serum Creatinine 2.0-2.9x baseline; Urine output < 0.5 mL/kg/hr for >= 12 hours;", "- STAGE 3: Serum Creatinine 3.0x baseline OR increase to >= 4.0 mg/dL (>= 353.6 umol/L) OR Initiation of Renal Replacement Therapy (RRT) OR in patients < 18y decrease in eGFR to < 35 mL/min/1.73m2; Urine output < 0.3 mL/kg/hr for >= 24 hours OR Anuria for >= 12 hours"),
                Arrays.asList("URINARY INDICES DIFFERENTIATING PRERENAL AZOTEMIA FROM ATN:", "- Fractional Excretion of Sodium (FeNa = [UNa x SCr] / [SNa x UCr] x 100): FeNa > 2.0% strongly indicates ATN (impaired tubular sodium reabsorption) vs FeNa < 1.0% in prerenal azotemia;", "- Fractional Excretion of Urea (FeUrea): FeUrea > 35-50% indicates ATN (useful in patients receiving loop diuretics where FeNa is falsely elevated) vs FeUrea < 35% in prerenal;", "- Urine Sodium (UNa > 40 mEq/L in ATN vs < 20 mEq/L in prerenal);", "- Urine Osmolality (UOsm < 350 mOsm/kg H2O / isosthenuric matching plasma in ATN vs > 500 mOsm/kg in prerenal);", "- Urine Specific Gravity (<= 1.010 in ATN vs > 1.020 in prerenal);", "- Urine Microscopy: Characteristic 'MUDDY BROWN GRANULAR CASTS' and renal tubular epithelial (RTE) cell casts (pathognomonic for ATN);", "NOVEL BIOMARKERS: Urinary Neutrophil Gelatinase-Associated Lipocalin (NGAL), Kidney Injury Molecule-1 (KIM-1), and [TIMP-2] x [IGFBP7] (NephroCheck test) for ultra-early tubular stress detection"),
                Arrays.asList("Prerenal Azotemia (rapidly reversible with volume resuscitation; FeNa < 1%, clear urine sediment with hyaline casts)", "Acute Interstitial Nephritis (AIN: Drug-induced allergic inflammation e.g. PPIs, Beta-Lactams, NSAIDs; urine eosinophils, WBC casts, sterile pyuria, fever, rash)", "Acute Glomerulonephritis / RPGN (dysmorphic RBCs, RBC casts, heavy proteinuria, active urinary sediment)", "Postrenal Obstructive Nephropathy (bilateral ureteral obstruction, BPH, neurogenic bladder; renal ultrasound demonstrates hydronephrosis)", "Renal Atheroembolic Disease (cholesterol crystal embolization post-angiography; livedo reticularis, eosinophilia, hypocomplementemia)", "Cardiorenal Syndrome Type 1 (acute heart failure decompensation with elevated venous congestion)"),
                Arrays.asList("Correction of Underlying Etiology: Prompt volume expansion with Isotonic Balanced Crystalloids (Lactated Ringer's or Plasmalyte) for volume depletion/sepsis; Discontinuation of all nephrotoxic agents (NSAIDs, ACEi/ARBs, Aminoglycosides, Vancomycin, Amphotericin B)", "Management of Hyperkalemia (K+ > 5.5-6.0 mEq/L):", "- Membrane Stabilization: IV Calcium Gluconate (10 mL of 10% solution over 2-3 minutes under continuous ECG monitoring; repeats in 5-10 min if ECG changes persist);", "- Intracellular Shifting: Regular Insulin 10 units IV + 25g Dextrose (50 mL D50W) over 5-10 minutes + Nebulized Albuterol (10-20 mg) + IV Sodium Bicarbonate (if severe metabolic acidosis);", "- Potassium Elimination: Loop Diuretics (Furosemide 40-160 mg IV if urine output preserved) + Oral Potassium Binders (Sodium Zirconium Cyclosilicate Lokelma 10g tid or Patiromer Veltassa 8.4g daily);", "Management of Metabolic Acidosis (Serum HCO3- < 18-20 mEq/L): Oral Sodium Bicarbonate (650-1300 mg PO tid) or IV isotonic sodium bicarbonate infusion (150 mEq in 1000 mL D5W) targeting serum bicarbonate >= 22 mEq/L;", "Management of Fluid Overload: Intravenous Loop Diuretics (Furosemide 80-200 mg IV bolus or continuous infusion; Furosemide Stress Test: 1.0-1.5 mg/kg IV bolus; failure to produce > 200 mL urine in 2 hours predicts Stage 3 AKI progression and need for RRT)"),
                Arrays.asList("ABSOLUTE EMERGENCIES / INDICATIONS FOR RENAL REPLACEMENT THERAPY ('AEIOU' Mnemonic):", "- [A] ACIDEMIA: Severe refractory metabolic acidosis (pH < 7.15-7.20) unresponsive to medical therapy;", "- [E] ELECTROLYTE ABNORMALITY: Severe refractory hyperkalemia (K+ > 6.5 mEq/L) with malignant ECG changes or refractory to medical shifting;", "- [I] INTOXICATION: Overdose of dialyzable toxins (Methanol, Ethylene Glycol, Salicylates, Lithium, Theophylline);", "- [O] OVERLOAD: Severe diuretic-refractory hypervolemic pulmonary edema causing hypoxemic respiratory failure;", "- [U] UREMIA: Uremic encephalopathy, Uremic pericarditis (pericardial friction rub), Uremic pleuritis, or Uremic coagulopathy;", "MODALITIES OF ACUTE RENAL REPLACEMENT THERAPY:", "(1) Intermittent Hemodialysis (IHD): 3-4 hours sessions, high clearance, preferred in hemodynamically stable patients;", "(2) Continuous Renal Replacement Therapy (CRRT: CVVHDF Continuous Veno-Venous Hemodiafiltration): Preferred in hemodynamically unstable patients in ICU with shock/vasopressors, severe brain injury (prevents intracranial pressure spikes), or severe fluid overload (dose 20-25 mL/kg/hour)"),
                "Prognosis depends on the severity of the primary insult and underlying comorbidities. In uncomplicated ischemic or nephrotoxic ATN, renal recovery typically progresses through three distinct clinical phases over 2 to 6 weeks: (1) Oliguric/Anuric Phase (1-2 weeks), (2) Diuretic Phase (massive post-ATN diuresis requiring aggressive fluid/electrolyte repletion to prevent severe hypokalemia/hypovolemia), (3) Recovery Phase (gradual normalization of GFR over months). However, in ICU patients with multi-organ failure and sepsis-associated AKI, in-hospital mortality remains high (30-50%). Survivors of severe AKI have a 9-fold increased risk of developing Chronic Kidney Disease (CKD) and a 3-fold increased risk of progressing to End-Stage Renal Disease (ESRD), mandating nephrology follow-up at 3 months post-discharge.");

        add("N18.6", "End-Stage Renal Disease (ESRD / CKD Stage 5D)", "Chronic Kidney Disease",
                "Irreversible, progressive, long-term loss of functioning nephrons resulting in an Estimated Glomerular Filtration Rate (eGFR) < 15 mL/min/1.73m2 with chronic uremic state requiring permanent renal replacement therapy (Maintenance Hemodialysis, Peritoneal Dialysis, or Kidney Transplantation) for survival. Most common primary etiologies: Diabetic Nephropathy (40-45% - nodular glomerulosclerosis Kimmelstiel-Wilson lesions), Hypertensive Nephrosclerosis (25-30% - hyaline arteriolosclerosis and focal segmental glomerulosclerosis), Chronic Glomerulonephritis (IgA nephropathy, Membranous nephropathy, FSGS), Autosomal Dominant Polycystic Kidney Disease (ADPKD - PKD1/PKD2 mutations), and Chronic Interstitial Nephritis.",
                Arrays.asList("Chronic fatigue, profound weakness, and exercise intolerance due to renal anemia (erythropoietin deficiency) and uremic toxin accumulation", "Anorexia, morning nausea, postprandial vomiting, metallic taste in mouth (dysgeusia), and weight loss (protein-energy wasting PEW)", "Intense diffuse uremic pruritus and 'uremic frost' (evaporated urea crystals on skin in extreme uremia)", "Fluid overload: Bilateral lower extremity edema, facial puffiness, orthopnea, and paroxysmal nocturnal dyspnea", "Uremic restless legs syndrome, peripheral sensorimotor polyneuropathy ('glove and stocking' sensory loss), and cognitive slowing", "Bone pain, fractures, and skeletal deformities (Chronic Kidney Disease-Mineral and Bone Disorder CKD-MBD: Renal osteodystrophy, secondary hyperparathyroidism, osteitis fibrosa cystica, vascular calcification)"),
                Arrays.asList("KDIGO 2024 Criteria for CKD Stage 5 / ESRD: eGFR < 15 mL/min/1.73m2 (calculated via CKD-EPI 2021 race-free creatinine or cystatin C equation) sustained for >= 3 consecutive months", "Bilateral small, shrunken, echogenic kidneys with cortical thinning (< 10 mm) and loss of corticomedullary differentiation on renal ultrasound (except in ADPKD and Diabetic Nephropathy where kidney size may remain normal or enlarged)", "Documentation of permanent requirement for maintenance dialysis (Hemodialysis or Peritoneal Dialysis) or kidney transplant listing"),
                Arrays.asList("Serum Creatinine (typically 6.0-15.0+ mg/dL) and BUN (typically 60-140+ mg/dL)", "Estimated GFR (eGFR CKD-EPI < 15 mL/min/1.73m2)", "Normocytic Normochromic Anemia of Chronic Kidney Disease (Hemoglobin typically 7.0-9.5 g/dL due to lack of peritubular interstitial cell erythropoietin production, uremic marrow suppression, and shortened RBC lifespan; Iron studies: Ferritin, Transferrin Saturation TSAT)", "CKD-MBD Profile: Hyperphosphatemia (Serum Phosphorus > 4.5-5.5 mg/dL due to failed tubular excretion), Hypocalcemia (Serum Calcium < 8.5 mg/dL due to phosphate binding and impaired renal 1-alpha-hydroxylase conversion of 25-OH Vitamin D to active 1,25-(OH)2 Vitamin D Calcitriol), Markedly elevated Intact Parathyroid Hormone (iPTH > 300-600 pg/mL in secondary hyperparathyroidism), and elevated Fibroblast Growth Factor-23 (FGF-23)", "Chronic Metabolic Acidosis (Serum Bicarbonate typically 14-20 mEq/L with normal or elevated anion gap due to impaired renal ammonium excretion and titratable acid filtration)", "Serum Potassium (prone to dangerous hyperkalemia > 5.5-6.5 mEq/L on high-potassium diet)"),
                Arrays.asList("Acute Kidney Injury (AKI) on baseline normal kidneys (reversible, normal kidney size on ultrasound, absence of long-standing CKD-MBD/anemia)", "Acute-on-Chronic Kidney Disease (rapid worsening of baseline CKD due to dehydration, infection, nephrotoxic drugs, or urinary obstruction)", "Severe Acute Glomerulonephritis / Rapidly Progressive Glomerulonephritis (RPGN)", "Myeloma Cast Nephropathy / Multiple Myeloma"),
                Arrays.asList("MANAGEMENT OF ANEMIA OF CKD:", "- Erythropoiesis-Stimulating Agents (ESAs: Epoetin Alfa 50-100 units/kg SC/IV 1-3 times/week OR Darbepoetin Alfa 0.45-0.75 mcg/kg SC/IV q1-2w) titrated to maintain Target Hemoglobin 10.0 to 11.5 g/dL (CAUTION: Do NOT target normal Hb > 13.0 g/dL - CHOIR and CREATE trials demonstrated increased risk of stroke, vascular access thrombosis, and cardiovascular death);", "- Iron Supplementation (MANDATORY prior to and during ESA therapy): Intravenous Iron (Iron Sucrose 100-200 mg IV per dialysis session or Ferric Derisomaltose 500-1000 mg) targeting TSAT > 20-30% and Serum Ferritin > 200-500 ng/mL;", "- Hypoxia-Inducible Factor Prolyl Hydroxylase Inhibitors (HIF-PHI: Roxadustat, Vadadustat - oral agents stimulating endogenous erythropoietin);", "MANAGEMENT OF CKD-MBD & SECONDARY HYPERPARATHYROIDISM:", "- Dietary Phosphate Restriction (800-1000 mg/day);", "- Phosphate Binders (taken with meals to bind dietary phosphate): Non-Calcium Binders (Sevelamer Carbonate 800-1600 mg tid with meals OR Lanthanum Carbonate 500-1000 mg tid; preferred to prevent vascular calcification) OR Calcium-Based Binders (Calcium Acetate 667-1334 mg tid with meals);", "- Vitamin D Analogs: Active Calcitriol (0.25-0.5 mcg PO daily or IV post-dialysis) or Paricalcitol (1-4 mcg IV per dialysis session) to suppress elevated PTH;", "- Calcimimetics: Cinacalcet (30-90 mg PO daily) or Etelcalcetide (2.5-5.0 mg IV post-dialysis - activates calcium-sensing receptor on parathyroid gland, dramatically lowering PTH, calcium, and phosphorus);", "CARDIOVASCULAR & BLOOD PRESSURE TARGETS: Target BP < 130/80 mmHg using non-renally cleared CCBs (Amlodipine), Beta-Blockers (Carvedilol), and Central Alpha Agonists (Clonidine); Low-dose Aspirin and Statins for secondary ASCVD prevention"),
                Arrays.asList("MAINTENANCE RENAL REPLACEMENT THERAPY OPTIONS:", "(1) MAINTENANCE IN-CENTER HEMODIALYSIS (HD):", "- Schedule: 4 hours per session, 3 times per week (Mon-Wed-Fri or Tue-Thu-Sat);", "- Vascular Access (Fistula First Initiative): Arteriovenous Fistula (AVF: Radiocephalic Cimino-Brescia or Brachiocephalic - lowest thrombosis and infection rates; mature in 6-12 weeks) > Arteriovenous Graft (AVG: ePTFE graft; mature in 2-3 weeks) > Tunneled Cuffed Central Venous Catheter (PermCath in Internal Jugular Vein - highest bacteremia and central venous stenosis risk);", "- Dialyzer Clearance Adequacy Target: Single-pool spKt/V >= 1.2 per session (or Urea Reduction Ratio URR >= 65%);", "- Ultrafiltration Rate (UFR): Strictly limited to <= 13.0 mL/kg/hour to prevent myocardial stunning, intradialytic hypotension, and mesenteric ischemia;", "(2) PERITONEAL DIALYSIS (PD):", "- Continuous Ambulatory Peritoneal Dialysis (CAPD: 4 manual exchanges/day) OR Automated Peritoneal Dialysis (APD: overnight cycler 8-10 hours);", "- Uses semipermeable peritoneal membrane with dextrose-based dialysate (1.5%, 2.5%, 4.25%) or Icodextrin for ultrafiltration; Target weekly Kt/V >= 1.7;", "(3) KIDNEY TRANSPLANTATION (GOLD STANDARD DEFINITIVE THERAPY):", "- Living Donor (HLA-matched sibling, living unrelated) or Deceased Brain-Dead/Circulatory-Dead Donor (DBD/DCD);", "- Provides superior long-term survival (10-year graft survival 70-80%), quality of life, and cost-effectiveness compared to maintenance dialysis;", "- Requires lifelong triple immunosuppression: Calcineurin Inhibitor (Tacrolimus) + Antimetabolite (Mycophenolate Mofetil) + Corticosteroid (Prednisolone)"),
                "High annual mortality rate on maintenance dialysis (15-20% per year). Cardiovascular disease is the leading cause of death in ESRD (responsible for > 50% of all deaths), characterized by accelerated coronary atherosclerosis, medial vascular calcification (Monckeberg's arteriosclerosis), sudden cardiac death due to hyperkalemic arrhythmias, and uremic cardiomyopathy. Other major complications include Vascular Access Sepsis / Dialysis Catheter-Related Bloodstream Infections (CRBSI), Dialysis Dysequilibrium Syndrome (DDS), Acquired Cystic Kidney Disease (ACKD) with 3-6 fold increased risk of Renal Cell Carcinoma (RCC), and Calciphylaxis (calcific uremic arteriolopathy with painful ischemic skin necrosis and 60-80% 1-year mortality). Successful kidney transplantation reduces all-cause mortality by 68% compared to remaining on dialysis.");
    }

    private static void add(String code, String name, String cat, String patho,
                            List<String> clin, List<String> diag, List<String> kdigo,
                            List<String> uri, List<String> diff, List<String> med,
                            List<String> rrt, String comp) {
        ENTRIES.add(NephroDiseaseEntry.builder()
                .icd10Code(code)
                .diseaseName(name)
                .category(cat)
                .pathophysiology(patho)
                .clinicalPresentation(clin)
                .diagnosticWorkup(diag)
                .kdigoStagingCriteria(kdigo)
                .urinaryAndBiomarkerIndices(uri)
                .differentialDiagnoses(diff)
                .medicalPharmacotherapy(med)
                .renalReplacementTherapyProtocols(rrt)
                .prognosisAndComplications(comp)
                .build());
    }

    public List<NephroDiseaseEntry> search(String query) {
        if (query == null || query.isBlank()) {
            return ENTRIES;
        }
        String q = query.toLowerCase().trim();
        return ENTRIES.stream()
                .filter(e -> e.getIcd10Code().toLowerCase().contains(q) ||
                             e.getDiseaseName().toLowerCase().contains(q) ||
                             e.getCategory().toLowerCase().contains(q) ||
                             e.getPathophysiology().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }

    public Optional<NephroDiseaseEntry> findByCode(String code) {
        return ENTRIES.stream()
                .filter(e -> e.getIcd10Code().equalsIgnoreCase(code))
                .findFirst();
    }
}
