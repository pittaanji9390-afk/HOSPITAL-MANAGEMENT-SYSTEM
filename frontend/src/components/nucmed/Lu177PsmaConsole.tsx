import React, { useState } from 'react';
import { ShieldCheck, Radiation, CheckCircle2 } from 'lucide-react';

export const Lu177PsmaConsole: React.FC = () => {
  const [cycle, setCycle] = useState(3);
  const [kidneyDose, setKidneyDose] = useState(11.2); // Gy (< 23 Gy limit)

  const isSafe = kidneyDose < 23.0;

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Radiation className="h-7 w-7 text-indigo-400" />
          <div>
            <h2 className="text-xl font-bold">177Lu-PSMA-617 (Pluvicto) Theranostic Dosimetry</h2>
            <p className="text-xs text-slate-400">Targeted Beta-Emitter (7.4 GBq Q6W) & Renal Absorbed Dose Monitor</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-2 gap-4 my-6 text-xs font-mono">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 space-y-2">
          <div>Prescribed Activity: <strong className="text-emerald-400">7.4 GBq (200 mCi) IV</strong></div>
          <div>Cycle Number: <strong className="text-white">Cycle #{cycle} of 6</strong></div>
        </div>

        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 space-y-2">
          <div>Cumulative Kidney Dose: <strong className={isSafe ? 'text-cyan-300' : 'text-rose-400'}>{kidneyDose} Gy / 23.0 Gy Limit</strong></div>
          <div className="text-slate-400 font-sans">Administer with IV amino acid infusion (Lysine/Arginine) for renal protection.</div>
        </div>
      </div>
    </div>
  );
};
