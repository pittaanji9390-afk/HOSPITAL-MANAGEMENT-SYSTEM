import React, { useState } from 'react';

export const NeonatalSepsisCalculator: React.FC = () => {
  const [maternalTemp, setMaternalTemp] = useState<number>(38.2);
  const [romHours, setRomHours] = useState<number>(14);

  const eosRisk = (maternalTemp >= 38 ? 2.4 : 0.4) * (romHours >= 18 ? 1.8 : 1.0);

  return (
    <div className="p-6 bg-slate-900 text-white rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-700">
        <div>
          <h2 className="text-2xl font-bold text-cyan-400">Kaiser Early-Onset Sepsis (EOS) Calculator</h2>
          <p className="text-sm text-slate-400">Neonatal Sepsis Stratification & Antibiotic Stewardship</p>
        </div>
        <span className="px-3 py-1 bg-cyan-950 text-cyan-300 border border-cyan-700 rounded-full text-xs font-mono">
          Kaiser EOS
        </span>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mt-6">
        <div className="space-y-4">
          <div>
            <label className="text-xs text-slate-300">Highest Maternal Temp (&deg;C)</label>
            <input
              type="number"
              step="0.1"
              value={maternalTemp}
              onChange={(e) => setMaternalTemp(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>
          <div>
            <label className="text-xs text-slate-300">Rupture of Membranes (Hours)</label>
            <input
              type="number"
              value={romHours}
              onChange={(e) => setRomHours(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>
        </div>

        <div className="bg-slate-950 p-5 rounded-lg border border-slate-800 flex flex-col justify-between">
          <div className="text-center p-4 bg-slate-900 rounded-lg border border-slate-800">
            <span className="text-xs text-slate-400">Estimated Sepsis Risk</span>
            <p className="text-3xl font-black mt-1 text-cyan-300">{eosRisk.toFixed(2)} / 1000 births</p>
          </div>

          <button className="w-full mt-4 py-2.5 bg-cyan-600 hover:bg-cyan-500 font-semibold rounded-lg text-white transition-colors">
            Evaluate Neonatal Orders
          </button>
        </div>
      </div>
    </div>
  );
};
