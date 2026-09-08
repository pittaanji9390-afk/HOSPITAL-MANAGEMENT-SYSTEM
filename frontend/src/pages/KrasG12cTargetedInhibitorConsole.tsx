import React, { useState } from 'react';

export const KrasG12cTargetedInhibitorConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">KRAS G12C Targeted Inhibitor Console</h1>
          <p className="text-sm text-slate-400">Sotorasib / Adagrasib Covalent Switch-II Pocket Inhibitor Matching</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <h2 className="text-base font-bold text-white mb-2">Mutation: KRAS p.G12C Point Mutation</h2>
        <p className="text-xs text-emerald-400">Matched Agent: Sotorasib (Lumakras) 960 mg PO Daily</p>
      </div>
    </div>
  );
};
