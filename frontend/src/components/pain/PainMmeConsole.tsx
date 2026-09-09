import React, { useState } from 'react';

export const PainMmeConsole: React.FC = () => {
  const [oxy, setOxy] = useState<number>(30);
  const [benzo, setBenzo] = useState<boolean>(false);

  const mme = oxy * 1.5;

  return (
    <div className="p-6 bg-slate-900 text-white rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-700">
        <div>
          <h2 className="text-2xl font-bold text-amber-400">Interventional Pain & MME Opioid Safety Studio</h2>
          <p className="text-sm text-slate-400">CDC Morphine Milligram Equivalent (MME) & Co-Prescribed Benzodiazepine Guard</p>
        </div>
        <span className="px-3 py-1 bg-amber-950 text-amber-300 border border-amber-700 rounded-full text-xs font-mono">
          CDC Opioid 2025
        </span>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mt-6">
        <div className="space-y-4">
          <div>
            <label className="text-xs text-slate-300">Daily Oxycodone (mg): {oxy} mg</label>
            <input
              type="number"
              value={oxy}
              onChange={(e) => setOxy(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>
        </div>

        <div className="bg-slate-950 p-5 rounded-lg border border-slate-800 flex flex-col justify-between">
          <div className="text-center p-4 bg-slate-900 rounded-lg border border-slate-800">
            <span className="text-xs text-slate-400">Total Daily MME</span>
            <p className="text-3xl font-black text-amber-300 mt-1">{mme.toFixed(0)} MME/day</p>
          </div>

          <button className="w-full mt-4 py-2.5 bg-amber-600 hover:bg-amber-500 font-semibold rounded-lg text-slate-950 transition-colors">
            Authorize Pain Prescription
          </button>
        </div>
      </div>
    </div>
  );
};
