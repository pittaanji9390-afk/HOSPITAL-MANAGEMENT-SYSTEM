import React, { useState } from 'react';
import { Eye, Volume2, CheckCircle2 } from 'lucide-react';

export const SensoryEmergencyConsole: React.FC = () => {
  const [condition, setCondition] = useState('SSNHL');

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          {condition === 'SSNHL' ? <Volume2 className="h-7 w-7 text-indigo-400" /> : <Eye className="h-7 w-7 text-rose-400" />}
          <div>
            <h2 className="text-xl font-bold">Sensory Emergency Hyperbaric Protocol</h2>
            <p className="text-xs text-slate-400">Sudden Sensorineural Hearing Loss & Central Retinal Artery Occlusion</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-2 gap-4 my-6">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 space-y-3">
          <select value={condition} onChange={e => setCondition(e.target.value)} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-slate-200">
            <option value="SSNHL">Sudden Sensorineural Hearing Loss (SSNHL)</option>
            <option value="CRAO">Central Retinal Artery Occlusion (CRAO)</option>
          </select>
        </div>

        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 text-xs font-mono space-y-1 text-slate-300">
          <div>Target Profile: <strong className="text-cyan-300">{condition === 'SSNHL' ? '2.4 ATA x 90m (20 dives)' : '2.8 ATA x 90m (10 dives)'}</strong></div>
          <div>Golden Window: <strong className="text-amber-400">{condition === 'SSNHL' ? '< 14 Days from onset' : '< 24 Hours (Emergent)'}</strong></div>
        </div>
      </div>
    </div>
  );
};
