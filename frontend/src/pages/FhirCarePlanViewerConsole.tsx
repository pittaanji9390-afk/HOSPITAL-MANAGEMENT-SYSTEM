import React, { useState } from 'react';

export const FhirCarePlanViewerConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">FHIR R4 CarePlan &amp; Clinical Goals Console</h1>
          <p className="text-sm text-slate-400">Interdisciplinary Care Coordination, Activity Milestones &amp; Outcomes</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <span className="text-xs font-mono text-sky-400 font-bold">CarePlan/CP-9901</span>
        <h2 className="text-base font-bold text-white mb-2">Post-Operative Enhanced Recovery After Surgery (ERAS) Pathway</h2>
        <p className="text-xs text-slate-300">Goal: Early ambulation within 6 hours post-op and oral fluid resumption.</p>
      </div>
    </div>
  );
};
