import React, { useState } from 'react';

export const GdmOgttStudio: React.FC = () => {
  const [fasting, setFasting] = useState<number>(98);
  const [oneHr, setOneHr] = useState<number>(185);

  let abnormal = 0;
  if (fasting >= 95) abnormal++;
  if (oneHr >= 180) abnormal++;

  const isGdm = abnormal >= 2;

  return (
    <div className="p-6 bg-slate-900 text-white rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-700">
        <div>
          <h2 className="text-2xl font-bold text-teal-400">Gestational Diabetes (GDM) OGTT Studio</h2>
          <p className="text-sm text-slate-400">Carpenter-Coustan 100g 3-Hour Diagnostic Evaluation</p>
        </div>
        <span className="px-3 py-1 bg-teal-950 text-teal-300 border border-teal-700 rounded-full text-xs font-mono">
          Carpenter-Coustan
        </span>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mt-6">
        <div className="space-y-4">
          <div>
            <label className="text-xs text-slate-300">Fasting Glucose (mg/dL) - Cutoff 95</label>
            <input
              type="number"
              value={fasting}
              onChange={(e) => setFasting(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>
          <div>
            <label className="text-xs text-slate-300">1-Hour Post-Load (mg/dL) - Cutoff 180</label>
            <input
              type="number"
              value={oneHr}
              onChange={(e) => setOneHr(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>
        </div>

        <div className="bg-slate-950 p-5 rounded-lg border border-slate-800 flex flex-col justify-between">
          <div className="text-center p-4 bg-slate-900 rounded-lg border border-slate-800">
            <span className="text-xs text-slate-400">Diagnostic Determination</span>
            <p className={isGdm ? 'text-xl font-bold mt-1 text-teal-300' : 'text-xl font-bold mt-1 text-slate-300'}>
              {isGdm ? 'GDM POSITIVE - Initiate Nutrition & Glucose Logs' : 'NON-DIAGNOSTIC'}
            </p>
          </div>

          <button className="w-full mt-4 py-2.5 bg-teal-600 hover:bg-teal-500 font-semibold rounded-lg text-white transition-colors">
            Log OGTT Results
          </button>
        </div>
      </div>
    </div>
  );
};
