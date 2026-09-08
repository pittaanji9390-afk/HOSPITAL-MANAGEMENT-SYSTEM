import React, { useState } from 'react';

export const RadiologyDicomWorklistPortal: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">Radiology Modality Worklist (MWL) &amp; PACS Portal</h1>
          <p className="text-sm text-slate-400">DICOM Study Dispatch, CT/MR Scanner Scheduling &amp; Radiologist Read Queue</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <span className="text-xs font-mono text-sky-400 font-bold block mb-1">ACC-77401 (Modality: CT)</span>
        <h2 className="text-base font-bold text-white mb-2">CT Abdomen/Pelvis with IV Contrast</h2>
        <span className="px-2 py-0.5 bg-emerald-900/60 text-emerald-300 text-xs font-mono font-bold rounded">REPORTED</span>
      </div>
    </div>
  );
};
