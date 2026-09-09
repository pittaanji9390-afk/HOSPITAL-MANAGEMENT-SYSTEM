package com.hospital.clinical.encyclopedia;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise ICD-10-CM Gastrointestinal, Pancreatobiliary & Hepatology Clinical Encyclopedia (Chapter XI: K00-K95).
 * Comprehensive clinical monographs for Peptic Ulcer Disease, Acute Pancreatitis (Atlanta criteria),
 * Acute Appendicitis, Cholecystitis, Liver Cirrhosis (Child-Pugh / MELD-Na), and GI Bleeding.
 */
@Component
public class Icd10GastrointestinalEncyclopedia {

    @Data
    @Builder
    public static class GastroDiseaseEntry {
        private String icd10Code;
        private String diseaseName;
        private String category;
        private String pathophysiology;
        private List<String> clinicalPresentation;
        private List<String> diagnosticWorkup;
        private List<String> endoscopicAndRadiologicCriteria;
        private List<String> severityScoringAndStaging;
        private List<String> differentialDiagnoses;
        private List<String> medicalPharmacotherapy;
        private List<String> endoscopicAndSurgicalInterventions;
        private String complicationsAndPrognosis;
    }

    private static final List<GastroDiseaseEntry> ENTRIES = new ArrayList<>();

