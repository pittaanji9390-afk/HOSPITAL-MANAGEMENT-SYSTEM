import React, { useState } from 'react';
import { ShieldCheck, CheckCircle2 } from 'lucide-react';

export const CinvAntiemeticConsole: React.FC = () => {
  const [emetogenicity, setEmetogenicity] = useState('High Emetic Risk (HEC > 90% - Cisplatin, AC)');

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <ShieldCheck className="h-7 w-7 text-indigo-400" />
          <div>
            <h2 className="text-xl font-bold">NCCN / ASCO CINV 4-Drug Antiemetic Protocol</h2>
            <p className="text-xs text-slate-400">NK1 RA + 5-HT3 RA + Dexamethasone + Olanzapine Quad Therapy</p>
          </div>
        </div>
      </div>

      <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 my-6 space-y-3">
        <label className="text-xs text-slate-400 block mb-1">Chemotherapy Emetogenic Risk Category</label>
        <select value={emetogenicity} onChange={e => setEmetogenicity(e.target.value)} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-slate-200">
          <option value="HEC">High Emetic Risk (HEC &gt; 90% - Cisplatin, AC)</option>
          <option value="MEC">Moderate Emetic Risk (MEC 30-90% - Carboplatin, Oxaliplatin)</option>
          <option value="LOW">Low Emetic Risk (10-30% - Paclitaxel, Docetaxel)</option>
        </select>

        <div className="mt-4 p-3 bg-slate-900 rounded border border-slate-800 text-xs font-mono space-y-1 text-slate-300">
          <div><strong>Day 1 (Acute):</strong> Fosaprepitant 150mg IV + Palonosetron 0.25mg IV + Dexamethasone 12mg + Olanzapine 10mg PO</div>
          <div><strong>Days 2-4 (Delayed):</strong> Dexamethasone 8mg daily + Olanzapine 10mg PO QHS</div>
        </div>
      </div>
    </div>
  );
};
