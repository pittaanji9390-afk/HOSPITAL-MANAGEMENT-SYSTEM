import React, { useState } from 'react';

export const SyntaxScoreBoard: React.FC = () => {
  const [syntax1, setSyntax1] = useState<number>(28);
  const [age, setAge] = useState<number>(68);
  const [crCl, setCrCl] = useState<number>(55);
  const [lvef, setLvef] = useState<number>(45);
  const [copd, setCopd] = useState<boolean>(false);
  const [pvd, setPvd] = useState<boolean>(true);

  const pciMortality = Math.max(1.5, Math.min(65.0, 4.2 + (syntax1 * 0.32) + (age * 0.18) - (crCl * 0.08) - (lvef * 0.15) + (copd ? 4.5 : 0) + (pvd ? 5.0 : 0)));
  const cabgMortality = Math.max(1.2, Math.min(60.0, 3.5 + (age * 0.16) - (crCl * 0.06) - (lvef * 0.12) + (copd ? 5.8 : 0) + (pvd ? 4.2 : 0)));

  const tier = syntax1 <= 22 ? 'Low Complexity (0-22)' : syntax1 <= 32 ? 'Intermediate Complexity (23-32)' : 'High Complexity (>=33)';

  return (
    <div className="p-6 bg-slate-900 text-white rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-700">
        <div>
          <h2 className="text-2xl font-bold text-amber-400">SYNTAX Score I & II Decision Board</h2>
          <p className="text-sm text-slate-400">Heart Team Multidisciplinary Revascularization Stratification</p>
        </div>
        <span className="px-3 py-1 bg-amber-950 text-amber-300 border border-amber-700 rounded-full text-xs font-mono">
          SYNTAX II Consensus
        </span>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mt-6">
        <div className="space-y-4">
          <div>
            <label className="text-xs text-slate-300 font-semibold">Anatomical SYNTAX Score I: {syntax1}</label>
            <input
              type="range"
              min="0"
              max="55"
              value={syntax1}
              onChange={(e) => setSyntax1(Number(e.target.value))}
              className="w-full mt-2 accent-amber-500"
            />
            <span className="text-xs text-amber-300 font-mono">{tier}</span>
          </div>

          <div className="grid grid-cols-3 gap-3">
            <div>
              <label className="text-xs text-slate-300">Age</label>
              <input
                type="number"
                value={age}
                onChange={(e) => setAge(Number(e.target.value))}
                className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
              />
            </div>
            <div>
              <label className="text-xs text-slate-300">CrCl (mL/min)</label>
              <input
                type="number"
                value={crCl}
                onChange={(e) => setCrCl(Number(e.target.value))}
                className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
              />
            </div>
            <div>
              <label className="text-xs text-slate-300">LVEF (%)</label>
              <input
                type="number"
                value={lvef}
                onChange={(e) => setLvef(Number(e.target.value))}
                className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
              />
            </div>
          </div>
        </div>

        <div className="bg-slate-950 p-5 rounded-lg border border-slate-800 flex flex-col justify-between">
          <div>
            <h3 className="text-sm font-semibold text-slate-300 mb-3">SYNTAX II 4-Year Mortality Estimation</h3>
            <div className="grid grid-cols-2 gap-4 text-center">
              <div className="p-3 bg-slate-900 border border-cyan-800 rounded-lg">
                <span className="text-xs text-cyan-400 font-semibold">PCI Mortality</span>
                <p className="text-2xl font-bold text-cyan-300 mt-1">{pciMortality.toFixed(1)}%</p>
              </div>
              <div className="p-3 bg-slate-900 border border-emerald-800 rounded-lg">
                <span className="text-xs text-emerald-400 font-semibold">CABG Mortality</span>
                <p className="text-2xl font-bold text-emerald-300 mt-1">{cabgMortality.toFixed(1)}%</p>
              </div>
            </div>
          </div>

          <button className="w-full mt-4 py-2.5 bg-amber-600 hover:bg-amber-500 font-semibold rounded-lg text-slate-950 transition-colors">
            Generate Heart Team Signoff
          </button>
        </div>
      </div>
    </div>
  );
};
