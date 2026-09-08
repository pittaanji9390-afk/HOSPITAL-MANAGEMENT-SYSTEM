import React, { useState } from 'react';
import { AlertOctagon, CheckCircle2, UserCheck, ShieldAlert, KeyRound } from 'lucide-react';

export const IsmpHighAlertConsole: React.FC = () => {
  const [selectedDrug, setSelectedDrug] = useState('Insulin Regular Infusion');
  const [prescribedDose, setPrescribedDose] = useState('14.0');
  const [units] = useState('Units/hr');
  const [primaryNurseBadge, setPrimaryNurseBadge] = useState('RN-88492');
  const [secondaryNurseBadge, setSecondaryNurseBadge] = useState('');
  const [isVerified, setIsVerified] = useState(false);

  const handleVerify = (e: React.FormEvent) => {
    e.preventDefault();
    if (!secondaryNurseBadge) {
      alert('Independent co-signature required.');
      return;
    }
    if (primaryNurseBadge === secondaryNurseBadge) {
      alert('ISMP Guardrail Violation: Dual-nurse co-signature requires two distinct authorized staff badges.');
      return;
    }
    setIsVerified(true);
  };

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <AlertOctagon className="h-7 w-7 text-rose-400" />
          <div>
            <h2 className="text-xl font-bold">ISMP High-Alert PINCH Independent Double-Check</h2>
            <p className="text-xs text-slate-400">Dual-Nurse Verification for Potassium, Insulin, Narcotics, Chemo & Heparin</p>
          </div>
        </div>
        <span className="px-3 py-1 bg-rose-950 text-rose-300 border border-rose-700/60 rounded-full text-xs font-mono">
          MANDATORY DUAL-SIGN
        </span>
      </div>

      <div className="grid grid-cols-2 gap-6 my-6">
        <div className="bg-slate-950 p-5 rounded-xl border border-slate-800 space-y-4">
          <h3 className="text-sm font-semibold text-slate-300">Medication & Dose Parameters</h3>
          <div>
            <label className="text-xs text-slate-400 block mb-1">High-Alert Medication</label>
            <select value={selectedDrug} onChange={e => { setSelectedDrug(e.target.value); setIsVerified(false); }} className="w-full bg-slate-900 border border-slate-700 rounded px-3 py-2 text-sm text-slate-200">
              <option>Insulin Regular Infusion (Units/hr)</option>
              <option>Heparin Sodium Infusion (Units/hr)</option>
              <option>Potassium Chloride IV Piggyback (mEq/hr)</option>
              <option>Morphine PCA Continuous + Demand (mg/hr)</option>
              <option>Cisplatin Chemo Infusion (mg/m²)</option>
            </select>
          </div>
          <div className="grid grid-cols-2 gap-3">
            <div>
              <label className="text-xs text-slate-400 block mb-1">Infusion Rate / Dose</label>
              <input type="text" value={prescribedDose} onChange={e => { setPrescribedDose(e.target.value); setIsVerified(false); }} className="w-full bg-slate-900 border border-slate-700 rounded px-3 py-2 text-sm text-slate-200 font-mono font-bold" />
            </div>
            <div>
              <label className="text-xs text-slate-400 block mb-1">Unit of Measure</label>
              <input type="text" value={units} className="w-full bg-slate-900 border border-slate-700 rounded px-3 py-2 text-sm text-slate-400 font-mono" readOnly />
            </div>
          </div>
        </div>

        <div className="bg-slate-950 p-5 rounded-xl border border-slate-800 flex flex-col justify-between">
          <form onSubmit={handleVerify} className="space-y-4">
            <h3 className="text-sm font-semibold text-slate-300">Independent Dual-Nurse Signatures</h3>
            <div>
              <label className="text-xs text-slate-400 block mb-1">Primary Nurse Badge ID</label>
              <input type="text" value={primaryNurseBadge} onChange={e => setPrimaryNurseBadge(e.target.value)} className="w-full bg-slate-900 border border-slate-700 rounded px-3 py-2 text-sm text-slate-200 font-mono" required />
            </div>
            <div>
              <label className="text-xs text-slate-400 block mb-1">Secondary Independent Nurse Badge ID</label>
              <input type="text" value={secondaryNurseBadge} placeholder="Scan second RN badge..." onChange={e => { setSecondaryNurseBadge(e.target.value); setIsVerified(false); }} className="w-full bg-slate-900 border border-slate-700 rounded px-3 py-2 text-sm text-amber-300 font-mono" required />
            </div>

            <button type="submit" className="w-full py-2.5 bg-indigo-600 hover:bg-indigo-500 text-white font-bold rounded-lg text-xs uppercase tracking-wider flex items-center justify-center gap-2">
              <UserCheck className="h-4 w-4" /> Authenticate Independent Double-Check
            </button>
          </form>

          {isVerified && (
            <div className="mt-3 p-3 bg-emerald-950/60 border border-emerald-700 rounded-lg flex items-center gap-2 text-emerald-300 text-xs">
              <CheckCircle2 className="h-4 w-4 text-emerald-400" />
              Smart Pump Guardrail Bypass Unlocked: Safe to initiate infusion.
            </div>
          )}
        </div>
      </div>
    </div>
  );
};
