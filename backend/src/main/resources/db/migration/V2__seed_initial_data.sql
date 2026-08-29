-- =====================================================================================
-- HOSPITAL MANAGEMENT SYSTEM (HMS) - ENTERPRISE SEED DATA (V2)
-- =====================================================================================

-- 1. SYSTEM SEQUENCES
INSERT INTO system_sequences (name, current_val, prefix) VALUES
('MRN_SEQ', 10001, 'MRN-'),
('APT_SEQ', 10001, 'APT-'),
('ENC_SEQ', 10001, 'OPD-'),
('ADM_SEQ', 10001, 'IPD-'),
('ER_SEQ', 10001, 'EMR-'),
('RX_SEQ', 10001, 'RX-'),
('LAB_SEQ', 10001, 'LAB-'),
('RAD_SEQ', 10001, 'RAD-'),
('INV_SEQ', 10001, 'INV-'),
('PAY_SEQ', 10001, 'PAY-'),
('REF_SEQ', 10001, 'REF-'),
('CLM_SEQ', 10001, 'CLM-'),
('PO_SEQ', 10001, 'PO-'),
('DNR_SEQ', 10001, 'DNR-'),
('UNT_SEQ', 10001, 'BAG-'),
('REQ_SEQ', 10001, 'BRQ-'),
('DSP_SEQ', 10001, 'DSP-'),
('PRC_SEQ', 10001, 'PRC-');

-- 2. SYSTEM SETTINGS
INSERT INTO system_settings (key, value, category, description) VALUES
('HOSPITAL_NAME', 'Apex Memorial Super-Speciality Hospital', 'GENERAL', 'Official registered hospital name'),
('HOSPITAL_CODE', 'AMSSH-01', 'GENERAL', 'Unique hospital branch identifier'),
('HOSPITAL_PHONE', '+91-80-4958-3000', 'GENERAL', 'Hospital primary helpline'),
('HOSPITAL_EMAIL', 'info@apexmemorialhospital.org', 'GENERAL', 'Hospital official contact email'),
('HOSPITAL_ADDRESS', '45 Healthcare Boulevard, Medical Enclave, Bengaluru, KA 560029', 'GENERAL', 'Hospital physical address'),
('BASE_CURRENCY', 'INR', 'FINANCIAL', 'Standard billing currency'),
('CURRENCY_SYMBOL', '₹', 'FINANCIAL', 'Currency symbol for invoices and reports'),
('TAX_RATE_DEFAULT', '5.00', 'FINANCIAL', 'Default medical services GST/tax rate'),
('APPOINTMENT_DURATION_DEFAULT', '15', 'CLINICAL', 'Standard consultation slot in minutes'),
('MAX_APPOINTMENT_FUTURE_DAYS', '30', 'CLINICAL', 'Allowed booking advance window in days'),
('AUTO_DISCHARGE_HOURS', '24', 'CLINICAL', 'Maximum planned observation period before discharge review'),
('PASSWORD_EXPIRY_DAYS', '90', 'SECURITY', 'Staff password rotation requirement in days'),
('SESSION_TIMEOUT_MINUTES', '30', 'SECURITY', 'Inactivity session timeout');

-- 3. ROLES
INSERT INTO roles (id, name, description) VALUES
(1, 'ROLE_SUPER_ADMIN', 'Global system administrator with unrestricted infrastructure and configuration rights'),
(2, 'ROLE_HOSPITAL_ADMIN', 'Hospital executive administrator managing departments, staff, fees, and operational policies'),
(3, 'ROLE_DOCTOR', 'Licensed physician authorized to consult, diagnose, prescribe, and perform procedures'),
(4, 'ROLE_NURSE', 'Registered nurse managing inpatient wards, vitals, eMAR, and clinical shift logs'),
(5, 'ROLE_RECEPTIONIST', 'Front-desk officer handling patient registrations, triage queue, and appointment booking'),
(6, 'ROLE_PHARMACIST', 'Licensed pharmacist managing pharmacy inventory, dispensing, and batch expirations'),
(7, 'ROLE_LAB_TECHNICIAN', 'Laboratory technologist conducting specimen analysis and lab report generation'),
(8, 'ROLE_RADIOLOGY_TECHNICIAN', 'Radiology technologist operating modalities (X-Ray, CT, MRI) and uploading imaging studies'),
(9, 'ROLE_ACCOUNTANT', 'Financial officer handling billing, invoices, payment ledger, claims, and refunds'),
(10, 'ROLE_INVENTORY_MANAGER', 'Supply chain officer managing hospital consumable inventory, suppliers, and purchase orders'),
(11, 'ROLE_BLOOD_BANK_STAFF', 'Blood bank coordinator managing donors, blood units, testing, and transfusion cross-matching'),
(12, 'ROLE_PATIENT', 'Patient portal user with view access to own clinical history, prescriptions, and invoices');

