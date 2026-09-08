import React, { useState } from 'react';

interface CentralLineAudit {
  lineId: string;
  patientId: string;
  lineType: string;
  insertionSite: string;
  insertionDate: string;
  daysInPlace: number;
  dailyNecessityConfirmed: boolean;
  dressingIntactClean: boolean;
  chlorhexidineBiopatchPresent: boolean;
  lumenCapsScrubbed15Sec: boolean;
  bloodAspirationFlushingNormal: boolean;
}

export const CentralLineCareBundleConsole: React.FC = () => {
  const [lines, setLines] = useState<CentralLineAudit[]>([
    {
      lineId: 'CVC-901',
      patientId: 'PT-ICU-8821',
      lineType: 'Triple Lumen CVC 7Fr',
      insertionSite: 'Right Internal Jugular',
      insertionDate: '2026-09-04',
      daysInPlace: 4,
      dailyNecessityConfirmed: true,
      dressingIntactClean: true,
      chlorhexidineBiopatchPresent: true,
      lumenCapsScrubbed15Sec: true,
      bloodAspirationFlushingNormal: true
    },
    {
      lineId: 'PICC-402',
      patientId: 'PT-MED-4412',
      lineType: 'Dual Lumen PICC 5Fr',
      insertionSite: 'Right Basilic Vein',
      insertionDate: '2026-08-28',
      daysInPlace: 11,
      dailyNecessityConfirmed: true,
      dressingIntactClean: false,
      chlorhexidineBiopatchPresent: true,
      lumenCapsScrubbed15Sec: true,
      bloodAspirationFlushingNormal: true
    }
  ]);

  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">CLABSI Prevention &amp; Central Line Bundle Console</h1>
          <p className="text-sm text-slate-400">CDC/NHSN Central Line Maintenance Checklist and Line Age Auditing</p>
        </div>
      </header>

      <div className="space-y-6">
        {lines.map((line) => (
          <div key={line.lineId} className="bg-slate-800/80 p-5 rounded-xl border border-slate-700">
            <div className="flex justify-between items-start mb-4">
              <div>
                <span className="text-xs font-mono text-sky-400 font-bold">{line.lineId} ({line.patientId})</span>
                <h2 className="text-lg font-bold text-white">{line.lineType} - {line.insertionSite}</h2>
                <p className="text-xs text-slate-400">Inserted on {line.insertionDate} ({line.daysInPlace} Days in Place)</p>
              </div>
              <span className={`px-3 py-1 rounded text-xs font-bold ${line.daysInPlace > 7 ? 'bg-amber-900/70 text-amber-300 border border-amber-600' : 'bg-emerald-900/70 text-emerald-300 border border-emerald-600'}`}>
                {line.daysInPlace > 7 ? 'High Line Age Warning' : 'Line Age Acceptable'}
              </span>
            </div>

            {/* Bundle Compliance Checklist */}
            <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-3 text-xs mb-4">
              <div className="flex items-center gap-2 p-3 bg-slate-900/80 rounded border border-slate-700/60">
                <input type="checkbox" checked={line.dailyNecessityConfirmed} readOnly className="accent-emerald-500" />
                <span className="text-slate-300">Daily Necessity Re-evaluated</span>
              </div>
              <div className="flex items-center gap-2 p-3 bg-slate-900/80 rounded border border-slate-700/60">
                <input type="checkbox" checked={line.dressingIntactClean} readOnly className="accent-emerald-500" />
                <span className={line.dressingIntactClean ? 'text-slate-300' : 'text-rose-400 font-bold'}>
                  Dressing Intact &amp; Clean ({line.dressingIntactClean ? 'OK' : 'CHANGE REQUIRED'})
                </span>
              </div>
              <div className="flex items-center gap-2 p-3 bg-slate-900/80 rounded border border-slate-700/60">
                <input type="checkbox" checked={line.chlorhexidineBiopatchPresent} readOnly className="accent-emerald-500" />
                <span className="text-slate-300">CHG Biopatch Present</span>
              </div>
              <div className="flex items-center gap-2 p-3 bg-slate-900/80 rounded border border-slate-700/60">
                <input type="checkbox" checked={line.lumenCapsScrubbed15Sec} readOnly className="accent-emerald-500" />
                <span className="text-slate-300">Hub Scrubbed 15s with Alcohol</span>
              </div>
              <div className="flex items-center gap-2 p-3 bg-slate-900/80 rounded border border-slate-700/60">
                <input type="checkbox" checked={line.bloodAspirationFlushingNormal} readOnly className="accent-emerald-500" />
                <span className="text-slate-300">Flushes &amp; Aspirates Patent</span>
              </div>
            </div>

            <div className="flex gap-3">
              <button className="bg-sky-600 hover:bg-sky-500 text-white text-xs font-semibold px-4 py-2 rounded">
                Perform Daily Bundle Audit
              </button>
              <button className="bg-rose-700 hover:bg-rose-600 text-white text-xs font-semibold px-4 py-2 rounded">
                Order Line Removal / DC
              </button>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};
