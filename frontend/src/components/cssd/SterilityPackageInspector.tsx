import React, { useState } from 'react';
import { ShieldCheck, AlertOctagon, CheckCircle2, Lock } from 'lucide-react';

export const SterilityPackageInspector: React.FC = () => {
  const [tamperIntact, setTamperIntact] = useState(true);
  const [moistureFree, setMoistureFree] = useState(true);
  const [filterCycles, setFilterCycles] = useState(14);
  const maxCycles = 50;

  const isSafe = tamperIntact && moistureFree && filterCycles < maxCycles;

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <ShieldCheck className="h-7 w-7 text-emerald-400" />
          <div>
            <h2 className="text-xl font-bold">Event-Related Sterility (ERS) Integrity Gate</h2>
            <p className="text-xs text-slate-400">Rigid Container Gaskets, PTFE Filters & Tamper Locks</p>
          </div>
        </div>
        <span className={'px-3 py-1 rounded-full text-xs font-mono font-bold ' + (
          isSafe ? 'bg-emerald-950 text-emerald-300 border border-emerald-700' : 'bg-rose-950 text-rose-300 border border-rose-700'
        )}>
          {isSafe ? 'STERILITY VALID' : 'REPROCESS REQUIRED'}
        </span>
      </div>

      <div className="grid grid-cols-3 gap-4 my-6">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800">
          <label className="flex items-center gap-2 text-xs text-slate-300 cursor-pointer">
            <input type="checkbox" checked={tamperIntact} onChange={e => setTamperIntact(e.target.checked)} className="rounded bg-slate-900 border-slate-700 text-indigo-600" />
            Tamper Locks Intact
          </label>
        </div>
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800">
          <label className="flex items-center gap-2 text-xs text-slate-300 cursor-pointer">
            <input type="checkbox" checked={moistureFree} onChange={e => setMoistureFree(e.target.checked)} className="rounded bg-slate-900 border-slate-700 text-indigo-600" />
            Moisture Free (No Wet Packs)
          </label>
        </div>
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800">
          <span className="text-xs text-slate-400 block mb-1">Filter Usage: {filterCycles} / {maxCycles} cycles</span>
          <input type="range" min="1" max="60" value={filterCycles} onChange={e => setFilterCycles(Number(e.target.value))} className="w-full" />
        </div>
      </div>
    </div>
  );
};
