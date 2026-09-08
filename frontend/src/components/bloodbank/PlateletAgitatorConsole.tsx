import React, { useState } from 'react';
import { Activity, Thermometer, CheckCircle2 } from 'lucide-react';

export const PlateletAgitatorConsole: React.FC = () => {
  const [temp] = useState(22.4);
  const [cycles] = useState(62);

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Activity className="h-7 w-7 text-indigo-400 animate-pulse" />
          <div>
            <h2 className="text-xl font-bold">Platelet Incubator & Agitator Telemetry</h2>
            <p className="text-xs text-slate-400">Helmer i.Series Continuous Agitation (20°C - 24°C Standard)</p>
          </div>
        </div>
        <span className="px-3 py-1 bg-emerald-950 text-emerald-300 border border-emerald-700/60 rounded-full text-xs font-mono">
          MOTION ACTIVE (62 CPM)
        </span>
      </div>

      <div className="grid grid-cols-2 gap-4 my-6">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 text-center">
          <span className="text-xs text-slate-400 block mb-1">Incubator Temperature</span>
          <span className="text-3xl font-extrabold font-mono text-emerald-400">{temp} °C</span>
          <p className="text-xs text-slate-400 mt-1">Acceptable Range: 20.0 - 24.0 °C</p>
        </div>
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 text-center">
          <span className="text-xs text-slate-400 block mb-1">Agitation Speed</span>
          <span className="text-3xl font-extrabold font-mono text-indigo-400">{cycles} CPM</span>
          <p className="text-xs text-slate-400 mt-1">Continuous Horizontal Motion</p>
        </div>
      </div>
    </div>
  );
};
