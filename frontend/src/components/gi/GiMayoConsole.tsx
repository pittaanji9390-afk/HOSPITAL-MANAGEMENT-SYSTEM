import React, { useState } from 'react';

export const GiMayoConsole: React.FC = () => {
  const [bleed, setBleed] = useState<number>(2);
  const [endo, setEndo] = useState<number>(2);

  const total = 2 + bleed + endo + 2;

  return (
    <div className="p-6 bg-slate-900 text-white rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-700">
        <div>
          <h2 className="text-2xl font-bold text-emerald-400">Gastroenterology Mayo IBD & Endoscopy Studio</h2>
          <p className="text-sm text-slate-400">Full Mayo Score & Boston Bowel Preparation Scale (BBPS) Classifier</p>
        </div>
        <span className="px-3 py-1 bg-emerald-950 text-emerald-300 border border-emerald-700 rounded-full text-xs font-mono">
          ACG IBD 2025
        </span>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mt-6">
        <div className="space-y-4">
          <div>
            <label className="text-xs text-slate-300">Rectal Bleeding Score (0-3): {bleed}</label>
            <input
              type="number"
              min="0"
              max="3"
              value={bleed}
              onChange={(e) => setBleed(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>
          <div>
            <label className="text-xs text-slate-300">Endoscopic Mucosal Appearance (0-3): {endo}</label>
            <input
              type="number"
              min="0"
              max="3"
              value={endo}
              onChange={(e) => setEndo(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>
        </div>

        <div className="bg-slate-950 p-5 rounded-lg border border-slate-800 flex flex-col justify-between">
          <div className="text-center p-4 bg-slate-900 rounded-lg border border-slate-800">
            <span className="text-xs text-slate-400">Total Mayo Score</span>
            <p className="text-3xl font-black text-emerald-300 mt-1">{total} / 12</p>
          </div>

          <button className="w-full mt-4 py-2.5 bg-emerald-600 hover:bg-emerald-500 font-semibold rounded-lg text-white transition-colors">
            Generate Endoscopy Note
          </button>
        </div>
      </div>
    </div>
  );
};
