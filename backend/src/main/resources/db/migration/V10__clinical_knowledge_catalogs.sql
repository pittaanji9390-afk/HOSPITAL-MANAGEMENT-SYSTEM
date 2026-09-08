-- V10: Clinical Knowledge Catalogs & Subspecialty Decision Registry
CREATE TABLE IF NOT EXISTS clinical_specialty_registry (
    id BIGSERIAL PRIMARY KEY,
    specialty_code VARCHAR(64) NOT NULL UNIQUE,
    specialty_name VARCHAR(255) NOT NULL,
    department_head VARCHAR(128),
    active_protocols_count INT DEFAULT 0,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO clinical_specialty_registry (specialty_code, specialty_name, department_head, active_protocols_count) VALUES
('CARD-EP', 'Cardiology & Electrophysiology', 'Dr. Arvind Sen', 24),
('NEURO-CRIT', 'Neurocritical Care & Stroke', 'Dr. Radhika Menon', 18),
('ONCO-MED', 'Medical & Precision Oncology', 'Dr. Suresh Pillai', 32),
('PULM-CC', 'Pulmonology & Critical Care', 'Dr. Fatima Khan', 21),
('NEPHRO-RRT', 'Nephrology & Renal Dialysis', 'Dr. Amitav Ghosh', 16),
('GASTRO-HEP', 'Gastroenterology & Hepatology', 'Dr. Ramesh Chandra', 28),
('ORTHO-TRM', 'Orthopedics & Trauma Surgery', 'Dr. Anand Verma', 19),
('OBGYN-MFM', 'Obstetrics & Maternal-Fetal Medicine', 'Dr. Maya Swaminathan', 22),
('PED-PALS', 'Pediatrics & Neonatology', 'Dr. Kavita Deshmukh', 25),
('TOX-ENV', 'Medical Toxicology & Poison Control', 'Dr. Sandeep Kulkarni', 15)
ON CONFLICT (specialty_code) DO NOTHING;