-- 4. PERMISSIONS
INSERT INTO permissions (id, name, module, description) VALUES
(1, 'USER_READ', 'IAM', 'View user accounts and profiles'),
(2, 'USER_WRITE', 'IAM', 'Create and modify user accounts'),
(3, 'ROLE_MANAGE', 'IAM', 'Assign roles and fine-grained permissions'),
(4, 'PATIENT_READ', 'PATIENT', 'View patient master index and demographics'),
(5, 'PATIENT_WRITE', 'PATIENT', 'Register and update patient demographics'),
(6, 'PATIENT_MERGE', 'PATIENT', 'Execute patient record merge operations'),
(7, 'APPOINTMENT_READ', 'APPOINTMENT', 'View doctor schedules and booked appointments'),
(8, 'APPOINTMENT_WRITE', 'APPOINTMENT', 'Book, reschedule, and cancel appointments'),
(9, 'CLINICAL_NOTE_READ', 'EMR', 'Read patient clinical notes, vitals, and diagnoses'),
(10, 'CLINICAL_NOTE_WRITE', 'EMR', 'Author and amend clinical notes and diagnoses'),
(11, 'VITALS_WRITE', 'EMR', 'Record patient physiological vital signs'),
(12, 'IPD_MANAGE', 'IPD', 'Manage inpatient admissions, transfers, and discharges'),
(13, 'BED_ALLOCATE', 'IPD', 'Allocate, transfer, and release ward beds'),
(14, 'EMERGENCY_TRIAGE', 'EMERGENCY', 'Triage and intake emergency cases'),
(15, 'PRESCRIPTION_WRITE', 'PRESCRIPTION', 'Author and issue electronic prescriptions'),
(16, 'MEDICATION_ADMIN', 'EMAR', 'Record inpatient medication administration'),
(17, 'PHARMACY_DISPENSE', 'PHARMACY', 'Dispense medicines against issued prescriptions'),
(18, 'PHARMACY_INVENTORY', 'PHARMACY', 'Manage medicine stock batches and expiry dates'),
(19, 'LAB_ORDER_CREATE', 'LABORATORY', 'Order diagnostic laboratory tests'),
(20, 'LAB_RESULT_WRITE', 'LABORATORY', 'Enter and verify laboratory test results'),
(21, 'RADIOLOGY_ORDER_CREATE', 'RADIOLOGY', 'Order imaging and radiological examinations'),
(22, 'RADIOLOGY_REPORT_WRITE', 'RADIOLOGY', 'Author and finalize radiological findings'),
(23, 'PROCEDURE_MANAGE', 'PROCEDURE', 'Schedule and record surgical procedures'),
(24, 'INVOICE_WRITE', 'BILLING', 'Generate and finalize patient invoices'),
(25, 'PAYMENT_COLLECT', 'BILLING', 'Collect and record payment transactions'),
(26, 'REFUND_AUTHORIZE', 'BILLING', 'Authorize financial refunds and ledger credits'),
(27, 'INSURANCE_CLAIM_MANAGE', 'INSURANCE', 'File and adjudicate insurance claims'),
(28, 'INVENTORY_MANAGE', 'INVENTORY', 'Create purchase orders and adjust inventory stock'),
(29, 'BLOOD_BANK_MANAGE', 'BLOOD_BANK', 'Manage donors, blood units, and cross-matching'),
(30, 'REPORT_VIEW', 'REPORT', 'Access clinical, operational, and financial analytics'),
(31, 'AUDIT_VIEW', 'AUDIT', 'Inspect system security and compliance audit logs'),
(32, 'SYSTEM_CONFIG', 'ADMIN', 'Modify hospital profiles and system configuration');

-- Assign Permissions to Roles
-- SUPER_ADMIN: All permissions
INSERT INTO role_permissions (role_id, permission_id)
SELECT 1, id FROM permissions;

-- HOSPITAL_ADMIN: Most operational and administrative permissions
INSERT INTO role_permissions (role_id, permission_id)
SELECT 2, id FROM permissions WHERE name NOT IN ('AUDIT_VIEW');

