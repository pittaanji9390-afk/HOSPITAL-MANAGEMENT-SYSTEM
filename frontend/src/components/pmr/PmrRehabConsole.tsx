import React, { useState } from 'react';

export const PmrRehabConsole: React.FC = () => {
  const [motor, setMotor] = useState<number>(62);
  const [berg, setBerg] = useState<number>(38);

  return (
    <div className="p-6 bg-slate-900 text-white rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-700">
        <div>
          <h2 className="text-2xl font-bold text-emerald-400">Physical Medicine & Rehabilitation (PM&R) Studio</h2>
          <p className="text-sm text-slate-400">FIM Motor Independence & Berg Balance Fall Risk Assessment</p>
        </div>
        <span className="px-3 py-1 bg-emerald-950 text-emerald-300 border border-emerald-700 rounded-full text-xs font-mono">
          Uniform Data System (UDS)
        </span>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mt-6">
        <div className="space-y-4">
          <div>
            <label className="text-xs text-slate-300">Motor FIM (13-91): {motor}</label>
            <input
              type="number"
              value={motor}
              onChange={(e) => setMotor(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>
          <div>
            <label className="text-xs text-slate-300">Berg Balance Score (0-56): {berg}</label>
            <input
              type="number"
              value={berg}
              onChange={(e) => setBerg(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>
        </div>

        <div className="bg-slate-950 p-5 rounded-lg border border-slate-800 flex flex-col justify-between">
          <div className="text-center p-4 bg-slate-900 rounded-lg border border-slate-800">
            <span className="text-xs text-slate-400">Fall Risk Stratification</span>
            <p className={berg < 45 ? 'text-2xl font-bold text-red-400 mt-1' : 'text-2xl font-bold text-emerald-400 mt-1'}>
              {berg < 45 ? 'HIGH FALL RISK (<45)' : 'LOW FALL RISK'}
            </p>
          </div>

          <button className="w-full mt-4 py-2.5 bg-emerald-600 hover:bg-emerald-500 font-semibold rounded-lg text-white transition-colors">
            Authorize Rehab Care Plan
          </button>
        </div>
      </div>
    </div>
  );
};
