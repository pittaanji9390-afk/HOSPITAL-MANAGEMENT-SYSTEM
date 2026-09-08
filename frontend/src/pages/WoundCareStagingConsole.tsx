import React, { useState } from 'react';

interface WoundAssessment {
  woundId: string;
  location: string;
  stage: string;
  lengthCm: number;
  widthCm: number;
  depthCm: number;
  tunnelingClock: string;
  exudateType: string;
  exudateAmount: string;
  tissueBase: string; // Granulation, Slough, Eschar
  currentDressing: string;
  nextChangeDue: string;
  pushToolScore: number;
}

export const WoundCareStagingConsole: React.FC = () => {
  const [wounds, setWounds] = useState<WoundAssessment[]>([
    {
      woundId: 'WND-01',
      location: 'Sacrum / Coccyx',
      stage: 'Stage 3 Pressure Injury',
      lengthCm: 3.5,
      widthCm: 2.8,
      depthCm: 0.6,
      tunnelingClock: '2 cm at 11 o'clock',
      exudateType: 'Serosanguinous',
      exudateAmount: 'Moderate',
      tissueBase: '70% Granulation, 30% Slough',
      currentDressing: 'Silver Alginate + Hydrocellular Foam bordered',
      nextChangeDue: 'Tomorrow 08:00 (Q48H)',
      pushToolScore: 11
    },
    {
      woundId: 'WND-02',
      location: 'Left Lateral Malleolus',
      stage: 'Stage 2 Pressure Injury',
      lengthCm: 1.2,
      widthCm: 0.8,
      depthCm: 0.1,
      tunnelingClock: 'None',
      exudateType: 'Serous',
      exudateAmount: 'Scant',
      tissueBase: '100% Granulation',
      currentDressing: 'Hydrocolloid Dressing',
      nextChangeDue: 'Day after tomorrow (Q72H)',
      pushToolScore: 5
    }
  ]);

  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">Pressure Injury Staging &amp; PUSH Score Console</h1>
          <p className="text-sm text-slate-400">National Pressure Injury Advisory Panel (NPIAP) Staging &amp; Dressing Regimen Tracker</p>
        </div>
        <button className="bg-sky-600 hover:bg-sky-500 text-white px-4 py-2 rounded text-sm font-semibold">
          + Add New Wound Assessment
        </button>
      </header>

      <div className="grid grid-cols-1 lg:grid-cols-2 gap-6">
        {wounds.map((w) => (
          <div key={w.woundId} className="bg-slate-800/80 p-5 rounded-xl border border-slate-700">
            <div className="flex justify-between items-start mb-3">
              <div>
                <span className="text-xs font-mono text-amber-400 font-bold">{w.woundId}</span>
                <h2 className="text-lg font-bold text-slate-100">{w.location}</h2>
              </div>
              <span className="px-3 py-1 bg-rose-900/60 border border-rose-700 text-rose-300 text-xs font-semibold rounded">
                {w.stage}
              </span>
            </div>

            <div className="grid grid-cols-3 gap-3 mb-4 bg-slate-900/80 p-3 rounded-lg border border-slate-700/60 text-center font-mono">
              <div>
                <span className="text-xs text-slate-400 block">Length × Width</span>
                <span className="text-sm text-sky-300 font-bold">{w.lengthCm} × {w.widthCm} cm</span>
              </div>
              <div>
                <span className="text-xs text-slate-400 block">Depth</span>
                <span className="text-sm text-sky-300 font-bold">{w.depthCm} cm</span>
              </div>
              <div>
                <span className="text-xs text-slate-400 block">PUSH Tool Score</span>
                <span className="text-sm text-amber-400 font-bold">{w.pushToolScore} / 17</span>
              </div>
            </div>

            <div className="space-y-2 text-xs text-slate-300 mb-4">
              <p><strong className="text-slate-400">Tunneling / Undermining:</strong> {w.tunnelingClock}</p>
              <p><strong className="text-slate-400">Wound Bed Composition:</strong> {w.tissueBase}</p>
              <p><strong className="text-slate-400">Exudate Characteristics:</strong> {w.exudateAmount} {w.exudateType}</p>
              <p><strong className="text-slate-400">Active Dressing Regimen:</strong> {w.currentDressing}</p>
              <p><strong className="text-emerald-400">Next Dressing Change:</strong> {w.nextChangeDue}</p>
            </div>

            <div className="flex gap-2">
              <button className="flex-1 bg-slate-700 hover:bg-slate-600 text-white text-xs font-semibold py-2 rounded">
                Log Dressing Change
              </button>
              <button className="flex-1 bg-sky-700 hover:bg-sky-600 text-white text-xs font-semibold py-2 rounded">
                Upload Wound Photo
              </button>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};
