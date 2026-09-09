import React, { useState } from 'react';

export const VascularWifiConsole: React.FC = () => {
  const [abi, setAbi] = useState<number>(0.45);

  return (
    <div className="p-6 bg-slate-900 text-white rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-700">
        <div>
          <h2 className="text-2xl font-bold text-red-400">Vascular Surgery WIfI Limb Salvage Studio</h2>
          <p className="text-sm text-slate-400">SVS WIfI Classification (Wound, Ischemia, Foot Infection) & ABI</p>
        </div>
        <span className="px-3 py-1 bg-red-950 text-red-300 border border-red-700 rounded-full text-xs font-mono">
          SVS Limb Salvage
        </span>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mt-6">
        <div className="space-y-4">
          <div>
            <label className="text-xs text-slate-300">Ankle-Brachial Index (ABI): {abi}</label>
            <input
              type="number"
              step="0.05"
              value={abi}
              onChange={(e) => setAbi(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>
        </div>

        <div className="bg-slate-950 p-5 rounded-lg border border-slate-800 flex flex-col justify-between">
          <div className="text-center p-4 bg-slate-900 rounded-lg border border-slate-800">
            <span className="text-xs text-slate-400">Ischemia Grade</span>
            <p className={abi < 0.5 ? 'text-2xl font-bold text-red-400 mt-1' : 'text-2xl font-bold text-emerald-400 mt-1'}>
              {abi < 0.5 ? 'SEVERE ISCHEMIA - REVASCULARIZATION INDICATED' : 'MILD / MODERATE'}
            </p>
          </div>

          <button className="w-full mt-4 py-2.5 bg-red-600 hover:bg-red-500 font-semibold rounded-lg text-white transition-colors">
            Schedule Revascularization Angiogram
          </button>
        </div>
      </div>
    </div>
  );
};
