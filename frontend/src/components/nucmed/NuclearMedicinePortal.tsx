import React, { useState } from 'react';
import { Tc99mGeneratorConsole } from './Tc99mGeneratorConsole';
import { I131AblationStudio } from './I131AblationStudio';
import { Lu177PsmaConsole } from './Lu177PsmaConsole';
import { Lu177DotatateConsole } from './Lu177DotatateConsole';
import { Y90SirtConsole } from './Y90SirtConsole';
import { F18DeauvilleConsole } from './F18DeauvilleConsole';
import { Radium223Console } from './Radium223Console';
import { RadiationSurveyConsole } from './RadiationSurveyConsole';
import { Ga68PurityConsole } from './Ga68PurityConsole';
import { Radiation, Flame, Activity, Gauge, ShieldAlert } from 'lucide-react';

export const NuclearMedicinePortal: React.FC = () => {
  const [activeTab, setActiveTab] = useState<'generator' | 'i131' | 'lu177psma' | 'dotatate' | 'y90' | 'f18' | 'ra223' | 'survey' | 'ga68'>('generator');

  return (
    <div className="min-h-screen bg-slate-950 text-slate-100 p-8">
      <div className="max-w-7xl mx-auto space-y-6">
        <header className="border-b border-slate-800 pb-6 flex justify-between items-center">
          <div>
            <h1 className="text-3xl font-extrabold tracking-tight text-white flex items-center gap-3">
              <span className="p-2 bg-amber-600 rounded-lg text-white">NM</span>
              Enterprise Nuclear Medicine & Theranostics Command Center
            </h1>
            <p className="text-sm text-slate-400 mt-1">177Lu-PSMA-617, I-131 Ablation, Y-90 SIRT, Mo-99/Tc-99m Generator & Hot Lab QC</p>
          </div>
          <div className="flex gap-2">
            <span className="px-3 py-1 bg-amber-950 text-amber-300 border border-amber-800 rounded-full text-xs font-mono font-semibold">
              NRC / SNMMI Certified
            </span>
          </div>
        </header>

        <div className="flex flex-wrap gap-2 border-b border-slate-800 pb-3">
          {[
            { id: 'generator', label: 'Mo-99/Tc-99m Generator', icon: Radiation },
            { id: 'i131', label: 'I-131 Thyroid Ablation', icon: Flame },
            { id: 'lu177psma', label: '177Lu-PSMA-617 Pluvicto', icon: Radiation },
            { id: 'dotatate', label: '177Lu-DOTATATE Lutathera', icon: Activity },
            { id: 'y90', label: 'Y-90 SIRT Lung Shunt', icon: Gauge },
            { id: 'f18', label: 'F-18 FDG Deauville', icon: Activity },
            { id: 'ra223', label: 'Radium-223 Xofigo', icon: Radiation },
            { id: 'survey', label: 'RSO Geiger Survey', icon: ShieldAlert },
            { id: 'ga68', label: 'Ga-68 ITLC Purity', icon: Radiation },
          ].map(tab => {
            const Icon = tab.icon;
            const active = activeTab === tab.id;
            return (
              <button
                key={tab.id}
                onClick={() => setActiveTab(tab.id as any)}
                className={'px-4 py-2 rounded-lg text-xs font-semibold flex items-center gap-2 transition-all ' + (
                  active
                    ? 'bg-amber-600 text-white shadow-lg shadow-amber-600/30'
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
          {activeTab === 'generator' && <Tc99mGeneratorConsole />}
          {activeTab === 'i131' && <I131AblationStudio />}
          {activeTab === 'lu177psma' && <Lu177PsmaConsole />}
          {activeTab === 'dotatate' && <Lu177DotatateConsole />}
          {activeTab === 'y90' && <Y90SirtConsole />}
          {activeTab === 'f18' && <F18DeauvilleConsole />}
          {activeTab === 'ra223' && <Radium223Console />}
          {activeTab === 'survey' && <RadiationSurveyConsole />}
          {activeTab === 'ga68' && <Ga68PurityConsole />}
        </main>
      </div>
    </div>
  );
};
