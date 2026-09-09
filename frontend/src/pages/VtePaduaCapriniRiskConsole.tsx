import React, { useState } from 'react';

export const VtePaduaCapriniRiskConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">VTE Prophylaxis: Padua &amp; Caprini Score</h1>
          <p className="text-sm text-slate-400">Inpatient Deep Vein Thrombosis &amp; Pulmonary Embolism Prevention</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <h2 className="text-base font-bold text-white mb-2">Padua Score: 5 (High VTE Risk)</h2>
        <p className="text-xs text-emerald-300">Ordered: Enoxaparin 40 mg SubQ Daily + Bilateral SCD Boots</p>
      </div>
    </div>
  );
};
