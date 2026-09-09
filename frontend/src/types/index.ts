export interface User {
  id: number;
  username: string;
  email: string;
  firstName: string;
  lastName: string;
  phone?: string;
  roles: string[];
  permissions: string[];
}

export interface AuthResponse {
  accessToken: string;
  refreshToken: string;
  tokenType: string;
  expiresIn: number;
  user: User;
}

export interface ApiResponse<T> {
  success: boolean;
  timestamp: string;
  requestId: string;
  message?: string;
  data: T;
  pagination?: PaginationMeta;
}

export interface PaginationMeta {
  page: number;
  size: number;
  totalElements: number;
  totalPages: number;
  isFirst: boolean;
  isLast: boolean;
}

export interface PagedResponse<T> {
  content: T[];
  meta: PaginationMeta;
}

export interface Patient {
  id: number;
  mrn: string;
  firstName: string;
  middleName?: string;
  lastName: string;
  dob: string;
  gender: 'MALE' | 'FEMALE' | 'OTHER';
  bloodGroup?: string;
  nationalId?: string;
  phone: string;
  email?: string;
  addressLine1?: string;
  city?: string;
  state?: string;
  postalCode?: string;
  country?: string;
  emergencyContactName?: string;
  emergencyContactRelation?: string;
  emergencyContactPhone?: string;
  maritalStatus?: string;
  status: 'ACTIVE' | 'INACTIVE' | 'MERGED' | 'DECEASED';
}

export interface Department {
  id: number;
  code: string;
  name: string;
  type: 'CLINICAL' | 'DIAGNOSTIC' | 'ADMINISTRATIVE' | 'SUPPORT' | 'EMERGENCY';
  headStaffId?: number;
  phone?: string;
  email?: string;
  location?: string;
  active: boolean;
}

export interface Doctor {
  id: number;
  staffId: number;
  doctorName: string;
  employeeNo: string;
  departmentId: number;
  departmentName: string;
  phone: string;
  email: string;
  licenseNo: string;
  specialization: string;
  subSpecialization?: string;
  consultationFee: number;
  followUpFee: number;
  maxDailyPatients: number;
  availableForTelemed: boolean;
  active: boolean;
  schedules?: DoctorSchedule[];
}

export interface DoctorSchedule {
  id: number;
  dayOfWeek: number;
  startTime: string;
  endTime: string;
  slotDurationMinutes: number;
  maxSlots: number;
  active: boolean;
}

export interface Appointment {
  id: number;
  appointmentNo: string;
  patientId: number;
  patientName: string;
  patientMrn: string;
  patientPhone: string;
  doctorId: number;
  doctorName: string;
  departmentId: number;
  departmentName: string;
  scheduledDate: string;
  startTime: string;
  endTime: string;
  type: 'CONSULTATION' | 'FOLLOW_UP' | 'PROCEDURE' | 'EMERGENCY' | 'TELEMEDICINE';
  status: 'SCHEDULED' | 'CONFIRMED' | 'CHECKED_IN' | 'IN_CONSULTATION' | 'COMPLETED' | 'CANCELLED' | 'NO_SHOW' | 'RESCHEDULED';
  reason?: string;
  notes?: string;
}

export interface OpdEncounter {
  id: number;
  encounterNo: string;
  patientId: number;
  patientName: string;
  patientMrn: string;
  patientPhone: string;
  doctorId: number;
  doctorName: string;
  departmentId: number;
  departmentName: string;
  appointmentId?: number;
  encounterDate: string;
  triagePriority: 'ROUTINE' | 'PRIORITY' | 'URGENT';
  chiefComplaint: string;
  historyOfPresentIllness?: string;
  physicalExamination?: string;
  status: 'WAITING' | 'WITH_DOCTOR' | 'COMPLETED' | 'CANCELLED';
}

export interface Bed {
  id: number;
  bedNumber: string;
  roomId: number;
  roomNumber: string;
  wardId: number;
  wardName: string;
  ratePerDay: number;
  status: 'AVAILABLE' | 'RESERVED' | 'OCCUPIED' | 'CLEANING' | 'MAINTENANCE' | 'OUT_OF_SERVICE';
}

export interface IpdAdmission {
  id: number;
  admissionNo: string;
  patientId: number;
  patientName: string;
  patientMrn: string;
  patientPhone: string;
  primaryDoctorId: number;
  primaryDoctorName: string;
  departmentId: number;
  departmentName: string;
  wardId: number;
  wardName: string;
  bedId: number;
  bedNumber: string;
  roomNumber: string;
  admissionDate: string;
  dischargeDate?: string;
  admissionType: 'EMERGENCY' | 'PLANNED' | 'TRANSFER' | 'OBSERVATION';
  admissionReason: string;
  provisionalDiagnosis?: string;
  dischargeType?: 'ROUTINE' | 'AGAINST_MEDICAL_ADVICE' | 'TRANSFER' | 'DECEASED' | 'REFERRED';
  dischargeSummary?: string;
  status: 'ADMITTED' | 'TRANSFERRED' | 'DISCHARGED' | 'CANCELLED';
}

