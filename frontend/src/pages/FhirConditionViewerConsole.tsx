import React, { useState } from 'react';

export const FhirConditionViewerConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">FHIR R4 Condition &amp; Problem List Explorer</h1>
          <p className="text-sm text-slate-400">SNOMED-CT / ICD-10 Coding and Verification Status Ledger</p>
        </div>
      </header>

      <div className="space-y-4">
        <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
          <div className="flex justify-between items-start mb-2">
            <div>
              <span className="text-xs font-mono text-sky-400 font-bold">Condition/COND-01 (ICD-10: I21.0)</span>
              <h2 className="text-base font-bold text-white">Acute Transmural Myocardial Infarction of Anterior Wall</h2>
            </div>
            <span className="px-2 py-0.5 bg-emerald-900/60 text-emerald-300 rounded text-xs font-bold font-mono">active / confirmed</span>
          </div>
          <p className="text-xs text-slate-400 font-mono">Recorded Date: 2026-09-08 | Onset: 2026-09-08</p>
        </div>
      </div>
    </div>
  );
};
