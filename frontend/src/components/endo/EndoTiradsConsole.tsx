import React, { useState } from 'react';

export const EndoTiradsConsole: React.FC = () => {
  const [points, setPoints] = useState<number>(6);
  const [size, setSize] = useState<number>(1.8);

  const isFna = points >= 7 ? size >= 1.0 : points >= 4 ? size >= 1.5 : false;

  return (
    <div className="p-6 bg-slate-900 text-white rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-700">
        <div>
          <h2 className="text-2xl font-bold text-amber-400">Thyroid Ultrasound TI-RADS & FNA Studio</h2>
          <p className="text-sm text-slate-400">ACR TI-RADS Point Classification & Fine Needle Aspiration Biopsy Thresholds</p>
        </div>
        <span className="px-3 py-1 bg-amber-950 text-amber-300 border border-amber-700 rounded-full text-xs font-mono">
          ACR TI-RADS
        </span>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mt-6">
        <div className="space-y-4">
          <div>
            <label className="text-xs text-slate-300">Total TI-RADS Points: {points}</label>
            <input
              type="number"
              value={points}
              onChange={(e) => setPoints(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>
          <div>
            <label className="text-xs text-slate-300">Nodule Size (cm): {size} cm</label>
            <input
              type="number"
              step="0.1"
              value={size}
              onChange={(e) => setSize(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>
        </div>

        <div className="bg-slate-950 p-5 rounded-lg border border-slate-800 flex flex-col justify-between">
          <div className="text-center p-4 bg-slate-900 rounded-lg border border-slate-800">
            <span className="text-xs text-slate-400">Biopsy Recommendation</span>
            <p className={isFna ? 'text-2xl font-bold text-rose-400 mt-1' : 'text-2xl font-bold text-emerald-400 mt-1'}>
              {isFna ? 'FNA BIOPSY RECOMMENDED' : 'FOLLOW-UP ULTRASOUND'}
            </p>
          </div>

          <button className="w-full mt-4 py-2.5 bg-amber-600 hover:bg-amber-500 font-semibold rounded-lg text-slate-950 transition-colors">
            Order Ultrasound / FNA
          </button>
        </div>
      </div>
    </div>
  );
};
