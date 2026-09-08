import React, { useState } from 'react';

export const MehranCinManager: React.FC = () => {
  const [scr, setScr] = useState<number>(1.6);
  const [weightKg, setWeightKg] = useState<number>(75);
  const [contrastVol, setContrastVol] = useState<number>(180);

  const maxSafeContrast = scr > 0 ? (5 * weightKg) / scr : 300;
  const isOverLimit = contrastVol > maxSafeContrast;

  return (
    <div className="p-6 bg-slate-900 text-white rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-700">
        <div>
          <h2 className="text-2xl font-bold text-emerald-400">Contrast Nephropathy (CIN) & Mehran Advisor</h2>
          <p className="text-sm text-slate-400">Renal Protection Protocols & Contrast Volume Upper Limit</p>
        </div>
        <span className="px-3 py-1 bg-emerald-950 text-emerald-300 border border-emerald-700 rounded-full text-xs font-mono">
          KDIGO CIN
        </span>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mt-6">
        <div className="space-y-4">
          <div className="grid grid-cols-2 gap-3">
            <div>
              <label className="text-xs text-slate-300">Serum Creatinine (mg/dL)</label>
              <input
                type="number"
                step="0.1"
                value={scr}
                onChange={(e) => setScr(Number(e.target.value))}
                className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
              />
            </div>
            <div>
              <label className="text-xs text-slate-300">Weight (kg)</label>
              <input
                type="number"
                value={weightKg}
                onChange={(e) => setWeightKg(Number(e.target.value))}
                className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
              />
            </div>
          </div>
        </div>

        <div className="bg-slate-950 p-5 rounded-lg border border-slate-800 flex flex-col justify-between">
          <div className="space-y-2 text-sm">
            <div className="flex justify-between py-1 border-b border-slate-800">
              <span className="text-slate-400">Max Safe Contrast Limit:</span>
              <span className="font-mono text-emerald-400">{maxSafeContrast.toFixed(0)} mL</span>
            </div>
            <div className="flex justify-between py-1 border-b border-slate-800">
              <span className="text-slate-400">Contrast Ratio:</span>
              <span className={isOverLimit ? 'font-bold text-red-400' : 'text-emerald-300'}>
                {(contrastVol / maxSafeContrast).toFixed(2)}x
              </span>
            </div>
          </div>

          <button className="w-full mt-4 py-2.5 bg-emerald-600 hover:bg-emerald-500 font-semibold rounded-lg text-white transition-colors">
            Confirm Renal Protection Protocol
          </button>
        </div>
      </div>
    </div>
  );
};
