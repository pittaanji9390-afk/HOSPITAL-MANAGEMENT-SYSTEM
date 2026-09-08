import React, { useState } from 'react';
import { AlertOctagon, CheckCircle2, ShieldAlert } from 'lucide-react';

export const NstiEmergencyConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <AlertOctagon className="h-7 w-7 text-rose-500 animate-pulse" />
          <div>
            <h2 className="text-xl font-bold">Necrotizing Soft Tissue Infection (NSTI) HBOT Protocol</h2>
            <p className="text-xs text-slate-400">Clostridial Myonecrosis & Fournier Gangrene 3.0 ATA Emergency Dispatch</p>
          </div>
        </div>
        <span className="px-3 py-1 bg-rose-950 text-rose-300 border border-rose-700/60 rounded-full text-xs font-mono">
          UHMS CATEGORY 1 EMERGENCY
        </span>
      </div>

      <div className="grid grid-cols-2 gap-4 my-6 text-xs font-mono">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 space-y-2">
          <div>Target Pressure: <strong className="text-cyan-300">3.0 ATA (Alpha-Toxin Arrest)</strong></div>
          <div>Session Duration: <strong className="text-white">90 Minutes (100% O2)</strong></div>
          <div>Frequency: <strong className="text-amber-400">Q8H for first 24 hrs, then Q12H</strong></div>
        </div>
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 flex items-center gap-2 text-slate-300">
          <ShieldAlert className="h-6 w-6 text-amber-400 shrink-0" />
          <span>Surgical debridement must precede or immediately follow hyperbaric compression. Never delay OR for HBOT.</span>
        </div>
      </div>
    </div>
  );
};
