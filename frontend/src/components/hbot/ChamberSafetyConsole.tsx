import React, { useState } from 'react';
import { ShieldCheck, ShieldAlert, CheckCircle2 } from 'lucide-react';

export const ChamberSafetyConsole: React.FC = () => {
  const [ambientO2, setAmbientO2] = useState(21.4); // Must be <= 23.5%
  const [rh, setRh] = useState(58); // Must be >= 50%

  const isFireSafe = ambientO2 <= 23.5 && rh >= 50;

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <ShieldCheck className="h-7 w-7 text-emerald-400" />
          <div>
            <h2 className="text-xl font-bold">NFPA 99 Chapter 14 Chamber Environmental Safety</h2>
            <p className="text-xs text-slate-400">Ambient O2 Fire Limit (&lt;= 23.5%) & Static Spark Prevention (RH &gt;= 50%)</p>
          </div>
        </div>
        <span className={'px-3 py-1 rounded-full text-xs font-mono font-bold ' + (
          isFireSafe ? 'bg-emerald-950 text-emerald-300 border border-emerald-700' : 'bg-rose-950 text-rose-300 border border-rose-700'
        )}>
          {isFireSafe ? 'FIRE SAFETY INTERLOCK SAFE' : 'HAZARD: OVERBOARD DUMP'}
        </span>
      </div>

      <div className="grid grid-cols-2 gap-4 my-6 text-xs font-mono">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800">
          <span className="text-slate-400 block mb-1">Ambient Chamber O2: {ambientO2}%</span>
          <input type="range" min="20.0" max="28.0" step="0.1" value={ambientO2} onChange={e => setAmbientO2(Number(e.target.value))} className="w-full" />
          <p className="text-slate-500 mt-2">NFPA 99 Limit: &lt;= 23.5% O2</p>
        </div>

        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800">
          <span className="text-slate-400 block mb-1">Relative Humidity: {rh}%</span>
          <input type="range" min="20" max="90" value={rh} onChange={e => setRh(Number(e.target.value))} className="w-full" />
          <p className="text-slate-500 mt-2">Antistatic Spark Floor: &gt;= 50% RH</p>
        </div>
      </div>
    </div>
  );
};
