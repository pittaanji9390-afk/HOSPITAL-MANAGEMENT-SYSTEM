import React, { useState } from 'react';
import { ShieldCheck, Scale, CheckCircle2 } from 'lucide-react';

export const KdpiEptsConsole: React.FC = () => {
  const [donorKdpi, setDonorKdpi] = useState(18);
  const [candidateEpts, setCandidateEpts] = useState(15);

  const isTop20 = donorKdpi <= 20 && candidateEpts <= 20;

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Scale className="h-7 w-7 text-indigo-400" />
          <div>
            <h2 className="text-xl font-bold">Kidney Allocation System (KAS) KDPI & EPTS Matcher</h2>
            <p className="text-xs text-slate-400">UNOS Top 20% Longevity Kidney & Candidate Matching Engine</p>
          </div>
        </div>
        <span className={'px-3 py-1 rounded-full text-xs font-mono font-bold ' + (
          isTop20 ? 'bg-emerald-950 text-emerald-300 border border-emerald-700' : 'bg-indigo-950 text-indigo-300 border border-indigo-700'
        )}>
          {isTop20 ? 'TOP 20% LONGEVITY MATCH' : 'STANDARD MATCH'}
        </span>
      </div>

      <div className="grid grid-cols-2 gap-4 my-6">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800">
          <span className="text-xs text-slate-400 block mb-1">Donor KDPI Percentile: {donorKdpi}%</span>
          <input type="range" min="1" max="100" value={donorKdpi} onChange={e => setDonorKdpi(Number(e.target.value))} className="w-full" />
          <p className="text-xs text-slate-400 mt-2">Lower KDPI = Longer expected graft survival</p>
        </div>
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800">
          <span className="text-xs text-slate-400 block mb-1">Recipient EPTS Percentile: {candidateEpts}%</span>
          <input type="range" min="1" max="100" value={candidateEpts} onChange={e => setCandidateEpts(Number(e.target.value))} className="w-full" />
          <p className="text-xs text-slate-400 mt-2">Lower EPTS = Longer expected candidate survival</p>
        </div>
      </div>
    </div>
  );
};
