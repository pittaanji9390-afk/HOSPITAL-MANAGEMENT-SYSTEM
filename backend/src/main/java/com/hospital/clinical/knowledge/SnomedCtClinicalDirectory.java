package com.hospital.clinical.knowledge;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Standard SNOMED CT (Systematized Nomenclature of Medicine -- Clinical Terms) Knowledge Base.
 * Covers Clinical Findings, Disorders, Procedures, Body Structures, and Organisms.
 */
@Component
public class SnomedCtClinicalDirectory {

    @Data
    @Builder
    public static class SnomedConcept {
        private String conceptId;
        private String fullySpecifiedName;
        private String preferredTerm;
        private String semanticTag; // disorder | finding | procedure | body structure | organism | substance
        private String parentConceptId;
        private boolean active;
    }

    private static final List<SnomedConcept> CONCEPTS = new ArrayList<>();

    static {
        // Cardiovascular Disorders & Findings
        add("38341003", "Hypertensive disorder, systemic arterial (disorder)", "Essential hypertension", "disorder", "64859006");
        add("22298006", "Myocardial infarction (disorder)", "Heart attack", "disorder", "414545008");
        add("401303003", "Acute ST segment elevation myocardial infarction (disorder)", "STEMI", "disorder", "22298006");
        add("401314000", "Acute non-ST segment elevation myocardial infarction (disorder)", "NSTEMI", "disorder", "22298006");
        add("42343007", "Congestive heart failure (disorder)", "CHF", "disorder", "84114007");
        add("49436004", "Atrial fibrillation (disorder)", "A-Fib", "disorder", "17366009");
        add("25569003", "Ventricular tachycardia (disorder)", "V-Tach", "disorder", "25569003");
        add("71908006", "Ventricular fibrillation (disorder)", "V-Fib", "disorder", "71908006");
        add("195080001", "Aortic valve stenosis (disorder)", "Aortic stenosis", "disorder", "60234000");
        add("48724000", "Mitral valve regurgitation (disorder)", "Mitral regurgitation", "disorder", "48724000");
        add("84114007", "Heart failure (disorder)", "Heart failure", "disorder", "56265001");
        add("230690007", "Stroke (disorder)", "Cerebrovascular accident", "disorder", "62914000");
        add("422504002", "Ischemic stroke (disorder)", "Ischemic stroke", "disorder", "230690007");
        add("274100004", "Hemorrhagic stroke (disorder)", "Brain hemorrhage", "disorder", "230690007");
        add("128053003", "Deep venous thrombosis (disorder)", "DVT", "disorder", "48867003");
        add("59282003", "Pulmonary embolism (disorder)", "PE", "disorder", "59282003");
        add("89138009", "Cardiogenic shock (disorder)", "Cardiogenic shock", "disorder", "27942005");
        add("423341008", "Atherosclerotic cardiovascular disease (disorder)", "ASCVD", "disorder", "399211009");
        add("29857009", "Chest pain (finding)", "Chest pain", "finding", "271681002");
        add("426396005", "Cardiac chest pain (finding)", "Angina pain", "finding", "29857009");
        add("80313002", "Palpitations (finding)", "Palpitations", "finding", "10601006");
        add("271863002", "Peripheral edema (finding)", "Pedal edema", "finding", "267038008");

        // Respiratory Disorders & Findings
        add("195967001", "Asthma (disorder)", "Bronchial asthma", "disorder", "195951007");
        add("13645005", "Chronic obstructive lung disease (disorder)", "COPD", "disorder", "195951007");
        add("233604007", "Pneumonia (disorder)", "Infective pneumonia", "disorder", "53084003");
        add("67782005", "Acute respiratory distress syndrome (disorder)", "ARDS", "disorder", "67782005");
        add("409622000", "Acute respiratory failure (disorder)", "Acute lung failure", "disorder", "409623005");
        add("233678006", "Pleural effusion (disorder)", "Fluid in lung", "disorder", "233678006");
        add("36118008", "Pneumothorax (disorder)", "Collapsed lung", "disorder", "36118008");
        add("267036007", "Dyspnea (finding)", "Shortness of breath", "finding", "267036007");
        add("49727002", "Cough (finding)", "Cough", "finding", "49727002");
        add("284523002", "Hemoptysis (finding)", "Coughing up blood", "finding", "49727002");
        add("386661006", "Fever (finding)", "Pyrexia", "finding", "386661006");
        add("40959006", "Stridor (finding)", "Stridor", "finding", "267036007");

        // Endocrine & Metabolic Disorders
        add("73211009", "Diabetes mellitus (disorder)", "Diabetes", "disorder", "362969004");
        add("46635009", "Type 1 diabetes mellitus (disorder)", "IDDM", "disorder", "73211009");
        add("44054006", "Type 2 diabetes mellitus (disorder)", "NIDDM", "disorder", "73211009");
        add("420422005", "Diabetic ketoacidosis (disorder)", "DKA", "disorder", "73211009");
        add("302866003", "Hyperosmolar hyperglycemic state (disorder)", "HHS", "disorder", "73211009");
        add("40930008", "Hypothyroidism (disorder)", "Underactive thyroid", "disorder", "362969004");
        add("34486009", "Hyperthyroidism (disorder)", "Thyrotoxicosis", "disorder", "362969004");
        add("414916001", "Obesity (disorder)", "Obesity", "disorder", "414915002");
        add("55822004", "Hyperlipidemia (disorder)", "High blood lipids", "disorder", "362969004");
        add("80394007", "Hyperkalemia (disorder)", "High serum potassium", "disorder", "80394007");
        add("43339006", "Hypokalemia (disorder)", "Low serum potassium", "disorder", "43339006");
        add("88810008", "Hyponatremia (disorder)", "Low serum sodium", "disorder", "88810008");
        add("10924008", "Metabolic acidosis (disorder)", "Acidosis", "disorder", "10924008");

        // Gastrointestinal & Hepatic
        add("235595009", "Gastroesophageal reflux disease (disorder)", "GERD", "disorder", "235595009");
        add("397825006", "Gastric ulcer (disorder)", "Stomach ulcer", "disorder", "397825006");
        add("85904008", "Acute appendicitis (disorder)", "Appendicitis", "disorder", "85904008");
        add("235856003", "Cholecystitis (disorder)", "Gallbladder inflammation", "disorder", "235856003");
        add("235447007", "Acute pancreatitis (disorder)", "Pancreatitis", "disorder", "235447007");
        add("19943007", "Cirrhosis of liver (disorder)", "Hepatic cirrhosis", "disorder", "19943007");
        add("235860002", "Hepatic failure (disorder)", "Liver failure", "disorder", "235860002");
        add("34014006", "Crohn's disease (disorder)", "Regional enteritis", "disorder", "34014006");
        add("64766004", "Ulcerative colitis (disorder)", "Colitis ulcerosa", "disorder", "64766004");
        add("260385009", "Gastrointestinal hemorrhage (disorder)", "GI bleed", "disorder", "260385009");

        // Renal & Genitourinary
        add("14669001", "Acute kidney injury (disorder)", "Acute renal failure", "disorder", "14669001");
        add("709044004", "Chronic kidney disease (disorder)", "CKD", "disorder", "709044004");
        add("46177005", "End-stage renal disease (disorder)", "ESRD", "disorder", "709044004");
        add("68566005", "Urinary tract infection (disorder)", "UTI", "disorder", "68566005");
        add("45816000", "Pyelonephritis (disorder)", "Kidney infection", "disorder", "45816000");
        add("95570007", "Kidney stone (disorder)", "Nephrolithiasis", "disorder", "95570007");

        // Infectious Diseases & Sepsis
        add("91302008", "Sepsis (disorder)", "Septicemia", "disorder", "91302008");
        add("76571007", "Septic shock (disorder)", "Septic shock", "disorder", "91302008");
        add("86406008", "Human immunodeficiency virus infection (disorder)", "HIV infection", "disorder", "86406008");
        add("56717001", "Tuberculosis (disorder)", "TB", "disorder", "56717001");
        add("840539006", "COVID-19 (disorder)", "Coronavirus disease 2019", "disorder", "840539006");
        add("6142004", "Influenza (disorder)", "Flu", "disorder", "6142004");
        add("240532009", "Cellulitis (disorder)", "Bacterial skin infection", "disorder", "240532009");

        // Surgical & Interventional Procedures
        add("232717009", "Coronary artery bypass graft (procedure)", "CABG surgery", "procedure", "232717009");
        add("415070008", "Percutaneous coronary intervention (procedure)", "PCI / Stenting", "procedure", "415070008");
        add("80146002", "Appendectomy (procedure)", "Removal of appendix", "procedure", "80146002");
        add("38102005", "Cholecystectomy (procedure)", "Removal of gallbladder", "procedure", "38102005");
        add("52734007", "Total knee arthroplasty (procedure)", "Knee replacement", "procedure", "52734007");
        add("59711009", "Total hip arthroplasty (procedure)", "Hip replacement", "procedure", "59711009");
        add("71388002", "Endotracheal intubation (procedure)", "Airway intubation", "procedure", "71388002");
        add("10849003", "Hemodialysis (procedure)", "Renal dialysis", "procedure", "10849003");
        add("116783008", "Cardiopulmonary resuscitation (procedure)", "CPR", "procedure", "116783008");
        add("392021009", "Lumbar puncture (procedure)", "Spinal tap", "procedure", "392021009");
        add("277132007", "Blood transfusion (procedure)", "Transfusion", "procedure", "277132007");
        add("73761001", "Colonoscopy (procedure)", "Colon examination", "procedure", "73761001");
        add("44491008", "Upper gastrointestinal endoscopy (procedure)", "Esophagogastroduodenoscopy (EGD)", "procedure", "44491008");
    }

    private static void add(String id, String fsn, String pt, String tag, String parent) {
        CONCEPTS.add(SnomedConcept.builder()
                .conceptId(id)
                .fullySpecifiedName(fsn)
                .preferredTerm(pt)
                .semanticTag(tag)
                .parentConceptId(parent)
                .active(true)
                .build());
    }

    public List<SnomedConcept> search(String query) {
        if (query == null || query.isBlank()) {
            return CONCEPTS;
        }
        String q = query.toLowerCase().trim();
        return CONCEPTS.stream()
                .filter(c -> c.getConceptId().contains(q) ||
                             c.getPreferredTerm().toLowerCase().contains(q) ||
                             c.getFullySpecifiedName().toLowerCase().contains(q) ||
                             c.getSemanticTag().toLowerCase().contains(q))
                .limit(50)
                .collect(Collectors.toList());
    }

    public Optional<SnomedConcept> findByConceptId(String conceptId) {
        return CONCEPTS.stream()
                .filter(c -> c.getConceptId().equals(conceptId))
                .findFirst();
    }
}
