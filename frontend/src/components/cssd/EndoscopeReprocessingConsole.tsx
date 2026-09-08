import React, { useState } from 'react';
import { ShieldCheck, Wind, CheckCircle2, Clock, AlertTriangle } from 'lucide-react';

export const EndoscopeReprocessingConsole: React.FC = () => {
  const [scopes] = useState([
    { sn: 'SCOPE-OLY-CF-190L-8821', model: 'CF-HQ190L Colonoscope', hangRemaining: '144 hrs', status: 'VALID FOR USE', slot: 'Cabinet #1 (Slot 3)' },
    { sn: 'SCOPE-OLY-TJF-Q190V-4410', model: 'TJF-Q190V Duodenoscope', hangRemaining: '120 hrs', status: 'VALID FOR USE', slot: 'Cabinet #1 (Slot 7)' },
    { sn: 'SCOPE-PNTX-EB1970-1120', model: 'EB-1970TK Bronchoscope', hangRemaining: '162 hrs', status: 'VALID FOR USE', slot: 'Cabinet #2 (Slot 1)' }
  ]);

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Wind className="h-7 w-7 text-cyan-400" />
          <div>
            <h2 className="text-xl font-bold">Endoscope Reprocessing & Positive Pressure HEPA Storage</h2>
            <p className="text-xs text-slate-400">AAMI ST91 Channel Drying & 7-Day Hang Time Compliance Tracker</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-3 gap-4 my-6">
        {scopes.map(s => (
          <div key={s.sn} className="p-4 bg-slate-950 rounded-xl border border-slate-800">
            <span className="text-xs font-mono text-slate-400 block mb-1">{s.sn}</span>
            <h3 className="text-sm font-bold text-white mb-2">{s.model}</h3>
            <div className="space-y-1.5 text-xs text-slate-300 font-mono">
              <div>Location: <strong className="text-indigo-300">{s.slot}</strong></div>
              <div>Hang Time Left: <strong className="text-emerald-400">{s.hangRemaining}</strong></div>
            </div>
            <div className="mt-4 pt-2 border-t border-slate-800 flex items-center gap-1 text-xs text-emerald-400 font-bold">
              <CheckCircle2 className="h-4 w-4" /> {s.status}
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};