-- DOCTOR: Clinical, EMR, Prescriptions, Lab Orders, Radiology Orders, Procedures, Appointments
INSERT INTO role_permissions (role_id, permission_id)
SELECT 3, id FROM permissions WHERE name IN (
    'PATIENT_READ', 'APPOINTMENT_READ', 'APPOINTMENT_WRITE', 'CLINICAL_NOTE_READ', 'CLINICAL_NOTE_WRITE',
    'VITALS_WRITE', 'IPD_MANAGE', 'EMERGENCY_TRIAGE', 'PRESCRIPTION_WRITE', 'LAB_ORDER_CREATE',
    'RADIOLOGY_ORDER_CREATE', 'PROCEDURE_MANAGE', 'REPORT_VIEW'
);

-- NURSE: Patient read, Vitals write, Inpatient bed check, EMAR, Clinical note read
INSERT INTO role_permissions (role_id, permission_id)
SELECT 4, id FROM permissions WHERE name IN (
    'PATIENT_READ', 'APPOINTMENT_READ', 'CLINICAL_NOTE_READ', 'VITALS_WRITE', 'BED_ALLOCATE',
    'EMERGENCY_TRIAGE', 'MEDICATION_ADMIN'
);

-- RECEPTIONIST: Patient demographics, Appointment booking, OPD Triage
INSERT INTO role_permissions (role_id, permission_id)
SELECT 5, id FROM permissions WHERE name IN (
    'PATIENT_READ', 'PATIENT_WRITE', 'APPOINTMENT_READ', 'APPOINTMENT_WRITE', 'EMERGENCY_TRIAGE'
);

-- PHARMACIST: Pharmacy dispense and inventory
INSERT INTO role_permissions (role_id, permission_id)
SELECT 6, id FROM permissions WHERE name IN (
    'PATIENT_READ', 'CLINICAL_NOTE_READ', 'PHARMACY_DISPENSE', 'PHARMACY_INVENTORY'
);

-- LAB_TECHNICIAN: Lab order view and result entry
INSERT INTO role_permissions (role_id, permission_id)
SELECT 7, id FROM permissions WHERE name IN (
    'PATIENT_READ', 'LAB_ORDER_CREATE', 'LAB_RESULT_WRITE'
);

-- RADIOLOGY_TECHNICIAN: Radiology order view and report writing
INSERT INTO role_permissions (role_id, permission_id)
SELECT 8, id FROM permissions WHERE name IN (
    'PATIENT_READ', 'RADIOLOGY_ORDER_CREATE', 'RADIOLOGY_REPORT_WRITE'
);

-- ACCOUNTANT: Invoicing, Payments, Refunds, Insurance
INSERT INTO role_permissions (role_id, permission_id)
SELECT 9, id FROM permissions WHERE name IN (
    'PATIENT_READ', 'INVOICE_WRITE', 'PAYMENT_COLLECT', 'REFUND_AUTHORIZE', 'INSURANCE_CLAIM_MANAGE', 'REPORT_VIEW'
);

-- INVENTORY_MANAGER: Stock transactions, purchase orders
INSERT INTO role_permissions (role_id, permission_id)
SELECT 10, id FROM permissions WHERE name IN (
    'INVENTORY_MANAGE', 'REPORT_VIEW'
);

-- BLOOD_BANK_STAFF: Blood donor and bag lifecycle
INSERT INTO role_permissions (role_id, permission_id)
SELECT 11, id FROM permissions WHERE name IN (
    'PATIENT_READ', 'BLOOD_BANK_MANAGE'
);

-- PATIENT: Self read
INSERT INTO role_permissions (role_id, permission_id)
SELECT 12, id FROM permissions WHERE name IN (
    'PATIENT_READ', 'APPOINTMENT_READ', 'CLINICAL_NOTE_READ'
);