export interface EmergencyCase {
  id: number;
  caseNo: string;
  patientId?: number;
  patientName: string;
  patientMrn: string;
  anonymousIdentifier?: string;
  arrivalTime: string;
  modeOfArrival: 'AMBULANCE' | 'WALK_IN' | 'POLICE' | 'TRANSFER';
  triageLevel: number;
  triagePriority: 'CRITICAL' | 'URGENT' | 'MODERATE' | 'LOW';
  attendingDoctorId?: number;
  attendingDoctorName: string;
  chiefComplaint: string;
  traumaDetails?: string;
  status: 'TRIAGED' | 'UNDER_TREATMENT' | 'ADMITTED' | 'TRANSFERRED' | 'DISCHARGED' | 'DECEASED';
  outcomeNotes?: string;
}

export interface ClinicalNote {
  id: number;
  patientId: number;
  encounterId?: number;
  admissionId?: number;
  authorId: number;
  authorName: string;
  noteType: 'PROGRESS_NOTE' | 'CONSULTATION' | 'NURSING_NOTE' | 'DISCHARGE_SUMMARY' | 'PROCEDURE_NOTE' | 'EMERGENCY_NOTE';
  title: string;
  content: string;
  status: 'DRAFT' | 'FINALIZED' | 'AMENDED';
  finalizedAt?: string;
  amendedFromId?: number;
  amendmentReason?: string;
  createdAt: string;
}

export interface Diagnosis {
  id: number;
  patientId: number;
  encounterId?: number;
  admissionId?: number;
  icd10Code: string;
  diagnosisText: string;
  type: 'PROVISIONAL' | 'FINAL' | 'SECONDARY' | 'DIFFERENTIAL' | 'ADMISSION' | 'DISCHARGE';
  status: 'ACTIVE' | 'RESOLVED' | 'RULED_OUT';
  doctorId: number;
  doctorName: string;
  diagnosedAt: string;
}

export interface PatientAllergy {
  id: number;
  patientId: number;
  allergen: string;
  allergyType: 'DRUG' | 'FOOD' | 'ENVIRONMENTAL' | 'LATEX' | 'OTHER';
  reaction: string;
  severity: 'MILD' | 'MODERATE' | 'SEVERE' | 'LIFE_THREATENING';
  onsetDate?: string;
  status: 'ACTIVE' | 'INACTIVE' | 'RESOLVED' | 'REFUTED';
  recordedBy: string;
  recordedAt: string;
}

export interface PatientVital {
  id: number;
  patientId: number;
  encounterId?: number;
  admissionId?: number;
  tempCelsius?: number;
  bpSystolic?: number;
  bpDiastolic?: number;
  heartRate?: number;
  respRate?: number;
  spo2?: number;
  bloodGlucose?: number;
  painScore?: number;
  weightKg?: number;
  heightCm?: number;
  bmi?: number;
  recordedBy: string;
  recordedAt: string;
}

export interface Medicine {
  id: number;
  code: string;
  brandName: string;
  genericName: string;
  categoryId: number;
  categoryName: string;
  dosageForm: string;
  strength: string;
  manufacturer?: string;
  prescriptionRequired: boolean;
  narcotic: boolean;
  reorderLevel: number;
  totalStock: number;
  active: boolean;
}

export interface MedicineBatch {
  id: number;
  medicineId: number;
  batchNumber: string;
  expiryDate: string;
  costPrice: number;
  sellingPrice: number;
  quantityInStock: number;
  supplierName?: string;
  receivedDate: string;
}

export interface Prescription {
  id: number;
  prescriptionNo: string;
  patientId: number;
  patientName: string;
  patientMrn: string;
  doctorId: number;
  doctorName: string;
  encounterId?: number;
  admissionId?: number;
  status: 'DRAFT' | 'ISSUED' | 'PARTIALLY_DISPENSED' | 'DISPENSED' | 'CANCELLED';
  clinicalNotes?: string;
  issuedAt: string;
  items: PrescriptionItem[];
}

export interface PrescriptionItem {
  id: number;
  medicineId: number;
  medicineName: string;
  genericName: string;
  dosage: string;
  route: string;
  frequency: string;
  durationDays: number;
  quantityPrescribed: number;
  quantityDispensed: number;
  instructions?: string;
  status: 'PENDING' | 'PARTIALLY_DISPENSED' | 'DISPENSED' | 'CANCELLED';
}

