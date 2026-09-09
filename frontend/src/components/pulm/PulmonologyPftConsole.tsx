import React, { useState } from 'react';

export const PulmonologyPftConsole: React.FC = () => {
  const [ratio, setRatio] = useState<number>(64);
  const [fev1Pred, setFev1Pred] = useState<number>(58);

  const isObstructive = ratio < 70;

  return (
    <div className="p-6 bg-slate-900 text-white rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-700">
        <div>
          <h2 className="text-2xl font-bold text-sky-400">Pulmonary Function Testing & Spirometry Studio</h2>
          <p className="text-sm text-slate-400">ATS/ERS GLI-2012 Reference Equations & GOLD COPD Staging</p>
        </div>
        <span className="px-3 py-1 bg-sky-950 text-sky-300 border border-sky-700 rounded-full text-xs font-mono">
          GOLD 2025
        </span>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mt-6">
        <div className="space-y-4">
          <div>
            <label className="text-xs text-slate-300">FEV1 / FVC Ratio (%): {ratio}%</label>
            <input
              type="number"
              value={ratio}
              onChange={(e) => setRatio(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>
          <div>
            <label className="text-xs text-slate-300">FEV1 % Predicted: {fev1Pred}%</label>
            <input
              type="number"
              value={fev1Pred}
              onChange={(e) => setFev1Pred(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>
        </div>

        <div className="bg-slate-950 p-5 rounded-lg border border-slate-800 flex flex-col justify-between">
          <div className="text-center p-4 bg-slate-900 rounded-lg border border-slate-800">
            <span className="text-xs text-slate-400">COPD Spirometric Classification</span>
            <p className={isObstructive ? 'text-2xl font-bold text-amber-400 mt-1' : 'text-2xl font-bold text-emerald-400 mt-1'}>
              {isObstructive ? 'GOLD 2 (Moderate Airflow Limitation)' : 'Normal Spirometry'}
            </p>
          </div>

          <button className="w-full mt-4 py-2.5 bg-sky-600 hover:bg-sky-500 font-semibold rounded-lg text-white transition-colors">
            Log PFT Report
          </button>
        </div>
      </div>
    </div>
  );
};
