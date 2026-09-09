import React, { useState } from 'react';
import {
  HeartPulse,
  Stethoscope,
  Pill,
  Flame,
  User,
  Activity,
  Video,
  Radio,
  Package,
  Calculator,
  Bell,
} from 'lucide-react';
import { BedsideVitalsScreen } from './screens/BedsideVitalsScreen';
import { DoctorRoundsScreen } from './screens/DoctorRoundsScreen';
import { PatientPortalScreen } from './screens/PatientPortalScreen';
import { NurseTriageScreen } from './screens/NurseTriageScreen';
import { MobileEmarScreen } from './screens/MobileEmarScreen';
import { TelemedicineVideoScreen } from './screens/TelemedicineVideoScreen';
import { EmergencyDispatchScreen } from './screens/EmergencyDispatchScreen';
import { InventoryScannerScreen } from './screens/InventoryScannerScreen';
import { ClinicalCalculatorScreen } from './screens/ClinicalCalculatorScreen';

export const App: React.FC = () => {
  const [activeTab, setActiveTab] = useState<'vitals' | 'rounds' | 'emar' | 'triage' | 'portal' | 'tele' | 'dispatch' | 'inventory' | 'calc'>('vitals');

  return (
    <div className="min-h-screen bg-slate-900 text-slate-100 flex flex-col justify-between max-w-md mx-auto relative shadow-2xl border-x border-slate-800">
      {/* Mobile App Bar */}
      <header className="px-4 py-3 bg-slate-950/90 backdrop-blur border-b border-slate-800 flex items-center justify-between sticky top-0 z-50">
        <div className="flex items-center gap-2.5">
          <div className="h-8 w-8 rounded-xl bg-gradient-to-tr from-sky-600 to-teal-400 flex items-center justify-center text-white shadow-md">
            <Activity className="h-4 w-4" />
          </div>
          <div>
            <h1 className="text-xs font-bold tracking-tight text-white leading-tight">
              Apex HMS Mobile
            </h1>
            <span className="text-[9px] text-sky-400 font-semibold tracking-wider uppercase block">
              Clinical Handheld Station
            </span>
          </div>
        </div>

        <div className="flex items-center gap-2">
          <button className="p-1.5 bg-slate-800 rounded-lg text-slate-300">
            <Bell className="h-4 w-4" />
          </button>
        </div>
      </header>

      {/* Screen View Container */}
      <main className="flex-1 p-4 overflow-y-auto">
        {activeTab === 'vitals' && <BedsideVitalsScreen />}
        {activeTab === 'rounds' && <DoctorRoundsScreen />}
        {activeTab === 'emar' && <MobileEmarScreen />}
        {activeTab === 'triage' && <NurseTriageScreen />}
        {activeTab === 'portal' && <PatientPortalScreen />}
        {activeTab === 'tele' && <TelemedicineVideoScreen />}
        {activeTab === 'dispatch' && <EmergencyDispatchScreen />}
        {activeTab === 'inventory' && <InventoryScannerScreen />}
        {activeTab === 'calc' && <ClinicalCalculatorScreen />}
      </main>

      {/* Mobile Bottom Navigation Bar */}
      <nav className="fixed bottom-0 left-0 right-0 max-w-md mx-auto bg-slate-950/95 backdrop-blur border-t border-slate-800/80 px-2 py-1.5 flex items-center justify-around z-50 overflow-x-auto">
        {[
          { key: 'vitals', label: 'Vitals', icon: HeartPulse },
          { key: 'rounds', label: 'Rounds', icon: Stethoscope },
          { key: 'emar', label: 'eMAR', icon: Pill },
          { key: 'triage', label: 'Triage', icon: Flame },
          { key: 'tele', label: 'Telehealth', icon: Video },
          { key: 'dispatch', label: 'Dispatch', icon: Radio },
          { key: 'inventory', label: 'Stock', icon: Package },
          { key: 'calc', label: 'Calc', icon: Calculator },
          { key: 'portal', label: 'Patient', icon: User },
        ].map((tab) => {
          const Icon = tab.icon;
          const isActive = activeTab === tab.key;
          return (
            <button
              key={tab.key}
              onClick={() => setActiveTab(tab.key as any)}
              className={`flex flex-col items-center justify-center py-1 px-2 rounded-xl transition-all whitespace-nowrap ${
                isActive ? 'text-sky-400 font-bold' : 'text-slate-500 hover:text-slate-300'
              }`}
            >
              <Icon className={`h-4 w-4 ${isActive ? 'scale-110' : ''}`} />
              <span className="text-[9px] mt-0.5">{tab.label}</span>
            </button>
          );
        })}
      </nav>
    </div>
  );
};
