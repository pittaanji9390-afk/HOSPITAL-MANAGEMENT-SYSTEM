import React, { useState } from 'react';
import { Activity, Calculator, ShieldCheck, AlertOctagon, Heart } from 'lucide-react';

export const MeldNaAllocationStudio: React.FC = () => {
  const [bili, setBili] = useState(2.8);
  const [inr, setInr] = useState(2.1);
  const [cr, setCr] = useState(1.9);
  const [na, setNa] = useState(128);
  const [dialysis, setDialysis] = useState(false);

  // Math
  const b = Math.max(1.0, bili);
  const i = Math.max(1.0, inr);
  const c = dialysis ? 4.0 : Math.min(4.0, Math.max(1.0, cr));
  const s = Math.min(137.0, Math.max(125.0, na));

  let rawMeld = (0.957 * Math.log(c)) + (0.378 * Math.log(b)) + (1.120 * Math.log(i)) + 0.643;
  rawMeld = Math.round(rawMeld * 10);

  let finalMeldNa = rawMeld;
  if (rawMeld > 11) {
    const mNa = rawMeld + 1.32 * (137.0 - s) - (0.033 * rawMeld * (137.0 - s));
    finalMeldNa = Math.min(40, Math.max(6, Math.round(mNa)));
  }

  const mortality = finalMeldNa >= 35 ? 71.3 : finalMeldNa >= 25 ? 52.6 : finalMeldNa >= 20 ? 19.6 : 6.0;

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Calculator className="h-7 w-7 text-amber-400" />
          <div>
            <h2 className="text-xl font-bold">UNOS / OPTN MELD-Na Liver Allocation Calculator</h2>
            <p className="text-xs text-slate-400">Policy 9 Serum Sodium Adjusted Model for End-Stage Liver Disease</p>
          </div>
        </div>
        <span className="px-3 py-1 bg-amber-950 text-amber-300 border border-amber-700/60 rounded-full text-xs font-mono">
          OPTN 2016 STANDARD
        </span>
      </div>

      <div className="grid grid-cols-2 gap-5 my-6">
        <div className="bg-slate-950 p-4 rounded-xl border border-slate-800 space-y-3">
          <div>
            <label className="text-xs text-slate-400 block mb-1">Serum Bilirubin (mg/dL)</label>
            <input type="number" step="0.1" value={bili} onChange={e => setBili(Number(e.target.value))} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-slate-200" />
          </div>
          <div>
            <label className="text-xs text-slate-400 block mb-1">INR (International Normalized Ratio)</label>
            <input type="number" step="0.1" value={inr} onChange={e => setInr(Number(e.target.value))} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-slate-200" />
          </div>
          <div>
            <label className="text-xs text-slate-400 block mb-1">Serum Creatinine (mg/dL)</label>
            <input type="number" step="0.1" value={cr} onChange={e => setCr(Number(e.target.value))} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-slate-200" />
          </div>
          <div>
            <label className="text-xs text-slate-400 block mb-1">Serum Sodium (mEq/L)</label>
            <input type="number" value={na} onChange={e => setNa(Number(e.target.value))} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-slate-200" />
          </div>
          <div className="pt-1">
            <label className="flex items-center gap-2 text-xs text-slate-300 cursor-pointer">
              <input type="checkbox" checked={dialysis} onChange={e => setDialysis(e.target.checked)} className="rounded bg-slate-900 border-slate-700 text-amber-500" />
              Dialysis 2x or CVVH in Past 7 Days
            </label>
          </div>
        </div>

        <div className="bg-slate-950 p-4 rounded-xl border border-slate-800 flex flex-col justify-between text-center">
          <div>
            <span className="text-xs text-slate-400 block mb-1">Calculated MELD-Na Score</span>
            <span className="text-5xl font-extrabold font-mono text-amber-400">{finalMeldNa}</span>
            <p className="text-xs text-slate-400 mt-2">Raw MELD: {rawMeld}</p>
          </div>
          <div className="p-3 bg-slate-900 rounded-lg border border-slate-800 font-mono text-xs">
            <div className="text-slate-400">Estimated 90-Day Mortality: <strong className="text-rose-400">{mortality}%</strong></div>
            <div className="text-slate-400 mt-1">Allocation Tier: <strong className="text-white">{finalMeldNa >= 35 ? 'TIER 1 (HIGH URGENCY)' : 'ROUTINE WAITLIST'}</strong></div>
          </div>
        </div>
      </div>
    </div>
  );
};
