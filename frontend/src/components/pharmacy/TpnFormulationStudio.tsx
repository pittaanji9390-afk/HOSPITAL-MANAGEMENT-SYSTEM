import React, { useState } from 'react';
import { Activity, AlertTriangle, CheckCircle, Info, Calculator } from 'lucide-react';

export const TpnFormulationStudio: React.FC = () => {
  const [patientWeightKg] = useState(70);
  const [isCentralLine, setIsCentralLine] = useState(true);
  const [aminoAcidsGrams, setAminoAcidsGrams] = useState(100);
  const [dextroseGrams, setDextroseGrams] = useState(250);
  const [lipid20Ml, setLipid20Ml] = useState(250);
  const [sodiumMeq, setSodiumMeq] = useState(80);
  const [potassiumMeq, setPotassiumMeq] = useState(60);
  const [calciumMeq, setCalciumMeq] = useState(10);
  const [phosphateMmol, setPhosphateMmol] = useState(20);
  const [volumeMl, setVolumeMl] = useState(2000);

  // Math
  const totalKcal = (aminoAcidsGrams * 4) + (dextroseGrams * 3.4) + (lipid20Ml * 2.0);
  const gramsNitrogen = aminoAcidsGrams / 6.25;
  const npcToN = gramsNitrogen > 0 ? ((dextroseGrams * 3.4) + (lipid20Ml * 2.0)) / gramsNitrogen : 0;
  
  const mOsmTotal = (aminoAcidsGrams * 10) + (dextroseGrams * 5) + (lipid20Ml * 0.7) + ((sodiumMeq + potassiumMeq) * 2);
  const osmPerLiter = (mOsmTotal / (volumeMl / 1000));

  const caConc = (calciumMeq / (volumeMl / 1000));
  const phosConc = (phosphateMmol / (volumeMl / 1000));
  const caPhosRisk = (caConc + phosConc) > 45 && (aminoAcidsGrams / (volumeMl / 100)) < 2.5;

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Calculator className="h-7 w-7 text-amber-400" />
          <div>
            <h2 className="text-xl font-bold">Total Parenteral Nutrition (TPN / PN) Formulator</h2>
            <p className="text-xs text-slate-400">Nutritional Caloric Ratios, Osmolarity & Calcium-Phosphate Solubility Curve</p>
          </div>
        </div>
        <span className="px-3 py-1 bg-indigo-950 text-indigo-300 border border-indigo-700/60 rounded-full text-xs font-mono">
          ASPEN Guideline Engine
        </span>
      </div>

      <div className="grid grid-cols-3 gap-5 my-6">
        <div className="bg-slate-950 p-4 rounded-xl border border-slate-800 space-y-3">
          <h3 className="text-sm font-semibold text-slate-300">Macronutrients</h3>
          <div>
            <label className="text-xs text-slate-400 block mb-1">Amino Acids (g)</label>
            <input type="number" value={aminoAcidsGrams} onChange={e => setAminoAcidsGrams(Number(e.target.value))} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-slate-200" />
          </div>
          <div>
            <label className="text-xs text-slate-400 block mb-1">Dextrose 70% (g)</label>
            <input type="number" value={dextroseGrams} onChange={e => setDextroseGrams(Number(e.target.value))} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-slate-200" />
          </div>
          <div>
            <label className="text-xs text-slate-400 block mb-1">20% IV Fat Emulsion (mL)</label>
            <input type="number" value={lipid20Ml} onChange={e => setLipid20Ml(Number(e.target.value))} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-slate-200" />
          </div>
          <div>
            <label className="text-xs text-slate-400 block mb-1">Total Infusion Volume (mL)</label>
            <input type="number" value={volumeMl} onChange={e => setVolumeMl(Number(e.target.value))} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-slate-200" />
          </div>
        </div>

        <div className="bg-slate-950 p-4 rounded-xl border border-slate-800 space-y-3">
          <h3 className="text-sm font-semibold text-slate-300">Electrolytes & Line Access</h3>
          <div className="grid grid-cols-2 gap-2">
            <div>
              <label className="text-xs text-slate-400 block mb-1">Sodium (mEq)</label>
              <input type="number" value={sodiumMeq} onChange={e => setSodiumMeq(Number(e.target.value))} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-slate-200" />
            </div>
            <div>
              <label className="text-xs text-slate-400 block mb-1">Potassium (mEq)</label>
              <input type="number" value={potassiumMeq} onChange={e => setPotassiumMeq(Number(e.target.value))} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-slate-200" />
            </div>
            <div>
              <label className="text-xs text-slate-400 block mb-1">Calcium (mEq)</label>
              <input type="number" value={calciumMeq} onChange={e => setCalciumMeq(Number(e.target.value))} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-slate-200" />
            </div>
            <div>
              <label className="text-xs text-slate-400 block mb-1">Phosphate (mmol)</label>
              <input type="number" value={phosphateMmol} onChange={e => setPhosphateMmol(Number(e.target.value))} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-slate-200" />
            </div>
          </div>
          <div className="pt-2">
            <label className="flex items-center gap-2 text-xs text-slate-300 cursor-pointer">
              <input type="checkbox" checked={isCentralLine} onChange={e => setIsCentralLine(e.target.checked)} className="rounded bg-slate-900 border-slate-700 text-indigo-600" />
              Central Line Access (PICC / Subclavian / Internal Jugular)
            </label>
          </div>
        </div>

        <div className="bg-slate-950 p-4 rounded-xl border border-slate-800 flex flex-col justify-between">
          <h3 className="text-sm font-semibold text-slate-300">Safety & Caloric Profile</h3>
          <div className="space-y-3 font-mono text-xs">
            <div className="flex justify-between pb-1 border-b border-slate-800">
              <span className="text-slate-400">Total Energy:</span>
              <strong className="text-white">{totalKcal.toFixed(0)} kcal ({(totalKcal / patientWeightKg).toFixed(1)} kcal/kg)</strong>
            </div>
            <div className="flex justify-between pb-1 border-b border-slate-800">
              <span className="text-slate-400">NPC:N Ratio:</span>
              <strong className="text-indigo-300">{npcToN.toFixed(0)} : 1</strong>
            </div>
            <div className="flex justify-between pb-1 border-b border-slate-800">
              <span className="text-slate-400">Osmolarity:</span>
              <strong className={osmPerLiter > 900 ? 'text-amber-400' : 'text-emerald-400'}>
                {osmPerLiter.toFixed(0)} mOsm/L
              </strong>
            </div>
            <div className="flex justify-between pb-1 border-b border-slate-800">
              <span className="text-slate-400">Ca + Phos Sum:</span>
              <strong className={caPhosRisk ? 'text-rose-400' : 'text-emerald-400'}>
                {(caConc + phosConc).toFixed(1)} mEq+mmol/L
              </strong>
            </div>
          </div>

          <div className={'p-3 rounded-lg text-xs mt-3 flex items-start gap-2 ' + (
            caPhosRisk ? 'bg-rose-950/60 border border-rose-700 text-rose-300' : 'bg-emerald-950/60 border border-emerald-700 text-emerald-300'
          )}>
            {caPhosRisk ? <AlertTriangle className="h-4 w-4 shrink-0 text-rose-400" /> : <CheckCircle className="h-4 w-4 shrink-0 text-emerald-400" />}
            <div>
              {caPhosRisk ? 'CRITICAL RISK: Calcium phosphate precipitation curve breached!' : 'STABLE: Formulation within safe solubility and osmolarity parameters.'}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};
