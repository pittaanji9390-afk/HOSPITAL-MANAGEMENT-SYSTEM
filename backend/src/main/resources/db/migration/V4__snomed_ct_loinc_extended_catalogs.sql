-- ==============================================================================
-- Flyway Database Migration: V4__snomed_ct_loinc_extended_catalogs.sql
-- Description: SNOMED-CT Clinical Terms and Comprehensive LOINC Test Catalog
-- ==============================================================================

-- Create SNOMED CT Concepts Table
CREATE TABLE IF NOT EXISTS snomed_concepts (
    id BIGSERIAL PRIMARY KEY,
    concept_id VARCHAR(32) NOT NULL UNIQUE,
    fully_specified_name VARCHAR(512) NOT NULL,
    preferred_term VARCHAR(255) NOT NULL,
    semantic_tag VARCHAR(64) NOT NULL,
    parent_concept_id VARCHAR(32),
    active BOOLEAN NOT NULL DEFAULT true,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT NOW()
);

CREATE INDEX IF NOT EXISTS idx_snomed_concept_id ON snomed_concepts(concept_id);
CREATE INDEX IF NOT EXISTS idx_snomed_preferred_term ON snomed_concepts(preferred_term);
CREATE INDEX IF NOT EXISTS idx_snomed_semantic_tag ON snomed_concepts(semantic_tag);

-- Insert Extensive SNOMED-CT Concepts
INSERT INTO snomed_concepts (concept_id, fully_specified_name, preferred_term, semantic_tag, parent_concept_id) VALUES
('38341003', 'Hypertensive disorder, systemic arterial (disorder)', 'Essential hypertension', 'disorder', '64859006'),
('22298006', 'Myocardial infarction (disorder)', 'Acute myocardial infarction', 'disorder', '414545008'),
('401303003', 'Acute ST segment elevation myocardial infarction (disorder)', 'STEMI', 'disorder', '22298006'),
('401314000', 'Acute non-ST segment elevation myocardial infarction (disorder)', 'NSTEMI', 'disorder', '22298006'),
('42343007', 'Congestive heart failure (disorder)', 'Congestive heart failure', 'disorder', '84114007'),
('49436004', 'Atrial fibrillation (disorder)', 'Atrial fibrillation', 'disorder', '17366009'),
('25569003', 'Ventricular tachycardia (disorder)', 'Ventricular tachycardia', 'disorder', '25569003'),
('71908006', 'Ventricular fibrillation (disorder)', 'Ventricular fibrillation', 'disorder', '71908006'),
('195080001', 'Aortic valve stenosis (disorder)', 'Aortic stenosis', 'disorder', '60234000'),
('48724000', 'Mitral valve regurgitation (disorder)', 'Mitral regurgitation', 'disorder', '48724000'),
('230690007', 'Stroke (disorder)', 'Cerebrovascular accident', 'disorder', '62914000'),
('422504002', 'Ischemic stroke (disorder)', 'Acute ischemic stroke', 'disorder', '230690007'),
('274100004', 'Hemorrhagic stroke (disorder)', 'Intracerebral hemorrhage', 'disorder', '230690007'),
('128053003', 'Deep venous thrombosis (disorder)', 'Deep vein thrombosis', 'disorder', '48867003'),
('59282003', 'Pulmonary embolism (disorder)', 'Pulmonary embolism', 'disorder', '59282003'),
('89138009', 'Cardiogenic shock (disorder)', 'Cardiogenic shock', 'disorder', '27942005'),
('195967001', 'Asthma (disorder)', 'Bronchial asthma', 'disorder', '195951007'),
('13645005', 'Chronic obstructive lung disease (disorder)', 'COPD', 'disorder', '195951007'),
('233604007', 'Pneumonia (disorder)', 'Infective pneumonia', 'disorder', '53084003'),
('67782005', 'Acute respiratory distress syndrome (disorder)', 'ARDS', 'disorder', '67782005'),
('409622000', 'Acute respiratory failure (disorder)', 'Acute respiratory failure', 'disorder', '409623005'),
('73211009', 'Diabetes mellitus (disorder)', 'Diabetes mellitus', 'disorder', '362969004'),
('46635009', 'Type 1 diabetes mellitus (disorder)', 'Type 1 diabetes', 'disorder', '73211009'),
('44054006', 'Type 2 diabetes mellitus (disorder)', 'Type 2 diabetes', 'disorder', '73211009'),
('420422005', 'Diabetic ketoacidosis (disorder)', 'Diabetic ketoacidosis', 'disorder', '73211009'),
('40930008', 'Hypothyroidism (disorder)', 'Hypothyroidism', 'disorder', '362969004'),
('34486009', 'Hyperthyroidism (disorder)', 'Thyrotoxicosis', 'disorder', '362969004'),
('235595009', 'Gastroesophageal reflux disease (disorder)', 'GERD', 'disorder', '235595009'),
('85904008', 'Acute appendicitis (disorder)', 'Acute appendicitis', 'disorder', '85904008'),
('235856003', 'Cholecystitis (disorder)', 'Acute cholecystitis', 'disorder', '235856003'),
('235447007', 'Acute pancreatitis (disorder)', 'Acute pancreatitis', 'disorder', '235447007'),
('14669001', 'Acute kidney injury (disorder)', 'Acute kidney injury', 'disorder', '14669001'),
('709044004', 'Chronic kidney disease (disorder)', 'Chronic kidney disease', 'disorder', '709044004'),
('68566005', 'Urinary tract infection (disorder)', 'Urinary tract infection', 'disorder', '68566005'),
('91302008', 'Sepsis (disorder)', 'Sepsis', 'disorder', '91302008'),
('76571007', 'Septic shock (disorder)', 'Septic shock', 'disorder', '91302008'),
('232717009', 'Coronary artery bypass graft (procedure)', 'CABG surgery', 'procedure', '232717009'),
('415070008', 'Percutaneous coronary intervention (procedure)', 'PCI / Stenting', 'procedure', '415070008'),
('80146002', 'Appendectomy (procedure)', 'Appendectomy', 'procedure', '80146002'),
('38102005', 'Cholecystectomy (procedure)', 'Cholecystectomy', 'procedure', '38102005'),
('52734007', 'Total knee arthroplasty (procedure)', 'Total knee replacement', 'procedure', '52734007'),
('59711009', 'Total hip arthroplasty (procedure)', 'Total hip replacement', 'procedure', '59711009'),
('10849003', 'Hemodialysis (procedure)', 'Hemodialysis', 'procedure', '10849003'),
('71388002', 'Endotracheal intubation (procedure)', 'Endotracheal intubation', 'procedure', '71388002')
ON CONFLICT (concept_id) DO NOTHING;

