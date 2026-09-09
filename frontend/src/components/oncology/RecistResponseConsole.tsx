import React, { useState } from 'react';
import { Activity, CheckCircle2, TrendingDown, TrendingUp, AlertOctagon } from 'lucide-react';

export const RecistResponseConsole: React.FC = () => {
  const [baselineSld, setBaselineSld] = useState(85); // mm
  const [currentSld, setCurrentSld] = useState(52); // mm
  const [newLesions, setNewLesions] = useState(false);

  const pctChange = ((currentSld - baselineSld) / baselineSld) * 100;
  
  let response = 'STABLE DISEASE (SD)';
  if (newLesions) response = 'PROGRESSIVE DISEASE (PD) [New Lesion]';
  else if (currentSld === 0) response = 'COMPLETE RESPONSE (CR)';
  else if (pctChange <= -30) response = 'PARTIAL RESPONSE (PR) [≥ 30% Tumor Shrinkage]';
  else if (pctChange >= 20) response = 'PROGRESSIVE DISEASE (PD) [≥ 20% Growth]';

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Activity className="h-7 w-7 text-indigo-400" />
          <div>
            <h2 className="text-xl font-bold">RECIST 1.1 Solid Tumor Response Tracker</h2>
            <p className="text-xs text-slate-400">Sum of Longest Diameters (SLD) Longitudinal Response Classification</p>
          </div>
        </div>
        <span className={'px-3 py-1 rounded-full text-xs font-mono font-bold ' + (
          response.includes('PR') || response.includes('CR') ? 'bg-emerald-950 text-emerald-300 border border-emerald-700' :
          response.includes('PD') ? 'bg-rose-950 text-rose-300 border border-rose-700' :
          'bg-indigo-950 text-indigo-300 border border-indigo-700'
        )}>
          {response.split('[')[0]}
        </span>
      </div>

      <div className="grid grid-cols-2 gap-4 my-6">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 space-y-3">
          <div>
            <span className="text-xs text-slate-400 block mb-1">Baseline Target Lesion SLD: {baselineSld} mm</span>
            <input type="range" min="10" max="200" value={baselineSld} onChange={e => setBaselineSld(Number(e.target.value))} className="w-full" />
          </div>
          <div>
            <span className="text-xs text-slate-400 block mb-1">Current Scan Target Lesion SLD: {currentSld} mm</span>
            <input type="range" min="0" max="200" value={currentSld} onChange={e => setCurrentSld(Number(e.target.value))} className="w-full" />
          </div>
          <div className="pt-2">
            <label className="flex items-center gap-2 text-xs text-slate-300 cursor-pointer">
              <input type="checkbox" checked={newLesions} onChange={e => setNewLesions(e.target.checked)} className="rounded bg-slate-900 border-slate-700 text-rose-600" />
              New Lesions Detected on CT / MRI
            </label>
          </div>
        </div>

        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 flex flex-col justify-center items-center text-center">
          <span className="text-xs text-slate-400">Tumor Burden Percentage Change</span>
          <span className={'text-4xl font-extrabold font-mono my-2 ' + (pctChange <= -30 ? 'text-emerald-400' : pctChange >= 20 ? 'text-rose-400' : 'text-indigo-300')}>
            {pctChange > 0 ? '+' + pctChange.toFixed(1) : pctChange.toFixed(1)}%
          </span>
          <p className="text-xs text-slate-300 font-sans mt-1">{response}</p>
        </div>
      </div>
    </div>
  );
};
