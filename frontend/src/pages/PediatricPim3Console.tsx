import React, { useState } from 'react';

export const PediatricPim3Console: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">Pediatric Index of Mortality (PIM3) Console</h1>
          <p className="text-sm text-slate-400">PICU Admission Risk Stratification &amp; Standardized Mortality Ratio</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <h2 className="text-base font-bold text-white mb-2">PIM3 Predicted Mortality: 4.8%</h2>
        <span className="px-2 py-0.5 bg-emerald-900/60 text-emerald-300 rounded text-xs font-bold">MODERATE/LOW RISK (&lt;10%)</span>
      </div>
    </div>
  );
};
