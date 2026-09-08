import React, { useState } from 'react';

interface TelemetryStrip {
  id: string;
  bed: string;
  patientName: string;
  rhythm: string;
  heartRateBpm: number;
  prIntervalMs: number;
  qrsDurationMs: number;
  qtcIntervalMs: number;
  ectopyEventsPerHour: number;
  alarmStatus: 'NORMAL' | 'WARNING' | 'CRITICAL';
}

export const TelemetryArrhythmiaLogConsole: React.FC = () => {
  const [teleStrips, setTeleStrips] = useState<TelemetryStrip[]>([
    {
      id: 'TEL-01',
      bed: 'TELE-Bed-01',
      patientName: 'Walter White',
      rhythm: 'Atrial Fibrillation with Rapid Ventricular Response (RVR)',
      heartRateBpm: 134,
      prIntervalMs: 0,
      qrsDurationMs: 88,
      qtcIntervalMs: 440,
      ectopyEventsPerHour: 18,
      alarmStatus: 'CRITICAL'
    },
    {
      id: 'TEL-02',
      bed: 'TELE-Bed-02',
      patientName: 'Jesse Pinkman',
      rhythm: 'Normal Sinus Rhythm with Prolonged QTc',
      heartRateBpm: 72,
      prIntervalMs: 160,
      qrsDurationMs: 92,
      qtcIntervalMs: 512,
      ectopyEventsPerHour: 2,
      alarmStatus: 'WARNING'
    }
  ]);

  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">Continuous Telemetry &amp; Arrhythmia Log</h1>
          <p className="text-sm text-slate-400">Real-time Cardiac Rhythm Strips, QTc Prolongation Alerts &amp; Ectopy Counters</p>
        </div>
      </header>

      <div className="grid grid-cols-1 lg:grid-cols-2 gap-6">
        {teleStrips.map((strip) => (
          <div key={strip.id} className="bg-slate-800/80 p-5 rounded-xl border border-slate-700">
            <div className="flex justify-between items-start mb-3">
              <div>
                <span className="text-xs font-mono text-sky-400 font-bold">{strip.bed}</span>
                <h2 className="text-lg font-bold text-white">{strip.patientName}</h2>
              </div>
              <span className={`px-3 py-1 rounded text-xs font-bold font-mono ${strip.alarmStatus === 'CRITICAL' ? 'bg-rose-900/80 text-rose-300 border border-rose-600 animate-pulse' : strip.alarmStatus === 'WARNING' ? 'bg-amber-900/80 text-amber-300 border border-amber-600' : 'bg-emerald-900/80 text-emerald-300'}`}>
                {strip.alarmStatus} ALARM
              </span>
            </div>

            <div className="p-3 bg-slate-950 rounded-lg border border-slate-800 font-mono text-emerald-400 mb-4">
              <div className="flex justify-between items-center mb-1">
                <span className="text-xs text-slate-400">Rhythm:</span>
                <span className="text-sm font-bold text-slate-100">{strip.rhythm}</span>
              </div>
              <div className="h-12 flex items-center justify-center border-y border-emerald-900/50 my-2 text-xs text-emerald-500 tracking-widest">
                /_/__/__//_/__/__ (SIMULATED LEAD II ECG STRIP)
              </div>
            </div>

            <div className="grid grid-cols-4 gap-2 text-center font-mono text-xs mb-4">
              <div className="bg-slate-900/70 p-2 rounded border border-slate-700/60">
                <span className="text-slate-400 block">HR</span>
                <span className="text-sm font-bold text-white">{strip.heartRateBpm} bpm</span>
              </div>
              <div className="bg-slate-900/70 p-2 rounded border border-slate-700/60">
                <span className="text-slate-400 block">PR</span>
                <span className="text-sm font-bold text-slate-200">{strip.prIntervalMs} ms</span>
              </div>
              <div className="bg-slate-900/70 p-2 rounded border border-slate-700/60">
                <span className="text-slate-400 block">QRS</span>
                <span className="text-sm font-bold text-slate-200">{strip.qrsDurationMs} ms</span>
              </div>
              <div className="bg-slate-900/70 p-2 rounded border border-slate-700/60">
                <span className="text-slate-400 block">QTc</span>
                <span className={`text-sm font-bold ${strip.qtcIntervalMs > 500 ? 'text-rose-400' : 'text-slate-200'}`}>{strip.qtcIntervalMs} ms</span>
              </div>
            </div>

            <div className="flex gap-2">
              <button className="flex-1 bg-slate-700 hover:bg-slate-600 text-white text-xs font-semibold py-2 rounded">
                Print 6-Second Strip
              </button>
              <button className="flex-1 bg-sky-600 hover:bg-sky-500 text-white text-xs font-semibold py-2 rounded">
                Acknowledge Alarm
              </button>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};
