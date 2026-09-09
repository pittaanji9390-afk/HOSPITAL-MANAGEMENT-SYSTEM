import React, { useState } from 'react';

export const CentralTelemetryNursingStationConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">16-Bed Central Telemetry Monitoring Station</h1>
          <p className="text-sm text-slate-400">ICU Multi-Patient Real-Time Alarm Surveillance &amp; Waveform Matrix</p>
        </div>
      </header>

      <div className="grid grid-cols-2 md:grid-cols-4 gap-4">
        {[1, 2, 3, 4, 5, 6, 7, 8].map(i => (
          <div key={i} className="p-3 bg-slate-800/80 rounded-xl border border-slate-700 font-mono text-xs">
            <div className="flex justify-between items-center mb-1">
              <span className="text-sky-400 font-bold">Bed {i}</span>
              <span className="text-emerald-400 font-bold">HR 74</span>
            </div>
            <div className="h-8 bg-slate-950 rounded border border-slate-800 flex items-center justify-center text-emerald-500 text-xs">
              /__/_
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};
