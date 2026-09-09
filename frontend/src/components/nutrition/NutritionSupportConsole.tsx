import React, { useState } from 'react';

export const NutritionSupportConsole: React.FC = () => {
  const [weight, setWeight] = useState<number>(68);

  const kcal = weight * 25;
  const protein = weight * 1.5;

  return (
    <div className="p-6 bg-slate-900 text-white rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-700">
        <div>
          <h2 className="text-2xl font-bold text-lime-400">Clinical Nutrition & Metabolic Support Studio</h2>
          <p className="text-sm text-slate-400">ASPEN Enteral/Parenteral Nutrition & Refeeding Syndrome Prevention</p>
        </div>
        <span className="px-3 py-1 bg-lime-950 text-lime-300 border border-lime-700 rounded-full text-xs font-mono">
          ASPEN 2025
        </span>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mt-6">
        <div className="space-y-4">
          <div>
            <label className="text-xs text-slate-300">Patient Weight (kg): {weight} kg</label>
            <input
              type="number"
              value={weight}
              onChange={(e) => setWeight(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>
        </div>

        <div className="bg-slate-950 p-5 rounded-lg border border-slate-800 flex flex-col justify-between">
          <div className="text-center p-4 bg-slate-900 rounded-lg border border-slate-800">
            <span className="text-xs text-slate-400">Target Daily Requirements</span>
            <p className="text-2xl font-bold text-lime-300 mt-1">{kcal.toFixed(0)} kcal / {protein.toFixed(0)}g protein</p>
          </div>

          <button className="w-full mt-4 py-2.5 bg-lime-600 hover:bg-lime-500 font-semibold rounded-lg text-slate-950 transition-colors">
            Generate TPN Prescription
          </button>
        </div>
      </div>
    </div>
  );
};
