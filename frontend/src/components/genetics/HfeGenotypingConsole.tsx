import React, { useState } from 'react';
import { Droplet, CheckCircle2 } from 'lucide-react';

export const HfeGenotypingConsole: React.FC = () => {
  const [genotype, setGenotype] = useState('C282Y / C282Y (Homozygote)');
  const [ferritin, setFerritin] = useState(650); // ng/mL

  const isPhlebotomyDue = ferritin > 300;

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Droplet className="h-7 w-7 text-rose-400" />
          <div>
            <h2 className="text-xl font-bold">Hereditary Hemochromatosis HFE Classifier</h2>
            <p className="text-xs text-slate-400">C282Y / H63D Genotype & Therapeutic Phlebotomy Protocol</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-2 gap-4 my-6 text-xs">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 space-y-3">
          <select value={genotype} onChange={e => setGenotype(e.target.value)} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-slate-200">
            <option>C282Y / C282Y (Homozygote)</option>
            <option>C282Y / H63D (Compound Heterozygote)</option>
            <option>H63D / H63D (Homozygote)</option>
          </select>
          <div>
            <span className="text-slate-400 block mb-1">Serum Ferritin: {ferritin} ng/mL</span>
            <input type="range" min="50" max="1500" value={ferritin} onChange={e => setFerritin(Number(e.target.value))} className="w-full" />
          </div>
        </div>

        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 flex flex-col justify-center font-mono">
          <div>Phlebotomy Action: <strong className={isPhlebotomyDue ? 'text-rose-400 font-bold' : 'text-emerald-400'}>
            {isPhlebotomyDue ? 'Therapeutic Phlebotomy Weekly Indicated' : 'Maintenance Monitoring'}
          </strong></div>
          <div className="text-slate-400 font-sans mt-2">Target Ferritin: 50 - 100 ng/mL.</div>
        </div>
      </div>
    </div>
  );
};
