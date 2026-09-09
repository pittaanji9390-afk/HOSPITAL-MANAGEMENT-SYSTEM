import React, { useState } from 'react';

export const CentorPharyngitisDecisionConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">Modified Centor McIsaac Strep Pharyngitis Score</h1>
          <p className="text-sm text-slate-400">Group A Strep Probability &amp; Antibiotic Stewardship Guidance</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <h2 className="text-base font-bold text-white mb-2">Centor Score: 3 (30% Strep Probability)</h2>
        <p className="text-xs text-sky-300">Action: Perform Rapid Antigen Detection Test (RADT) before antibiotic prescribing.</p>
      </div>
    </div>
  );
};
