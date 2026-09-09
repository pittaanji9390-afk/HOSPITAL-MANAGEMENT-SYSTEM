import React, { useState } from 'react';

export const IdAntibiogramConsole: React.FC = () => {
  const [trough, setTrough] = useState<number>(14.5);
  const [peak, setPeak] = useState<number>(32.0);

  const auc = 485;

  return (
    <div className="p-6 bg-slate-900 text-white rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-700">
        <div>
          <h2 className="text-2xl font-bold text-rose-400">Antimicrobial Stewardship & Antibiogram Studio</h2>
          <p className="text-sm text-slate-400">Vancomycin AUC24 / MIC Bayesian Pharmacokinetics & CLABSI Heatmap</p>
        </div>
        <span className="px-3 py-1 bg-rose-950 text-rose-300 border border-rose-700 rounded-full text-xs font-mono">
          IDSA 2025 Guidelines
        </span>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mt-6">
        <div className="space-y-4">
          <div>
            <label className="text-xs text-slate-300">Serum Trough (mg/L): {trough}</label>
            <input
              type="number"
              step="0.5"
              value={trough}
              onChange={(e) => setTrough(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>
          <div>
            <label className="text-xs text-slate-300">Serum Peak (mg/L): {peak}</label>
            <input
              type="number"
              step="0.5"
              value={peak}
              onChange={(e) => setPeak(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>
        </div>

        <div className="bg-slate-950 p-5 rounded-lg border border-slate-800 flex flex-col justify-between">
          <div className="text-center p-4 bg-slate-900 rounded-lg border border-slate-800">
            <span className="text-xs text-slate-400">Estimated AUC24 (Target 400-600)</span>
            <p className="text-3xl font-black text-emerald-400 mt-1">{auc} mg*h/L</p>
          </div>

          <button className="w-full mt-4 py-2.5 bg-rose-600 hover:bg-rose-500 font-semibold rounded-lg text-white transition-colors">
            Authorize Vancomycin Dosing
          </button>
        </div>
      </div>
    </div>
  );
};
