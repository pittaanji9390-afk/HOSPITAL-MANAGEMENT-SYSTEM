import React, { useState } from 'react';

interface GlucoseLogEntry {
  time: string;
  mealTiming: 'Fasting' | 'Pre-Lunch' | 'Pre-Dinner' | 'Bedtime (HS)';
  glucoseMgDl: number;
  slidingScaleUnits: number;
  basalGivenUnits: number;
  carbIntakeGrams: number;
  administeredBy: string;
}

export const BloodGlucoseInsulinSlidingScaleConsole: React.FC = () => {
  const [scaleTier, setScaleTier] = useState<'LOW' | 'MODERATE' | 'HIGH'>('MODERATE');
  const [currentGlucose, setCurrentGlucose] = useState<number>(245);
  const [logs, setLogs] = useState<GlucoseLogEntry[]>([
    { time: '07:30', mealTiming: 'Fasting', glucoseMgDl: 182, slidingScaleUnits: 2, basalGivenUnits: 20, carbIntakeGrams: 45, administeredBy: 'Nurse S. Patel' },
    { time: '12:00', mealTiming: 'Pre-Lunch', glucoseMgDl: 245, slidingScaleUnits: 6, basalGivenUnits: 0, carbIntakeGrams: 60, administeredBy: 'Nurse S. Patel' }
  ]);

  // Calculate units based on tier
  const calculateUnits = (bg: number, tier: 'LOW' | 'MODERATE' | 'HIGH') => {
    if (bg < 150) return 0;
    if (bg <= 199) return tier === 'LOW' ? 1 : tier === 'MODERATE' ? 2 : 4;
    if (bg <= 249) return tier === 'LOW' ? 3 : tier === 'MODERATE' ? 4 : 6;
    if (bg <= 299) return tier === 'LOW' ? 5 : tier === 'MODERATE' ? 6 : 8;
    if (bg <= 349) return tier === 'LOW' ? 7 : tier === 'MODERATE' ? 8 : 10;
    return tier === 'LOW' ? 8 : tier === 'MODERATE' ? 10 : 12; // >= 350 Call MD
  };

  const calculatedDose = calculateUnits(currentGlucose, scaleTier);

  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">Point-of-Care Glucose &amp; Insulin Sliding Scale Calculator</h1>
          <p className="text-sm text-slate-400">Correctional Insulin Lispro/Aspart Dosing &amp; Hypoglycemia Rule-of-15 Protocol</p>
        </div>
      </header>

      {/* Calculator Widget */}
      <div className="bg-slate-800/90 p-5 rounded-xl border border-slate-700 mb-6">
        <h2 className="text-base font-bold text-sky-300 mb-4">Correctional Dose Calculator</h2>
        <div className="grid grid-cols-1 md:grid-cols-3 gap-4 items-center">
          <div>
            <label className="text-xs text-slate-400 block mb-1">POC Blood Glucose (mg/dL)</label>
            <input 
              type="number" 
              value={currentGlucose} 
              onChange={(e) => setCurrentGlucose(parseInt(e.target.value) || 0)}
              className="w-full bg-slate-900 border border-slate-700 rounded px-3 py-2 text-lg font-mono font-bold text-white"
            />
          </div>
          <div>
            <label className="text-xs text-slate-400 block mb-1">Sliding Scale Sensitivity Tier</label>
            <select 
              value={scaleTier} 
              onChange={(e) => setScaleTier(e.target.value as any)}
              className="w-full bg-slate-900 border border-slate-700 rounded px-3 py-2 text-sm text-slate-200"
            >
              <option value="LOW">Low Sensitivity (Insulin Sensitive)</option>
              <option value="MODERATE">Moderate Sensitivity (Standard Adult)</option>
              <option value="HIGH">High Sensitivity (Insulin Resistant / Steroids)</option>
            </select>
          </div>
          <div className="p-4 bg-slate-950 rounded-lg border border-slate-800 text-center">
            <span className="text-xs text-slate-400 block">Recommended Rapid-Acting Insulin:</span>
            <span className="text-2xl font-mono font-bold text-emerald-400">{calculatedDose} Units SubQ</span>
            {currentGlucose >= 350 && (
              <span className="text-xs text-rose-400 font-bold block mt-1">ALERT: BG &gt;= 350, Call Provider STAT!</span>
            )}
          </div>
        </div>
      </div>

      {/* Log History */}
      <div className="bg-slate-800/80 rounded-xl border border-slate-700 overflow-hidden">
        <div className="p-4 border-b border-slate-700">
          <h3 className="text-sm font-bold text-slate-200">Today's POC Blood Glucose &amp; Insulin Administration Log</h3>
        </div>
        <table className="w-full text-left text-xs text-slate-300 font-mono">
          <thead className="bg-slate-950 text-slate-400 uppercase">
            <tr>
              <th className="p-3">Time</th>
              <th className="p-3">Meal Slot</th>
              <th className="p-3">Glucose</th>
              <th className="p-3 text-emerald-400">Sliding Scale Dose</th>
              <th className="p-3 text-sky-400">Basal Glargine</th>
              <th className="p-3">Administered By</th>
            </tr>
          </thead>
          <tbody className="divide-y divide-slate-700/60">
            {logs.map((row, idx) => (
              <tr key={idx} className="hover:bg-slate-800/50">
                <td className="p-3 font-bold text-white">{row.time}</td>
                <td className="p-3 text-slate-300">{row.mealTiming}</td>
                <td className="p-3 text-amber-300 font-bold">{row.glucoseMgDl} mg/dL</td>
                <td className="p-3 text-emerald-400 font-bold">{row.slidingScaleUnits} Units</td>
                <td className="p-3 text-sky-300">{row.basalGivenUnits} Units</td>
                <td className="p-3 text-slate-400">{row.administeredBy}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};
