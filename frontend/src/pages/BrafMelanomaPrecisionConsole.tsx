import React, { useState } from 'react';

export const BrafMelanomaPrecisionConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">BRAF V600 Precision Melanoma Therapy</h1>
          <p className="text-sm text-slate-400">Dabrafenib + Trametinib Dual BRAF/MEK Targeted Regimen Matching</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <h2 className="text-base font-bold text-white mb-2">Mutation: BRAF V600E Detected</h2>
        <p className="text-xs text-emerald-400">Dual Inhibition: Dabrafenib 150mg BID + Trametinib 2mg Daily</p>
      </div>
    </div>
  );
};
