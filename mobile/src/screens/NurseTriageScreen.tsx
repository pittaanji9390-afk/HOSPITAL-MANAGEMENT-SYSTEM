import React, { useState } from 'react';
import {
  Flame,
  AlertTriangle,
  HeartPulse,
  Activity,
  CheckCircle2,
  Send,
  User,
} from 'lucide-react';

export const NurseTriageScreen: React.FC = () => {
  const [patientName, setPatientName] = useState('Ramesh Sharma');
  const [age, setAge] = useState(58);
  const [complaint, setComplaint] = useState('Severe central chest crushing pain radiating to left shoulder, diaphoresis');
  const [esiLevel, setEsiLevel] = useState<number>(1);
  const [submitted, setSubmitted] = useState(false);

  const handleSubmit = () => {
    setSubmitted(true);
    setTimeout(() => setSubmitted(false), 2500);
  };

  return (
    <div className="space-y-4 pb-20">
      {/* Header */}
      <div className="p-4 bg-slate-800/80 border border-slate-700/80 rounded-2xl flex items-center justify-between">
        <div>
          <h2 className="text-sm font-bold text-white flex items-center gap-2">
            <Flame className="h-4 w-4 text-rose-500" />
            Emergency Rapid Triage (ESI 1-5)
          </h2>
          <p className="text-[11px] text-slate-400 mt-0.5">Point-of-care emergency intake</p>
        </div>
      </div>

      {/* Triage Level Selector */}
      <div className="space-y-2">
        <label className="text-xs font-bold text-slate-300 uppercase tracking-wider block">
          Select ESI Acuity Level
        </label>
        <div className="grid grid-cols-5 gap-1.5 text-center font-black text-xs">
          {[
            { level: 1, label: 'ESI 1', color: 'bg-rose-600 border-rose-500' },
            { level: 2, label: 'ESI 2', color: 'bg-amber-600 border-amber-500' },
            { level: 3, label: 'ESI 3', color: 'bg-yellow-600 border-yellow-500' },
            { level: 4, label: 'ESI 4', color: 'bg-sky-600 border-sky-500' },
            { level: 5, label: 'ESI 5', color: 'bg-emerald-600 border-emerald-500' },
          ].map((item) => (
            <button
              key={item.level}
              onClick={() => setEsiLevel(item.level)}
              className={`py-3 rounded-xl border transition-all ${
                esiLevel === item.level
                  ? `${item.color} text-white shadow-lg`
                  : 'bg-slate-800 border-slate-700 text-slate-400'
              }`}
            >
              {item.label}
            </button>
          ))}
        </div>
      </div>

      {/* Patient Intake Form */}
      <div className="p-4 bg-slate-800 rounded-2xl border border-slate-700/80 space-y-3 text-xs">
        <div>
          <label className="font-semibold text-slate-300 block mb-1">Patient Name</label>
          <input
            type="text"
            value={patientName}
            onChange={(e) => setPatientName(e.target.value)}
            className="w-full px-3 py-2 bg-slate-900 border border-slate-700 rounded-xl text-white font-medium"
          />
        </div>

        <div>
          <label className="font-semibold text-slate-300 block mb-1">Chief Presenting Complaint</label>
          <textarea
            rows={3}
            value={complaint}
            onChange={(e) => setComplaint(e.target.value)}
            className="w-full px-3 py-2 bg-slate-900 border border-slate-700 rounded-xl text-white font-medium leading-relaxed"
          />
        </div>
      </div>

      {/* Submit */}
      <button
        onClick={handleSubmit}
        className="w-full py-3.5 bg-rose-600 active:bg-rose-500 text-white rounded-2xl font-bold text-sm shadow-xl shadow-rose-600/30 flex items-center justify-center gap-2"
      >
        {submitted ? <CheckCircle2 className="h-5 w-5 text-emerald-300" /> : <Send className="h-5 w-5" />}
        {submitted ? 'Patient Dispatched to Trauma Bay' : 'Confirm Triage & Assign Bed'}
      </button>
    </div>
  );
};
