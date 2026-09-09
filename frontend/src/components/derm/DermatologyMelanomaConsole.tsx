import React, { useState } from 'react';

export const DermatologyMelanomaConsole: React.FC = () => {
  const [breslow, setBreslow] = useState<number>(1.4);
  const [ulcerated, setUlcerated] = useState<boolean>(false);

  return (
    <div className="p-6 bg-slate-900 text-white rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-700">
        <div>
          <h2 className="text-2xl font-bold text-rose-400">Dermato-Oncology & Mohs Surgery Studio</h2>
          <p className="text-sm text-slate-400">AJCC 8th Edition Melanoma Breslow Staging & Surgical Margin Planning</p>
        </div>
        <span className="px-3 py-1 bg-rose-950 text-rose-300 border border-rose-700 rounded-full text-xs font-mono">
          NCCN Melanoma 2025
        </span>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mt-6">
        <div className="space-y-4">
          <div>
            <label className="text-xs text-slate-300">Breslow Depth (mm): {breslow} mm</label>
            <input
              type="number"
              step="0.1"
              value={breslow}
              onChange={(e) => setBreslow(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>
        </div>

        <div className="bg-slate-950 p-5 rounded-lg border border-slate-800 flex flex-col justify-between">
          <div className="text-center p-4 bg-slate-900 rounded-lg border border-slate-800">
            <span className="text-xs text-slate-400">Sentinel Lymph Node Biopsy (SLNB)</span>
            <p className={breslow > 0.8 ? 'text-2xl font-bold text-rose-400 mt-1' : 'text-2xl font-bold text-emerald-400 mt-1'}>
              {breslow > 0.8 ? 'SLNB RECOMMENDED (>0.8mm)' : 'SLNB NOT ROUTINELY INDICATED'}
            </p>
          </div>

          <button className="w-full mt-4 py-2.5 bg-rose-600 hover:bg-rose-500 font-semibold rounded-lg text-white transition-colors">
            Generate Surgical Excision Plan
          </button>
        </div>
      </div>
    </div>
  );
};
