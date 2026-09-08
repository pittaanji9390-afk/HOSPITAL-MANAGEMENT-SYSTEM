import React, { useState } from 'react';
import { Gauge, Wind, ShieldAlert, CheckCircle2, Clock, Play, Pause } from 'lucide-react';

export const ChamberPressureStudio: React.FC = () => {
  const [currentAta, setCurrentAta] = useState(2.4);
  const [isOxygen, setIsOxygen] = useState(true);
  const [o2Minutes, setO2Minutes] = useState(24);

  const isAirBreakDue = isOxygen && o2Minutes >= 30;

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Gauge className="h-7 w-7 text-cyan-400" />
          <div>
            <h2 className="text-xl font-bold">Hyperbaric Chamber ATA Pressure & Oxygen Cycle Profile</h2>
            <p className="text-xs text-slate-400">Atmospheres Absolute (ATA) Depth & Mandatory 5-Minute Air Break Timer</p>
          </div>
        </div>
        <span className={'px-3 py-1 rounded-full text-xs font-mono font-bold ' + (
          isAirBreakDue ? 'bg-amber-950 text-amber-300 border border-amber-700 animate-pulse' : 'bg-emerald-950 text-emerald-300 border border-emerald-700'
        )}>
          {isAirBreakDue ? 'AIR BREAK MANDATED (30 MIN LIMIT)' : 'O2 CYCLE OPTIMAL'}
        </span>
      </div>

      <div className="grid grid-cols-3 gap-4 my-6">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 text-center">
          <span className="text-xs text-slate-400 block mb-1">Chamber Pressure</span>
          <span className="text-4xl font-extrabold font-mono text-cyan-400">{currentAta} ATA</span>
          <p className="text-xs text-slate-400 mt-1">{((currentAta - 1) * 33).toFixed(1)} Feet of Sea Water (fsw)</p>
        </div>

        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 text-center">
          <span className="text-xs text-slate-400 block mb-1">Breathing Gas</span>
          <span className={'text-3xl font-bold font-mono ' + (isOxygen ? 'text-emerald-400' : 'text-indigo-300')}>
            {isOxygen ? '100% O2' : '21% Medical Air'}
          </span>
          <button onClick={() => setIsOxygen(!isOxygen)} className="mt-2 px-3 py-1 bg-slate-800 hover:bg-slate-700 rounded text-xs">
            Switch to {isOxygen ? 'Air Break' : '100% O2'}
          </button>
        </div>

        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 text-center">
          <span className="text-xs text-slate-400 block mb-1">Current Gas Period</span>
          <span className="text-4xl font-extrabold font-mono text-white">{o2Minutes} min</span>
          <div className="mt-2 flex justify-center gap-2">
            <button onClick={() => setO2Minutes(Math.max(0, o2Minutes - 5))} className="px-2 py-0.5 bg-slate-800 rounded text-xs">-5m</button>
            <button onClick={() => setO2Minutes(o2Minutes + 5)} className="px-2 py-0.5 bg-slate-800 rounded text-xs">+5m</button>
          </div>
        </div>
      </div>
    </div>
  );
};
