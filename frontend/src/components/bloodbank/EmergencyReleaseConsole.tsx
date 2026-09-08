import React, { useState } from 'react';
import { AlertTriangle, ShieldAlert, CheckCircle2, User } from 'lucide-react';

export const EmergencyReleaseConsole: React.FC = () => {
  const [patientAge, setPatientAge] = useState(28);
  const [isFemale, setIsFemale] = useState(true);

  const bloodChoice = (isFemale && patientAge <= 50) ? 'O Rh-Negative (Prevent RhD Alloimmunization)' : 'O Rh-Positive';

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <AlertTriangle className="h-7 w-7 text-amber-400" />
          <div>
            <h2 className="text-xl font-bold">Emergency Uncrossmatched Blood Release</h2>
            <p className="text-xs text-slate-400">Emergency Attending Override & Age/Gender Rh-D Allocation Gate</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-2 gap-4 my-6">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 space-y-3">
          <div>
            <span className="text-xs text-slate-400 block mb-1">Patient Age: {patientAge} years</span>
            <input type="range" min="1" max="90" value={patientAge} onChange={e => setPatientAge(Number(e.target.value))} className="w-full" />
          </div>
          <div>
            <label className="flex items-center gap-2 text-xs text-slate-300 cursor-pointer">
              <input type="checkbox" checked={isFemale} onChange={e => setIsFemale(e.target.checked)} className="rounded bg-slate-900 border-slate-700 text-indigo-600" />
              Female of Childbearing Potential
            </label>
          </div>
        </div>

        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 flex flex-col justify-center items-center text-center">
          <span className="text-xs text-slate-400">Mandated Emergency Blood Group</span>
          <span className="text-base font-bold font-mono text-rose-400 my-2">{bloodChoice}</span>
          <span className="text-xs text-slate-400 font-mono">Retrospective Type & Screen In Progress</span>
        </div>
      </div>
    </div>
  );
};
