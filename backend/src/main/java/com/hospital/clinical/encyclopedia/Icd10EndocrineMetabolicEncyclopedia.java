package com.hospital.clinical.encyclopedia;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise ICD-10-CM Endocrine & Metabolic Clinical Encyclopedia (Chapter IV: E00-E89).
 * Comprehensive clinical monographs for Diabetic Ketoacidosis (DKA), Hyperosmolar Hyperglycemic State (HHS),
 * Thyroid Storm (Burch-Wartofsky score), Myxedema Coma, Adrenal Crisis, and Electrolyte Disorders.
 */
@Component
public class Icd10EndocrineMetabolicEncyclopedia {

    @Data
    @Builder
    public static class EndocrineDiseaseEntry {
        private String icd10Code;
        private String diseaseName;
        private String category;
        private String pathophysiology;
        private List<String> clinicalPresentation;
        private List<String> diagnosticCriteria;
        private List<String> laboratoryProfile;
        private List<String> diagnosticScoringAndAlgorithms;
        private List<String> differentialDiagnoses;
        private List<String> emergencyPharmacotherapyProtocol;
        private List<String> maintenancePharmacotherapy;
        private String complicationsAndPrognosis;
    }

    private static final List<EndocrineDiseaseEntry> ENTRIES = new ArrayList<>();

