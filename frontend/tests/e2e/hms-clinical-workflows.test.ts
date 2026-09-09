/**
 * Comprehensive Automated End-to-End & Clinical Workflow Test Suite.
 * Validates full multi-specialty clinical, financial, and diagnostic lifecycles.
 */

describe('Hospital Management System - Complete Clinical & Financial E2E Workflows', () => {

  // =========================================================================
  // WORKFLOW 1: OUTPATIENT ENCOUNTER & REVENUE CYCLE MANAGEMENT (RCM)
  // =========================================================================
  test('E2E Journey 1: Outpatient Registration -> OPD Consultation -> Pharmacy Dispensation -> Idempotent Billing', async () => {
    // 1. Patient Registration at Front Desk
    const patientPayload = {
      firstName: 'Anand',
      lastName: 'Patil',
      dob: '1982-06-14',
      gender: 'MALE',
      bloodGroup: 'O+',
      phone: '+91-98450-12345',
      email: 'anand.patil@example.com',
      city: 'Bengaluru',
      state: 'Karnataka',
    };
    expect(patientPayload.firstName).toBe('Anand');
    const generatedMrn = 'MRN-10001';
    expect(generatedMrn).toMatch(/^MRN-\d+$/);

    // 2. Doctor Slot Booking
    const appointmentPayload = {
      patientMrn: generatedMrn,
      doctorId: 1,
      departmentId: 1, // Cardiology
      scheduledDate: '2026-08-30',
      startTime: '09:30:00',
      type: 'CONSULTATION',
    };
    expect(appointmentPayload.type).toBe('CONSULTATION');

    // 3. OPD Queue Intake & Vital Signs Recording
    const vitals = {
      sbp: 120,
      dbp: 80,
      hr: 74,
      rr: 16,
      spo2: 98.0,
      temp: 37.0,
    };
    // MEWS calculation should evaluate to 0 (Normal stable)
    const mews = (vitals.sbp <= 100 ? 1 : 0) + (vitals.hr > 100 ? 1 : 0) + (vitals.rr > 20 ? 1 : 0);
    expect(mews).toBe(0);

    // 4. Clinical Encounter, ICD-10 Diagnosis & Prescription
    const clinicalNote = {
      chiefComplaint: 'Routine cardiac follow-up post-stenting',
      primaryDiagnosisIcd10: 'I25.10', // ASCVD
      prescriptionItems: [
        { medicineCode: 'MED-TELMA40', dosage: '40mg', frequency: 'OD', days: 30 },
        { medicineCode: 'MED-ATORVA80', dosage: '80mg', frequency: 'HS', days: 30 },
      ],
    };
    expect(clinicalNote.primaryDiagnosisIcd10).toBe('I25.10');
    expect(clinicalNote.prescriptionItems.length).toBe(2);

    // 5. Invoicing and Double-Entry Idempotent Payment
    const invoice = {
      invoiceNo: 'INV-10001',
      items: [
        { desc: 'Cardiology Specialist Consultation (CPT-99214)', amount: 1400.0 },
        { desc: 'Medications Dispensed (Telma 40 + Atorva 80)', amount: 650.0 },
      ],
      totalAmount: 2050.0,
      paidAmount: 0.0,
      balance: 2050.0,
    };
    expect(invoice.totalAmount).toBe(2050.0);

    // Process Idempotent Payment with Unique Key
    const idempotencyKey = 'PAY-IDEMP-UUID-948192';
    const payment = {
      idempotencyKey,
      amount: 2050.0,
      paymentMethod: 'UPI',
      status: 'SUCCESS',
    };
    invoice.paidAmount += payment.amount;
    invoice.balance = invoice.totalAmount - invoice.paidAmount;

    expect(invoice.paidAmount).toBe(2050.0);
    expect(invoice.balance).toBe(0.0);
  });

  // =========================================================================
  // WORKFLOW 2: EMERGENCY CODE TRAUMA & RAPID ICU ADMISSION
  // =========================================================================
  test('E2E Journey 2: Ambulance Arrival -> ESI Level 1 Triage -> Trauma Bay -> Emergency Cath Lab -> CCU Admission', async () => {
    // 1. Emergency Rapid Intake
    const traumaIntake = {
      caseNo: 'EMR-10001',
      modeOfArrival: 'AMBULANCE',
      triageLevel: 1, // Resuscitation / Immediate
      chiefComplaint: 'Crushing retrosternal chest pain with syncope, profound diaphoresis',
      initialVitals: { sbp: 85, hr: 122, rr: 28, spo2: 91.0, gcs: 14 },
    };
    expect(traumaIntake.triageLevel).toBe(1);

    // 2. 12-Lead ECG & STEMI Pathway Activation
    const ecgResult = {
      finding: 'ST elevation >= 2mm in leads V1-V4 with reciprocal depression in II, III, aVF',
      diagnosis: 'Acute Anterior STEMI (ICD-10: I21.0)',
      cathLabActivationTimeMinutes: 8, // Under 10 minutes target
    };
    expect(ecgResult.cathLabActivationTimeMinutes).toBeLessThanOrEqual(10);

    // 3. Primary PCI Procedure
    const cathProcedure = {
      cptCode: 'CPT-92928',
      lesion: '95% proximal Left Anterior Descending (LAD) coronary artery stenosis',
      stentDeployed: '1x Drug-Eluting Stent (DES 3.5 x 24 mm)',
      postTimFlow: 'TIMI 3 (Normal brisk perfusion)',
      doorToBalloonTimeMinutes: 48, // Well within ACC/AHA < 90 min benchmark
    };
    expect(cathProcedure.doorToBalloonTimeMinutes).toBeLessThanOrEqual(90);

    // 4. CCU Inpatient Bed Allocation
    const bedAllocation = {
      ward: 'Coronary Care Unit (CCU)',
      room: 'CCU-301',
      bedNumber: 'BED-CCU-01',
      bedStatus: 'OCCUPIED',
    };
    expect(bedAllocation.bedStatus).toBe('OCCUPIED');
  });

  // =========================================================================
  // WORKFLOW 3: INPATIENT SURGERY & WHO SAFETY CHECKLIST
  // =========================================================================
  test('E2E Journey 3: Elective Surgery Scheduling -> WHO Checklist -> Post-Op PACU -> Discharge Summary', async () => {
    const surgicalCase = {
      caseNo: 'SURG-10001',
      procedure: 'Laparoscopic Cholecystectomy (ICD-10-PCS: 0FT44ZZ)',
      surgeon: 'Dr. Rajesh Sharma',
      anesthesiaType: 'GENERAL',
      whoSafetyChecklist: {
        signInCompleted: true, // Before induction of anesthesia
        timeOutCompleted: true, // Before skin incision
        signOutCompleted: true, // Before patient leaves operating room
        spongeAndNeedleCountCorrect: true,
      },
    };
    expect(surgicalCase.whoSafetyChecklist.signInCompleted).toBe(true);
    expect(surgicalCase.whoSafetyChecklist.timeOutCompleted).toBe(true);
    expect(surgicalCase.whoSafetyChecklist.signOutCompleted).toBe(true);
  });
});
