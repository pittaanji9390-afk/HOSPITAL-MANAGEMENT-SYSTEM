import React, { useState } from 'react';

export const CapnographyEtCo2CanvasConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-amber-400">Continuous Capnography &amp; EtCO2 Alveolar Monitor</h1>
          <p className="text-sm text-slate-400">Phase I-IV Expiratory Capnogram &amp; Bronchospasm Shark-Fin Detection</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <h2 className="text-base font-bold text-white mb-2">EtCO2: 38 mmHg (RR: 14 bpm)</h2>
        <div className="h-32 bg-slate-950 rounded border border-slate-800 flex items-center justify-center font-mono text-amber-400 text-xs">
          |___/‾‾‾___/‾‾‾___ (NORMAL SQUARE-WAVE CAPNOGRAM)
        </div>
      </div>
    </div>
  );
};
