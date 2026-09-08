import React, { useState } from 'react';
import { Gauge, CheckCircle2, ShieldCheck } from 'lucide-react';

export const BowieDickConsole: React.FC = () => {
  const [leakRate] = useState(0.35); // mmHg/min (Limit: < 1.0)
  const isPass = leakRate < 1.0;

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Gauge className="h-7 w-7 text-cyan-400" />
          <div>
            <h2 className="text-xl font-bold">Daily Bowie-Dick Dynamic Air Removal Analyzer</h2>
            <p className="text-xs text-slate-400">Vacuum Leak Rate & Thermocouple Air Entrapment Quality Test</p>
          </div>
        </div>
        <span className="px-3 py-1 bg-emerald-950 text-emerald-300 border border-emerald-700/60 rounded-full text-xs font-mono">
          AIR REMOVAL PASS
        </span>
      </div>

      <div className="grid grid-cols-2 gap-4 my-6">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800">
          <span className="text-xs text-slate-400 block mb-1">Measured Chamber Leak Rate</span>
          <span className="text-3xl font-extrabold font-mono text-cyan-300">{leakRate} mmHg/min</span>
          <p className="text-xs text-slate-400 mt-1">Acceptable Limit: &lt; 1.0 mmHg/min</p>
        </div>
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 flex flex-col justify-between">
          <span className="text-xs text-slate-400">Chemical Indicator Sheet Color</span>
          <span className="text-emerald-400 font-bold flex items-center gap-1.5"><CheckCircle2 className="h-4 w-4" /> Uniform Dark Blue/Black Across Entire Sheet</span>
          <span className="text-xs text-slate-500 font-mono">No central yellow gas bubble entrapment detected.</span>
        </div>
      </div>
    </div>
  );
};
