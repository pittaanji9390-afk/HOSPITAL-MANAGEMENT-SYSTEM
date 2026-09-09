import React, { useState } from 'react';

export const BispectralIndexAnesthesiaConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">Bispectral Index (BIS) Sedation Depth</h1>
          <p className="text-sm text-slate-400">Target Surgical Anesthesia (40-60) &amp; Burst Suppression Ratio</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <h2 className="text-base font-bold text-white mb-2">BIS Index: 48 (Target 40-60)</h2>
        <span className="px-2 py-0.5 bg-emerald-900/60 text-emerald-300 rounded text-xs font-bold font-mono">GENERAL ANESTHESIA TARGET ACHIEVED</span>
      </div>
    </div>
  );
};
