-- ==============================================================================
-- Flyway Database Migration: V5__icd10_pcs_inpatient_procedures_catalog.sql
-- Description: Inpatient ICD-10-PCS Surgical and Medical Procedure Coding System
-- ==============================================================================

CREATE TABLE IF NOT EXISTS icd10_pcs_procedures (
    id BIGSERIAL PRIMARY KEY,
    pcs_code VARCHAR(16) NOT NULL UNIQUE,
    description VARCHAR(512) NOT NULL,
    section_name VARCHAR(128) NOT NULL,
    body_system VARCHAR(128) NOT NULL,
    root_operation VARCHAR(128) NOT NULL,
    body_part VARCHAR(128) NOT NULL,
    approach VARCHAR(128) NOT NULL,
    device_name VARCHAR(128),
    qualifier VARCHAR(128),
    active BOOLEAN NOT NULL DEFAULT true,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT NOW()
);

CREATE INDEX IF NOT EXISTS idx_pcs_code ON icd10_pcs_procedures(pcs_code);
CREATE INDEX IF NOT EXISTS idx_pcs_body_system ON icd10_pcs_procedures(body_system);
CREATE INDEX IF NOT EXISTS idx_pcs_root_operation ON icd10_pcs_procedures(root_operation);

INSERT INTO icd10_pcs_procedures (pcs_code, description, section_name, body_system, root_operation, body_part, approach, device_name, qualifier) VALUES
('0210093', 'Bypass Coronary Artery, One Site from Coronary Artery with Autologous Venous Tissue, Open Approach', 'Medical and Surgical', 'Heart and Great Vessels', 'Bypass', 'Coronary Artery, One Site', 'Open', 'Autologous Venous Tissue', 'Coronary Artery'),
('02100Z9', 'Bypass Coronary Artery, One Site from Internal Mammary, Open Approach', 'Medical and Surgical', 'Heart and Great Vessels', 'Bypass', 'Coronary Artery, One Site', 'Open', 'No Device', 'Internal Mammary'),
('0211093', 'Bypass Coronary Artery, Two Sites with Autologous Venous Tissue, Open Approach', 'Medical and Surgical', 'Heart and Great Vessels', 'Bypass', 'Coronary Artery, Two Sites', 'Open', 'Autologous Venous Tissue', 'Coronary Artery'),
('0212093', 'Bypass Coronary Artery, Three Sites with Autologous Venous Tissue, Open Approach', 'Medical and Surgical', 'Heart and Great Vessels', 'Bypass', 'Coronary Artery, Three Sites', 'Open', 'Autologous Venous Tissue', 'Coronary Artery'),
('027034Z', 'Dilation of Coronary Artery, One Site with Drug-eluting Intraluminal Device, Percutaneous Approach (PCI DES)', 'Medical and Surgical', 'Heart and Great Vessels', 'Dilation', 'Coronary Artery, One Site', 'Percutaneous', 'Drug-eluting Intraluminal Device', 'No Qualifier'),
('027134Z', 'Dilation of Coronary Artery, Two Sites with Drug-eluting Intraluminal Device, Percutaneous Approach', 'Medical and Surgical', 'Heart and Great Vessels', 'Dilation', 'Coronary Artery, Two Sites', 'Percutaneous', 'Drug-eluting Intraluminal Device', 'No Qualifier'),
('02RF0JZ', 'Replacement of Aortic Valve with Synthetic Substitute, Open Approach', 'Medical and Surgical', 'Heart and Great Vessels', 'Replacement', 'Aortic Valve', 'Open', 'Synthetic Substitute', 'No Qualifier'),
('02RG0JZ', 'Replacement of Mitral Valve with Synthetic Substitute, Open Approach', 'Medical and Surgical', 'Heart and Great Vessels', 'Replacement', 'Mitral Valve', 'Open', 'Synthetic Substitute', 'No Qualifier'),
('02HK0DZ', 'Insertion of Pacemaker Lead into Right Ventricle, Open Approach', 'Medical and Surgical', 'Heart and Great Vessels', 'Insertion', 'Right Ventricle', 'Open', 'Intraluminal Device', 'No Qualifier'),
('02WA0MZ', 'Revision of Cardiac Pacemaker Lead, Open Approach', 'Medical and Surgical', 'Heart and Great Vessels', 'Revision', 'Heart', 'Open', 'Intraluminal Device', 'No Qualifier'),
('0FT44ZZ', 'Resection of Gallbladder, Percutaneous Endoscopic Approach (Laparoscopic Cholecystectomy)', 'Medical and Surgical', 'Hepatobiliary System and Pancreas', 'Resection', 'Gallbladder', 'Percutaneous Endoscopic', 'No Device', 'No Qualifier'),
('0FT40ZZ', 'Resection of Gallbladder, Open Approach (Open Cholecystectomy)', 'Medical and Surgical', 'Hepatobiliary System and Pancreas', 'Resection', 'Gallbladder', 'Open', 'No Device', 'No Qualifier'),
('0DTJ4ZZ', 'Resection of Appendix, Percutaneous Endoscopic Approach (Laparoscopic Appendectomy)', 'Medical and Surgical', 'Gastrointestinal System', 'Resection', 'Appendix', 'Percutaneous Endoscopic', 'No Device', 'No Qualifier'),
('0DTJ0ZZ', 'Resection of Appendix, Open Approach (Open Appendectomy)', 'Medical and Surgical', 'Gastrointestinal System', 'Resection', 'Appendix', 'Open', 'No Device', 'No Qualifier'),
('0D160ZA', 'Bypass Stomach to Jejunum, Open Approach (Roux-en-Y Gastric Bypass)', 'Medical and Surgical', 'Gastrointestinal System', 'Bypass', 'Stomach', 'Open', 'No Device', 'Jejunum'),
('0D164ZA', 'Bypass Stomach to Jejunum, Percutaneous Endoscopic Approach (Laparoscopic Gastric Bypass)', 'Medical and Surgical', 'Gastrointestinal System', 'Bypass', 'Stomach', 'Percutaneous Endoscopic', 'No Device', 'Jejunum'),
('0SRD0JZ', 'Replacement of Right Knee Joint with Synthetic Substitute, Open Approach (Right TKA)', 'Medical and Surgical', 'Lower Joints', 'Replacement', 'Right Knee Joint', 'Open', 'Synthetic Substitute', 'No Qualifier'),
('0SRE0JZ', 'Replacement of Left Knee Joint with Synthetic Substitute, Open Approach (Left TKA)', 'Medical and Surgical', 'Lower Joints', 'Replacement', 'Left Knee Joint', 'Open', 'Synthetic Substitute', 'No Qualifier'),
('0SR9019', 'Replacement of Right Hip Joint with Metal on Polyethylene, Open Approach (Right THA)', 'Medical and Surgical', 'Lower Joints', 'Replacement', 'Right Hip Joint', 'Open', 'Metal on Polyethylene', 'No Qualifier'),
('0SRB019', 'Replacement of Left Hip Joint with Metal on Polyethylene, Open Approach (Left THA)', 'Medical and Surgical', 'Lower Joints', 'Replacement', 'Left Hip Joint', 'Open', 'Metal on Polyethylene', 'No Qualifier'),
('0SHG44Z', 'Repair Right Knee Tendon, Percutaneous Endoscopic Approach (Arthroscopic ACL Reconstruction)', 'Medical and Surgical', 'Bursae, Ligaments, and Tendons', 'Repair', 'Right Knee Tendon', 'Percutaneous Endoscopic', 'Internal Fixation Device', 'No Qualifier'),
('0SHH44Z', 'Repair Left Knee Tendon, Percutaneous Endoscopic Approach (Arthroscopic ACL Reconstruction)', 'Medical and Surgical', 'Bursae, Ligaments, and Tendons', 'Repair', 'Left Knee Tendon', 'Percutaneous Endoscopic', 'Internal Fixation Device', 'No Qualifier'),
('10D00Z0', 'Extraction of Products of Conception, Open Approach (Classical Cesarean Section)', 'Obstetrics', 'Pregnancy', 'Extraction', 'Products of Conception', 'Open', 'No Device', 'Classical C-Section'),
('10D00Z1', 'Extraction of Products of Conception, Low Cervical Open Approach (Low Transverse C-Section)', 'Obstetrics', 'Pregnancy', 'Extraction', 'Products of Conception', 'Open', 'No Device', 'Low Transverse C-Section'),
('10E0XZZ', 'Delivery of Products of Conception, External Approach (Spontaneous Vaginal Delivery)', 'Obstetrics', 'Pregnancy', 'Delivery', 'Products of Conception', 'External', 'No Device', 'No Qualifier'),
('0B110F4', 'Bypass Trachea to Cutaneous with Tracheostomy Tube, Open Approach (Surgical Tracheostomy)', 'Medical and Surgical', 'Respiratory System', 'Bypass', 'Trachea', 'Open', 'Tracheostomy Tube', 'Cutaneous')
ON CONFLICT (pcs_code) DO NOTHING;
