import React, { useState } from 'react';
import { Radiation, CheckCircle2, AlertOctagon, ShieldCheck } from 'lucide-react';

export const Tc99mGeneratorConsole: React.FC = () => {
  const [tcYield, setTcYield] = useState(850); // mCi
  const [moBreakthrough, setMoBreakthrough] = useState(0.04); // uCi
  const [itlcPurity, setItlcPurity] = useState(98.4); // %

  const ratio = (moBreakthrough / tcYield);
  const isMoPass = ratio < 0.15;
  const isItlcPass = itlcPurity >= 95.0;

  const isAllPass = isMoPass && isItlcPass;

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Radiation className="h-7 w-7 text-amber-400" />
          <div>
            <h2 className="text-xl font-bold">Tc-99m Generator Elution & Mo-99 Breakthrough QC</h2>
            <p className="text-xs text-slate-400">USP &lt;825&gt; Radiopharmacy Hot Lab Radionuclidic & Chemical Purity</p>
          </div>
        </div>
        <span className={'px-3 py-1 rounded-full text-xs font-mono font-bold ' + (
          isAllPass ? 'bg-emerald-950 text-emerald-300 border border-emerald-700' : 'bg-rose-950 text-rose-300 border border-rose-700'
        )}>
          {isAllPass ? 'PASSED USP <825> RELEASE' : 'FAILED QC INTERCEPT'}
        </span>
      </div>

      <div className="grid grid-cols-3 gap-4 my-6 text-xs font-mono">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 space-y-2">
          <span className="text-slate-400 block">Tc-99m Elution Yield</span>
          <strong className="text-2xl text-emerald-400 block">{tcYield} mCi</strong>
          <span className="text-slate-500">Capintec CRC-55tR Assay</span>
        </div>

        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 space-y-2">
          <span className="text-slate-400 block">Mo-99 Breakthrough Ratio</span>
          <strong className={'text-2xl block ' + (isMoPass ? 'text-cyan-300' : 'text-rose-400')}>
            {ratio.toFixed(5)} µCi/mCi
          </strong>
          <span className="text-slate-500">NRC Limit: &lt; 0.15000 µCi/mCi</span>
        </div>

        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 space-y-2">
          <span className="text-slate-400 block">ITLC Radiochemical Purity</span>
          <strong className="text-2xl text-indigo-300 block">{itlcPurity}%</strong>
          <span className="text-slate-500">Free TcO4- Limit: ≥ 95.0%</span>
        </div>
      </div>
    </div>
  );
};
