-- V3: Laboratory Information System (LIS) & PACS DICOM Ingestion Tables
CREATE TABLE IF NOT EXISTS lis_specimen_orders (
    id BIGSERIAL PRIMARY KEY,
    accession_number VARCHAR(64) NOT NULL UNIQUE,
    patient_mrn VARCHAR(32) NOT NULL,
    encounter_uuid VARCHAR(64) NOT NULL,
    loinc_test_code VARCHAR(32) NOT NULL,
    test_description VARCHAR(128) NOT NULL,
    specimen_matrix VARCHAR(32) NOT NULL,
    collection_time TIMESTAMP WITH TIME ZONE,
    analytical_instrument_id VARCHAR(64),
    order_status VARCHAR(32) NOT NULL DEFAULT 'ORDERED',
    is_panic_critical_value BOOLEAN DEFAULT FALSE,
    verified_by_pathologist_id VARCHAR(64),
    verified_timestamp TIMESTAMP WITH TIME ZONE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS pacs_dicom_studies (
    id BIGSERIAL PRIMARY KEY,
    study_instance_uid VARCHAR(128) NOT NULL UNIQUE,
    patient_mrn VARCHAR(32) NOT NULL,
    accession_number VARCHAR(64) NOT NULL,
    modality VARCHAR(16) NOT NULL,
    study_description TEXT,
    series_count INTEGER DEFAULT 1,
    instance_count INTEGER DEFAULT 1,
    radiation_dose_msv NUMERIC(8, 3) DEFAULT 0.000,
    storage_s3_bucket_uri TEXT,
    study_date TIMESTAMP WITH TIME ZONE NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_pacs_study_uid ON pacs_dicom_studies(study_instance_uid);
