import React, { useState } from 'react';
import { Activity, CheckCircle2 } from 'lucide-react';

export const FhDutchLipidConsole: React.FC = () => {
  const [ldl, setLdl] = useState(260); // mg/dL
  const [xanthoma, setXanthoma] = useState(true);

  let score = 0;
  if (xanthoma) score += 6;
  if (ldl >= 330) score += 8;
  else if (ldl >= 250) score += 5;
  else if (ldl >= 190) score += 3;

  const isDefinite = score > 8;

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Activity className="h-7 w-7 text-indigo-400" />
          <div>
            <h2 className="text-xl font-bold">Familial Hypercholesterolemia DLCN Scorer</h2>
            <p className="text-xs text-slate-400">Dutch Lipid Clinic Network Score & LDLR / PCSK9 Cascade Testing</p>
          </div>
        </div>
        <span className={'px-3 py-1 rounded-full text-xs font-mono font-bold ' + (
          isDefinite ? 'bg-rose-950 text-rose-300 border border-rose-700' : 'bg-amber-950 text-amber-300 border border-amber-700'
        )}>
          DLCN SCORE: {score} ({isDefinite ? 'DEFINITE FH' : 'PROBABLE FH'})
        </span>
      </div>

      <div className="grid grid-cols-2 gap-4 my-6">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 space-y-3">
          <div>
            <span className="text-xs text-slate-400 block mb-1">Untreated LDL-C: {ldl} mg/dL</span>
            <input type="range" min="130" max="400" value={ldl} onChange={e => setLdl(Number(e.target.value))} className="w-full" />
          </div>
          <div>
            <label className="flex items-center gap-2 text-xs text-slate-300 cursor-pointer">
              <input type="checkbox" checked={xanthoma} onChange={e => setXanthoma(e.target.checked)} className="rounded bg-slate-900 border-slate-700 text-indigo-600" />
              Tendon Xanthomas Present [+6 pts]
            </label>
          </div>
        </div>

        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 flex flex-col justify-center text-xs font-mono">
          <div>Regimen: <strong className="text-emerald-400">High-Intensity Statin + Ezetimibe + PCSK9 Inhibitor</strong></div>
          <div className="text-slate-400 font-sans mt-2">Cascade family screening strongly mandated for first-degree relatives.</div>
        </div>
      </div>
    </div>
  );
};
