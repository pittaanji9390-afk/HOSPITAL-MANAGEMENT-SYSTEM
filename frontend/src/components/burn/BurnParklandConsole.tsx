import React, { useState } from 'react';

export const BurnParklandConsole: React.FC = () => {
  const [weight, setWeight] = useState<number>(70);
  const [tbsa, setTbsa] = useState<number>(35);

  const totalFluid = 4 * weight * tbsa;
  const first8Rate = totalFluid / 2 / 8;

  return (
    <div className="p-6 bg-slate-900 text-white rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-700">
        <div>
          <h2 className="text-2xl font-bold text-orange-400">Burn Critical Care & Parkland Fluid Studio</h2>
          <p className="text-sm text-slate-400">American Burn Association (ABA) Parkland Resuscitation & Urine Output Titrator</p>
        </div>
        <span className="px-3 py-1 bg-orange-950 text-orange-300 border border-orange-700 rounded-full text-xs font-mono">
          ABA Burn Standard
        </span>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mt-6">
        <div className="space-y-4">
          <div>
            <label className="text-xs text-slate-300">Weight (kg): {weight} kg</label>
            <input
              type="number"
              value={weight}
              onChange={(e) => setWeight(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>
          <div>
            <label className="text-xs text-slate-300">Total Body Surface Area Burn (%TBSA): {tbsa}%</label>
            <input
              type="number"
              value={tbsa}
              onChange={(e) => setTbsa(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>
        </div>

        <div className="bg-slate-950 p-5 rounded-lg border border-slate-800 flex flex-col justify-between">
          <div className="text-center p-4 bg-slate-900 rounded-lg border border-slate-800">
            <span className="text-xs text-slate-400">First 8 Hours Infusion Rate</span>
            <p className="text-3xl font-black text-orange-300 mt-1">{first8Rate.toFixed(0)} mL/hr</p>
            <p className="text-xs text-slate-400 mt-1">Total 24h Lactated Ringer's: {totalFluid.toFixed(0)} mL</p>
          </div>

          <button className="w-full mt-4 py-2.5 bg-orange-600 hover:bg-orange-500 font-semibold rounded-lg text-white transition-colors">
            Confirm Fluid Orders
          </button>
        </div>
      </div>
    </div>
  );
};
