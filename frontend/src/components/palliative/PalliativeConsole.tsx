import React, { useState } from 'react';

export const PalliativeConsole: React.FC = () => {
  const [pps, setPps] = useState<number>(40);

  return (
    <div className="p-6 bg-slate-900 text-white rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-700">
        <div>
          <h2 className="text-2xl font-bold text-teal-400">Palliative Medicine & Comfort Care Studio</h2>
          <p className="text-sm text-slate-400">Palliative Performance Scale (PPSv2) & ESAS-r Symptom Titration</p>
        </div>
        <span className="px-3 py-1 bg-teal-950 text-teal-300 border border-teal-700 rounded-full text-xs font-mono">
          AAHPM Consensus
        </span>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mt-6">
        <div className="space-y-4">
          <div>
            <label className="text-xs text-slate-300">Palliative Performance Scale (PPS %): {pps}%</label>
            <input
              type="number"
              step="10"
              min="10"
              max="100"
              value={pps}
              onChange={(e) => setPps(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>
        </div>

        <div className="bg-slate-950 p-5 rounded-lg border border-slate-800 flex flex-col justify-between">
          <div className="text-center p-4 bg-slate-900 rounded-lg border border-slate-800">
            <span className="text-xs text-slate-400">Care Trajectory</span>
            <p className="text-2xl font-bold text-teal-300 mt-1">
              {pps <= 40 ? 'Hospice Eligible / Comfort-Focused Care' : 'Palliative Co-Management'}
            </p>
          </div>

          <button className="w-full mt-4 py-2.5 bg-teal-600 hover:bg-teal-500 font-semibold rounded-lg text-white transition-colors">
            Confirm Comfort Orders
          </button>
        </div>
      </div>
    </div>
  );
};
