import React, { useState } from 'react';

export const BurnParklandResuscitationConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">Burn Fluid Resuscitation &amp; Lund-Browder</h1>
          <p className="text-sm text-slate-400">Parkland Formula (4 mL/kg/%TBSA) &amp; Hourly Urine Output Targets</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <h2 className="text-base font-bold text-white mb-2">35% TBSA Burn (70 kg Patient)</h2>
        <p className="text-xs text-slate-300">Total 24h LR: 9,800 mL | First 8h Rate: 613 mL/h | Next 16h Rate: 306 mL/h</p>
      </div>
    </div>
  );
};
