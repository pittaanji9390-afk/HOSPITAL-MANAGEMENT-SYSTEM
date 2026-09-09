package com.hospital.clinical.knowledge;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise ICD-10-CM Clinical Knowledge Base & Diagnostic Reference Encyclopedia.
 * Contains evidence-based diagnostic criteria, pathophysiology, clinical presentations,
 * and management guidelines across international clinical chapters.
 */
@Component
public class Icd10ClinicalEncyclopedia {

    @Data
    @Builder
    public static class ClinicalDiseaseEntry {
        private String icd10Code;
        private String diseaseName;
        private String chapter;
        private String organSystem;
        private String pathophysiology;
        private List<String> commonPresentingSymptoms;
        private List<String> diagnosticCriteria;
        private List<String> firstLinePharmacotherapy;
        private List<String> differentialDiagnoses;
        private String prognosisAndComplications;
        private boolean chronicCondition;
        private boolean notifiableDisease;
    }

    private static final List<ClinicalDiseaseEntry> ENCYCLOPEDIA = new ArrayList<>();

    static {
        // ==========================================
        // CHAPTER IX: DISEASES OF THE CIRCULATORY SYSTEM (I00-I99)
        // ==========================================
        add("I10", "Essential (Primary) Hypertension", "Circulatory System", "Cardiovascular / Vascular",
                "Multifactorial disorder characterized by chronic elevation of systemic arterial blood pressure due to increased systemic vascular resistance, arterial stiffness, and renal sodium retention.",
                Arrays.asList("Often asymptomatic ('silent killer')", "Occipital early morning headache", "Dizziness", "Epistaxis", "Blurred vision"),
                Arrays.asList("Systolic BP >= 130 mmHg and/or Diastolic BP >= 80 mmHg on at least 2 separate clinical visits", "Ambulatory Blood Pressure Monitoring (ABPM) confirmation", "Fundoscopy for hypertensive retinopathy", "ECG for left ventricular hypertrophy (LVH)"),
                Arrays.asList("Angiotensin Receptor Blockers (Telmisartan 40-80mg daily)", "ACE Inhibitors (Ramipril 2.5-10mg daily)", "Calcium Channel Blockers (Amlodipine 5-10mg daily)", "Thiazide-like diuretics (Chlorthalidone 12.5-25mg daily)"),
                Arrays.asList("Renal artery stenosis", "Primary hyperaldosteronism (Conn syndrome)", "Pheochromocytoma", "Cushing syndrome", "Coarctation of aorta"),
                "Prognosis is excellent with strict BP control (< 130/80). Complications include stroke, myocardial infarction, heart failure, chronic kidney disease, and hypertensive retinopathy.",
                true, false);

        add("I20.0", "Unstable Angina Pectoris", "Circulatory System", "Cardiovascular / Coronary",
                "Acute coronary syndrome resulting from transient, non-occlusive thrombus formation over an ulcerated atherosclerotic plaque causing acute myocardial ischemia without myocyte necrosis.",
                Arrays.asList("Crescendo retrosternal chest pain occurring at rest", "Pain lasting > 20 minutes", "Radiation to left shoulder, arm, neck, or jaw", "Diaphoresis", "Nausea"),
                Arrays.asList("Ischemic chest pain symptoms at rest", "Transient ST depression or T-wave inversion on 12-lead ECG", "Absence of cardiac biomarker elevation (Negative high-sensitivity Troponin I/T)"),
                Arrays.asList("Dual Antiplatelet Therapy (Aspirin 325mg chewed + Ticagrelor 180mg)", "Anticoagulation (Enoxaparin 1mg/kg SubQ q12h or Fondaparinux 2.5mg SubQ daily)", "High-intensity statin (Atorvastatin 80mg daily)", "Sublingual Nitroglycerin 0.4mg PRN", "Beta-blocker (Metoprolol tartrate)"),
                Arrays.asList("NSTEMI (Differentiated by positive troponin)", "Aortic dissection", "Acute pericarditis", "Gastroesophageal reflux disease (GERD)", "Costochondritis"),
                "High risk of progression to acute myocardial infarction within 30 days without medical therapy and early invasive coronary angiography.",
                true, false);

        add("I21.0", "ST-Elevation Myocardial Infarction (STEMI) of Anterior Wall", "Circulatory System", "Cardiovascular / Coronary",
                "Complete thrombotic occlusion of the Left Anterior Descending (LAD) coronary artery resulting in transmural myocardial ischemia and necrosis of the anterior wall of the left ventricle and interventricular septum.",
                Arrays.asList("Crushing, squeezing retrosternal chest pain", "Radiation to left arm and jaw", "Severe diaphoresis", "Dyspnea", "Impending sense of doom", "Vomiting"),
                Arrays.asList("ST-segment elevation >= 1 mm in >= 2 contiguous precordial leads (V1-V4)", "New Left Bundle Branch Block (LBBB)", "Elevated high-sensitivity cardiac troponin I (> 0.04 ng/mL)", "Transthoracic Echocardiogram showing anterior wall hypokinesia/akinesia"),
                Arrays.asList("Emergency Primary Percutaneous Coronary Intervention (PCI) within 90 minutes", "Aspirin 325mg PO chewed + Ticagrelor 180mg PO loading", "Unfractionated Heparin 60 U/kg IV bolus", "Atorvastatin 80mg PO", "Supplemental O2 if SpO2 < 90%"),
                Arrays.asList("Acute Pericarditis", "Aortic Dissection (Stanford Type A)", "Pulmonary Embolism", "Takotsubo Cardiomyopathy", "Esophageal Spasm"),
                "Early revascularization reduces mortality to < 5%. Complications include cardiogenic shock, ventricular fibrillation, ventricular free wall rupture, and post-infarction heart failure.",
                false, false);

        add("I21.1", "ST-Elevation Myocardial Infarction (STEMI) of Inferior Wall", "Circulatory System", "Cardiovascular / Coronary",
                "Thrombotic occlusion of the Right Coronary Artery (RCA) or dominant Left Circumflex (LCx), causing transmural ischemia of the diaphragmatic/inferior myocardium, often associated with Right Ventricular infarction and AV nodal conduction blocks.",
                Arrays.asList("Retrosternal chest tightness radiating to epigastrium", "Profound nausea and vomiting (vagal irritation)", "Hiccups", "Dizziness", "Syncope or bradycardia"),
                Arrays.asList("ST-segment elevation >= 1 mm in inferior leads II, III, and aVF", "ST depression in reciprocal leads I and aVL", "Right-sided ECG (V4R) elevation indicating RV infarction", "Elevated high-sensitivity Troponin I"),
                Arrays.asList("Primary PCI of RCA", "Dual Antiplatelet Therapy (Aspirin + Prasugrel/Ticagrelor)", "Aggressive IV normal saline hydration if RV infarction present (PRELOAD DEPENDENT - AVOID NITRATES/DIURETICS)", "Atropine 0.5-1.0mg IV for symptomatic sinus bradycardia/AV block"),
                Arrays.asList("Acute cholecystitis", "Peptic ulcer perforation", "Acute pancreatitis", "Inferior wall ischemia without infarction"),
                "Generally better survival than anterior STEMI, but carries significant risk of complete heart block and hypotension if RV is involved.",
                false, false);

        add("I48.0", "Paroxysmal Atrial Fibrillation", "Circulatory System", "Cardiovascular / Electrophysiology",
                "Supraventricular tachyarrhythmia characterized by uncoordinated atrial activation and irregular ventricular response that terminates spontaneously or with intervention within 7 days.",
                Arrays.asList("Rapid irregular palpitations", "Fatigue and exercise intolerance", "Lightheadedness", "Shortness of breath", "Polyuria (due to atrial natriuretic peptide release)"),
                Arrays.asList("12-Lead ECG demonstrating irregularly irregular R-R intervals and absence of distinct P-waves", "24-48 hour Holter ambulatory monitoring", "Echocardiogram assessing left atrial size and LVEF"),
                Arrays.asList("Rate control: Beta-blockers (Metoprolol Succinate 50-100mg) or Non-DHP CCB (Diltiazem)", "Anticoagulation based on CHA2DS2-VASc score (Apixaban 5mg BID or Rivaroxaban 20mg daily)", "Rhythm control: Amiodarone or Flecainide in selected patients"),
                Arrays.asList("Atrial Flutter with variable block", "Multifocal Atrial Tachycardia (MAT)", "Sinus tachycardia with frequent PACs", "Ventricular Tachycardia"),
                "Increased long-term risk of thromboembolic ischemic stroke (5-fold) and heart failure. Stroke risk effectively mitigated with DOAC anticoagulation.",
                true, false);

        add("I50.22", "Chronic Systolic (Heart Failure with Reduced Ejection Fraction - HFrEF)", "Circulatory System", "Cardiovascular / Myocardial",
                "Clinical syndrome caused by impaired myocardial contractility resulting in left ventricular ejection fraction (LVEF) <= 40%, elevated cardiac filling pressures, and inadequate systemic perfusion.",
                Arrays.asList("Progressive dyspnea on exertion", "Orthopnea (requiring multiple pillows)", "Paroxysmal nocturnal dyspnea (PND)", "Bilateral pedal edema", "Fatigue", "Abdominal fullness due to hepatic congestion"),
                Arrays.asList("Transthoracic Echocardiogram demonstrating LVEF <= 40% with LV dilation", "Elevated NT-proBNP (> 300 pg/mL in acute, > 125 pg/mL in chronic)", "Chest X-ray showing cardiomegaly, cephalization of pulmonary vessels, and Kerley B lines"),
                Arrays.asList("Guideline-Directed Medical Therapy (GDMT - 4 Pillars):", "1. ARNI (Sacubitril/Valsartan 24/26mg BID up to 97/103mg BID)", "2. Beta-Blocker (Bisoprolol, Carvedilol, or Metoprolol Succinate)", "3. MRA (Spironolactone 25mg daily)", "4. SGLT2 Inhibitor (Dapagliflozin 10mg or Empagliflozin 10mg daily)", "Loop diuretics (Furosemide) for volume congestion"),
                Arrays.asList("Heart failure with preserved ejection fraction (HFpEF)", "Chronic kidney disease with volume overload", "Cirrhosis with ascites", "Severe COPD exacerbation"),
                "5-year mortality is approximately 50% without GDMT. Quadruple GDMT therapy significantly reduces cardiovascular mortality and hospital readmissions.",
                true, false);

        // ==========================================
        // CHAPTER IV: ENDOCRINE, NUTRITIONAL AND METABOLIC DISEASES (E00-E89)
        // ==========================================
        add("E10.9", "Type 1 Diabetes Mellitus without Complications", "Endocrine", "Pancreas / Metabolism",
                "Autoimmune destruction of insulin-producing pancreatic beta-cells in the islets of Langerhans, leading to absolute insulin deficiency and dependence on exogenous insulin.",
                Arrays.asList("Polyuria (excessive urination)", "Polydipsia (excessive thirst)", "Polyphagia (increased appetite)", "Unexplained rapid weight loss", "Fatigue", "Nocturnal enuresis in children"),
                Arrays.asList("Fasting plasma glucose >= 126 mg/dL (7.0 mmol/L)", "HbA1c >= 6.5%", "Positive autoantibodies: Anti-GAD65, Anti-IA-2, Anti-ZnT8, and Islet Cell Antibodies (ICA)", "Low or undetectable fasting C-peptide (< 0.2 nmol/L)"),
                Arrays.asList("Basal-Bolus Insulin Regimen: Long-acting basal (Insulin Glargine / Degludec once daily) + Rapid-acting prandial (Insulin Aspart / Lispro before meals)", "Continuous Glucose Monitoring (CGM)", "Carbohydrate counting and meal-matching insulin dosing"),
                Arrays.asList("Type 2 Diabetes Mellitus", "Latent Autoimmune Diabetes in Adults (LADA)", "Maturity-Onset Diabetes of the Young (MODY)", "Secondary diabetes due to chronic pancreatitis"),
                "Requires lifelong insulin therapy. Strict glycemic control (HbA1c < 7.0%) prevents long-term microvascular complications (retinopathy, nephropathy, neuropathy).",
                true, false);

        add("E11.65", "Type 2 Diabetes Mellitus with Hyperglycemia", "Endocrine", "Pancreas / Metabolism",
                "Metabolic disorder characterized by progressive peripheral insulin resistance coupled with relative pancreatic beta-cell secretory defect, hepatic glucose overproduction, and incretin dysfunction.",
                Arrays.asList("Often asymptomatic for years", "Fatigue", "Frequent skin and genitourinary fungal infections (Candida)", "Blurred vision", "Paresthesias in lower extremities", "Acanthosis nigricans"),
                Arrays.asList("Fasting plasma glucose >= 126 mg/dL on 2 occasions", "HbA1c >= 6.5%", "2-hour plasma glucose >= 200 mg/dL during 75g OGTT", "Random blood glucose >= 200 mg/dL with classic symptoms"),
                Arrays.asList("First-line: Metformin 500-1000mg BID (if eGFR >= 30 mL/min)", "SGLT2 inhibitors (Empagliflozin 10-25mg daily) for cardio-renal protection", "GLP-1 receptor agonists (Semaglutide / Dulaglutide) for weight loss and cardiovascular reduction", "DPP-4 inhibitors (Sitagliptin 100mg daily)", "Basal insulin if HbA1c > 10%"),
                Arrays.asList("Type 1 Diabetes Mellitus", "Cushing Syndrome", "Hemochromatosis (Bronze diabetes)", "Drug-induced hyperglycemia (Corticosteroids, Atypical antipsychotics)"),
                "High lifetime risk of macrovascular events (ASCVD, stroke, peripheral arterial disease) and microvascular disease (diabetic nephropathy, proliferative retinopathy).",
                true, false);

        add("E03.9", "Hypothyroidism, Unspecified", "Endocrine", "Thyroid",
                "Deficiency of thyroid hormones (Thyroxine T4 and Triiodothyronine T3) leading to generalized slowing of metabolic processes, most commonly due to autoimmune Hashimoto thyroiditis.",
                Arrays.asList("Cold intolerance", "Weight gain despite poor appetite", "Constipation", "Chronic lethargy and fatigue", "Dry skin and brittle hair", "Depression and memory impairment", "Menorrhagia"),
                Arrays.asList("Elevated serum Thyroid-Stimulating Hormone (TSH > 4.5 mIU/L)", "Decreased free T4 (FT4 < 0.8 ng/dL)", "Elevated Anti-Thyroperoxidase (Anti-TPO) antibodies in autoimmune thyroiditis"),
                Arrays.asList("Levothyroxine Sodium (T4) oral replacement (1.6 mcg/kg/day for adults, 25-50 mcg in elderly/cardiac disease)", "Administer on empty stomach with water 30-60 minutes before breakfast", "Recheck TSH after 6-8 weeks for dose titration"),
                Arrays.asList("Major Depressive Disorder", "Chronic Fatigue Syndrome", "Euthyroid Sick Syndrome", "Severe iron deficiency anemia", "Nephrotic syndrome"),
                "Prognosis is normal with adequate hormone replacement. Untreated severe hypothyroidism can progress to life-threatening Myxedema Coma.",
                true, false);

        // ==========================================
        // CHAPTER X: DISEASES OF THE RESPIRATORY SYSTEM (J00-J99)
        // ==========================================
        add("J45.909", "Unspecified Asthma, Uncomplicated", "Respiratory System", "Pulmonary / Airway",
                "Chronic inflammatory disorder of the conducting airways characterized by bronchial hyperresponsiveness, reversible airflow obstruction, and chronic airway remodeling driven by Th2 inflammatory cascade.",
                Arrays.asList("Recurrent wheezing", "Shortness of breath", "Chest tightness", "Nocturnal or early-morning dry cough", "Symptoms triggered by viral URI, exercise, allergens, or cold air"),
                Arrays.asList("Spirometry demonstrating airflow limitation (FEV1/FVC < 0.70) with significant bronchodilator reversibility (increase in FEV1 > 12% and > 200 mL post-albuterol)", "Fractional exhaled Nitric Oxide (FeNO > 25 ppb)", "Positive bronchial challenge test (Methacholine)"),
                Arrays.asList("GINA Track 1 Preferred: Inhaled Corticosteroid + Formoterol (Budesonide-Formoterol low dose) as both daily controller and symptom reliever", "Short-Acting Beta-2 Agonist (Albuterol/Salbutamol MDI) as rescue", "Leukotriene Receptor Antagonist (Montelukast 10mg PO nightly)", "Biologics (Dupilumab, Omalizumab) in severe eosinophilic asthma"),
                Arrays.asList("COPD", "Congestive Heart Failure ('Cardiac asthma')", "Vocal cord dysfunction (VCD)", "Foreign body aspiration", "Gastroesophageal reflux disease"),
                "Normal life expectancy and pulmonary function maintained with consistent inhaled corticosteroid adherence. Acute severe asthma (status asthmaticus) requires urgent systemic steroids.",
                true, false);

        add("J18.9", "Pneumonia, Unspecified Organism", "Respiratory System", "Pulmonary / Infectious",
                "Acute infection of the pulmonary parenchymal alveoli and interstitium resulting in alveolar exudate accumulation, consolidation, and ventilation-perfusion mismatch.",
                Arrays.asList("High fever with chills and rigors", "Productive cough with purulent or rust-colored sputum", "Pleuritic chest pain worsening on inspiration", "Dyspnea", "Tachypnea", "Confusion in elderly patients"),
                Arrays.asList("Chest Radiograph showing focal lobar consolidation, air bronchograms, or patchy interstitial opacities", "Elevated white blood cell count with left shift (bandemia)", "Elevated inflammatory markers (CRP, Procalcitonin)", "Blood and sputum cultures for pathogen identification", "CURB-65 / PSI risk stratification score"),
                Arrays.asList("Outpatient CAP: Amoxicillin-Clavulanate 1g PO BID + Azithromycin 500mg PO daily (or Doxycycline 100mg BID)", "Inpatient Non-ICU: Ceftriaxone 1-2g IV daily + Azithromycin 500mg IV daily", "Inpatient ICU: Ceftriaxone + Azithromycin + Vancomycin (if MRSA suspected) + Piperacillin-Tazobactam (if Pseudomonas suspected)"),
                Arrays.asList("Pulmonary Embolism with infarction", "Acute Bronchitis", "Aspiration pneumonitis", "Pulmonary edema", "Lung malignancy with post-obstructive atelectasis"),
                "Mortality ranges from < 1% in low-risk outpatients to > 30% in ICU-admitted septic shock patients. Complications include parapneumonic effusion, empyema, lung abscess, and ARDS.",
                false, false);

        // ==========================================
        // CHAPTER XI: DISEASES OF THE DIGESTIVE SYSTEM (K00-K95)
        // ==========================================
        add("K21.0", "Gastro-Esophageal Reflux Disease with Esophagitis", "Digestive System", "Upper GI",
                "Retrograde flow of acidic gastric contents across an incompetent lower esophageal sphincter (LES) into the distal esophagus, causing mucosal inflammation, erosions, and histological injury.",
                Arrays.asList("Retrosternal pyrosis (Heartburn)", "Acid regurgitation", "Dysphagia", "Odynophagia", "Water brash (hypersalivation)", "Chronic nocturnal cough and hoarseness"),
                Arrays.asList("Clinical diagnosis based on classic symptoms", "Upper Gastrointestinal Endoscopy (EGD) showing Los Angeles Grade A-D mucosal breaks", "24-hour ambulatory esophageal pH-impedance monitoring (DeMeester score > 14.72)", "Esophageal manometry to rule out motility disorders"),
                Arrays.asList("Proton Pump Inhibitors (Pantoprazole 40mg PO daily or Esomeprazole 40mg PO daily 30 min before breakfast)", "H2-receptor antagonists (Famotidine 20-40mg PO at bedtime)", "Alginate antacid suspensions for breakthrough symptoms", "Lifestyle: Weight reduction, head-of-bed elevation (6 inches), avoidance of late-night meals"),
                Arrays.asList("Coronary Artery Disease / Angina", "Eosinophilic Esophagitis", "Infectious Esophagitis (Candida, HSV, CMV)", "Achalasia", "Esophageal adenocarcinoma"),
                "High response rate to PPI therapy. Chronic unmanaged acid exposure may lead to peptic esophageal strictures, Barrett's esophagus (intestinal metaplasia), and esophageal adenocarcinoma.",
                true, false);

        add("K35.80", "Unspecified Acute Appendicitis", "Digestive System", "Lower GI / Surgical",
                "Acute inflammation and luminal obstruction of the vermiform appendix by a fecalith, lymphoid hyperplasia, or neoplasm, resulting in bacterial overgrowth, ischemic necrosis, and perforation risk.",
                Arrays.asList("Periumbilical dull pain migrating to the Right Lower Quadrant (McBurney's point)", "Anorexia ('hamburger sign')", "Nausea and vomiting following pain onset", "Low-grade fever", "Right iliac fossa rebound tenderness and guarding"),
                Arrays.asList("Positive physical signs: Rovsing sign, Psoas sign, Obturator sign", "Abdominal Contrast-Enhanced CT showing dilated appendix (> 6 mm outer diameter), appendiceal wall thickening, and periappendiceal fat stranding", "Alvarado Score >= 7 / AIR Score", "Elevated CRP and leukocytosis with neutrophilia"),
                Arrays.asList("Definitive: Emergency Laparoscopic Appendectomy", "Pre-operative IV broad-spectrum antibiotics (Ceftriaxone 1g + Metronidazole 500mg IV or Cefoxitin 2g IV)", "NPO status and IV isotonic fluid resuscitation", "Multimodal post-operative analgesia"),
                Arrays.asList("Acute mesenteric adenitis", "Meckel's diverticulitis", "Right ovarian torsion or ruptured corpus luteum cyst", "Ectopic pregnancy in females (Stat urine pregnancy test required)", "Right nephrolithiasis / ureteric colic"),
                "Excellent prognosis with timely surgical resection prior to perforation (< 1% mortality). Perforation increases intra-abdominal abscess and sepsis risks.",
                false, false);

        add("K80.00", "Calculus of Gallbladder with Acute Cholecystitis without Obstruction", "Digestive System", "Hepatobiliary / Surgical",
                "Acute chemical and secondary bacterial inflammation of the gallbladder wall caused by prolonged cystic duct impaction by a gallstone (cholelithiasis).",
                Arrays.asList("Severe, continuous Right Upper Quadrant (RUQ) and epigastric pain", "Radiation of pain to the right infrascapular region / shoulder", "Pain triggered 1 hour after a fatty meal", "Fever and chills", "Nausea and bilious vomiting"),
                Arrays.asList("Positive Murphy's sign (arrest of inspiration upon deep palpation of RUQ)", "Abdominal Ultrasound showing gallstones, gallbladder wall thickening > 3 mm, pericholecystic fluid, and sonographic Murphy sign", "Elevated WBC and mild transaminitis/hyperbilirubinemia"),
                Arrays.asList("Early Laparoscopic Cholecystectomy (preferred within 72 hours of symptom onset)", "IV isotonic hydration and bowel rest (NPO)", "IV Antibiotics: Ceftriaxone 1g IV daily + Metronidazole 500mg IV q8h", "NSAIDs (Ketorolac / Diclofenac) or opioid analgesics for visceral pain"),
                Arrays.asList("Acute Pancreatitis", "Perforated Peptic Ulcer", "Right Lower Lobe Pneumonia", "Acute Hepatitis", "Biliary Colic (transient < 6 hours pain)"),
                "Mortality < 1% in uncomplicated cases. Complications include gallbladder gangrene, empyema, perforation, biliary peritonitis, and cholecystoenteric fistula (gallstone ileus).",
                false, false);

        // ==========================================
        // CHAPTER XIV: DISEASES OF THE GENITOURINARY SYSTEM (N00-N99)
        // ==========================================
        add("N39.0", "Urinary Tract Infection, Site Not Specified", "Genitourinary", "Renal / Bladder",
                "Bacterial colonization and inflammation of the urothelium lining the urinary bladder (cystitis) or upper urinary tract, predominantly caused by uropathogenic Escherichia coli (UPEC).",
                Arrays.asList("Dysuria (burning sensation on micturition)", "Urinary frequency and urgency", "Suprapubic tenderness", "Turbid, foul-smelling urine", "Microscopic or macroscopic hematuria"),
                Arrays.asList("Clean-catch midstream urinalysis showing pyuria (WBC > 10/HPF), positive leukocyte esterase, and positive urine nitrites", "Urine microscopy for bacteriuria", "Urine culture demonstrating > 10^5 CFU/mL of a single uropathogen"),
                Arrays.asList("Nitrofurantoin monohydrate/macrocrystals 100mg PO BID for 5 days (Avoid if eGFR < 30)", "Fosfomycin trometamol 3g PO single dose", "Trimethoprim-Sulfamethoxazole (TMP-SMX 160/800mg) 1 DS Tab PO BID for 3 days (if local E. coli resistance < 20%)", "Oral hydration and urinary alkalinizers for symptomatic relief"),
                Arrays.asList("Acute Pyelonephritis (differentiated by flank pain and high fever)", "Bacterial Vaginitis / Candida vulvovaginitis", "Sexually Transmitted Infection (Chlamydia trachomatis, Neisseria gonorrhoeae)", "Interstitial Cystitis / Bladder Pain Syndrome", "Urethral syndrome"),
                "Rapid resolution within 48-72 hours of targeted antibiotic therapy. Recurrent UTIs in postmenopausal women benefit from topical vaginal estrogen therapy.",
                false, false);

        add("N17.9", "Acute Kidney Injury, Unspecified", "Genitourinary", "Renal / Nephrology",
                "Abrupt decline in renal filtration function occurring over hours to days, leading to the retention of nitrogenous waste products (urea and creatinine) and dysregulation of extracellular volume and electrolytes.",
                Arrays.asList("Oliguria (urine output < 0.5 mL/kg/hr for > 6 hours) or anuria", "Peripheral and periorbital edema", "Nausea, anorexia, and metallic taste (uremia)", "Encephalopathy and asterixis in severe cases", "Dyspnea due to pulmonary edema"),
                Arrays.asList("KDIGO Diagnostic Criteria: Rise in Serum Creatinine by >= 0.3 mg/dL within 48 hours OR >= 1.5 times baseline within 7 days OR urine volume < 0.5 mL/kg/hr for 6 hours", "Fractional Excretion of Sodium (FENa < 1% indicates prerenal, > 2% indicates ATN)", "Renal ultrasound assessing kidney size, echogenicity, and ruling out bilateral hydronephrosis"),
                Arrays.asList("Prerenal AKI: Discontinue nephrotoxic agents (NSAIDs, ACEi/ARBs, Aminoglycosides), restore volume with IV balanced crystalloids", "Intrinsic AKI: Supportive care, avoid nephrotoxins, manage hyperkalemia and acidosis", "Postrenal AKI: Urgent urinary decompression (Foley catheterization, bilateral nephrostomy tubes)", "Renal Replacement Therapy (Hemodialysis) for AEIOU indications (Acidosis, Electrolytes, Ingestion, Overload, Uremia)"),
                Arrays.asList("Chronic Kidney Disease (look for small shrunken kidneys on USG and long-standing elevated creatinine)", "Prerenal azotemia vs Acute Tubular Necrosis (ATN)", "Acute Interstitial Nephritis (AIN - eosinophiluria, rash, fever)", "Acute Glomerulonephritis"),
                "High potential for complete recovery if underlying etiology is reversed early. Chronic transition to CKD occurs in severe or repeated ischemic/toxic ATN insults.",
                false, false);
    }

