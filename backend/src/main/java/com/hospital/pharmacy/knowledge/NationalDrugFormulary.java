package com.hospital.pharmacy.knowledge;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * National & International Pharmaceutical Formulary & Pharmacopeia Master.
 * Comprehensive directory of approved pharmaceutical entities with ATC codes,
 * standard routes, renal dose adjustments, hepatic considerations, and pregnancy safety categories.
 */
@Component
public class NationalDrugFormulary {

    @Data
    @Builder
    public static class DrugProduct {
        private String ndcOrCode;
        private String genericName;
        private String brandName;
        private String atcCode; // WHO Anatomical Therapeutic Chemical code
        private String therapeuticClass;
        private String dosageForm; // TABLET, CAPSULE, INJECTION, SYRUP, OINTMENT, INHALER
        private String strength;
        private String route; // ORAL, INTRAVENOUS, INTRAMUSCULAR, SUBCUTANEOUS, INHALATION, TOPICAL
        private String pregnancyCategory; // A, B, C, D, X
        private String renalAdjustmentGuideline;
        private String hepaticDosingAdvice;
        private boolean highAlertMedication;
        private boolean controlledSubstance;
    }

    private static final List<DrugProduct> DRUGS = new ArrayList<>();

    static {
        // Cardiovascular & Antihypertensives (ATC: C)
        add("NDC-0078-0495", "Telmisartan", "Micardis / Telma", "C09CA07", "Angiotensin II Receptor Antagonist (ARB)", "TABLET", "40mg", "ORAL", "D", "No initial dosage adjustment needed in mild-to-moderate renal impairment.", "Administer with caution in biliary obstructive disorders and severe hepatic impairment.", false, false);
        add("NDC-0078-0496", "Telmisartan", "Micardis / Telma", "C09CA07", "Angiotensin II Receptor Antagonist (ARB)", "TABLET", "80mg", "ORAL", "D", "No initial dosage adjustment needed.", "Avoid in severe hepatic impairment.", false, false);
        add("NDC-0069-3150", "Amlodipine Besylate", "Norvasc / Amlong", "C08CA01", "Calcium Channel Blocker (Dihydropyridine)", "TABLET", "5mg", "ORAL", "C", "No dosage adjustment required.", "Titrate slowly; initial dose 2.5 mg in severe hepatic impairment.", false, false);
        add("NDC-0069-3160", "Amlodipine Besylate", "Norvasc / Amlong", "C08CA01", "Calcium Channel Blocker (Dihydropyridine)", "TABLET", "10mg", "ORAL", "C", "No dosage adjustment required.", "Monitor blood pressure closely.", false, false);
        add("NDC-0071-0155", "Atorvastatin Calcium", "Lipitor / Atorva", "C10AA05", "HMG-CoA Reductase Inhibitor (Statin)", "TABLET", "20mg", "ORAL", "X", "No dosage adjustment required.", "Contraindicated in active liver disease or unexplained persistent transaminase elevations.", false, false);
        add("NDC-0071-0156", "Atorvastatin Calcium", "Lipitor / Atorva", "C10AA05", "HMG-CoA Reductase Inhibitor (Statin)", "TABLET", "40mg", "ORAL", "X", "No dosage adjustment required.", "Contraindicated in active liver disease.", false, false);
        add("NDC-0071-0157", "Atorvastatin Calcium", "Lipitor / Atorva", "C10AA05", "HMG-CoA Reductase Inhibitor (Statin)", "TABLET", "80mg", "ORAL", "X", "No dosage adjustment required.", "Contraindicated in active liver disease.", false, false);
        add("NDC-0002-3228", "Metoprolol Succinate", "Toprol-XL / Betaloc", "C07AB02", "Beta-1 Selective Adrenergic Blocker", "TABLET", "50mg", "ORAL", "C", "No dosage adjustment necessary.", "Initiate with lower doses and titrate slowly in severe hepatic failure.", false, false);
        add("NDC-0002-3229", "Metoprolol Succinate", "Toprol-XL / Betaloc", "C07AB02", "Beta-1 Selective Adrenergic Blocker", "TABLET", "25mg", "ORAL", "C", "No dosage adjustment necessary.", "Monitor resting heart rate.", false, false);
        add("NDC-0006-0030", "Enalapril Maleate", "Vasotec / Enam", "C09AA02", "ACE Inhibitor", "TABLET", "5mg", "ORAL", "D", "CrCl < 30 mL/min: Reduce starting dose to 2.5 mg daily.", "Monitor transaminases.", false, false);
        add("NDC-0025-1870", "Spironolactone", "Aldactone", "C03DA01", "Aldosterone Receptor Antagonist (Potassium-Sparing)", "TABLET", "25mg", "ORAL", "C", "CrCl < 30 mL/min: Contraindicated due to fatal hyperkalemia risk.", "Use with caution in severe cirrhosis.", false, false);
        add("NDC-0002-4165", "Furosemide", "Lasix", "C03CA01", "High-Ceiling Loop Diuretic", "INJECTION", "20mg/2mL", "INTRAVENOUS", "C", "Higher doses may be required in severe renal failure to achieve diuresis.", "Monitor fluid/electrolyte balance in cirrhosis with ascites.", false, false);
        add("NDC-0002-4166", "Furosemide", "Lasix", "C03CA01", "High-Ceiling Loop Diuretic", "TABLET", "40mg", "ORAL", "C", "Titrate dose based on 24-hr urine output.", "Monitor for hypokalemia.", false, false);

        // Anti-Infectives & Antibiotics (ATC: J)
        add("NDC-0029-6086", "Amoxicillin + Clavulanate Potassium", "Augmentin 625 Duo", "J01CR02", "Beta-Lactam + Beta-Lactamase Inhibitor", "TABLET", "625mg", "ORAL", "B", "GFR 10-30 mL/min: 625mg q12h; GFR < 10: 625mg q24h.", "Monitor liver function; rare cholestatic jaundice.", false, false);
        add("NDC-0029-6087", "Amoxicillin + Clavulanate Potassium", "Augmentin 1.2g", "J01CR02", "Beta-Lactam + Beta-Lactamase Inhibitor", "INJECTION", "1.2g", "INTRAVENOUS", "B", "GFR 10-30 mL/min: 1.2g stat then 600mg q12h; GFR < 10: 1.2g stat then 600mg q24h.", "Monitor hepatic enzymes.", false, false);
        add("NDC-0009-0056", "Ceftriaxone Sodium", "Rocephin / Monocef", "J01DD04", "Third-Generation Cephalosporin", "INJECTION", "1.0g", "INTRAVENOUS", "B", "No adjustment needed unless combined severe renal and hepatic dysfunction (max 2g/day).", "No dosage adjustment needed.", false, false);
        add("NDC-0009-0057", "Ceftriaxone Sodium", "Rocephin / Monocef", "J01DD04", "Third-Generation Cephalosporin", "INJECTION", "2.0g", "INTRAVENOUS", "B", "No adjustment needed for renal impairment alone.", "Standard dosing.", false, false);
        add("NDC-0002-7510", "Vancomycin Hydrochloride", "Vancocin", "J01XA01", "Glycopeptide Antibacterial", "INJECTION", "1.0g", "INTRAVENOUS", "C", "Mandatory trough concentration monitoring (Target 15-20 mcg/mL in severe infections). Adjust interval based on CrCl.", "No hepatic adjustment required.", true, false);
        add("NDC-0002-7511", "Piperacillin + Tazobactam", "Zosyn / Pipzo", "J01CR05", "Antipseudomonal Penicillin + Inhibitor", "INJECTION", "4.5g", "INTRAVENOUS", "B", "CrCl 20-50 mL/min: 3.375g q6h; CrCl < 20: 2.25g q6h; Hemodialysis: 2.25g q8h + 0.75g post-HD.", "No hepatic adjustment needed.", false, false);
        add("NDC-0049-3960", "Meropenem", "Merrem", "J01DH02", "Carbapenem Antibiotic", "INJECTION", "1.0g", "INTRAVENOUS", "B", "CrCl 26-50 mL/min: 1.0g q12h; CrCl 10-25: 500mg q12h; CrCl < 10: 500mg q24h.", "No adjustment needed.", false, false);
        add("NDC-0085-1110", "Azithromycin", "Zithromax / Azithral", "J01FA10", "Macrolide Antibacterial", "TABLET", "500mg", "ORAL", "B", "No adjustment needed in mild-moderate renal impairment; caution if CrCl < 10.", "Use caution in biliary impairment.", false, false);
        add("NDC-0085-1111", "Ciprofloxacin Hydrochloride", "Cipro / Ciplox", "J01MA02", "Fluoroquinolone Antibacterial", "TABLET", "500mg", "ORAL", "C", "CrCl 30-50 mL/min: 250-500mg q12h; CrCl < 30: 250-500mg q18-24h.", "No hepatic adjustment required.", false, false);

        // Analgesics, Anesthetics & Antipyretics (ATC: N)
        add("NDC-50458-511", "Paracetamol (Acetaminophen)", "Tylenol / Dolo 650", "N02BE01", "Anilide Analgesic & Antipyretic", "TABLET", "650mg", "ORAL", "B", "CrCl < 50 mL/min: Increase dosing interval to q6-8h.", "Max dose 2000 mg/day in chronic liver disease or alcoholism. Severe hepatotoxicity in overdose.", false, false);
        add("NDC-50458-512", "Paracetamol IV", "Ofirmev / Paracip IV", "N02BE01", "Anilide Analgesic & Antipyretic", "INJECTION", "1000mg/100mL", "INTRAVENOUS", "B", "CrCl <= 30 mL/min: Minimum 6-hour interval.", "Contraindicated in severe active hepatic failure.", false, false);
        add("NDC-0074-3211", "Tramadol Hydrochloride", "Ultram", "N02AX02", "Synthetic Opioid Analgesic", "TABLET", "50mg", "ORAL", "C", "CrCl < 30 mL/min: Max 100 mg/day; interval q12h.", "Cirrhosis: 50 mg q12h maximum.", true, true);
        add("NDC-0074-3212", "Morphine Sulfate", "Duramorph", "N02AA01", "Natural Opium Alkaloid", "INJECTION", "10mg/mL", "INTRAVENOUS", "C", "CrCl 15-50 mL/min: Administer 75% of dose; CrCl < 15: Administer 50% of dose (Active M6G metabolite accumulation).", "Reduce dose and extend interval in hepatic impairment.", true, true);
        add("NDC-0074-3213", "Fentanyl Citrate", "Sublimaze", "N01AH01", "Potent Synthetic Opioid Anesthetic", "INJECTION", "100mcg/2mL", "INTRAVENOUS", "C", "No active metabolites; preferred in acute renal failure over morphine.", "Clearance may be reduced in severe cirrhosis.", true, true);
        add("NDC-0074-3214", "Propofol", "Diprivan", "N01AX10", "General Anesthetic / Sedative", "INJECTION", "10mg/mL (1%)", "INTRAVENOUS", "B", "No renal dosage adjustment required.", "Use with caution in hepatic failure.", true, false);

        // Antidiabetic Agents (ATC: A10)
        add("NDC-0087-6060", "Metformin Hydrochloride", "Glucophage / Glycomet", "A10BA02", "Biguanide Antihyperglycemic", "TABLET", "500mg", "ORAL", "B", "eGFR 30-45 mL/min: Max 1000 mg/day; eGFR < 30: Contraindicated (Lactic Acidosis risk).", "Avoid in severe hepatic impairment.", false, false);
        add("NDC-0087-6070", "Metformin Hydrochloride", "Glucophage / Glycomet", "A10BA02", "Biguanide Antihyperglycemic", "TABLET", "850mg", "ORAL", "B", "Contraindicated if eGFR < 30 mL/min.", "Avoid in severe hepatic impairment.", false, false);
        add("NDC-0024-5850", "Insulin Glargine", "Lantus / Basalog", "A10AE04", "Long-Acting Recombinant Human Insulin", "INJECTION", "100 units/mL", "SUBCUTANEOUS", "C", "Insulin clearance is decreased in renal failure; monitor blood glucose and reduce dose if needed.", "Frequent glucose monitoring required.", true, false);
        add("NDC-0002-7512", "Empagliflozin", "Jardiance", "A10BK03", "SGLT2 Inhibitor", "TABLET", "10mg", "ORAL", "C", "eGFR 20-45 mL/min: 10mg daily for kidney protection; eGFR < 20: Initiation not recommended.", "No adjustment in mild-moderate hepatic impairment.", false, false);
        add("NDC-0002-7513", "Empagliflozin", "Jardiance", "A10BK03", "SGLT2 Inhibitor", "TABLET", "25mg", "ORAL", "C", "Not recommended if eGFR < 45 mL/min for glycemic control.", "No adjustment needed.", false, false);
    }

