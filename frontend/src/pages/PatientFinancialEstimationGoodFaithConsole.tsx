import React, { useState } from 'react';

export const PatientFinancialEstimationGoodFaithConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">No Surprises Act Good Faith Estimate (GFE)</h1>
          <p className="text-sm text-slate-400">Pre-Service Out-of-Pocket Estimate &amp; Uninsured Patient Protections</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <h2 className="text-base font-bold text-white mb-2">Estimated Patient Responsibility: $450.00</h2>
        <p className="text-xs text-slate-300">Self-Pay Discount (35%) Applied | Compliant with Federal No Surprises Act</p>
      </div>
    </div>
  );
};
