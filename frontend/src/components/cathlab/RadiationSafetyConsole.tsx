import React, { useState } from 'react';

export const RadiationSafetyConsole: React.FC = () => {
  const [airKermaGy, setAirKermaGy] = useState<number>(2.4);
  const isSrdExceeded = airKermaGy >= 2.0;

  return (
    <div className="p-6 bg-slate-900 text-white rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-700">
        <div>
          <h2 className="text-2xl font-bold text-amber-400">Fluoroscopy Radiation Safety Monitor</h2>
          <p className="text-sm text-slate-400">Air Kerma (Gy), Dose Area Product (DAP), and SIR Skin Injury Thresholds</p>
        </div>
        <span className="px-3 py-1 bg-amber-950 text-amber-300 border border-amber-700 rounded-full text-xs font-mono">
          SIR SRD Standard
        </span>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mt-6">
        <div className="space-y-4">
          <div>
            <label className="text-xs text-slate-300 font-semibold">Cumulative Reference Air Kerma: {airKermaGy} Gy</label>
            <input
              type="number"
              step="0.1"
              value={airKermaGy}
              onChange={(e) => setAirKermaGy(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>
        </div>

        <div className="bg-slate-950 p-5 rounded-lg border border-slate-800 flex flex-col justify-between">
          <div className={isSrdExceeded ? 'p-4 rounded-lg border bg-red-950/40 border-red-700' : 'p-4 rounded-lg border bg-slate-900 border-slate-800'}>
            <span className="text-xs text-slate-400">SRD Status</span>
            <p className={isSrdExceeded ? 'text-xl font-bold mt-1 text-red-400' : 'text-xl font-bold mt-1 text-emerald-400'}>
              {isSrdExceeded ? 'SRD THRESHOLD EXCEEDED (>= 2.0 Gy)' : 'WITHIN STANDARD SAFETY BOUNDS'}
            </p>
          </div>

          <button className="w-full mt-4 py-2.5 bg-amber-600 hover:bg-amber-500 font-semibold rounded-lg text-slate-950 transition-colors">
            Log Dose to Registry
          </button>
        </div>
      </div>
    </div>
  );
};
