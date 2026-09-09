import React, { useState } from 'react';
import { Activity, CheckCircle2 } from 'lucide-react';

export const LqtsSchwartzConsole: React.FC = () => {
  const [qtc, setQtc] = useState(490); // ms
  const [syncope, setSyncope] = useState(true);

  let score = 0;
  if (qtc >= 480) score += 3.0;
  else if (qtc >= 460) score += 2.0;
  if (syncope) score += 2.0;

  const isHighProb = score >= 3.5;

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Activity className="h-7 w-7 text-cyan-400" />
          <div>
            <h2 className="text-xl font-bold">Congenital Long QT Syndrome Schwartz Score</h2>
            <p className="text-xs text-slate-400">Cardiac Channelopathy (KCNQ1 / KCNH2 / SCN5A) Classifier</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-2 gap-4 my-6">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 space-y-3">
          <div>
            <span className="text-xs text-slate-400 block mb-1">QTc Interval: {qtc} ms</span>
            <input type="range" min="420" max="550" value={qtc} onChange={e => setQtc(Number(e.target.value))} className="w-full" />
          </div>
          <div>
            <label className="flex items-center gap-2 text-xs text-slate-300 cursor-pointer">
              <input type="checkbox" checked={syncope} onChange={e => setSyncope(e.target.checked)} className="rounded bg-slate-900 border-slate-700 text-indigo-600" />
              Syncope Triggered by Stress / Exertion [+2 pts]
            </label>
          </div>
        </div>

        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 flex flex-col justify-center text-xs font-mono">
          <div>Schwartz Score: <strong className={isHighProb ? 'text-rose-400 text-sm' : 'text-slate-200'}>{score.toFixed(1)} ({isHighProb ? 'High Probability' : 'Intermediate'})</strong></div>
          <div className="text-slate-400 font-sans mt-2">Therapy: Nadolol non-selective beta-blocker + avoid QT-prolonging drugs.</div>
        </div>
      </div>
    </div>
  );
};
