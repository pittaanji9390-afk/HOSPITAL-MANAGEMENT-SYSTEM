import React, { useState } from 'react';
import { Microscope, CheckCircle2 } from 'lucide-react';

export const AntigramPanelStudio: React.FC = () => {
  const [cells] = useState([
    { cell: 1, d: '+', c: '+', bigE: '-', littleC: '-', littleE: '+', k: '+', fya: '+', fyb: '-', ahg: '3+' },
    { cell: 2, d: '+', c: '-', bigE: '+', littleC: '+', littleE: '-', k: '+', fya: '-', fyb: '+', ahg: '3+' },
    { cell: 3, d: '-', c: '+', bigE: '-', littleC: '+', littleE: '+', k: '+', fya: '+', fyb: '+', ahg: '3+' },
    { cell: 4, d: '-', c: '-', bigE: '-', littleC: '+', littleE: '+', k: '-', fya: '+', fyb: '-', ahg: '0' },
    { cell: 5, d: '+', c: '+', bigE: '+', littleC: '-', littleE: '-', k: '-', fya: '-', fyb: '+', ahg: '0' },
    { cell: 6, d: '-', c: '-', bigE: '+', littleC: '+', littleE: '-', k: '-', fya: '+', fyb: '+', ahg: '0' }
  ]);

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Microscope className="h-7 w-7 text-indigo-400" />
          <div>
            <h2 className="text-xl font-bold">11-Cell Antigram Antibody Identification Panel</h2>
            <p className="text-xs text-slate-400">Rule-of-Three Statistical Confirmation: Anti-Kell (Anti-K)</p>
          </div>
        </div>
        <span className="px-3 py-1 bg-emerald-950 text-emerald-300 border border-emerald-700/60 rounded-full text-xs font-mono">
          p &lt; 0.05 CONFIRMED
        </span>
      </div>

      <div className="my-6 overflow-x-auto">
        <table className="w-full text-left text-xs border border-slate-800 rounded font-mono">
          <thead className="bg-slate-950 text-slate-400 uppercase">
            <tr>
              <th className="p-2">Cell</th>
              <th className="p-2">D</th>
              <th className="p-2">C</th>
              <th className="p-2">E</th>
              <th className="p-2">c</th>
              <th className="p-2">e</th>
              <th className="p-2 text-amber-400">K</th>
              <th className="p-2">Fya</th>
              <th className="p-2">Fyb</th>
              <th className="p-2 text-indigo-400 font-bold">AHG</th>
            </tr>
          </thead>
          <tbody className="divide-y divide-slate-800 bg-slate-900/60">
            {cells.map(c => (
              <tr key={c.cell} className="hover:bg-slate-800/50">
                <td className="p-2 font-bold">{c.cell}</td>
                <td className="p-2">{c.d}</td>
                <td className="p-2">{c.c}</td>
                <td className="p-2">{c.bigE}</td>
                <td className="p-2">{c.littleC}</td>
                <td className="p-2">{c.littleE}</td>
                <td className="p-2 text-amber-300 font-bold">{c.k}</td>
                <td className="p-2">{c.fya}</td>
                <td className="p-2">{c.fyb}</td>
                <td className="p-2 font-bold text-indigo-300">{c.ahg}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};
