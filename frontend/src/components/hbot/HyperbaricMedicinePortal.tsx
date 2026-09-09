import React, { useState } from 'react';
import { ChamberPressureStudio } from './ChamberPressureStudio';
import { NavyDiveTableConsole } from './NavyDiveTableConsole';
import { CoClearanceStudio } from './CoClearanceStudio';
import { Tcpo2OximetryConsole } from './Tcpo2OximetryConsole';
import { NstiEmergencyConsole } from './NstiEmergencyConsole';
import { MarxProtocolConsole } from './MarxProtocolConsole';
import { SensoryEmergencyConsole } from './SensoryEmergencyConsole';
import { ChamberSafetyConsole } from './ChamberSafetyConsole';
import { CiernyMaderOsteoConsole } from './CiernyMaderOsteoConsole';
import { Gauge, Anchor, Flame, Activity, AlertOctagon, ShieldCheck, Eye, ShieldAlert } from 'lucide-react';

export const HyperbaricMedicinePortal: React.FC = () => {
  const [activeTab, setActiveTab] = useState<'pressure' | 'dive' | 'co' | 'tcpo2' | 'nsti' | 'marx' | 'sensory' | 'safety' | 'osteo'>('pressure');

  return (
    <div className="min-h-screen bg-slate-950 text-slate-100 p-8">
      <div className="max-w-7xl mx-auto space-y-6">
        <header className="border-b border-slate-800 pb-6 flex justify-between items-center">
          <div>
            <h1 className="text-3xl font-extrabold tracking-tight text-white flex items-center gap-3">
              <span className="p-2 bg-cyan-600 rounded-lg text-white">O2</span>
              Enterprise Hyperbaric Oxygen & Undersea Medicine Center
            </h1>
            <p className="text-sm text-slate-400 mt-1">Chamber ATA Depth, US Navy Table 6, CO Poisoning, TcPO2 & Marx Radiation Staging</p>
          </div>
          <div className="flex gap-2">
            <span className="px-3 py-1 bg-cyan-950 text-cyan-300 border border-cyan-800 rounded-full text-xs font-mono font-semibold">
              UHMS Accredited
            </span>
          </div>
        </header>

        <div className="flex flex-wrap gap-2 border-b border-slate-800 pb-3">
          {[
            { id: 'pressure', label: 'Chamber ATA Profile', icon: Gauge },
            { id: 'dive', label: 'US Navy Dive Table 6', icon: Anchor },
            { id: 'co', label: 'Carbon Monoxide T½', icon: Flame },
            { id: 'tcpo2', label: 'TcPO2 Oximetry', icon: Activity },
            { id: 'nsti', label: 'NSTI Gas Gangrene', icon: AlertOctagon },
            { id: 'marx', label: 'Marx Radiation Injury', icon: ShieldCheck },
            { id: 'sensory', label: 'SSNHL & CRAO', icon: Eye },
            { id: 'safety', label: 'NFPA 99 Gas Safety', icon: ShieldAlert },
            { id: 'osteo', label: 'Chronic Osteomyelitis', icon: Activity },
          ].map(tab => {
            const Icon = tab.icon;
            const active = activeTab === tab.id;
            return (
              <button
                key={tab.id}
                onClick={() => setActiveTab(tab.id as any)}
                className={'px-4 py-2 rounded-lg text-xs font-semibold flex items-center gap-2 transition-all ' + (
                  active
                    ? 'bg-cyan-600 text-white shadow-lg shadow-cyan-600/30'
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
          {activeTab === 'pressure' && <ChamberPressureStudio />}
          {activeTab === 'dive' && <NavyDiveTableConsole />}
          {activeTab === 'co' && <CoClearanceStudio />}
          {activeTab === 'tcpo2' && <Tcpo2OximetryConsole />}
          {activeTab === 'nsti' && <NstiEmergencyConsole />}
          {activeTab === 'marx' && <MarxProtocolConsole />}
          {activeTab === 'sensory' && <SensoryEmergencyConsole />}
          {activeTab === 'safety' && <ChamberSafetyConsole />}
          {activeTab === 'osteo' && <CiernyMaderOsteoConsole />}
        </main>
      </div>
    </div>
  );
};
