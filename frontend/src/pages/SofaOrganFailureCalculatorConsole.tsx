import React, { useState } from 'react';

export const SofaOrganFailureCalculatorConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">Sequential Organ Failure Assessment (SOFA)</h1>
          <p className="text-sm text-slate-400">6-Organ System Severity Matrix: Respiratory, Coag, Liver, CV, CNS, Renal</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <h2 className="text-base font-bold text-white mb-2">Total SOFA Score: 9 / 24</h2>
        <span className="px-2 py-0.5 bg-rose-900/60 text-rose-300 rounded text-xs font-bold font-mono">SEVERE DYSFUNCTION</span>
      </div>
    </div>
  );
};
