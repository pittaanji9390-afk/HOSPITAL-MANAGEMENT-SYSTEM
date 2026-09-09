import React, { useState } from 'react';

export const NichdDecelerationAnalyzer: React.FC = () => {
  const [decType, setDecType] = useState<string>('VARIABLE');
  const [contractions, setContractions] = useState<number>(4);

  const isTachysystole = contractions > 5;

  return (
    <div className="p-6 bg-slate-900 text-white rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-700">
        <div>
          <h2 className="text-2xl font-bold text-rose-400">NICHD Deceleration Pattern Studio</h2>
          <p className="text-sm text-slate-400">Uterine Contraction Coupling & Tachysystole Surveillance</p>
        </div>
        <span className="px-3 py-1 bg-rose-950 text-rose-300 border border-rose-700 rounded-full text-xs font-mono">
          NICHD Nomenclature
        </span>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mt-6">
        <div className="space-y-4">
          <div>
            <label className="text-xs text-slate-300 font-semibold">Deceleration Morphology</label>
            <select
              value={decType}
              onChange={(e) => setDecType(e.target.value)}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded-lg p-2.5 text-white"
            >
              <option value="EARLY">Early Deceleration (Head Compression)</option>
              <option value="LATE">Late Deceleration (Uteroplacental Insufficiency)</option>
              <option value="VARIABLE">Variable Deceleration (Cord Compression)</option>
              <option value="PROLONGED">Prolonged Deceleration (&ge;2 min to &lt;10 min)</option>
            </select>
          </div>

          <div>
            <label className="text-xs text-slate-300 font-semibold">Contractions in 10 min window: {contractions}</label>
            <input
              type="range"
              min="1"
              max="10"
              value={contractions}
              onChange={(e) => setContractions(Number(e.target.value))}
              className="w-full mt-2 accent-rose-500"
            />
          </div>
        </div>

        <div className="bg-slate-950 p-5 rounded-lg border border-slate-800 flex flex-col justify-between">
          <div className="space-y-2 text-sm">
            <div className="flex justify-between py-1 border-b border-slate-800">
              <span className="text-slate-400">Tachysystole Status:</span>
              <span className={isTachysystole ? 'font-bold text-red-400' : 'text-emerald-400'}>
                {isTachysystole ? 'TACHYSYSTOLE (>5/10 min) - STOP PITOCIN' : 'NORMAL CONTRACTION FREQUENCY'}
              </span>
            </div>
          </div>

          <button className="w-full mt-4 py-2.5 bg-rose-600 hover:bg-rose-500 font-semibold rounded-lg text-white transition-colors">
            Record Deceleration Findings
          </button>
        </div>
      </div>
    </div>
  );
};
