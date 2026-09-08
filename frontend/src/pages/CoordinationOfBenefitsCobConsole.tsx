import React, { useState } from 'react';

export const CoordinationOfBenefitsCobConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">Coordination of Benefits (COB) Determinator</h1>
          <p className="text-sm text-slate-400">NAIC Birthday Rule, Dependent Coverage &amp; Medicare Secondary Payer (MSP)</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <h2 className="text-base font-bold text-white mb-2">Primary Payer: Mother's Employer Group Plan (Birthday Rule: May vs August)</h2>
        <p className="text-xs text-sky-300">Secondary Payer: Father's Commercial PPO Plan</p>
      </div>
    </div>
  );
};
