import React, { useState } from 'react';

export const Dpyd5FuToxicitySafetyConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">DPYD 5-FU Chemotherapy Safety Monitor</h1>
          <p className="text-sm text-slate-400">Dihydropyrimidine Dehydrogenase Deficiency &amp; Capecitabine Safety</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <h2 className="text-base font-bold text-white mb-2">DPYD Variant: Wild-Type (Score 2.0)</h2>
        <span className="px-2 py-0.5 bg-emerald-900/60 text-emerald-300 rounded text-xs font-bold font-mono">STANDARD FOLFOX / CAPOX ELIGIBLE</span>
      </div>
    </div>
  );
};
