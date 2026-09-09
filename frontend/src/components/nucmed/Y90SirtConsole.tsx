import React, { useState } from 'react';
import { Gauge, CheckCircle2, AlertOctagon } from 'lucide-react';

export const Y90SirtConsole: React.FC = () => {
  const [lsf, setLsf] = useState(7.2); // %

  const isSafe = lsf <= 20.0;
  const reduction = lsf > 15 ? '40% Dose Reduction' : lsf >= 10 ? '20% Dose Reduction' : 'Full 100% Dose';

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Gauge className="h-7 w-7 text-indigo-400" />
          <div>
            <h2 className="text-xl font-bold">Y-90 Microspheres SIRT Lung Shunt Fraction (LSF)</h2>
            <p className="text-xs text-slate-400">Tc-99m MAA Planar/SPECT Shunt & Radiation Pneumonitis Limit (&lt; 20%)</p>
          </div>
        </div>
        <span className={'px-3 py-1 rounded-full text-xs font-mono font-bold ' + (
          isSafe ? 'bg-emerald-950 text-emerald-300 border border-emerald-700' : 'bg-rose-950 text-rose-300 border border-rose-700'
        )}>
          {isSafe ? 'SIRT APPROVED' : 'CONTRAINDICATED (> 20% LUNG SHUNT)'}
        </span>
      </div>

      <div className="grid grid-cols-2 gap-4 my-6">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800">
          <span className="text-xs text-slate-400 block mb-1">Measured Lung Shunt Fraction: {lsf}%</span>
          <input type="range" min="1.0" max="30.0" step="0.1" value={lsf} onChange={e => setLsf(Number(e.target.value))} className="w-full" />
        </div>

        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 flex flex-col justify-center text-xs font-mono">
          <div>Dose Adjustment Factor: <strong className="text-emerald-400">{reduction}</strong></div>
          <div className="text-slate-400 font-sans mt-2">Lung absorbed dose limit: strictly &lt; 30 Gy.</div>
        </div>
      </div>
    </div>
  );
};
