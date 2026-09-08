import React, { useState } from 'react';
import { AlertOctagon, CheckCircle2, Clock, ShieldCheck } from 'lucide-react';

export const MtpCoolerConsole: React.FC = () => {
  const [prbc, setPrbc] = useState(6);
  const [ffp, setFfp] = useState(6);
  const [plt, setPlt] = useState(1); // 1 apheresis unit = 6 pack equiv

  const ratio = ffp > 0 ? (prbc / ffp).toFixed(1) : prbc.toString();
  const isRatio1to1 = prbc === ffp;

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <AlertOctagon className="h-7 w-7 text-rose-500 animate-pulse" />
          <div>
            <h2 className="text-xl font-bold">Massive Transfusion Protocol (MTP) 1:1:1 Dispatcher</h2>
            <p className="text-xs text-slate-400">Trauma Resuscitation Balanced Ratio Cooler Verification</p>
          </div>
        </div>
        <span className={'px-3 py-1 rounded-full text-xs font-mono font-bold ' + (
          isRatio1to1 ? 'bg-emerald-950 text-emerald-300 border border-emerald-700' : 'bg-amber-950 text-amber-300 border border-amber-700'
        )}>
          {isRatio1to1 ? 'BALANCED 1:1 RATIO' : 'UNBALANCED RATIO'}
        </span>
      </div>

      <div className="grid grid-cols-3 gap-4 my-6 text-center">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800">
          <span className="text-xs text-slate-400 block mb-1">Packed RBCs (pRBC)</span>
          <span className="text-4xl font-extrabold font-mono text-rose-400">{prbc} Units</span>
          <div className="mt-3 flex justify-center gap-2">
            <button onClick={() => setPrbc(Math.max(0, prbc - 1))} className="px-2 py-1 bg-slate-800 rounded text-xs">-</button>
            <button onClick={() => setPrbc(prbc + 1)} className="px-2 py-1 bg-slate-800 rounded text-xs">+</button>
          </div>
        </div>

        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800">
          <span className="text-xs text-slate-400 block mb-1">Fresh Frozen Plasma (FFP)</span>
          <span className="text-4xl font-extrabold font-mono text-amber-400">{ffp} Units</span>
          <div className="mt-3 flex justify-center gap-2">
            <button onClick={() => setFfp(Math.max(0, ffp - 1))} className="px-2 py-1 bg-slate-800 rounded text-xs">-</button>
            <button onClick={() => setFfp(ffp + 1)} className="px-2 py-1 bg-slate-800 rounded text-xs">+</button>
          </div>
        </div>

        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800">
          <span className="text-xs text-slate-400 block mb-1">Apheresis Platelets</span>
          <span className="text-4xl font-extrabold font-mono text-indigo-400">{plt} Unit</span>
          <div className="mt-3 flex justify-center gap-2">
            <button onClick={() => setPlt(Math.max(0, plt - 1))} className="px-2 py-1 bg-slate-800 rounded text-xs">-</button>
            <button onClick={() => setPlt(plt + 1)} className="px-2 py-1 bg-slate-800 rounded text-xs">+</button>
          </div>
        </div>
      </div>
    </div>
  );
};
