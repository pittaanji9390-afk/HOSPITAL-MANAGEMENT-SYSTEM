import React, { useState } from 'react';
import { ShieldCheck, CheckCircle2 } from 'lucide-react';

export const MarxProtocolConsole: React.FC = () => {
  const [stage, setStage] = useState(1);

  const plans: Record<number, { pre: number; post: number; action: string }> = {
    1: { pre: 30, post: 0, action: 'Evaluate for spontaneous mucosal coverage after 30 sessions (2.4 ATA x 90 min).' },
    2: { pre: 30, post: 10, action: 'Transoral cortical debridement followed by 10 post-operative HBOT sessions.' },
    3: { pre: 30, post: 10, action: 'Segmental bone resection + microvascular free flap + 10 post-op sessions.' }
  };

  const current = plans[stage];

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <ShieldCheck className="h-7 w-7 text-indigo-400" />
          <div>
            <h2 className="text-xl font-bold">Marx Protocol Radiation Necrosis Stager</h2>
            <p className="text-xs text-slate-400">Osteoradionecrosis, Radiation Cystitis & Proctitis 30/10 Session Algorithm</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-2 gap-4 my-6">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 space-y-3">
          <label className="text-xs text-slate-400 block mb-1">Marx Osteoradionecrosis Stage</label>
          <select value={stage} onChange={e => setStage(Number(e.target.value))} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-slate-200">
            <option value="1">Marx Stage I (Superficial exposed bone)</option>
            <option value="2">Marx Stage II (Failed Stage I / Requires debridement)</option>
            <option value="3">Marx Stage III (Pathologic fracture / Orocutaneous fistula)</option>
          </select>
        </div>

        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 text-xs font-mono space-y-2">
          <div>Pre-Op Sessions: <strong className="text-emerald-400">{current.pre} dives</strong></div>
          <div>Post-Op Sessions: <strong className="text-indigo-300">{current.post} dives</strong></div>
          <p className="text-slate-300 font-sans mt-2">{current.action}</p>
        </div>
      </div>
    </div>
  );
};
