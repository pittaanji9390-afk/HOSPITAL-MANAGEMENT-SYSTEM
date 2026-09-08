import React, { useState } from 'react';

export const InpatientOrderEntryCpoePortal: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">Computerized Physician Order Entry (CPOE) Portal</h1>
          <p className="text-sm text-slate-400">Direct Physician Order Entry with Clinical Decision Support CDSS Validation</p>
        </div>
      </header>

      <div className="bg-slate-800/80 rounded-xl border border-slate-700 p-5">
        <h2 className="text-base font-bold text-white mb-3">Recent Medication &amp; Diagnostic Orders</h2>
        <div className="p-3 bg-slate-900/80 rounded border border-slate-700/60 text-xs font-mono">
          <div className="flex justify-between items-center mb-1">
            <span className="text-sky-400 font-bold">ORD-1001 (Priority: STAT)</span>
            <span className="px-2 py-0.5 bg-emerald-900/60 text-emerald-300 rounded font-sans font-bold">EXECUTED</span>
          </div>
          <p className="text-slate-200">Norepinephrine 4mg in 250mL D5W - Titrate for MAP &gt;= 65</p>
        </div>
      </div>
    </div>
  );
};
