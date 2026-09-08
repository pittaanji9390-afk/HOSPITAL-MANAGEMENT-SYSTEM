import React, { useState } from 'react';
import { ShieldAlert, AlertTriangle, CheckCircle2 } from 'lucide-react';

export const HemovigilanceStudio: React.FC = () => {
  const [acuteDyspnea, setAcuteDyspnea] = useState(true);
  const [elevatedBnp, setElevatedBnp] = useState(true);
  const [fever, setFever] = useState(false);
  const [pinkPlasma, setPinkPlasma] = useState(false);

  let diagnosis = 'ALLERGIC / URTICARIAL';
  if (pinkPlasma) diagnosis = 'ACUTE HEMOLYTIC TRANSFUSION REACTION (AHTR)';
  else if (acuteDyspnea && elevatedBnp) diagnosis = 'TRANSFUSION-ASSOCIATED CIRCULATORY OVERLOAD (TACO)';
  else if (acuteDyspnea && !elevatedBnp) diagnosis = 'TRANSFUSION-RELATED ACUTE LUNG INJURY (TRALI)';
  else if (fever) diagnosis = 'FEBRILE NON-HEMOLYTIC REACTION (FNHTR)';

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <ShieldAlert className="h-7 w-7 text-amber-400" />
          <div>
            <h2 className="text-xl font-bold">Hemovigilance Reaction Differential Classifier</h2>
            <p className="text-xs text-slate-400">CDC / NHSN Adverse Transfusion Investigation Workup</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-2 gap-4 my-6 text-xs">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 space-y-2">
          <label className="flex items-center gap-2 text-slate-300 cursor-pointer">
            <input type="checkbox" checked={acuteDyspnea} onChange={e => setAcuteDyspnea(e.target.checked)} className="rounded bg-slate-900 border-slate-700 text-indigo-600" />
            Acute Respiratory Distress / Hypoxemia
          </label>
          <label className="flex items-center gap-2 text-slate-300 cursor-pointer">
            <input type="checkbox" checked={elevatedBnp} onChange={e => setElevatedBnp(e.target.checked)} className="rounded bg-slate-900 border-slate-700 text-indigo-600" />
            Elevated BNP / JVP / Response to Lasix Diuresis
          </label>
          <label className="flex items-center gap-2 text-slate-300 cursor-pointer">
            <input type="checkbox" checked={fever} onChange={e => setFever(e.target.checked)} className="rounded bg-slate-900 border-slate-700 text-indigo-600" />
            Fever (&gt;= 1°C rise) & Rigors
          </label>
          <label className="flex items-center gap-2 text-slate-300 cursor-pointer">
            <input type="checkbox" checked={pinkPlasma} onChange={e => setPinkPlasma(e.target.checked)} className="rounded bg-slate-900 border-slate-700 text-rose-600" />
            Hemoglobinuria / Pink Post-Transfusion Plasma (Intravascular Hemolysis)
          </label>
        </div>

        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 flex flex-col justify-center items-center text-center">
          <span className="text-xs text-slate-400">Probable Adverse Reaction</span>
          <span className="text-base font-bold font-mono text-rose-400 my-2">{diagnosis}</span>
          <span className="text-xs text-slate-400">Halt infusion immediately & dispatch workup kit.</span>
        </div>
      </div>
    </div>
  );
};
