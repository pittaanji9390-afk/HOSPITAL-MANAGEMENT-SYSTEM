import React, { useState } from 'react';

export const BishopInductionStudio: React.FC = () => {
  const [dilation, setDilation] = useState<number>(2);
  const [effacement, setEffacement] = useState<number>(50);
  const [station, setStation] = useState<number>(-1);

  let score = 0;
  if (dilation >= 5) score += 3; else if (dilation >= 3) score += 2; else if (dilation >= 1) score += 1;
  if (effacement >= 80) score += 3; else if (effacement >= 60) score += 2; else if (effacement >= 40) score += 1;
  if (station >= 1) score += 3; else if (station >= -1) score += 2; else if (station >= -2) score += 1;

  const isFavorable = score >= 8;

  return (
    <div className="p-6 bg-slate-900 text-white rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-700">
        <div>
          <h2 className="text-2xl font-bold text-amber-400">Bishop Cervical Score & Induction Advisor</h2>
          <p className="text-sm text-slate-400">Pre-Induction Cervical Ripening Readiness Evaluation</p>
        </div>
        <span className="px-3 py-1 bg-amber-950 text-amber-300 border border-amber-700 rounded-full text-xs font-mono">
          Score: {score} / 13
        </span>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mt-6">
        <div className="space-y-4">
          <div>
            <label className="text-xs text-slate-300">Cervical Dilation (cm): {dilation} cm</label>
            <input
              type="number"
              min="0"
              max="10"
              value={dilation}
              onChange={(e) => setDilation(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>

          <div>
            <label className="text-xs text-slate-300">Effacement (%): {effacement}%</label>
            <input
              type="number"
              min="0"
              max="100"
              step="10"
              value={effacement}
              onChange={(e) => setEffacement(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>
        </div>

        <div className="bg-slate-950 p-5 rounded-lg border border-slate-800 flex flex-col justify-between">
          <div className="text-center p-4 bg-slate-900 rounded-lg border border-slate-800">
            <span className="text-xs text-slate-400">Ripening Recommendation</span>
            <p className={isFavorable ? 'text-xl font-bold mt-1 text-emerald-400' : 'text-xl font-bold mt-1 text-amber-400'}>
              {isFavorable ? 'Favorable: Direct Oxytocin Infusion' : 'Unfavorable: Foley Bulb / Prostaglandin Ripening'}
            </p>
          </div>

          <button className="w-full mt-4 py-2.5 bg-amber-600 hover:bg-amber-500 font-semibold rounded-lg text-slate-950 transition-colors">
            Generate Induction Plan
          </button>
        </div>
      </div>
    </div>
  );
};
