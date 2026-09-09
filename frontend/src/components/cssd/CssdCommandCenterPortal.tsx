import React, { useState } from 'react';
import { RfidTrayInspectionConsole } from './RfidTrayInspectionConsole';
import { AutoclaveTelemetryConsole } from './AutoclaveTelemetryConsole';
import { BiologicalIndicatorConsole } from './BiologicalIndicatorConsole';
import { EndoscopeReprocessingConsole } from './EndoscopeReprocessingConsole';
import { WasherDisinfectorStudio } from './WasherDisinfectorStudio';
import { SterilityPackageInspector } from './SterilityPackageInspector';
import { LoanerConsignmentConsole } from './LoanerConsignmentConsole';
import { IussFlashAuditorConsole } from './IussFlashAuditorConsole';
import { BowieDickConsole } from './BowieDickConsole';
import { Tag, Flame, Microscope, Wind, Waves, ShieldCheck, Truck, AlertOctagon, Gauge } from 'lucide-react';

export const CssdCommandCenterPortal: React.FC = () => {
  const [activeTab, setActiveTab] = useState<'rfid' | 'autoclave' | 'bi' | 'endoscope' | 'washer' | 'ers' | 'loaner' | 'iuss' | 'bowiedick'>('rfid');

  return (
    <div className="min-h-screen bg-slate-950 text-slate-100 p-8">
      <div className="max-w-7xl mx-auto space-y-6">
        <header className="border-b border-slate-800 pb-6 flex justify-between items-center">
          <div>
            <h1 className="text-3xl font-extrabold tracking-tight text-white flex items-center gap-3">
              <span className="p-2 bg-indigo-600 rounded-lg text-white">CSSD</span>
              Central Sterile Supply Department (CSSD) Operations Center
            </h1>
            <p className="text-sm text-slate-400 mt-1">RFID Surgical Trays, Steam Autoclaves, Biological Spores, AER Endoscopes & Loaners</p>
          </div>
          <div className="flex gap-2">
            <span className="px-3 py-1 bg-emerald-950 text-emerald-300 border border-emerald-800 rounded-full text-xs font-mono font-semibold">
              AAMI ST79 Pass
            </span>
          </div>
        </header>

        <div className="flex flex-wrap gap-2 border-b border-slate-800 pb-3">
          {[
            { id: 'rfid', label: 'RFID Tray Assembly', icon: Tag },
            { id: 'autoclave', label: 'Autoclave Telemetry', icon: Flame },
            { id: 'bi', label: 'Biological Indicators', icon: Microscope },
            { id: 'endoscope', label: 'Endoscope Reprocessing', icon: Wind },
            { id: 'washer', label: 'Washer-Disinfector A0', icon: Waves },
            { id: 'ers', label: 'Sterility ERS Gate', icon: ShieldCheck },
            { id: 'loaner', label: 'Loaner Trays SLA', icon: Truck },
            { id: 'iuss', label: 'IUSS Flash Audit', icon: AlertOctagon },
            { id: 'bowiedick', label: 'Bowie-Dick Leak Test', icon: Gauge },
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
          {activeTab === 'rfid' && <RfidTrayInspectionConsole />}
          {activeTab === 'autoclave' && <AutoclaveTelemetryConsole />}
          {activeTab === 'bi' && <BiologicalIndicatorConsole />}
          {activeTab === 'endoscope' && <EndoscopeReprocessingConsole />}
          {activeTab === 'washer' && <WasherDisinfectorStudio />}
          {activeTab === 'ers' && <SterilityPackageInspector />}
          {activeTab === 'loaner' && <LoanerConsignmentConsole />}
          {activeTab === 'iuss' && <IussFlashAuditorConsole />}
          {activeTab === 'bowiedick' && <BowieDickConsole />}
        </main>
      </div>
    </div>
  );
};
