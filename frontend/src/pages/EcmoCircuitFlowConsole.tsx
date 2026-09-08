import React, { useState } from 'react';

export const EcmoCircuitFlowConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">ECMO Extracorporeal Circuit Flow Console</h1>
          <p className="text-sm text-slate-400">Venoarterial &amp; Venovenous Cannula Pressures, RPM &amp; Sweep Gas Titration</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <h2 className="text-base font-bold text-white mb-2">Configuration: VA-ECMO (Blood Flow: 4.2 L/min)</h2>
        <p className="text-xs text-slate-300">Sweep Gas: 3.5 L/min (FiO2 100%) | Post-Membrane PaO2: 420 mmHg</p>
      </div>
    </div>
  );
};
