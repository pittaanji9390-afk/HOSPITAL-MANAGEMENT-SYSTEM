import React, { useState } from 'react';

export const FhirAllergyIntoleranceConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-rose-400">FHIR R4 AllergyIntolerance &amp; Safety Alerts</h1>
          <p className="text-sm text-slate-400">Critical Hypersensitivity Ledger and Anaphylaxis Risk Warnings</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-rose-800/70">
        <span className="text-xs font-mono text-rose-400 font-bold">Criticality: HIGH</span>
        <h2 className="text-base font-bold text-white mb-2">Penicillin G / Beta-Lactam Antibiotics (RxNorm: 7980)</h2>
        <p className="text-xs text-rose-200 font-sans">Reaction: Anaphylaxis, severe bronchospasm and facial angioedema.</p>
      </div>
    </div>
  );
};
