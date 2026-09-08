import React, { useState } from 'react';
import { MeldNaAllocationStudio } from './MeldNaAllocationStudio';
import { KdpiEptsConsole } from './KdpiEptsConsole';
import { VirtualCrossmatchStudio } from './VirtualCrossmatchStudio';
import { OrganPerfusionConsole } from './OrganPerfusionConsole';
import { TacrolimusTdmConsole } from './TacrolimusTdmConsole';
import { BanffStagingStudio } from './BanffStagingStudio';
import { LungCasConsole } from './LungCasConsole';
import { AboIncompatibleConsole } from './AboIncompatibleConsole';
import { CmvSurveillanceConsole } from './CmvSurveillanceConsole';
import { Heart, Calculator, Scale, Microscope, Activity, ShieldCheck, Wind, Droplet } from 'lucide-react';

export const OrganTransplantPortal: React.FC = () => {
  const [activeTab, setActiveTab] = useState<'meld' | 'kdpi' | 'vxm' | 'perfusion' | 'tdm' | 'banff' | 'lung' | 'aboi' | 'cmv'>('meld');

  return (
    <div className="min-h-screen bg-slate-950 text-slate-100 p-8">
      <div className="max-w-7xl mx-auto space-y-6">
        <header className="border-b border-slate-800 pb-6 flex justify-between items-center">
          <div>
            <h1 className="text-3xl font-extrabold tracking-tight text-white flex items-center gap-3">
              <span className="p-2 bg-indigo-600 rounded-lg text-white">TX</span>
              Enterprise Organ Transplant Command Center
            </h1>
            <p className="text-sm text-slate-400 mt-1">UNOS Allocation (MELD-Na / KDPI / EPTS / CAS), Virtual Crossmatch & Perfusion</p>
          </div>
          <div className="flex gap-2">
            <span className="px-3 py-1 bg-emerald-950 text-emerald-300 border border-emerald-800 rounded-full text-xs font-mono font-semibold">
              UNOS Link: Active
            </span>
          </div>
        </header>

        <div className="flex flex-wrap gap-2 border-b border-slate-800 pb-3">
          {[
            { id: 'meld', label: 'UNOS MELD-Na Liver', icon: Calculator },
            { id: 'kdpi', label: 'KDPI / EPTS Kidney', icon: Scale },
            { id: 'vxm', label: 'Virtual Crossmatch (vXM)', icon: Microscope },
            { id: 'perfusion', label: 'Cold Ischemia & Perfusion', icon: Activity },
            { id: 'tdm', label: 'Tacrolimus TDM', icon: ShieldCheck },
            { id: 'banff', label: 'Banff Biopsy Staging', icon: Microscope },
            { id: 'lung', label: 'Lung CAS Score', icon: Wind },
            { id: 'aboi', label: 'ABOi Desensitization', icon: Droplet },
            { id: 'cmv', label: 'CMV Surveillance', icon: Activity },
          ].map(tab => {
            const Icon = tab.icon;
            const active = activeTab === tab.id;
            return (
              <button
                key={tab.id}
                onClick={() => setActiveTab(tab.id as any)}
                className={'px-4 py-2 rounded-lg text-xs font-semibold flex items-center gap-2 transition-all ' + (
                  active
                    ? 'bg-indigo-600 text-white shadow-lg shadow-indigo-600/30'
                    : 'bg-slate-900 text-slate-400 hover:text-slate-200 hover:bg-slate-800 border border-slate-800'
                )}
              >
                <Icon className="h-4 w-4" />
                {tab.label}
              </button>
            );
          })}
        </div>

        <main>
          {activeTab === 'meld' && <MeldNaAllocationStudio />}
          {activeTab === 'kdpi' && <KdpiEptsConsole />}
          {activeTab === 'vxm' && <VirtualCrossmatchStudio />}
          {activeTab === 'perfusion' && <OrganPerfusionConsole />}
          {activeTab === 'tdm' && <TacrolimusTdmConsole />}
          {activeTab === 'banff' && <BanffStagingStudio />}
          {activeTab === 'lung' && <LungCasConsole />}
          {activeTab === 'aboi' && <AboIncompatibleConsole />}
          {activeTab === 'cmv' && <CmvSurveillanceConsole />}
        </main>
      </div>
    </div>
  );
};
