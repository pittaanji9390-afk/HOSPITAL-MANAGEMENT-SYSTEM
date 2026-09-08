import React, { useState } from 'react';

export const IntensiveCareTelemetryStreamPortal: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">ICU Multi-Parameter Bedside Telemetry Hub</h1>
          <p className="text-sm text-slate-400">Arterial Line, CVP, SpO2, EtCO2 &amp; Intracranial Pressure Stream</p>
        </div>
      </header>

      <div className="grid grid-cols-2 md:grid-cols-4 gap-4">
        <div className="p-4 bg-slate-800/80 rounded-xl border border-slate-700 text-center font-mono">
          <span className="text-xs text-slate-400 block font-sans">Heart Rate</span>
          <span className="text-3xl font-bold text-emerald-400">78</span>
          <span className="text-xs text-slate-400 block font-sans">bpm</span>
        </div>
        <div className="p-4 bg-slate-800/80 rounded-xl border border-slate-700 text-center font-mono">
          <span className="text-xs text-slate-400 block font-sans">Arterial BP (MAP)</span>
          <span className="text-3xl font-bold text-sky-400">122/74 (90)</span>
          <span className="text-xs text-slate-400 block font-sans">mmHg</span>
        </div>
        <div className="p-4 bg-slate-800/80 rounded-xl border border-slate-700 text-center font-mono">
          <span className="text-xs text-slate-400 block font-sans">SpO2 Saturation</span>
          <span className="text-3xl font-bold text-cyan-400">98%</span>
          <span className="text-xs text-slate-400 block font-sans">on 2L NC</span>
        </div>
        <div className="p-4 bg-slate-800/80 rounded-xl border border-slate-700 text-center font-mono">
          <span className="text-xs text-slate-400 block font-sans">ICP Pressure</span>
          <span className="text-3xl font-bold text-amber-400">12</span>
          <span className="text-xs text-slate-400 block font-sans">mmHg</span>
        </div>
      </div>
    </div>
  );
};
