import React, { useState } from 'react';

export const RheumatologyDas28Console: React.FC = () => {
  const [tjc, setTjc] = useState<number>(6);
  const [sjc, setSjc] = useState<number>(4);
  const [crp, setCrp] = useState<number>(18);

  const score = 0.56 * Math.sqrt(tjc) + 0.28 * Math.sqrt(sjc) + 0.36 * Math.log(crp + 1) + 0.014 * 50 + 0.96;

  return (
    <div className="p-6 bg-slate-900 text-white rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-700">
        <div>
          <h2 className="text-2xl font-bold text-violet-400">Rheumatoid Arthritis DAS28-CRP Studio</h2>
          <p className="text-sm text-slate-400">28-Joint Disease Activity Score & Biologic Response Evaluator</p>
        </div>
        <span className="px-3 py-1 bg-violet-950 text-violet-300 border border-violet-700 rounded-full text-xs font-mono">
          ACR / EULAR 2025
        </span>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mt-6">
        <div className="space-y-4">
          <div>
            <label className="text-xs text-slate-300">Tender Joint Count (0-28): {tjc}</label>
            <input
              type="number"
              value={tjc}
              onChange={(e) => setTjc(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>
          <div>
            <label className="text-xs text-slate-300">Swollen Joint Count (0-28): {sjc}</label>
            <input
              type="number"
              value={sjc}
              onChange={(e) => setSjc(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>
        </div>

        <div className="bg-slate-950 p-5 rounded-lg border border-slate-800 flex flex-col justify-between">
          <div className="text-center p-4 bg-slate-900 rounded-lg border border-slate-800">
            <span className="text-xs text-slate-400">Calculated DAS28-CRP</span>
            <p className="text-3xl font-black text-violet-300 mt-1">{score.toFixed(2)}</p>
            <p className="text-xs text-slate-400 mt-1">
              {score > 5.1 ? 'High Activity' : score > 3.2 ? 'Moderate Activity' : 'Low/Remission'}
            </p>
          </div>

          <button className="w-full mt-4 py-2.5 bg-violet-600 hover:bg-violet-500 font-semibold rounded-lg text-white transition-colors">
            Update Biologic Treatment Plan
          </button>
        </div>
      </div>
    </div>
  );
};
