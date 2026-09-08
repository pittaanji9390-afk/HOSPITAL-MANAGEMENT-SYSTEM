import React, { useState } from 'react';
import { Dna, CheckCircle2, ShieldCheck } from 'lucide-react';

export const HbocBrcaConsole: React.FC = () => {
  const [ovarianCancer, setOvarianCancer] = useState(true);
  const [youngBreast, setYoungBreast] = useState(false);

  const meetsTesting = ovarianCancer || youngBreast;

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Dna className="h-7 w-7 text-rose-400" />
          <div>
            <h2 className="text-xl font-bold">HBOC BRCA1 / BRCA2 Testing Criteria</h2>
            <p className="text-xs text-slate-400">NCCN High-Risk Familial Breast & Ovarian Cancer Classifier</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-2 gap-4 my-6 text-xs">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 space-y-2">
          <label className="flex items-center gap-2 text-slate-300 cursor-pointer">
            <input type="checkbox" checked={ovarianCancer} onChange={e => setOvarianCancer(e.target.checked)} className="rounded bg-slate-900 border-slate-700 text-indigo-600" />
            Epithelial Ovarian / Fallopian Tube Cancer at Any Age
          </label>
          <label className="flex items-center gap-2 text-slate-300 cursor-pointer">
            <input type="checkbox" checked={youngBreast} onChange={e => setYoungBreast(e.target.checked)} className="rounded bg-slate-900 border-slate-700 text-indigo-600" />
            Breast Cancer Diagnosed ≤ 50 Years Old
          </label>
        </div>

        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 flex flex-col justify-center font-mono">
          <div>Recommendation: <strong className="text-emerald-400">{meetsTesting ? 'Germline Multi-Gene NGS Panel Indicated' : 'Standard Screening'}</strong></div>
          <div className="text-slate-400 font-sans mt-2">Targeted PARP inhibitors: Olaparib / Talazoparib eligible if positive.</div>
        </div>
      </div>
    </div>
  );
};
