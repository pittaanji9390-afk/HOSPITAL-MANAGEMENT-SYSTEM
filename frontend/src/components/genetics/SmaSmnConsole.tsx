import React, { useState } from 'react';
import { Dna, CheckCircle2 } from 'lucide-react';

export const SmaSmnConsole: React.FC = () => {
  const [smn2Copies, setSmn2Copies] = useState(2);

  const types: Record<number, string> = {
    1: 'SMA Type 0/1A (Very Severe)',
    2: 'SMA Type 1 (Werdnig-Hoffmann - Severe)',
    3: 'SMA Type 2 (Intermediate)',
    4: 'SMA Type 3 (Mild)'
  };

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Dna className="h-7 w-7 text-indigo-400" />
          <div>
            <h2 className="text-xl font-bold">Spinal Muscular Atrophy SMN Genotype Engine</h2>
            <p className="text-xs text-slate-400">SMN1 Homozygous Deletion & SMN2 Disease Modifier Copies</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-2 gap-4 my-6 text-xs">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800">
          <span className="text-slate-400 block mb-1">SMN2 Backup Copy Number: {smn2Copies}</span>
          <input type="range" min="1" max="4" value={smn2Copies} onChange={e => setSmn2Copies(Number(e.target.value))} className="w-full" />
        </div>

        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 flex flex-col justify-center font-mono">
          <div>Phenotype: <strong className="text-rose-400 font-bold">{types[smn2Copies]}</strong></div>
          <div className="text-slate-400 font-sans mt-2">Therapy: Onasemnogene abeparvovec (Zolgensma) gene therapy / Risdiplam.</div>
        </div>
      </div>
    </div>
  );
};
