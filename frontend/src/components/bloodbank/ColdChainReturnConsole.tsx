import React, { useState } from 'react';
import { Clock, ShieldCheck, AlertOctagon } from 'lucide-react';

export const ColdChainReturnConsole: React.FC = () => {
  const [minutesElapsed, setMinutesElapsed] = useState(18);
  const [temp, setTemp] = useState(6.2);

  const isEligible = minutesElapsed <= 30 && temp <= 10.0;

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Clock className="h-7 w-7 text-cyan-400" />
          <div>
            <h2 className="text-xl font-bold">AABB 30-Minute Blood Return Rule Gate</h2>
            <p className="text-xs text-slate-400">Ambient Exposure Time & Surface Temperature Restock Verification</p>
          </div>
        </div>
        <span className={'px-3 py-1 rounded-full text-xs font-mono font-bold ' + (
          isEligible ? 'bg-emerald-950 text-emerald-300 border border-emerald-700' : 'bg-rose-950 text-rose-300 border border-rose-700'
        )}>
          {isEligible ? 'RESTOCK PERMITTED' : 'DISCARD MANDATED'}
        </span>
      </div>

      <div className="grid grid-cols-2 gap-4 my-6">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800">
          <span className="text-xs text-slate-400 block mb-1">Minutes Outside Blood Bank: {minutesElapsed} min</span>
          <input type="range" min="1" max="60" value={minutesElapsed} onChange={e => setMinutesElapsed(Number(e.target.value))} className="w-full" />
        </div>
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800">
          <span className="text-xs text-slate-400 block mb-1">Surface Temperature: {temp} °C</span>
          <input type="range" min="1" max="18" step="0.1" value={temp} onChange={e => setTemp(Number(e.target.value))} className="w-full" />
        </div>
      </div>
    </div>
  );
};
