-- =====================================================================================
-- HOSPITAL MANAGEMENT SYSTEM (HMS) - ENTERPRISE RELATIONAL SCHEMA (V1)
-- =====================================================================================

-- 1. EXTENSIONS
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE EXTENSION IF NOT EXISTS "pgcrypto";

-- =====================================================================================
-- 2. SYSTEM SEQUENCES & CONFIGURATION
-- =====================================================================================
CREATE TABLE system_sequences (
    name VARCHAR(50) PRIMARY KEY,
    current_val BIGINT NOT NULL DEFAULT 1000,
    prefix VARCHAR(10) NOT NULL
);

CREATE TABLE system_settings (
    key VARCHAR(100) PRIMARY KEY,
    value TEXT NOT NULL,
    category VARCHAR(50) NOT NULL,
    description TEXT,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- =====================================================================================
-- 3. IAM & AUTHENTICATION
-- =====================================================================================
CREATE TABLE roles (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE,
    description TEXT,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE permissions (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    module VARCHAR(50) NOT NULL,
    description TEXT,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE role_permissions (
    role_id BIGINT NOT NULL REFERENCES roles(id) ON DELETE CASCADE,
    permission_id BIGINT NOT NULL REFERENCES permissions(id) ON DELETE CASCADE,
    PRIMARY KEY (role_id, permission_id)
);

CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    phone VARCHAR(25),
    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE' CHECK (status IN ('ACTIVE', 'SUSPENDED', 'LOCKED', 'DEACTIVATED')),
    failed_login_attempts INT NOT NULL DEFAULT 0,
    locked_until TIMESTAMP WITH TIME ZONE,
    mfa_enabled BOOLEAN NOT NULL DEFAULT FALSE,
    mfa_secret VARCHAR(100),
    last_login_at TIMESTAMP WITH TIME ZONE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50),
    updated_by VARCHAR(50)
);

CREATE TABLE user_roles (
    user_id BIGINT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    role_id BIGINT NOT NULL REFERENCES roles(id) ON DELETE CASCADE,
    PRIMARY KEY (user_id, role_id)
);

CREATE TABLE user_sessions (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id BIGINT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    refresh_token_hash VARCHAR(255) NOT NULL,
    device_info VARCHAR(255),
    ip_address VARCHAR(50),
    expires_at TIMESTAMP WITH TIME ZONE NOT NULL,
    revoked_at TIMESTAMP WITH TIME ZONE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE login_history (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    user_id BIGINT REFERENCES users(id) ON DELETE SET NULL,
    status VARCHAR(20) NOT NULL, -- SUCCESS, FAILED, LOCKED
    ip_address VARCHAR(50),
    user_agent TEXT,
    failure_reason VARCHAR(100),
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- =====================================================================================
-- 4. ORGANIZATION, DEPARTMENTS & CLINICAL STAFF
-- =====================================================================================
CREATE TABLE departments (
    id BIGSERIAL PRIMARY KEY,
    code VARCHAR(20) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    type VARCHAR(30) NOT NULL CHECK (type IN ('CLINICAL', 'DIAGNOSTIC', 'ADMINISTRATIVE', 'SUPPORT', 'EMERGENCY')),
    head_staff_id BIGINT,
    phone VARCHAR(25),
    email VARCHAR(100),
    location VARCHAR(100),
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE staff (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT UNIQUE REFERENCES users(id) ON DELETE SET NULL,
    employee_no VARCHAR(30) NOT NULL UNIQUE,
    department_id BIGINT NOT NULL REFERENCES departments(id),
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    gender VARCHAR(10) NOT NULL CHECK (gender IN ('MALE', 'FEMALE', 'OTHER')),
    dob DATE NOT NULL,
    phone VARCHAR(25) NOT NULL,
    email VARCHAR(100) NOT NULL,
    designation VARCHAR(50) NOT NULL,
    qualification VARCHAR(100),
    join_date DATE NOT NULL,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE departments ADD CONSTRAINT fk_department_head FOREIGN KEY (head_staff_id) REFERENCES staff(id) ON DELETE SET NULL;

CREATE TABLE doctors (
    id BIGSERIAL PRIMARY KEY,
    staff_id BIGINT NOT NULL UNIQUE REFERENCES staff(id) ON DELETE CASCADE,
    license_no VARCHAR(50) NOT NULL UNIQUE,
    specialization VARCHAR(100) NOT NULL,
    sub_specialization VARCHAR(100),
    consultation_fee NUMERIC(12,2) NOT NULL DEFAULT 0.00,
    follow_up_fee NUMERIC(12,2) NOT NULL DEFAULT 0.00,
    max_daily_patients INT NOT NULL DEFAULT 30,
    is_available_for_telemed BOOLEAN NOT NULL DEFAULT FALSE,
    is_active BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE doctor_schedules (
    id BIGSERIAL PRIMARY KEY,
    doctor_id BIGINT NOT NULL REFERENCES doctors(id) ON DELETE CASCADE,
    day_of_week INT NOT NULL CHECK (day_of_week BETWEEN 1 AND 7), -- 1=Monday, 7=Sunday
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    slot_duration_minutes INT NOT NULL DEFAULT 15,
    max_slots INT NOT NULL DEFAULT 20,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT chk_schedule_times CHECK (start_time < end_time)
);

CREATE TABLE doctor_leaves (
    id BIGSERIAL PRIMARY KEY,
    doctor_id BIGINT NOT NULL REFERENCES doctors(id) ON DELETE CASCADE,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    reason TEXT,
    status VARCHAR(20) NOT NULL DEFAULT 'APPROVED' CHECK (status IN ('PENDING', 'APPROVED', 'REJECTED', 'CANCELLED')),
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- =====================================================================================
-- 5. MASTER PATIENT INDEX (MPI) & CONSENT
-- =====================================================================================
CREATE TABLE patients (
    id BIGSERIAL PRIMARY KEY,
    mrn VARCHAR(30) NOT NULL UNIQUE, -- Medical Record Number
    first_name VARCHAR(50) NOT NULL,
    middle_name VARCHAR(50),
    last_name VARCHAR(50) NOT NULL,
    dob DATE NOT NULL,
    gender VARCHAR(10) NOT NULL CHECK (gender IN ('MALE', 'FEMALE', 'OTHER')),
    blood_group VARCHAR(10) CHECK (blood_group IN ('A+', 'A-', 'B+', 'B-', 'AB+', 'AB-', 'O+', 'O-', 'UNKNOWN')),
    national_id VARCHAR(50),
    phone VARCHAR(25) NOT NULL,
    email VARCHAR(100),
    address_line1 VARCHAR(150),
    address_line2 VARCHAR(150),
    city VARCHAR(50),
    state VARCHAR(50),
    postal_code VARCHAR(20),
    country VARCHAR(50) DEFAULT 'India',
    emergency_contact_name VARCHAR(100),
    emergency_contact_relation VARCHAR(50),
    emergency_contact_phone VARCHAR(25),
    marital_status VARCHAR(20),
    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE' CHECK (status IN ('ACTIVE', 'INACTIVE', 'MERGED', 'DECEASED')),
    merged_into_id BIGINT REFERENCES patients(id),
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50),
    updated_by VARCHAR(50)
);

CREATE TABLE patient_merges (
    id BIGSERIAL PRIMARY KEY,
    primary_patient_id BIGINT NOT NULL REFERENCES patients(id),
    merged_patient_id BIGINT NOT NULL REFERENCES patients(id),
    reason TEXT NOT NULL,
    merged_by VARCHAR(50) NOT NULL,
    merged_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE patient_consents (
    id BIGSERIAL PRIMARY KEY,
    patient_id BIGINT NOT NULL REFERENCES patients(id) ON DELETE CASCADE,
    consent_type VARCHAR(50) NOT NULL, -- GENERAL_TREATMENT, DATA_SHARING, SURGICAL_PROCEDURE, RESEARCH
    purpose TEXT NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'GRANTED' CHECK (status IN ('GRANTED', 'REVOKED', 'EXPIRED')),
    granted_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    expires_at TIMESTAMP WITH TIME ZONE,
    revoked_at TIMESTAMP WITH TIME ZONE,
    witness_staff_id BIGINT REFERENCES staff(id),
    document_ref VARCHAR(255)
);

-- =====================================================================================
-- 6. APPOINTMENTS & SCHEDULING
-- =====================================================================================
CREATE TABLE appointments (
    id BIGSERIAL PRIMARY KEY,
    appointment_no VARCHAR(30) NOT NULL UNIQUE,
    patient_id BIGINT NOT NULL REFERENCES patients(id),
    doctor_id BIGINT NOT NULL REFERENCES doctors(id),
    department_id BIGINT NOT NULL REFERENCES departments(id),
    scheduled_date DATE NOT NULL,
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    type VARCHAR(30) NOT NULL DEFAULT 'CONSULTATION' CHECK (type IN ('CONSULTATION', 'FOLLOW_UP', 'PROCEDURE', 'EMERGENCY', 'TELEMEDICINE')),
    status VARCHAR(30) NOT NULL DEFAULT 'SCHEDULED' CHECK (status IN ('SCHEDULED', 'CONFIRMED', 'CHECKED_IN', 'IN_CONSULTATION', 'COMPLETED', 'CANCELLED', 'NO_SHOW', 'RESCHEDULED')),
    reason TEXT,
    notes TEXT,
    cancellation_reason TEXT,
    version INT NOT NULL DEFAULT 0,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50),
    updated_by VARCHAR(50),
    CONSTRAINT uk_doctor_time_slot UNIQUE (doctor_id, scheduled_date, start_time)
);

-- =====================================================================================
-- 7. OUTPATIENT DEPARTMENT (OPD) & ENCOUNTERS
-- =====================================================================================
CREATE TABLE opd_encounters (
    id BIGSERIAL PRIMARY KEY,
    encounter_no VARCHAR(30) NOT NULL UNIQUE,
    patient_id BIGINT NOT NULL REFERENCES patients(id),
    doctor_id BIGINT NOT NULL REFERENCES doctors(id),
    department_id BIGINT NOT NULL REFERENCES departments(id),
    appointment_id BIGINT REFERENCES appointments(id),
    encounter_date TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    triage_priority VARCHAR(20) NOT NULL DEFAULT 'ROUTINE' CHECK (triage_priority IN ('ROUTINE', 'PRIORITY', 'URGENT')),
    chief_complaint TEXT NOT NULL,
    history_of_present_illness TEXT,
    physical_examination TEXT,
    status VARCHAR(20) NOT NULL DEFAULT 'WAITING' CHECK (status IN ('WAITING', 'WITH_DOCTOR', 'COMPLETED', 'CANCELLED')),
    version INT NOT NULL DEFAULT 0,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- =====================================================================================
-- 8. WARDS, ROOMS, BEDS & INPATIENT DEPARTMENT (IPD)
-- =====================================================================================
CREATE TABLE wards (
    id BIGSERIAL PRIMARY KEY,
    department_id BIGINT NOT NULL REFERENCES departments(id),
    name VARCHAR(100) NOT NULL,
    ward_type VARCHAR(30) NOT NULL CHECK (ward_type IN ('GENERAL', 'SEMI_PRIVATE', 'PRIVATE', 'ICU', 'NICU', 'CCU', 'ISOLATION', 'MATERNITY', 'PEDIATRIC')),
    gender_allowed VARCHAR(10) NOT NULL DEFAULT 'ALL' CHECK (gender_allowed IN ('MALE', 'FEMALE', 'ALL')),
    total_beds INT NOT NULL DEFAULT 0,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE rooms (
    id BIGSERIAL PRIMARY KEY,
    ward_id BIGINT NOT NULL REFERENCES wards(id) ON DELETE CASCADE,
    room_number VARCHAR(30) NOT NULL,
    room_type VARCHAR(30) NOT NULL DEFAULT 'STANDARD',
    rate_per_day NUMERIC(12,2) NOT NULL DEFAULT 0.00,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT uk_ward_room UNIQUE (ward_id, room_number)
);

CREATE TABLE beds (
    id BIGSERIAL PRIMARY KEY,
    room_id BIGINT NOT NULL REFERENCES rooms(id) ON DELETE CASCADE,
    bed_number VARCHAR(30) NOT NULL,
    status VARCHAR(30) NOT NULL DEFAULT 'AVAILABLE' CHECK (status IN ('AVAILABLE', 'RESERVED', 'OCCUPIED', 'CLEANING', 'MAINTENANCE', 'OUT_OF_SERVICE')),
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    version INT NOT NULL DEFAULT 0,
    CONSTRAINT uk_room_bed UNIQUE (room_id, bed_number)
);

CREATE TABLE ipd_admissions (
    id BIGSERIAL PRIMARY KEY,
    admission_no VARCHAR(30) NOT NULL UNIQUE,
    patient_id BIGINT NOT NULL REFERENCES patients(id),
    primary_doctor_id BIGINT NOT NULL REFERENCES doctors(id),
    department_id BIGINT NOT NULL REFERENCES departments(id),
    ward_id BIGINT NOT NULL REFERENCES wards(id),
    current_bed_id BIGINT NOT NULL REFERENCES beds(id),
    admission_date TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    discharge_date TIMESTAMP WITH TIME ZONE,
    admission_type VARCHAR(30) NOT NULL DEFAULT 'PLANNED' CHECK (admission_type IN ('EMERGENCY', 'PLANNED', 'TRANSFER', 'OBSERVATION')),
    admission_reason TEXT NOT NULL,
    provisional_diagnosis TEXT,
    discharge_type VARCHAR(30) CHECK (discharge_type IN ('ROUTINE', 'AGAINST_MEDICAL_ADVICE', 'TRANSFER', 'DECEASED', 'REFERRED')),
    discharge_summary TEXT,
    status VARCHAR(30) NOT NULL DEFAULT 'ADMITTED' CHECK (status IN ('ADMITTED', 'TRANSFERRED', 'DISCHARGED', 'CANCELLED')),
    version INT NOT NULL DEFAULT 0,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50),
    updated_by VARCHAR(50)
);

CREATE TABLE bed_assignments (
    id BIGSERIAL PRIMARY KEY,
    admission_id BIGINT NOT NULL REFERENCES ipd_admissions(id),
    bed_id BIGINT NOT NULL REFERENCES beds(id),
    assigned_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    released_at TIMESTAMP WITH TIME ZONE,
    transfer_reason TEXT,
    assigned_by VARCHAR(50) NOT NULL
);

CREATE TABLE doctor_rounds (
    id BIGSERIAL PRIMARY KEY,
    admission_id BIGINT NOT NULL REFERENCES ipd_admissions(id) ON DELETE CASCADE,
    doctor_id BIGINT NOT NULL REFERENCES doctors(id),
    round_time TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    notes TEXT NOT NULL,
    instructions TEXT,
    plan_of_care TEXT
);

CREATE TABLE nursing_notes (
    id BIGSERIAL PRIMARY KEY,
    admission_id BIGINT NOT NULL REFERENCES ipd_admissions(id) ON DELETE CASCADE,
    nurse_id BIGINT NOT NULL REFERENCES staff(id),
    shift VARCHAR(20) NOT NULL CHECK (shift IN ('MORNING', 'EVENING', 'NIGHT')),
    assessment_notes TEXT NOT NULL,
    actions_taken TEXT,
    recorded_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- =====================================================================================
-- 9. EMERGENCY & TRIAGE
-- =====================================================================================
CREATE TABLE emergency_cases (
    id BIGSERIAL PRIMARY KEY,
    case_no VARCHAR(30) NOT NULL UNIQUE,
    patient_id BIGINT REFERENCES patients(id),
    anonymous_identifier VARCHAR(50),
    arrival_time TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    mode_of_arrival VARCHAR(50) CHECK (mode_of_arrival IN ('AMBULANCE', 'WALK_IN', 'POLICE', 'TRANSFER')),
    triage_level INT NOT NULL CHECK (triage_level BETWEEN 1 AND 5), -- 1=Resuscitation, 2=Emergent, 3=Urgent, 4=Less Urgent, 5=Non-Urgent
    triage_priority VARCHAR(20) NOT NULL CHECK (triage_priority IN ('CRITICAL', 'URGENT', 'MODERATE', 'LOW')),
    attending_doctor_id BIGINT REFERENCES doctors(id),
    chief_complaint TEXT NOT NULL,
    trauma_details TEXT,
    status VARCHAR(30) NOT NULL DEFAULT 'TRIAGED' CHECK (status IN ('TRIAGED', 'UNDER_TREATMENT', 'ADMITTED', 'TRANSFERRED', 'DISCHARGED', 'DECEASED')),
    outcome_notes TEXT,
    discharged_at TIMESTAMP WITH TIME ZONE,
    version INT NOT NULL DEFAULT 0,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- =====================================================================================
-- 10. CLINICAL RECORDS: NOTES, DIAGNOSES, ALLERGIES, VITALS
-- =====================================================================================
CREATE TABLE patient_allergies (
    id BIGSERIAL PRIMARY KEY,
    patient_id BIGINT NOT NULL REFERENCES patients(id) ON DELETE CASCADE,
    allergen VARCHAR(100) NOT NULL,
    allergy_type VARCHAR(50) NOT NULL CHECK (allergy_type IN ('DRUG', 'FOOD', 'ENVIRONMENTAL', 'LATEX', 'OTHER')),
    reaction VARCHAR(255) NOT NULL,
    severity VARCHAR(20) NOT NULL CHECK (severity IN ('MILD', 'MODERATE', 'SEVERE', 'LIFE_THREATENING')),
    onset_date DATE,
    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE' CHECK (status IN ('ACTIVE', 'INACTIVE', 'RESOLVED', 'REFUTED')),
    recorded_by VARCHAR(50) NOT NULL,
    recorded_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE patient_vitals (
    id BIGSERIAL PRIMARY KEY,
    patient_id BIGINT NOT NULL REFERENCES patients(id) ON DELETE CASCADE,
    encounter_id BIGINT REFERENCES opd_encounters(id),
    admission_id BIGINT REFERENCES ipd_admissions(id),
    emergency_case_id BIGINT REFERENCES emergency_cases(id),
    temp_celsius NUMERIC(4,1) CHECK (temp_celsius BETWEEN 25.0 AND 45.0),
    bp_systolic INT CHECK (bp_systolic BETWEEN 40 AND 300),
    bp_diastolic INT CHECK (bp_diastolic BETWEEN 20 AND 200),
    heart_rate INT CHECK (heart_rate BETWEEN 20 AND 300),
    resp_rate INT CHECK (resp_rate BETWEEN 5 AND 80),
    spo2 NUMERIC(4,1) CHECK (spo2 BETWEEN 0.0 AND 100.0),
    blood_glucose NUMERIC(5,1),
    pain_score INT CHECK (pain_score BETWEEN 0 AND 10),
    weight_kg NUMERIC(5,2) CHECK (weight_kg > 0),
    height_cm NUMERIC(5,2) CHECK (height_cm > 0),
    bmi NUMERIC(4,1),
    recorded_by VARCHAR(50) NOT NULL,
    recorded_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE clinical_notes (
    id BIGSERIAL PRIMARY KEY,
    patient_id BIGINT NOT NULL REFERENCES patients(id) ON DELETE CASCADE,
    encounter_id BIGINT REFERENCES opd_encounters(id),
    admission_id BIGINT REFERENCES ipd_admissions(id),
    author_id BIGINT NOT NULL REFERENCES staff(id),
    note_type VARCHAR(30) NOT NULL CHECK (note_type IN ('PROGRESS_NOTE', 'CONSULTATION', 'NURSING_NOTE', 'DISCHARGE_SUMMARY', 'PROCEDURE_NOTE', 'EMERGENCY_NOTE')),
    title VARCHAR(150) NOT NULL,
    content TEXT NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'DRAFT' CHECK (status IN ('DRAFT', 'FINALIZED', 'AMENDED')),
    finalized_at TIMESTAMP WITH TIME ZONE,
    amended_from_id BIGINT REFERENCES clinical_notes(id),
    amendment_reason TEXT,
    version INT NOT NULL DEFAULT 0,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE diagnoses (
    id BIGSERIAL PRIMARY KEY,
    patient_id BIGINT NOT NULL REFERENCES patients(id) ON DELETE CASCADE,
    encounter_id BIGINT REFERENCES opd_encounters(id),
    admission_id BIGINT REFERENCES ipd_admissions(id),
    icd10_code VARCHAR(20) NOT NULL,
    diagnosis_text VARCHAR(255) NOT NULL,
    type VARCHAR(20) NOT NULL DEFAULT 'PROVISIONAL' CHECK (type IN ('PROVISIONAL', 'FINAL', 'SECONDARY', 'DIFFERENTIAL', 'ADMISSION', 'DISCHARGE')),
    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE' CHECK (status IN ('ACTIVE', 'RESOLVED', 'RULED_OUT')),
    diagnosed_by BIGINT NOT NULL REFERENCES doctors(id),
    diagnosed_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- =====================================================================================
-- 11. MEDICINES, PHARMACY & PRESCRIPTIONS
-- =====================================================================================
CREATE TABLE medicine_categories (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    description TEXT
);

CREATE TABLE medicines (
    id BIGSERIAL PRIMARY KEY,
    code VARCHAR(30) NOT NULL UNIQUE,
    brand_name VARCHAR(100) NOT NULL,
    generic_name VARCHAR(100) NOT NULL,
    category_id BIGINT NOT NULL REFERENCES medicine_categories(id),
    dosage_form VARCHAR(50) NOT NULL, -- TABLET, CAPSULE, SYRUP, INJECTION, OINTMENT, INHALER, DROPS
    strength VARCHAR(50) NOT NULL,    -- 500mg, 10ml, etc.
    manufacturer VARCHAR(100),
    is_prescription_required BOOLEAN NOT NULL DEFAULT TRUE,
    is_narcotic BOOLEAN NOT NULL DEFAULT FALSE,
    reorder_level INT NOT NULL DEFAULT 50,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE medicine_batches (
    id BIGSERIAL PRIMARY KEY,
    medicine_id BIGINT NOT NULL REFERENCES medicines(id) ON DELETE CASCADE,
    batch_number VARCHAR(50) NOT NULL,
    expiry_date DATE NOT NULL,
    cost_price NUMERIC(12,2) NOT NULL DEFAULT 0.00,
    selling_price NUMERIC(12,2) NOT NULL DEFAULT 0.00,
    quantity_in_stock INT NOT NULL DEFAULT 0 CHECK (quantity_in_stock >= 0),
    supplier_name VARCHAR(100),
    received_date DATE DEFAULT CURRENT_DATE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT uk_medicine_batch UNIQUE (medicine_id, batch_number)
);

CREATE TABLE prescriptions (
    id BIGSERIAL PRIMARY KEY,
    prescription_no VARCHAR(30) NOT NULL UNIQUE,
    patient_id BIGINT NOT NULL REFERENCES patients(id),
    doctor_id BIGINT NOT NULL REFERENCES doctors(id),
    encounter_id BIGINT REFERENCES opd_encounters(id),
    admission_id BIGINT REFERENCES ipd_admissions(id),
    status VARCHAR(30) NOT NULL DEFAULT 'ISSUED' CHECK (status IN ('DRAFT', 'ISSUED', 'PARTIALLY_DISPENSED', 'DISPENSED', 'CANCELLED')),
    clinical_notes TEXT,
    issued_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    version INT NOT NULL DEFAULT 0,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50)
);

CREATE TABLE prescription_items (
    id BIGSERIAL PRIMARY KEY,
    prescription_id BIGINT NOT NULL REFERENCES prescriptions(id) ON DELETE CASCADE,
    medicine_id BIGINT NOT NULL REFERENCES medicines(id),
    dosage VARCHAR(50) NOT NULL,       -- e.g. "1 Tablet"
    route VARCHAR(30) NOT NULL,        -- ORAL, IV, IM, SC, TOPICAL, INHALATION
    frequency VARCHAR(30) NOT NULL,    -- ONCE_DAILY, TWICE_DAILY, THRICE_DAILY, FOUR_TIMES_DAILY, PRN, STAT
    duration_days INT NOT NULL,
    quantity_prescribed INT NOT NULL CHECK (quantity_prescribed > 0),
    quantity_dispensed INT NOT NULL DEFAULT 0 CHECK (quantity_dispensed >= 0),
    instructions TEXT,
    status VARCHAR(30) NOT NULL DEFAULT 'PENDING' CHECK (status IN ('PENDING', 'PARTIALLY_DISPENSED', 'DISPENSED', 'CANCELLED'))
);

CREATE TABLE medication_administrations (
    id BIGSERIAL PRIMARY KEY,
    admission_id BIGINT NOT NULL REFERENCES ipd_admissions(id) ON DELETE CASCADE,
    prescription_item_id BIGINT NOT NULL REFERENCES prescription_items(id),
    scheduled_time TIMESTAMP WITH TIME ZONE NOT NULL,
    administered_time TIMESTAMP WITH TIME ZONE,
    status VARCHAR(20) NOT NULL DEFAULT 'SCHEDULED' CHECK (status IN ('SCHEDULED', 'ADMINISTERED', 'SKIPPED', 'REFUSED', 'HELD')),
    dose_given VARCHAR(50),
    reason_not_given TEXT,
    administered_by BIGINT REFERENCES staff(id),
    notes TEXT,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE pharmacy_dispensations (
    id BIGSERIAL PRIMARY KEY,
    dispensation_no VARCHAR(30) NOT NULL UNIQUE,
    prescription_id BIGINT NOT NULL REFERENCES prescriptions(id),
    patient_id BIGINT NOT NULL REFERENCES patients(id),
    dispensed_by BIGINT NOT NULL REFERENCES staff(id),
    total_amount NUMERIC(12,2) NOT NULL DEFAULT 0.00,
    status VARCHAR(20) NOT NULL DEFAULT 'COMPLETED' CHECK (status IN ('COMPLETED', 'RETURNED', 'CANCELLED')),
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE pharmacy_dispensation_items (
    id BIGSERIAL PRIMARY KEY,
    dispensation_id BIGINT NOT NULL REFERENCES pharmacy_dispensations(id) ON DELETE CASCADE,
    prescription_item_id BIGINT NOT NULL REFERENCES prescription_items(id),
    batch_id BIGINT NOT NULL REFERENCES medicine_batches(id),
    quantity INT NOT NULL CHECK (quantity > 0),
    unit_price NUMERIC(12,2) NOT NULL,
    total_price NUMERIC(12,2) NOT NULL
);

-- =====================================================================================
-- 12. LABORATORY & RADIOLOGY
-- =====================================================================================
CREATE TABLE lab_tests (
    id BIGSERIAL PRIMARY KEY,
    code VARCHAR(30) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    category VARCHAR(50) NOT NULL, -- HEMATOLOGY, BIOCHEMISTRY, MICROBIOLOGY, PATHOLOGY, IMMUNOLOGY
    specimen_type VARCHAR(50) NOT NULL, -- BLOOD, URINE, SERUM, CSF, STOOL, TISSUE
    price NUMERIC(12,2) NOT NULL DEFAULT 0.00,
    normal_range_min NUMERIC(10,3),
    normal_range_max NUMERIC(10,3),
    unit VARCHAR(30),
    turnaround_hours INT NOT NULL DEFAULT 24,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE lab_orders (
    id BIGSERIAL PRIMARY KEY,
    order_no VARCHAR(30) NOT NULL UNIQUE,
    patient_id BIGINT NOT NULL REFERENCES patients(id),
    ordering_doctor_id BIGINT NOT NULL REFERENCES doctors(id),
    encounter_id BIGINT REFERENCES opd_encounters(id),
    admission_id BIGINT REFERENCES ipd_admissions(id),
    priority VARCHAR(20) NOT NULL DEFAULT 'ROUTINE' CHECK (priority IN ('ROUTINE', 'URGENT', 'STAT')),
    clinical_indication TEXT,
    status VARCHAR(30) NOT NULL DEFAULT 'ORDERED' CHECK (status IN ('ORDERED', 'SAMPLE_COLLECTED', 'IN_PROCESS', 'COMPLETED', 'CANCELLED')),
    ordered_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE lab_order_items (
    id BIGSERIAL PRIMARY KEY,
    lab_order_id BIGINT NOT NULL REFERENCES lab_orders(id) ON DELETE CASCADE,
    test_id BIGINT NOT NULL REFERENCES lab_tests(id),
    sample_barcode VARCHAR(50),
    sample_collected_at TIMESTAMP WITH TIME ZONE,
    sample_collected_by BIGINT REFERENCES staff(id),
    result_value VARCHAR(255),
    result_numeric NUMERIC(10,3),
    normal_range_snapshot VARCHAR(100),
    is_abnormal BOOLEAN NOT NULL DEFAULT FALSE,
    is_critical BOOLEAN NOT NULL DEFAULT FALSE,
    technician_notes TEXT,
    technician_id BIGINT REFERENCES staff(id),
    verified_by BIGINT REFERENCES staff(id),
    verified_at TIMESTAMP WITH TIME ZONE,
    status VARCHAR(30) NOT NULL DEFAULT 'PENDING' CHECK (status IN ('PENDING', 'COLLECTED', 'PROCESSING', 'RESULTED', 'VERIFIED', 'CANCELLED'))
);

CREATE TABLE radiology_examinations (
    id BIGSERIAL PRIMARY KEY,
    code VARCHAR(30) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    modality VARCHAR(30) NOT NULL CHECK (modality IN ('X_RAY', 'CT_SCAN', 'MRI', 'ULTRASOUND', 'MAMMOGRAPHY', 'DEXA', 'FLUOROSCOPY')),
    body_part VARCHAR(100) NOT NULL,
    price NUMERIC(12,2) NOT NULL DEFAULT 0.00,
    preparation_instructions TEXT,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE radiology_orders (
    id BIGSERIAL PRIMARY KEY,
    order_no VARCHAR(30) NOT NULL UNIQUE,
    patient_id BIGINT NOT NULL REFERENCES patients(id),
    ordering_doctor_id BIGINT NOT NULL REFERENCES doctors(id),
    examination_id BIGINT NOT NULL REFERENCES radiology_examinations(id),
    encounter_id BIGINT REFERENCES opd_encounters(id),
    admission_id BIGINT REFERENCES ipd_admissions(id),
    priority VARCHAR(20) NOT NULL DEFAULT 'ROUTINE' CHECK (priority IN ('ROUTINE', 'URGENT', 'STAT')),
    clinical_history TEXT,
    scheduled_at TIMESTAMP WITH TIME ZONE,
    completed_at TIMESTAMP WITH TIME ZONE,
    radiologist_id BIGINT REFERENCES doctors(id),
    findings TEXT,
    impression TEXT,
    pacs_image_url VARCHAR(255),
    status VARCHAR(30) NOT NULL DEFAULT 'ORDERED' CHECK (status IN ('ORDERED', 'SCHEDULED', 'PERFORMED', 'REPORTED', 'VERIFIED', 'CANCELLED')),
    verified_at TIMESTAMP WITH TIME ZONE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- =====================================================================================
-- 13. PROCEDURES & SURGICAL SERVICES
-- =====================================================================================
CREATE TABLE procedures (
    id BIGSERIAL PRIMARY KEY,
    code VARCHAR(30) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    department_id BIGINT NOT NULL REFERENCES departments(id),
    category VARCHAR(50) NOT NULL,
    base_price NUMERIC(12,2) NOT NULL DEFAULT 0.00,
    duration_minutes INT NOT NULL DEFAULT 60,
    preparation_instructions TEXT,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE procedure_records (
    id BIGSERIAL PRIMARY KEY,
    record_no VARCHAR(30) NOT NULL UNIQUE,
    procedure_id BIGINT NOT NULL REFERENCES procedures(id),
    patient_id BIGINT NOT NULL REFERENCES patients(id),
    primary_surgeon_id BIGINT NOT NULL REFERENCES doctors(id),
    anesthesiologist_id BIGINT REFERENCES doctors(id),
    admission_id BIGINT REFERENCES ipd_admissions(id),
    scheduled_start TIMESTAMP WITH TIME ZONE NOT NULL,
    actual_start TIMESTAMP WITH TIME ZONE,
    actual_end TIMESTAMP WITH TIME ZONE,
    pre_op_diagnosis TEXT,
    post_op_diagnosis TEXT,
    procedure_notes TEXT,
    anesthesia_type VARCHAR(50),
    complications TEXT,
    status VARCHAR(30) NOT NULL DEFAULT 'SCHEDULED' CHECK (status IN ('SCHEDULED', 'IN_PROGRESS', 'COMPLETED', 'CANCELLED')),
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- =====================================================================================
-- 14. BILLING, PAYMENTS & INSURANCE
-- =====================================================================================
CREATE TABLE service_items (
    id BIGSERIAL PRIMARY KEY,
    code VARCHAR(30) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    category VARCHAR(50) NOT NULL, -- CONSULTATION, LAB, RADIOLOGY, BED, PROCEDURE, NURSING, MISC
    unit_price NUMERIC(12,2) NOT NULL DEFAULT 0.00,
    tax_percent NUMERIC(5,2) NOT NULL DEFAULT 0.00,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE invoices (
    id BIGSERIAL PRIMARY KEY,
    invoice_no VARCHAR(30) NOT NULL UNIQUE,
    patient_id BIGINT NOT NULL REFERENCES patients(id),
    encounter_id BIGINT REFERENCES opd_encounters(id),
    admission_id BIGINT REFERENCES ipd_admissions(id),
    subtotal NUMERIC(12,2) NOT NULL DEFAULT 0.00,
    discount_amount NUMERIC(12,2) NOT NULL DEFAULT 0.00,
    tax_amount NUMERIC(12,2) NOT NULL DEFAULT 0.00,
    total_amount NUMERIC(12,2) NOT NULL DEFAULT 0.00,
    paid_amount NUMERIC(12,2) NOT NULL DEFAULT 0.00,
    balance_amount NUMERIC(12,2) NOT NULL DEFAULT 0.00,
    status VARCHAR(30) NOT NULL DEFAULT 'DRAFT' CHECK (status IN ('DRAFT', 'ISSUED', 'PARTIALLY_PAID', 'PAID', 'VOIDED')),
    due_date DATE NOT NULL,
    notes TEXT,
    version INT NOT NULL DEFAULT 0,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50),
    updated_by VARCHAR(50)
);

CREATE TABLE invoice_items (
    id BIGSERIAL PRIMARY KEY,
    invoice_id BIGINT NOT NULL REFERENCES invoices(id) ON DELETE CASCADE,
    item_type VARCHAR(50) NOT NULL, -- SERVICE, MEDICINE, LAB, RADIOLOGY, BED, PROCEDURE
    reference_id BIGINT,
    description VARCHAR(255) NOT NULL,
    quantity INT NOT NULL DEFAULT 1 CHECK (quantity > 0),
    unit_price NUMERIC(12,2) NOT NULL,
    discount_amount NUMERIC(12,2) NOT NULL DEFAULT 0.00,
    tax_amount NUMERIC(12,2) NOT NULL DEFAULT 0.00,
    total_price NUMERIC(12,2) NOT NULL
);

CREATE TABLE payments (
    id BIGSERIAL PRIMARY KEY,
    payment_no VARCHAR(30) NOT NULL UNIQUE,
    invoice_id BIGINT NOT NULL REFERENCES invoices(id),
    patient_id BIGINT NOT NULL REFERENCES patients(id),
    amount NUMERIC(12,2) NOT NULL CHECK (amount > 0),
    payment_method VARCHAR(30) NOT NULL CHECK (payment_method IN ('CASH', 'CREDIT_CARD', 'DEBIT_CARD', 'UPI', 'BANK_TRANSFER', 'INSURANCE', 'CHEQUE')),
    transaction_ref VARCHAR(100),
    idempotency_key VARCHAR(100) UNIQUE,
    received_by VARCHAR(50) NOT NULL,
    payment_date TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    notes TEXT
);

CREATE TABLE payment_refunds (
    id BIGSERIAL PRIMARY KEY,
    refund_no VARCHAR(30) NOT NULL UNIQUE,
    payment_id BIGINT NOT NULL REFERENCES payments(id),
    invoice_id BIGINT NOT NULL REFERENCES invoices(id),
    amount NUMERIC(12,2) NOT NULL CHECK (amount > 0),
    reason TEXT NOT NULL,
    authorized_by VARCHAR(50) NOT NULL,
    refund_date TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE insurance_providers (
    id BIGSERIAL PRIMARY KEY,
    code VARCHAR(30) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    contact_person VARCHAR(100),
    phone VARCHAR(25),
    email VARCHAR(100),
    claim_submission_email VARCHAR(100),
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE insurance_policies (
    id BIGSERIAL PRIMARY KEY,
    patient_id BIGINT NOT NULL REFERENCES patients(id) ON DELETE CASCADE,
    provider_id BIGINT NOT NULL REFERENCES insurance_providers(id),
    policy_no VARCHAR(50) NOT NULL,
    group_no VARCHAR(50),
    coverage_percentage NUMERIC(5,2) NOT NULL DEFAULT 80.00,
    max_coverage_amount NUMERIC(12,2) NOT NULL,
    valid_from DATE NOT NULL,
    valid_until DATE NOT NULL,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT uk_patient_policy UNIQUE (patient_id, provider_id, policy_no)
);

CREATE TABLE insurance_claims (
    id BIGSERIAL PRIMARY KEY,
    claim_no VARCHAR(30) NOT NULL UNIQUE,
    invoice_id BIGINT NOT NULL REFERENCES invoices(id),
    policy_id BIGINT NOT NULL REFERENCES insurance_policies(id),
    claimed_amount NUMERIC(12,2) NOT NULL,
    approved_amount NUMERIC(12,2) DEFAULT 0.00,
    patient_copay NUMERIC(12,2) DEFAULT 0.00,
    status VARCHAR(30) NOT NULL DEFAULT 'SUBMITTED' CHECK (status IN ('SUBMITTED', 'UNDER_REVIEW', 'APPROVED', 'PARTIALLY_APPROVED', 'REJECTED')),
    rejection_reason TEXT,
    submitted_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    adjudicated_at TIMESTAMP WITH TIME ZONE
);

-- =====================================================================================
-- 15. INVENTORY & SUPPLY CHAIN
-- =====================================================================================
CREATE TABLE inventory_categories (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    description TEXT
);

CREATE TABLE inventory_items (
    id BIGSERIAL PRIMARY KEY,
    code VARCHAR(30) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    category_id BIGINT NOT NULL REFERENCES inventory_categories(id),
    unit_of_measure VARCHAR(30) NOT NULL, -- PCS, BOX, BOTTLE, ROLL, PACK, KG
    current_stock INT NOT NULL DEFAULT 0 CHECK (current_stock >= 0),
    minimum_stock INT NOT NULL DEFAULT 10,
    reorder_quantity INT NOT NULL DEFAULT 50,
    unit_cost NUMERIC(12,2) NOT NULL DEFAULT 0.00,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE stock_transactions (
    id BIGSERIAL PRIMARY KEY,
    item_id BIGINT NOT NULL REFERENCES inventory_items(id),
    transaction_type VARCHAR(30) NOT NULL CHECK (transaction_type IN ('PURCHASE', 'CONSUMPTION', 'TRANSFER', 'ADJUSTMENT', 'RETURN', 'DISPOSAL')),
    quantity INT NOT NULL,
    unit_cost NUMERIC(12,2) NOT NULL,
    reference_type VARCHAR(50), -- PO, OPD, IPD, WARD_TRANSFER
    reference_id BIGINT,
    reason TEXT,
    actor_id VARCHAR(50) NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE purchase_orders (
    id BIGSERIAL PRIMARY KEY,
    po_no VARCHAR(30) NOT NULL UNIQUE,
    supplier_name VARCHAR(100) NOT NULL,
    total_amount NUMERIC(12,2) NOT NULL DEFAULT 0.00,
    status VARCHAR(30) NOT NULL DEFAULT 'DRAFT' CHECK (status IN ('DRAFT', 'SUBMITTED', 'PARTIALLY_RECEIVED', 'COMPLETED', 'CANCELLED')),
    order_date DATE DEFAULT CURRENT_DATE,
    expected_delivery DATE,
    created_by VARCHAR(50) NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- =====================================================================================
-- 16. BLOOD BANK
-- =====================================================================================
CREATE TABLE blood_donors (
    id BIGSERIAL PRIMARY KEY,
    donor_no VARCHAR(30) NOT NULL UNIQUE,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    blood_group VARCHAR(10) NOT NULL CHECK (blood_group IN ('A+', 'A-', 'B+', 'B-', 'AB+', 'AB-', 'O+', 'O-')),
    dob DATE NOT NULL,
    gender VARCHAR(10) NOT NULL,
    phone VARCHAR(25) NOT NULL,
    email VARCHAR(100),
    last_donation_date DATE,
    eligibility_status VARCHAR(20) NOT NULL DEFAULT 'ELIGIBLE' CHECK (eligibility_status IN ('ELIGIBLE', 'TEMPORARILY_DEFERRED', 'PERMANENTLY_DEFERRED')),
    deferral_reason TEXT,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE blood_units (
    id BIGSERIAL PRIMARY KEY,
    unit_barcode VARCHAR(50) NOT NULL UNIQUE,
    donor_id BIGINT NOT NULL REFERENCES blood_donors(id),
    blood_group VARCHAR(10) NOT NULL CHECK (blood_group IN ('A+', 'A-', 'B+', 'B-', 'AB+', 'AB-', 'O+', 'O-')),
    component_type VARCHAR(30) NOT NULL CHECK (component_type IN ('WHOLE_BLOOD', 'PACKED_RED_CELLS', 'FRESH_FROZEN_PLASMA', 'PLATELETS', 'CRYOPRECIPITATE')),
    volume_ml INT NOT NULL DEFAULT 450,
    collection_date DATE NOT NULL DEFAULT CURRENT_DATE,
    expiry_date DATE NOT NULL,
    storage_location VARCHAR(100) NOT NULL, -- e.g. "Refrigerator-A / Shelf-2"
    status VARCHAR(30) NOT NULL DEFAULT 'QUARANTINED' CHECK (status IN ('QUARANTINED', 'TESTED_SAFE', 'RESERVED', 'ISSUED', 'EXPIRED', 'DISCARDED')),
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE blood_requests (
    id BIGSERIAL PRIMARY KEY,
    request_no VARCHAR(30) NOT NULL UNIQUE,
    patient_id BIGINT NOT NULL REFERENCES patients(id),
    ordering_doctor_id BIGINT NOT NULL REFERENCES doctors(id),
    blood_group VARCHAR(10) NOT NULL CHECK (blood_group IN ('A+', 'A-', 'B+', 'B-', 'AB+', 'AB-', 'O+', 'O-')),
    component_type VARCHAR(30) NOT NULL,
    units_requested INT NOT NULL CHECK (units_requested > 0),
    units_issued INT NOT NULL DEFAULT 0,
    priority VARCHAR(20) NOT NULL DEFAULT 'ROUTINE' CHECK (priority IN ('ROUTINE', 'URGENT', 'EMERGENCY')),
    status VARCHAR(30) NOT NULL DEFAULT 'PENDING' CHECK (status IN ('PENDING', 'CROSS_MATCHING', 'PARTIALLY_ISSUED', 'ISSUED', 'CANCELLED')),
    required_by TIMESTAMP WITH TIME ZONE NOT NULL,
    clinical_indication TEXT,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE blood_crossmatches (
    id BIGSERIAL PRIMARY KEY,
    request_id BIGINT NOT NULL REFERENCES blood_requests(id),
    blood_unit_id BIGINT NOT NULL REFERENCES blood_units(id),
    is_compatible BOOLEAN NOT NULL,
    tested_by BIGINT NOT NULL REFERENCES staff(id),
    tested_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    notes TEXT
);

-- =====================================================================================
-- 17. DOCUMENTS, NOTIFICATIONS & AUDITING
-- =====================================================================================
CREATE TABLE documents (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    patient_id BIGINT REFERENCES patients(id) ON DELETE SET NULL,
    title VARCHAR(150) NOT NULL,
    document_type VARCHAR(50) NOT NULL, -- LAB_REPORT, RADIOLOGY_IMAGE, CONSENT_FORM, DISCHARGE_SUMMARY, ID_PROOF, INSURANCE_DOC
    mime_type VARCHAR(100) NOT NULL,
    file_size_bytes BIGINT NOT NULL,
    storage_path VARCHAR(500) NOT NULL,
    file_hash_sha256 VARCHAR(64) NOT NULL,
    uploaded_by VARCHAR(50) NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE system_notifications (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT REFERENCES users(id) ON DELETE CASCADE,
    title VARCHAR(150) NOT NULL,
    message TEXT NOT NULL,
    channel VARCHAR(20) NOT NULL DEFAULT 'IN_APP' CHECK (channel IN ('IN_APP', 'EMAIL', 'SMS', 'SYSTEM')),
    priority VARCHAR(20) NOT NULL DEFAULT 'NORMAL' CHECK (priority IN ('LOW', 'NORMAL', 'HIGH', 'URGENT')),
    read_status BOOLEAN NOT NULL DEFAULT FALSE,
    read_at TIMESTAMP WITH TIME ZONE,
    action_link VARCHAR(255),
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE audit_logs (
    id BIGSERIAL PRIMARY KEY,
    event_id UUID DEFAULT gen_random_uuid(),
    actor_id VARCHAR(50) NOT NULL,
    actor_role VARCHAR(50),
    tenant_id VARCHAR(50) DEFAULT 'MAIN_HOSPITAL',
    module VARCHAR(50) NOT NULL,
    action VARCHAR(50) NOT NULL,
    entity_name VARCHAR(50) NOT NULL,
    entity_id VARCHAR(50) NOT NULL,
    before_state JSONB,
    after_state JSONB,
    ip_address VARCHAR(50),
    user_agent TEXT,
    timestamp TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- =====================================================================================
-- 18. CRITICAL INDEXES (QUERY OPTIMIZATION & PERFORMANCE)
-- =====================================================================================
CREATE INDEX idx_users_username ON users(username);
CREATE INDEX idx_users_email ON users(email);
CREATE INDEX idx_users_status ON users(status);

CREATE INDEX idx_patients_mrn ON patients(mrn);
CREATE INDEX idx_patients_name ON patients(last_name, first_name);
CREATE INDEX idx_patients_phone ON patients(phone);
CREATE INDEX idx_patients_status ON patients(status);

CREATE INDEX idx_appointments_doctor_date ON appointments(doctor_id, scheduled_date);
CREATE INDEX idx_appointments_patient ON appointments(patient_id);
CREATE INDEX idx_appointments_status ON appointments(status);

CREATE INDEX idx_opd_encounters_patient ON opd_encounters(patient_id);
CREATE INDEX idx_opd_encounters_doctor ON opd_encounters(doctor_id);
CREATE INDEX idx_opd_encounters_date ON opd_encounters(encounter_date);

CREATE INDEX idx_ipd_admissions_patient ON ipd_admissions(patient_id);
CREATE INDEX idx_ipd_admissions_status ON ipd_admissions(status);
CREATE INDEX idx_ipd_admissions_ward ON ipd_admissions(ward_id);
CREATE INDEX idx_beds_status ON beds(status);

CREATE INDEX idx_vitals_patient_date ON patient_vitals(patient_id, recorded_at DESC);
CREATE INDEX idx_clinical_notes_patient ON clinical_notes(patient_id);
CREATE INDEX idx_diagnoses_patient ON diagnoses(patient_id);
CREATE INDEX idx_allergies_patient ON patient_allergies(patient_id);

CREATE INDEX idx_prescriptions_patient ON prescriptions(patient_id);
CREATE INDEX idx_prescription_items_presc ON prescription_items(prescription_id);
CREATE INDEX idx_medicine_batches_med ON medicine_batches(medicine_id);
CREATE INDEX idx_medicine_batches_expiry ON medicine_batches(expiry_date);

CREATE INDEX idx_lab_orders_patient ON lab_orders(patient_id);
CREATE INDEX idx_lab_orders_status ON lab_orders(status);
CREATE INDEX idx_lab_items_order ON lab_order_items(lab_order_id);

CREATE INDEX idx_radiology_orders_patient ON radiology_orders(patient_id);
CREATE INDEX idx_radiology_orders_status ON radiology_orders(status);

CREATE INDEX idx_invoices_patient ON invoices(patient_id);
CREATE INDEX idx_invoices_status ON invoices(status);
CREATE INDEX idx_payments_invoice ON payments(invoice_id);
CREATE INDEX idx_payments_idempotency ON payments(idempotency_key);

CREATE INDEX idx_inventory_items_code ON inventory_items(code);
CREATE INDEX idx_stock_trans_item ON stock_transactions(item_id);

CREATE INDEX idx_blood_units_barcode ON blood_units(unit_barcode);
CREATE INDEX idx_blood_units_group ON blood_units(blood_group, status);

CREATE INDEX idx_audit_logs_actor ON audit_logs(actor_id);
CREATE INDEX idx_audit_logs_entity ON audit_logs(entity_name, entity_id);
CREATE INDEX idx_audit_logs_timestamp ON audit_logs(timestamp DESC);
CREATE INDEX idx_notifications_user_unread ON system_notifications(user_id, read_status) WHERE read_status = FALSE;
