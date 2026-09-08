import React, { useState } from 'react';

export const BillingClaimsAnsiX12Portal: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">Revenue Cycle &amp; ANSI X12 EDI Claims Portal</h1>
          <p className="text-sm text-slate-400">Electronic 837I Inpatient Claims Dispatch &amp; 835 Remittance Advice Processing</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700 font-mono text-xs">
        <div className="flex justify-between items-start mb-2">
          <div>
            <span className="text-sky-400 font-bold">CLM-881201 (Medicare Part A)</span>
            <h2 className="text-base font-bold text-white font-sans">MS-DRG 329: Major Small &amp; Large Bowel Procedures</h2>
          </div>
          <span className="px-2 py-0.5 bg-emerald-900/60 text-emerald-300 rounded font-bold font-sans">TRANSMITTED 837I</span>
        </div>
        <p className="text-slate-300">Total Billed: $48,500.00 | Expected Reimbursement: $39,200.00</p>
      </div>
    </div>
  );
};
