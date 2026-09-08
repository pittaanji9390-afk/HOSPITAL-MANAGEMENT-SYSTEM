import React, { useState } from 'react';

export const Cyp2c19ClopidogrelResistanceConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">CYP2C19 Clopidogrel Resistance Monitor</h1>
          <p className="text-sm text-slate-400">Post-PCI Stent Thrombosis Prevention &amp; Alternative Antiplatelet Guidance</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <h2 className="text-base font-bold text-white mb-2">Diplotype: *1/*2 (Intermediate Metabolizer - Resistance Alert)</h2>
        <p className="text-xs text-emerald-400">Recommended Alternative: Ticagrelor 90mg BID (Avoid Plavix)</p>
      </div>
    </div>
  );
};
