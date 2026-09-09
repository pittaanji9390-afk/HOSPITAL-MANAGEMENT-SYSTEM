import React, { useState } from 'react';

export const EgfrTargetedLungOncologyConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">EGFR Molecular Oncology Precision Matching</h1>
          <p className="text-sm text-slate-400">Exon 19 Deletion &amp; L858R Osimertinib (Tagrisso) First-Line Pathway</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <h2 className="text-base font-bold text-white mb-2">Mutation: EGFR Exon 19 In-Frame Deletion (E746_A750del)</h2>
        <p className="text-xs text-emerald-400">Matched Therapy: Osimertinib 80 mg Daily (NCCN Category 1)</p>
      </div>
    </div>
  );
};
