import React, { useState } from 'react';

export const SleepPsgConsole: React.FC = () => {
  const [ahi, setAhi] = useState<number>(24);
  const [nadir, setNadir] = useState<number>(82);

  return (
    <div className="p-6 bg-slate-900 text-white rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-700">
        <div>
          <h2 className="text-2xl font-bold text-indigo-400">Polysomnography & Sleep Architecture Studio</h2>
          <p className="text-sm text-slate-400">Apnea-Hypopnea Index (AHI) & Positive Airway Pressure (PAP) Prescriptions</p>
        </div>
        <span className="px-3 py-1 bg-indigo-950 text-indigo-300 border border-indigo-700 rounded-full text-xs font-mono">
          AASM Standards
        </span>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mt-6">
        <div className="space-y-4">
          <div>
            <label className="text-xs text-slate-300">Apnea-Hypopnea Index (events/hr): {ahi}</label>
            <input
              type="number"
              value={ahi}
              onChange={(e) => setAhi(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>
          <div>
            <label className="text-xs text-slate-300">Nadir SpO2 (%): {nadir}%</label>
            <input
              type="number"
              value={nadir}
              onChange={(e) => setNadir(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>
        </div>

        <div className="bg-slate-950 p-5 rounded-lg border border-slate-800 flex flex-col justify-between">
          <div className="text-center p-4 bg-slate-900 rounded-lg border border-slate-800">
            <span className="text-xs text-slate-400">Obstructive Sleep Apnea Classification</span>
            <p className="text-2xl font-bold text-indigo-300 mt-1">
              {ahi >= 30 ? 'Severe OSA' : ahi >= 15 ? 'Moderate OSA' : ahi >= 5 ? 'Mild OSA' : 'Normal'}
            </p>
          </div>

          <button className="w-full mt-4 py-2.5 bg-indigo-600 hover:bg-indigo-500 font-semibold rounded-lg text-white transition-colors">
            Generate CPAP Order
          </button>
        </div>
      </div>
    </div>
  );
};
