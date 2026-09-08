import React, { useState } from 'react';

export const HipaaDeidentificationStudioConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">HIPAA Safe-Harbor De-identification Studio</h1>
          <p className="text-sm text-slate-400">Automated 18-Identifier Redaction for Clinical Research &amp; AI Training Datasets</p>
        </div>
      </header>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
        <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
          <h2 className="text-sm font-bold text-rose-400 mb-3 uppercase">Raw Protected Health Information (PHI)</h2>
          <pre className="p-3 bg-slate-950 rounded border border-slate-800 text-xs font-mono text-rose-200 overflow-x-auto">
{`Patient: Eleanor Vance
DOB: 1954-04-12 (Age: 72)
MRN: MRN-9941-8812
Address: 10021 New York, NY
Encounter Date: 2026-09-04`}
          </pre>
        </div>

        <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
          <h2 className="text-sm font-bold text-emerald-400 mb-3 uppercase">Safe-Harbor Anonymized Export</h2>
          <pre className="p-3 bg-slate-950 rounded border border-slate-800 text-xs font-mono text-emerald-300 overflow-x-auto">
{`Pseudonym: SYNTH-77B19C02
Age Band: 70-74
Masked MRN: MRN-***-8812
Zip 3-Digit: 100xx
Encounter Year: 2026`}
          </pre>
        </div>
      </div>
    </div>
  );
};
