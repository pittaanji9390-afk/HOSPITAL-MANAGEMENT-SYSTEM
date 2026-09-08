import React, { useState } from 'react';
import { Activity, CheckCircle2 } from 'lucide-react';

export const F18DeauvilleConsole: React.FC = () => {
  const [deauville, setDeauville] = useState(2);

  const isCmr = deauville <= 3;

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Activity className="h-7 w-7 text-indigo-400" />
          <div>
            <h2 className="text-xl font-bold">F-18 FDG PET/CT Deauville 5-Point Scale</h2>
            <p className="text-xs text-slate-400">Lugano Classification for Lymphoma Metabolic Response</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-2 gap-4 my-6">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800">
          <span className="text-xs text-slate-400 block mb-1">Deauville Score: Score {deauville}</span>
          <input type="range" min="1" max="5" value={deauville} onChange={e => setDeauville(Number(e.target.value))} className="w-full" />
        </div>

        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 flex flex-col justify-center text-xs font-mono">
          <div>Metabolic Response: <strong className={isCmr ? 'text-emerald-400 font-bold' : 'text-rose-400'}>
            {isCmr ? 'Complete Metabolic Response (CMR / Negative)' : 'Residual Metabolic Disease (Positive)'}
          </strong></div>
        </div>
      </div>
    </div>
  );
};
