import React, { useState } from 'react';

interface HourlyFluidEntry {
  hour: string;
  ivInfusionMl: number;
  enteralMl: number;
  bloodProductsMl: number;
  urineMl: number;
  ngDrainageMl: number;
  woundDrainMl: number;
  sbp: number;
  dbp: number;
  hr: number;
  tempC: number;
}

export const InpatientVitalsFluidBalanceConsole: React.FC = () => {
  const [entries, setEntries] = useState<HourlyFluidEntry[]>([
    { hour: '00:00', ivInfusionMl: 100, enteralMl: 50, bloodProductsMl: 0, urineMl: 65, ngDrainageMl: 20, woundDrainMl: 10, sbp: 120, dbp: 74, hr: 78, tempC: 37.1 },
    { hour: '01:00', ivInfusionMl: 100, enteralMl: 50, bloodProductsMl: 0, urineMl: 55, ngDrainageMl: 15, woundDrainMl: 10, sbp: 118, dbp: 72, hr: 76, tempC: 37.0 },
    { hour: '02:00', ivInfusionMl: 100, enteralMl: 50, bloodProductsMl: 0, urineMl: 70, ngDrainageMl: 25, woundDrainMl: 15, sbp: 122, dbp: 75, hr: 80, tempC: 37.2 },
    { hour: '03:00', ivInfusionMl: 125, enteralMl: 50, bloodProductsMl: 0, urineMl: 60, ngDrainageMl: 10, woundDrainMl: 5, sbp: 116, dbp: 70, hr: 74, tempC: 36.9 },
    { hour: '04:00', ivInfusionMl: 125, enteralMl: 50, bloodProductsMl: 0, urineMl: 50, ngDrainageMl: 30, woundDrainMl: 10, sbp: 124, dbp: 78, hr: 82, tempC: 37.3 },
    { hour: '05:00', ivInfusionMl: 125, enteralMl: 50, bloodProductsMl: 0, urineMl: 80, ngDrainageMl: 20, woundDrainMl: 10, sbp: 120, dbp: 76, hr: 78, tempC: 37.1 }
  ]);

  const totalIntake = entries.reduce((sum, e) => sum + e.ivInfusionMl + e.enteralMl + e.bloodProductsMl, 0);
  const totalOutput = entries.reduce((sum, e) => sum + e.urineMl + e.ngDrainageMl + e.woundDrainMl, 0);
  const netBalance = totalIntake - totalOutput;

  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">24-Hour Fluid Balance &amp; Hemodynamics Flowsheet</h1>
          <p className="text-sm text-slate-400">Real-time ICU Intake/Output (I&amp;O) Calculation and Fluid Overload Monitoring</p>
        </div>
        <div className="flex gap-4">
          <div className="bg-slate-800 px-4 py-2 rounded-lg border border-slate-700 text-right">
            <span className="text-xs text-slate-400 block">Total Intake:</span>
            <span className="text-base font-mono font-bold text-sky-400">+{totalIntake} mL</span>
          </div>
          <div className="bg-slate-800 px-4 py-2 rounded-lg border border-slate-700 text-right">
            <span className="text-xs text-slate-400 block">Total Output:</span>
            <span className="text-base font-mono font-bold text-amber-400">-{totalOutput} mL</span>
          </div>
          <div className="bg-slate-800 px-4 py-2 rounded-lg border border-slate-700 text-right">
            <span className="text-xs text-slate-400 block">Net Balance:</span>
            <span className={`text-base font-mono font-bold ${netBalance >= 0 ? 'text-emerald-400' : 'text-rose-400'}`}>
              {netBalance >= 0 ? `+${netBalance}` : netBalance} mL
            </span>
          </div>
        </div>
      </header>

      {/* Hourly Flowsheet Table */}
      <div className="bg-slate-800/80 rounded-xl border border-slate-700 overflow-x-auto">
        <table className="w-full text-left text-xs text-slate-300">
          <thead className="bg-slate-950 text-slate-400 uppercase font-mono">
            <tr>
              <th className="p-3">Hour</th>
              <th className="p-3 text-sky-400">IV (mL)</th>
              <th className="p-3 text-sky-400">Enteral (mL)</th>
              <th className="p-3 text-amber-400">Urine (mL)</th>
              <th className="p-3 text-amber-400">NG/Drain (mL)</th>
              <th className="p-3 text-emerald-400">Net (mL)</th>
              <th className="p-3">BP (mmHg)</th>
              <th className="p-3">HR (bpm)</th>
              <th className="p-3">Temp (°C)</th>
            </tr>
          </thead>
          <tbody className="divide-y divide-slate-700/60 font-mono">
            {entries.map((row, idx) => {
              const rowIntake = row.ivInfusionMl + row.enteralMl + row.bloodProductsMl;
              const rowOutput = row.urineMl + row.ngDrainageMl + row.woundDrainMl;
              const rowNet = rowIntake - rowOutput;
              return (
                <tr key={idx} className="hover:bg-slate-800/50">
                  <td className="p-3 font-bold text-white">{row.hour}</td>
                  <td className="p-3 text-sky-300">{row.ivInfusionMl}</td>
                  <td className="p-3 text-sky-300">{row.enteralMl}</td>
                  <td className="p-3 text-amber-300">{row.urineMl}</td>
                  <td className="p-3 text-amber-300">{row.ngDrainageMl + row.woundDrainMl}</td>
                  <td className={`p-3 font-bold ${rowNet >= 0 ? 'text-emerald-400' : 'text-rose-400'}`}>
                    {rowNet >= 0 ? `+${rowNet}` : rowNet}
                  </td>
                  <td className="p-3 text-slate-200">{row.sbp}/{row.dbp}</td>
                  <td className="p-3 text-slate-200">{row.hr}</td>
                  <td className="p-3 text-slate-200">{row.tempC}</td>
                </tr>
              );
            })}
          </tbody>
        </table>
      </div>
    </div>
  );
};
