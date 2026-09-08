import React, { useState } from 'react';
import { Activity, CheckCircle2 } from 'lucide-react';

export const FabryGlaConsole: React.FC = () => {
  const [mutation, setMutation] = useState('p.R301Q (Amenable)');

  const isAmenable = mutation.includes('Amenable');

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Activity className="h-7 w-7 text-indigo-400" />
          <div>
            <h2 className="text-xl font-bold">Fabry Disease GLA Precision Therapy</h2>
            <p className="text-xs text-slate-400">Alpha-Gal A Enzyme & Oral Chaperone (Migalastat) Amenability</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-2 gap-4 my-6 text-xs font-mono">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 space-y-3">
          <select value={mutation} onChange={e => setMutation(e.target.value)} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-slate-200">
            <option>p.R301Q (Amenable)</option>
            <option>p.N215S (Amenable Cardiac Variant)</option>
            <option>Exon Deletion (Non-Amenable)</option>
          </select>
        </div>

        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 flex flex-col justify-center">
          <div>Recommended Therapy: <strong className="text-emerald-400">
            {isAmenable ? 'Oral Chaperone: Migalastat 123mg QOD' : 'Enzyme Replacement: Agalsidase Beta IV Q2W'}
          </strong></div>
        </div>
      </div>
    </div>
  );
};
