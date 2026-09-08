import React, { useState } from 'react';
import { ShieldCheck, CheckCircle2, AlertOctagon } from 'lucide-react';

export const LynchSyndromeConsole: React.FC = () => {
  const [relativesCount, setRelativesCount] = useState(3);
  const [successiveGens, setSuccessiveGens] = useState(2);
  const [under50, setUnder50] = useState(true);

  const meetsAmsterdam = relativesCount >= 3 && successiveGens >= 2 && under50;

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <ShieldCheck className="h-7 w-7 text-indigo-400" />
          <div>
            <h2 className="text-xl font-bold">Lynch Syndrome Amsterdam II Clinical Evaluator</h2>
            <p className="text-xs text-slate-400">3-2-1 Rule & MMR (MLH1/MSH2/MSH6/PMS2) Germline Gate</p>
          </div>
        </div>
        <span className={'px-3 py-1 rounded-full text-xs font-mono font-bold ' + (
          meetsAmsterdam ? 'bg-rose-950 text-rose-300 border border-rose-700' : 'bg-emerald-950 text-emerald-300 border border-emerald-700'
        )}>
          {meetsAmsterdam ? 'AMSTERDAM II CRITERIA MET' : 'CRITERIA NOT MET'}
        </span>
      </div>

      <div className="grid grid-cols-2 gap-4 my-6 text-xs">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 space-y-3">
          <div>
            <span className="text-slate-400 block mb-1">Lynch Cancers in Relatives: {relativesCount}</span>
            <input type="range" min="0" max="6" value={relativesCount} onChange={e => setRelativesCount(Number(e.target.value))} className="w-full" />
          </div>
          <div>
            <span className="text-slate-400 block mb-1">Successive Generations: {successiveGens}</span>
            <input type="range" min="1" max="4" value={successiveGens} onChange={e => setSuccessiveGens(Number(e.target.value))} className="w-full" />
          </div>
        </div>

        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 flex flex-col justify-center font-mono">
          <div>Status: <strong className="text-white">{meetsAmsterdam ? 'High Risk Germline Lynch' : 'Standard Evaluation'}</strong></div>
          <div className="text-slate-400 font-sans mt-2">Recommendation: Colonoscopy Q1-2Y starting at age 20-25 + Germline MMR Panel.</div>
        </div>
      </div>
    </div>
  );
};
