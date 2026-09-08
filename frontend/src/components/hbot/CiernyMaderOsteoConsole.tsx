import React, { useState } from 'react';
import { ShieldCheck, Activity } from 'lucide-react';

export const CiernyMaderOsteoConsole: React.FC = () => {
  const [stage] = useState('Cierny-Mader Stage 3B (Localized Diffuse, Compromised Host)');

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Activity className="h-7 w-7 text-indigo-400" />
          <div>
            <h2 className="text-xl font-bold">Chronic Refractory Osteomyelitis Protocol</h2>
            <p className="text-xs text-slate-400">Cierny-Mader Classification & Bone Neovascularization Protocol</p>
          </div>
        </div>
      </div>

      <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 my-6 text-xs font-mono space-y-2">
        <div className="text-slate-300">Staging: <strong className="text-white">{stage}</strong></div>
        <div>HBOT Recommendation: <strong className="text-emerald-400">30 - 40 Dives at 2.4 ATA x 90 Minutes</strong></div>
        <div className="text-slate-400 font-sans mt-2">Stimulates PMN leukocyte killing of S. aureus and fibroblastic osteogenesis.</div>
      </div>
    </div>
  );
};
