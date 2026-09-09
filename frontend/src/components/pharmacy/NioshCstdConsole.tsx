import React, { useState } from 'react';
import { ShieldAlert, AlertTriangle, CheckCircle2, Lock } from 'lucide-react';

export const NioshCstdConsole: React.FC = () => {
  const [selectedDrug, setSelectedDrug] = useState('Doxorubicin');

  const drugs: Record<string, { category: string; cstd: boolean; ppe: string }> = {
    'Doxorubicin': { category: 'NIOSH Table 1 (Antineoplastic)', cstd: true, ppe: 'Double ASTM D6978 Chemo Gloves, Gown, N95 in Class II Type B2 BSC' },
    'Cyclophosphamide': { category: 'NIOSH Table 1 (Antineoplastic)', cstd: true, ppe: 'Double Chemo Gloves, Impermeable Gown, CSTD Syringe Lock' },
    'Ganciclovir': { category: 'NIOSH Table 2 (Non-antineoplastic hazardous)', cstd: true, ppe: 'Single Chemo Gloves, Dedicated BSC Hood' },
    'Finasteride': { category: 'NIOSH Table 3 (Reproductive Risk)', cstd: false, ppe: 'Single Universal Gloves, Do Not Crush/Split' }
  };

  const current = drugs[selectedDrug] || drugs['Doxorubicin'];

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <ShieldAlert className="h-7 w-7 text-amber-400" />
          <div>
            <h2 className="text-xl font-bold">NIOSH Hazardous Drug Containment & CSTD Safety Console</h2>
            <p className="text-xs text-slate-400">Closed System Transfer Device (PhaSeal / Equashield) Compliance Engine</p>
          </div>
        </div>
        <span className="px-3 py-1 bg-amber-950 text-amber-300 border border-amber-700/60 rounded-full text-xs font-mono">
          USP &lt;800&gt; COMPLIANT
        </span>
      </div>

      <div className="grid grid-cols-2 gap-5 my-6">
        <div className="bg-slate-950 p-4 rounded-xl border border-slate-800 space-y-3">
          <label className="text-xs text-slate-400 block mb-1">Select Hazardous Agent</label>
          <select value={selectedDrug} onChange={e => setSelectedDrug(e.target.value)} className="w-full bg-slate-900 border border-slate-700 rounded px-3 py-2 text-sm text-slate-200">
            {Object.keys(drugs).map(d => (
              <option key={d} value={d}>{d}</option>
            ))}
          </select>
          <div className="pt-2">
            <span className="text-xs text-slate-400 block mb-1">NIOSH Classification</span>
            <span className="px-2.5 py-1 bg-rose-950 text-rose-300 border border-rose-800 rounded text-xs font-mono font-bold block">
              {current.category}
            </span>
          </div>
        </div>

        <div className="bg-slate-950 p-4 rounded-xl border border-slate-800 space-y-3">
          <h3 className="text-sm font-semibold text-slate-300">Mandated Protective Equipment & Hardware</h3>
          <div className="p-3 bg-slate-900 rounded-lg border border-slate-800 text-xs space-y-2">
            <div className="flex items-center gap-2 text-emerald-300">
              <CheckCircle2 className="h-4 w-4" /> CSTD Requirement: {current.cstd ? 'MANDATORY CSTD ENGAGEMENT' : 'OPTIONAL'}
            </div>
            <div className="text-slate-300 leading-relaxed">
              <strong>PPE Protocol:</strong> {current.ppe}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};
