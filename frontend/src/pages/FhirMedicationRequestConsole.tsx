import React, { useState } from 'react';

export const FhirMedicationRequestConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">FHIR R4 MedicationRequest &amp; CPOE Viewer</h1>
          <p className="text-sm text-slate-400">RxNorm Harmonized Drug Orders, Dosage Sigs &amp; Intent Verification</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <span className="text-xs font-mono text-sky-400 font-bold">MedicationRequest/MED-4412</span>
        <h2 className="text-base font-bold text-white mb-2">Lisinopril 10 mg Oral Tablet (RxNorm: 314076)</h2>
        <p className="text-xs text-slate-300 font-mono">Sig: Take 1 tablet by mouth daily in the morning for hypertension.</p>
      </div>
    </div>
  );
};
