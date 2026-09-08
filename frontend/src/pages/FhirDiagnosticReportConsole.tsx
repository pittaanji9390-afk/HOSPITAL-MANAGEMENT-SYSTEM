import React, { useState } from 'react';

export const FhirDiagnosticReportConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">FHIR R4 DiagnosticReport &amp; Panels Viewer</h1>
          <p className="text-sm text-slate-400">Automated Assembly of Multi-Analyte Lab Bundles and Imaging Narratives</p>
        </div>
      </header>

      <div className="bg-slate-800/80 rounded-xl border border-slate-700 p-5">
        <span className="text-xs font-mono text-sky-400 font-bold">DiagnosticReport/REP-9921</span>
        <h2 className="text-base font-bold text-white mb-2">Comprehensive Metabolic Panel (CMP - LOINC 24323-8)</h2>
        <p className="text-xs text-slate-300 font-sans mb-4">Conclusion: Mild acute kidney injury with BUN/Cr elevation. Electrolytes otherwise within normal limits.</p>
      </div>
    </div>
  );
};
