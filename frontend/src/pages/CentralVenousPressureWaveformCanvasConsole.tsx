import React, { useState } from 'react';

export const CentralVenousPressureWaveformCanvasConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">Central Venous Pressure (CVP) Morphology</h1>
          <p className="text-sm text-slate-400">Right Atrial a, c, v Waves and x, y Descents Analysis</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <h2 className="text-base font-bold text-white mb-2">Mean CVP: 8 mmHg</h2>
        <p className="text-xs text-slate-300 font-mono">Normal sinus a-wave preceding QRS, normal ventricular filling.</p>
      </div>
    </div>
  );
};
