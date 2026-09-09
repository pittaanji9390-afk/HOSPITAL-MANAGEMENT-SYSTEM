import React, { useState } from 'react';

export const ClinicalAdmissionEpisodePortal: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">Inpatient Admission &amp; Bed Placement Portal</h1>
          <p className="text-sm text-slate-400">Electronic Admission Tracking, Direct Transfers &amp; Bed Occupancy Matrix</p>
        </div>
      </header>

      <div className="bg-slate-800/80 rounded-xl border border-slate-700 p-5">
        <h2 className="text-base font-bold text-white mb-3">Active Inpatient Episodes</h2>
        <div className="space-y-3 font-mono text-xs">
          <div className="p-4 bg-slate-900/80 rounded border border-slate-700/60 flex justify-between items-center">
            <div>
              <span className="text-sky-400 font-bold block">ADM-994101 (Patient: PT-9941)</span>
              <span className="text-slate-300 font-sans">Ward: ICU-Bed-04 | Attending: Dr. Gregory House</span>
            </div>
            <span className="px-2.5 py-1 bg-emerald-900/60 text-emerald-300 font-sans font-bold rounded">INPATIENT ACTIVE</span>
          </div>
        </div>
      </div>
    </div>
  );
};
