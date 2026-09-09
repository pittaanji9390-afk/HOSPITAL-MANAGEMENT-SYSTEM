import React, { useState } from 'react';

interface RestraintRecord {
  patientId: string;
  patientName: string;
  room: string;
  restraintType: 'Non-Violent (Medical/Lines)' | 'Violent / Behavioral';
  orderStartTime: string;
  orderExpirationTime: string;
  lastCirculationCheck: string;
  lastRomHydrationOffered: string;
  limbColorWarmthNormal: boolean;
  behaviorJustification: string;
}

export const RestraintSeclusionAuditConsole: React.FC = () => {
  const [records, setRecords] = useState<RestraintRecord[]>([
    {
      patientId: 'PT-7712',
      patientName: 'Donald Draper',
      room: 'ICU-Bed-07',
      restraintType: 'Non-Violent (Medical/Lines)',
      orderStartTime: '2026-09-08 14:00',
      orderExpirationTime: '2026-09-09 14:00 (24h Limit)',
      lastCirculationCheck: '18:15 (Q2H)',
      lastRomHydrationOffered: '18:00 (Q2H)',
      limbColorWarmthNormal: true,
      behaviorJustification: 'Repeatedly attempting to pull endotracheal tube and left femoral arterial line.'
    }
  ]);

  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">Restraint &amp; Seclusion Patient Safety Monitor</h1>
          <p className="text-sm text-slate-400">CMS / Joint Commission 24-Hour Physician Renewal &amp; Q2H Circulation Flowsheet</p>
        </div>
      </header>

      <div className="space-y-6">
        {records.map((r) => (
          <div key={r.patientId} className="bg-slate-800/80 p-5 rounded-xl border border-slate-700">
            <div className="flex justify-between items-start mb-4">
              <div>
                <span className="text-xs font-mono text-rose-400 font-bold">{r.room} ({r.patientId})</span>
                <h2 className="text-lg font-bold text-white">{r.patientName}</h2>
                <p className="text-xs text-slate-400">Type: {r.restraintType}</p>
              </div>
              <span className="px-3 py-1 bg-amber-900/60 border border-amber-700 text-amber-300 text-xs font-semibold rounded">
                Order Active Until: {r.orderExpirationTime}
              </span>
            </div>

            <div className="p-3 bg-slate-900/80 rounded border border-slate-700/60 text-xs text-slate-300 mb-4">
              <p><strong className="text-amber-400">Clinical Justification:</strong> {r.behaviorJustification}</p>
            </div>

            <div className="grid grid-cols-1 md:grid-cols-3 gap-3 text-xs mb-4">
              <div className="p-3 bg-slate-900/60 rounded border border-slate-700/60">
                <span className="text-slate-400 block">Last Circulation / Pulse Check:</span>
                <span className="text-sm font-mono text-sky-300 font-bold">{r.lastCirculationCheck}</span>
              </div>
              <div className="p-3 bg-slate-900/60 rounded border border-slate-700/60">
                <span className="text-slate-400 block">Last ROM / Water Offered:</span>
                <span className="text-sm font-mono text-emerald-300 font-bold">{r.lastRomHydrationOffered}</span>
              </div>
              <div className="p-3 bg-slate-900/60 rounded border border-slate-700/60">
                <span className="text-slate-400 block">Distal Extremity Warmth:</span>
                <span className="text-sm font-mono text-slate-200 font-bold">{r.limbColorWarmthNormal ? 'Warm & Pink' : 'Pale / Cold'}</span>
              </div>
            </div>

            <div className="flex gap-3">
              <button className="bg-sky-600 hover:bg-sky-500 text-white text-xs font-semibold px-4 py-2 rounded">
                Log 2-Hour ROM &amp; Skin Assessment
              </button>
              <button className="bg-emerald-700 hover:bg-emerald-600 text-white text-xs font-semibold px-4 py-2 rounded">
                Trial Release / Discontinue Restraints
              </button>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};
