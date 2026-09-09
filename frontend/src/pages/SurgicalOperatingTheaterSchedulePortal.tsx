import React, { useState } from 'react';

export const SurgicalOperatingTheaterSchedulePortal: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">Surgical Operating Theater Live Dashboard</h1>
          <p className="text-sm text-slate-400">WHO Surgical Time-Out, Intraoperative Progression &amp; PACU Transitions</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <span className="text-xs font-mono text-sky-400 font-bold block mb-1">OR-3 (Cardiac Suite)</span>
        <h2 className="text-base font-bold text-white mb-2">Emergency Coronary Artery Bypass Graft (CABG x3)</h2>
        <p className="text-xs text-slate-300 font-sans mb-3">Primary Surgeon: Dr. Preston Burke | Duration: 240 mins</p>
        <span className="px-2 py-0.5 bg-sky-900/60 text-sky-300 text-xs font-mono font-bold rounded">SURGERY IN PROGRESS</span>
      </div>
    </div>
  );
};
