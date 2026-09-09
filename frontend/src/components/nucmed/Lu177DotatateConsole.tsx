import React, { useState } from 'react';
import { Activity, CheckCircle2 } from 'lucide-react';

export const Lu177DotatateConsole: React.FC = () => {
  const [aminoRunning, setAminoRunning] = useState(true);

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Activity className="h-7 w-7 text-emerald-400" />
          <div>
            <h2 className="text-xl font-bold">177Lu-DOTATATE (Lutathera) PRRT Protocol</h2>
            <p className="text-xs text-slate-400">Somatostatin Receptor Radionuclide Therapy & Amino Acid Infusion Safety</p>
          </div>
        </div>
      </div>

      <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 my-6 text-xs font-mono space-y-3">
        <label className="flex items-center gap-2 text-slate-300 cursor-pointer">
          <input type="checkbox" checked={aminoRunning} onChange={e => setAminoRunning(e.target.checked)} className="rounded bg-slate-900 border-slate-700 text-indigo-600" />
          Amino Acid Renal Protector (Lysine/Arginine) Infusion Running &gt;= 30 Min
        </label>
        <div className={aminoRunning ? 'text-emerald-400 font-bold' : 'text-rose-400 font-bold'}>
          {aminoRunning ? 'PRRT RELEASE SAFE: Proceed with 7.4 GBq Lutathera infusion over 30 min' : 'SAFETY HOLD: Amino acids must run for 30 min before radionuclide'}
        </div>
      </div>
    </div>
  );
};
