import React, { useState } from 'react';
import { AcmgClassificationStudio } from './AcmgClassificationStudio';
import { LynchSyndromeConsole } from './LynchSyndromeConsole';
import { HbocBrcaConsole } from './HbocBrcaConsole';
import { FhDutchLipidConsole } from './FhDutchLipidConsole';
import { LqtsSchwartzConsole } from './LqtsSchwartzConsole';
import { HuntingtonCagConsole } from './HuntingtonCagConsole';
import { HfeGenotypingConsole } from './HfeGenotypingConsole';
import { FabryGlaConsole } from './FabryGlaConsole';
import { SmaSmnConsole } from './SmaSmnConsole';
import { Dna, ShieldCheck, Activity, Droplet } from 'lucide-react';

export const ClinicalGeneticsPortal: React.FC = () => {
  const [activeTab, setActiveTab] = useState<'acmg' | 'lynch' | 'hboc' | 'fh' | 'lqts' | 'huntington' | 'hfe' | 'fabry' | 'sma'>('acmg');

  return (
    <div className="min-h-screen bg-slate-950 text-slate-100 p-8">
      <div className="max-w-7xl mx-auto space-y-6">
        <header className="border-b border-slate-800 pb-6 flex justify-between items-center">
          <div>
            <h1 className="text-3xl font-extrabold tracking-tight text-white flex items-center gap-3">
              <span className="p-2 bg-indigo-600 rounded-lg text-white">DNA</span>
              Enterprise Clinical Genetics & Genomic Medicine Center
            </h1>
            <p className="text-sm text-slate-400 mt-1">ACMG Variant Classification, Hereditary Cancer, Cardiac Channelopathies & Rare Disease</p>
          </div>
          <div className="flex gap-2">
            <span className="px-3 py-1 bg-indigo-950 text-indigo-300 border border-indigo-800 rounded-full text-xs font-mono font-semibold">
              ACMG / AMP 2015 Compliant
            </span>
          </div>
        </header>

        <div className="flex flex-wrap gap-2 border-b border-slate-800 pb-3">
          {[
            { id: 'acmg', label: 'ACMG 5-Tier Classifier', icon: Dna },
            { id: 'lynch', label: 'Lynch Syndrome MMR', icon: ShieldCheck },
            { id: 'hboc', label: 'HBOC BRCA1/2', icon: Dna },
            { id: 'fh', label: 'Familial Hypercholesterolemia', icon: Activity },
            { id: 'lqts', label: 'Long QT Schwartz', icon: Activity },
            { id: 'huntington', label: 'Huntington CAG Repeats', icon: Dna },
            { id: 'hfe', label: 'HFE Hemochromatosis', icon: Droplet },
            { id: 'fabry', label: 'Fabry Disease GLA', icon: Activity },
            { id: 'sma', label: 'SMA SMN1/SMN2', icon: Dna },
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
          {activeTab === 'acmg' && <AcmgClassificationStudio />}
          {activeTab === 'lynch' && <LynchSyndromeConsole />}
          {activeTab === 'hboc' && <HbocBrcaConsole />}
          {activeTab === 'fh' && <FhDutchLipidConsole />}
          {activeTab === 'lqts' && <LqtsSchwartzConsole />}
          {activeTab === 'huntington' && <HuntingtonCagConsole />}
          {activeTab === 'hfe' && <HfeGenotypingConsole />}
          {activeTab === 'fabry' && <FabryGlaConsole />}
          {activeTab === 'sma' && <SmaSmnConsole />}
        </main>
      </div>
    </div>
  );
};
