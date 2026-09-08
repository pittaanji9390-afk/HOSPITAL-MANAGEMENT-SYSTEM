import React, { useState } from 'react';

export const FhirServiceRequestConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">FHIR R4 ServiceRequest &amp; Order Tracker</h1>
          <p className="text-sm text-slate-400">CPT/HCPCS Diagnostic Orders and Subspecialty Consultations</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <span className="text-xs font-mono text-sky-400 font-bold">ServiceRequest/SRV-8821 (Priority: STAT)</span>
        <h2 className="text-base font-bold text-white mb-2">CT Angiography Chest with IV Contrast (CPT: 71275)</h2>
        <p className="text-xs text-slate-300 font-mono">Reason: Rule out Acute Pulmonary Embolism in post-op setting.</p>
      </div>
    </div>
  );
};
