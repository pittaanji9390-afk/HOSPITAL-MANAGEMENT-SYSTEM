import React, { useState } from 'react';
import { Activity, ShieldCheck, CheckCircle2 } from 'lucide-react';

export const MasccNeutropeniaConsole: React.FC = () => {
  const [burdenScore, setBurdenScore] = useState(5); // 5 = mild
  const [noHypotension, setNoHypotension] = useState(true); // 5
  const [noCopd, setNoCopd] = useState(true); // 4
  const [solidTumor, setSolidTumor] = useState(true); // 4
  const [noDehydration, setNoDehydration] = useState(true); // 3

  let total = burdenScore;
  if (noHypotension) total += 5;
  if (noCopd) total += 4;
  if (solidTumor) total += 4;
  if (noDehydration) total += 3;

  const isLowRisk = total >= 21;

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Activity className="h-7 w-7 text-indigo-400" />
          <div>
            <h2 className="text-xl font-bold">MASCC Febrile Neutropenia Risk Calculator</h2>
            <p className="text-xs text-slate-400">Stratification for Outpatient Oral vs Inpatient IV Antipseudomonals</p>
          </div>
        </div>
        <span className={'px-3 py-1 rounded-full text-xs font-mono font-bold ' + (
          isLowRisk ? 'bg-emerald-950 text-emerald-300 border border-emerald-700' : 'bg-rose-950 text-rose-300 border border-rose-700'
        )}>
          MASCC SCORE: {total} ({isLowRisk ? 'LOW RISK' : 'HIGH RISK'})
        </span>
      </div>

      <div className="grid grid-cols-2 gap-4 my-6 text-xs">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 space-y-2">
          <label className="flex items-center gap-2 text-slate-300 cursor-pointer">
            <input type="checkbox" checked={noHypotension} onChange={e => setNoHypotension(e.target.checked)} className="rounded bg-slate-900 border-slate-700 text-indigo-600" />
            No Hypotension (SBP &gt; 90 mmHg) [+5 pts]
          </label>
          <label className="flex items-center gap-2 text-slate-300 cursor-pointer">
            <input type="checkbox" checked={noCopd} onChange={e => setNoCopd(e.target.checked)} className="rounded bg-slate-900 border-slate-700 text-indigo-600" />
            No COPD [+4 pts]
          </label>
          <label className="flex items-center gap-2 text-slate-300 cursor-pointer">
            <input type="checkbox" checked={solidTumor} onChange={e => setSolidTumor(e.target.checked)} className="rounded bg-slate-900 border-slate-700 text-indigo-600" />
            Solid Tumor / No Previous Fungal Infection [+4 pts]
          </label>
          <label className="flex items-center gap-2 text-slate-300 cursor-pointer">
            <input type="checkbox" checked={noDehydration} onChange={e => setNoDehydration(e.target.checked)} className="rounded bg-slate-900 border-slate-700 text-indigo-600" />
            No Dehydration [+3 pts]
          </label>
        </div>

        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 flex flex-col justify-center">
          <span className="text-slate-400 mb-1">Recommended Antibiotic Strategy:</span>
          <p className="text-white font-mono font-bold leading-relaxed">
            {isLowRisk ? 'Outpatient Oral: Ciprofloxacin 750mg + Augmentin 875mg BID' : 'Emergency Inpatient IV: Cefepime 2g IV Q8H within 60 minutes'}
          </p>
        </div>
      </div>
    </div>
  );
};
