import React, { useState } from 'react';

export const SwanGanzPacConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">Swan-Ganz Pulmonary Artery Catheter Console</h1>
          <p className="text-sm text-slate-400">PAOP Wedge Pressure, Systemic Vascular Resistance (SVR) &amp; Shock Profiling</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <h2 className="text-base font-bold text-white mb-2">Hemodynamic Shock Pattern: CARDIOGENIC SHOCK</h2>
        <p className="text-xs text-slate-300">SVR: 1,650 dynes·s/cm⁵ | PAOP Wedge: 22 mmHg | Cardiac Output: 3.1 L/min</p>
      </div>
    </div>
  );
};
