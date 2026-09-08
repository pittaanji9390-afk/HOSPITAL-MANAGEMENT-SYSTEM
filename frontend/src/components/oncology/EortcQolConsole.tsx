import React, { useState } from 'react';
import { Heart, Activity } from 'lucide-react';

export const EortcQolConsole: React.FC = () => {
  const [globalHealth, setGlobalHealth] = useState(72);
  const [physical, setPhysical] = useState(85);
  const [fatigue, setFatigue] = useState(33);

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Heart className="h-7 w-7 text-rose-400" />
          <div>
            <h2 className="text-xl font-bold">EORTC QLQ-C30 Quality of Life Multi-Scale Engine</h2>
            <p className="text-xs text-slate-400">Functional & Symptom Scale Standardized Scores (0-100)</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-3 gap-4 my-6 text-center font-mono">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800">
          <span className="text-xs text-slate-400 block mb-1">Global Health Status</span>
          <span className="text-3xl font-extrabold text-emerald-400">{globalHealth} / 100</span>
        </div>
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800">
          <span className="text-xs text-slate-400 block mb-1">Physical Functioning</span>
          <span className="text-3xl font-extrabold text-indigo-400">{physical} / 100</span>
        </div>
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800">
          <span className="text-xs text-slate-400 block mb-1">Fatigue Symptom Score</span>
          <span className="text-3xl font-extrabold text-amber-400">{fatigue} / 100</span>
        </div>
      </div>
    </div>
  );
};