-- 5. SEED USERS (Passwords hashed with BCrypt standard strength 12: 'Hospital@123')
-- '$2a$12$e8Y6PqV6F7c7TgzbH4q2iODKvh6rIqK7hB8JqQJ1fC4Fk9bL0rK2e' represents 'Hospital@123'
INSERT INTO users (id, username, email, password_hash, first_name, last_name, phone, status) VALUES
(1, 'superadmin', 'admin@apexmemorialhospital.org', '$2a$12$e8Y6PqV6F7c7TgzbH4q2iODKvh6rIqK7hB8JqQJ1fC4Fk9bL0rK2e', 'Alexander', 'Vance', '+91-98800-00001', 'ACTIVE'),
(2, 'dr.sharma', 'dr.sharma@apexmemorialhospital.org', '$2a$12$e8Y6PqV6F7c7TgzbH4q2iODKvh6rIqK7hB8JqQJ1fC4Fk9bL0rK2e', 'Rajesh', 'Sharma', '+91-98800-00002', 'ACTIVE'),
(3, 'dr.priya', 'dr.priya@apexmemorialhospital.org', '$2a$12$e8Y6PqV6F7c7TgzbH4q2iODKvh6rIqK7hB8JqQJ1fC4Fk9bL0rK2e', 'Priya', 'Nair', '+91-98800-00003', 'ACTIVE'),
(4, 'dr.robert', 'dr.robert@apexmemorialhospital.org', '$2a$12$e8Y6PqV6F7c7TgzbH4q2iODKvh6rIqK7hB8JqQJ1fC4Fk9bL0rK2e', 'Robert', 'D''Souza', '+91-98800-00004', 'ACTIVE'),
(5, 'nurse.sarah', 'sarah.mathew@apexmemorialhospital.org', '$2a$12$e8Y6PqV6F7c7TgzbH4q2iODKvh6rIqK7hB8JqQJ1fC4Fk9bL0rK2e', 'Sarah', 'Mathew', '+91-98800-00005', 'ACTIVE'),
(6, 'reception.amit', 'amit.verma@apexmemorialhospital.org', '$2a$12$e8Y6PqV6F7c7TgzbH4q2iODKvh6rIqK7hB8JqQJ1fC4Fk9bL0rK2e', 'Amit', 'Verma', '+91-98800-00006', 'ACTIVE'),
(7, 'pharm.kavita', 'kavita.patel@apexmemorialhospital.org', '$2a$12$e8Y6PqV6F7c7TgzbH4q2iODKvh6rIqK7hB8JqQJ1fC4Fk9bL0rK2e', 'Kavita', 'Patel', '+91-98800-00007', 'ACTIVE'),
(8, 'lab.rahul', 'rahul.sen@apexmemorialhospital.org', '$2a$12$e8Y6PqV6F7c7TgzbH4q2iODKvh6rIqK7hB8JqQJ1fC4Fk9bL0rK2e', 'Rahul', 'Sen', '+91-98800-00008', 'ACTIVE'),
(9, 'rad.deepak', 'deepak.joshi@apexmemorialhospital.org', '$2a$12$e8Y6PqV6F7c7TgzbH4q2iODKvh6rIqK7hB8JqQJ1fC4Fk9bL0rK2e', 'Deepak', 'Joshi', '+91-98800-00009', 'ACTIVE'),
(10, 'acc.suresh', 'suresh.menon@apexmemorialhospital.org', '$2a$12$e8Y6PqV6F7c7TgzbH4q2iODKvh6rIqK7hB8JqQJ1fC4Fk9bL0rK2e', 'Suresh', 'Menon', '+91-98800-00010', 'ACTIVE');

-- Assign User Roles
INSERT INTO user_roles (user_id, role_id) VALUES
(1, 1), -- superadmin -> SUPER_ADMIN
(2, 3), -- dr.sharma -> DOCTOR
(3, 3), -- dr.priya -> DOCTOR
(4, 3), -- dr.robert -> DOCTOR
(5, 4), -- nurse.sarah -> NURSE
(6, 5), -- reception.amit -> RECEPTIONIST
(7, 6), -- pharm.kavita -> PHARMACIST
(8, 7), -- lab.rahul -> LAB_TECHNICIAN
(9, 8), -- rad.deepak -> RADIOLOGY_TECHNICIAN
(10, 9); -- acc.suresh -> ACCOUNTANT

