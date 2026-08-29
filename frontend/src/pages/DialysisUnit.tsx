import React, { useState } from 'react';
import {
  Activity,
  HeartPulse,
  Droplets,
  AlertTriangle,
  CheckCircle2,
  Clock,
  User,
  Plus,
} from 'lucide-react';

interface DialysisSession {
  id: number;
  patientName: string;
  patientMrn: string;
  stationNumber: string;
  preWeightKg: number;
  dryWeightTargetKg: number;
  durationHours: number;
  bloodFlowRate: number; // mL/min
  dialysateFlowRate: number; // mL/min
  currentUfr: number; // mL/kg/hr
  vascularAccess: string;
  status: 'PRE_ASSESSMENT' | 'RUNNING' | 'RINSEBACK' | 'COMPLETED';
}

export const DialysisUnit: React.FC = () => {
  const [sessions, setSessions] = useState<DialysisSession[]>([
    {
      id: 1,
      patientName: 'Anand Patil',
      patientMrn: 'MRN-10001',
      stationNumber: 'Station 1 (High-Flux Polysulfone)',
      preWeightKg: 72.5,
      dryWeightTargetKg: 70.0,
      durationHours: 4.0,
      bloodFlowRate: 350,
      dialysateFlowRate: 600,
      currentUfr: 9.3,
      vascularAccess: 'Left Radio-Cephalic AV Fistula',
      status: 'RUNNING',
    },
    {
      id: 2,
      patientName: 'Kishore Kumar',
      patientMrn: 'MRN-10042',
      stationNumber: 'Station 2',
      preWeightKg: 65.0,
      dryWeightTargetKg: 63.5,
      durationHours: 3.5,
      bloodFlowRate: 300,
      dialysateFlowRate: 500,
      currentUfr: 7.5,
      vascularAccess: 'Right Internal Jugular Permcath',
      status: 'RUNNING',
    },
  ]);

  return (
    <div className="space-y-6">
      {/* Header */}
      <div className="flex flex-col sm:flex-row sm:items-center justify-between gap-4 bg-white p-6 rounded-3xl border border-slate-200 shadow-sm">
        <div>
          <h1 className="text-xl font-bold text-slate-900 tracking-tight flex items-center gap-2">
            <Droplets className="h-6 w-6 text-sky-600" />
            Nephrology & Renal Dialysis Workstation
          </h1>
          <p className="text-xs text-slate-500 mt-1">
            Hemodialysis prescription management, Ultrafiltration Rate (UFR) safety limits, and vascular access surveillance
          </p>
        </div>

        <div className="flex items-center gap-2 px-3 py-1.5 bg-emerald-50 border border-emerald-200 text-emerald-800 rounded-xl text-xs font-bold">
          <CheckCircle2 className="h-4 w-4 text-emerald-600" />
          <span>All Stations Within UFR Safety Limits (&le; 13 mL/kg/hr)</span>
        </div>
      </div>

      {/* Active Hemodialysis Stations */}
      <div className="grid grid-cols-1 lg:grid-cols-2 gap-6">
        {sessions.map((sess) => {
          const fluidOverload = (sess.preWeightKg - sess.dryWeightTargetKg).toFixed(1);
          return (
            <div
              key={sess.id}
              className="bg-white p-6 rounded-3xl border border-slate-200 shadow-sm space-y-4"
            >
              <div className="flex items-center justify-between pb-3 border-b border-slate-100">
                <div>
                  <span className="text-xs font-bold text-sky-700">{sess.stationNumber}</span>
                  <h3 className="text-sm font-bold text-slate-900 mt-0.5">
                    {sess.patientName}{' '}
                    <span className="font-mono text-xs font-normal text-slate-400">
                      ({sess.patientMrn})
                    </span>
                  </h3>
                </div>
                <span className="px-2.5 py-1 rounded-full text-[10px] font-bold bg-sky-100 text-sky-800">
                  {sess.status}
                </span>
              </div>

              <div className="grid grid-cols-2 sm:grid-cols-4 gap-3 text-xs">
                <div className="p-3 bg-slate-50 rounded-2xl">
                  <span className="text-slate-500 text-[10px] uppercase font-bold block">Pre-Weight</span>
                  <span className="text-slate-900 font-bold text-sm">{sess.preWeightKg} kg</span>
                </div>
                <div className="p-3 bg-slate-50 rounded-2xl">
                  <span className="text-slate-500 text-[10px] uppercase font-bold block">Dry Target</span>
                  <span className="text-slate-900 font-bold text-sm">{sess.dryWeightTargetKg} kg</span>
                </div>
                <div className="p-3 bg-sky-50 rounded-2xl">
                  <span className="text-sky-700 text-[10px] uppercase font-bold block">UF Goal</span>
                  <span className="text-sky-900 font-bold text-sm">{fluidOverload} Liters</span>
                </div>
                <div className="p-3 bg-emerald-50 rounded-2xl">
                  <span className="text-emerald-700 text-[10px] uppercase font-bold block">Calculated UFR</span>
                  <span className="text-emerald-900 font-bold text-sm">{sess.currentUfr} <span className="text-[10px]">mL/kg/h</span></span>
                </div>
              </div>

              <div className="pt-2 border-t border-slate-100 flex items-center justify-between text-xs text-slate-600">
                <span>Access: <strong className="text-slate-900">{sess.vascularAccess}</strong></span>
                <span>Qb: <strong>{sess.bloodFlowRate}</strong> • Qd: <strong>{sess.dialysateFlowRate}</strong> mL/min</span>
              </div>
            </div>
          );
        })}
      </div>
    </div>
  );
};
