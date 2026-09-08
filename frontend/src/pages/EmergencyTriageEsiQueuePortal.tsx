import React, { useState } from 'react';

export const EmergencyTriageEsiQueuePortal: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">Emergency Department ESI Triage Queue</h1>
          <p className="text-sm text-slate-400">Real-Time Emergency Severity Index (ESI 1-5) Patient Prioritization</p>
        </div>
      </header>

      <div className="space-y-3">
        <div className="p-4 bg-slate-800/80 rounded-xl border border-rose-800/80 flex justify-between items-center">
          <div>
            <span className="text-xs font-mono text-rose-400 font-bold block">ESI LEVEL 1: IMMEDIATE RESUSCITATION</span>
            <h2 className="text-base font-bold text-white">John Doe (Trauma) - Trauma Bay 1</h2>
            <p className="text-xs text-slate-300">Severe Hemorrhagic Shock / GCS 6</p>
          </div>
          <span className="px-3 py-1 bg-rose-900/80 text-rose-300 text-xs font-mono font-bold rounded animate-pulse">STAT 10m Wait</span>
        </div>
      </div>
    </div>
  );
};
