-- ==============================================================================
-- Flyway Database Migration: V6__national_drug_formulary_atc_catalog.sql
-- Description: National Drug Formulary, WHO ATC Codes, and Pharmacy Inventory
-- ==============================================================================

CREATE TABLE IF NOT EXISTS national_drug_products (
    id BIGSERIAL PRIMARY KEY,
    ndc_code VARCHAR(32) NOT NULL UNIQUE,
    generic_name VARCHAR(255) NOT NULL,
    brand_name VARCHAR(255) NOT NULL,
    atc_code VARCHAR(16) NOT NULL,
    therapeutic_class VARCHAR(128) NOT NULL,
    dosage_form VARCHAR(64) NOT NULL,
    strength VARCHAR(64) NOT NULL,
    route VARCHAR(64) NOT NULL,
    pregnancy_category VARCHAR(8) NOT NULL,
    renal_guideline TEXT,
    hepatic_guideline TEXT,
    high_alert BOOLEAN NOT NULL DEFAULT false,
    controlled_substance BOOLEAN NOT NULL DEFAULT false,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT NOW()
);

CREATE INDEX IF NOT EXISTS idx_ndc_code ON national_drug_products(ndc_code);
CREATE INDEX IF NOT EXISTS idx_atc_code ON national_drug_products(atc_code);
CREATE INDEX IF NOT EXISTS idx_generic_name ON national_drug_products(generic_name);

