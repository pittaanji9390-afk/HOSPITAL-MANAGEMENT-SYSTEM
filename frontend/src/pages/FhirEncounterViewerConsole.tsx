import React, { useState } from 'react';

export const FhirEncounterViewerConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">FHIR R4 Encounter &amp; Episode-of-Care Inspector</h1>
          <p className="text-sm text-slate-400">Inpatient Admission Class, Diagnosis Linkages &amp; Care Team Participants</p>
        </div>
      </header>

      <div className="bg-slate-800/80 rounded-xl border border-slate-700 p-5">
        <span className="text-xs font-mono text-sky-400 font-bold block mb-1">Encounter/ENC-881204</span>
        <h2 className="text-lg font-bold text-white mb-4">Inpatient Acute Care Admission (IMP)</h2>
        <div className="grid grid-cols-1 md:grid-cols-3 gap-4 font-mono text-xs mb-4">
          <div className="p-3 bg-slate-900/80 rounded border border-slate-700/60">
            <span className="text-slate-400 block">Status</span>
            <span className="text-emerald-400 font-bold text-sm">in-progress</span>
          </div>
          <div className="p-3 bg-slate-900/80 rounded border border-slate-700/60">
            <span className="text-slate-400 block">Subject</span>
            <span className="text-sky-300 font-bold text-sm">Patient/PT-9941</span>
          </div>
          <div className="p-3 bg-slate-900/80 rounded border border-slate-700/60">
            <span className="text-slate-400 block">Attending Practitioner</span>
            <span className="text-amber-300 font-bold text-sm">Practitioner/DR-7719</span>
          </div>
        </div>
      </div>
    </div>
  );
};
