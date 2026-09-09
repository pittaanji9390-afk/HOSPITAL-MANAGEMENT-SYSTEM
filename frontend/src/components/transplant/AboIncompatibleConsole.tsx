import React, { useState } from 'react';
import { Droplet, CheckCircle2, AlertOctagon } from 'lucide-react';

export const AboIncompatibleConsole: React.FC = () => {
  const [titerDenominator, setTiterDenominator] = useState(4); // 1:4
  const isSafe = titerDenominator <= 8;

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Droplet className="h-7 w-7 text-rose-400" />
          <div>
            <h2 className="text-xl font-bold">ABO-Incompatible (ABOi) Isoagglutinin Titer Monitor</h2>
            <p className="text-xs text-slate-400">Anti-A / Anti-B Antibody Titer & Plasmapheresis Clearance Gate</p>
          </div>
        </div>
      </div>

      <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 my-6">
        <span className="text-xs text-slate-400 block mb-1">Anti-A IgG Titer: 1 : {titerDenominator}</span>
        <input type="range" min="1" max="128" step="1" value={titerDenominator} onChange={e => setTiterDenominator(Number(e.target.value))} className="w-full" />
        <div className="mt-3 flex items-center gap-2 text-xs font-mono">
          <span className={isSafe ? 'text-emerald-400 font-bold' : 'text-rose-400 font-bold'}>
            {isSafe ? 'SAFE FOR SURGERY (Titer <= 1:8)' : 'HIGH RISK: Plasmapheresis / DFPP session required'}
          </span>
        </div>
      </div>
    </div>
  );
};