    static {
        // =========================================================================
        // SECTION 1: DIABETES MELLITUS ACUTE METABOLIC COMPLICATIONS (E10 - E14)
        // =========================================================================
        add("E10.10", "Type 1 Diabetes Mellitus with Diabetic Ketoacidosis (DKA) without Coma", "Diabetes Mellitus",
                "Acute life-threatening metabolic derangement resulting from absolute or relative insulin deficiency combined with marked elevation of counter-regulatory hormones (Glucagon, Cortisol, Epinephrine, Growth Hormone). Pathophysiology unfolds across three interconnected pathways: (1) Unopposed lipolysis in adipose tissue: Hormone-sensitive lipase activation releases massive free fatty acids (FFAs) into circulation; hepatic Carnitine Palmitoyltransferase-1 (CPT-1) activation transports FFAs into mitochondrial matrix, accelerating beta-oxidation and ketogenesis, producing Acetoacetate and Beta-Hydroxybutyrate (Beta-OHB); dissociation into hydrogen ions produces severe high anion gap metabolic acidosis; (2) Unrestrained hepatic gluconeogenesis and glycogenolysis with impaired peripheral glucose uptake: Produces severe hyperglycemia (typically 250-600 mg/dL), surpassing the renal threshold for glucose reabsorption (~180 mg/dL), triggering profound osmotic diuresis with massive urinary loss of water (5-7 Liters deficit), sodium, potassium, chloride, magnesium, and phosphate; (3) Intravascular hypovolemia and hyperosmolality.",
                Arrays.asList("Polydipsia (intense thirst), Polyuria (excessive urination), Polyphagia, and rapid weight loss over 1-3 days", "Nausea, intractable vomiting, and severe diffuse abdominal pain ('pseudoperitonitis' caused by delayed gastric emptying, ketosis, and mesenteric hypoperfusion)", "Kussmaul breathing (deep, rapid, sighing, labored respirations attempting respiratory compensation to blow off volatile carbonic acid CO2)", "Distinctive 'fruity / sweet / acetone' breath odor", "Signs of profound dehydration: Sunken eyes, dry mucous membranes, poor skin turgor, orthostatic hypotension, and weak thready pulse", "Progressive lethargy, somnolence, and obtundation (uncontrolled DKA progressing toward coma)"),
                Arrays.asList("AMERICAN DIABETES ASSOCIATION (ADA) DIAGNOSTIC CRITERIA FOR DKA:", "(1) Hyperglycemia: Blood Glucose > 250 mg/dL (13.9 mmol/L) or known diabetes history with 'Euglycemic DKA' (glucose < 250 mg/dL, seen with SGLT2 inhibitors or pregnancy);", "(2) Metabolic Acidosis: Arterial pH < 7.30 (Mild: 7.25-7.30, Moderate: 7.00-7.24, Severe: < 7.00) AND Serum Bicarbonate < 18 mEq/L (Mild: 15-18, Moderate: 10-14, Severe: < 10 mEq/L);", "(3) High Anion Gap: Serum Anion Gap = [Na+] - ([Cl-] + [HCO3-]) > 10-12 mEq/L (typically 16-25+ mEq/L);", "(4) Ketonemia / Ketonuria: Positive serum Beta-Hydroxybutyrate (>= 3.0 mmol/L - gold standard quantitative measurement; urine nitroprusside dipstick detects acetoacetate only and may underestimate severity)"),
                Arrays.asList("Serum Beta-Hydroxybutyrate (elevated >= 3.0 to 10+ mmol/L)", "Arterial Blood Gas (ABG): Low pH (< 7.30), Low PaCO2 (< 30-35 mmHg due to compensatory hyperventilation), Low HCO3- (< 15-18 mEq/L)", "Serum Electrolytes & Corrected Sodium: Measured Na+ is artifactually lowered by hyperglycemia (Pseudohyponatremia); Corrected Sodium = Measured Na + [1.6 x (Glucose - 100) / 100] or 2.0 multiplier for glucose > 400 mg/dL", "Serum Potassium: Measured K+ may be elevated or normal initially due to transcellular shift (insulin deficiency and acidemia drive K+ out of cells), despite a massive TOTAL BODY POTASSIUM DEFICIT (3-5 mEq/kg); initiating insulin will cause rapid intracellular potassium influx and life-threatening hypokalemia if not monitored", "Serum Creatinine and BUN (prerenal azotemia with elevated BUN/Cr ratio)", "Serum Osmolality: Effective Serum Osmolality = 2 x [Na+] + [Glucose / 18] (typically 295-320 mOsm/kg in DKA vs > 320 in HHS)", "Complete Blood Count: Leukocytosis (15,000-25,000/uL is common due to stress demargination and hyperketonemia, even without bacterial infection)", "Urinalysis and Urine/Blood Cultures (screen for precipitating infection: UTI, pneumonia, sepsis)", "Cardiac Troponin and ECG (screen for painless silent myocardial infarction as DKA precipitant)"),
                Arrays.asList("ADA Severity Staging:", "- MILD DKA: Arterial pH 7.25-7.30, HCO3- 15-18 mEq/L, Anion gap > 10, Alert mental status;", "- MODERATE DKA: Arterial pH 7.00-7.24, HCO3- 10-14 mEq/L, Anion gap > 12, Alert/Drowsy mental status;", "- SEVERE DKA: Arterial pH < 7.00, HCO3- < 10 mEq/L, Anion gap > 12, Stupor/Coma;", "Two-Bag Intravenous Infusion Algorithm (Titration of fluid tonicity and dextrose concentration based on hourly bedside glucose)"),
                Arrays.asList("Hyperosmolar Hyperglycemic State (HHS: Glucose > 600 mg/dL, Osmolality > 320 mOsm/kg, pH > 7.30, Bicarbonate > 18 mEq/L, minimal/absent ketones)", "Euglycemic DKA (Glucose < 250 mg/dL in patients on SGLT2 inhibitors like Empagliflozin/Dapagliflozin, pregnancy, or prolonged starvation)", "Alcoholic Ketoacidosis (AKA: History of chronic alcohol binge followed by starvation and vomiting; Glucose normal or low, high Beta-OHB/Acetoacetate ratio)", "Starvation Ketosis (mild acidosis with HCO3- rarely < 18 mEq/L, glucose normal/low)", "Lactic Acidosis (Type A hypoxic or Type B non-hypoxic/Metformin-associated; Lactate > 4.0-5.0 mmol/L)", "Toxic Ingestions (Methanol, Ethylene Glycol, Salicylates - elevated anion gap and osmolar gap)"),
                Arrays.asList("FOUR-PILLAR INTENSIVE CARE RESUSCITATION PROTOCOL:", "(1) FLUID RESUSCITATION (Correcting 5-7L deficit):", "- Hour 1: Isotonic 0.9% Normal Saline (1000-1500 mL/hr or 15-20 mL/kg/hr IV bolus) to restore intravascular volume and renal perfusion;", "- Hours 2-12: If Corrected Sodium is Normal/High (>= 135 mEq/L), switch to 0.45% Half-Normal Saline (250-500 mL/hr); if Corrected Sodium is Low (< 135 mEq/L), continue 0.9% Normal Saline (250-500 mL/hr);", "- When Blood Glucose reaches 200-250 mg/dL: ADD 5% DEXTROSE with 0.45% Saline (D5 0.45% NS at 150-250 mL/hr) to maintain blood glucose between 150-200 mg/dL while continuing insulin infusion to clear ketoacidosis without causing hypoglycemia or cerebral edema;", "(2) POTASSIUM REPLACEMENT (MANDATORY BEFORE OR CONCURRENT WITH INSULIN):", "- If K+ < 3.3 mEq/L: HOLD INSULIN; administer IV Potassium Chloride (20-40 mEq/hr) until K+ > 3.3 mEq/L to prevent fatal cardiac arrhythmias and respiratory arrest;", "- If K+ 3.3 to 5.2 mEq/L: Start Insulin AND add 20-30 mEq KCl per liter of IV fluid (maintain K+ 4.0-5.0 mEq/L);", "- If K+ > 5.2 mEq/L: Do not give potassium; re-check serum K+ q2h;", "(3) INTRAVENOUS INSULIN THERAPY:", "- Regular Insulin IV continuous infusion: 0.1 units/kg IV bolus followed by 0.1 units/kg/hour continuous infusion (OR 0.14 units/kg/hr continuous infusion without bolus);", "- Target rate of glucose decline: 50-75 mg/dL per hour; if glucose does not drop by >= 50 mg/dL in first hour, double the insulin infusion rate;", "- When glucose reaches 200 mg/dL: Reduce insulin rate to 0.02-0.05 units/kg/hr while infusing D5W, maintaining glucose 150-200 mg/dL until resolution of ketoacidosis;", "(4) SODIUM BICARBONATE (STRICTLY RESTRICTED):", "- NOT recommended for pH >= 6.90 (causes paradoxical CSF acidosis, hypokalemia, delayed ketosis clearance);", "- ONLY indicated for SEVERE LIFE-THREATENING ACIDOSIS (Arterial pH < 6.90): 100 mmol Sodium Bicarbonate in 400 mL sterile water with 20 mEq KCl infused over 2 hours; repeat q2h until pH >= 7.00"),
                Arrays.asList("CRITERIA FOR RESOLUTION OF DKA (ALL MUST BE MET BEFORE TRANSITIONING TO SUBCUTANEOUS INSULIN):", "(1) Blood Glucose < 200 mg/dL;", "(2) Serum Bicarbonate >= 18 mEq/L;", "(3) Venous pH > 7.30;", "(4) Normalization of Serum Anion Gap (<= 12 mEq/L);", "(5) Patient able to tolerate oral nutrition;", "SUBCUTANEOUS INSULIN TRANSITION PROTOCOL:", "- Administer Subcutaneous Basal Insulin (e.g. Insulin Glargine or Degludec weight-based 0.2-0.3 units/kg) AT LEAST 2 HOURS PRIOR TO DISCONTINUING IV INSULIN INFUSION (prevents rebound ketoacidosis and hyperglycemia due to the 5-minute half-life of IV insulin);", "- Resume Basal-Bolus MDI (Multiple Daily Injections: 50% Basal Glargine + 50% Prandial Lispro/Aspart divided before 3 meals) or Insulin Pump therapy"),
                "Overall mortality in DKA is < 1% in specialized centers, but rises to > 5% in elderly patients with severe precipitating illness (sepsis, acute myocardial infarction). Major life-threatening complications: (1) CEREBRAL EDEMA (Occurs primarily in children/young adults in 0.5-1% of DKA; mortality 20-40%; caused by rapid osmolality reduction; warning signs: headache, lethargy, bradycardia, hypertension - treat immediately with IV Mannitol 0.5-1.0 g/kg or 3% Hypertonic Saline 5 mL/kg without waiting for CT brain); (2) Severe Hypokalemia with cardiac arrhythmias (VT/VF/Asystole); (3) Acute Respiratory Distress Syndrome (ARDS) / Pulmonary Edema due to aggressive fluid overload; (4) Acute Tubular Necrosis (ATN) and AKI; (5) Mucormycosis (Rhizopus oryzae fungal infection of paranasal sinuses and brain in ketoacidosis).");

        add("E05.01", "Thyrotoxicosis with Diffuse Goiter with Thyrotoxic Crisis or Storm", "Thyroid Disorders",
                "Extreme, life-threatening exacerbation of hyperthyroidism characterized by decompensation of one or more organ systems (thermoregulatory, central nervous, cardiovascular, gastrointestinal-hepatic). Pathophysiology involves sudden massive release of free thyroid hormones (Free T3 and Free T4) into circulation or heightened end-organ responsiveness to catecholamines due to dramatic upregulation of beta-adrenergic receptors and post-receptor signaling pathways. Triggered by acute precipitating events in an untreated or poorly controlled thyrotoxic patient: Systemic infection/sepsis, thyroid surgery, non-thyroid surgery, radioiodine (RAI) therapy, abrupt withdrawal of antithyroid medications, iodinated contrast administration (Jod-Basedow phenomenon), diabetic ketoacidosis, trauma, or parturition.",
                Arrays.asList("Severe Hyperpyrexia / Malignant Fever (Body Temperature 38.5°C to 41.0°C [101°F - 106°F]) with profuse drenching diaphoresis", "Marked Tachycardia out of proportion to fever (Heart Rate 140-180+ bpm), Atrial Fibrillation with Rapid Ventricular Response, or high-output congestive heart failure (pulmonary edema, elevated JVP)", "Profound Central Nervous System Dysfunction: Severe agitation, anxiety, delirium, acute psychosis, confusion, tremors, seizure activity, progressing to stupor and coma", "Gastrointestinal and Hepatic Dysfunction: Severe nausea, intractable vomiting, profuse watery diarrhea, severe abdominal pain, and jaundice (elevated bilirubin indicating hepatic failure and poor prognosis)", "Physical signs of Graves' Disease: Diffuse smooth vascular goiter with audible systolic bruit, Graves' Ophthalmopathy (exophthalmos, proptosis, periorbital edema, lid lag), and Pretibial Myxedema"),
                Arrays.asList("BURCH-WARTOFSKY POINT SCALE (BWPS) FOR THYROTOXIC CRISIS (Score >= 45 = Highly suggestive of Thyroid Storm; 25-44 = Impending Storm; < 25 = Storm unlikely):", "- Thermoregulatory dysfunction (Temperature 37.2-37.7°C = 5, 37.8-38.2°C = 10, 38.3-38.8°C = 15, 38.9-39.4°C = 20, 39.5-39.9°C = 25, >= 40.0°C = 30 pts);", "- CNS effects (Mild agitation = 10, Moderate delirium/psychosis = 20, Severe seizure/coma = 30 pts);", "- Gastrointestinal-hepatic (Diarrhea/nausea/vomiting/pain = 10, Severe unexplained jaundice = 20 pts);", "- Cardiovascular dysfunction (Tachycardia 90-109 = 5, 110-119 = 10, 120-129 = 15, 130-139 = 20, >= 140 bpm = 25 pts; Atrial Fibrillation = 10 pts; Heart Failure Mild = 5, Moderate = 10, Severe = 15 pts);", "- Precipitating history (Identified trigger present = 10 pts);", "Akamizu Diagnostic Criteria for Thyroid Storm (Japan Thyroid Association: Combination of Thyrotoxicosis + at least 1 CNS manifestation + at least 1 of: fever >= 38°C, tachycardia >= 130 bpm, CHF, or GI/hepatic dysfunction)"),
                Arrays.asList("Thyroid Function Tests (TFTs): Undetectable Thyroid-Stimulating Hormone (TSH < 0.01 mIU/L), Markedly elevated Free Thyroxine (Free T4) and Free Triiodothyronine (Free T3); Note: Hormone levels do NOT correlate with severity of thyroid storm vs uncomplicated thyrotoxicosis", "TSH Receptor Antibodies (TRAb) / Thyroid-Stimulating Immunoglobulin (TSI positive in Graves' disease)", "Liver Function Tests: Marked elevation of Total Bilirubin, AST, ALT, and Alkaline Phosphatase (congestive hepatopathy and direct thyrotoxic hepatic injury)", "Complete Blood Count: Leukocytosis with left shift", "Serum Electrolytes: Hypercalcemia (due to increased thyroid hormone-mediated bone resorption) and Hypokalemia", "Fasting Blood Glucose: Hyperglycemia (increased glycogenolysis and insulin resistance)"),
                Arrays.asList("Sinus tachycardia (140-180 bpm)", "Atrial Fibrillation with Rapid Ventricular Response (in 20-30% of cases)", "Atrial Flutter", "Premature ventricular contractions (PVCs) and non-sustained VT", "High QRS voltage indicating left ventricular hypertrophy and high-output state"),
                Arrays.asList("Sepsis / Septic Shock (can coexist and trigger thyroid storm)", "Malignant Hyperthermia (history of volatile inhalational anesthetics or succinylcholine exposure)", "Neuroleptic Malignant Syndrome (NMS - history of antipsychotics, lead-pipe rigidity, elevated CK)", "Serotonin Syndrome (history of SSRIs/SNRIs, hyperreflexia, clonus)", "Pheochromocytoma Crisis (elevated plasma metanephrines, severe paroxysmal hypertension)", "Acute Heat Stroke", "Delirium Tremens (alcohol withdrawal)"),
                Arrays.asList("FIVE-STEP EMERGENCY MEDICAL MULTI-TARGET PHARMACOTHERAPY PROTOCOL:", "(1) BLOCK THYROID HORMONE SYNTHESIS (Thionamides):", "- PROPYLTHIOURACIL (PTU is preferred over Methimazole in thyroid storm due to additional inhibition of peripheral T4-to-T3 conversion): Loading dose 500-1000 mg PO/NG/PR, followed by 200-250 mg q4h; OR METHIMAZOLE (60-80 mg daily divided q6-8h) if PTU unavailable;", "(2) BLOCK THYROID HORMONE RELEASE (Inorganic Iodine):", "- MANDATORY: Administer Iodine AT LEAST 1 HOUR AFTER THIONAMIDE (Giving iodine before thionamide provides substrate for new hormone synthesis, worsening thyrotoxicosis - Wolff-Chaikoff effect):", "- Saturated Solution of Potassium Iodide (SSKI: 5 drops PO q6h) OR Lugol's Solution (8-10 drops PO q8h) OR Potassium Iodide tablets;", "(3) BLOCK PERIPHERAL ACTIONS OF THYROID HORMONES (Beta-Adrenergic Blockers):", "- PROPRANOLOL (Non-selective beta-blocker that ALSO inhibits peripheral 5'-deiodinase, blocking T4 to active T3 conversion): 60-80 mg PO q4-6h, OR IV Propranolol 1-2 mg slow IV push q15min up to 5-10 mg; in patients with asthma/severe HFrEF, use ultra-short-acting ESMOLOL infusion (50-300 mcg/kg/min) under continuous ICU monitoring;", "(4) INHIBIT PERIPHERAL T4-TO-T3 CONVERSION & PREVENT ADRENAL INSUFFICIENCY (Corticosteroids):", "- Intravenous Hydrocortisone (100 mg IV q8h) OR Dexamethasone (2 mg IV q6h) - blocks T4-to-T3 conversion and treats relative adrenal exhaustion due to accelerated cortisol clearance in severe thyrotoxicosis;", "(5) AGGRESSIVE SYSTEMIC SUPPORT & COOLING:", "- Antipyresis: Acetaminophen (500-1000 mg q6h) + external cooling blankets/ice packs; AVOID ASPIRIN / SALICYLATES (Aspirin displaces T4/T3 from thyroid-binding globulin TBG, drastically increasing free active hormone levels);", "- Bile Acid Sequestrants: Cholestyramine (4 grams PO qid - binds thyroid hormones in the intestinal lumen, interrupting enterohepatic circulation and accelerating hormone excretion)"),
                Arrays.asList("Therapeutic Plasma Exchange (Plasmapheresis): Highly effective rescue therapy for patients refractory to medical management or with severe thionamide-induced hepatotoxicity/agranulocytosis (removes antibody-bound and free thyroid hormones)", "Definitive Thyroid Ablation (once patient is rendered euthyroid and medically stabilized): Total Thyroidectomy or Radioactive Iodine Ablation (131-I)"),
                "High in-hospital mortality rate (10-25%), even with modern intensive care management. Leading causes of death are multi-organ failure, refractory high-output or low-output heart failure, lethal cardiac arrhythmias (VF/asystole), hyperpyrexic encephalopathy, and sepsis. Following storm resolution, patients must remain on maintenance antithyroid medications (Methimazole 10-30 mg daily) with definitive surgical thyroidectomy or radioiodine ablation planned.");
    }

    private static void add(String code, String name, String cat, String patho,
                            List<String> clin, List<String> diag, List<String> labs,
                            List<String> scor, List<String> diff, List<String> rx,
                            List<String> main, String comp) {
        ENTRIES.add(EndocrineDiseaseEntry.builder()
                .icd10Code(code)
                .diseaseName(name)
                .category(cat)
                .pathophysiology(patho)
                .clinicalPresentation(clin)
                .diagnosticCriteria(diag)
                .laboratoryProfile(labs)
                .diagnosticScoringAndAlgorithms(scor)
                .differentialDiagnoses(diff)
                .emergencyPharmacotherapyProtocol(rx)
                .maintenancePharmacotherapy(main)
                .complicationsAndPrognosis(comp)
                .build());
    }

    public List<EndocrineDiseaseEntry> search(String query) {
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

    public Optional<EndocrineDiseaseEntry> findByCode(String code) {
        return ENTRIES.stream()
                .filter(e -> e.getIcd10Code().equalsIgnoreCase(code))
                .findFirst();
    }
}