export interface LabTest {
  id: number;
  code: string;
  name: string;
  category: string;
  specimenType: string;
  price: number;
  normalRangeMin?: number;
  normalRangeMax?: number;
  unit?: string;
  turnaroundHours: number;
  active: boolean;
}

export interface LabOrder {
  id: number;
  orderNo: string;
  patientId: number;
  patientName: string;
  patientMrn: string;
  doctorId: number;
  doctorName: string;
  priority: 'ROUTINE' | 'URGENT' | 'STAT';
  clinicalIndication?: string;
  status: 'ORDERED' | 'SAMPLE_COLLECTED' | 'IN_PROCESS' | 'COMPLETED' | 'CANCELLED';
  orderedAt: string;
  items: LabOrderItem[];
}

export interface LabOrderItem {
  id: number;
  testId: number;
  testCode: string;
  testName: string;
  category: string;
  specimenType: string;
  sampleBarcode?: string;
  resultValue?: string;
  resultNumeric?: number;
  normalRangeSnapshot?: string;
  abnormal: boolean;
  critical: boolean;
  technicianNotes?: string;
  verifiedByName?: string;
  verifiedAt?: string;
  status: 'PENDING' | 'COLLECTED' | 'PROCESSING' | 'RESULTED' | 'VERIFIED' | 'CANCELLED';
}

export interface RadiologyExam {
  id: number;
  code: string;
  name: string;
  modality: 'X_RAY' | 'CT_SCAN' | 'MRI' | 'ULTRASOUND' | 'MAMMOGRAPHY' | 'DEXA' | 'FLUOROSCOPY';
  bodyPart: string;
  price: number;
  preparationInstructions?: string;
  active: boolean;
}

export interface RadiologyOrder {
  id: number;
  orderNo: string;
  patientId: number;
  patientName: string;
  patientMrn: string;
  doctorId: number;
  doctorName: string;
  examinationId: number;
  examinationName: string;
  modality: RadiologyExam['modality'];
  bodyPart: string;
  priority: 'ROUTINE' | 'URGENT' | 'STAT';
  clinicalHistory?: string;
  findings?: string;
  impression?: string;
  pacsImageUrl?: string;
  status: 'ORDERED' | 'SCHEDULED' | 'PERFORMED' | 'REPORTED' | 'VERIFIED' | 'CANCELLED';
  createdAt: string;
}

export interface ServiceItem {
  id: number;
  code: string;
  name: string;
  category: string;
  unitPrice: number;
  taxPercent: number;
  active: boolean;
}

export interface Invoice {
  id: number;
  invoiceNo: string;
  patientId: number;
  patientName: string;
  patientMrn: string;
  encounterId?: number;
  admissionId?: number;
  subtotal: number;
  discountAmount: number;
  taxAmount: number;
  totalAmount: number;
  paidAmount: number;
  balanceAmount: number;
  status: 'DRAFT' | 'ISSUED' | 'PARTIALLY_PAID' | 'PAID' | 'VOIDED';
  dueDate: string;
  notes?: string;
  createdAt: string;
  items: InvoiceItem[];
}

export interface InvoiceItem {
  id: number;
  itemType: string;
  referenceId?: number;
  description: string;
  quantity: number;
  unitPrice: number;
  discountAmount: number;
  taxAmount: number;
  totalPrice: number;
}

export interface Payment {
  id: number;
  paymentNo: string;
  invoiceId: number;
  invoiceNo: string;
  patientId: number;
  patientName: string;
  amount: number;
  paymentMethod: 'CASH' | 'CREDIT_CARD' | 'DEBIT_CARD' | 'UPI' | 'BANK_TRANSFER' | 'INSURANCE' | 'CHEQUE';
  transactionRef?: string;
  receivedBy: string;
  paymentDate: string;
  notes?: string;
}

export interface InventoryItem {
  id: number;
  code: string;
  name: string;
  categoryId?: number;
  categoryName: string;
  unitOfMeasure: string;
  currentStock: number;
  minimumStock: number;
  reorderQuantity: number;
  unitCost: number;
  active: boolean;
}

export interface BloodStockSummary {
  bloodGroup: string;
  count: number;
}

export interface AuditLog {
  id: number;
  eventId: string;
  actorId: string;
  actorRole?: string;
  tenantId: string;
  module: string;
  action: string;
  entityName: string;
  entityId: string;
  ipAddress?: string;
  userAgent?: string;
  timestamp: string;
}

export interface DashboardStats {
  totalPatients: number;
  todayAppointments: number;
  activeAdmissions: number;
  availableBeds: number;
  occupiedBeds: number;
  activeEmergencyCases: number;
  todayRevenue: number;
  outstandingBalance: number;
}
