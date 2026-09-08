import React, { useState } from 'react';

export const FhirObservationViewerConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">FHIR R4 Observation &amp; Vital Signs Explorer</h1>
          <p className="text-sm text-slate-400">LOINC Harmonized Observational Measurements and Reference Intervals</p>
        </div>
      </header>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
        <div className="p-4 bg-slate-800/80 rounded-xl border border-slate-700">
          <span className="text-xs font-mono text-sky-400 font-bold">LOINC: 8867-4</span>
          <h3 className="text-base font-bold text-white mb-2">Heart Rate (Pulse)</h3>
          <div className="text-2xl font-mono font-bold text-emerald-400">76 <span className="text-xs text-slate-400 font-sans">beats/min</span></div>
        </div>
        <div className="p-4 bg-slate-800/80 rounded-xl border border-slate-700">
          <span className="text-xs font-mono text-sky-400 font-bold">LOINC: 2708-6</span>
          <h3 className="text-base font-bold text-white mb-2">Oxygen Saturation SpO2</h3>
          <div className="text-2xl font-mono font-bold text-sky-400">98 <span className="text-xs text-slate-400 font-sans">%</span></div>
        </div>
      </div>
    </div>
  );
};
