import React, { useState } from 'react';
import { Microscope, CheckCircle2, ShieldCheck } from 'lucide-react';

export const MolecularTumorBoardStudio: React.FC = () => {
  const [selectedGene, setSelectedGene] = useState('EGFR');

  const variants: Record<string, { var: string; drug: string; level: string }> = {
    'EGFR': { var: 'Exon 19 del (E746_A750del) / L858R', drug: 'Osimertinib 80mg daily (Tagrisso)', level: 'Level 1 (FDA Approved First-Line)' },
    'BRAF': { var: 'V600E (c.1799T>A)', drug: 'Dabrafenib 150mg BID + Trametinib 2mg daily', level: 'Level 1 (FDA Tissue-Agnostic)' },
    'KRAS': { var: 'G12C (c.34G>T)', drug: 'Sotorasib 960mg daily (Lumakras)', level: 'Level 1 (FDA Approved NSCLC)' }
  };

  const current = variants[selectedGene] || variants['EGFR'];

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Microscope className="h-7 w-7 text-indigo-400" />
          <div>
            <h2 className="text-xl font-bold">Molecular Tumor Board (MTB) NGS Actionable Annotator</h2>
            <p className="text-xs text-slate-400">OncoKB / FDA Level 1-4 Actionable Biomarker & Targeted Therapy Matcher</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-2 gap-4 my-6">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800">
          <label className="text-xs text-slate-400 block mb-1">Select Mutated Biomarker</label>
          <select value={selectedGene} onChange={e => setSelectedGene(e.target.value)} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-slate-200">
            <option>EGFR</option>
            <option>BRAF</option>
            <option>KRAS</option>
          </select>
          <div className="mt-3 font-mono text-xs text-slate-300">
            Variant: <strong>{current.var}</strong>
          </div>
        </div>

        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 text-xs font-mono space-y-2">
          <div>Evidence Tier: <strong className="text-emerald-400">{current.level}</strong></div>
          <div className="text-slate-300">
            <strong>Targeted Therapeutic Recommendation:</strong>
            <p className="text-white font-bold mt-1">{current.drug}</p>
          </div>
        </div>
      </div>
    </div>
  );
};
