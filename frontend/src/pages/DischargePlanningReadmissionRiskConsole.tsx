import React, { useState } from 'react';

interface DischargeChecklist {
  patientId: string;
  patientName: string;
  plannedDischargeDate: string;
  laceScore: number;
  readmissionRiskCategory: 'Low' | 'Moderate' | 'High';
  medReconciliationComplete: boolean;
  followUpAppointmentsBooked: boolean;
  dmeEquipmentDelivered: boolean;
  patientEducationTeachBackPassed: boolean;
  transportationArranged: boolean;
  dischargeSummarySigned: boolean;
}

export const DischargePlanningReadmissionRiskConsole: React.FC = () => {
  const [patients, setPatients] = useState<DischargeChecklist[]>([
    {
      patientId: 'PT-3091',
      patientName: 'Arthur Dent',
      plannedDischargeDate: '2026-09-09',
      laceScore: 12,
      readmissionRiskCategory: 'High',
      medReconciliationComplete: true,
      followUpAppointmentsBooked: true,
      dmeEquipmentDelivered: false,
      patientEducationTeachBackPassed: true,
      transportationArranged: true,
      dischargeSummarySigned: false
    }
  ]);

  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">Project RED Multidisciplinary Discharge &amp; LACE Score Console</h1>
          <p className="text-sm text-slate-400">30-Day Readmission Prevention, Medication Reconciliation &amp; Teach-Back Verification</p>
        </div>
      </header>

      <div className="space-y-6">
        {patients.map((p) => (
          <div key={p.patientId} className="bg-slate-800/80 p-5 rounded-xl border border-slate-700">
            <div className="flex justify-between items-start mb-4">
              <div>
                <span className="text-xs font-mono text-sky-400 font-bold">{p.patientId}</span>
                <h2 className="text-lg font-bold text-white">{p.patientName}</h2>
                <p className="text-xs text-slate-400">Target Discharge Date: {p.plannedDischargeDate}</p>
              </div>
              <div className="text-right">
                <span className="text-xs text-slate-400 block">LACE Index Score</span>
                <span className="text-lg font-mono font-bold text-rose-400">{p.laceScore} / 19 ({p.readmissionRiskCategory} Risk)</span>
              </div>
            </div>

            {/* Project RED 12-Point Checklist Items */}
            <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-3 text-xs mb-4">
              <div className="flex items-center gap-2 p-3 bg-slate-900/80 rounded border border-slate-700/60">
                <input type="checkbox" checked={p.medReconciliationComplete} readOnly className="accent-emerald-500" />
                <span className="text-slate-300">Medication Reconciliation Done</span>
              </div>
              <div className="flex items-center gap-2 p-3 bg-slate-900/80 rounded border border-slate-700/60">
                <input type="checkbox" checked={p.followUpAppointmentsBooked} readOnly className="accent-emerald-500" />
                <span className="text-slate-300">PCP Follow-Up Booked (within 7d)</span>
              </div>
              <div className="flex items-center gap-2 p-3 bg-slate-900/80 rounded border border-slate-700/60">
                <input type="checkbox" checked={p.dmeEquipmentDelivered} readOnly className="accent-emerald-500" />
                <span className={p.dmeEquipmentDelivered ? 'text-slate-300' : 'text-amber-400 font-bold'}>
                  DME / Home O2 Delivered ({p.dmeEquipmentDelivered ? 'YES' : 'PENDING'})
                </span>
              </div>
              <div className="flex items-center gap-2 p-3 bg-slate-900/80 rounded border border-slate-700/60">
                <input type="checkbox" checked={p.patientEducationTeachBackPassed} readOnly className="accent-emerald-500" />
                <span className="text-slate-300">Teach-Back Method Passed</span>
              </div>
              <div className="flex items-center gap-2 p-3 bg-slate-900/80 rounded border border-slate-700/60">
                <input type="checkbox" checked={p.transportationArranged} readOnly className="accent-emerald-500" />
                <span className="text-slate-300">Safe Ride / Transport Confirmed</span>
              </div>
              <div className="flex items-center gap-2 p-3 bg-slate-900/80 rounded border border-slate-700/60">
                <input type="checkbox" checked={p.dischargeSummarySigned} readOnly className="accent-emerald-500" />
                <span className={p.dischargeSummarySigned ? 'text-slate-300' : 'text-sky-400 font-bold'}>
                  Physician DC Summary Signed
                </span>
              </div>
            </div>

            <div className="flex gap-3">
              <button className="bg-sky-600 hover:bg-sky-500 text-white text-xs font-semibold px-4 py-2 rounded">
                Print Patient After-Care Instructions Booklet
              </button>
              <button className="bg-emerald-600 hover:bg-emerald-500 text-white text-xs font-semibold px-4 py-2 rounded">
                Authorize Final Discharge
              </button>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};
