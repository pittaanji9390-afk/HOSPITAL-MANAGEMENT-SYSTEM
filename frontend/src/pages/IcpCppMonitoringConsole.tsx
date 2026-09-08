import React, { useState } from 'react';

export const IcpCppMonitoringConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">Neuro-ICU Intracranial &amp; CPP Monitor</h1>
          <p className="text-sm text-slate-400">EVD Extraventricular Drainage &amp; Cerebral Perfusion Pressure (CPP 60-70)</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <h2 className="text-base font-bold text-white mb-2">ICP: 14 mmHg | CPP: 68 mmHg</h2>
        <span className="px-2 py-0.5 bg-emerald-900/60 text-emerald-300 rounded text-xs font-bold">OPTIMAL NEUROPROTECTION</span>
      </div>
    </div>
  );
};
