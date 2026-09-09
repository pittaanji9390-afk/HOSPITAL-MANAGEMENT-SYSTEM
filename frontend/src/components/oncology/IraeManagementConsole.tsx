import React, { useState } from 'react';
import { ShieldAlert, AlertTriangle, CheckCircle2 } from 'lucide-react';

export const IraeManagementConsole: React.FC = () => {
  const [organ, setOrgan] = useState('Colitis / Diarrhea');
  const [grade, setGrade] = useState(2);

  const hold = grade >= 2;
  const permanentStop = grade >= 3;
  const steroids = grade === 1 ? 'Symptomatic loperamide / observation' : grade === 2 ? 'Prednisone 1 mg/kg/day PO taper' : 'High-Dose Methylprednisolone 2 mg/kg/day IV + Infliximab 5mg/kg if refractory';

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <ShieldAlert className="h-7 w-7 text-amber-400" />
          <div>
            <h2 className="text-xl font-bold">Immune-Related Adverse Events (irAE) Stager</h2>
            <p className="text-xs text-slate-400">CTCAE v5.0 Checkpoint Inhibitor (PD-1 / CTLA-4) Toxicity Algorithm</p>
          </div>
        </div>
        <span className={'px-3 py-1 rounded-full text-xs font-mono font-bold ' + (
          grade >= 3 ? 'bg-rose-950 text-rose-300 border border-rose-700' : 'bg-amber-950 text-amber-300 border border-amber-700'
        )}>
          CTCAE GRADE {grade}
        </span>
      </div>

      <div className="grid grid-cols-2 gap-4 my-6">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 space-y-3">
          <div>
            <label className="text-xs text-slate-400 block mb-1">Target Organ Toxicity</label>
            <select value={organ} onChange={e => setOrgan(e.target.value)} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-slate-200">
              <option>Colitis / Diarrhea</option>
              <option>Pneumonitis</option>
              <option>Hepatitis (AST/ALT elevation)</option>
              <option>Hypophysitis / Adrenal Insufficiency</option>
              <option>Myocarditis</option>
            </select>
          </div>
          <div>
            <span className="text-xs text-slate-400 block mb-1">Toxicity Severity Grade: Grade {grade}</span>
            <input type="range" min="1" max="4" value={grade} onChange={e => setGrade(Number(e.target.value))} className="w-full" />
          </div>
        </div>

        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 flex flex-col justify-between text-xs font-mono">
          <div className="space-y-2">
            <div>Checkpoint Drug Action: <strong className={permanentStop ? 'text-rose-400 font-bold' : hold ? 'text-amber-400' : 'text-emerald-400'}>
              {permanentStop ? 'PERMANENTLY DISCONTINUE' : hold ? 'HOLD DOSING' : 'CONTINUE WITH MONITORING'}
            </strong></div>
            <div className="text-slate-300 pt-2 border-t border-slate-800">
              <strong>Mandated Steroid Protocol:</strong>
              <p className="text-slate-400 font-sans mt-1">{steroids}</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};