-- 6. DEPARTMENTS
INSERT INTO departments (id, code, name, type, phone, email, location) VALUES
(1, 'DEP-CARD', 'Cardiology & Heart Institute', 'CLINICAL', '+91-80-4958-3101', 'cardio@apexmemorialhospital.org', 'Block A, 2nd Floor'),
(2, 'DEP-ORTH', 'Orthopedics & Joint Reconstruction', 'CLINICAL', '+91-80-4958-3102', 'ortho@apexmemorialhospital.org', 'Block A, 3rd Floor'),
(3, 'DEP-PED', 'Pediatrics & Neonatology', 'CLINICAL', '+91-80-4958-3103', 'pediatrics@apexmemorialhospital.org', 'Block B, 1st Floor'),
(4, 'DEP-GENMED', 'General Internal Medicine', 'CLINICAL', '+91-80-4958-3104', 'genmed@apexmemorialhospital.org', 'Block A, 1st Floor'),
(5, 'DEP-GENSURG', 'General & Laparoscopic Surgery', 'CLINICAL', '+91-80-4958-3105', 'surgery@apexmemorialhospital.org', 'Block A, 4th Floor'),
(6, 'DEP-EMERG', 'Emergency & Trauma Care', 'EMERGENCY', '+91-80-4958-3999', 'er@apexmemorialhospital.org', 'Ground Floor, North Gate'),
(7, 'DEP-LAB', 'Central Diagnostic Laboratory', 'DIAGNOSTIC', '+91-80-4958-3201', 'lab@apexmemorialhospital.org', 'Basement 1, Diagnostic Wing'),
(8, 'DEP-RAD', 'Radiology & Advanced Imaging', 'DIAGNOSTIC', '+91-80-4958-3202', 'radiology@apexmemorialhospital.org', 'Basement 1, East Wing'),
(9, 'DEP-PHARM', 'Central Pharmacy & Dispensing', 'SUPPORT', '+91-80-4958-3301', 'pharmacy@apexmemorialhospital.org', 'Ground Floor, Main Lobby'),
(10, 'DEP-BBANK', 'Transfusion Medicine & Blood Bank', 'DIAGNOSTIC', '+91-80-4958-3401', 'bloodbank@apexmemorialhospital.org', 'Block B, Ground Floor');

-- 7. CLINICAL STAFF
INSERT INTO staff (id, user_id, employee_no, department_id, first_name, last_name, gender, dob, phone, email, designation, qualification, join_date) VALUES
(1, 1, 'EMP-1001', 4, 'Alexander', 'Vance', 'MALE', '1975-04-12', '+91-98800-00001', 'admin@apexmemorialhospital.org', 'Chief Medical Officer', 'MBBS, MD (Hospital Admin)', '2018-01-15'),
(2, 2, 'EMP-1002', 1, 'Rajesh', 'Sharma', 'MALE', '1980-08-22', '+91-98800-00002', 'dr.sharma@apexmemorialhospital.org', 'Senior Interventional Cardiologist', 'MBBS, MD, DM (Cardiology), FACC', '2019-03-01'),
(3, 3, 'EMP-1003', 2, 'Priya', 'Nair', 'FEMALE', '1984-11-15', '+91-98800-00003', 'dr.priya@apexmemorialhospital.org', 'Lead Orthopedic Surgeon', 'MBBS, MS (Orthopedics), MCh', '2020-06-15'),
(4, 4, 'EMP-1004', 3, 'Robert', 'D''Souza', 'MALE', '1982-02-10', '+91-98800-00004', 'dr.robert@apexmemorialhospital.org', 'Senior Pediatrician', 'MBBS, MD (Pediatrics), DNB', '2020-09-01'),
(5, 5, 'EMP-1005', 4, 'Sarah', 'Mathew', 'FEMALE', '1990-05-18', '+91-98800-00005', 'sarah.mathew@apexmemorialhospital.org', 'Head Nurse (ICU)', 'B.Sc Nursing, M.Sc Critical Care', '2021-02-01'),
(6, 6, 'EMP-1006', 4, 'Amit', 'Verma', 'MALE', '1993-09-25', '+91-98800-00006', 'amit.verma@apexmemorialhospital.org', 'Senior Front Desk Officer', 'BBA (Healthcare Management)', '2022-01-10'),
(7, 7, 'EMP-1007', 9, 'Kavita', 'Patel', 'FEMALE', '1988-12-04', '+91-98800-00007', 'kavita.patel@apexmemorialhospital.org', 'Chief Pharmacist', 'B.Pharm, M.Pharm', '2019-08-15'),
(8, 8, 'EMP-1008', 7, 'Rahul', 'Sen', 'MALE', '1991-03-30', '+91-98800-00008', 'rahul.sen@apexmemorialhospital.org', 'Senior Laboratory Technologist', 'B.Sc MLT, M.Sc Medical Biochemistry', '2021-05-20'),
(9, 9, 'EMP-1009', 8, 'Deepak', 'Joshi', 'MALE', '1986-07-14', '+91-98800-00009', 'deepak.joshi@apexmemorialhospital.org', 'Lead Radiographer', 'B.Sc Radiologic Technology', '2020-11-01'),
(10, 10, 'EMP-1010', 4, 'Suresh', 'Menon', 'MALE', '1985-01-20', '+91-98800-00010', 'suresh.menon@apexmemorialhospital.org', 'Chief Financial Accountant', 'Chartered Accountant (ICAI)', '2018-05-10');

