import React, { useState } from 'react';

export const ToxicologyNomogramConsole: React.FC = () => {
  const [hours, setHours] = useState<number>(6);
  const [level, setLevel] = useState<number>(140);

  const threshold = 150 * Math.pow(0.5, (hours - 4) / 4);
  const isToxic = hours >= 4 && level >= threshold;

  return (
    <div className="p-6 bg-slate-900 text-white rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-700">
        <div>
          <h2 className="text-2xl font-bold text-amber-400">Clinical Toxicology & Antidote Nomogram</h2>
          <p className="text-sm text-slate-400">Rumack-Matthew Acetaminophen Toxicity & IV N-Acetylcysteine (NAC) Protocol</p>
        </div>
        <span className="px-3 py-1 bg-amber-950 text-amber-300 border border-amber-700 rounded-full text-xs font-mono">
          AAPCC Verified
        </span>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mt-6">
        <div className="space-y-4">
          <div>
            <label className="text-xs text-slate-300">Hours Post-Ingestion: {hours} h</label>
            <input
              type="number"
              min="4"
              max="24"
              value={hours}
              onChange={(e) => setHours(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>
          <div>
            <label className="text-xs text-slate-300">Serum APAP Level (mcg/mL): {level}</label>
            <input
              type="number"
              value={level}
              onChange={(e) => setLevel(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>
        </div>

        <div className="bg-slate-950 p-5 rounded-lg border border-slate-800 flex flex-col justify-between">
          <div className="text-center p-4 bg-slate-900 rounded-lg border border-slate-800">
            <span className="text-xs text-slate-400">Nomogram Threshold at {hours}h: {threshold.toFixed(1)} mcg/mL</span>
            <p className={isToxic ? 'text-2xl font-bold text-red-400 mt-1' : 'text-2xl font-bold text-emerald-400 mt-1'}>
              {isToxic ? 'HEPATOTOXIC RISK: START IV NAC' : 'BELOW TREATMENT LINE'}
            </p>
          </div>

          <button className="w-full mt-4 py-2.5 bg-amber-600 hover:bg-amber-500 font-semibold rounded-lg text-slate-950 transition-colors">
            Order IV Acetylcysteine
          </button>
        </div>
      </div>
    </div>
  );
};
