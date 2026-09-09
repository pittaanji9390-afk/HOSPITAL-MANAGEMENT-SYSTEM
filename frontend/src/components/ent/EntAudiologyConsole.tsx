import React, { useState } from 'react';

export const EntAudiologyConsole: React.FC = () => {
  const [dixHallpike, setDixHallpike] = useState<boolean>(true);

  return (
    <div className="p-6 bg-slate-900 text-white rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-700">
        <div>
          <h2 className="text-2xl font-bold text-yellow-400">ENT Audiology & Vestibular Medicine Console</h2>
          <p className="text-sm text-slate-400">Dix-Hallpike BPPV Nystagmus Analyzer & Pure Tone Threshold Tracker</p>
        </div>
        <span className="px-3 py-1 bg-yellow-950 text-yellow-300 border border-yellow-700 rounded-full text-xs font-mono">
          ASHA Audiology
        </span>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mt-6">
        <div className="space-y-4">
          <label className="flex items-center gap-2 text-xs text-slate-300 cursor-pointer">
            <input
              type="checkbox"
              checked={dixHallpike}
              onChange={(e) => setDixHallpike(e.target.checked)}
              className="accent-yellow-500 rounded"
            />
            Positive Dix-Hallpike Test (Torsional Nystagmus)
          </label>
        </div>

        <div className="bg-slate-950 p-5 rounded-lg border border-slate-800 flex flex-col justify-between">
          <div className="text-center p-4 bg-slate-900 rounded-lg border border-slate-800">
            <span className="text-xs text-slate-400">Vestibular Maneuver</span>
            <p className="text-2xl font-bold text-yellow-300 mt-1">
              {dixHallpike ? 'Perform Epley Maneuver (Right Posterior Canal)' : 'No Maneuver Indicated'}
            </p>
          </div>

          <button className="w-full mt-4 py-2.5 bg-yellow-600 hover:bg-yellow-500 font-semibold rounded-lg text-slate-950 transition-colors">
            Log Vestibular Protocol
          </button>
        </div>
      </div>
    </div>
  );
};
