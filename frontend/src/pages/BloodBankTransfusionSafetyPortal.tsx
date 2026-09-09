import React, { useState } from 'react';

export const BloodBankTransfusionSafetyPortal: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">Blood Bank Crossmatch &amp; Transfusion Safety Portal</h1>
          <p className="text-sm text-slate-400">ISBT 128 Unit Barcoding, ABO/Rh Compatibility Verification &amp; Hemovigilance</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <span className="text-xs font-mono text-rose-400 font-bold block mb-1">ISBT-128: DIN-W0398-PRBC-01</span>
        <h2 className="text-base font-bold text-white mb-2">Packed Red Blood Cells (PRBC) - Group O-Negative</h2>
        <span className="px-2 py-0.5 bg-emerald-900/60 text-emerald-300 text-xs font-mono font-bold rounded">CROSSMATCH COMPATIBLE</span>
      </div>
    </div>
  );
};
