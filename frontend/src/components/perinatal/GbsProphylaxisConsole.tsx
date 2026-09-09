import React, { useState } from 'react';

export const GbsProphylaxisConsole: React.FC = () => {
  const [gbsPos, setGbsPos] = useState<boolean>(true);
  const [allergy, setAllergy] = useState<string>('NONE');

  return (
    <div className="p-6 bg-slate-900 text-white rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-700">
        <div>
          <h2 className="text-2xl font-bold text-sky-400">GBS Intrapartum Antibiotic Prophylaxis (IAP)</h2>
          <p className="text-sm text-slate-400">CDC / ACOG Neonatal Early-Onset Sepsis Prevention</p>
        </div>
        <span className="px-3 py-1 bg-sky-950 text-sky-300 border border-sky-700 rounded-full text-xs font-mono">
          CDC IAP Protocol
        </span>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mt-6">
        <div className="space-y-4">
          <label className="flex items-center gap-2 text-xs text-slate-300 cursor-pointer">
            <input
              type="checkbox"
              checked={gbsPos}
              onChange={(e) => setGbsPos(e.target.checked)}
              className="accent-sky-500 rounded"
            />
            Positive Rectovaginal GBS Culture
          </label>

          <div>
            <label className="text-xs text-slate-300">Penicillin Allergy Severity</label>
            <select
              value={allergy}
              onChange={(e) => setAllergy(e.target.value)}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded-lg p-2.5 text-white"
            >
              <option value="NONE">No Known Allergy (Penicillin G First Line)</option>
              <option value="LOW">Low Risk / Mild Rash (Cefazolin)</option>
              <option value="HIGH">High Risk Anaphylaxis (Clindamycin / Vancomycin)</option>
            </select>
          </div>
        </div>

        <div className="bg-slate-950 p-5 rounded-lg border border-slate-800 flex flex-col justify-between">
          <div className="space-y-2 text-sm">
            <div className="flex justify-between py-1 border-b border-slate-800">
              <span className="text-slate-400">Target Antibiotic:</span>
              <span className="font-mono text-sky-300">
                {allergy === 'NONE' ? 'Penicillin G 5M units IV' : allergy === 'LOW' ? 'Cefazolin 2g IV' : 'Vancomycin / Clinda'}
              </span>
            </div>
          </div>

          <button className="w-full mt-4 py-2.5 bg-sky-600 hover:bg-sky-500 font-semibold rounded-lg text-white transition-colors">
            Order IAP Regimen
          </button>
        </div>
      </div>
    </div>
  );
};
