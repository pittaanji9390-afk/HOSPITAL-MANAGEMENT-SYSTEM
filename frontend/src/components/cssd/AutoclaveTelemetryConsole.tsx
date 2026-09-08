import React, { useState } from 'react';
import { Gauge, Flame, CheckCircle, ShieldCheck, Activity } from 'lucide-react';

export const AutoclaveTelemetryConsole: React.FC = () => {
  const [chamberTemp] = useState(132.8);
  const [targetTemp] = useState(132.0);
  const [pressurePsi] = useState(29.4);
  const [phase] = useState('STERILIZATION EXPOSURE HOLD (4:00 Min)');

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Flame className="h-7 w-7 text-amber-400" />
          <div>
            <h2 className="text-xl font-bold">Steam Autoclave Dynamic Parameter Monitor</h2>
            <p className="text-xs text-slate-400">Pre-Vacuum 132°C Cycle Telemetry & Pressure Chamber Sensor Stream</p>
          </div>
        </div>
        <span className="px-3 py-1 bg-emerald-950 text-emerald-300 border border-emerald-700/60 rounded-full text-xs font-mono">
          AUTOCLAVE #1: RUNNING
        </span>
      </div>

      <div className="grid grid-cols-3 gap-5 my-6">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 text-center">
          <span className="text-xs text-slate-400 block mb-1">Chamber Temperature</span>
          <span className="text-3xl font-extrabold font-mono text-amber-400">{chamberTemp} °C</span>
          <p className="text-xs text-slate-400 mt-1">Set Point: {targetTemp} °C</p>
        </div>
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 text-center">
          <span className="text-xs text-slate-400 block mb-1">Chamber Pressure</span>
          <span className="text-3xl font-extrabold font-mono text-cyan-400">{pressurePsi} PSI</span>
          <p className="text-xs text-slate-400 mt-1">Range: 27.0 - 31.0 PSI</p>
        </div>
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 text-center">
          <span className="text-xs text-slate-400 block mb-1">Active Cycle Phase</span>
          <span className="text-sm font-bold font-mono text-emerald-400 block mt-2">{phase}</span>
        </div>
      </div>
    </div>
  );
};
