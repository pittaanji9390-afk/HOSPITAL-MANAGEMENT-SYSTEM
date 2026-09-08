import React, { useState } from 'react';
import { Anchor, CheckCircle2, AlertOctagon } from 'lucide-react';

export const NavyDiveTableConsole: React.FC = () => {
  const [dciType, setDciType] = useState('DCS Type II (Neurological / Spinal)');

  const tables: Record<string, { table: string; depth: string; time: string; periods: string }> = {
    'DCS Type II (Neurological / Spinal)': { table: 'US Navy Treatment Table 6', depth: '60 fsw (2.81 ATA)', time: '285 minutes (4h 45m)', periods: '3 O2 periods at 60 fsw, 2 O2 periods at 30 fsw' },
    'Arterial Gas Embolism (AGE)': { table: 'US Navy Treatment Table 6 (Extended)', depth: '60 fsw (2.81 ATA)', time: '330+ minutes', periods: '6+ O2 periods with emergency extensions' },
    'DCS Type I (Pain-Only Bends)': { table: 'US Navy Treatment Table 5', depth: '60 fsw (2.81 ATA)', time: '135 minutes (2h 15m)', periods: '2 O2 periods at 60 fsw, 1 at 30 fsw' }
  };

  const current = tables[dciType] || tables['DCS Type II (Neurological / Spinal)'];

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Anchor className="h-7 w-7 text-indigo-400" />
          <div>
            <h2 className="text-xl font-bold">US Navy Decompression Illness Recompression Tables</h2>
            <p className="text-xs text-slate-400">Treatment Table 5 & 6 Decompression Sickness (DCS) / AGE Protocol</p>
          </div>
        </div>
        <span className="px-3 py-1 bg-indigo-950 text-indigo-300 border border-indigo-700/60 rounded-full text-xs font-mono">
          UHMS PROTOCOL
        </span>
      </div>

      <div className="grid grid-cols-2 gap-4 my-6">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 space-y-3">
          <label className="text-xs text-slate-400 block mb-1">Decompression Injury Classification</label>
          <select value={dciType} onChange={e => setDciType(e.target.value)} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-slate-200">
            <option>DCS Type II (Neurological / Spinal)</option>
            <option>Arterial Gas Embolism (AGE)</option>
            <option>DCS Type I (Pain-Only Bends)</option>
          </select>
          <div className="p-3 bg-slate-900 rounded border border-slate-800 text-xs font-mono text-emerald-400 font-bold">
            Assigned Table: {current.table}
          </div>
        </div>

        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 text-xs font-mono space-y-2">
          <div>Initial Treatment Depth: <strong className="text-cyan-300">{current.depth}</strong></div>
          <div>Total Table Run Time: <strong className="text-white">{current.time}</strong></div>
          <div className="text-slate-300 pt-1 border-t border-slate-800">
            <strong>Oxygen Schedule:</strong> {current.periods}
          </div>
        </div>
      </div>
    </div>
  );
};