    static {
        // =========================================================================
        // SECTION 1: DISEASES OF ESOPHAGUS, STOMACH AND DUODENUM (K20 - K31)
        // =========================================================================
        add("K25.0", "Acute Gastric Ulcer with Hemorrhage", "Esophagus, Stomach, Duodenum",
                "Focal mucosal defect extending through the muscularis mucosae into the submucosa or muscularis propria of the gastric wall with active intraluminal bleeding. Pathophysiology involves breakdown of the gastric mucosal defensive barrier (mucus-bicarbonate layer, mucosal blood flow, epithelial tight junctions, prostaglandin E2 synthesis) by aggressive luminal factors (gastric hydrochloric acid, pepsin) triggered by Helicobacter pylori colonization (causing chronic active gastritis, decreased somatostatin, and hypergastrinemia) or Nonsteroidal Anti-Inflammatory Drugs (NSAIDs / Aspirin - causing direct topical mucosal injury and systemic inhibition of Cyclooxygenase-1 COX-1, halting protective prostaglandin synthesis).",
                Arrays.asList("Hematemesis ('coffee-ground' emesis or frank bright red bloody vomiting)", "Melena (passage of black, tarry, foul-smelling stools due to hemoglobin oxidation by intestinal bacteria)", "Severe epigastric pain ('gnawing, burning, or aching sensation') typically worsening immediately after food intake", "Postprandial fullness, early satiety, nausea, and anorexia", "Syncope, presyncope, orthostatic dizziness, and diaphoresis in massive hemorrhage", "Tachycardia (HR > 100 bpm) and hypotension (Systolic BP < 90-100 mmHg) indicating Class II-IV hemorrhagic shock"),
                Arrays.asList("Emergency Esophagogastroduodenoscopy (EGD) performed within 12 to 24 hours of presentation (gold standard for diagnosis, Forrest classification, and immediate endoscopic hemostasis)", "Nasogastric tube aspiration (frank red blood confirms active upper GI bleed; clear aspirate does not rule out duodenal bleed)", "Complete Blood Count (serial Hemoglobin and Hematocrit monitoring - baseline Hb may appear falsely normal before crystalloid fluid redistribution)", "Blood Urea Nitrogen (BUN) to Creatinine Ratio (BUN/Cr > 30:1 strongly suggests upper GI bleeding due to intestinal absorption of digested blood proteins)", "Type and Screen / Crossmatch for 2-4 units PRBCs", "Coagulation Profile (PT/INR, aPTT, Fibrinogen)", "Testing for Helicobacter pylori (Stool Antigen test, Urea Breath Test, or Rapid Urease Test / histology on mucosal biopsy once bleeding is controlled)"),
                Arrays.asList("FORREST CLASSIFICATION OF PEPTIC ULCER BLEEDING ON ENDOSCOPY:", "- FORREST IA: Active spurting hemorrhage (High rebleeding risk 90%; mandatory endoscopic therapy)", "- FORREST IB: Active oozing hemorrhage (High rebleeding risk 50%; mandatory endoscopic therapy)", "- FORREST IIA: Non-bleeding visible vessel in ulcer base (High rebleeding risk 40-50%; mandatory endoscopic therapy)", "- FORREST IIB: Adherent clot covering ulcer base (Intermediate rebleeding risk 20-30%; targeted clot irrigation and underlying vessel treatment)", "- FORREST IIC: Flat pigmented spot / hematin in ulcer base (Low rebleeding risk 5-10%; medical therapy alone)", "- FORREST III: Clean-based ulcer with white fibrinous base (Minimal rebleeding risk < 2%; medical therapy, outpatient discharge)"),
                Arrays.asList("Glasgow-Blatchford Bleeding Score (GBS: 0-23; Score 0-1 = low risk suitable for outpatient management; Score >= 6 = high risk requiring urgent endoscopy and transfusion)", "Rockall Risk Score (Pre-endoscopy 0-7, Post-endoscopy 0-11 for rebleeding and mortality prediction)", "AIMS65 Score (Albumin < 3.0, INR > 1.5, Altered Mental Status, Systolic BP <= 90, Age > 65; 1 point each)"),
                Arrays.asList("Bleeding Duodenal Ulcer (typically located on posterior bulbar wall eroding into Gastroduodenal Artery GDA)", "Bleeding Esophageal or Gastric Varices (in patients with chronic liver disease / portal hypertension)", "Mallory-Weiss Syndrome (linear mucosal tear at the gastroesophageal junction following severe retching/vomiting)", "Dieulafoy's Lesion (large tortuous submucosal arteriole eroding through normal-appearing mucosa)", "Gastric Antral Vascular Ectasia (GAVE / 'Watermelon Stomach')", "Bleeding Gastric Adenocarcinoma / Gastrointestinal Stromal Tumor (GIST)", "Aortoenteric Fistula (in patients with prior abdominal aortic aneurysm graft surgery)"),
                Arrays.asList("Immediate Resuscitation: Two large-bore (16-18G) peripheral IV lines, rapid isotonic crystalloid infusion, target restrictive transfusion threshold (PRBC transfusion when Hemoglobin < 7-8 g/dL; target Hb 8-9 g/dL in coronary artery disease - Villanueva NEJM landmark trial)", "High-Dose Intravenous Proton Pump Inhibitor (PPI): IV Pantoprazole or Esomeprazole (80 mg IV bolus followed by 8 mg/hour continuous infusion for 72 hours post-endoscopy, OR high-dose intermittent 40 mg IV bid; maintains gastric pH > 6.0, stabilizing fibrin clot formation and preventing pepsin-mediated clot lysis)", "Intravenous Prokinetic (Erythromycin 250 mg IV or Metoclopramide 10 mg IV administered 30-60 minutes prior to endoscopy to clear blood and clots from the gastric fundus and optimize mucosal visualization)", "Helicobacter pylori Eradication (Quadruple Therapy for 14 days once oral intake resumes): Bismuth Subsalicylate 524 mg qid + Metronidazole 500 mg tid-qid + Tetracycline 500 mg qid + PPI (Pantoprazole 40 mg bid) OR Clarithromycin-based triple therapy only in areas with low (< 15%) clarithromycin resistance", "Permanent discontinuation of non-selective NSAIDs; if antiplatelet/anticoagulant is mandatory for cardiac stents, resume Aspirin within 3-5 days under continuous PPI co-prescription"),
                Arrays.asList("ENDOSCOPIC DUAL-MODALITY HEMOSTASIS (Mandatory for Forrest IA, IB, and IIA lesions):", "(1) Mechanical Therapy: Placement of Through-The-Scope (TTS) Hemostatic Clips or Over-The-Scope Clips (OTSC / 'Padlock' clip) directly over the bleeding vessel;", "(2) Thermal Coagulation: Bipolar electrocoagulation (Gold Probe) or Heater Probe or Argon Plasma Coagulation (APC);", "(3) Injection Therapy: Dilute Epinephrine (1:10,000 solution) injection into 4 quadrants around the ulcer base to achieve initial tamponade (MUST ALWAYS be combined with mechanical or thermal therapy; epinephrine monotherapy is inadequate);", "(4) Topical Hemostatic Agents: Hemostatic powders (Hemospray / TC-325) as rescue therapy for diffuse oozing or refractory malignant ulcers;", "TRANS-CATHETER ARTERIAL EMBOLIZATION (TAE / Interventional Radiology): Highly effective minimally invasive rescue for refractory bleeding or failed endoscopic therapy (coil or micro-particle embolization of the Left Gastric Artery or Gastroduodenal Artery);", "SURGICAL REPAIR (Emergency Laparotomy): Indicated for persistent bleeding refractory to endoscopy and TAE, or massive hemodynamic collapse: Gastrotomy with direct four-quadrant under-running transfixion suture ligation of the bleeding vessel, with or without partial gastrectomy and truncal vagotomy/pyloroplasty"),
                "Mortality in acute bleeding peptic ulcer disease is approximately 5-10%, primarily occurring in elderly patients with severe cardiopulmonary, renal, or hepatic comorbidities. Recurrent bleeding occurs in 10-15% of high-risk endoscopic lesions. Complications include Hemorrhagic Shock, Acute Myocardial Infarction due to severe acute anemia, Acute Tubular Necrosis, Aspiration Pneumonia, and Gastric Ulcer Perforation into the peritoneal cavity with generalized peritonitis.");

        add("K85.90", "Acute Pancreatitis, Unspecified", "Pancreatobiliary Diseases",
                "Acute inflammatory disorder of the pancreas characterized by premature intracellular activation of digestive zymogens (trypsinogen converted to active trypsin within acinar cells), leading to autodigestion of pancreatic acinar tissue, local interstitial edema, microvascular thrombosis, acinar cell necrosis, and massive release of pro-inflammatory cytokines (TNF-alpha, IL-1beta, IL-6, IL-8, platelet-activating factor) into systemic circulation triggering Systemic Inflammatory Response Syndrome (SIRS), increased endothelial permeability, third-space fluid sequestration, and multi-organ failure. Etiology: Gallstones / Biliary sludge (40-50% - mechanical ampullary impaction), Alcohol abuse (30-35% - direct acinar toxicity and protein plugging), Hypertriglyceridemia (5-10% - serum triglycerides > 1000 mg/dL hydrolyzed by pancreatic lipase into toxic free fatty acids), Post-ERCP (3-5%), Hypercalcemia, Trauma, and Drug-induced (Azathioprine, Thiazides, Valproate, GLP-1 receptor agonists).",
                Arrays.asList("Severe, sudden-onset epigastric pain ('boring, stabbing, or piercing pain') radiating straight through to the mid-back in > 50-70% of cases", "Pain characteristically partially relieved by sitting upright and leaning forward, and worsened by lying supine or eating", "Persistent nausea, vomiting, and retching that fails to relieve the abdominal pain", "Abdominal distension, epigastric tenderness, voluntary guarding, and hypoactive/absent bowel sounds due to paralytic ileus", "Tachycardia (HR > 100 bpm), tachypnea, low-grade fever, and hypotension in severe necrotizing cases", "Late retroperitoneal hemorrhagic ecchymosis: Cullen's Sign (periumbilical bluish discoloration) and Grey Turner's Sign (flank ecchymosis) indicating extensive retroperitoneal hemorrhage"),
                Arrays.asList("REVISED ATLANTA CLASSIFICATION FOR DIAGNOSIS (Requires >= 2 of the following 3 criteria):", "(1) Abdominal pain strongly consistent with acute pancreatitis (acute onset of persistent, severe, epigastric pain radiating to the back);", "(2) Serum Amylase or Serum Lipase elevated to AT LEAST THREE TIMES (>= 3x) the upper limit of normal (Serum Lipase is superior: Sensitivity > 90%, Specificity > 95%, remains elevated for 8-14 days vs amylase which normalizes in 3-5 days);", "(3) Characteristic cross-sectional imaging findings of acute pancreatitis on Contrast-Enhanced CT, MRI, or Transabdominal Ultrasound"),
                Arrays.asList("Contrast-Enhanced Computed Tomography (CECT Abdomen & Pelvis with IV contrast): Optimal timing is 72 to 96 hours AFTER symptom onset to accurately delineate non-perfused necrotic pancreatic parenchyma (Balthazar CT Severity Index / Modified CTSI 0-10); early CT (< 48h) frequently underestimates necrosis;", "Transabdominal Ultrasound: Mandatory on presentation to evaluate for cholelithiasis, choledocholithiasis, and common bile duct (CBD) dilation (> 6 mm);", "Magnetic Resonance Cholangiopancreatography (MRCP): Non-invasive imaging of choice for suspected occult biliary stone, choledochal cyst, or pancreas divisum;", "Endoscopic Ultrasound (EUS): Highest sensitivity for detecting occult microlithiasis, biliary sludge, and small ampullary neoplasms"),
                Arrays.asList("ATLANTA CLASSIFICATION OF SEVERITY:", "- MILD ACUTE PANCREATITIS: No organ failure and no local or systemic complications (resolves rapidly in 3-5 days);", "- MODERATELY SEVERE: Transient organ failure resolving within 48 hours AND/OR local complications (acute peripancreatic fluid collection APFC, acute necrotic collection ANC);", "- SEVERE ACUTE PANCREATITIS: Persistent organ failure lasting > 48 hours (Respiratory PaO2/FiO2 <= 300, Cardiovascular SBP < 90 unresponsive to fluids, Renal Serum Creatinine >= 1.9 mg/dL - Marshall Modified Organ Failure Score >= 2);", "CLINICAL RISK PREDICTORS: BISAP Score (BUN > 25 mg/dL, Impaired mental status, SIRS >= 2 criteria, Age > 60, Pleural effusion; Score >= 3 = high mortality), Ranson's Criteria (at admission and 48h), APACHE II Score (>= 8 indicates severe disease)"),
                Arrays.asList("Perforated Peptic Ulcer (free air under diaphragm on erect CXR)", "Acute Cholecystitis / Acute Ascending Cholangitis (Charcot's triad: RUQ pain, fever, jaundice)", "Acute Mesenteric Ischemia (severe abdominal pain out of proportion to physical exam findings)", "Acute Bowel Obstruction / Strangulated Hernia", "Ruptured Abdominal Aortic Aneurysm", "Acute Inferior Wall Myocardial Infarction (ECG and troponin mandatory)", "Diabetic Ketoacidosis (can cause hyperlipasemia and abdominal pain)"),
                Arrays.asList("GOAL-DIRECTED FLUID RESUSCITATION: Isotonic Balanced Crystalloids (Lactated Ringer's solution is preferred over 0.9% Normal Saline - reduces systemic metabolic acidosis and SIRS): Bolus of 10-20 mL/kg followed by infusion of 200-250 mL/hour for the first 12-24 hours, titrated to hemodynamic endpoints: Target Heart Rate < 100 bpm, Mean Arterial Pressure 65-85 mmHg, Urine Output > 0.5-1.0 mL/kg/hour, and reduction in Hematocrit (target 35-40%) and BUN; CAUTION: Avoid aggressive fluid overload (worsens abdominal compartment syndrome and pulmonary edema; Waterfall trial)", "MULTIMODAL ANALGESIA: Intravenous Opioids (Hydromorphone 0.5-1 mg IV or Fentanyl 25-50 mcg IV or Morphine; earlier dogma regarding morphine-induced Sphincter of Oddi spasm is clinically insignificant) + Acetaminophen IV", "EARLY ENTERAL NUTRITION (Within 24-48 hours): Early oral feeding with low-fat solid or liquid diet as soon as abdominal pain is decreasing and ileus is resolving; if oral not tolerated, Enteral Tube Feeding (Nasogastric or Nasojejunal) is vastly superior to Total Parenteral Nutrition (TPN), preserving gut mucosal barrier and reducing bacterial translocation and infected necrosis by 50%", "ANTIMICROBIAL STEWARDSHIP: Prophylactic antibiotics are STRICTLY CONTRAINDICATED in sterile acute necrotizing pancreatitis (does not prevent infected necrosis and breeds fungal/multidrug-resistant superinfections); Therapeutic Intravenous Antibiotics (Carbapenems: Meropenem 1g IV q8h OR Fluoroquinolone + Metronidazole) are indicated ONLY for DOCUMENTED INFECTED PANCREATIC NECROSIS (confirmed by CT demonstrating gas within necrotic collection or CT-guided fine needle aspiration FNA Gram stain/culture) or extrapancreatic infections (cholangitis, bacteremia, UTI, pneumonia)", "TREATMENT OF HYPERTRIGLYCERIDEMIA-INDUCED PANCREATITIS: Intravenous Regular Insulin infusion (0.05-0.1 units/kg/hr with D5W/D10W to prevent hypoglycemia, activating lipoprotein lipase and rapidly clearing chylomicrons/triglycerides < 500 mg/dL) +/- Therapeutic Plasma Exchange (Plasmapheresis) in severe cases"),
                Arrays.asList("URGENT ENDOSCOPIC RETROGRADE CHOLANGIOPANCREATOGRAPHY (ERCP with endoscopic biliary sphincterotomy and stone extraction): Mandatory within 24 hours for acute biliary pancreatitis with concomitant Acute Cholangitis, or within 48 hours for persistent common bile duct obstruction/severe biliary pancreatitis;", "MINIMALLY INVASIVE 'STEP-UP' SURGICAL APPROACH FOR INFECTED PANCREATIC NECROSIS (PANTER Trial - standard of care):", "(1) Step 1: Percutaneous Catheter Drainage (PCD) or Endoscopic Transmural Drainage (EUS-guided Cystogastrostomy with lumen-apposing metal stents LAMS) - resolves infected necrosis without surgery in 35-50% of patients;", "(2) Step 2 (if no clinical improvement after 72 hours): Minimally Invasive Retroperitoneal Necrosectomy (VARD: Video-Assisted Retroperitoneal Debridement) or Endoscopic Necrosectomy (Direct Endoscopic Necrosectomy DEN);", "(3) Open Surgical Necrosectomy (Laparotomy with open packing): Reserved as last resort for refractory necrotizing pancreatitis failing minimally invasive techniques;", "INDEX ADMISSION CHOLECYSTECTOMY: Mandatory laparoscopic cholecystectomy during the SAME hospital admission once mild biliary pancreatitis resolves (delaying cholecystectomy leads to 25-30% recurrence of life-threatening biliary events within 30 days)"),
                "Overall mortality in acute pancreatitis is approx 2-5%; however, in severe acute necrotizing pancreatitis with persistent multi-organ failure and infected necrosis, mortality reaches 30-40%. Late local complications (> 4 weeks) include Pancreatic Pseudocyst (mature fibrous wall without epithelial lining containing pancreatic juice), Walled-Off Pancreatic Necrosis (WON), Pancreatic Ascites, Pseudoaneurysms of the Splenic or Gastroduodenal Arteries with massive gastrointestinal hemorrhage, Splenic Vein Thrombosis with left-sided (sinistral) portal hypertension and gastric varices, and Exocrine/Endocrine Pancreatic Insufficiency (Type 3c Diabetes Mellitus).");
    }

    private static void add(String code, String name, String cat, String patho,
                            List<String> clin, List<String> diag, List<String> endo,
                            List<String> scor, List<String> diff, List<String> med,
                            List<String> surg, String comp) {
        ENTRIES.add(GastroDiseaseEntry.builder()
                .icd10Code(code)
                .diseaseName(name)
                .category(cat)
                .pathophysiology(patho)
                .clinicalPresentation(clin)
                .diagnosticWorkup(diag)
                .endoscopicAndRadiologicCriteria(endo)
                .severityScoringAndStaging(scor)
                .differentialDiagnoses(diff)
                .medicalPharmacotherapy(med)
                .endoscopicAndSurgicalInterventions(surg)
                .complicationsAndPrognosis(comp)
                .build());
    }

    public List<GastroDiseaseEntry> search(String query) {
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

    public Optional<GastroDiseaseEntry> findByCode(String code) {
        return ENTRIES.stream()
                .filter(e -> e.getIcd10Code().equalsIgnoreCase(code))
                .findFirst();
    }
}
