-- V1: Enterprise Master Patient Index, Demographics, and Inpatient Encounters DDL
CREATE TABLE IF NOT EXISTS patients_mpi (
    id BIGSERIAL PRIMARY KEY,
    patient_mrn VARCHAR(32) NOT NULL UNIQUE,
    national_health_id VARCHAR(64),
    first_name VARCHAR(64) NOT NULL,
    middle_name VARCHAR(64),
    last_name VARCHAR(64) NOT NULL,
    date_of_birth DATE NOT NULL,
    gender VARCHAR(16) NOT NULL,
    blood_group VARCHAR(8),
    primary_contact_phone VARCHAR(32),
    emergency_contact_phone VARCHAR(32),
    email_address VARCHAR(128),
    residential_address TEXT,
    city VARCHAR(64),
    state_province VARCHAR(64),
    postal_code VARCHAR(16),
    country_code VARCHAR(8) DEFAULT 'IND',
    biometric_template_hash VARCHAR(256),
    fellegi_sunter_linkage_uuid VARCHAR(64),
    is_vip_confidential BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_patients_mpi_mrn ON patients_mpi(patient_mrn);
CREATE INDEX idx_patients_mpi_name_dob ON patients_mpi(last_name, date_of_birth);
CREATE INDEX idx_patients_mpi_national_id ON patients_mpi(national_health_id);

CREATE TABLE IF NOT EXISTS clinical_encounters (
    id BIGSERIAL PRIMARY KEY,
    encounter_uuid VARCHAR(64) NOT NULL UNIQUE,
    patient_mrn VARCHAR(32) NOT NULL REFERENCES patients_mpi(patient_mrn) ON DELETE RESTRICT,
    encounter_type VARCHAR(32) NOT NULL,
    admission_timestamp TIMESTAMP WITH TIME ZONE NOT NULL,
    discharge_timestamp TIMESTAMP WITH TIME ZONE,
    attending_physician_id VARCHAR(64) NOT NULL,
    admitting_department VARCHAR(32) NOT NULL,
    assigned_ward_room_bed VARCHAR(32),
    chief_complaint TEXT,
    admission_diagnosis_icd10 VARCHAR(32),
    discharge_disposition VARCHAR(64),
    total_incurred_cost_inr NUMERIC(12, 2) DEFAULT 0.00,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_encounters_patient_mrn ON clinical_encounters(patient_mrn);
CREATE INDEX idx_encounters_admission_time ON clinical_encounters(admission_timestamp);
