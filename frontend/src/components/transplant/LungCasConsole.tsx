import React, { useState } from 'react';
import { Wind, Activity, CheckCircle2 } from 'lucide-react';

export const LungCasConsole: React.FC = () => {
  const [fvc, setFvc] = useState(42);
  const [o2Lpm, setO2Lpm] = useState(6);

  const lasScore = Math.min(100, Math.max(1, 30 + (100 - fvc) * 0.3 + o2Lpm * 3));

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Wind className="h-7 w-7 text-cyan-400" />
          <div>
            <h2 className="text-xl font-bold">Lung Composite Allocation Score (CAS / LAS)</h2>
            <p className="text-xs text-slate-400">Continuous Distribution Urgency & Post-Transplant Benefit</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-2 gap-4 my-6">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 space-y-3">
          <div>
            <span className="text-xs text-slate-400 block mb-1">FVC (% Predicted): {fvc}%</span>
            <input type="range" min="10" max="100" value={fvc} onChange={e => setFvc(Number(e.target.value))} className="w-full" />
          </div>
          <div>
            <span className="text-xs text-slate-400 block mb-1">Resting O2 Requirement: {o2Lpm} L/min</span>
            <input type="range" min="0" max="15" value={o2Lpm} onChange={e => setO2Lpm(Number(e.target.value))} className="w-full" />
          </div>
        </div>
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 flex flex-col justify-center items-center">
          <span className="text-xs text-slate-400">Calculated LAS Score</span>
          <span className="text-5xl font-extrabold font-mono text-cyan-400 my-2">{lasScore.toFixed(1)}</span>
          <span className="text-xs text-slate-400">Priority: {lasScore > 50 ? 'High Waitlist Urgency' : 'Standard'}</span>
        </div>
      </div>
    </div>
  );
};
