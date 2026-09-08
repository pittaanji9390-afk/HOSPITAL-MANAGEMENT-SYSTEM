import React, { useState } from 'react';

export const SsnFuzzyMatchAuditConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">SSN Transposition &amp; Last-4 Match Audit</h1>
          <p className="text-sm text-slate-400">Automated Identification of Inverted Digit Errors in Patient SSNs</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <h2 className="text-base font-bold text-white mb-2">***-**-9941 vs ***-**-9914 (1 Adjacent Transposition)</h2>
        <span className="px-2 py-0.5 bg-amber-900/60 text-amber-300 rounded text-xs font-bold font-mono">POTENTIAL CLERICAL ERROR</span>
      </div>
    </div>
  );
};