-- 8. DOCTORS & SCHEDULES
INSERT INTO doctors (id, staff_id, license_no, specialization, sub_specialization, consultation_fee, follow_up_fee, max_daily_patients, is_available_for_telemed) VALUES
(1, 2, 'KMC-DOC-49581', 'Cardiology', 'Interventional Cardiology & Electrophysiology', 1200.00, 800.00, 25, TRUE),
(2, 3, 'KMC-DOC-51294', 'Orthopedics', 'Arthroscopy & Total Knee/Hip Replacement', 1000.00, 700.00, 25, FALSE),
(3, 4, 'KMC-DOC-44820', 'Pediatrics', 'Pediatric Pulmonology & Neonatal Intensive Care', 900.00, 600.00, 30, TRUE);

-- Doctor Schedules (Mon-Fri)
INSERT INTO doctor_schedules (doctor_id, day_of_week, start_time, end_time, slot_duration_minutes, max_slots) VALUES
(1, 1, '09:00:00', '13:00:00', 15, 16),
(1, 1, '14:30:00', '17:30:00', 15, 12),
(1, 2, '09:00:00', '13:00:00', 15, 16),
(1, 3, '09:00:00', '13:00:00', 15, 16),
(1, 4, '09:00:00', '13:00:00', 15, 16),
(1, 5, '09:00:00', '13:00:00', 15, 16),
(2, 1, '10:00:00', '14:00:00', 20, 12),
(2, 2, '10:00:00', '14:00:00', 20, 12),
(2, 3, '10:00:00', '14:00:00', 20, 12),
(2, 4, '10:00:00', '14:00:00', 20, 12),
(2, 5, '10:00:00', '14:00:00', 20, 12),
(3, 1, '08:30:00', '12:30:00', 15, 16),
(3, 2, '08:30:00', '12:30:00', 15, 16),
(3, 3, '08:30:00', '12:30:00', 15, 16),
(3, 4, '08:30:00', '12:30:00', 15, 16),
(3, 5, '08:30:00', '12:30:00', 15, 16);

-- 9. WARDS, ROOMS & BEDS
INSERT INTO wards (id, department_id, name, ward_type, gender_allowed, total_beds) VALUES
(1, 4, 'Male General Ward (North)', 'GENERAL', 'MALE', 10),
(2, 4, 'Female General Ward (South)', 'GENERAL', 'FEMALE', 10),
(3, 1, 'Coronary Intensive Care Unit (CCU)', 'ICU', 'ALL', 6),
(4, 5, 'Executive Deluxe Suites', 'PRIVATE', 'ALL', 4);

INSERT INTO rooms (id, ward_id, room_number, room_type, rate_per_day) VALUES
(1, 1, 'MGW-101', 'GENERAL_10_BED', 1200.00),
(2, 2, 'FGW-201', 'GENERAL_10_BED', 1200.00),
(3, 3, 'CCU-301', 'ICU_ISOLATED', 8500.00),
(4, 4, 'STE-401', 'DELUXE_SINGLE', 6500.00),
(5, 4, 'STE-402', 'DELUXE_SINGLE', 6500.00);

INSERT INTO beds (room_id, bed_number, status) VALUES
(1, 'BED-MGW-01', 'AVAILABLE'),
(1, 'BED-MGW-02', 'AVAILABLE'),
(1, 'BED-MGW-03', 'AVAILABLE'),
(1, 'BED-MGW-04', 'AVAILABLE'),
(1, 'BED-MGW-05', 'AVAILABLE'),
(2, 'BED-FGW-01', 'AVAILABLE'),
(2, 'BED-FGW-02', 'AVAILABLE'),
(2, 'BED-FGW-03', 'AVAILABLE'),
(2, 'BED-FGW-04', 'AVAILABLE'),
(2, 'BED-FGW-05', 'AVAILABLE'),
(3, 'BED-CCU-01', 'AVAILABLE'),
(3, 'BED-CCU-02', 'AVAILABLE'),
(3, 'BED-CCU-03', 'AVAILABLE'),
(4, 'BED-STE-401', 'AVAILABLE'),
(5, 'BED-STE-402', 'AVAILABLE');

