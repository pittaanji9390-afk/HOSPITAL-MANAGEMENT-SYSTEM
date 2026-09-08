import React, { useState } from 'react';

export const LaboratorySpecimenWorkflowPortal: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">Laboratory Specimen Tracking &amp; Panic Alerts</h1>
          <p className="text-sm text-slate-400">Vacuum Tube Color Coding, Centrifuge Status &amp; STAT Coagulation Results</p>
        </div>
      </header>

      <div className="space-y-3">
        <div className="p-4 bg-slate-800/80 rounded-xl border border-rose-800/70">
          <div className="flex justify-between items-center mb-1">
            <span className="text-xs font-mono text-rose-400 font-bold">SPEC-9922 (Citrate Light Blue)</span>
            <span className="px-2 py-0.5 bg-rose-900/60 text-rose-300 rounded text-xs font-bold font-mono animate-pulse">CRITICAL PANIC VALUE</span>
          </div>
          <p className="text-xs text-white">Coagulation Panel: INR 4.8 (Critical High) - Provider Notified</p>
        </div>
      </div>
    </div>
  );
};
