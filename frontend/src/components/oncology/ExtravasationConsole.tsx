import React, { useState } from 'react';
import { ShieldAlert, AlertTriangle, CheckCircle2 } from 'lucide-react';

export const ExtravasationConsole: React.FC = () => {
  const [drug, setDrug] = useState('Doxorubicin');

  const antidotes: Record<string, { cls: string; thermal: string; antidote: string }> = {
    'Doxorubicin': { cls: 'DNA-Binding Anthracycline Vesicant', thermal: 'Dry Cold Pack (DO NOT USE HEAT)', antidote: 'Dexrazoxane (Totect) IV within 6 hrs (Day 1: 1000 mg/m², Day 2: 1000 mg/m², Day 3: 500 mg/m²)' },
    'Vincristine': { cls: 'Plant Alkaloid Vesicant', thermal: 'Dry Warm Heat Pack (DO NOT USE COLD)', antidote: 'Hyaluronidase 150 U/mL (1.0 - 1.7 mL subQ around site)' },
    'Paclitaxel': { cls: 'Taxane Vesicant / Irritant', thermal: 'Dry Cold Compress', antidote: 'Hyaluronidase subQ for large volume extravasations' }
  };

  const current = antidotes[drug] || antidotes['Doxorubicin'];

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <AlertTriangle className="h-7 w-7 text-rose-400" />
          <div>
            <h2 className="text-xl font-bold">Chemotherapy Extravasation Emergency Protocol</h2>
            <p className="text-xs text-slate-400">ONS / ESMO Vesicant Antidote & Thermal Compress Algorithm</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-2 gap-4 my-6">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800">
          <label className="text-xs text-slate-400 block mb-1">Extravasated Chemotherapeutic Agent</label>
          <select value={drug} onChange={e => setDrug(e.target.value)} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-slate-200">
            <option>Doxorubicin</option>
            <option>Vincristine</option>
            <option>Paclitaxel</option>
          </select>
          <p className="text-xs font-mono text-amber-400 mt-3">{current.cls}</p>
        </div>

        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 text-xs font-mono space-y-2">
          <div>Thermal Measure: <strong className="text-cyan-300">{current.thermal}</strong></div>
          <div className="text-slate-300">
            <strong>Antidote:</strong>
            <p className="text-emerald-400 mt-1">{current.antidote}</p>
          </div>
        </div>
      </div>
    </div>
  );
};
