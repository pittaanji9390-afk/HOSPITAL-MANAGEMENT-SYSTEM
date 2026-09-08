import React, { useState } from 'react';

export const LvPressureVolumeConsole: React.FC = () => {
  const [map, setMap] = useState<number>(75);
  const [co, setCo] = useState<number>(3.8);

  const cpo = (map * co) / 451;
  const isShock = cpo < 0.6;

  return (
    <div className="p-6 bg-slate-900 text-white rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-700">
        <div>
          <h2 className="text-2xl font-bold text-rose-400">LV Hemodynamics & Shock Profiler</h2>
          <p className="text-sm text-slate-400">Cardiac Power Output (CPO) and Mechanical Circulatory Support</p>
        </div>
        <span className="px-3 py-1 bg-rose-950 text-rose-300 border border-rose-700 rounded-full text-xs font-mono">
          SHOCK Trial CPO
        </span>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mt-6">
        <div className="space-y-4">
          <div>
            <label className="text-xs text-slate-300">Mean Arterial Pressure (mmHg)</label>
            <input
              type="number"
              value={map}
              onChange={(e) => setMap(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>
        </div>

        <div className="bg-slate-950 p-5 rounded-lg border border-slate-800 flex flex-col justify-between">
          <div className={isShock ? 'p-4 rounded-lg border bg-rose-950/40 border-rose-700' : 'p-4 rounded-lg border bg-slate-900 border-slate-800'}>
            <span className="text-xs text-slate-400">Cardiac Power Output (CPO)</span>
            <p className={isShock ? 'text-3xl font-black mt-1 text-rose-400' : 'text-3xl font-black mt-1 text-emerald-400'}>
              {cpo.toFixed(2)} Watts
            </p>
          </div>

          <button className="w-full mt-4 py-2.5 bg-rose-600 hover:bg-rose-500 font-semibold rounded-lg text-white transition-colors">
            Transmit Cath Report
          </button>
        </div>
      </div>
    </div>
  );
};
