import React, { useState } from 'react';
import { ShieldAlert, CheckCircle2, Flame } from 'lucide-react';

export const I131AblationStudio: React.FC = () => {
  const [doseMci, setDoseMci] = useState(100);
  const [doseRateAt1m, setDoseRateAt1m] = useState(3.4); // mrem/hr

  const canRelease = doseRateAt1m <= 5.0;

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Flame className="h-7 w-7 text-amber-400" />
          <div>
            <h2 className="text-xl font-bold">Radioiodine I-131 Thyroid Ablation & NRC Release</h2>
            <p className="text-xs text-slate-400">10 CFR 35.75 Public Dose Rate (&lt; 5.0 mrem/hr @ 1 Meter) Clearance Gate</p>
          </div>
        </div>
        <span className={'px-3 py-1 rounded-full text-xs font-mono font-bold ' + (
          canRelease ? 'bg-emerald-950 text-emerald-300 border border-emerald-700' : 'bg-rose-950 text-rose-300 border border-rose-700'
        )}>
          {canRelease ? 'PATIENT DISCHARGE APPROVED' : 'HOSPITAL ISOLATION REQUIRED'}
        </span>
      </div>

      <div className="grid grid-cols-2 gap-4 my-6">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 space-y-3">
          <div>
            <span className="text-xs text-slate-400 block mb-1">Prescribed I-131 Activity: {doseMci} mCi</span>
            <input type="range" min="30" max="200" value={doseMci} onChange={e => setDoseMci(Number(e.target.value))} className="w-full" />
          </div>
          <div>
            <span className="text-xs text-slate-400 block mb-1">Measured Dose Rate at 1 Meter: {doseRateAt1m} mrem/hr</span>
            <input type="range" min="0.5" max="12.0" step="0.1" value={doseRateAt1m} onChange={e => setDoseRateAt1m(Number(e.target.value))} className="w-full" />
          </div>
        </div>

        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 flex flex-col justify-center text-xs font-mono">
          <div>NRC Release Threshold: <strong className="text-white">&lt;= 5.0 mrem/hr at 1 meter</strong></div>
          <div className="mt-2 text-slate-400 font-sans">Mandated Home Isolation: <strong>{doseMci > 100 ? '5 Days' : '3 Days'}</strong> separate bedroom / bathroom.</div>
        </div>
      </div>
    </div>
  );
};
