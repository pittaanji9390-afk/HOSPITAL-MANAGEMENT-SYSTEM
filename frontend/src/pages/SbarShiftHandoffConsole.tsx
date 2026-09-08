import React, { useState } from 'react';

interface SbarRecord {
  patientId: string;
  patientName: string;
  bed: string;
  codeStatus: string;
  situation: string;
  background: string;
  assessment: string;
  recommendation: string;
  criticalLabs: string;
  linesDrains: string;
  pendingStatTasks: string[];
}

export const SbarShiftHandoffConsole: React.FC = () => {
  const [activeBed, setActiveBed] = useState('ICU-Bed-04');
  const [handoffList, setHandoffList] = useState<SbarRecord[]>([
    {
      patientId: 'PT-9941',
      patientName: 'Eleanor Vance',
      bed: 'ICU-Bed-04',
      codeStatus: 'FULL CODE',
      situation: 'Post-op Day 1 Exploratory Laparotomy with Ileostomy creation for perforated diverticulitis.',
      background: '72yo Female with PMHx of severe COPD, HTN, and T2DM. Extubated 4 hours ago.',
      assessment: 'SpO2 95% on 3L NC. MAP maintained >=70 on low-dose Norepi at 0.04 mcg/kg/min. Stoma pink & viable, 150mL serosanguinous output.',
      recommendation: 'Wean Norepinephrine as tolerated. Repeat ABG and CBC at 04:00. Encourage incentive spirometry Q1H.',
      criticalLabs: 'Lactate 1.8 (down from 4.2), WBC 14.5, K+ 4.1',
      linesDrains: 'Right IJ Triple Lumen CVC (Day 2), Foley Catheter (Output 45 mL/hr), Left Jackson-Pratt #1',
      pendingStatTasks: ['Draw 04:00 STAT Lactate & Chem7', 'Replace JP Bulb Dressing Q Shift', 'Consult Physical Therapy in AM']
    },
    {
      patientId: 'PT-8812',
      patientName: 'Robert Langdon',
      bed: 'ICU-Bed-05',
      codeStatus: 'DNR / DNI',
      situation: 'Acute Anterolateral STEMI s/p Emergent PCI with 2 DES to proximal LAD. Cardiogenic Shock.',
      background: '64yo Male with 30 pack-year smoking history, hyperlipidemia, and prior CABG.',
      assessment: 'Impella CP at P-6 support. CI 2.4 L/min/m2 on Dobutamine 5 mcg/kg/min. Urine output 30 mL/hr.',
      recommendation: 'Maintain ACT 160-180 for Impella purge. Strict telemetry ST segment monitoring. Echo scheduled at 08:00.',
      criticalLabs: 'Troponin-I 48.2 ng/mL, BNP 1,420 pg/mL, Cr 1.6 mg/dL',
      linesDrains: 'Right Femoral Impella 14Fr, Left Radial Arterial Line, Foley with Temperature Sensor',
      pendingStatTasks: ['STAT ACT Check at 02:00', 'Check distal pedal pulses Q1H', 'Titrate Dobutamine for CI > 2.2']
    }
  ]);

  const currentRecord = handoffList.find(r => r.bed === activeBed) || handoffList[0];

  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">SBAR Shift Transition &amp; Handoff Tool</h1>
          <p className="text-sm text-slate-400">JCI National Patient Safety Goal (IPSG 2): Standardized Handover Communication</p>
        </div>
        <div className="flex gap-2">
          {handoffList.map(item => (
            <button
              key={item.bed}
              onClick={() => setActiveBed(item.bed)}
              className={`px-4 py-2 rounded text-sm font-semibold ${activeBed === item.bed ? 'bg-sky-600 text-white' : 'bg-slate-800 text-slate-400 hover:bg-slate-700'}`}
            >
              {item.bed}: {item.patientName.split(' ')[1]}
            </button>
          ))}
        </div>
      </header>

      {/* Patient Top Banner */}
      <div className="bg-slate-800/90 p-4 rounded-xl border border-slate-700 mb-6 flex flex-wrap justify-between items-center gap-4">
        <div>
          <span className="text-xs text-slate-400 font-mono">PATIENT:</span>
          <span className="text-lg font-bold text-white ml-2">{currentRecord.patientName}</span>
          <span className="text-xs text-sky-400 font-mono ml-3">({currentRecord.patientId})</span>
        </div>
        <div className="flex gap-4">
          <span className="px-3 py-1 rounded text-xs font-bold bg-rose-900/80 text-rose-300 border border-rose-700">
            {currentRecord.codeStatus}
          </span>
          <span className="px-3 py-1 rounded text-xs font-mono bg-slate-700 text-slate-200">
            LOCATION: {currentRecord.bed}
          </span>
        </div>
      </div>

      {/* SBAR 4-Quadrant Matrix */}
      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mb-6">
        {/* Situation */}
        <div className="bg-slate-800/70 p-5 rounded-xl border-l-4 border-sky-500 border-t border-r border-b border-slate-700/60">
          <div className="flex items-center gap-2 mb-2">
            <span className="px-2 py-0.5 bg-sky-500/20 text-sky-400 font-bold text-xs rounded">S</span>
            <h3 className="text-base font-bold text-sky-300">Situation (Current Clinical Problem)</h3>
          </div>
          <p className="text-sm text-slate-300 leading-relaxed">{currentRecord.situation}</p>
        </div>

        {/* Background */}
        <div className="bg-slate-800/70 p-5 rounded-xl border-l-4 border-indigo-500 border-t border-r border-b border-slate-700/60">
          <div className="flex items-center gap-2 mb-2">
            <span className="px-2 py-0.5 bg-indigo-500/20 text-indigo-400 font-bold text-xs rounded">B</span>
            <h3 className="text-base font-bold text-indigo-300">Background (History &amp; Context)</h3>
          </div>
          <p className="text-sm text-slate-300 leading-relaxed">{currentRecord.background}</p>
        </div>

        {/* Assessment */}
        <div className="bg-slate-800/70 p-5 rounded-xl border-l-4 border-amber-500 border-t border-r border-b border-slate-700/60">
          <div className="flex items-center gap-2 mb-2">
            <span className="px-2 py-0.5 bg-amber-500/20 text-amber-400 font-bold text-xs rounded">A</span>
            <h3 className="text-base font-bold text-amber-300">Assessment (Exam &amp; Findings)</h3>
          </div>
          <p className="text-sm text-slate-300 leading-relaxed">{currentRecord.assessment}</p>
          <div className="mt-3 p-3 bg-slate-900/80 rounded border border-slate-700/60 text-xs">
            <p className="text-amber-400 font-semibold mb-1">Critical Labs:</p>
            <p className="text-slate-300 font-mono">{currentRecord.criticalLabs}</p>
          </div>
        </div>

        {/* Recommendation */}
        <div className="bg-slate-800/70 p-5 rounded-xl border-l-4 border-emerald-500 border-t border-r border-b border-slate-700/60">
          <div className="flex items-center gap-2 mb-2">
            <span className="px-2 py-0.5 bg-emerald-500/20 text-emerald-400 font-bold text-xs rounded">R</span>
            <h3 className="text-base font-bold text-emerald-300">Recommendation (Action Plan)</h3>
          </div>
          <p className="text-sm text-slate-300 leading-relaxed">{currentRecord.recommendation}</p>
          <div className="mt-3 p-3 bg-slate-900/80 rounded border border-slate-700/60 text-xs">
            <p className="text-emerald-400 font-semibold mb-1">Invasive Lines &amp; Drains:</p>
            <p className="text-slate-300 font-mono">{currentRecord.linesDrains}</p>
          </div>
        </div>
      </div>

      {/* STAT Shift Action Checklist */}
      <div className="bg-slate-800/80 p-5 rounded-xl border border-slate-700">
        <h3 className="text-sm font-bold text-slate-200 mb-3 uppercase tracking-wider">Pending STAT Orders for Next Shift</h3>
        <div className="space-y-2">
          {currentRecord.pendingStatTasks.map((task, idx) => (
            <label key={idx} className="flex items-center gap-3 p-2.5 bg-slate-900/70 rounded hover:bg-slate-900 cursor-pointer">
              <input type="checkbox" className="rounded bg-slate-800 border-slate-600 text-sky-500 h-4 w-4" />
              <span className="text-xs text-slate-300 font-medium">{task}</span>
            </label>
          ))}
        </div>
      </div>
    </div>
  );
};
