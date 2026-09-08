import React, { useState } from 'react';
import { Activity, Heart, Wind, AlertTriangle, ShieldCheck, Zap, Thermometer, Droplets } from 'lucide-react';

export const IcuCommandCenter: React.FC = () => {
  const [selectedBed, setSelectedBed] = useState('ICU-01');

  const beds = [
    { id: 'ICU-01', patient: 'Vikram Mehta (58M)', diagnosis: 'Septic Shock / ARDS', hr: 118, bp: '82/45 (57)', spo2: 91, lactate: 4.2, mews: 8, status: 'CRITICAL' },
    { id: 'ICU-02', patient: 'Pooja Iyer (42F)', diagnosis: 'Post-CABG Day 1', hr: 78, bp: '115/72 (86)', spo2: 99, lactate: 1.1, mews: 1, status: 'STABLE' },
    { id: 'ICU-03', patient: 'Anand Roy (67M)', diagnosis: 'Acute STEMI / Impella', hr: 94, bp: '102/60 (74)', spo2: 96, lactate: 2.1, mews: 4, status: 'GUARDED' },
    { id: 'ICU-04', patient: 'Sunita Rao (51F)', diagnosis: 'DKA / Acute Tubular Necrosis', hr: 104, bp: '98/62 (74)', spo2: 95, lactate: 3.4, mews: 5, status: 'HIGH RISK' },
  ];

  return (
    <div className="space-y-6">
      <div className="flex justify-between items-center bg-slate-900 text-white p-6 rounded-2xl shadow-xl border border-slate-800">
        <div>
          <div className="flex items-center gap-3">
            <Activity className="w-8 h-8 text-rose-500 animate-pulse" />
            <h1 className="text-2xl font-bold tracking-tight">ICU & Critical Care Command Center</h1>
          </div>
          <p className="text-slate-400 text-sm mt-1">Real-time Continuous Hemodynamic Surveillance & Multi-Organ Failure Tracking</p>
        </div>
        <div className="flex gap-4">
          <div className="bg-slate-800 px-4 py-2 rounded-xl border border-slate-700 text-center">
            <span className="text-xs text-slate-400 block">Occupancy</span>
            <span className="text-lg font-bold text-emerald-400">4 / 4 Beds</span>
          </div>
          <div className="bg-rose-950/60 border border-rose-800 px-4 py-2 rounded-xl text-center">
            <span className="text-xs text-rose-300 block">Active Code Sepsis</span>
            <span className="text-lg font-bold text-rose-400">1 Patient</span>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-4">
        {beds.map(bed => (
          <div
            key={bed.id}
            onClick={() => setSelectedBed(bed.id)}
            className={`p-5 rounded-2xl border cursor-pointer transition-all ${
              selectedBed === bed.id
                ? 'bg-slate-900 border-indigo-500 shadow-lg ring-2 ring-indigo-500/30'
                : 'bg-white hover:border-slate-400 border-slate-200 shadow-sm'
            }`}
          >
            <div className="flex justify-between items-center mb-2">
              <span className={`text-xs font-bold px-2.5 py-1 rounded-full ${
                selectedBed === bed.id ? 'bg-indigo-950 text-indigo-400' : 'bg-slate-100 text-slate-700'
              }`}>{bed.id}</span>
              <span className={`text-xs font-semibold px-2 py-0.5 rounded ${
                bed.status === 'CRITICAL' ? 'bg-rose-100 text-rose-800 border border-rose-200' : 'bg-emerald-100 text-emerald-800'
              }`}>{bed.status}</span>
            </div>
            <h3 className={`font-bold text-sm ${selectedBed === bed.id ? 'text-white' : 'text-slate-900'}`}>{bed.patient}</h3>
            <p className="text-xs text-slate-400 mb-3">{bed.diagnosis}</p>
            
            <div className="grid grid-cols-2 gap-2 text-xs">
              <div className="bg-slate-100 dark:bg-slate-800 p-2 rounded-lg">
                <span className="text-slate-400 block">HR / SpO2</span>
                <span className="font-bold text-slate-800 dark:text-slate-200">{bed.hr} bpm | {bed.spo2}%</span>
              </div>
              <div className="bg-slate-100 dark:bg-slate-800 p-2 rounded-lg">
                <span className="text-slate-400 block">BP (MAP)</span>
                <span className="font-bold text-slate-800 dark:text-slate-200">{bed.bp}</span>
              </div>
            </div>
          </div>
        ))}
      </div>

      <div className="bg-white rounded-2xl border border-slate-200 shadow-sm p-6">
        <h2 className="text-lg font-bold text-slate-900 mb-4 flex items-center gap-2">
          <Zap className="w-5 h-5 text-indigo-600" />
          Active Hemodynamic Interventions ({selectedBed})
        </h2>
        <div className="grid grid-cols-1 md:grid-cols-3 gap-4">
          <div className="border border-slate-200 p-4 rounded-xl bg-slate-50">
            <h4 className="text-xs font-bold text-slate-500 uppercase">Vasopressor Infusion</h4>
            <p className="text-base font-bold text-slate-900 mt-1">Norepinephrine @ 0.35 mcg/kg/min</p>
            <span className="text-xs text-emerald-600 block mt-1">Titrating for MAP &gt;= 65 mmHg</span>
          </div>
          <div className="border border-slate-200 p-4 rounded-xl bg-slate-50">
            <h4 className="text-xs font-bold text-slate-500 uppercase">Mechanical Ventilation</h4>
            <p className="text-base font-bold text-slate-900 mt-1">PRVC: TV 420 mL, PEEP 12, FiO2 60%</p>
            <span className="text-xs text-slate-500 block mt-1">Plateau Pressure: 24 cmH2O</span>
          </div>
          <div className="border border-slate-200 p-4 rounded-xl bg-slate-50">
            <h4 className="text-xs font-bold text-slate-500 uppercase">Continuous Dialysis (CRRT)</h4>
            <p className="text-base font-bold text-slate-900 mt-1">CVVHDF: Effluent Rate 25 mL/kg/hr</p>
            <span className="text-xs text-indigo-600 block mt-1">Regional Citrate Anticoagulation</span>
          </div>
        </div>
      </div>
    </div>
  );
};
