import React, { useState } from 'react';

export const AkiKdigoSurveillanceConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">Acute Kidney Injury (AKI) KDIGO Staging</h1>
          <p className="text-sm text-slate-400">Serum Creatinine Velocity &amp; Oliguria Trajectory Surveillance</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <h2 className="text-base font-bold text-white mb-2">KDIGO Stage 2 Acute Kidney Injury</h2>
        <p className="text-xs text-slate-300">Creatinine 2.4 mg/dL (2.1x Baseline of 1.1 mg/dL). Hold nephrotoxic agents.</p>
      </div>
    </div>
  );
};
