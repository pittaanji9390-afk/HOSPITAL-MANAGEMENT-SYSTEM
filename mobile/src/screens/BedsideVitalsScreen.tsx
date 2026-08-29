import React, { useState } from 'react';
import {
  HeartPulse,
  Activity,
  AlertTriangle,
  CheckCircle2,
  Barcode,
  Save,
  Thermometer,
  Wind,
} from 'lucide-react';

export const BedsideVitalsScreen: React.FC = () => {
  const [patientMrn, setPatientMrn] = useState('MRN-10001');
  const [patientName, setPatientName] = useState('Anand Patil (CCU-301 / Bed 1)');
  const [sbp, setSbp] = useState(120);
  const [dbp, setDbp] = useState(80);
  const [hr, setHr] = useState(74);
  const [rr, setRr] = useState(16);
  const [spo2, setSpo2] = useState(98);
  const [temp, setTemp] = useState(37.0);
  const [saved, setSaved] = useState(false);

  // Rapid MEWS calculation
  const calculateMews = () => {
    let score = 0;
    if (sbp <= 70) score += 3;
    else if (sbp <= 80) score += 2;
    else if (sbp <= 100) score += 1;
    else if (sbp >= 200) score += 2;

    if (hr < 40) score += 2;
    else if (hr <= 50) score += 1;
    else if (hr >= 130) score += 3;
    else if (hr >= 111) score += 2;
    else if (hr >= 101) score += 1;

    if (rr < 9) score += 2;
    else if (rr >= 30) score += 3;
    else if (rr >= 21) score += 2;
    else if (rr >= 15) score += 1;

    if (temp < 35.0) score += 2;
    else if (temp >= 38.5) score += 2;

    return score;
  };

  const mews = calculateMews();

  const handleSave = () => {
    setSaved(true);
    setTimeout(() => setSaved(false), 2500);
  };

  return (
    <div className="space-y-4 pb-20">
      {/* Patient Barcode Banner */}
      <div className="p-4 bg-slate-800/80 border border-slate-700/80 rounded-2xl flex items-center justify-between">
        <div>
          <span className="text-[10px] font-mono font-bold text-sky-400">{patientMrn}</span>
          <h2 className="text-sm font-bold text-white mt-0.5">{patientName}</h2>
        </div>
        <button className="p-2.5 bg-sky-600 active:bg-sky-500 rounded-xl text-white shadow-lg">
          <Barcode className="h-5 w-5" />
        </button>
      </div>

      {/* MEWS Pill */}
      <div
        className={`p-3.5 rounded-2xl flex items-center justify-between border ${
          mews >= 5
            ? 'bg-rose-950/60 border-rose-600 text-rose-300'
            : mews >= 3
            ? 'bg-amber-950/60 border-amber-600 text-amber-300'
            : 'bg-emerald-950/60 border-emerald-600 text-emerald-300'
        }`}
      >
        <div className="flex items-center gap-2">
          <Activity className="h-5 w-5" />
          <span className="text-xs font-bold">Modified Early Warning Score (MEWS)</span>
        </div>
        <span className="text-lg font-black">{mews}</span>
      </div>

      {/* Vitals Input Grid */}
      <div className="grid grid-cols-2 gap-3 text-xs">
        <div className="p-3.5 bg-slate-800 rounded-2xl border border-slate-700/60 space-y-1">
          <span className="text-slate-400 font-semibold block">Blood Pressure</span>
          <div className="flex items-center gap-1.5 mt-1">
            <input
              type="number"
              value={sbp}
              onChange={(e) => setSbp(Number(e.target.value))}
              className="w-16 p-2 bg-slate-900 border border-slate-700 rounded-xl text-center font-bold text-white text-sm"
            />
            <span className="text-slate-500 font-bold">/</span>
            <input
              type="number"
              value={dbp}
              onChange={(e) => setDbp(Number(e.target.value))}
              className="w-16 p-2 bg-slate-900 border border-slate-700 rounded-xl text-center font-bold text-white text-sm"
            />
          </div>
          <span className="text-[10px] text-slate-500 block">mmHg</span>
        </div>

        <div className="p-3.5 bg-slate-800 rounded-2xl border border-slate-700/60 space-y-1">
          <span className="text-slate-400 font-semibold block flex items-center gap-1">
            <HeartPulse className="h-3.5 w-3.5 text-rose-400" /> Heart Rate
          </span>
          <input
            type="number"
            value={hr}
            onChange={(e) => setHr(Number(e.target.value))}
            className="w-full p-2 bg-slate-900 border border-slate-700 rounded-xl text-center font-bold text-white text-sm"
          />
          <span className="text-[10px] text-slate-500 block">BPM</span>
        </div>

        <div className="p-3.5 bg-slate-800 rounded-2xl border border-slate-700/60 space-y-1">
          <span className="text-slate-400 font-semibold block flex items-center gap-1">
            <Wind className="h-3.5 w-3.5 text-sky-400" /> Resp Rate
          </span>
          <input
            type="number"
            value={rr}
            onChange={(e) => setRr(Number(e.target.value))}
            className="w-full p-2 bg-slate-900 border border-slate-700 rounded-xl text-center font-bold text-white text-sm"
          />
          <span className="text-[10px] text-slate-500 block">breaths/min</span>
        </div>

        <div className="p-3.5 bg-slate-800 rounded-2xl border border-slate-700/60 space-y-1">
          <span className="text-slate-400 font-semibold block flex items-center gap-1">
            <Thermometer className="h-3.5 w-3.5 text-amber-400" /> Temp (°C)
          </span>
          <input
            type="number"
            step="0.1"
            value={temp}
            onChange={(e) => setTemp(Number(e.target.value))}
            className="w-full p-2 bg-slate-900 border border-slate-700 rounded-xl text-center font-bold text-white text-sm"
          />
          <span className="text-[10px] text-slate-500 block">Celsius</span>
        </div>
      </div>

      {/* Save Button */}
      <button
        onClick={handleSave}
        className="w-full py-3.5 bg-sky-600 active:bg-sky-500 text-white rounded-2xl font-bold text-sm shadow-xl shadow-sky-600/30 flex items-center justify-center gap-2 transition-transform active:scale-[0.98]"
      >
        {saved ? <CheckCircle2 className="h-5 w-5 text-emerald-300" /> : <Save className="h-5 w-5" />}
        {saved ? 'Vitals Synced to EMR' : 'Record Bedside Vitals'}
      </button>
    </div>
  );
};
