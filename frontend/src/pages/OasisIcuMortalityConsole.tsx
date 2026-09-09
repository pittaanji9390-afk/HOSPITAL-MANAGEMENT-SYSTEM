import React, { useState } from 'react';

export const OasisIcuMortalityConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">OASIS ICU Severity of Illness Calculator</h1>
          <p className="text-sm text-slate-400">Oxford Acute Severity of Illness Score (OASIS) Logistic Regression Predictor</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <span className="text-xs font-mono text-sky-400 font-bold block mb-1">PT-ICU-8821</span>
        <h2 className="text-lg font-bold text-white mb-2">OASIS Score: 38 (Predicted In-Hospital Mortality: 28.4%)</h2>
        <span className="px-2 py-0.5 bg-amber-900/60 text-amber-300 rounded text-xs font-bold">HIGH RISK (20-40%)</span>
      </div>
    </div>
  );
};
