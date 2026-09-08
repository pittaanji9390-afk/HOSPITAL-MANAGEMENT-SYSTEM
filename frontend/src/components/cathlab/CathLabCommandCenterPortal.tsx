import React, { useState } from 'react';
import { TimiFlowAngiographyStudio } from './TimiFlowAngiographyStudio';
import { SyntaxScoreBoard } from './SyntaxScoreBoard';
import { FfrWaveformViewer } from './FfrWaveformViewer';
import { MehranCinManager } from './MehranCinManager';
import { RadiationSafetyConsole } from './RadiationSafetyConsole';
import { VascularClosureMonitor } from './VascularClosureMonitor';
import { TipsGradientConsole } from './TipsGradientConsole';
import { EkosThrombolysisConsole } from './EkosThrombolysisConsole';
import { LvPressureVolumeConsole } from './LvPressureVolumeConsole';

export const CathLabCommandCenterPortal: React.FC = () => {
  const [activeTab, setActiveTab] = useState<string>('timi');

  return (
    <div className="min-h-screen bg-slate-950 text-slate-100 p-8">
      <header className="mb-8 flex flex-col md:flex-row md:items-center justify-between border-b border-slate-800 pb-6">
        <div>
          <h1 className="text-3xl font-extrabold text-transparent bg-clip-text bg-gradient-to-r from-rose-400 via-amber-300 to-cyan-400">
            Cardiac Cath Lab & Interventional Radiology Command Center
          </h1>
          <p className="text-slate-400 text-sm mt-1">
            Real-Time Angiography Perfusion, SYNTAX II, FFR Physiology, Mehran CIN, and Radiation Dosimetry
          </p>
        </div>
      </header>

      <nav className="flex flex-wrap gap-2 mb-8 border-b border-slate-800 pb-4">
        {[
          { id: 'timi', label: 'TIMI Flow & Blush' },
          { id: 'syntax', label: 'SYNTAX II Revascularization' },
          { id: 'ffr', label: 'FFR / iFR Physiology' },
          { id: 'cin', label: 'Mehran CIN Protection' },
          { id: 'radiation', label: 'Radiation Safety & DAP' },
          { id: 'closure', label: 'Vascular Closure & Access' },
          { id: 'tips', label: 'TIPS Gradient' },
          { id: 'ekos', label: 'EKOS Thrombolysis' },
          { id: 'lv', label: 'LV Power & Shock' }
        ].map((tab) => (
          <button
            key={tab.id}
            onClick={() => setActiveTab(tab.id)}
            className={
              activeTab === tab.id
                ? 'px-4 py-2 rounded-lg text-xs font-semibold transition-all bg-rose-600 text-white shadow-lg shadow-rose-900/40'
                : 'px-4 py-2 rounded-lg text-xs font-semibold transition-all bg-slate-900 text-slate-400 hover:bg-slate-800 hover:text-slate-200'
            }
          >
            {tab.label}
          </button>
        ))}
      </nav>

      <main className="space-y-6">
        {activeTab === 'timi' && <TimiFlowAngiographyStudio />}
        {activeTab === 'syntax' && <SyntaxScoreBoard />}
        {activeTab === 'ffr' && <FfrWaveformViewer />}
        {activeTab === 'cin' && <MehranCinManager />}
        {activeTab === 'radiation' && <RadiationSafetyConsole />}
        {activeTab === 'closure' && <VascularClosureMonitor />}
        {activeTab === 'tips' && <TipsGradientConsole />}
        {activeTab === 'ekos' && <EkosThrombolysisConsole />}
        {activeTab === 'lv' && <LvPressureVolumeConsole />}
      </main>
    </div>
  );
};
