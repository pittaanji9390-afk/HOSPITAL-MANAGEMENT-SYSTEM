import React, { useState } from 'react';
import {
  Calculator,
  Activity,
  Brain,
  Stethoscope,
  HeartPulse,
} from 'lucide-react';

export const ClinicalCalculatorScreen: React.FC = () => {
  const [activeTab, setActiveTab] = useState<'mews' | 'curb65' | 'gcs'>('mews');

  // GCS
  const [eye, setEye] = useState(4);
  const [verbal, setVerbal] = useState(5);
  const [motor, setMotor] = useState(6);

  // MEWS
  const [sbp, setSbp] = useState(120);
  const [hr, setHr] = useState(75);
  const [rr, setRr] = useState(16);
  const [temp, setTemp] = useState(37.0);

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

  return (
    <div className="space-y-4 pb-20">
      <div className="p-4 bg-slate-800 rounded-2xl border border-slate-700 flex items-center justify-between">
        <div>
          <span className="text-[10px] font-bold text-sky-400 block">CLINICAL DECISION SUPPORT</span>
          <h3 className="text-sm font-bold text-white">Bedside Risk Calculators</h3>
        </div>
      </div>

      <div className="flex bg-slate-800 p-1 rounded-2xl border border-slate-700 text-xs font-bold">
        {[
          { key: 'mews', label: 'MEWS Vitals' },
          { key: 'gcs', label: 'Glasgow Coma (GCS)' },
        ].map((t) => (
          <button
            key={t.key}
            onClick={() => setActiveTab(t.key as any)}
            className={`flex-1 py-2 rounded-xl transition-all ${
              activeTab === t.key ? 'bg-sky-600 text-white shadow-md' : 'text-slate-400'
            }`}
          >
            {t.label}
          </button>
        ))}
      </div>

      {activeTab === 'mews' && (
        <div className="p-4 bg-slate-800 rounded-2xl border border-slate-700 space-y-3 text-xs">
          <div className="flex items-center justify-between p-3 bg-slate-900 rounded-xl">
            <span className="font-bold text-slate-300">Total MEWS Score</span>
            <span className="text-2xl font-black text-sky-400">{calculateMews()}</span>
          </div>

          <div className="grid grid-cols-2 gap-2.5">
            <div>
              <label className="text-slate-400 block mb-1">Systolic BP</label>
              <input
                type="number"
                value={sbp}
                onChange={(e) => setSbp(Number(e.target.value))}
                className="w-full p-2 bg-slate-900 border border-slate-700 rounded-xl text-white font-bold"
              />
            </div>
            <div>
              <label className="text-slate-400 block mb-1">Heart Rate</label>
              <input
                type="number"
                value={hr}
                onChange={(e) => setHr(Number(e.target.value))}
                className="w-full p-2 bg-slate-900 border border-slate-700 rounded-xl text-white font-bold"
              />
            </div>
          </div>
        </div>
      )}

      {activeTab === 'gcs' && (
        <div className="p-4 bg-slate-800 rounded-2xl border border-slate-700 space-y-3 text-xs">
          <div className="flex items-center justify-between p-3 bg-slate-900 rounded-xl">
            <span className="font-bold text-slate-300">Total GCS Score</span>
            <span className="text-2xl font-black text-sky-400">{eye + verbal + motor} / 15</span>
          </div>

          <div className="space-y-2">
            <div>
              <label className="text-slate-400 block mb-1">Eye Opening (1-4)</label>
              <select
                value={eye}
                onChange={(e) => setEye(Number(e.target.value))}
                className="w-full p-2 bg-slate-900 border border-slate-700 rounded-xl text-white font-medium"
              >
                <option value={4}>4 - Spontaneous</option>
                <option value={3}>3 - To Speech</option>
                <option value={2}>2 - To Pain</option>
                <option value={1}>1 - None</option>
              </select>
            </div>

            <div>
              <label className="text-slate-400 block mb-1">Verbal Response (1-5)</label>
              <select
                value={verbal}
                onChange={(e) => setVerbal(Number(e.target.value))}
                className="w-full p-2 bg-slate-900 border border-slate-700 rounded-xl text-white font-medium"
              >
                <option value={5}>5 - Oriented</option>
                <option value={4}>4 - Confused</option>
                <option value={3}>3 - Inappropriate</option>
                <option value={2}>2 - Incomprehensible</option>
                <option value={1}>1 - None</option>
              </select>
            </div>
          </div>
        </div>
      )}
    </div>
  );
};
