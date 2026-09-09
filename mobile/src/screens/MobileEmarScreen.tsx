import React, { useState } from 'react';
import {
  Pill,
  Barcode,
  CheckCircle2,
  AlertTriangle,
  Clock,
  ShieldCheck,
} from 'lucide-react';

export const MobileEmarScreen: React.FC = () => {
  const [meds, setMeds] = useState([
    {
      id: 1,
      patientName: 'Anand Patil',
      bed: 'CCU-301 / Bed 1',
      medication: 'Telma 40 (Telmisartan 40mg)',
      route: 'Oral (1 Tab)',
      time: '08:00 AM',
      given: true,
    },
    {
      id: 2,
      patientName: 'Anand Patil',
      bed: 'CCU-301 / Bed 1',
      medication: 'Atorva 80 (Atorvastatin 80mg)',
      route: 'Oral (1 Tab)',
      time: '10:00 PM',
      given: false,
    },
    {
      id: 3,
      patientName: 'Deepa Rao',
      bed: 'FGW-102 / Bed 4',
      medication: 'Augmentin 625 (Amox-Clav)',
      route: 'Oral (1 Tab)',
      time: '02:00 PM',
      given: false,
    },
  ]);

  const markGiven = (id: number) => {
    setMeds(meds.map((m) => (m.id === id ? { ...m, given: true } : m)));
  };

  return (
    <div className="space-y-4 pb-20">
      {/* Header */}
      <div className="p-4 bg-slate-800/80 border border-slate-700/80 rounded-2xl flex items-center justify-between">
        <div>
          <h2 className="text-sm font-bold text-white flex items-center gap-2">
            <Pill className="h-4 w-4 text-emerald-400" />
            Mobile eMAR Dosing Station
          </h2>
          <p className="text-[11px] text-slate-400 mt-0.5">5 Rights Barcode Verification</p>
        </div>
        <button className="p-2.5 bg-emerald-600 active:bg-emerald-500 rounded-xl text-white shadow-lg">
          <Barcode className="h-5 w-5" />
        </button>
      </div>

      {/* Medication List */}
      <div className="space-y-3">
        {meds.map((m) => (
          <div
            key={m.id}
            className={`p-4 rounded-2xl border ${
              m.given
                ? 'bg-emerald-950/30 border-emerald-800/50'
                : 'bg-slate-800 border-slate-700/80'
            } space-y-2.5 text-xs`}
          >
            <div className="flex items-start justify-between">
              <div>
                <span className="text-[10px] font-bold text-sky-400 block">{m.bed}</span>
                <h3 className="text-sm font-bold text-white mt-0.5">{m.patientName}</h3>
              </div>
              <span className={`px-2 py-0.5 rounded text-[10px] font-bold ${m.given ? 'bg-emerald-900 text-emerald-300' : 'bg-amber-900 text-amber-300'}`}>
                {m.given ? 'Administered' : 'Due ' + m.time}
              </span>
            </div>

            <div className="p-2.5 bg-slate-900/80 rounded-xl border border-slate-800">
              <p className="font-bold text-white">{m.medication}</p>
              <span className="text-[11px] text-slate-400">{m.route}</span>
            </div>

            {!m.given && (
              <button
                onClick={() => markGiven(m.id)}
                className="w-full py-2 bg-emerald-600 active:bg-emerald-500 text-white rounded-xl font-bold text-xs flex items-center justify-center gap-1.5 shadow-md"
              >
                <ShieldCheck className="h-4 w-4" />
                Scan Barcode & Administer
              </button>
            )}
          </div>
        ))}
      </div>
    </div>
  );
};
