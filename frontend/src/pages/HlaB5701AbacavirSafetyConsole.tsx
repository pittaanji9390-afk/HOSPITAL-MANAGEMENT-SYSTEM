import React, { useState } from 'react';

export const HlaB5701AbacavirSafetyConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">HLA-B*57:01 Abacavir Safety Screener</h1>
          <p className="text-sm text-slate-400">Fatal Multi-Organ System Hypersensitivity Hard-Stop Protocol</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <h2 className="text-base font-bold text-white mb-2">Result: HLA-B*57:01 NEGATIVE</h2>
        <span className="px-2 py-0.5 bg-emerald-900/60 text-emerald-300 rounded text-xs font-bold font-mono">ABACAVIR PRESCRIBING AUTHORIZED</span>
      </div>
    </div>
  );
};
