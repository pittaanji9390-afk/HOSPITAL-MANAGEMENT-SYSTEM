import React, { useState } from 'react';
import { Dna, CheckCircle2, AlertOctagon, ShieldCheck } from 'lucide-react';

export const AcmgClassificationStudio: React.FC = () => {
  const [pvs1, setPvs1] = useState(true);
  const [psCount, setPsCount] = useState(1);
  const [pmCount, setPmCount] = useState(2);
  const [ppCount, setPpCount] = useState(2);

  let classification = 'VARIANT OF UNCERTAIN SIGNIFICANCE (VUS)';
  if (pvs1 && (psCount >= 1 || pmCount >= 2)) {
    classification = 'PATHOGENIC (CLASS 5)';
  } else if (pvs1 && pmCount >= 1) {
    classification = 'LIKELY PATHOGENIC (CLASS 4)';
  }

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Dna className="h-7 w-7 text-indigo-400 animate-pulse" />
          <div>
            <h2 className="text-xl font-bold">ACMG / AMP Sequence Variant Pathogenicity Studio</h2>
            <p className="text-xs text-slate-400">PVS1, PS, PM, PP Combinatorial Evidence Classifier</p>
          </div>
        </div>
        <span className={'px-3 py-1 rounded-full text-xs font-mono font-bold ' + (
          classification.includes('PATHOGENIC') ? 'bg-rose-950 text-rose-300 border border-rose-700' : 'bg-amber-950 text-amber-300 border border-amber-700'
        )}>
          {classification}
        </span>
      </div>

      <div className="grid grid-cols-2 gap-4 my-6">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 space-y-3">
          <label className="flex items-center gap-2 text-xs text-slate-300 cursor-pointer">
            <input type="checkbox" checked={pvs1} onChange={e => setPvs1(e.target.checked)} className="rounded bg-slate-900 border-slate-700 text-indigo-600" />
            PVS1: Null Variant (Nonsense / Frameshift / Canonical Splice)
          </label>
          <div>
            <span className="text-xs text-slate-400 block mb-1">PS (Strong Criteria Count): {psCount}</span>
            <input type="range" min="0" max="4" value={psCount} onChange={e => setPsCount(Number(e.target.value))} className="w-full" />
          </div>
          <div>
            <span className="text-xs text-slate-400 block mb-1">PM (Moderate Criteria Count): {pmCount}</span>
            <input type="range" min="0" max="6" value={pmCount} onChange={e => setPmCount(Number(e.target.value))} className="w-full" />
          </div>
        </div>

        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 flex flex-col justify-center items-center text-center">
          <span className="text-xs text-slate-400">ACMG 2015 Classification Result</span>
          <span className="text-xl font-extrabold font-mono text-rose-400 my-2">{classification}</span>
          <span className="text-xs text-slate-400 font-mono">Actionable for clinical decision-making.</span>
        </div>
      </div>
    </div>
  );
};
