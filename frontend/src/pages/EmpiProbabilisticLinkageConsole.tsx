import React, { useState } from 'react';
import { SAMPLE_LINKAGE_RESULT } from '../types/empiFellegiSunter';

export const EmpiProbabilisticLinkageConsole: React.FC = () => {
  const [data, setData] = useState(SAMPLE_LINKAGE_RESULT);

  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">Enterprise Master Patient Index (EMPI) Linkage</h1>
          <p className="text-sm text-slate-400">Fellegi-Sunter Dual-Threshold Probabilistic Weight Matching Studio</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <span className="text-xs font-mono text-sky-400 font-bold block mb-1">Comparing {data.candidateRecordIdA} vs {data.candidateRecordIdB}</span>
        <h2 className="text-xl font-bold text-white mb-2">Match Weight Score: {data.totalMatchWeightScore}</h2>
        <span className="px-3 py-1 bg-amber-900/60 text-amber-300 font-bold text-xs rounded border border-amber-700">
          {data.matchClassification.replace(/_/g, ' ')}
        </span>
      </div>
    </div>
  );
};
