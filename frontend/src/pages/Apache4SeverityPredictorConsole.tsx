import React, { useState } from 'react';

export const Apache4SeverityPredictorConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">APACHE IV Acute Physiology Predictor</h1>
          <p className="text-sm text-slate-400">Predicted ICU Length-of-Stay, Mechanical Ventilation Duration &amp; Mortality</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <h2 className="text-base font-bold text-white mb-2">APACHE IV Score: 64</h2>
        <p className="text-xs text-slate-300">Predicted Mortality: 41.6% | Predicted ICU LOS: 7.6 Days | Predicted Vent: 5.1 Days</p>
      </div>
    </div>
  );
};
