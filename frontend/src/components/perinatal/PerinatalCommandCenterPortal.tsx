import React, { useState } from 'react';
import { EfmCardiotocographyViewer } from './EfmCardiotocographyViewer';
import { NichdDecelerationAnalyzer } from './NichdDecelerationAnalyzer';
import { BishopInductionStudio } from './BishopInductionStudio';
import { PphRapidResponseConsole } from './PphRapidResponseConsole';
import { PreeclampsiaManager } from './PreeclampsiaManager';
import { GdmOgttStudio } from './GdmOgttStudio';
import { GbsProphylaxisConsole } from './GbsProphylaxisConsole';
import { ApgarNrpConsole } from './ApgarNrpConsole';
import { NeonatalSepsisCalculator } from './NeonatalSepsisCalculator';

export const PerinatalCommandCenterPortal: React.FC = () => {
  const [activeTab, setActiveTab] = useState<string>('efm');

  return (
    <div className="min-h-screen bg-slate-950 text-slate-100 p-8">
      <header className="mb-8 flex flex-col md:flex-row md:items-center justify-between border-b border-slate-800 pb-6">
        <div>
          <h1 className="text-3xl font-extrabold text-transparent bg-clip-text bg-gradient-to-r from-pink-400 via-rose-300 to-amber-300">
            Labor & Delivery & Perinatal Medicine Command Center
          </h1>
          <p className="text-slate-400 text-sm mt-1">
            Real-Time Cardiotocography EFM, CMQCC PPH Protocols, Preeclampsia Severe Features, and Neonatal NRP Resuscitation
          </p>
        </div>
        <div className="mt-4 md:mt-0 flex gap-3">
          <span className="px-3 py-1 bg-pink-950 text-pink-400 border border-pink-800 rounded-full text-xs flex items-center gap-1.5">
            <span className="w-2 h-2 rounded-full bg-pink-400 animate-pulse"></span>
            12 L&D Suites Active
          </span>
          <span className="px-3 py-1 bg-cyan-950 text-cyan-400 border border-cyan-800 rounded-full text-xs">
            NICU Level III Ready
          </span>
        </div>
      </header>

      <nav className="flex flex-wrap gap-2 mb-8 border-b border-slate-800 pb-4">
        {[
          { id: 'efm', label: 'ACOG EFM CTG Viewer' },
          { id: 'nichd', label: 'NICHD Decelerations' },
          { id: 'bishop', label: 'Bishop Induction' },
          { id: 'pph', label: 'CMQCC PPH Emergency' },
          { id: 'preeclampsia', label: 'Preeclampsia & MgSO4' },
          { id: 'gdm', label: 'GDM Glucose OGTT' },
          { id: 'gbs', label: 'GBS Antibiotic IAP' },
          { id: 'apgar', label: 'APGAR & NRP Resuscitation' },
          { id: 'sepsis', label: 'Neonatal Sepsis (EOS)' }
        ].map((tab) => (
          <button
            key={tab.id}
            onClick={() => setActiveTab(tab.id)}
            className={
              activeTab === tab.id
                ? 'px-4 py-2 rounded-lg text-xs font-semibold transition-all bg-pink-600 text-white shadow-lg shadow-pink-900/40'
                : 'px-4 py-2 rounded-lg text-xs font-semibold transition-all bg-slate-900 text-slate-400 hover:bg-slate-800 hover:text-slate-200'
            }
          >
            {tab.label}
          </button>
        ))}
      </nav>

      <main className="space-y-6">
        {activeTab === 'efm' && <EfmCardiotocographyViewer />}
        {activeTab === 'nichd' && <NichdDecelerationAnalyzer />}
        {activeTab === 'bishop' && <BishopInductionStudio />}
        {activeTab === 'pph' && <PphRapidResponseConsole />}
        {activeTab === 'preeclampsia' && <PreeclampsiaManager />}
        {activeTab === 'gdm' && <GdmOgttStudio />}
        {activeTab === 'gbs' && <GbsProphylaxisConsole />}
        {activeTab === 'apgar' && <ApgarNrpConsole />}
        {activeTab === 'sepsis' && <NeonatalSepsisCalculator />}
      </main>
    </div>
  );
};