    private static void add(String code, String gen, String br, String atc, String cls, String form, String str,
                            String route, String preg, String renal, String hep, boolean highAlert, boolean ctrl) {
        DRUGS.add(DrugProduct.builder()
                .ndcOrCode(code)
                .genericName(gen)
                .brandName(br)
                .atcCode(atc)
                .therapeuticClass(cls)
                .dosageForm(form)
                .strength(str)
                .route(route)
                .pregnancyCategory(preg)
                .renalAdjustmentGuideline(renal)
                .hepaticDosingAdvice(hep)
                .highAlertMedication(highAlert)
                .controlledSubstance(ctrl)
                .build());
    }

    public List<DrugProduct> search(String query) {
        if (query == null || query.isBlank()) {
            return DRUGS;
        }
        String q = query.toLowerCase().trim();
        return DRUGS.stream()
                .filter(d -> d.getGenericName().toLowerCase().contains(q) ||
                             d.getBrandName().toLowerCase().contains(q) ||
                             d.getAtcCode().toLowerCase().contains(q) ||
                             d.getTherapeuticClass().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }

    public Optional<DrugProduct> findByCode(String code) {
        return DRUGS.stream()
                .filter(d -> d.getNdcOrCode().equalsIgnoreCase(code))
                .findFirst();
    }
}
