import React, { useState } from 'react';
import { Isbt128LabelConsole } from './Isbt128LabelConsole';
import { MtpCoolerConsole } from './MtpCoolerConsole';
import { HemovigilanceStudio } from './HemovigilanceStudio';
import { AntigramPanelStudio } from './AntigramPanelStudio';
import { ComponentModificationConsole } from './ComponentModificationConsole';
import { EmergencyReleaseConsole } from './EmergencyReleaseConsole';
import { PlateletAgitatorConsole } from './PlateletAgitatorConsole';
import { CompatibilityMatrixConsole } from './CompatibilityMatrixConsole';
import { ColdChainReturnConsole } from './ColdChainReturnConsole';
import { Droplets, AlertOctagon, ShieldAlert, Microscope, ShieldCheck, AlertTriangle, Activity, Clock } from 'lucide-react';

export const BloodBankPortal: React.FC = () => {
  const [activeTab, setActiveTab] = useState<'isbt' | 'mtp' | 'hemovigilance' | 'antigram' | 'modification' | 'emergency' | 'platelet' | 'compatibility' | 'coldchain'>('isbt');

  return (
    <div className="min-h-screen bg-slate-950 text-slate-100 p-8">
      <div className="max-w-7xl mx-auto space-y-6">
        <header className="border-b border-slate-800 pb-6 flex justify-between items-center">
          <div>
            <h1 className="text-3xl font-extrabold tracking-tight text-white flex items-center gap-3">
              <span className="p-2 bg-rose-600 rounded-lg text-white">BB</span>
              Enterprise Hospital Blood Bank & Transfusion Command Center
            </h1>
            <p className="text-sm text-slate-400 mt-1">ISBT 128 Labeling, MTP 1:1:1 Resuscitation, Hemovigilance, Antigram Panels & Compatibility</p>
          </div>
          <div className="flex gap-2">
            <span className="px-3 py-1 bg-emerald-950 text-emerald-300 border border-emerald-800 rounded-full text-xs font-mono font-semibold">
              AABB / CAP Certified
            </span>
          </div>
        </header>

        <div className="flex flex-wrap gap-2 border-b border-slate-800 pb-3">
          {[
            { id: 'isbt', label: 'ISBT 128 Decoder', icon: Droplets },
            { id: 'mtp', label: 'MTP 1:1:1 Cooler Dispatch', icon: AlertOctagon },
            { id: 'hemovigilance', label: 'Hemovigilance TRALI/TACO', icon: ShieldAlert },
            { id: 'antigram', label: '11-Cell Antigram Panel', icon: Microscope },
            { id: 'modification', label: '25 Gy Irradiation & Wash', icon: ShieldCheck },
            { id: 'emergency', label: 'Emergency Uncrossmatched', icon: AlertTriangle },
            { id: 'platelet', label: 'Platelet Agitator (22°C)', icon: Activity },
            { id: 'compatibility', label: 'ABO/Rh Matrix', icon: Droplets },
            { id: 'coldchain', label: '30-Min Return Rule', icon: Clock },
          ].map(tab => {
            const Icon = tab.icon;
            const active = activeTab === tab.id;
            return (
              <button
                key={tab.id}
                onClick={() => setActiveTab(tab.id as any)}
                className={'px-4 py-2 rounded-lg text-xs font-semibold flex items-center gap-2 transition-all ' + (
                  active
                    ? 'bg-rose-600 text-white shadow-lg shadow-rose-600/30'
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
          {activeTab === 'isbt' && <Isbt128LabelConsole />}
          {activeTab === 'mtp' && <MtpCoolerConsole />}
          {activeTab === 'hemovigilance' && <HemovigilanceStudio />}
          {activeTab === 'antigram' && <AntigramPanelStudio />}
          {activeTab === 'modification' && <ComponentModificationConsole />}
          {activeTab === 'emergency' && <EmergencyReleaseConsole />}
          {activeTab === 'platelet' && <PlateletAgitatorConsole />}
          {activeTab === 'compatibility' && <CompatibilityMatrixConsole />}
          {activeTab === 'coldchain' && <ColdChainReturnConsole />}
        </main>
      </div>
    </div>
  );
};
