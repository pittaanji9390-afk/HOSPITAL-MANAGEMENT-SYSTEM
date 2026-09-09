import React, { useState } from 'react';

export const GraceAcsRiskCalculatorConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">GRACE 2.0 Acute Coronary Syndrome Risk</h1>
          <p className="text-sm text-slate-400">In-Hospital and 6-Month Mortality Predictor for STEMI / NSTEMI</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <h2 className="text-base font-bold text-white mb-2">GRACE Score: 154 (High Risk)</h2>
        <p className="text-xs text-rose-300">In-Hospital Mortality: 12.5% | Recommendation: Urgent PCI within 24h</p>
      </div>
    </div>
  );
};
