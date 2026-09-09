import React, { useState } from 'react';

export const HfrReadmissionRiskConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">Heart Failure 30-Day Readmission Predictor</h1>
          <p className="text-sm text-slate-400">Transitional Care Management (TCM) Targeting &amp; BNP/eGFR Risk Stratification</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <h2 className="text-base font-bold text-white mb-2">30-Day Readmission Risk: 38% (Moderate-High)</h2>
        <p className="text-xs text-emerald-400">Recommended for Home Health Nurse Visit within 48 hours post-discharge.</p>
      </div>
    </div>
  );
};
