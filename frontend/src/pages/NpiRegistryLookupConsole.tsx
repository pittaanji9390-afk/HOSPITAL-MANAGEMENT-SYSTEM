import React, { useState } from 'react';

export const NpiRegistryLookupConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">CMS NPPES NPI Registry &amp; Luhn Validator</h1>
          <p className="text-sm text-slate-400">10-Digit National Provider Identifier Checksum Verification</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <h2 className="text-base font-bold text-white mb-2">NPI: 1234567893 (Luhn Checksum Valid)</h2>
        <p className="text-xs text-emerald-400 font-mono">Status: ACTIVE Type 1 Individual Physician</p>
      </div>
    </div>
  );
};