    private static void add(String code, String name, String ch, String sys, String patho,
                            List<String> symp, List<String> diag, List<String> rx, List<String> diff,
                            String prog, boolean chronic, boolean notifiable) {
        ENCYCLOPEDIA.add(ClinicalDiseaseEntry.builder()
                .icd10Code(code)
                .diseaseName(name)
                .chapter(ch)
                .organSystem(sys)
                .pathophysiology(patho)
                .commonPresentingSymptoms(symp)
                .diagnosticCriteria(diag)
                .firstLinePharmacotherapy(rx)
                .differentialDiagnoses(diff)
                .prognosisAndComplications(prog)
                .chronicCondition(chronic)
                .notifiableDisease(notifiable)
                .build());
    }

    public List<ClinicalDiseaseEntry> search(String query) {
        if (query == null || query.isBlank()) {
            return ENCYCLOPEDIA;
        }
        String q = query.toLowerCase().trim();
        return ENCYCLOPEDIA.stream()
                .filter(e -> e.getIcd10Code().toLowerCase().contains(q) ||
                             e.getDiseaseName().toLowerCase().contains(q) ||
                             e.getChapter().toLowerCase().contains(q) ||
                             e.getOrganSystem().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }

    public Optional<ClinicalDiseaseEntry> findByCode(String code) {
        return ENCYCLOPEDIA.stream()
                .filter(e -> e.getIcd10Code().equalsIgnoreCase(code))
                .findFirst();
    }
}
