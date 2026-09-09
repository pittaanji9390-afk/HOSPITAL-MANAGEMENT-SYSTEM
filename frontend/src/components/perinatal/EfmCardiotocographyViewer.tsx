import React, { useState } from 'react';

export const EfmCardiotocographyViewer: React.FC = () => {
  const [fhrBpm, setFhrBpm] = useState<number>(140);
  const [variability, setVariability] = useState<string>('MODERATE');
  const [lateDecels, setLateDecels] = useState<boolean>(false);
  const [recurrentVariables, setRecurrentVariables] = useState<boolean>(false);
  const [sinusoidal, setSinusoidal] = useState<boolean>(false);

  let category = 'Category I (Normal)';
  let color = 'text-emerald-400';
  let badgeBg = 'bg-emerald-950 border-emerald-700 text-emerald-300';

  if (sinusoidal || (variability === 'ABSENT' && (lateDecels || recurrentVariables || fhrBpm < 110))) {
    category = 'Category III (Abnormal - Action Required)';
    color = 'text-rose-400';
    badgeBg = 'bg-rose-950 border-rose-700 text-rose-300';
  } else if (variability !== 'MODERATE' || lateDecels || recurrentVariables || fhrBpm < 110 || fhrBpm > 160) {
    category = 'Category II (Indeterminate)';
    color = 'text-amber-400';
    badgeBg = 'bg-amber-950 border-amber-700 text-amber-300';
  }

  return (
    <div className="p-6 bg-slate-900 text-white rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-700">
        <div>
          <h2 className="text-2xl font-bold text-pink-400">ACOG Electronic Fetal Monitoring (EFM) Viewer</h2>
          <p className="text-sm text-slate-400">Cardiotocography FHR Strip Categorization & Intrauterine Resuscitation</p>
        </div>
        <span className={`px-3 py-1 border rounded-full text-xs font-mono ${badgeBg}`}>
          {category}
        </span>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mt-6">
        <div className="space-y-4">
          <div>
            <label className="text-xs text-slate-300 font-semibold">Baseline FHR: {fhrBpm} bpm</label>
            <input
              type="range"
              min="80"
              max="200"
              value={fhrBpm}
              onChange={(e) => setFhrBpm(Number(e.target.value))}
              className="w-full mt-2 accent-pink-500"
            />
          </div>

          <div>
            <label className="text-xs text-slate-300 font-semibold">Baseline FHR Variability</label>
            <select
              value={variability}
              onChange={(e) => setVariability(e.target.value)}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded-lg p-2.5 text-white"
            >
              <option value="MODERATE">Moderate (6-25 bpm - Reassuring)</option>
              <option value="MINIMAL">Minimal (&le;5 bpm)</option>
              <option value="ABSENT">Absent (Undetectable)</option>
              <option value="MARKED">Marked (&gt;25 bpm)</option>
            </select>
          </div>

          <div className="flex flex-col gap-2 pt-2">
            <label className="flex items-center gap-2 text-xs text-slate-300 cursor-pointer">
              <input
                type="checkbox"
                checked={lateDecels}
                onChange={(e) => setLateDecels(e.target.checked)}
                className="accent-pink-500 rounded"
              />
              Recurrent Late Decelerations Present
            </label>
            <label className="flex items-center gap-2 text-xs text-slate-300 cursor-pointer">
              <input
                type="checkbox"
                checked={recurrentVariables}
                onChange={(e) => setRecurrentVariables(e.target.checked)}
                className="accent-pink-500 rounded"
              />
              Recurrent Variable Decelerations Present
            </label>
            <label className="flex items-center gap-2 text-xs text-slate-300 cursor-pointer">
              <input
                type="checkbox"
                checked={sinusoidal}
                onChange={(e) => setSinusoidal(e.target.checked)}
                className="accent-pink-500 rounded"
              />
              Sinusoidal FHR Waveform (Severe Fetal Anemia)
            </label>
          </div>
        </div>

        <div className="bg-slate-950 p-5 rounded-lg border border-slate-800 flex flex-col justify-between">
          <div>
            <h3 className="text-sm font-semibold text-slate-300 mb-3">Intrapartum CTG Status</h3>
            <div className="p-4 bg-slate-900 border border-slate-800 rounded-lg text-center">
              <span className="text-xs text-slate-400">Cardiotocography Classification</span>
              <p className={`text-2xl font-bold mt-1 ${color}`}>{category}</p>
            </div>

            <div className="mt-4 p-3 rounded bg-slate-900 border border-slate-700 text-xs text-slate-300">
              {category.includes('III')
                ? 'EMERGENCY: Immediate maternal left lateral repositioning, IV fluid bolus 1000mL, stop Pitocin, prepare OR for urgent delivery.'
                : category.includes('II')
                ? 'Continuous surveillance; maternal repositioning and IV hydration indicated.'
                : 'Reassuring fetal acid-base status. Continue routine labor support.'}
            </div>
          </div>

          <button className="w-full mt-4 py-2.5 bg-pink-600 hover:bg-pink-500 font-semibold rounded-lg text-white transition-colors">
            Log EFM Strip Assessment
          </button>
        </div>
      </div>
    </div>
  );
};
