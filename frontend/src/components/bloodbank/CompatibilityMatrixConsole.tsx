import React, { useState } from 'react';
import { ShieldCheck, CheckCircle2, XCircle, Droplets } from 'lucide-react';

export const CompatibilityMatrixConsole: React.FC = () => {
  const [recipient, setRecipient] = useState('A');
  const [donor, setDonor] = useState('O');
  const [component, setComponent] = useState('RBC');

  let compatible = false;
  if (component === 'RBC') {
    if (recipient === 'O') compatible = (donor === 'O');
    else if (recipient === 'A') compatible = (donor === 'A' || donor === 'O');
    else if (recipient === 'B') compatible = (donor === 'B' || donor === 'O');
    else if (recipient === 'AB') compatible = true;
  } else {
    // Plasma reverse
    if (recipient === 'AB') compatible = (donor === 'AB');
    else if (recipient === 'A') compatible = (donor === 'A' || donor === 'AB');
    else if (recipient === 'B') compatible = (donor === 'B' || donor === 'AB');
    else if (recipient === 'O') compatible = true;
  }

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Droplets className="h-7 w-7 text-rose-400" />
          <div>
            <h2 className="text-xl font-bold">ABO / Rh Component Compatibility Matrix</h2>
            <p className="text-xs text-slate-400">RBC Forward vs Plasma Reverse Compatibility Logic</p>
          </div>
        </div>
        <span className={'px-3 py-1 rounded-full text-xs font-mono font-bold ' + (
          compatible ? 'bg-emerald-950 text-emerald-300 border border-emerald-700' : 'bg-rose-950 text-rose-300 border border-rose-700'
        )}>
          {compatible ? 'COMPATIBLE' : 'INCOMPATIBLE'}
        </span>
      </div>

      <div className="grid grid-cols-3 gap-4 my-6">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800">
          <label className="text-xs text-slate-400 block mb-1">Recipient ABO</label>
          <select value={recipient} onChange={e => setRecipient(e.target.value)} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-slate-200">
            <option value="O">Type O</option>
            <option value="A">Type A</option>
            <option value="B">Type B</option>
            <option value="AB">Type AB</option>
          </select>
        </div>

        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800">
          <label className="text-xs text-slate-400 block mb-1">Donor ABO</label>
          <select value={donor} onChange={e => setDonor(e.target.value)} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-slate-200">
            <option value="O">Type O</option>
            <option value="A">Type A</option>
            <option value="B">Type B</option>
            <option value="AB">Type AB</option>
          </select>
        </div>

        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800">
          <label className="text-xs text-slate-400 block mb-1">Component Type</label>
          <select value={component} onChange={e => setComponent(e.target.value)} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-slate-200">
            <option value="RBC">Packed Red Blood Cells (pRBC)</option>
            <option value="PLASMA">Fresh Frozen Plasma (FFP)</option>
          </select>
        </div>
      </div>
    </div>
  );
};
