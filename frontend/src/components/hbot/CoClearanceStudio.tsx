import React, { useState } from 'react';
import { Flame, Clock, ShieldAlert, CheckCircle2 } from 'lucide-react';

export const CoClearanceStudio: React.FC = () => {
  const [cohb, setCohb] = useState(28);
  const [syncope, setSyncope] = useState(true);

  const isHbotIndicated = cohb >= 25 || syncope;

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Flame className="h-7 w-7 text-amber-400" />
          <div>
            <h2 className="text-xl font-bold">Carbon Monoxide Carboxyhemoglobin Elimination Engine</h2>
            <p className="text-xs text-slate-400">Half-life Clearance: 320 min (Room Air) vs 80 min (NRB) vs 22 min (HBOT 3.0 ATA)</p>
          </div>
        </div>
        <span className={'px-3 py-1 rounded-full text-xs font-mono font-bold ' + (
          isHbotIndicated ? 'bg-rose-950 text-rose-300 border border-rose-700' : 'bg-emerald-950 text-emerald-300 border border-emerald-700'
        )}>
          {isHbotIndicated ? 'EMERGENCY HBOT INDICATION' : 'NORMOBARIC O2 ADEQUATE'}
        </span>
      </div>

      <div className="grid grid-cols-2 gap-4 my-6">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 space-y-3">
          <div>
            <span className="text-xs text-slate-400 block mb-1">Measured COHb: {cohb}%</span>
            <input type="range" min="1" max="60" value={cohb} onChange={e => setCohb(Number(e.target.value))} className="w-full" />
          </div>
          <div>
            <label className="flex items-center gap-2 text-xs text-slate-300 cursor-pointer">
              <input type="checkbox" checked={syncope} onChange={e => setSyncope(e.target.checked)} className="rounded bg-slate-900 border-slate-700 text-rose-600" />
              Loss of Consciousness / Coma / Seizure
            </label>
          </div>
        </div>

        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 text-xs font-mono space-y-2">
          <div className="text-slate-400">T½ Room Air (21% O2): <strong className="text-slate-200">~320 minutes (5.3 hrs)</strong></div>
          <div className="text-slate-400">T½ Non-Rebreather (100% O2): <strong className="text-indigo-300">~80 minutes (1.3 hrs)</strong></div>
          <div className="text-slate-400">T½ Hyperbaric (100% O2 @ 3.0 ATA): <strong className="text-emerald-400 font-bold">~22 minutes</strong></div>
        </div>
      </div>
    </div>
  );
};
