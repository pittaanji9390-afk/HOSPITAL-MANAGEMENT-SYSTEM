import React, { useState } from 'react';
import { SAMPLE_CYP2D6_GUIDANCE } from '../types/cyp2d6Pgx';

export const Cyp2d6CodeineTamoxifenPgxConsole: React.FC = () => {
  const [data, setData] = useState(SAMPLE_CYP2D6_GUIDANCE);

  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">CYP2D6 Pharmacogenomics Clinical Decision Support</h1>
          <p className="text-sm text-slate-400">CPIC Guidelines for Codeine, Tramadol &amp; Tamoxifen Metabolizer Phenotypes</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-rose-800/80">
        <h2 className="text-base font-bold text-white mb-2">Phenotype: {data.metabolizerPhenotype} (Diplotype: {data.diplotype})</h2>
        <p className="text-xs text-rose-300 mb-2">{data.codeineRecommendation}</p>
        <p className="text-xs text-sky-300">{data.tamoxifenRecommendation}</p>
      </div>
    </div>
  );
};
