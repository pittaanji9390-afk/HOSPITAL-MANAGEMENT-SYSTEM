import React, { useState } from 'react';
import { Dna, CheckCircle2 } from 'lucide-react';

export const HuntingtonCagConsole: React.FC = () => {
  const [cagRepeats, setCagRepeats] = useState(42);

  let penetrance = 'Normal (< 27)';
  if (cagRepeats >= 60) penetrance = 'Juvenile Onset (≥ 60 repeats)';
  else if (cagRepeats >= 40) penetrance = 'Full Penetrance (≥ 40 repeats)';
  else if (cagRepeats >= 36) penetrance = 'Reduced Penetrance (36-39 repeats)';
  else if (cagRepeats >= 27) penetrance = 'Intermediate Premutation (27-35 repeats)';

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Dna className="h-7 w-7 text-amber-400" />
          <div>
            <h2 className="text-xl font-bold">Huntington Disease CAG Trinucleotide Expansion</h2>
            <p className="text-xs text-slate-400">HTT Gene Exon 1 Repeat Range & Genetic Counseling Guidance</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-2 gap-4 my-6">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800">
          <span className="text-xs text-slate-400 block mb-1">CAG Repeat Count: {cagRepeats}</span>
          <input type="range" min="15" max="75" value={cagRepeats} onChange={e => setCagRepeats(Number(e.target.value))} className="w-full" />
        </div>

        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 flex flex-col justify-center text-xs font-mono">
          <div>Penetrance Status: <strong className={cagRepeats >= 40 ? 'text-rose-400 font-bold' : 'text-emerald-400'}>{penetrance}</strong></div>
          <div className="text-slate-400 font-sans mt-2">Pre-test and post-test genetic counseling strictly mandated.</div>
        </div>
      </div>
    </div>
  );
};
