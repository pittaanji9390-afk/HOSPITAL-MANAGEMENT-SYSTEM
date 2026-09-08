import React, { useState } from 'react';
import { ShieldCheck, CheckCircle2, Clock } from 'lucide-react';

export const ComponentModificationConsole: React.FC = () => {
  const [radTagBlack, setRadTagBlack] = useState(true);

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <ShieldCheck className="h-7 w-7 text-indigo-400" />
          <div>
            <h2 className="text-xl font-bold">Blood Component Modification Station</h2>
            <p className="text-xs text-slate-400">25 Gy Gamma/X-Ray Irradiation & Saline Cell Washer Ledger</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-2 gap-4 my-6">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800">
          <h3 className="text-sm font-bold text-white mb-2">Unit: W0123 26 884411 (pRBC)</h3>
          <div className="space-y-1 text-xs font-mono text-slate-300">
            <div>Modification: <strong>Gamma Irradiation (2500 cGy)</strong></div>
            <div>Indication: <strong>TA-GvHD Prevention (Bone Marrow Transplant)</strong></div>
            <div>New Expiration: <strong>28 Days from Irradiation</strong></div>
          </div>
        </div>

        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 flex flex-col justify-between">
          <label className="flex items-center gap-2 text-xs text-slate-300 cursor-pointer">
            <input type="checkbox" checked={radTagBlack} onChange={e => setRadTagBlack(e.target.checked)} className="rounded bg-slate-900 border-slate-700 text-indigo-600" />
            Rad-Tag Sensitive Chemical Indicator Turned Solid Black (Pass &gt;= 25 Gy)
          </label>
          <div className="text-xs text-emerald-400 font-bold flex items-center gap-1 mt-2">
            <CheckCircle2 className="h-4 w-4" /> Ready for Clinical Dispense
          </div>
        </div>
      </div>
    </div>
  );
};
