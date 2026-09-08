import React, { useState } from 'react';

export const CrrtEffluentDosingConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">CRRT Effluent Dosing &amp; Citrate Protocol</h1>
          <p className="text-sm text-slate-400">CVVHDF 20-25 mL/kg/h Delivered Dose &amp; Filtration Fraction Surveillance</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <h2 className="text-base font-bold text-white mb-2">Delivered Effluent Dose: 23.5 mL/kg/h</h2>
        <p className="text-xs text-emerald-400">Filtration Fraction: 14.2% (Within safe &lt;20% filter preservation target)</p>
      </div>
    </div>
  );
};