-- 10. MEDICINE CATEGORIES & MEDICINES
INSERT INTO medicine_categories (id, name, description) VALUES
(1, 'Antibiotics & Antimicrobials', 'Bacterial and broad-spectrum antimicrobial agents'),
(2, 'Cardiovascular & Antihypertensives', 'Blood pressure, cardiac glycosides, and antiarrhythmics'),
(3, 'Analgesics & NSAIDs', 'Pain management and anti-inflammatory formulations'),
(4, 'Gastrointestinal Agents', 'Proton-pump inhibitors, antacids, and antiemetics'),
(5, 'Antidiabetic Agents', 'Insulins, biguanides, and oral hypoglycemics'),
(6, 'Respiratory & Antiasthmatics', 'Bronchodilators, corticosteroids, and antihistamines');

INSERT INTO medicines (id, code, brand_name, generic_name, category_id, dosage_form, strength, manufacturer, reorder_level) VALUES
(1, 'MED-AUG625', 'Augmentin 625 Duo', 'Amoxicillin (500mg) + Clavulanic Acid (125mg)', 1, 'TABLET', '625mg', 'GlaxoSmithKline', 100),
(2, 'MED-AZI500', 'Azee 500', 'Azithromycin', 1, 'TABLET', '500mg', 'Cipla Ltd', 100),
(3, 'MED-TEL40', 'Telma 40', 'Telmisartan', 2, 'TABLET', '40mg', 'Glenmark Pharmaceuticals', 150),
(4, 'MED-ATV20', 'Atorva 20', 'Atorvastatin', 2, 'TABLET', '20mg', 'Zydus Cadila', 150),
(5, 'MED-PCM650', 'Dolo 650', 'Paracetamol', 3, 'TABLET', '650mg', 'Micro Labs Ltd', 300),
(6, 'MED-PAN40', 'Pan 40', 'Pantoprazole Sodium', 4, 'TABLET', '40mg', 'Alkem Laboratories', 200),
(7, 'MED-GLY500', 'Glycomet 500 SR', 'Metformin Hydrochloride (Sustained Release)', 5, 'TABLET', '500mg', 'USV Private Ltd', 200);

-- Medicine Batches
INSERT INTO medicine_batches (medicine_id, batch_number, expiry_date, cost_price, selling_price, quantity_in_stock, supplier_name) VALUES
(1, 'AUG-2024-B101', '2027-06-30', 140.00, 205.00, 500, 'MedPlus Healthcare Supplies'),
(2, 'AZI-2024-B202', '2027-04-30', 85.00, 130.00, 450, 'Apex Pharma Distributors'),
(3, 'TEL-2024-B303', '2027-09-30', 60.00, 95.00, 800, 'Apollo Health Logistics'),
(4, 'ATV-2024-B404', '2027-11-30', 110.00, 165.00, 600, 'Cipla Supply Chain'),
(5, 'PCM-2024-B505', '2028-01-31', 18.00, 32.00, 2500, 'Micro Labs Hub'),
(6, 'PAN-2024-B606', '2027-08-31', 75.00, 115.00, 1200, 'MedPlus Healthcare Supplies'),
(7, 'GLY-2024-B707', '2027-12-31', 35.00, 58.00, 1500, 'USV Direct Distribution');

-- 11. DIAGNOSTIC LAB TESTS
INSERT INTO lab_tests (id, code, name, category, specimen_type, price, normal_range_min, normal_range_max, unit, turnaround_hours) VALUES
(1, 'LAB-CBC', 'Complete Blood Count (CBC) with Automated Differential', 'HEMATOLOGY', 'BLOOD', 450.00, NULL, NULL, 'Standard Panel', 4),
(2, 'LAB-GLUC-F', 'Fasting Blood Glucose (FBG)', 'BIOCHEMISTRY', 'SERUM', 150.00, 70.0, 100.0, 'mg/dL', 2),
(3, 'LAB-HBA1C', 'Glycated Hemoglobin (HbA1c)', 'BIOCHEMISTRY', 'BLOOD', 650.00, 4.0, 5.6, '%', 4),
(4, 'LAB-LIPID', 'Comprehensive Lipid Profile Panel', 'BIOCHEMISTRY', 'SERUM', 850.00, NULL, NULL, 'mg/dL', 6),
(5, 'LAB-KFT', 'Renal Function Test (Urea, Creatinine, Electrolytes)', 'BIOCHEMISTRY', 'SERUM', 750.00, 0.7, 1.3, 'mg/dL', 4),
(6, 'LAB-LFT', 'Liver Function Test (Bilirubin, SGOT, SGPT, ALP)', 'BIOCHEMISTRY', 'SERUM', 800.00, NULL, NULL, 'U/L', 6),
(7, 'LAB-TSH', 'Thyroid Stimulating Hormone (Ultra-sensitive TSH)', 'IMMUNOLOGY', 'SERUM', 500.00, 0.45, 4.5, 'uIU/mL', 6),
(8, 'LAB-TROP-I', 'Troponin-I High Sensitivity (Cardiac Biomarker)', 'BIOCHEMISTRY', 'SERUM', 1200.00, 0.00, 0.04, 'ng/mL', 1);

