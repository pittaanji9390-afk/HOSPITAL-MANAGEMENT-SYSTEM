import React, { useState } from 'react';

export const OphthalmologyConsole: React.FC = () => {
  const [iopOd, setIopOd] = useState<number>(24);
  const [iopOs, setIopOs] = useState<number>(18);

  return (
    <div className="p-6 bg-slate-900 text-white rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-700">
        <div>
          <h2 className="text-2xl font-bold text-cyan-400">Ophthalmology & Retinal Diagnostics Studio</h2>
          <p className="text-sm text-slate-400">Goldmann Applanation Tonometry & Anti-VEGF Intravitreal Injection Tracker</p>
        </div>
        <span className="px-3 py-1 bg-cyan-950 text-cyan-300 border border-cyan-700 rounded-full text-xs font-mono">
          AAO Preferred Practice
        </span>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mt-6">
        <div className="space-y-4">
          <div>
            <label className="text-xs text-slate-300">Right Eye IOP (OD - mmHg): {iopOd}</label>
            <input
              type="number"
              value={iopOd}
              onChange={(e) => setIopOd(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>
          <div>
            <label className="text-xs text-slate-300">Left Eye IOP (OS - mmHg): {iopOs}</label>
            <input
              type="number"
              value={iopOs}
              onChange={(e) => setIopOs(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>
        </div>

        <div className="bg-slate-950 p-5 rounded-lg border border-slate-800 flex flex-col justify-between">
          <div className="text-center p-4 bg-slate-900 rounded-lg border border-slate-800">
            <span className="text-xs text-slate-400">Ocular Hypertension Status</span>
            <p className={iopOd > 21 || iopOs > 21 ? 'text-2xl font-bold text-amber-400 mt-1' : 'text-2xl font-bold text-emerald-400 mt-1'}>
              {iopOd > 21 || iopOs > 21 ? 'ELEVATED IOP (>21 mmHg)' : 'NORMAL PRESSURE'}
            </p>
          </div>

          <button className="w-full mt-4 py-2.5 bg-cyan-600 hover:bg-cyan-500 font-semibold rounded-lg text-white transition-colors">
            Record Exam Findings
          </button>
        </div>
      </div>
    </div>
  );
};
