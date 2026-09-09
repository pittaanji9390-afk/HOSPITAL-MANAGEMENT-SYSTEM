import React, { useState } from 'react';
import { Activity, Thermometer, Navigation, ShieldCheck } from 'lucide-react';

export const OrganPerfusionConsole: React.FC = () => {
  const [organs] = useState([
    { id: 'ORG-KIDNEY-4091', organ: 'Kidney (Left)', cit: '4h 12m', temp: '3.8 °C', flow: '110 mL/min', resistance: '0.26', status: 'IN FLIGHT (MEDEVAC)' },
    { id: 'ORG-HEART-1042', organ: 'Heart (TransMedics OCS)', cit: '2h 05m', temp: '34.0 °C (Warm)', flow: '850 mL/min', resistance: '0.18', status: 'ARRIVED OR SUITE' }
  ]);

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Activity className="h-7 w-7 text-cyan-400 animate-pulse" />
          <div>
            <h2 className="text-xl font-bold">Organ Perfusion & Cold Ischemia Tracker</h2>
            <p className="text-xs text-slate-400">Hypothermic Machine Perfusion (HMP) & Normothermic OCS Stream</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-2 gap-4 my-6">
        {organs.map(o => (
          <div key={o.id} className="p-4 bg-slate-950 rounded-xl border border-slate-800">
            <span className="text-xs font-mono text-slate-400">{o.id}</span>
            <h3 className="text-base font-bold text-white mt-1">{o.organ}</h3>
            <div className="grid grid-cols-2 gap-2 mt-3 text-xs font-mono">
              <div className="p-2 bg-slate-900 rounded border border-slate-800">CIT: <strong className="text-cyan-300">{o.cit}</strong></div>
              <div className="p-2 bg-slate-900 rounded border border-slate-800">Temp: <strong className="text-amber-300">{o.temp}</strong></div>
              <div className="p-2 bg-slate-900 rounded border border-slate-800">Flow: <strong className="text-emerald-300">{o.flow}</strong></div>
              <div className="p-2 bg-slate-900 rounded border border-slate-800">Resist: <strong className="text-white">{o.resistance}</strong></div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};
