package com.hospital.clinical.knowledge;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Clinical Decision Support System (CDSS) - Drug-Drug Interaction and Contraindication Matrix.
 * Operates offline deterministically without third-party API dependencies.
 */
@Component
public class DrugInteractionEngine {

    public enum Severity {
        CONTRAINDICATED, // Absolute contraindication - DO NOT CO-ADMINISTER
        MAJOR,           // Significant clinical hazard; requires alternative or intense monitoring
        MODERATE,        // Potential clinical deterioration; dose titration or lab monitoring needed
        MINOR            // Minor or theoretical interaction
    }

    @Data
    @Builder
    public static class DrugInteraction {
        private String drugA;
        private String drugB;
        private Severity severity;
        private String mechanism;
        private String clinicalEffect;
        private String managementAdvice;
    }

    private static final List<DrugInteraction> INTERACTIONS = new ArrayList<>();

    static {
        // Anticoagulants & NSAIDs / Antiplatelets
        add("Warfarin", "Aspirin", Severity.MAJOR,
                "Additive inhibition of platelet aggregation and coagulation cascade factors.",
                "Substantially increased risk of major gastrointestinal and intracerebral hemorrhage.",
                "Avoid concomitant use unless indicated for specific cardiovascular conditions (e.g. mechanical heart valve). Monitor INR closely.");

        add("Warfarin", "Ibuprofen", Severity.MAJOR,
                "NSAID-induced gastric mucosal erosion combined with vitamin K antagonism.",
                "Severe gastrointestinal bleeding and elevated PT/INR.",
                "Use acetaminophen/paracetamol as an alternative analgesic. If NSAID essential, co-prescribe PPI.");

        add("Clopidogrel", "Omeprazole", Severity.MAJOR,
                "CYP2C19 competitive inhibition prevents conversion of clopidogrel to its active metabolite.",
                "Reduced antiplatelet efficacy leading to increased risk of stent thrombosis and ischemic stroke.",
                "Switch PPI to pantoprazole or rabeprazole which exert minimal CYP2C19 inhibition.");

        add("Warfarin", "Ciprofloxacin", Severity.MAJOR,
                "Inhibition of CYP1A2 and CYP3A4 metabolism of warfarin isomers + reduction in gut vitamin K flora.",
                "Acute prolongation of INR, severe bleeding diathesis.",
                "Reduce warfarin dose by 30-50% during fluoroquinolone therapy and monitor INR at 48 hours.");

        // Renin-Angiotensin-Aldosterone System (RAAS) Interactions
        add("Lisinopril", "Spironolactone", Severity.MAJOR,
                "Additive potassium-sparing effect through aldosterone inhibition and ACE blockade.",
                "Severe hyperkalemia (> 6.0 mmol/L), cardiac conduction blocks, ventricular arrhythmias.",
                "Check serum potassium and creatinine at baseline and 1 week after starting combination.");

        add("Telmisartan", "Spironolactone", Severity.MAJOR,
                "Additive blockade of aldosterone-induced renal potassium excretion.",
                "Severe hyperkalemia, cardiac arrest risk.",
                "Monitor serum potassium. Advise low-potassium diet and avoid potassium supplements.");

        add("Enalapril", "Potassium Chloride", Severity.CONTRAINDICATED,
                "Direct potassium supplementation with impaired renal potassium excretion from ACE inhibition.",
                "Life-threatening hyperkalemia.",
                "Contraindicated unless severe refractory hypokalemia under close ICU telemetry.");

        add("Lisinopril", "Ibuprofen", Severity.MODERATE,
                "NSAID inhibits renal vasodilatory prostaglandins, blunting antihypertensive efficacy and reducing GFR.",
                "Loss of blood pressure control and precipitation of acute kidney injury (triple whammy).",
                "Monitor blood pressure and renal function. Avoid prolonged NSAID therapy in hypertensive patients.");

        // Cardiac Glycosides & Antiarrhythmics
        add("Digoxin", "Amiodarone", Severity.MAJOR,
                "Amiodarone inhibits P-glycoprotein efflux transport of digoxin, doubling serum digoxin concentrations.",
                "Digoxin toxicity (nausea, yellow-green visual halos, lethal bradyarrhythmias/heart block).",
                "Reduce digoxin maintenance dose by 50% when initiating amiodarone. Measure serum digoxin level.");

        add("Digoxin", "Verapamil", Severity.MAJOR,
                "Verapamil decreases renal and non-renal clearance of digoxin and exerts additive AV-nodal blockade.",
                "Profound bradycardia, complete heart block, and digoxin toxicity.",
                "Reduce digoxin dose by 30-50%. Monitor ECG and serum digoxin levels.");

        // Statins & Antimicrobial CYP3A4 Inhibitors
        add("Simvastatin", "Clarithromycin", Severity.CONTRAINDICATED,
                "Clarithromycin strongly inhibits hepatic CYP3A4, increasing simvastatin AUC by up to 10-fold.",
                "Severe rhabdomyolysis, myoglobinuric acute renal failure, and hepatotoxicity.",
                "Temporarily suspend simvastatin during macrolide antibiotic course, or use azithromycin.");

        add("Atorvastatin", "Clarithromycin", Severity.MAJOR,
                "Potent CYP3A4 inhibition elevates plasma atorvastatin exposure.",
                "Myalgia, elevated serum creatine kinase (CK), rhabdomyolysis.",
                "Limit atorvastatin dose to maximum 20mg daily or switch antibiotic.");

        add("Simvastatin", "Amiodarone", Severity.MAJOR,
                "CYP3A4 inhibition elevates simvastatin levels.",
                "Increased risk of myopathy and rhabdomyolysis.",
                "Do not exceed simvastatin 20mg daily when co-administered with amiodarone.");

        // QT Prolongation Combinations
        add("Amiodarone", "Levofloxacin", Severity.CONTRAINDICATED,
                "Additive delay in cardiac ventricular repolarization (hERG potassium channel blockade).",
                "Marked QT interval prolongation, Torsades de Pointes, and sudden cardiac arrest.",
                "Avoid combination. If antibiotic necessary, select beta-lactam or alternative without QT liability.");

        add("Ondansetron", "Ciprofloxacin", Severity.MODERATE,
                "Additive cardiac repolarization delay.",
                "QTc prolongation risk.",
                "Monitor baseline ECG QTc in patients with underlying cardiac history or electrolyte disturbances.");

        // Central Nervous System & Serotonin Syndrome
        add("Tramadol", "Sertraline", Severity.MAJOR,
                "Combined serotonergic neurotransmission enhancement and inhibition of serotonin reuptake.",
                "Serotonin Syndrome (hyperthermia, clonus, autonomic instability, delirium, seizures).",
                "Avoid combination or monitor closely for early symptoms of serotonin toxicity.");

        add("Linezolid", "Fluoxetine", Severity.CONTRAINDICATED,
                "Linezolid is a reversible, non-selective MAO inhibitor combined with an SSRI.",
                "Severe, potentially fatal Serotonin Syndrome.",
                "Linezolid should not be administered to patients taking SSRIs unless psychiatric washout observed.");

        // Diabetes & Beta-Blockers
        add("Metoprolol", "Insulin Glargine", Severity.MODERATE,
                "Beta-2 blockade masks adrenergic hypoglycemic warning signs (tremor, tachycardia, diaphoresis).",
                "Unrecognized severe hypoglycemia.",
                "Educate patient that sweating may be the only remaining sign of hypoglycemia.");

        // Methotrexate & NSAIDs
        add("Methotrexate", "Naproxen", Severity.MAJOR,
                "NSAIDs reduce renal blood flow and compete for organic anion renal tubular secretion of methotrexate.",
                "Accumulation of toxic methotrexate levels, bone marrow suppression, severe mucositis, pancytopenia.",
                "Avoid NSAIDs with high-dose methotrexate. Monitor CBC and liver enzymes with low-dose regimens.");
    }