-- 12. RADIOLOGY EXAMINATIONS
INSERT INTO radiology_examinations (id, code, name, modality, body_part, price, preparation_instructions) VALUES
(1, 'RAD-XRAY-CHEST', 'Chest X-Ray PA View', 'X_RAY', 'Chest / Thorax', 600.00, 'Remove metallic jewelry and accessories.'),
(2, 'RAD-ECG-12L', '12-Lead Electrocardiogram (ECG)', 'FLUOROSCOPY', 'Cardiac', 350.00, 'Relax in supine position; clean chest surface.'),
(3, 'RAD-USG-ABD', 'Ultrasound Whole Abdomen and Pelvis', 'ULTRASOUND', 'Abdomen & Pelvis', 1500.00, 'Fast for 6 hours prior; full bladder required.'),
(4, 'RAD-CT-HEAD', 'CT Scan Head / Brain Plain', 'CT_SCAN', 'Brain', 3500.00, '4 hours fasting if IV contrast is considered.'),
(5, 'RAD-MRI-LUMBAR', 'MRI Lumbar Spine with Screening', 'MRI', 'Spine', 7500.00, 'Strict screening for pacemakers, metallic implants or foreign bodies.');

-- 13. SERVICE ITEMS (BILLING CATALOG)
INSERT INTO service_items (id, code, name, category, unit_price, tax_percent) VALUES
(1, 'SRV-CONS-CARD', 'Consultation - Senior Cardiologist', 'CONSULTATION', 1200.00, 0.00),
(2, 'SRV-CONS-ORTH', 'Consultation - Orthopedic Surgeon', 'CONSULTATION', 1000.00, 0.00),
(3, 'SRV-CONS-PED', 'Consultation - Senior Pediatrician', 'CONSULTATION', 900.00, 0.00),
(4, 'SRV-ER-TRIAGE', 'Emergency Room Triage & Resuscitation Initial Care', 'MISC', 1500.00, 5.00),
(5, 'SRV-ICU-DAY', 'Intensive Care Unit (ICU) Daily Monitoring Charge', 'BED', 8500.00, 5.00),
(6, 'SRV-DELUXE-DAY', 'Deluxe Room Daily Bed Charge', 'BED', 6500.00, 5.00),
(7, 'SRV-GEN-DAY', 'General Ward Daily Bed Charge', 'BED', 1200.00, 0.00),
(8, 'SRV-NURSING-CARE', 'Daily Inpatient Nursing Care & Clinical Monitoring', 'NURSING', 800.00, 0.00);

-- 14. INSURANCE PROVIDERS
INSERT INTO insurance_providers (id, code, name, contact_person, phone, email, claim_submission_email) VALUES
(1, 'INS-STAR', 'Star Health and Allied Insurance', 'Rajesh Kulkarni', '+91-80-2200-1122', 'claims@starhealth.in', 'tpa.apex@starhealth.in'),
(2, 'INS-HDFC', 'HDFC ERGO General Insurance Co.', 'Meenakshi Sundaram', '+91-80-6600-4455', 'healthclaims@hdfcergo.com', 'claims.hms@hdfcergo.com'),
(3, 'INS-ICICI', 'ICICI Lombard Health Care', 'Sunil Kapoor', '+91-80-4411-8899', 'hospitalization@icicilombard.com', 'provider.tpa@icicilombard.com');

-- 15. SEED PATIENT (FOR IMMEDIATE VERIFICATION)
INSERT INTO patients (id, mrn, first_name, middle_name, last_name, dob, gender, blood_group, phone, email, address_line1, city, state, postal_code, emergency_contact_name, emergency_contact_phone, status) VALUES
(1, 'MRN-10001', 'Anand', 'Kumar', 'Patil', '1982-06-14', 'MALE', 'O+', '+91-98450-12345', 'anand.patil@example.com', '74 Garden View Enclave, Indiranagar', 'Bengaluru', 'Karnataka', '560038', 'Sunita Patil', '+91-98450-54321', 'ACTIVE');
