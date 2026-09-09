import React, { useState } from 'react';
import { Microscope, CheckCircle2, AlertOctagon } from 'lucide-react';

export const BanffStagingStudio: React.FC = () => {
  const [iScore, setIScore] = useState(2);
  const [tScore, setTScore] = useState(2);
  const [vScore, setVScore] = useState(0);

  const isTcmr = iScore >= 2 && tScore >= 2;

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Microscope className="h-7 w-7 text-indigo-400" />
          <div>
            <h2 className="text-xl font-bold">Banff 2019 Allograft Biopsy Staging</h2>
            <p className="text-xs text-slate-400">T-Cell Mediated & Antibody-Mediated Rejection Lesion Scoring</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-3 gap-4 my-6 text-xs">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800">
          <span className="text-slate-400 block mb-1">Interstitial Inflammation (i): {iScore}</span>
          <input type="range" min="0" max="3" value={iScore} onChange={e => setIScore(Number(e.target.value))} className="w-full" />
        </div>
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800">
          <span className="text-slate-400 block mb-1">Tubulitis (t): {tScore}</span>
          <input type="range" min="0" max="3" value={tScore} onChange={e => setTScore(Number(e.target.value))} className="w-full" />
        </div>
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800">
          <span className="text-slate-400 block mb-1">Intimal Arteritis (v): {vScore}</span>
          <input type="range" min="0" max="3" value={vScore} onChange={e => setVScore(Number(e.target.value))} className="w-full" />
        </div>
      </div>

      <div className={'p-3 rounded-lg border text-xs font-mono font-bold ' + (
        isTcmr ? 'bg-rose-950 text-rose-300 border-rose-800' : 'bg-emerald-950 text-emerald-300 border-emerald-800'
      )}>
        Diagnosis: {isTcmr ? 'TCMR GRADE IB (High-Dose Solu-Medrol Indicated)' : 'NO SIGNIFICANT TCMR'}
      </div>
    </div>
  );
};
