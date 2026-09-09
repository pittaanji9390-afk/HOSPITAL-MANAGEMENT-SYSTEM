import React, { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import {
  User,
  AlertTriangle,
  HeartPulse,
  FileText,
  Activity,
  Pill,
  TestTube2,
  ScanLine,
  Receipt,
  Calendar,
  Plus,
  ArrowLeft,
  Clock,
  CheckCircle2,
  Stethoscope,
} from 'lucide-react';
import {
  LineChart,
  Line,
  XAxis,
  YAxis,
  CartesianGrid,
  Tooltip,
  ResponsiveContainer,
} from 'recharts';
import { apiClient } from '../api/client';
import {
  Patient,
  ClinicalNote,
  Diagnosis,
  PatientAllergy,
  PatientVital,
  Prescription,
  LabOrder,
  Invoice,
  ApiResponse,
  PagedResponse,
} from '../types';

export const PatientDetail: React.FC = () => {
  const { id } = useParams<{ id: string }>();
  const navigate = useNavigate();
  const [activeTab, setActiveTab] = useState<
    'timeline' | 'notes' | 'diagnoses' | 'vitals' | 'prescriptions' | 'lab' | 'billing'
  >('timeline');

  const [patient, setPatient] = useState<Patient>({
    id: 1,
    mrn: 'MRN-10001',
    firstName: 'Anand',
    middleName: 'Kumar',
    lastName: 'Patil',
    dob: '1982-06-14',
    gender: 'MALE',
    bloodGroup: 'O+',
    phone: '+91-98450-12345',
    email: 'anand.patil@example.com',
    addressLine1: '74 Garden View Enclave, Indiranagar',
    city: 'Bengaluru',
    state: 'Karnataka',
    emergencyContactName: 'Sunita Patil',
    emergencyContactPhone: '+91-98450-54321',
    status: 'ACTIVE',
  });

  const [allergies, setAllergies] = useState<PatientAllergy[]>([
    {
      id: 1,
      patientId: 1,
      allergen: 'Penicillin / Amoxicillin',
      allergyType: 'DRUG',
      reaction: 'Severe Anaphylactoid Rash & Bronchospasm',
      severity: 'SEVERE',
      status: 'ACTIVE',
      recordedBy: 'Dr. Rajesh Sharma',
      recordedAt: '2024-02-15T10:00:00Z',
    },
  ]);

  const [vitals, setVitals] = useState<PatientVital[]>([
    {
      id: 1,
      patientId: 1,
      tempCelsius: 37.1,
      bpSystolic: 124,
      bpDiastolic: 82,
      heartRate: 74,
      respRate: 16,
      spo2: 99.0,
      bmi: 24.2,
      recordedBy: 'Sarah Mathew (Nurse)',
      recordedAt: '2026-08-28 09:30',
    },
    {
      id: 2,
      patientId: 1,
      tempCelsius: 36.9,
      bpSystolic: 130,
      bpDiastolic: 85,
      heartRate: 78,
      respRate: 17,
      spo2: 98.5,
      bmi: 24.2,
      recordedBy: 'Sarah Mathew (Nurse)',
      recordedAt: '2026-08-27 10:00',
    },
    {
      id: 3,
      patientId: 1,
      tempCelsius: 37.4,
      bpSystolic: 138,
      bpDiastolic: 88,
      heartRate: 84,
      respRate: 18,
      spo2: 97.8,
      bmi: 24.2,
      recordedBy: 'Sarah Mathew (Nurse)',
      recordedAt: '2026-08-26 14:15',
    },
  ]);

  const [notes, setNotes] = useState<ClinicalNote[]>([
    {
      id: 1,
      patientId: 1,
      authorId: 2,
      authorName: 'Dr. Rajesh Sharma',
      noteType: 'CONSULTATION',
      title: 'Cardiology Outpatient Follow-up Evaluation',
      content:
        'Patient reports improved exercise tolerance after titration of Telmisartan. No episodes of exertional chest pain, orthopnea, or palpitation. ECG shows sinus rhythm without ST-T changes. Advised lipid profile and continue current medical therapy.',
      status: 'FINALIZED',
      finalizedAt: '2026-08-28T10:30:00Z',
      createdAt: '2026-08-28T10:15:00Z',
    },
  ]);

  const [diagnoses, setDiagnoses] = useState<Diagnosis[]>([
    {
      id: 1,
      patientId: 1,
      icd10Code: 'I10',
      diagnosisText: 'Essential (Primary) Systemic Hypertension',
      type: 'FINAL',
      status: 'ACTIVE',
      doctorId: 2,
      doctorName: 'Dr. Rajesh Sharma',
      diagnosedAt: '2023-11-10T11:00:00Z',
    },
    {
      id: 2,
      patientId: 1,
      icd10Code: 'E78.0',
      diagnosisText: 'Pure Hypercholesterolemia',
      type: 'FINAL',
      status: 'ACTIVE',
      doctorId: 2,
      doctorName: 'Dr. Rajesh Sharma',
      diagnosedAt: '2024-02-15T10:45:00Z',
    },
  ]);

  const [prescriptions, setPrescriptions] = useState<Prescription[]>([
    {
      id: 1,
      prescriptionNo: 'RX-10001',
      patientId: 1,
      patientName: 'Anand Patil',
      patientMrn: 'MRN-10001',
      doctorId: 2,
      doctorName: 'Dr. Rajesh Sharma',
      status: 'DISPENSED',
      issuedAt: '2026-08-28T10:35:00Z',
      items: [
        {
          id: 1,
          medicineId: 3,
          medicineName: 'Telma 40',
          genericName: 'Telmisartan',
          dosage: '1 Tablet',
          route: 'ORAL',
          frequency: 'ONCE_DAILY',
          durationDays: 30,
          quantityPrescribed: 30,
          quantityDispensed: 30,
          instructions: 'Take once daily in the morning after breakfast',
          status: 'DISPENSED',
        },
        {
          id: 2,
          medicineId: 4,
          medicineName: 'Atorva 20',
          genericName: 'Atorvastatin',
          dosage: '1 Tablet',
          route: 'ORAL',
          frequency: 'ONCE_DAILY',
          durationDays: 30,
          quantityPrescribed: 30,
          quantityDispensed: 30,
          instructions: 'Take once daily at bedtime',
          status: 'DISPENSED',
        },
      ],
    },
  ]);

  useEffect(() => {
    if (id) {
      apiClient
        .get<ApiResponse<Patient>>(`/patients/${id}`)
        .then((res) => {
          if (res.data?.success && res.data?.data) {
            setPatient(res.data.data);
          }
        })
        .catch(() => {});

      apiClient
        .get<ApiResponse<PatientAllergy[]>>(`/clinical/patients/${id}/allergies`)
        .then((res) => {
          if (res.data?.success && res.data?.data) {
            setAllergies(res.data.data);
          }
        })
        .catch(() => {});
    }
  }, [id]);

  const age = new Date().getFullYear() - new Date(patient.dob).getFullYear();

  return (
    <div className="space-y-6">
      {/* Back button & Patient Banner */}
      <div className="flex items-center gap-3">
        <button
          onClick={() => navigate('/patients')}
          className="p-2 bg-white hover:bg-slate-100 rounded-xl border border-slate-200 text-slate-600 transition-colors"
        >
          <ArrowLeft className="h-4 w-4" />
        </button>
        <span className="text-xs text-slate-500 font-medium">Back to Master Patient Index</span>
      </div>

      {/* Patient 360 Header Card */}
      <div className="bg-white p-6 rounded-3xl border border-slate-200 shadow-sm">
        <div className="flex flex-col lg:flex-row lg:items-center justify-between gap-6">
          <div className="flex items-start gap-4">
            <div className="h-16 w-16 rounded-2xl bg-gradient-to-tr from-sky-600 to-teal-500 text-white font-bold text-xl flex items-center justify-center shadow-md">
              {patient.firstName[0]}
              {patient.lastName[0]}
            </div>
            <div>
              <div className="flex items-center gap-3">
                <h1 className="text-xl font-bold text-slate-900">
                  {patient.firstName} {patient.middleName ? `${patient.middleName} ` : ''}
                  {patient.lastName}
                </h1>
                <span className="px-2.5 py-0.5 rounded-full text-xs font-mono font-bold bg-sky-100 text-sky-800">
                  {patient.mrn}
                </span>
                <span className="px-2 py-0.5 rounded-md text-[11px] font-semibold bg-emerald-100 text-emerald-800">
                  {patient.status}
                </span>
              </div>
              <p className="text-xs text-slate-500 mt-1">
                {patient.gender} • Born {patient.dob} ({age} years) • Blood Group:{' '}
                <span className="font-bold text-rose-600">{patient.bloodGroup || 'N/A'}</span>
              </p>
              <p className="text-xs text-slate-600 mt-1">
                Phone: <span className="font-medium text-slate-800">{patient.phone}</span> • Email:{' '}
                <span className="font-medium text-slate-800">{patient.email || 'N/A'}</span> • City:{' '}
                <span className="font-medium text-slate-800">{patient.city}, {patient.state}</span>
              </p>
            </div>
          </div>

          {/* Allergy Critical Warning Badge */}
          {allergies.length > 0 && (
            <div className="p-3 bg-rose-50 border border-rose-200 rounded-2xl flex items-center gap-3">
              <div className="h-9 w-9 rounded-xl bg-rose-500 text-white flex items-center justify-center shrink-0">
                <AlertTriangle className="h-5 w-5" />
              </div>
              <div>
                <p className="text-[11px] font-bold uppercase tracking-wider text-rose-700">
                  Critical Allergy Alert
                </p>
                <p className="text-xs font-semibold text-rose-900">
                  {allergies.map((a) => a.allergen).join(', ')}
                </p>
              </div>
            </div>
          )}
        </div>

        {/* Latest Vitals Snapshot Banner */}
        {vitals.length > 0 && (
          <div className="mt-6 pt-4 border-t border-slate-100 grid grid-cols-2 sm:grid-cols-6 gap-3 text-xs">
            <div className="p-2.5 bg-slate-50 rounded-xl">
              <span className="text-[10px] text-slate-400 font-semibold uppercase">Blood Pressure</span>
              <p className="font-bold text-slate-900 mt-0.5">
                {vitals[0].bpSystolic}/{vitals[0].bpDiastolic} mmHg
              </p>
            </div>
            <div className="p-2.5 bg-slate-50 rounded-xl">
              <span className="text-[10px] text-slate-400 font-semibold uppercase">Heart Rate</span>
              <p className="font-bold text-slate-900 mt-0.5">{vitals[0].heartRate} bpm</p>
            </div>
            <div className="p-2.5 bg-slate-50 rounded-xl">
              <span className="text-[10px] text-slate-400 font-semibold uppercase">Temperature</span>
              <p className="font-bold text-slate-900 mt-0.5">{vitals[0].tempCelsius} °C</p>
            </div>
            <div className="p-2.5 bg-slate-50 rounded-xl">
              <span className="text-[10px] text-slate-400 font-semibold uppercase">Oxygen SpO2</span>
              <p className="font-bold text-emerald-600 mt-0.5">{vitals[0].spo2} %</p>
            </div>
            <div className="p-2.5 bg-slate-50 rounded-xl">
              <span className="text-[10px] text-slate-400 font-semibold uppercase">Resp Rate</span>
              <p className="font-bold text-slate-900 mt-0.5">{vitals[0].respRate} /min</p>
            </div>
            <div className="p-2.5 bg-slate-50 rounded-xl">
              <span className="text-[10px] text-slate-400 font-semibold uppercase">BMI</span>
              <p className="font-bold text-slate-900 mt-0.5">{vitals[0].bmi} kg/m²</p>
            </div>
          </div>
        )}
      </div>

      {/* Navigation Tabs */}
      <div className="flex border-b border-slate-200 gap-2 overflow-x-auto text-xs font-semibold">
        {[
          { key: 'timeline', label: 'Clinical Timeline', icon: Activity },
          { key: 'notes', label: 'Clinical Notes', icon: FileText },
          { key: 'diagnoses', label: 'Diagnoses (ICD-10)', icon: Stethoscope },
          { key: 'vitals', label: 'Vitals Chart', icon: HeartPulse },
          { key: 'prescriptions', label: 'E-Prescriptions', icon: Pill },
          { key: 'lab', label: 'Lab & Diagnostics', icon: TestTube2 },
          { key: 'billing', label: 'Invoices & Billing', icon: Receipt },
        ].map((tab) => {
          const Icon = tab.icon;
          const isActive = activeTab === tab.key;
          return (
            <button
              key={tab.key}
              onClick={() => setActiveTab(tab.key as any)}
              className={`pb-3 px-4 flex items-center gap-2 border-b-2 transition-all whitespace-nowrap ${
                isActive
                  ? 'border-sky-600 text-sky-600 font-bold'
                  : 'border-transparent text-slate-500 hover:text-slate-800'
              }`}
            >
              <Icon className="h-4 w-4" />
              {tab.label}
            </button>
          );
        })}
      </div>

      {/* Tab Content Areas */}
      {activeTab === 'timeline' && (
        <div className="bg-white p-6 rounded-3xl border border-slate-200 shadow-sm space-y-6">
          <h3 className="text-sm font-bold text-slate-900">Chronological Medical Encounter Timeline</h3>
          <div className="relative border-l-2 border-slate-200 ml-4 space-y-8 pl-6">
            <div className="relative">
              <span className="absolute -left-[31px] top-1.5 h-3.5 w-3.5 rounded-full bg-sky-600 ring-4 ring-sky-100" />
              <p className="text-[11px] font-semibold text-sky-600">2026-08-28 • 10:15 AM</p>
              <h4 className="text-xs font-bold text-slate-900 mt-0.5">
                Cardiology Consultation with Dr. Rajesh Sharma
              </h4>
              <p className="text-xs text-slate-600 mt-1">
                Routine hypertension assessment. Blood pressure well-controlled on Telma 40. Advised lipid panel.
              </p>
            </div>
            <div className="relative">
              <span className="absolute -left-[31px] top-1.5 h-3.5 w-3.5 rounded-full bg-teal-600 ring-4 ring-teal-100" />
              <p className="text-[11px] font-semibold text-teal-600">2026-08-28 • 10:40 AM</p>
              <h4 className="text-xs font-bold text-slate-900 mt-0.5">
                Prescription Dispensed at Central Pharmacy
              </h4>
              <p className="text-xs text-slate-600 mt-1">
                Dispensed Telma 40 (30 tablets) and Atorva 20 (30 tablets). Dispensed by Pharmacist Kavita Patel.
              </p>
            </div>
            <div className="relative">
              <span className="absolute -left-[31px] top-1.5 h-3.5 w-3.5 rounded-full bg-indigo-600 ring-4 ring-indigo-100" />
              <p className="text-[11px] font-semibold text-indigo-600">2024-02-15 • 10:00 AM</p>
              <h4 className="text-xs font-bold text-slate-900 mt-0.5">
                Recorded Severe Penicillin Allergy Alert
              </h4>
              <p className="text-xs text-slate-600 mt-1">
                Patient experienced acute bronchospasm following oral Amoxicillin. Flagged in EMR permanently.
              </p>
            </div>
          </div>
        </div>
      )}

      {activeTab === 'notes' && (
        <div className="space-y-4">
          <div className="flex items-center justify-between">
            <h3 className="text-sm font-bold text-slate-900">Clinical Progress & Consultation Notes</h3>
            <button className="px-3.5 py-1.5 bg-sky-600 hover:bg-sky-500 text-white rounded-xl text-xs font-bold shadow-sm flex items-center gap-1.5">
              <Plus className="h-4 w-4" /> Author New Note
            </button>
          </div>
          {notes.map((n) => (
            <div key={n.id} className="bg-white p-6 rounded-3xl border border-slate-200 shadow-sm space-y-2">
              <div className="flex items-center justify-between">
                <div>
                  <h4 className="text-sm font-bold text-slate-900">{n.title}</h4>
                  <p className="text-xs text-slate-500">
                    Authored by <span className="font-semibold text-slate-800">{n.authorName}</span> • {n.noteType}
                  </p>
                </div>
                <span className="px-2.5 py-1 rounded-full text-[10px] font-bold bg-emerald-100 text-emerald-800">
                  {n.status}
                </span>
              </div>
              <p className="text-xs text-slate-700 leading-relaxed pt-2 border-t border-slate-100">
                {n.content}
              </p>
            </div>
          ))}
        </div>
      )}

      {activeTab === 'vitals' && (
        <div className="bg-white p-6 rounded-3xl border border-slate-200 shadow-sm space-y-6">
          <div className="flex items-center justify-between">
            <div>
              <h3 className="text-sm font-bold text-slate-900">Blood Pressure & Heart Rate Longitudinal Trend</h3>
              <p className="text-xs text-slate-500">Systolic/Diastolic mmHg and Heart Rate BPM</p>
            </div>
          </div>
          <div className="h-64 w-full">
            <ResponsiveContainer width="100%" height="100%">
              <LineChart data={[...vitals].reverse()}>
                <CartesianGrid strokeDasharray="3 3" vertical={false} stroke="#f1f5f9" />
                <XAxis dataKey="recordedAt" tickLine={false} axisLine={false} tick={{ fontSize: 11, fill: '#64748b' }} />
                <YAxis tickLine={false} axisLine={false} tick={{ fontSize: 11, fill: '#64748b' }} domain={[50, 160]} />
                <Tooltip />
                <Line type="monotone" dataKey="bpSystolic" name="Systolic BP" stroke="#0ea5e9" strokeWidth={2} dot={{ r: 4 }} />
                <Line type="monotone" dataKey="bpDiastolic" name="Diastolic BP" stroke="#0d9488" strokeWidth={2} dot={{ r: 4 }} />
                <Line type="monotone" dataKey="heartRate" name="Heart Rate (BPM)" stroke="#f43f5e" strokeWidth={2} dot={{ r: 4 }} />
              </LineChart>
            </ResponsiveContainer>
          </div>
        </div>
      )}

      {activeTab === 'diagnoses' && (
        <div className="bg-white p-6 rounded-3xl border border-slate-200 shadow-sm space-y-4">
          <div className="flex items-center justify-between">
            <h3 className="text-sm font-bold text-slate-900">Problem List & ICD-10 Diagnoses</h3>
            <button className="px-3 py-1.5 bg-sky-600 hover:bg-sky-500 text-white rounded-xl text-xs font-semibold flex items-center gap-1">
              <Plus className="h-4 w-4" /> Add Diagnosis
            </button>
          </div>
          <table className="w-full text-left text-xs">
            <thead className="bg-slate-50 text-slate-500 uppercase font-semibold border-b border-slate-200">
              <tr>
                <th className="py-3 px-4">ICD-10 Code</th>
                <th className="py-3 px-4">Diagnosis Description</th>
                <th className="py-3 px-4">Type</th>
                <th className="py-3 px-4">Diagnosed By</th>
                <th className="py-3 px-4">Status</th>
              </tr>
            </thead>
            <tbody className="divide-y divide-slate-100">
              {diagnoses.map((d) => (
                <tr key={d.id}>
                  <td className="py-3 px-4 font-mono font-bold text-sky-700">{d.icd10Code}</td>
                  <td className="py-3 px-4 font-semibold text-slate-900">{d.diagnosisText}</td>
                  <td className="py-3 px-4 text-slate-600">{d.type}</td>
                  <td className="py-3 px-4 text-slate-700">{d.doctorName}</td>
                  <td className="py-3 px-4">
                    <span className="px-2 py-0.5 rounded-full text-[10px] font-bold bg-emerald-100 text-emerald-800">
                      {d.status}
                    </span>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}

      {activeTab === 'prescriptions' && (
        <div className="space-y-4">
          {prescriptions.map((rx) => (
            <div key={rx.id} className="bg-white p-6 rounded-3xl border border-slate-200 shadow-sm space-y-4">
              <div className="flex items-center justify-between">
                <div>
                  <h4 className="text-sm font-bold text-slate-900 font-mono">{rx.prescriptionNo}</h4>
                  <p className="text-xs text-slate-500">
                    Prescribed by {rx.doctorName} on {new Date(rx.issuedAt).toLocaleDateString()}
                  </p>
                </div>
                <span className="px-2.5 py-1 rounded-full text-[10px] font-bold bg-emerald-100 text-emerald-800">
                  {rx.status}
                </span>
              </div>
              <div className="overflow-x-auto">
                <table className="w-full text-left text-xs border border-slate-100 rounded-xl">
                  <thead className="bg-slate-50 text-slate-500 font-semibold">
                    <tr>
                      <th className="py-2.5 px-3">Medicine Name</th>
                      <th className="py-2.5 px-3">Dosage / Route</th>
                      <th className="py-2.5 px-3">Frequency</th>
                      <th className="py-2.5 px-3">Duration</th>
                      <th className="py-2.5 px-3">Quantity</th>
                      <th className="py-2.5 px-3">Instructions</th>
                    </tr>
                  </thead>
                  <tbody className="divide-y divide-slate-100">
                    {rx.items.map((item) => (
                      <tr key={item.id}>
                        <td className="py-2.5 px-3 font-semibold text-slate-900">
                          {item.medicineName}
                          <span className="block text-[10px] text-slate-400 font-normal">
                            {item.genericName}
                          </span>
                        </td>
                        <td className="py-2.5 px-3 text-slate-600">
                          {item.dosage} ({item.route})
                        </td>
                        <td className="py-2.5 px-3 text-slate-600">{item.frequency}</td>
                        <td className="py-2.5 px-3 text-slate-600">{item.durationDays} days</td>
                        <td className="py-2.5 px-3 font-semibold text-slate-800">
                          {item.quantityPrescribed} units
                        </td>
                        <td className="py-2.5 px-3 text-slate-600">{item.instructions}</td>
                      </tr>
                    ))}
                  </tbody>
                </table>
              </div>
            </div>
          ))}
        </div>
      )}
    </div>
  );
};
