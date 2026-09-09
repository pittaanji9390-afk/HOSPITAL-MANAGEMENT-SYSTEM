import React, { useState } from 'react';

export const PphRapidResponseConsole: React.FC = () => {
  const [qblMl, setQblMl] = useState<number>(850);
  const [hr, setHr] = useState<number>(115);

  let stage = 'Stage 0 (Prophylaxis)';
  let color = 'text-emerald-400';
  if (qblMl > 1500) {
    stage = 'STAGE 3 (Massive Hemorrhage / MTP)';
    color = 'text-red-500 font-black animate-pulse';
  } else if (qblMl >= 1000) {
    stage = 'Stage 2 (Moderate Hemorrhage)';
    color = 'text-rose-400 font-bold';
  } else if (qblMl >= 500) {
    stage = 'Stage 1 (Mild Hemorrhage)';
    color = 'text-amber-400 font-semibold';
  }

  return (
    <div className="p-6 bg-slate-900 text-white rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-700">
        <div>
          <h2 className="text-2xl font-bold text-red-400">CMQCC Postpartum Hemorrhage (PPH) Rapid Response</h2>
          <p className="text-sm text-slate-400">Gravimetric Quantitative Blood Loss (QBL) & Uterotonic Protocol</p>
        </div>
        <span className="px-3 py-1 bg-red-950 text-red-300 border border-red-700 rounded-full text-xs font-mono">
          CMQCC Stage 0-3
        </span>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mt-6">
        <div className="space-y-4">
          <div>
            <label className="text-xs text-slate-300 font-semibold">Quantitative Blood Loss (QBL): {qblMl} mL</label>
            <input
              type="number"
              value={qblMl}
              onChange={(e) => setQblMl(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>

          <div>
            <label className="text-xs text-slate-300 font-semibold">Heart Rate: {hr} bpm</label>
            <input
              type="number"
              value={hr}
              onChange={(e) => setHr(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>
        </div>

        <div className="bg-slate-950 p-5 rounded-lg border border-slate-800 flex flex-col justify-between">
          <div className="text-center p-4 bg-slate-900 rounded-lg border border-slate-800">
            <span className="text-xs text-slate-400">PPH Protocol Level</span>
            <p className={`text-2xl mt-1 ${color}`}>{stage}</p>
          </div>

          <button className="w-full mt-4 py-2.5 bg-red-600 hover:bg-red-500 font-semibold rounded-lg text-white transition-colors">
            Activate Hemorrhage Protocol
          </button>
        </div>
      </div>
    </div>
  );
};
