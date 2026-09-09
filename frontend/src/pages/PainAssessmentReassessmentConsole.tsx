import React, { useState } from 'react';

interface PainEntry {
  id: string;
  patientName: string;
  bed: string;
  scaleUsed: 'NRS' | 'CPOT' | 'FLACC' | 'PAINAD';
  baselineScore: number;
  maxScaleScore: number;
  interventionType: string;
  administeredAt: string;
  reassessmentDueAt: string;
  reassessedScore: number | null;
  status: 'PENDING_REASSESSMENT' | 'COMPLETED' | 'OVERDUE';
}

export const PainAssessmentReassessmentConsole: React.FC = () => {
  const [entries, setEntries] = useState<PainEntry[]>([
    {
      id: 'PAIN-101',
      patientName: 'Samuel Jackson',
      bed: 'PACU-02',
      scaleUsed: 'NRS',
      baselineScore: 8,
      maxScaleScore: 10,
      interventionType: 'Fentanyl 50 mcg IV Push',
      administeredAt: '18:15',
      reassessmentDueAt: '18:45',
      reassessedScore: null,
      status: 'PENDING_REASSESSMENT'
    },
    {
      id: 'PAIN-102',
      patientName: 'Maria Garcia (Intubated)',
      bed: 'ICU-Bed-03',
      scaleUsed: 'CPOT',
      baselineScore: 6,
      maxScaleScore: 8,
      interventionType: 'Hydromorphone 0.5 mg IV Push + Repositioning',
      administeredAt: '17:30',
      reassessmentDueAt: '18:00',
      reassessedScore: 2,
      status: 'COMPLETED'
    }
  ]);

  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">Pain Assessment &amp; 30-Minute Reassessment Tracker</h1>
          <p className="text-sm text-slate-400">JCI / Joint Commission Mandatory Pain Reassessment Timing &amp; CPOT Scoring</p>
        </div>
      </header>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
        {entries.map((item) => (
          <div key={item.id} className="bg-slate-800/80 p-5 rounded-xl border border-slate-700">
            <div className="flex justify-between items-start mb-3">
              <div>
                <span className="text-xs font-mono text-sky-400 font-bold">{item.bed}</span>
                <h2 className="text-lg font-bold text-white">{item.patientName}</h2>
              </div>
              <span className={`px-3 py-1 rounded text-xs font-bold ${item.status === 'COMPLETED' ? 'bg-emerald-900/60 text-emerald-300 border border-emerald-700' : 'bg-amber-900/60 text-amber-300 border border-amber-700'}`}>
                {item.status.replace('_', ' ')}
              </span>
            </div>

            <div className="bg-slate-900/80 p-3 rounded-lg border border-slate-700/60 mb-4 flex justify-between items-center font-mono">
              <div>
                <span className="text-xs text-slate-400 block">Baseline ({item.scaleUsed})</span>
                <span className="text-xl font-bold text-rose-400">{item.baselineScore} / {item.maxScaleScore}</span>
              </div>
              <div className="text-center">
                <span className="text-xs text-slate-400 block">Given At / Due At</span>
                <span className="text-xs text-slate-200">{item.administeredAt} ➔ {item.reassessmentDueAt}</span>
              </div>
              <div className="text-right">
                <span className="text-xs text-slate-400 block">Post-Score</span>
                <span className="text-xl font-bold text-emerald-400">{item.reassessedScore !== null ? item.reassessedScore : '--'}</span>
              </div>
            </div>

            <p className="text-xs text-slate-300 mb-4">
              <strong className="text-slate-400">Intervention Administered:</strong> {item.interventionType}
            </p>

            {item.status === 'PENDING_REASSESSMENT' ? (
              <div className="flex gap-2">
                <button className="flex-1 bg-emerald-600 hover:bg-emerald-500 text-white text-xs font-semibold py-2 rounded">
                  Record 30-Min Reassessment Score
                </button>
              </div>
            ) : (
              <div className="p-2 bg-emerald-950/40 border border-emerald-800 rounded text-center text-xs text-emerald-300">
                Pain successfully reassessed and documented.
              </div>
            )}
          </div>
        ))}
      </div>
    </div>
  );
};
