import React, { useState } from 'react';
import { AlertOctagon, CheckCircle2 } from 'lucide-react';

export const CairoBishopTlsConsole: React.FC = () => {
  const [uricAcid, setUricAcid] = useState(8.8);
  const [potassium, setPotassium] = useState(6.2);
  const [phosphate, setPhosphate] = useState(5.1);
  const [calcium, setCalcium] = useState(6.8);

  let criteria = 0;
  if (uricAcid >= 8.0) criteria++;
  if (potassium >= 6.0) criteria++;
  if (phosphate >= 4.5) criteria++;
  if (calcium <= 7.0) criteria++;

  const isLtls = criteria >= 2;

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <AlertOctagon className="h-7 w-7 text-amber-400" />
          <div>
            <h2 className="text-xl font-bold">Cairo-Bishop Tumor Lysis Syndrome (TLS) Stager</h2>
            <p className="text-xs text-slate-400">Laboratory & Clinical TLS Diagnostic Criteria</p>
          </div>
        </div>
        <span className={'px-3 py-1 rounded-full text-xs font-mono font-bold ' + (
          isLtls ? 'bg-rose-950 text-rose-300 border border-rose-700' : 'bg-emerald-950 text-emerald-300 border border-emerald-700'
        )}>
          {isLtls ? 'LABORATORY TLS CONFIRMED (≥ 2 CRITERIA)' : 'NO TLS'}
        </span>
      </div>

      <div className="grid grid-cols-4 gap-3 my-6 text-center text-xs font-mono">
        <div className="p-3 bg-slate-950 rounded border border-slate-800">
          <span className="text-slate-400 block mb-1">Uric Acid (≥ 8.0)</span>
          <strong className={uricAcid >= 8.0 ? 'text-rose-400 text-sm' : 'text-slate-200 text-sm'}>{uricAcid} mg/dL</strong>
        </div>
        <div className="p-3 bg-slate-950 rounded border border-slate-800">
          <span className="text-slate-400 block mb-1">Potassium (≥ 6.0)</span>
          <strong className={potassium >= 6.0 ? 'text-rose-400 text-sm' : 'text-slate-200 text-sm'}>{potassium} mEq/L</strong>
        </div>
        <div className="p-3 bg-slate-950 rounded border border-slate-800">
          <span className="text-slate-400 block mb-1">Phosphate (≥ 4.5)</span>
          <strong className={phosphate >= 4.5 ? 'text-rose-400 text-sm' : 'text-slate-200 text-sm'}>{phosphate} mg/dL</strong>
        </div>
        <div className="p-3 bg-slate-950 rounded border border-slate-800">
          <span className="text-slate-400 block mb-1">Calcium (≤ 7.0)</span>
          <strong className={calcium <= 7.0 ? 'text-rose-400 text-sm' : 'text-slate-200 text-sm'}>{calcium} mg/dL</strong>
        </div>
      </div>
    </div>
  );
};
