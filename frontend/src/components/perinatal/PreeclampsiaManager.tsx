import React, { useState } from 'react';

export const PreeclampsiaManager: React.FC = () => {
  const [sbp, setSbp] = useState<number>(165);
  const [dbp, setDbp] = useState<number>(105);

  const isSevere = sbp >= 160 || dbp >= 110;

  return (
    <div className="p-6 bg-slate-900 text-white rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-700">
        <div>
          <h2 className="text-2xl font-bold text-violet-400">Preeclampsia with Severe Features Manager</h2>
          <p className="text-sm text-slate-400">MgSO4 Seizure Prophylaxis & Antihypertensive Crisis Algorithm</p>
        </div>
        <span className="px-3 py-1 bg-violet-950 text-violet-300 border border-violet-700 rounded-full text-xs font-mono">
          ACOG Preeclampsia
        </span>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mt-6">
        <div className="space-y-4">
          <div className="grid grid-cols-2 gap-3">
            <div>
              <label className="text-xs text-slate-300">Systolic BP (mmHg)</label>
              <input
                type="number"
                value={sbp}
                onChange={(e) => setSbp(Number(e.target.value))}
                className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
              />
            </div>
            <div>
              <label className="text-xs text-slate-300">Diastolic BP (mmHg)</label>
              <input
                type="number"
                value={dbp}
                onChange={(e) => setDbp(Number(e.target.value))}
                className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
              />
            </div>
          </div>
        </div>

        <div className="bg-slate-950 p-5 rounded-lg border border-slate-800 flex flex-col justify-between">
          <div className={isSevere ? 'p-4 rounded-lg border bg-violet-950/40 border-violet-700' : 'p-4 rounded-lg border bg-slate-900 border-slate-800'}>
            <span className="text-xs text-slate-400">Hypertensive Crisis Status</span>
            <p className={isSevere ? 'text-xl font-bold mt-1 text-violet-300' : 'text-xl font-bold mt-1 text-emerald-400'}>
              {isSevere ? 'SEVERE HYPERTENSION - IV LABETALOL / HYDRALAZINE STAT' : 'NON-SEVERE RANGE'}
            </p>
          </div>

          <button className="w-full mt-4 py-2.5 bg-violet-600 hover:bg-violet-500 font-semibold rounded-lg text-white transition-colors">
            Confirm MgSO4 Infusion Orders
          </button>
        </div>
      </div>
    </div>
  );
};
