import React, { useState } from 'react';
import { CalvertDosingStudio } from './CalvertDosingStudio';
import { RecistResponseConsole } from './RecistResponseConsole';
import { IraeManagementConsole } from './IraeManagementConsole';
import { ExtravasationConsole } from './ExtravasationConsole';
import { MasccNeutropeniaConsole } from './MasccNeutropeniaConsole';
import { CairoBishopTlsConsole } from './CairoBishopTlsConsole';
import { CinvAntiemeticConsole } from './CinvAntiemeticConsole';
import { EortcQolConsole } from './EortcQolConsole';
import { MolecularTumorBoardStudio } from './MolecularTumorBoardStudio';
import { Calculator, Activity, ShieldAlert, AlertTriangle, ShieldCheck, AlertOctagon, Heart, Microscope } from 'lucide-react';

export const ClinicalOncologyPortal: React.FC = () => {
  const [activeTab, setActiveTab] = useState<'calvert' | 'recist' | 'irae' | 'extravasation' | 'mascc' | 'tls' | 'cinv' | 'qol' | 'mtb'>('calvert');

  return (
    <div className="min-h-screen bg-slate-950 text-slate-100 p-8">
      <div className="max-w-7xl mx-auto space-y-6">
        <header className="border-b border-slate-800 pb-6 flex justify-between items-center">
          <div>
            <h1 className="text-3xl font-extrabold tracking-tight text-white flex items-center gap-3">
              <span className="p-2 bg-indigo-600 rounded-lg text-white">ONC</span>
              Enterprise Clinical Oncology & Molecular Tumor Board Center
            </h1>
            <p className="text-sm text-slate-400 mt-1">Calvert Dosing, RECIST 1.1, irAE CTCAE v5.0, Cairo-Bishop TLS & NGS Annotation</p>
          </div>
          <div className="flex gap-2">
            <span className="px-3 py-1 bg-emerald-950 text-emerald-300 border border-emerald-800 rounded-full text-xs font-mono font-semibold">
              NCCN Guidelines Active
            </span>
          </div>
        </header>

        <div className="flex flex-wrap gap-2 border-b border-slate-800 pb-3">
          {[
            { id: 'calvert', label: 'Calvert Carboplatin Dosing', icon: Calculator },
            { id: 'recist', label: 'RECIST 1.1 Tumor Tracker', icon: Activity },
            { id: 'irae', label: 'irAE Checkpoint Toxicity', icon: ShieldAlert },
            { id: 'extravasation', label: 'Extravasation Rescue', icon: AlertTriangle },
            { id: 'mascc', label: 'MASCC Neutropenia', icon: ShieldCheck },
            { id: 'tls', label: 'Cairo-Bishop TLS', icon: AlertOctagon },
            { id: 'cinv', label: 'NCCN CINV Antiemetics', icon: ShieldCheck },
            { id: 'qol', label: 'EORTC QLQ-C30 QoL', icon: Heart },
            { id: 'mtb', label: 'Molecular Tumor Board NGS', icon: Microscope },
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
          {activeTab === 'calvert' && <CalvertDosingStudio />}
          {activeTab === 'recist' && <RecistResponseConsole />}
          {activeTab === 'irae' && <IraeManagementConsole />}
          {activeTab === 'extravasation' && <ExtravasationConsole />}
          {activeTab === 'mascc' && <MasccNeutropeniaConsole />}
          {activeTab === 'tls' && <CairoBishopTlsConsole />}
          {activeTab === 'cinv' && <CinvAntiemeticConsole />}
          {activeTab === 'qol' && <EortcQolConsole />}
          {activeTab === 'mtb' && <MolecularTumorBoardStudio />}
        </main>
      </div>
    </div>
  );
};
