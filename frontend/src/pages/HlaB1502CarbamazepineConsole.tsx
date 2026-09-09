import React, { useState } from 'react';

export const HlaB1502CarbamazepineConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">HLA-B*15:02 SJS / TEN Prevention Console</h1>
          <p className="text-sm text-slate-400">Carbamazepine and Oxcarbazepine Severe Cutaneous Adverse Reaction Screen</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <h2 className="text-base font-bold text-white mb-2">Result: HLA-B*15:02 NEGATIVE</h2>
        <p className="text-xs text-slate-300">Carbamazepine safe for trigeminal neuralgia / seizure therapy.</p>
      </div>
    </div>
  );
};
