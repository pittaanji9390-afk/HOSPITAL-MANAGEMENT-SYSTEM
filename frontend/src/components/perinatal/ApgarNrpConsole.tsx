import React, { useState } from 'react';

export const ApgarNrpConsole: React.FC = () => {
  const [hr, setHr] = useState<number>(2); // 0, 1, 2
  const [resp, setResp] = useState<number>(2);
  const [tone, setTone] = useState<number>(2);
  const [reflex, setReflex] = useState<number>(2);
  const [color, setColor] = useState<number>(1);

  const totalApgar = hr + resp + tone + reflex + color;

  return (
    <div className="p-6 bg-slate-900 text-white rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-700">
        <div>
          <h2 className="text-2xl font-bold text-amber-400">Neonatal APGAR & NRP Resuscitation Studio</h2>
          <p className="text-sm text-slate-400">1, 5, 10 Minute APGAR Scoring & NRP 8th Edition Intervention Steps</p>
        </div>
        <span className="px-3 py-1 bg-amber-950 text-amber-300 border border-amber-700 rounded-full text-xs font-mono">
          NRP 8th Ed
        </span>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mt-6">
        <div className="space-y-4">
          <div className="grid grid-cols-2 gap-3">
            <div>
              <label className="text-xs text-slate-300">Heart Rate (0-2)</label>
              <input
                type="number"
                min="0"
                max="2"
                value={hr}
                onChange={(e) => setHr(Number(e.target.value))}
                className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
              />
            </div>
            <div>
              <label className="text-xs text-slate-300">Respiratory Effort (0-2)</label>
              <input
                type="number"
                min="0"
                max="2"
                value={resp}
                onChange={(e) => setResp(Number(e.target.value))}
                className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
              />
            </div>
          </div>
        </div>

        <div className="bg-slate-950 p-5 rounded-lg border border-slate-800 flex flex-col justify-between">
          <div className="text-center p-4 bg-slate-900 rounded-lg border border-slate-800">
            <span className="text-xs text-slate-400">Total APGAR Score</span>
            <p className={totalApgar >= 7 ? 'text-4xl font-black mt-1 text-emerald-400' : 'text-4xl font-black mt-1 text-rose-400'}>
              {totalApgar} / 10
            </p>
          </div>

          <button className="w-full mt-4 py-2.5 bg-amber-600 hover:bg-amber-500 font-semibold rounded-lg text-slate-950 transition-colors">
            Transmit APGAR Document
          </button>
        </div>
      </div>
    </div>
  );
};
