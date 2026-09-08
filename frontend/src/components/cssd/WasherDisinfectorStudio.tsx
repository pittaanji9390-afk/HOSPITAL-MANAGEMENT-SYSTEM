import React, { useState } from 'react';
import { Waves, CheckCircle2, ShieldCheck, Thermometer } from 'lucide-react';

export const WasherDisinfectorStudio: React.FC = () => {
  const [washCycles] = useState([
    { id: 'WASH-01', unit: 'Miele PG8528 #1', enzyme: '4.0 mL/L', temp: '93.4 °C', hold: '300 sec', a0: '3,450 (Pass >= 600)', result: 'PASSED' },
    { id: 'WASH-02', unit: 'Miele PG8528 #2', enzyme: '4.2 mL/L', temp: '93.0 °C', hold: '300 sec', a0: '3,200 (Pass >= 600)', result: 'PASSED' }
  ]);

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Waves className="h-7 w-7 text-indigo-400" />
          <div>
            <h2 className="text-xl font-bold">Washer-Disinfector A0 Thermal Lethality Analyzer</h2>
            <p className="text-xs text-slate-400">ISO 15883 Quad-Enzyme Dosing & 93°C Thermal Disinfection Stage</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-2 gap-4 my-6">
        {washCycles.map(c => (
          <div key={c.id} className="p-4 bg-slate-950 rounded-xl border border-slate-800">
            <div className="flex justify-between items-center mb-2">
              <span className="text-xs font-bold font-mono px-2 py-0.5 bg-slate-900 text-slate-300 rounded">{c.id}</span>
              <span className="text-xs font-mono font-bold px-2 py-0.5 bg-emerald-950 text-emerald-300 border border-emerald-800 rounded">{c.result}</span>
            </div>
            <h3 className="text-sm font-bold text-white">{c.unit}</h3>
            <div className="grid grid-cols-2 gap-2 mt-3 text-xs font-mono">
              <div className="p-2 bg-slate-900 rounded border border-slate-800">Enzyme: {c.enzyme}</div>
              <div className="p-2 bg-slate-900 rounded border border-slate-800">Temp: {c.temp}</div>
              <div className="p-2 bg-slate-900 rounded border border-slate-800">Hold: {c.hold}</div>
              <div className="p-2 bg-slate-900 rounded border border-slate-800">A0 Lethality: {c.a0}</div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};
