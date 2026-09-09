import React, { useState } from 'react';

export const PicuPrismConsole: React.FC = () => {
  const [weight, setWeight] = useState<number>(14);
  const [sbp, setSbp] = useState<number>(85);
  const [hr, setHr] = useState<number>(130);
  const [gcs, setGcs] = useState<number>(14);

  const isHighRisk = sbp < 70 || hr > 160 || gcs < 9;

  return (
    <div className="p-6 bg-slate-900 text-white rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-700">
        <div>
          <h2 className="text-2xl font-bold text-sky-400">PICU PRISM III & PALS Resuscitation Console</h2>
          <p className="text-sm text-slate-400">Pediatric Risk of Mortality & Two-Bag DKA Fluid Infusion Protocol</p>
        </div>
        <span className="px-3 py-1 bg-sky-950 text-sky-300 border border-sky-700 rounded-full text-xs font-mono">
          PALS 2025 Standard
        </span>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mt-6">
        <div className="space-y-4">
          <div>
            <label className="text-xs text-slate-300">Child Weight (kg): {weight} kg</label>
            <input
              type="number"
              value={weight}
              onChange={(e) => setWeight(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>
          <div>
            <label className="text-xs text-slate-300">Systolic BP: {sbp} mmHg</label>
            <input
              type="number"
              value={sbp}
              onChange={(e) => setSbp(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>
        </div>

        <div className="bg-slate-950 p-5 rounded-lg border border-slate-800 flex flex-col justify-between">
          <div className="text-center p-4 bg-slate-900 rounded-lg border border-slate-800">
            <span className="text-xs text-slate-400">Endotracheal Tube Size (Uncuffed: Age/4 + 4)</span>
            <p className="text-2xl font-bold text-sky-300 mt-1">4.5 mm ID / 14 cm Depth</p>
          </div>

          <button className="w-full mt-4 py-2.5 bg-sky-600 hover:bg-sky-500 font-semibold rounded-lg text-white transition-colors">
            Transmit PICU Telemetry
          </button>
        </div>
      </div>
    </div>
  );
};
