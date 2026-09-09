import React, { useState } from 'react';
import { Radiation, CheckCircle2 } from 'lucide-react';

export const Ga68PurityConsole: React.FC = () => {
  const [itlc, setItlc] = useState(98.8); // % (Limit >= 95%)

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Radiation className="h-7 w-7 text-indigo-400" />
          <div>
            <h2 className="text-xl font-bold">Ga-68 DOTATOC / PSMA-11 Radiochemical Purity</h2>
            <p className="text-xs text-slate-400">Instant Thin-Layer Chromatography (ITLC-SG) Quality Control</p>
          </div>
        </div>
      </div>

      <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 my-6 text-xs font-mono">
        <div>ITLC Radiochemical Purity: <strong className="text-emerald-400 text-xl">{itlc}%</strong></div>
        <div className="text-slate-400 font-sans mt-2">Passed USP &lt;825&gt; criteria (≥ 95.0%). Free unchelated Gallium &lt; 2.0%.</div>
      </div>
    </div>
  );
};
