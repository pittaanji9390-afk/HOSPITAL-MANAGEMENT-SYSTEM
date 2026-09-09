import React, { useState } from 'react';

export const FfrWaveformViewer: React.FC = () => {
  const [aorticPa, setAorticPa] = useState<number>(95);
  const [distalPd, setDistalPd] = useState<number>(72);

  const ffr = distalPd / aorticPa;
  const isIschemic = ffr <= 0.80;

  return (
    <div className="p-6 bg-slate-900 text-white rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-700">
        <div>
          <h2 className="text-2xl font-bold text-cyan-400">FFR / iFR Coronary Physiology Console</h2>
          <p className="text-sm text-slate-400">Intracoronary Pressure Wire Waveforms & Hyperemic Flow Reserve</p>
        </div>
        <span className="px-3 py-1 bg-cyan-950 text-cyan-300 border border-cyan-700 rounded-full text-xs font-mono">
          DEFER/FAME Validated
        </span>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mt-6">
        <div className="space-y-4">
          <div>
            <label className="text-xs text-slate-300 font-semibold">Mean Aortic Pressure (Pa): {aorticPa} mmHg</label>
            <input
              type="range"
              min="50"
              max="150"
              value={aorticPa}
              onChange={(e) => setAorticPa(Number(e.target.value))}
              className="w-full mt-2 accent-red-500"
            />
          </div>

          <div>
            <label className="text-xs text-slate-300 font-semibold">Distal Coronary Pressure (Pd): {distalPd} mmHg</label>
            <input
              type="range"
              min="30"
              max="140"
              value={distalPd}
              onChange={(e) => setDistalPd(Number(e.target.value))}
              className="w-full mt-2 accent-yellow-500"
            />
          </div>
        </div>

        <div className="bg-slate-950 p-5 rounded-lg border border-slate-800 flex flex-col justify-between">
          <div className="text-center p-4 bg-slate-900 rounded-lg border border-slate-800">
            <span className="text-xs text-slate-400">Fractional Flow Reserve (FFR)</span>
            <p className={isIschemic ? 'text-4xl font-black mt-1 text-rose-400' : 'text-4xl font-black mt-1 text-emerald-400'}>
              {ffr.toFixed(2)}
            </p>
            <p className="text-xs text-slate-400 mt-1">Ischemic Cutoff: &le; 0.80</p>
          </div>

          <button className="w-full mt-4 py-2.5 bg-cyan-600 hover:bg-cyan-500 font-semibold rounded-lg text-white transition-colors">
            Log Pressure Wire Telemetry
          </button>
        </div>
      </div>
    </div>
  );
};
