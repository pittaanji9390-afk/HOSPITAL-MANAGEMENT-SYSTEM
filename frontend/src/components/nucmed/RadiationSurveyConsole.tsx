import React, { useState } from 'react';
import { ShieldAlert, CheckCircle2 } from 'lucide-react';

export const RadiationSurveyConsole: React.FC = () => {
  const [doseRate, setDoseRate] = useState(0.4); // mR/hr (Trigger > 2.0)
  const isSafe = doseRate < 2.0;

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <ShieldAlert className="h-7 w-7 text-emerald-400" />
          <div>
            <h2 className="text-xl font-bold">Hot Lab Radiation Safety Survey Ledger</h2>
            <p className="text-xs text-slate-400">Daily Ludlum Geiger-Muller Ambient Survey & Wipe Test Records</p>
          </div>
        </div>
        <span className={'px-3 py-1 rounded-full text-xs font-mono font-bold ' + (
          isSafe ? 'bg-emerald-950 text-emerald-300 border border-emerald-700' : 'bg-rose-950 text-rose-300 border border-rose-700'
        )}>
          {isSafe ? 'RADIATION LEVELS NORMAL' : 'CONTAMINATION ALARM'}
        </span>
      </div>

      <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 my-6 text-xs font-mono">
        <span className="text-slate-400 block mb-1">Dose Calibrator Area Ambient Rate: {doseRate} mR/hr</span>
        <input type="range" min="0.1" max="5.0" step="0.1" value={doseRate} onChange={e => setDoseRate(Number(e.target.value))} className="w-full" />
        <p className="text-slate-500 mt-2">NRC Action Trigger: &gt; 2.0 mR/hr in restricted area</p>
      </div>
    </div>
  );
};
