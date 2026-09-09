import React, { useState } from 'react';
import {
  Activity,
  HeartPulse,
  Pill,
  AlertTriangle,
  CheckCircle2,
  Calendar,
  Layers,
  User,
  Clock,
  Plus,
} from 'lucide-react';

interface ChemoSession {
  id: number;
  patientName: string;
  patientMrn: string;
  cancerDiagnosis: string;
  regimenName: string;
  cycleNumber: number;
  totalCycles: number;
  bsaM2: number;
  scheduledDate: string;
  preMedicationsGiven: boolean;
  status: 'PRE_MEDS' | 'INFUSING' | 'OBSERVATION' | 'COMPLETED';
  drugs: { name: string; dose: string; vehicle: string; duration: string; completed: boolean }[];
}

export const OncologyDaycare: React.FC = () => {
  const [sessions, setSessions] = useState<ChemoSession[]>([
    {
      id: 1,
      patientName: 'Meera Deshmukh',
      patientMrn: 'MRN-10034',
      cancerDiagnosis: 'Invasive Ductal Carcinoma of Breast (Stage IIB, HER2-)',
      regimenName: 'Doxorubicin + Cyclophosphamide (AC)',
      cycleNumber: 2,
      totalCycles: 4,
      bsaM2: 1.68,
      scheduledDate: '2026-08-29',
      preMedicationsGiven: true,
      status: 'INFUSING',
      drugs: [
        {
          name: 'Doxorubicin (Adriamycin)',
          dose: '100.8 mg (60 mg/m²)',
          vehicle: '50 mL Normal Saline IV Push',
          duration: '15 mins',
          completed: true,
        },
        {
          name: 'Cyclophosphamide (Cytoxan)',
          dose: '1008 mg (600 mg/m²)',
          vehicle: '500 mL Normal Saline IV Infusion',
          duration: '60 mins',
          completed: false,
        },
      ],
    },
    {
      id: 2,
      patientName: 'Vikram Singhania',
      patientMrn: 'MRN-10003',
      cancerDiagnosis: 'Sigmoid Colon Adenocarcinoma (Stage III, KRAS Wild-type)',
      regimenName: 'mFOLFOX6 (Oxaliplatin + Leucovorin + 5-FU)',
      cycleNumber: 4,
      totalCycles: 12,
      bsaM2: 1.85,
      scheduledDate: '2026-08-29',
      preMedicationsGiven: true,
      status: 'PRE_MEDS',
      drugs: [
        {
          name: 'Oxaliplatin',
          dose: '157.25 mg (85 mg/m²)',
          vehicle: '500 mL D5W Infusion (NO SALINE)',
          duration: '120 mins',
          completed: false,
        },
        {
          name: 'Leucovorin',
          dose: '740 mg (400 mg/m²)',
          vehicle: '500 mL D5W Infusion',
          duration: '120 mins',
          completed: false,
        },
      ],
    },
  ]);

  return (
    <div className="space-y-6">
      {/* Header */}
      <div className="flex flex-col sm:flex-row sm:items-center justify-between gap-4 bg-white p-6 rounded-3xl border border-slate-200 shadow-sm">
        <div>
          <h1 className="text-xl font-bold text-slate-900 tracking-tight flex items-center gap-2">
            <Activity className="h-6 w-6 text-sky-600" />
            Medical Oncology & Daycare Chemotherapy Center
          </h1>
          <p className="text-xs text-slate-500 mt-1">
            NCCN chemotherapy regimens, BSA-adjusted dosing verification, extravasation checks, and cycle tracking
          </p>
        </div>

        <div className="flex items-center gap-2 px-3 py-1.5 bg-rose-50 border border-rose-200 text-rose-800 rounded-xl text-xs font-bold">
          <AlertTriangle className="h-4 w-4 text-rose-600" />
          <span>High-Alert Cytotoxic Protocols</span>
        </div>
      </div>

      {/* Active Daycare Chemo Infusion Sessions */}
      <div className="space-y-6">
        {sessions.map((sess) => (
          <div
            key={sess.id}
            className="bg-white p-6 rounded-3xl border border-slate-200 shadow-sm space-y-4"
          >
            <div className="flex items-center justify-between flex-wrap gap-2 pb-4 border-b border-slate-100">
              <div>
                <span className="text-[10px] font-mono font-bold text-sky-700">{sess.patientMrn}</span>
                <h3 className="text-base font-bold text-slate-900 mt-0.5">
                  {sess.patientName} •{' '}
                  <span className="text-xs font-normal text-slate-500">{sess.cancerDiagnosis}</span>
                </h3>
                <p className="text-xs text-slate-600 mt-1">
                  Regimen: <span className="font-bold text-slate-900">{sess.regimenName}</span> (Cycle{' '}
                  {sess.cycleNumber} of {sess.totalCycles}) • Verified BSA:{' '}
                  <span className="font-bold text-sky-700">{sess.bsaM2} m²</span>
                </p>
              </div>

              <span className="px-3 py-1 rounded-full text-xs font-bold bg-sky-100 text-sky-800">
                Status: {sess.status}
              </span>
            </div>

            {/* Drugs List */}
            <div className="space-y-2">
              <h4 className="text-xs font-bold text-slate-800 uppercase tracking-wider">
                Infusion Sequence & Verification
              </h4>
              <div className="grid grid-cols-1 md:grid-cols-2 gap-3">
                {sess.drugs.map((drug, dIdx) => (
                  <div
                    key={dIdx}
                    className={`p-4 rounded-2xl border ${
                      drug.completed
                        ? 'bg-emerald-50/60 border-emerald-200 text-emerald-900'
                        : 'bg-slate-50 border-slate-200 text-slate-800'
                    } flex items-center justify-between text-xs`}
                  >
                    <div>
                      <div className="flex items-center gap-2">
                        <span className="font-bold text-slate-900">{drug.name}</span>
                        {drug.completed && (
                          <CheckCircle2 className="h-4 w-4 text-emerald-600 shrink-0" />
                        )}
                      </div>
                      <p className="text-sky-700 font-semibold mt-0.5">{drug.dose}</p>
                      <p className="text-[11px] text-slate-500 mt-0.5">{drug.vehicle} • {drug.duration}</p>
                    </div>

                    {!drug.completed && (
                      <button
                        onClick={() => {
                          const updated = [...sessions];
                          drug.completed = true;
                          setSessions(updated);
                        }}
                        className="px-3 py-1.5 bg-slate-900 hover:bg-emerald-600 text-white rounded-xl font-semibold text-[11px] transition-colors"
                      >
                        Verify & Infuse
                      </button>
                    )}
                  </div>
                ))}
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};
