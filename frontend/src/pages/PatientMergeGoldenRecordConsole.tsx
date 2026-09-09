import React, { useState } from 'react';

export const PatientMergeGoldenRecordConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">EMPI Golden Record Merge &amp; Survivorship</h1>
          <p className="text-sm text-slate-400">HIM Specialist Verification, Field-by-Field Survivorship &amp; Record Merging</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <h2 className="text-base font-bold text-white mb-2">Target Golden Record: PT-9941 (Surviving)</h2>
        <p className="text-xs text-slate-300">Subsuming: PT-8812 | All past lab encounters and medications reassigned.</p>
      </div>
    </div>
  );
};
