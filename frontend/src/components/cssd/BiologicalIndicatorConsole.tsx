import React, { useState } from 'react';
import { ShieldCheck, AlertCircle, CheckCircle2, Clock, Microscope } from 'lucide-react';

export const BiologicalIndicatorConsole: React.FC = () => {
  const [wells] = useState([
    { wellId: 1, lot: 'LOT-2026-GBS-882', sterilizer: 'Autoclave #1', cycle: 'CYC-01', timeRemaining: '00:00 (Done)', result: 'NEGATIVE (PASS)' },
    { wellId: 2, lot: 'LOT-2026-GBS-882', sterilizer: 'Autoclave #2', cycle: 'CYC-04', timeRemaining: '11:45', result: 'INCUBATING' },
    { wellId: 3, lot: 'LOT-2026-VHP-104', sterilizer: 'Sterrad NX', cycle: 'CYC-12', timeRemaining: '00:00 (Done)', result: 'NEGATIVE (PASS)' },
    { wellId: 4, lot: 'CONTROL-2026-GBS', sterilizer: 'Positive Control', cycle: 'CTRL', timeRemaining: '00:00 (Done)', result: 'POSITIVE (CONTROL VALID)' }
  ]);

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Microscope className="h-7 w-7 text-indigo-400" />
          <div>
            <h2 className="text-xl font-bold">Biological Indicator 24-Min Rapid Auto-Reader</h2>
            <p className="text-xs text-slate-400">G. stearothermophilus α-Glucosidase Fluorescence Spore Assay</p>
          </div>
        </div>
        <span className="px-3 py-1 bg-emerald-950 text-emerald-300 border border-emerald-700/60 rounded-full text-xs font-mono">
          3M Attest Auto-Reader 490
        </span>
      </div>

      <div className="grid grid-cols-2 gap-4 my-6">
        {wells.map(w => (
          <div key={w.wellId} className="p-4 bg-slate-950 rounded-xl border border-slate-800">
            <div className="flex justify-between items-start mb-2">
              <span className="text-xs font-mono font-bold px-2 py-0.5 bg-slate-900 text-slate-300 rounded">Well #{w.wellId}</span>
              <span className={'text-xs font-mono font-bold px-2.5 py-0.5 rounded ' + (
                w.result.includes('PASS') ? 'bg-emerald-950 text-emerald-300 border border-emerald-800' :
                w.result.includes('CONTROL') ? 'bg-indigo-950 text-indigo-300 border border-indigo-800' :
                'bg-amber-950 text-amber-300 border border-amber-800'
              )}>
                {w.result}
              </span>
            </div>
            <h4 className="text-sm font-bold text-white">{w.sterilizer} ({w.cycle})</h4>
            <p className="text-xs text-slate-400 font-mono mt-1">Lot: {w.lot}</p>
            <div className="mt-3 flex items-center gap-1.5 text-xs text-slate-300">
              <Clock className="h-3.5 w-3.5 text-amber-400" /> Time Remaining: <strong>{w.timeRemaining}</strong>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};