-- Populate LOINC Lab Tests in lab_tests table
INSERT INTO lab_tests (code, name, category, specimen_type, price, normal_range_min, normal_range_max, unit, critical_low, critical_high, active, created_at, updated_at) VALUES
('LN-2345-7', 'Fasting Blood Glucose (LOINC: 2345-7)', 'BIOCHEMISTRY', 'SERUM', 250.00, 70.0, 99.0, 'mg/dL', 45.0, 450.0, true, NOW(), NOW()),
('LN-2160-0', 'Serum Creatinine (LOINC: 2160-0)', 'BIOCHEMISTRY', 'SERUM', 300.00, 0.6, 1.2, 'mg/dL', 0.2, 7.0, true, NOW(), NOW()),
('LN-2823-3', 'Serum Potassium (LOINC: 2823-3)', 'ELECTROLYTES', 'SERUM', 250.00, 3.5, 5.1, 'mmol/L', 2.8, 6.2, true, NOW(), NOW()),
('LN-2951-2', 'Serum Sodium (LOINC: 2951-2)', 'ELECTROLYTES', 'SERUM', 250.00, 136.0, 145.0, 'mmol/L', 120.0, 160.0, true, NOW(), NOW()),
('LN-718-7', 'Hemoglobin (LOINC: 718-7)', 'HEMATOLOGY', 'WHOLE_BLOOD', 200.00, 13.0, 17.5, 'g/dL', 6.0, 20.0, true, NOW(), NOW()),
('LN-6690-2', 'Total White Blood Cell Count (LOINC: 6690-2)', 'HEMATOLOGY', 'WHOLE_BLOOD', 200.00, 4000.0, 11000.0, '/uL', 1500.0, 30000.0, true, NOW(), NOW()),
('LN-777-3', 'Platelet Count (LOINC: 777-3)', 'HEMATOLOGY', 'WHOLE_BLOOD', 200.00, 150000.0, 450000.0, '/uL', 20000.0, 1000000.0, true, NOW(), NOW()),
('LN-5902-2', 'Prothrombin Time INR (LOINC: 5902-2)', 'COAGULATION', 'PLASMA', 450.00, 0.85, 1.15, 'INR', 0.7, 5.0, true, NOW(), NOW()),
('LN-42757-5', 'High Sensitivity Cardiac Troponin I (LOINC: 42757-5)', 'CARDIAC', 'SERUM', 1200.00, 0.0, 0.04, 'ng/mL', 0.0, 0.04, true, NOW(), NOW()),
('LN-33762-6', 'NT-proBNP (LOINC: 33762-6)', 'CARDIAC', 'SERUM', 1800.00, 0.0, 125.0, 'pg/mL', 0.0, 900.0, true, NOW(), NOW()),
('LN-1988-5', 'C-Reactive Protein (CRP) (LOINC: 1988-5)', 'SEROLOGY', 'SERUM', 400.00, 0.0, 5.0, 'mg/L', 0.0, 100.0, true, NOW(), NOW()),
('LN-33959-8', 'Procalcitonin (LOINC: 33959-8)', 'SEROLOGY', 'SERUM', 1500.00, 0.0, 0.5, 'ng/mL', 0.0, 2.0, true, NOW(), NOW()),
('LN-17861-6', 'Serum Calcium (LOINC: 17861-6)', 'BIOCHEMISTRY', 'SERUM', 250.00, 8.5, 10.5, 'mg/dL', 6.5, 13.0, true, NOW(), NOW()),
('LN-1920-8', 'Aspartate Aminotransferase (AST/SGOT) (LOINC: 1920-8)', 'LIVER', 'SERUM', 250.00, 10.0, 40.0, 'U/L', 0.0, 500.0, true, NOW(), NOW()),
('LN-1742-6', 'Alanine Aminotransferase (ALT/SGPT) (LOINC: 1742-6)', 'LIVER', 'SERUM', 250.00, 7.0, 56.0, 'U/L', 0.0, 500.0, true, NOW(), NOW()),
('LN-1975-2', 'Total Serum Bilirubin (LOINC: 1975-2)', 'LIVER', 'SERUM', 250.00, 0.2, 1.2, 'mg/dL', 0.0, 15.0, true, NOW(), NOW()),
('LN-2532-0', 'Serum Lactate (LOINC: 2532-0)', 'CRITICAL_CARE', 'BLOOD', 600.00, 0.5, 2.0, 'mmol/L', 0.0, 4.0, true, NOW(), NOW()),
('LN-2708-6', 'Arterial Blood pH (LOINC: 2708-6)', 'BLOOD_GAS', 'BLOOD', 800.00, 7.35, 7.45, 'pH', 7.10, 7.60, true, NOW(), NOW()),
('LN-2028-9', 'Arterial pCO2 (LOINC: 2028-9)', 'BLOOD_GAS', 'BLOOD', 800.00, 35.0, 45.0, 'mmHg', 20.0, 65.0, true, NOW(), NOW()),
('LN-2703-7', 'Arterial pO2 (LOINC: 2703-7)', 'BLOOD_GAS', 'BLOOD', 800.00, 80.0, 100.0, 'mmHg', 50.0, 300.0, true, NOW(), NOW())
ON CONFLICT (code) DO UPDATE
SET name = EXCLUDED.name,
    category = EXCLUDED.category,
    price = EXCLUDED.price,
    normal_range_min = EXCLUDED.normal_range_min,
    normal_range_max = EXCLUDED.normal_range_max,
    critical_low = EXCLUDED.critical_low,
    critical_high = EXCLUDED.critical_high,
    updated_at = NOW();
