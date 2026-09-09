import React, { useState } from 'react';
import { ShieldCheck, AlertTriangle, CheckCircle2 } from 'lucide-react';

export const TacrolimusTdmConsole: React.FC = () => {
  const [trough, setTrough] = useState(9.4);
  const targetMin = 8.0;
  const targetMax = 12.0;

  const inRange = trough >= targetMin && trough <= targetMax;

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <ShieldCheck className="h-7 w-7 text-indigo-400" />
          <div>
            <h2 className="text-xl font-bold">Tacrolimus Therapeutic Drug Monitoring (TDM)</h2>
            <p className="text-xs text-slate-400">Post-Transplant Trough Level & Rejection / Toxicity Range</p>
          </div>
        </div>
        <span className={'px-3 py-1 rounded-full text-xs font-mono font-bold ' + (
          inRange ? 'bg-emerald-950 text-emerald-300 border border-emerald-700' : 'bg-rose-950 text-rose-300 border border-rose-700'
        )}>
          {inRange ? 'THERAPEUTIC' : 'OUT OF RANGE'}
        </span>
      </div>

      <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 my-6">
        <span className="text-xs text-slate-400 block mb-1">Measured Tacrolimus Trough: {trough} ng/mL</span>
        <input type="range" min="1.0" max="25.0" step="0.1" value={trough} onChange={e => setTrough(Number(e.target.value))} className="w-full" />
        <div className="flex justify-between text-xs font-mono text-slate-400 mt-2">
          <span>Target Range: {targetMin} - {targetMax} ng/mL (Month 1-3)</span>
          <span className={inRange ? 'text-emerald-400 font-bold' : 'text-rose-400 font-bold'}>
            {inRange ? 'Optimal Immunosuppression' : trough < targetMin ? 'Under-immunosuppressed (Rejection Risk)' : 'Nephrotoxicity Risk'}
          </span>
        </div>
      </div>
    </div>
  );
};
