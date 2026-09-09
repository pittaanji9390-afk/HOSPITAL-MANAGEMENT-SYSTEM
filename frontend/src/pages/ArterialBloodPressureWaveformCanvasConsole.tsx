import React, { useState } from 'react';

export const ArterialBloodPressureWaveformCanvasConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-rose-400">Invasive Arterial Blood Pressure (ABP) Stream</h1>
          <p className="text-sm text-slate-400">Arterial Pulse Contour Analysis, Dicrotic Notch &amp; Continuous MAP</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <h2 className="text-base font-bold text-white mb-2">ABP: 124 / 76 mmHg (MAP: 92 mmHg)</h2>
        <div className="h-32 bg-slate-950 rounded border border-slate-800 flex items-center justify-center font-mono text-rose-400 text-xs">
          /|__/__/|__/__ (ARTERIAL LINE PULSE CONTOUR)
        </div>
      </div>
    </div>
  );
};
