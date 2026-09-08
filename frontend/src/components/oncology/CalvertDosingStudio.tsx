import React, { useState } from 'react';
import { Calculator, ShieldAlert, CheckCircle2, Scale } from 'lucide-react';

export const CalvertDosingStudio: React.FC = () => {
  const [heightCm, setHeightCm] = useState(170);
  const [weightKg, setWeightKg] = useState(70);
  const [ageYears, setAgeYears] = useState(62);
  const [isFemale, setIsFemale] = useState(false);
  const [scr, setScr] = useState(0.9);
  const [targetAuc, setTargetAuc] = useState(5.0); // AUC 5 or 6

  // Math
  const bsa = Math.sqrt((heightCm * weightKg) / 3600);
  const adjustedScr = Math.max(0.7, scr);
  let crcl = ((140 - ageYears) * weightKg) / (72 * adjustedScr);
  if (isFemale) crcl *= 0.85;

  const cappedGfr = Math.min(125, crcl);
  const carboplatinDose = targetAuc * (cappedGfr + 25);
  const isCapped = crcl > 125;

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Calculator className="h-7 w-7 text-indigo-400" />
          <div>
            <h2 className="text-xl font-bold">Calvert Formula Carboplatin & BSA Dosing Engine</h2>
            <p className="text-xs text-slate-400">Target AUC x (GFR + 25) with FDA 125 mL/min Safety Cap</p>
          </div>
        </div>
        <span className="px-3 py-1 bg-indigo-950 text-indigo-300 border border-indigo-700/60 rounded-full text-xs font-mono">
          ASCO / FDA STANDARD
        </span>
      </div>

      <div className="grid grid-cols-2 gap-5 my-6">
        <div className="bg-slate-950 p-4 rounded-xl border border-slate-800 space-y-3">
          <div className="grid grid-cols-2 gap-2">
            <div>
              <label className="text-xs text-slate-400 block mb-1">Height (cm)</label>
              <input type="number" value={heightCm} onChange={e => setHeightCm(Number(e.target.value))} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-slate-200" />
            </div>
            <div>
              <label className="text-xs text-slate-400 block mb-1">Weight (kg)</label>
              <input type="number" value={weightKg} onChange={e => setWeightKg(Number(e.target.value))} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-slate-200" />
            </div>
          </div>
          <div className="grid grid-cols-2 gap-2">
            <div>
              <label className="text-xs text-slate-400 block mb-1">Age (years)</label>
              <input type="number" value={ageYears} onChange={e => setAgeYears(Number(e.target.value))} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-slate-200" />
            </div>
            <div>
              <label className="text-xs text-slate-400 block mb-1">Serum Creatinine (mg/dL)</label>
              <input type="number" step="0.1" value={scr} onChange={e => setScr(Number(e.target.value))} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-slate-200" />
            </div>
          </div>
          <div>
            <label className="text-xs text-slate-400 block mb-1">Target AUC</label>
            <select value={targetAuc} onChange={e => setTargetAuc(Number(e.target.value))} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-slate-200">
              <option value="5">AUC 5 (Standard solid tumor)</option>
              <option value="6">AUC 6 (Ovarian / Lung first-line)</option>
              <option value="4">AUC 4 (Chemo-radiation concurrent)</option>
            </select>
          </div>
        </div>

        <div className="bg-slate-950 p-4 rounded-xl border border-slate-800 flex flex-col justify-between font-mono text-xs">
          <div className="space-y-2">
            <div className="flex justify-between pb-1 border-b border-slate-800">
              <span className="text-slate-400">Mosteller BSA:</span>
              <strong className="text-white">{bsa.toFixed(2)} m²</strong>
            </div>
            <div className="flex justify-between pb-1 border-b border-slate-800">
              <span className="text-slate-400">Cockcroft-Gault CrCl:</span>
              <strong className="text-indigo-300">{crcl.toFixed(1)} mL/min</strong>
            </div>
            <div className="flex justify-between pb-1 border-b border-slate-800">
              <span className="text-slate-400">Capped GFR:</span>
              <strong className="text-emerald-400">{cappedGfr.toFixed(1)} mL/min</strong>
            </div>
          </div>

          <div className="text-center my-3">
            <span className="text-xs text-slate-400 block">Calculated Carboplatin Dose</span>
            <span className="text-4xl font-extrabold font-mono text-emerald-400">{carboplatinDose.toFixed(0)} mg</span>
          </div>

          {isCapped && (
            <div className="p-2 bg-amber-950/60 border border-amber-800 rounded text-amber-300 text-xs font-sans flex items-center gap-1.5">
              <ShieldAlert className="h-4 w-4 shrink-0" /> GFR capped at 125 mL/min to prevent severe myelosuppression.
            </div>
          )}
        </div>
      </div>
    </div>
  );
};
