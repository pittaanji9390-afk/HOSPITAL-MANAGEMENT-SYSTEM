import React, { useState } from 'react';
import { ShieldAlert, CheckCircle2, Activity } from 'lucide-react';

export const CmvSurveillanceConsole: React.FC = () => {
  const [cmvCopies] = useState(1450); // IU/mL
  const isElevated = cmvCopies >= 1000;

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Activity className="h-7 w-7 text-indigo-400" />
          <div>
            <h2 className="text-xl font-bold">Post-Transplant CMV & EBV PCR Surveillance</h2>
            <p className="text-xs text-slate-400">Quantitative Nucleic Acid Amplification (QNAT) Viral Load</p>
          </div>
        </div>
      </div>

      <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 my-6">
        <div className="flex justify-between items-center text-xs font-mono">
          <span>CMV DNA Viral Load: <strong className="text-white">{cmvCopies} IU/mL</strong></span>
          <span className={isElevated ? 'text-rose-400 font-bold' : 'text-emerald-400 font-bold'}>
            {isElevated ? 'ACTIVE VIREMIA: Initiate Valganciclovir' : 'CMV UNDETECTABLE / LOW'}
          </span>
        </div>
      </div>
    </div>
  );
};
