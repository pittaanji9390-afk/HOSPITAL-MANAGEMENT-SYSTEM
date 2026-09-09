import React, { useState } from 'react';

export const UrologyConsole: React.FC = () => {
  const [qmax, setQmax] = useState<number>(8.5);
  const [pvr, setPvr] = useState<number>(140);

  return (
    <div className="p-6 bg-slate-900 text-white rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-700">
        <div>
          <h2 className="text-2xl font-bold text-sky-400">Clinical Urology & Urodynamics Studio</h2>
          <p className="text-sm text-slate-400">Uroflowmetry Qmax & Post-Void Residual (PVR) Obstruction Analysis</p>
        </div>
        <span className="px-3 py-1 bg-sky-950 text-sky-300 border border-sky-700 rounded-full text-xs font-mono">
          AUA Guidelines
        </span>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mt-6">
        <div className="space-y-4">
          <div>
            <label className="text-xs text-slate-300">Peak Flow Rate (Qmax - mL/s): {qmax}</label>
            <input
              type="number"
              step="0.5"
              value={qmax}
              onChange={(e) => setQmax(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>
          <div>
            <label className="text-xs text-slate-300">Post-Void Residual (PVR - mL): {pvr}</label>
            <input
              type="number"
              value={pvr}
              onChange={(e) => setPvr(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>
        </div>

        <div className="bg-slate-950 p-5 rounded-lg border border-slate-800 flex flex-col justify-between">
          <div className="text-center p-4 bg-slate-900 rounded-lg border border-slate-800">
            <span className="text-xs text-slate-400">Obstruction Status</span>
            <p className="text-2xl font-bold text-amber-400 mt-1">Bladder Outlet Obstruction</p>
          </div>

          <button className="w-full mt-4 py-2.5 bg-sky-600 hover:bg-sky-500 font-semibold rounded-lg text-white transition-colors">
            Generate Urology Treatment Plan
          </button>
        </div>
      </div>
    </div>
  );
};
