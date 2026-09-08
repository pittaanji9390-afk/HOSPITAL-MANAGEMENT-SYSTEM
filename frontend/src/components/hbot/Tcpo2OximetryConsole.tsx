import React, { useState } from 'react';
import { Activity, CheckCircle2, XCircle } from 'lucide-react';

export const Tcpo2OximetryConsole: React.FC = () => {
  const [baseline, setBaseline] = useState(24); // mmHg (<40 is hypoxia)
  const [inChamber, setInChamber] = useState(380); // mmHg (>200 predicts healing)

  const isHypoxic = baseline < 40;
  const willHeal = inChamber >= 200;

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Activity className="h-7 w-7 text-indigo-400" />
          <div>
            <h2 className="text-xl font-bold">Transcutaneous Oximetry (TcPO2 / TCOM) Predictor</h2>
            <p className="text-xs text-slate-400">Peri-Wound Microvascular Oxygen Tension & Angiogenesis Potential</p>
          </div>
        </div>
        <span className={'px-3 py-1 rounded-full text-xs font-mono font-bold ' + (
          willHeal ? 'bg-emerald-950 text-emerald-300 border border-emerald-700' : 'bg-rose-950 text-rose-300 border border-rose-700'
        )}>
          {willHeal ? 'PREDICTED HEALING WITH HBOT' : 'POOR RESPONSE (MACROVASCULAR)'}
        </span>
      </div>

      <div className="grid grid-cols-2 gap-4 my-6">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 space-y-3">
          <div>
            <span className="text-xs text-slate-400 block mb-1">Baseline Room Air TcPO2: {baseline} mmHg</span>
            <input type="range" min="5" max="80" value={baseline} onChange={e => setBaseline(Number(e.target.value))} className="w-full" />
          </div>
          <div>
            <span className="text-xs text-slate-400 block mb-1">In-Chamber (2.4 ATA) TcPO2: {inChamber} mmHg</span>
            <input type="range" min="10" max="600" value={inChamber} onChange={e => setInChamber(Number(e.target.value))} className="w-full" />
          </div>
        </div>

        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 flex flex-col justify-center text-xs font-mono">
          <div>Baseline Status: <strong className={isHypoxic ? 'text-amber-400' : 'text-emerald-400'}>{isHypoxic ? 'Severe Tissue Hypoxia (< 40 mmHg)' : 'Normal Tissue Oxygenation'}</strong></div>
          <div className="mt-2">In-Chamber Oxygen Challenge: <strong className={willHeal ? 'text-emerald-400 font-bold' : 'text-rose-400'}>{willHeal ? 'Excellent (> 200 mmHg - Angiogenesis Pass)' : 'Sub-therapeutic (< 200 mmHg)'}</strong></div>
        </div>
      </div>
    </div>
  );
};
