import React, { useState } from 'react';

export const PatientBenefitAccumulatorConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">Patient Benefit Accumulator Tracker</h1>
          <p className="text-sm text-slate-400">Deductible Met vs Remaining, Out-of-Pocket Max (MOOP) &amp; Co-insurance</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <h2 className="text-base font-bold text-white mb-2">Individual Deductible: $1,500 ($1,050 Met / $450 Remaining)</h2>
        <p className="text-xs text-slate-300">Out-of-Pocket Max: $6,000 ($4,150 Met / $1,850 Remaining)</p>
      </div>
    </div>
  );
};
