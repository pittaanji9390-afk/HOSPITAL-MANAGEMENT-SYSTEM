import React, { useState } from 'react';
import { Radiation, CheckCircle2 } from 'lucide-react';

export const Radium223Console: React.FC = () => {
  const [weightKg, setWeightKg] = useState(78);
  const doseKbq = weightKg * 55; // 55 kBq/kg

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Radiation className="h-7 w-7 text-amber-400" />
          <div>
            <h2 className="text-xl font-bold">Radium-223 (Xofigo) Alpha-Emitter Dosimetry</h2>
            <p className="text-xs text-slate-400">Targeted Bone Metastases Alpha-Particle Therapy (55 kBq/kg Q4W x 6)</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-2 gap-4 my-6">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800">
          <span className="text-xs text-slate-400 block mb-1">Patient Weight: {weightKg} kg</span>
          <input type="range" min="45" max="130" value={weightKg} onChange={e => setWeightKg(Number(e.target.value))} className="w-full" />
        </div>

        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 flex flex-col justify-center text-xs font-mono">
          <div>Calculated Dose: <strong className="text-2xl text-emerald-400 block mt-1">{doseKbq.toLocaleString()} kBq ({ (doseKbq / 37).toFixed(1) } µCi)</strong></div>
        </div>
      </div>
    </div>
  );
};
