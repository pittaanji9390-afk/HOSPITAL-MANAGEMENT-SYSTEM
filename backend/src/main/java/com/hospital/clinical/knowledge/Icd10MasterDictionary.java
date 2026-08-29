package com.hospital.clinical.knowledge;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Standard ICD-10-CM Clinical Diagnostic Knowledge Base.
 * Self-contained local medical coding directory without external API dependencies.
 */
@Component
public class Icd10MasterDictionary {

    @Data
    @Builder
    public static class Icd10Entry {
        private String code;
        private String description;
        private String chapter;
        private String category;
        private boolean chronicCondition;
        private String severityLevel; // MILD, MODERATE, SEVERE, CRITICAL
    }

    private static final List<Icd10Entry> ENTRIES = new ArrayList<>();

    static {
        // Chapter I: Certain infectious and parasitic diseases (A00-B99)
        add("A00.0", "Cholera due to Vibrio cholerae 01, biovar cholerae", "Infectious Diseases", "Intestinal Infectious", false, "SEVERE");
        add("A00.1", "Cholera due to Vibrio cholerae 01, biovar eltor", "Infectious Diseases", "Intestinal Infectious", false, "SEVERE");
        add("A00.9", "Cholera, unspecified", "Infectious Diseases", "Intestinal Infectious", false, "SEVERE");
        add("A01.0", "Typhoid fever", "Infectious Diseases", "Typhoid and Paratyphoid", false, "SEVERE");
        add("A01.00", "Typhoid fever, unspecified", "Infectious Diseases", "Typhoid and Paratyphoid", false, "SEVERE");
        add("A01.01", "Typhoid meningitis", "Infectious Diseases", "Typhoid and Paratyphoid", false, "CRITICAL");
        add("A01.02", "Typhoid fever with heart involvement", "Infectious Diseases", "Typhoid and Paratyphoid", false, "CRITICAL");
        add("A01.03", "Typhoid pneumonia", "Infectious Diseases", "Typhoid and Paratyphoid", false, "CRITICAL");
        add("A01.04", "Typhoid arthritis", "Infectious Diseases", "Typhoid and Paratyphoid", false, "MODERATE");
        add("A01.05", "Typhoid osteomyelitis", "Infectious Diseases", "Typhoid and Paratyphoid", false, "MODERATE");
        add("A01.1", "Paratyphoid fever A", "Infectious Diseases", "Typhoid and Paratyphoid", false, "MODERATE");
        add("A01.2", "Paratyphoid fever B", "Infectious Diseases", "Typhoid and Paratyphoid", false, "MODERATE");
        add("A01.3", "Paratyphoid fever C", "Infectious Diseases", "Typhoid and Paratyphoid", false, "MODERATE");
        add("A02.0", "Salmonella enteritis", "Infectious Diseases", "Other Salmonella Infections", false, "MODERATE");
        add("A02.1", "Salmonella sepsis", "Infectious Diseases", "Other Salmonella Infections", false, "CRITICAL");
        add("A03.0", "Shigellosis due to Shigella dysenteriae", "Infectious Diseases", "Shigellosis", false, "SEVERE");
        add("A03.1", "Shigellosis due to Shigella flexneri", "Infectious Diseases", "Shigellosis", false, "MODERATE");
        add("A04.0", "Enteropathogenic Escherichia coli infection", "Infectious Diseases", "Bacterial Intestinal", false, "MODERATE");
        add("A04.5", "Campylobacter enteritis", "Infectious Diseases", "Bacterial Intestinal", false, "MODERATE");
        add("A04.7", "Enterocolitis due to Clostridium difficile", "Infectious Diseases", "Bacterial Intestinal", false, "SEVERE");
        add("A04.71", "Enterocolitis due to Clostridium difficile, recurrent", "Infectious Diseases", "Bacterial Intestinal", false, "SEVERE");
        add("A05.0", "Foodborne staphylococcal intoxication", "Infectious Diseases", "Bacterial Foodborne", false, "MODERATE");
        add("A06.0", "Acute amebic dysentery", "Infectious Diseases", "Amebiasis", false, "MODERATE");
        add("A06.4", "Amebic liver abscess", "Infectious Diseases", "Amebiasis", false, "SEVERE");
        add("A08.0", "Rotaviral enteritis", "Infectious Diseases", "Viral Intestinal Infections", false, "MODERATE");
        add("A08.11", "Acute gastroenteropathy due to Norwalk agent", "Infectious Diseases", "Viral Intestinal Infections", false, "MODERATE");
        add("A09", "Infectious gastroenteritis and colitis, unspecified", "Infectious Diseases", "Gastroenteritis", false, "MODERATE");
        add("A15.0", "Tuberculosis of lung", "Infectious Diseases", "Respiratory Tuberculosis", true, "SEVERE");
        add("A15.4", "Tuberculosis of intrathoracic lymph nodes", "Infectious Diseases", "Respiratory Tuberculosis", true, "MODERATE");
        add("A15.5", "Tuberculosis of larynx, trachea and bronchus", "Infectious Diseases", "Respiratory Tuberculosis", true, "SEVERE");
        add("A15.6", "Tuberculous pleurisy", "Infectious Diseases", "Respiratory Tuberculosis", true, "SEVERE");
        add("A17.0", "Tuberculous meningitis", "Infectious Diseases", "Tuberculosis of Nervous System", true, "CRITICAL");
        add("A18.01", "Tuberculosis of spine (Pott's disease)", "Infectious Diseases", "Tuberculosis of Bones", true, "SEVERE");
        add("A20.0", "Bubonic plague", "Infectious Diseases", "Plague", false, "CRITICAL");
        add("A22.0", "Cutaneous anthrax", "Infectious Diseases", "Anthrax", false, "SEVERE");
        add("A22.1", "Pulmonary anthrax", "Infectious Diseases", "Anthrax", false, "CRITICAL");
        add("A30.0", "Indeterminate leprosy", "Infectious Diseases", "Leprosy", true, "MODERATE");
        add("A35", "Other tetanus", "Infectious Diseases", "Tetanus", false, "CRITICAL");
        add("A36.0", "Pharyngeal diphtheria", "Infectious Diseases", "Diphtheria", false, "SEVERE");
        add("A37.0", "Whooping cough due to Bordetella pertussis", "Infectious Diseases", "Whooping Cough", false, "SEVERE");
        add("A38.0", "Scarlet fever with angina", "Infectious Diseases", "Scarlet Fever", false, "MODERATE");
        add("A39.0", "Meningococcal meningitis", "Infectious Diseases", "Meningococcal Infection", false, "CRITICAL");
        add("A39.2", "Acute meningococcemia", "Infectious Diseases", "Meningococcal Infection", false, "CRITICAL");
        add("A40.0", "Sepsis due to streptococcus, group A", "Infectious Diseases", "Streptococcal Sepsis", false, "CRITICAL");
        add("A40.1", "Sepsis due to streptococcus, group B", "Infectious Diseases", "Streptococcal Sepsis", false, "CRITICAL");
        add("A41.0", "Sepsis due to Staphylococcus aureus", "Infectious Diseases", "Other Sepsis", false, "CRITICAL");
        add("A41.01", "Sepsis due to Methicillin susceptible Staphylococcus aureus", "Infectious Diseases", "Other Sepsis", false, "CRITICAL");
        add("A41.02", "Sepsis due to Methicillin resistant Staphylococcus aureus (MRSA)", "Infectious Diseases", "Other Sepsis", false, "CRITICAL");
        add("A41.51", "Sepsis due to Escherichia coli [E. coli]", "Infectious Diseases", "Other Sepsis", false, "CRITICAL");
        add("A41.52", "Sepsis due to Pseudomonas", "Infectious Diseases", "Other Sepsis", false, "CRITICAL");
        add("A41.9", "Sepsis, unspecified organism", "Infectious Diseases", "Other Sepsis", false, "CRITICAL");
        add("A49.01", "Methicillin susceptible Staphylococcus aureus infection, unspecified site", "Infectious Diseases", "Bacterial Infections", false, "MODERATE");
        add("A49.02", "Methicillin resistant Staphylococcus aureus infection, unspecified site", "Infectious Diseases", "Bacterial Infections", false, "SEVERE");
        add("B00.0", "Eczema herpeticum", "Infectious Diseases", "Herpesviral Infections", false, "MODERATE");
        add("B00.1", "Herpesviral vesicular dermatitis", "Infectious Diseases", "Herpesviral Infections", false, "MILD");
        add("B01.0", "Varicella meningitis", "Infectious Diseases", "Varicella", false, "CRITICAL");
        add("B01.9", "Varicella without complication", "Infectious Diseases", "Varicella", false, "MILD");
        add("B02.0", "Zoster encephalitis", "Infectious Diseases", "Zoster", false, "CRITICAL");
        add("B02.9", "Zoster without complications", "Infectious Diseases", "Zoster", false, "MODERATE");
        add("B05.0", "Measles complicated by encephalitis", "Infectious Diseases", "Measles", false, "CRITICAL");
        add("B15.0", "Hepatitis A with hepatic coma", "Infectious Diseases", "Viral Hepatitis", false, "CRITICAL");
        add("B15.9", "Hepatitis A without hepatic coma", "Infectious Diseases", "Viral Hepatitis", false, "MODERATE");
        add("B16.0", "Acute hepatitis B with delta-agent with hepatic coma", "Infectious Diseases", "Viral Hepatitis", false, "CRITICAL");
        add("B16.2", "Acute hepatitis B without delta-agent with hepatic coma", "Infectious Diseases", "Viral Hepatitis", false, "CRITICAL");
        add("B16.9", "Acute hepatitis B without delta-agent and without hepatic coma", "Infectious Diseases", "Viral Hepatitis", false, "MODERATE");
        add("B18.1", "Chronic viral hepatitis B without delta-agent", "Infectious Diseases", "Viral Hepatitis", true, "MODERATE");
        add("B18.2", "Chronic viral hepatitis C", "Infectious Diseases", "Viral Hepatitis", true, "MODERATE");
        add("B20", "Human immunodeficiency virus [HIV] disease", "Infectious Diseases", "HIV Disease", true, "SEVERE");
        add("B34.9", "Viral infection, unspecified", "Infectious Diseases", "Viral Infections", false, "MILD");
        add("B37.0", "Candidal stomatitis (Oral Thrush)", "Infectious Diseases", "Mycoses", false, "MILD");
        add("B50.0", "Plasmodium falciparum malaria with cerebral complications", "Infectious Diseases", "Protozoal Diseases", false, "CRITICAL");
        add("B50.9", "Plasmodium falciparum malaria, unspecified", "Infectious Diseases", "Protozoal Diseases", false, "SEVERE");
        add("B51.9", "Plasmodium vivax malaria without complication", "Infectious Diseases", "Protozoal Diseases", false, "MODERATE");
        add("B54", "Unspecified malaria", "Infectious Diseases", "Protozoal Diseases", false, "MODERATE");
        add("B95.62", "Methicillin resistant Staphylococcus aureus infection as the cause of diseases classified elsewhere", "Infectious Diseases", "Bacterial Agents", false, "SEVERE");

        // Chapter II: Neoplasms (C00-D49)
        add("C15.9", "Malignant neoplasm of esophagus, unspecified", "Neoplasms", "Digestive Organs", true, "SEVERE");
        add("C16.9", "Malignant neoplasm of stomach, unspecified", "Neoplasms", "Digestive Organs", true, "SEVERE");
        add("C18.9", "Malignant neoplasm of colon, unspecified", "Neoplasms", "Digestive Organs", true, "SEVERE");
        add("C20", "Malignant neoplasm of rectum", "Neoplasms", "Digestive Organs", true, "SEVERE");
        add("C22.0", "Liver cell carcinoma (Hepatocellular carcinoma)", "Neoplasms", "Digestive Organs", true, "CRITICAL");
        add("C25.9", "Malignant neoplasm of pancreas, unspecified", "Neoplasms", "Digestive Organs", true, "CRITICAL");
        add("C34.90", "Malignant neoplasm of unspecified part of unspecified bronchus or lung", "Neoplasms", "Respiratory Organs", true, "CRITICAL");
        add("C43.9", "Malignant melanoma of skin, unspecified", "Neoplasms", "Melanoma & Skin", true, "SEVERE");
        add("C50.911", "Malignant neoplasm of unspecified site of right female breast", "Neoplasms", "Breast", true, "SEVERE");
        add("C50.912", "Malignant neoplasm of unspecified site of left female breast", "Neoplasms", "Breast", true, "SEVERE");
        add("C53.9", "Malignant neoplasm of cervix uteri, unspecified", "Neoplasms", "Female Genital Organs", true, "SEVERE");
        add("C56.9", "Malignant neoplasm of unspecified ovary", "Neoplasms", "Female Genital Organs", true, "SEVERE");
        add("C61", "Malignant neoplasm of prostate", "Neoplasms", "Male Genital Organs", true, "MODERATE");
        add("C64.9", "Malignant neoplasm of unspecified kidney, except renal pelvis", "Neoplasms", "Urinary Tract", true, "SEVERE");
        add("C67.9", "Malignant neoplasm of bladder, unspecified", "Neoplasms", "Urinary Tract", true, "SEVERE");
        add("C71.9", "Malignant neoplasm of brain, unspecified", "Neoplasms", "Brain & CNS", true, "CRITICAL");
        add("C73", "Malignant neoplasm of thyroid gland", "Neoplasms", "Thyroid & Endocrine", true, "MODERATE");
        add("C81.90", "Hodgkin lymphoma, unspecified, unspecified site", "Neoplasms", "Lymphoid & Hematopoietic", true, "SEVERE");
        add("C85.90", "Non-Hodgkin lymphoma, unspecified, unspecified site", "Neoplasms", "Lymphoid & Hematopoietic", true, "SEVERE");
        add("C90.00", "Multiple myeloma not having achieved remission", "Neoplasms", "Lymphoid & Hematopoietic", true, "SEVERE");
        add("C91.00", "Acute lymphoblastic leukemia not having achieved remission", "Neoplasms", "Leukemia", true, "CRITICAL");
        add("C92.00", "Acute myeloblastic leukemia not having achieved remission", "Neoplasms", "Leukemia", true, "CRITICAL");
        add("D50.0", "Iron deficiency anemia secondary to blood loss (chronic)", "Diseases of Blood", "Nutritional Anemias", true, "MODERATE");
        add("D50.9", "Iron deficiency anemia, unspecified", "Diseases of Blood", "Nutritional Anemias", true, "MILD");
        add("D57.0", "Hb-SS disease with crisis (Sickle-cell crisis)", "Diseases of Blood", "Hemolytic Anemias", true, "SEVERE");
        add("D64.9", "Anemia, unspecified", "Diseases of Blood", "Aplastic & Other Anemias", false, "MILD");
        add("D69.6", "Thrombocytopenia, unspecified", "Diseases of Blood", "Coagulation Defects", false, "MODERATE");

        // Chapter IV: Endocrine, Nutritional and Metabolic Diseases (E00-E89)
        add("E03.9", "Hypothyroidism, unspecified", "Endocrine & Metabolic", "Thyroid Disorders", true, "MILD");
        add("E05.90", "Thyrotoxicosis without thyrotoxic crisis or storm, unspecified", "Endocrine & Metabolic", "Thyroid Disorders", true, "MODERATE");
        add("E05.00", "Thyrotoxicosis with diffuse goiter without thyrotoxic crisis (Graves disease)", "Endocrine & Metabolic", "Thyroid Disorders", true, "MODERATE");
        add("E10.9", "Type 1 diabetes mellitus without complications", "Endocrine & Metabolic", "Diabetes Mellitus", true, "MODERATE");
        add("E10.10", "Type 1 diabetes mellitus with ketoacidosis without coma (DKA)", "Endocrine & Metabolic", "Diabetes Mellitus", true, "CRITICAL");
        add("E10.21", "Type 1 diabetes mellitus with diabetic nephropathy", "Endocrine & Metabolic", "Diabetes Mellitus", true, "SEVERE");
        add("E10.319", "Type 1 diabetes mellitus with unspecified diabetic retinopathy", "Endocrine & Metabolic", "Diabetes Mellitus", true, "MODERATE");
        add("E10.40", "Type 1 diabetes mellitus with diabetic neuropathy, unspecified", "Endocrine & Metabolic", "Diabetes Mellitus", true, "MODERATE");
        add("E10.65", "Type 1 diabetes mellitus with hyperglycemia", "Endocrine & Metabolic", "Diabetes Mellitus", true, "MODERATE");
        add("E11.9", "Type 2 diabetes mellitus without complications", "Endocrine & Metabolic", "Diabetes Mellitus", true, "MILD");
        add("E11.00", "Type 2 diabetes mellitus with hyperosmolarity without nonketotic hyperglycemic-hyperosmolar coma (HHS)", "Endocrine & Metabolic", "Diabetes Mellitus", true, "CRITICAL");
        add("E11.21", "Type 2 diabetes mellitus with diabetic nephropathy", "Endocrine & Metabolic", "Diabetes Mellitus", true, "SEVERE");
        add("E11.22", "Type 2 diabetes mellitus with diabetic chronic kidney disease", "Endocrine & Metabolic", "Diabetes Mellitus", true, "SEVERE");
        add("E11.40", "Type 2 diabetes mellitus with diabetic neuropathy, unspecified", "Endocrine & Metabolic", "Diabetes Mellitus", true, "MODERATE");
        add("E11.51", "Type 2 diabetes mellitus with diabetic peripheral angiopathy without gangrene", "Endocrine & Metabolic", "Diabetes Mellitus", true, "SEVERE");
        add("E11.621", "Type 2 diabetes mellitus with foot ulcer", "Endocrine & Metabolic", "Diabetes Mellitus", true, "SEVERE");
        add("E11.65", "Type 2 diabetes mellitus with hyperglycemia", "Endocrine & Metabolic", "Diabetes Mellitus", true, "MODERATE");
        add("E16.2", "Hypoglycemia, unspecified", "Endocrine & Metabolic", "Other Pancreatic Disorders", false, "SEVERE");
        add("E66.01", "Morbid (severe) obesity due to excess calories", "Endocrine & Metabolic", "Obesity", true, "MODERATE");
        add("E66.9", "Obesity, unspecified", "Endocrine & Metabolic", "Obesity", true, "MILD");
        add("E78.0", "Pure hypercholesterolemia", "Endocrine & Metabolic", "Lipoprotein Disorders", true, "MILD");
        add("E78.1", "Pure hyperglyceridemia", "Endocrine & Metabolic", "Lipoprotein Disorders", true, "MILD");
        add("E78.2", "Mixed hyperlipidemia", "Endocrine & Metabolic", "Lipoprotein Disorders", true, "MILD");
        add("E78.5", "Hyperlipidemia, unspecified", "Endocrine & Metabolic", "Lipoprotein Disorders", true, "MILD");
        add("E86.0", "Dehydration", "Endocrine & Metabolic", "Fluid & Electrolyte Disorders", false, "MODERATE");
        add("E87.1", "Hypo-osmolality and hyponatremia", "Endocrine & Metabolic", "Fluid & Electrolyte Disorders", false, "SEVERE");
        add("E87.2", "Acidosis", "Endocrine & Metabolic", "Fluid & Electrolyte Disorders", false, "SEVERE");
        add("E87.5", "Hyperkalemia", "Endocrine & Metabolic", "Fluid & Electrolyte Disorders", false, "CRITICAL");
        add("E87.6", "Hypokalemia", "Endocrine & Metabolic", "Fluid & Electrolyte Disorders", false, "SEVERE");

        // Chapter IX: Diseases of the Circulatory System (I00-I99)
        add("I10", "Essential (primary) hypertension", "Circulatory System", "Hypertensive Diseases", true, "MILD");
        add("I11.0", "Hypertensive heart disease with heart failure", "Circulatory System", "Hypertensive Diseases", true, "SEVERE");
        add("I11.9", "Hypertensive heart disease without heart failure", "Circulatory System", "Hypertensive Diseases", true, "MODERATE");
        add("I12.0", "Hypertensive chronic kidney disease with stage 5 chronic kidney disease or end stage renal disease", "Circulatory System", "Hypertensive Diseases", true, "CRITICAL");
        add("I12.9", "Hypertensive chronic kidney disease with stage 1 through stage 4 chronic kidney disease", "Circulatory System", "Hypertensive Diseases", true, "SEVERE");
        add("I13.10", "Hypertensive heart and chronic kidney disease without heart failure, with stage 1 through stage 4 chronic kidney disease", "Circulatory System", "Hypertensive Diseases", true, "SEVERE");
        add("I20.0", "Unstable angina (Pre-infarction syndrome)", "Circulatory System", "Ischemic Heart Diseases", false, "CRITICAL");
        add("I20.9", "Angina pectoris, unspecified", "Circulatory System", "Ischemic Heart Diseases", true, "SEVERE");
        add("I21.09", "ST elevation (STEMI) myocardial infarction involving other anterior wall", "Circulatory System", "Ischemic Heart Diseases", false, "CRITICAL");
        add("I21.19", "ST elevation (STEMI) myocardial infarction involving other coronary artery of inferior wall", "Circulatory System", "Ischemic Heart Diseases", false, "CRITICAL");
        add("I21.3", "ST elevation (STEMI) myocardial infarction of unspecified site", "Circulatory System", "Ischemic Heart Diseases", false, "CRITICAL");
        add("I21.4", "Non-ST elevation (NSTEMI) myocardial infarction", "Circulatory System", "Ischemic Heart Diseases", false, "CRITICAL");
        add("I25.10", "Atherosclerotic heart disease of native coronary artery without angina pectoris", "Circulatory System", "Chronic Ischemic Heart Disease", true, "MODERATE");
        add("I25.110", "Atherosclerotic heart disease of native coronary artery with unstable angina pectoris", "Circulatory System", "Chronic Ischemic Heart Disease", true, "CRITICAL");
        add("I26.92", "Saddle embolus of pulmonary artery without acute cor pulmonale (Pulmonary Embolism)", "Circulatory System", "Pulmonary Heart Disease", false, "CRITICAL");
        add("I26.99", "Other pulmonary embolism without acute cor pulmonale", "Circulatory System", "Pulmonary Heart Disease", false, "CRITICAL");
        add("I30.9", "Acute pericarditis, unspecified", "Circulatory System", "Other Heart Diseases", false, "SEVERE");
        add("I33.0", "Acute and subacute infective endocarditis", "Circulatory System", "Other Heart Diseases", false, "CRITICAL");
        add("I42.0", "Dilated cardiomyopathy", "Circulatory System", "Cardiomyopathy", true, "SEVERE");
        add("I42.1", "Obstructive hypertrophic cardiomyopathy", "Circulatory System", "Cardiomyopathy", true, "SEVERE");
        add("I47.1", "Supraventricular tachycardia (SVT)", "Circulatory System", "Conduction Disorders & Arrhythmias", false, "SEVERE");
        add("I48.0", "Paroxysmal atrial fibrillation", "Circulatory System", "Conduction Disorders & Arrhythmias", true, "SEVERE");
        add("I48.2", "Chronic atrial fibrillation", "Circulatory System", "Conduction Disorders & Arrhythmias", true, "MODERATE");
        add("I48.91", "Unspecified atrial fibrillation", "Circulatory System", "Conduction Disorders & Arrhythmias", true, "MODERATE");
        add("I49.01", "Ventricular fibrillation", "Circulatory System", "Conduction Disorders & Arrhythmias", false, "CRITICAL");
        add("I49.02", "Ventricular flutter", "Circulatory System", "Conduction Disorders & Arrhythmias", false, "CRITICAL");
        add("I50.1", "Left ventricular failure, onset without mention of decompensation", "Circulatory System", "Heart Failure", true, "SEVERE");
        add("I50.20", "Unspecified systolic (congestive) heart failure", "Circulatory System", "Heart Failure", true, "SEVERE");
        add("I50.21", "Acute systolic (congestive) heart failure", "Circulatory System", "Heart Failure", false, "CRITICAL");
        add("I50.22", "Chronic systolic (congestive) heart failure", "Circulatory System", "Heart Failure", true, "SEVERE");
        add("I50.23", "Acute on chronic systolic (congestive) heart failure", "Circulatory System", "Heart Failure", false, "CRITICAL");
        add("I50.30", "Unspecified diastolic (congestive) heart failure", "Circulatory System", "Heart Failure", true, "SEVERE");
        add("I50.9", "Heart failure, unspecified", "Circulatory System", "Heart Failure", true, "SEVERE");
        add("I63.9", "Cerebral infarction, unspecified (Ischemic Stroke)", "Circulatory System", "Cerebrovascular Diseases", false, "CRITICAL");
        add("I61.9", "Nontraumatic intracerebral hemorrhage, unspecified", "Circulatory System", "Cerebrovascular Diseases", false, "CRITICAL");
        add("I67.9", "Cerebrovascular disease, unspecified", "Circulatory System", "Cerebrovascular Diseases", true, "SEVERE");
        add("I70.209", "Unspecified atherosclerosis of native arteries of extremities, unspecified extremity", "Circulatory System", "Arteries & Arterioles", true, "MODERATE");
        add("I73.9", "Peripheral vascular disease, unspecified", "Circulatory System", "Arteries & Arterioles", true, "MODERATE");
        add("I80.209", "Phlebitis and thrombophlebitis of unspecified deep vessels of unspecified lower extremity (DVT)", "Circulatory System", "Veins & Lymphatics", false, "SEVERE");

        // Chapter X: Diseases of the Respiratory System (J00-J99)
        add("J00", "Acute nasopharyngitis [common cold]", "Respiratory System", "Acute Upper Respiratory", false, "MILD");
        add("J01.90", "Acute sinusitis, unspecified", "Respiratory System", "Acute Upper Respiratory", false, "MILD");
        add("J02.0", "Streptococcal pharyngitis", "Respiratory System", "Acute Upper Respiratory", false, "MILD");
        add("J02.9", "Acute pharyngitis, unspecified", "Respiratory System", "Acute Upper Respiratory", false, "MILD");
        add("J03.90", "Acute tonsillitis, unspecified", "Respiratory System", "Acute Upper Respiratory", false, "MILD");
        add("J06.9", "Acute upper respiratory infection, unspecified", "Respiratory System", "Acute Upper Respiratory", false, "MILD");
        add("J12.89", "Other viral pneumonia (including COVID-19 related)", "Respiratory System", "Pneumonia", false, "SEVERE");
        add("J15.9", "Unspecified bacterial pneumonia", "Respiratory System", "Pneumonia", false, "SEVERE");
        add("J18.9", "Pneumonia, unspecified organism", "Respiratory System", "Pneumonia", false, "SEVERE");
        add("J20.9", "Acute bronchitis, unspecified", "Respiratory System", "Acute Lower Respiratory", false, "MILD");
        add("J44.0", "Chronic obstructive pulmonary disease with (acute) lower respiratory infection", "Respiratory System", "Chronic Lower Respiratory", true, "SEVERE");
        add("J44.1", "Chronic obstructive pulmonary disease with (acute) exacerbation", "Respiratory System", "Chronic Lower Respiratory", true, "SEVERE");
        add("J44.9", "Chronic obstructive pulmonary disease, unspecified (COPD)", "Respiratory System", "Chronic Lower Respiratory", true, "MODERATE");
        add("J45.20", "Mild intermittent asthma, uncomplicated", "Respiratory System", "Asthma", true, "MILD");
        add("J45.41", "Moderate persistent asthma with (acute) exacerbation", "Respiratory System", "Asthma", true, "SEVERE");
        add("J45.901", "Unspecified asthma with (acute) exacerbation", "Respiratory System", "Asthma", true, "SEVERE");
        add("J45.902", "Unspecified asthma with status asthmaticus", "Respiratory System", "Asthma", true, "CRITICAL");
        add("J80", "Acute respiratory distress syndrome (ARDS)", "Respiratory System", "Other Respiratory Diseases", false, "CRITICAL");
        add("J96.00", "Acute respiratory failure, unspecified whether with hypoxia or hypercapnia", "Respiratory System", "Respiratory Failure", false, "CRITICAL");

        // Chapter XI: Diseases of the Digestive System (K00-K95)
        add("K21.0", "Gastro-esophageal reflux disease with esophagitis (GERD)", "Digestive System", "Esophagus & Stomach", true, "MILD");
        add("K21.9", "Gastro-esophageal reflux disease without esophagitis", "Digestive System", "Esophagus & Stomach", true, "MILD");
        add("K25.0", "Acute gastric ulcer with hemorrhage", "Digestive System", "Peptic Ulcer", false, "CRITICAL");
        add("K25.9", "Gastric ulcer, unspecified as acute or chronic, without hemorrhage or perforation", "Digestive System", "Peptic Ulcer", true, "MODERATE");
        add("K29.70", "Gastritis, unspecified, without bleeding", "Digestive System", "Gastritis & Duodenitis", true, "MILD");
        add("K35.80", "Unspecified acute appendicitis", "Digestive System", "Appendicitis", false, "SEVERE");
        add("K35.2", "Acute appendicitis with generalized peritonitis", "Digestive System", "Appendicitis", false, "CRITICAL");
        add("K40.90", "Unilateral inguinal hernia, without obstruction or gangrene, not specified as recurrent", "Digestive System", "Hernia", true, "MODERATE");
        add("K50.90", "Crohn's disease, unspecified, without complications", "Digestive System", "Noninfective Enteritis", true, "MODERATE");
        add("K51.90", "Ulcerative colitis, unspecified, without complications", "Digestive System", "Noninfective Enteritis", true, "MODERATE");
        add("K56.60", "Unspecified intestinal obstruction", "Digestive System", "Intestinal Disorders", false, "CRITICAL");
        add("K57.92", "Diverticulitis of intestine, part unspecified, without perforation or abscess without bleeding", "Digestive System", "Diverticular Disease", false, "MODERATE");
        add("K58.0", "Irritable bowel syndrome with diarrhea (IBS-D)", "Digestive System", "Irritable Bowel Syndrome", true, "MILD");
        add("K70.30", "Alcoholic cirrhosis of liver without ascites", "Digestive System", "Hepatic Disorders", true, "SEVERE");
        add("K70.31", "Alcoholic cirrhosis of liver with ascites", "Digestive System", "Hepatic Disorders", true, "CRITICAL");
        add("K72.00", "Acute and subacute hepatic failure without coma", "Digestive System", "Hepatic Failure", false, "CRITICAL");
        add("K74.60", "Unspecified cirrhosis of liver", "Digestive System", "Hepatic Disorders", true, "SEVERE");
        add("K80.00", "Calculus of gallbladder with acute cholecystitis without obstruction (Gallstones)", "Digestive System", "Gallbladder & Biliary", false, "SEVERE");
        add("K80.20", "Calculus of gallbladder without cholecystitis without obstruction", "Digestive System", "Gallbladder & Biliary", true, "MODERATE");
        add("K85.90", "Acute pancreatitis, unspecified", "Digestive System", "Pancreas Disorders", false, "CRITICAL");
        add("K92.0", "Hematemesis (Vomiting blood)", "Digestive System", "Other Digestive Diseases", false, "CRITICAL");
        add("K92.1", "Melena (Blood in stool)", "Digestive System", "Other Digestive Diseases", false, "CRITICAL");

        // Chapter XIV: Diseases of the Genitourinary System (N00-N99)
        add("N10", "Acute pyelonephritis", "Genitourinary System", "Renal Tubulo-interstitial", false, "SEVERE");
        add("N17.9", "Acute kidney injury, unspecified (AKI)", "Genitourinary System", "Acute Kidney Failure", false, "CRITICAL");
        add("N18.1", "Chronic kidney disease, stage 1", "Genitourinary System", "Chronic Kidney Disease", true, "MILD");
        add("N18.2", "Chronic kidney disease, stage 2 (mild)", "Genitourinary System", "Chronic Kidney Disease", true, "MILD");
        add("N18.30", "Chronic kidney disease, stage 3 unspecified", "Genitourinary System", "Chronic Kidney Disease", true, "MODERATE");
        add("N18.4", "Chronic kidney disease, stage 4 (severe)", "Genitourinary System", "Chronic Kidney Disease", true, "SEVERE");
        add("N18.5", "Chronic kidney disease, stage 5 (ESRD requiring dialysis)", "Genitourinary System", "Chronic Kidney Disease", true, "CRITICAL");
        add("N18.6", "End stage renal disease (ESRD)", "Genitourinary System", "Chronic Kidney Disease", true, "CRITICAL");
        add("N20.0", "Calculus of kidney (Kidney Stones)", "Genitourinary System", "Urolithiasis", false, "SEVERE");
        add("N20.1", "Calculus of ureter", "Genitourinary System", "Urolithiasis", false, "SEVERE");
        add("N30.00", "Acute cystitis without hematuria", "Genitourinary System", "Bladder Disorders", false, "MILD");
        add("N39.0", "Urinary tract infection, site not specified (UTI)", "Genitourinary System", "Other Urinary Disorders", false, "MILD");
        add("N40.0", "Benign prostatic hyperplasia without lower urinary tract symptoms (BPH)", "Genitourinary System", "Male Genital Organs", true, "MILD");
        add("N40.1", "Benign prostatic hyperplasia with lower urinary tract symptoms", "Genitourinary System", "Male Genital Organs", true, "MODERATE");

        // Chapter XIX: Injury, poisoning and certain other consequences of external causes (S00-T88)
        add("S02.0XXA", "Fracture of vault of skull, initial encounter for closed fracture", "Injuries & Trauma", "Head Injuries", false, "CRITICAL");
        add("S06.0X0A", "Concussion without loss of consciousness, initial encounter", "Injuries & Trauma", "Head Injuries", false, "MODERATE");
        add("S06.0X1A", "Concussion with loss of consciousness of 30 minutes or less, initial encounter", "Injuries & Trauma", "Head Injuries", false, "SEVERE");
        add("S06.5X0A", "Traumatic subdural hemorrhage without loss of consciousness, initial encounter", "Injuries & Trauma", "Head Injuries", false, "CRITICAL");
        add("S22.31XA", "Fracture of one rib, right side, initial encounter for closed fracture", "Injuries & Trauma", "Thorax Injuries", false, "MODERATE");
        add("S72.001A", "Fracture of unspecified part of neck of right femur, initial encounter for closed fracture (Hip Fracture)", "Injuries & Trauma", "Femur & Hip Injuries", false, "SEVERE");
        add("S82.201A", "Unspecified fracture of shaft of right tibia, initial encounter for closed fracture", "Injuries & Trauma", "Lower Leg Injuries", false, "SEVERE");
        add("T78.00XA", "Anaphylactic reaction due to unspecified food, initial encounter", "Injuries & Trauma", "Allergic Reactions", false, "CRITICAL");
        add("T78.2XXA", "Anaphylactic shock, unspecified, initial encounter", "Injuries & Trauma", "Allergic Reactions", false, "CRITICAL");
        add("T88.7XXA", "Unspecified adverse effect of drug or medicament, initial encounter", "Injuries & Trauma", "Drug Adverse Effects", false, "SEVERE");
    }

    private static void add(String code, String desc, String chapter, String cat, boolean chronic, String severity) {
        ENTRIES.add(Icd10Entry.builder()
                .code(code)
                .description(desc)
                .chapter(chapter)
                .category(cat)
                .chronicCondition(chronic)
                .severityLevel(severity)
                .build());
    }

    public List<Icd10Entry> search(String query) {
        if (query == null || query.isBlank()) {
            return ENTRIES.subList(0, Math.min(ENTRIES.size(), 50));
        }
        String q = query.toLowerCase().trim();
        return ENTRIES.stream()
                .filter(e -> e.getCode().toLowerCase().contains(q) ||
                             e.getDescription().toLowerCase().contains(q) ||
                             e.getCategory().toLowerCase().contains(q))
                .limit(50)
                .collect(Collectors.toList());
    }

    public Optional<Icd10Entry> findByCode(String code) {
        return ENTRIES.stream()
                .filter(e -> e.getCode().equalsIgnoreCase(code))
                .findFirst();
    }
}
