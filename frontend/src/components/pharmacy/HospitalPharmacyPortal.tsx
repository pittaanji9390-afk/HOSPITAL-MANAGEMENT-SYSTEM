import React, { useState } from 'react';
import { PyxisDrawerConsole } from './PyxisDrawerConsole';
import { DeaVaultLedgerConsole } from './DeaVaultLedgerConsole';
import { CleanroomHvacConsole } from './CleanroomHvacConsole';
import { GravimetricCompoundingConsole } from './GravimetricCompoundingConsole';
import { TpnFormulationStudio } from './TpnFormulationStudio';
import { IsmpHighAlertConsole } from './IsmpHighAlertConsole';
import { BcmaScannerConsole } from './BcmaScannerConsole';
import { PharmacyCarouselConsole } from './PharmacyCarouselConsole';
import { NioshCstdConsole } from './NioshCstdConsole';
import { Cpu, ShieldCheck, Wind, Scale, Calculator, AlertOctagon, Scan, Layers, ShieldAlert } from 'lucide-react';

export const HospitalPharmacyPortal: React.FC = () => {
  const [activeTab, setActiveTab] = useState<'pyxis' | 'dea' | 'cleanroom' | 'gravimetric' | 'tpn' | 'ismp' | 'bcma' | 'carousel' | 'niosh'>('pyxis');

  return (
    <div className="min-h-screen bg-slate-950 text-slate-100 p-8">
      <div className="max-w-7xl mx-auto space-y-6">
        <header className="border-b border-slate-800 pb-6 flex justify-between items-center">
          <div>
            <h1 className="text-3xl font-extrabold tracking-tight text-white flex items-center gap-3">
              <span className="p-2 bg-indigo-600 rounded-lg text-white">Rx</span>
              Enterprise Hospital Inpatient Pharmacy Command Center
            </h1>
            <p className="text-sm text-slate-400 mt-1">Automated Dispensing Cabinets, Perpetual DEA CSOS, USP &lt;797/800&gt;, Gravimetric Compounding & TPN</p>
          </div>
          <div className="flex gap-2">
            <span className="px-3 py-1 bg-emerald-950 text-emerald-300 border border-emerald-800 rounded-full text-xs font-mono font-semibold">
              Pyxis Bus: Online (500kbps)
            </span>
            <span className="px-3 py-1 bg-indigo-950 text-indigo-300 border border-indigo-800 rounded-full text-xs font-mono font-semibold">
              USP &lt;797&gt; Pass
            </span>
          </div>
        </header>

        <div className="flex flex-wrap gap-2 border-b border-slate-800 pb-3">
          {[
            { id: 'pyxis', label: 'Pyxis ADC Solenoids', icon: Cpu },
            { id: 'dea', label: 'DEA Perpetual Ledger', icon: ShieldCheck },
            { id: 'cleanroom', label: 'USP 797/800 Cleanroom', icon: Wind },
            { id: 'gravimetric', label: 'Gravimetric Compounding', icon: Scale },
            { id: 'tpn', label: 'TPN Osmolarity Formulator', icon: Calculator },
            { id: 'ismp', label: 'ISMP High-Alert Dual Sign', icon: AlertOctagon },
            { id: 'bcma', label: 'BCMA 5-Rights Scanner', icon: Scan },
            { id: 'carousel', label: 'Vertical Carousel Storage', icon: Layers },
            { id: 'niosh', label: 'NIOSH CSTD Safety', icon: ShieldAlert },
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
          {activeTab === 'pyxis' && <PyxisDrawerConsole />}
          {activeTab === 'dea' && <DeaVaultLedgerConsole />}
          {activeTab === 'cleanroom' && <CleanroomHvacConsole />}
          {activeTab === 'gravimetric' && <GravimetricCompoundingConsole />}
          {activeTab === 'tpn' && <TpnFormulationStudio />}
          {activeTab === 'ismp' && <IsmpHighAlertConsole />}
          {activeTab === 'bcma' && <BcmaScannerConsole />}
          {activeTab === 'carousel' && <PharmacyCarouselConsole />}
          {activeTab === 'niosh' && <NioshCstdConsole />}
        </main>
      </div>
    </div>
  );
};