INSERT INTO national_drug_products (ndc_code, generic_name, brand_name, atc_code, therapeutic_class, dosage_form, strength, route, pregnancy_category, renal_guideline, hepatic_guideline, high_alert, controlled_substance) VALUES
('NDC-0078-0495', 'Telmisartan', 'Telma 40', 'C09CA07', 'Angiotensin II Receptor Antagonist', 'TABLET', '40mg', 'ORAL', 'D', 'No initial dosage adjustment required in mild-to-moderate renal impairment.', 'Caution in biliary obstructive disorders.', false, false),
('NDC-0078-0496', 'Telmisartan', 'Telma 80', 'C09CA07', 'Angiotensin II Receptor Antagonist', 'TABLET', '80mg', 'ORAL', 'D', 'No initial dosage adjustment required.', 'Avoid in severe hepatic failure.', false, false),
('NDC-0069-3150', 'Amlodipine Besylate', 'Norvasc 5', 'C08CA01', 'Dihydropyridine Calcium Channel Blocker', 'TABLET', '5mg', 'ORAL', 'C', 'No dosage adjustment required.', 'Start with 2.5 mg daily in hepatic dysfunction.', false, false),
('NDC-0069-3160', 'Amlodipine Besylate', 'Norvasc 10', 'C08CA01', 'Dihydropyridine Calcium Channel Blocker', 'TABLET', '10mg', 'ORAL', 'C', 'No dosage adjustment required.', 'Monitor blood pressure.', false, false),
('NDC-0071-0155', 'Atorvastatin Calcium', 'Atorva 20', 'C10AA05', 'HMG-CoA Reductase Inhibitor', 'TABLET', '20mg', 'ORAL', 'X', 'No dosage adjustment required.', 'Contraindicated in active liver disease or transaminases > 3x ULN.', false, false),
('NDC-0071-0156', 'Atorvastatin Calcium', 'Atorva 40', 'C10AA05', 'HMG-CoA Reductase Inhibitor', 'TABLET', '40mg', 'ORAL', 'X', 'No dosage adjustment required.', 'Contraindicated in active liver disease.', false, false),
('NDC-0071-0157', 'Atorvastatin Calcium', 'Atorva 80', 'C10AA05', 'HMG-CoA Reductase Inhibitor', 'TABLET', '80mg', 'ORAL', 'X', 'No dosage adjustment required.', 'Contraindicated in active liver disease.', false, false),
('NDC-0002-3228', 'Metoprolol Succinate', 'Betaloc 50', 'C07AB02', 'Beta-1 Selective Adrenergic Blocker', 'TABLET', '50mg', 'ORAL', 'C', 'No dosage adjustment required.', 'Titrate slowly in cirrhosis.', false, false),
('NDC-0029-6086', 'Amoxicillin + Clavulanate', 'Augmentin 625', 'J01CR02', 'Beta-Lactam + Beta-Lactamase Inhibitor', 'TABLET', '625mg', 'ORAL', 'B', 'GFR 10-30: 625mg q12h; GFR < 10: 625mg q24h.', 'Monitor liver function.', false, false),
('NDC-0029-6087', 'Amoxicillin + Clavulanate IV', 'Augmentin 1.2g IV', 'J01CR02', 'Beta-Lactam + Beta-Lactamase Inhibitor', 'INJECTION', '1.2g', 'INTRAVENOUS', 'B', 'Adjust interval in renal failure.', 'Monitor hepatic transaminases.', false, false),
('NDC-0009-0056', 'Ceftriaxone Sodium', 'Monocef 1g', 'J01DD04', 'Third-Generation Cephalosporin', 'INJECTION', '1.0g', 'INTRAVENOUS', 'B', 'No adjustment required for renal impairment alone.', 'No dosage adjustment needed.', false, false),
('NDC-0009-0057', 'Ceftriaxone Sodium', 'Monocef 2g', 'J01DD04', 'Third-Generation Cephalosporin', 'INJECTION', '2.0g', 'INTRAVENOUS', 'B', 'No adjustment required.', 'Standard dosing.', false, false),
('NDC-0002-7510', 'Vancomycin Hydrochloride', 'Vancocin 1g', 'J01XA01', 'Glycopeptide Antibacterial', 'INJECTION', '1.0g', 'INTRAVENOUS', 'C', 'Mandatory trough concentration monitoring (Target 15-20 mcg/mL).', 'No hepatic adjustment required.', true, false),
('NDC-0002-7511', 'Piperacillin + Tazobactam', 'Pipzo 4.5g', 'J01CR05', 'Antipseudomonal Penicillin + Inhibitor', 'INJECTION', '4.5g', 'INTRAVENOUS', 'B', 'CrCl 20-50: 3.375g q6h; CrCl < 20: 2.25g q6h.', 'No hepatic adjustment needed.', false, false),
('NDC-0049-3960', 'Meropenem', 'Meronem 1g', 'J01DH02', 'Carbapenem Antibiotic', 'INJECTION', '1.0g', 'INTRAVENOUS', 'B', 'CrCl 26-50: 1g q12h; CrCl 10-25: 500mg q12h; CrCl < 10: 500mg q24h.', 'No adjustment needed.', false, false),
('NDC-50458-511', 'Paracetamol (Acetaminophen)', 'Dolo 650', 'N02BE01', 'Anilide Analgesic & Antipyretic', 'TABLET', '650mg', 'ORAL', 'B', 'CrCl < 50: Increase dosing interval to q6-8h.', 'Max dose 2000 mg/day in chronic liver disease. Hepatotoxic in overdose.', false, false),
('NDC-50458-512', 'Paracetamol IV', 'Paracip IV 1g', 'N02BE01', 'Anilide Analgesic & Antipyretic', 'INJECTION', '1000mg/100mL', 'INTRAVENOUS', 'B', 'CrCl <= 30: Minimum 6-hr interval.', 'Contraindicated in severe hepatic failure.', false, false),
('NDC-0074-3211', 'Tramadol Hydrochloride', 'Tramazac 50', 'N02AX02', 'Synthetic Opioid Analgesic', 'TABLET', '50mg', 'ORAL', 'C', 'CrCl < 30: Max 100 mg/day; interval q12h.', 'Cirrhosis: 50 mg q12h maximum.', true, true),
('NDC-0074-3212', 'Morphine Sulfate', 'Morcontin 10', 'N02AA01', 'Natural Opioid Alkaloid', 'INJECTION', '10mg/mL', 'INTRAVENOUS', 'C', 'Reduce dose in renal failure (M6G accumulation).', 'Reduce dose and extend interval in cirrhosis.', true, true),
('NDC-0087-6060', 'Metformin Hydrochloride', 'Glycomet 500', 'A10BA02', 'Biguanide Antihyperglycemic', 'TABLET', '500mg', 'ORAL', 'B', 'eGFR 30-45: Max 1000 mg/day; eGFR < 30: Contraindicated.', 'Avoid in severe hepatic impairment.', false, false),
('NDC-0024-5850', 'Insulin Glargine', 'Lantus 100U', 'A10AE04', 'Long-Acting Recombinant Human Insulin', 'INJECTION', '100 units/mL', 'SUBCUTANEOUS', 'C', 'Insulin clearance reduced in renal failure; monitor blood glucose.', 'Frequent glucose monitoring required.', true, false),
('NDC-0002-7512', 'Empagliflozin', 'Jardiance 10', 'A10BK03', 'SGLT2 Inhibitor', 'TABLET', '10mg', 'ORAL', 'C', 'eGFR 20-45: 10mg daily for kidney protection; eGFR < 20: Do not initiate.', 'No adjustment in mild-moderate hepatic disease.', false, false)
ON CONFLICT (ndc_code) DO NOTHING;
