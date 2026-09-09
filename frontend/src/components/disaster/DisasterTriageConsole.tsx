import React, { useState } from 'react';

export const DisasterTriageConsole: React.FC = () => {
  const [canWalk, setCanWalk] = useState<boolean>(false);
  const [rr, setRr] = useState<number>(34);

  const tag = canWalk ? 'GREEN' : rr > 30 ? 'RED' : 'YELLOW';

  return (
    <div className="p-6 bg-slate-900 text-white rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-700">
        <div>
          <h2 className="text-2xl font-bold text-red-500">Hospital Incident Command (HICS) & Disaster Triage</h2>
          <p className="text-sm text-slate-400">Simple Triage and Rapid Treatment (START) Mass Casualty Algorithm</p>
        </div>
        <span className="px-3 py-1 bg-red-950 text-red-300 border border-red-700 rounded-full text-xs font-mono">
          FEMA HICS 2025
        </span>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mt-6">
        <div className="space-y-4">
          <div>
            <label className="text-xs text-slate-300">Respiratory Rate: {rr} breaths/min</label>
            <input
              type="number"
              value={rr}
              onChange={(e) => setRr(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>
        </div>

        <div className="bg-slate-950 p-5 rounded-lg border border-slate-800 flex flex-col justify-between">
          <div className="text-center p-4 bg-slate-900 rounded-lg border border-slate-800">
            <span className="text-xs text-slate-400">START Triage Category</span>
            <p className={tag === 'RED' ? 'text-3xl font-black text-red-500 mt-1' : 'text-3xl font-black text-amber-400 mt-1'}>
              {tag} (IMMEDIATE RESUSCITATION)
            </p>
          </div>

          <button className="w-full mt-4 py-2.5 bg-red-600 hover:bg-red-500 font-semibold rounded-lg text-white transition-colors">
            Deploy Decontamination / Surge Team
          </button>
        </div>
      </div>
    </div>
  );
};
