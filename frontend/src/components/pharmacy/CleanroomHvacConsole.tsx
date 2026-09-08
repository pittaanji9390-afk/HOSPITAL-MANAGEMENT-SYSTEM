import React, { useState } from 'react';
import { Gauge, Wind, AlertTriangle, CheckCircle, ShieldAlert, Thermometer, Droplets } from 'lucide-react';

export const CleanroomHvacConsole: React.FC = () => {
  const [zones] = useState([
    {
      id: 'ZONE-STERILE-BUF',
      name: 'ISO 7 Non-Hazardous Buffer Room',
      iso: 'ISO Class 7',
      pressure: '+0.038 in w.g.',
      pressureStatus: 'OPTIMAL',
      particles: '14,200 / m³ (Limit: 352,000)',
      temp: '19.2 °C',
      rh: '44.5 %',
      ach: '34.5 ACH'
    },
    {
      id: 'ZONE-HAZARD-BUF',
      name: 'ISO 7 Hazardous Negative Buffer Room (Chemo)',
      iso: 'ISO Class 7',
      pressure: '-0.024 in w.g.',
      pressureStatus: 'OPTIMAL',
      particles: '18,500 / m³ (Limit: 352,000)',
      temp: '18.8 °C',
      rh: '41.0 %',
      ach: '32.1 ACH'
    },
    {
      id: 'ZONE-BSC-HOOD',
      name: 'ISO 5 Biological Safety Cabinet #1',
      iso: 'ISO Class 5',
      pressure: '-0.042 in w.g.',
      pressureStatus: 'OPTIMAL',
      particles: '48 / m³ (Limit: 3,520)',
      temp: '18.0 °C',
      rh: '39.0 %',
      ach: '78.0 ACH'
    },
    {
      id: 'ZONE-ANTE-ROOM',
      name: 'ISO 8 Ante-Room & Gowning Air-Lock',
      iso: 'ISO Class 8',
      pressure: '+0.016 in w.g.',
      pressureStatus: 'OPTIMAL',
      particles: '112,000 / m³ (Limit: 3,520,000)',
      temp: '20.1 °C',
      rh: '48.0 %',
      ach: '24.0 ACH'
    }
  ]);

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Wind className="h-7 w-7 text-cyan-400 animate-spin" />
          <div>
            <h2 className="text-xl font-bold">USP &lt;797&gt; & &lt;800&gt; Cleanroom Environmental Monitor</h2>
            <p className="text-xs text-slate-400">Differential Pressure Transducers, Particle Counters & Air Changes/Hour (ACH)</p>
          </div>
        </div>
        <div className="flex items-center gap-2">
          <span className="flex items-center gap-1 text-xs text-emerald-400 bg-emerald-950/60 border border-emerald-700/60 px-3 py-1 rounded-full font-medium">
            <CheckCircle className="h-3.5 w-3.5" /> All 4 Zones In Compliance
          </span>
        </div>
      </div>

      <div className="grid grid-cols-2 gap-4 my-6">
        {zones.map(z => (
          <div key={z.id} className="p-4 bg-slate-950 rounded-xl border border-slate-800 hover:border-slate-700 transition">
            <div className="flex justify-between items-start mb-3">
              <div>
                <span className="text-xs font-mono px-2 py-0.5 bg-indigo-950 text-indigo-300 border border-indigo-800 rounded font-semibold">
                  {z.iso}
                </span>
                <h3 className="text-base font-bold text-white mt-1.5">{z.name}</h3>
              </div>
              <span className="px-2.5 py-1 bg-emerald-950 text-emerald-300 border border-emerald-800 rounded text-xs font-mono font-bold">
                {z.pressureStatus}
              </span>
            </div>

            <div className="grid grid-cols-2 gap-3 mt-4 text-xs font-mono">
              <div className="p-2.5 bg-slate-900 rounded border border-slate-800">
                <span className="text-slate-400 block mb-1 flex items-center gap-1"><Gauge className="h-3.5 w-3.5 text-cyan-400" /> Diff Pressure</span>
                <strong className="text-sm text-cyan-300">{z.pressure}</strong>
              </div>
              <div className="p-2.5 bg-slate-900 rounded border border-slate-800">
                <span className="text-slate-400 block mb-1 flex items-center gap-1"><Wind className="h-3.5 w-3.5 text-indigo-400" /> Particle Count 0.5µm</span>
                <strong className="text-sm text-indigo-300">{z.particles}</strong>
              </div>
              <div className="p-2.5 bg-slate-900 rounded border border-slate-800">
                <span className="text-slate-400 block mb-1 flex items-center gap-1"><Thermometer className="h-3.5 w-3.5 text-amber-400" /> Temperature</span>
                <strong className="text-sm text-amber-300">{z.temp}</strong>
              </div>
              <div className="p-2.5 bg-slate-900 rounded border border-slate-800">
                <span className="text-slate-400 block mb-1 flex items-center gap-1"><Droplets className="h-3.5 w-3.5 text-blue-400" /> Humidity / ACH</span>
                <strong className="text-sm text-blue-300">{z.rh} ({z.ach})</strong>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};