    private static void add(String a, String b, Severity sev, String mech, String eff, String adv) {
        INTERACTIONS.add(DrugInteraction.builder()
                .drugA(a)
                .drugB(b)
                .severity(sev)
                .mechanism(mech)
                .clinicalEffect(eff)
                .managementAdvice(adv)
                .build());
    }

    /**
     * Evaluates all pair-wise drug interactions across a list of prescribed generic medication names.
     */
    public List<DrugInteraction> checkInteractions(List<String> genericDrugNames) {
        if (genericDrugNames == null || genericDrugNames.size() < 2) {
            return Collections.emptyList();
        }

        List<DrugInteraction> detected = new ArrayList<>();
        List<String> normalized = genericDrugNames.stream()
                .map(String::toLowerCase)
                .map(String::trim)
                .toList();

        for (int i = 0; i < normalized.size(); i++) {
            for (int j = i + 1; j < normalized.size(); j++) {
                String drug1 = normalized.get(i);
                String drug2 = normalized.get(j);

                for (DrugInteraction rule : INTERACTIONS) {
                    boolean matchDirect = rule.getDrugA().equalsIgnoreCase(drug1) && rule.getDrugB().equalsIgnoreCase(drug2);
                    boolean matchReverse = rule.getDrugA().equalsIgnoreCase(drug2) && rule.getDrugB().equalsIgnoreCase(drug1);

                    if (matchDirect || matchReverse) {
                        detected.add(rule);
                    }
                }
            }
        }
        return detected;
    }
}
