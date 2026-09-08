import React, { useState } from 'react';

export const PharmacyMedicationAdministrationPortal: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">Barcode Medication Administration (BCMA) Portal</h1>
          <p className="text-sm text-slate-400">Five Rights of Medication Verification &amp; Dual-Signoff for High-Alert Drugs</p>
        </div>
      </header>

      <div className="bg-slate-800/80 rounded-xl border border-slate-700 p-5">
        <h2 className="text-base font-bold text-white mb-3">Barcode Scanner Emulation</h2>
        <div className="flex gap-3">
          <input type="text" placeholder="Scan Patient Wristband Barcode..." className="flex-1 bg-slate-900 border border-slate-700 rounded px-3 py-2 text-xs font-mono text-white" />
          <button className="bg-sky-600 text-white px-4 py-2 rounded text-xs font-semibold">Verify Wristband</button>
        </div>
      </div>
    </div>
  );
};
