import React, { useState } from 'react';

export const FhirImmunizationViewerConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">FHIR R4 Immunization Registry Console</h1>
          <p className="text-sm text-slate-400">CDC CVX Coded Vaccine Administration Records and State Registry Export</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <span className="text-xs font-mono text-sky-400 font-bold">Immunization/IMM-1142 (Status: COMPLETED)</span>
        <h2 className="text-base font-bold text-white mb-2">Influenza, seasonal, injectable, preservative free (CVX: 140)</h2>
        <p className="text-xs text-slate-400 font-mono">Administered: 2026-09-08 | Lot: FL2026-8812 | Route: Left Arm IM</p>
      </div>
    </div>
  );
};
