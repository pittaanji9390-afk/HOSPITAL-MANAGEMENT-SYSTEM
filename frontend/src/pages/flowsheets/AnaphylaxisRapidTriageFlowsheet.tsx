import React, { useState } from 'react';
import { Siren, Activity, ShieldCheck, Timer } from 'lucide-react';

export const AnaphylaxisRapidTriageFlowsheet: React.FC = () => {
  const [weightKg, setWeightKg] = useState<number>(70);
  const epiDose = weightKg >= 50 ? 0.50 : (weightKg >= 25 ? 0.30 : 0.15);

  return (
    <div className="p-6 space-y-6 max-w-7xl mx-auto">
      <div className="flex items-center justify-between border-b pb-4">
        <div className="flex items-center space-x-3">
          <div className="p-3 bg-red-100 dark:bg-red-900/30 text-red-600 rounded-xl">
            <Siren className="w-8 h-8" />
          </div>
          <div>
            <h1 className="text-2xl font-bold text-gray-900 dark:text-white">Anaphylaxis Rapid Response Console</h1>
            <p className="text-sm text-gray-500">IM Epinephrine dosing calculator (1:1000) and biphasic reaction 8-hour surveillance flowsheet</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-2 gap-6">
        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-4 shadow-sm">
          <h2 className="text-lg font-semibold text-gray-900 dark:text-white">Patient Parameters</h2>
          <div>
            <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Patient Weight (kg)</label>
            <input type="number" value={weightKg} onChange={(e) => setWeightKg(parseFloat(e.target.value) || 0)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600 text-lg font-bold" />
          </div>
        </div>

        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-4 shadow-sm">
          <h2 className="text-lg font-semibold text-gray-900 dark:text-white">STAT Epinephrine 1:1000 IM Order</h2>
          <div className="p-4 bg-red-50 dark:bg-red-900/20 border border-red-200 rounded-xl space-y-2">
            <div className="text-2xl font-bold text-red-700 dark:text-red-400">{epiDose.toFixed(2)} mg IM (1 mg/mL)</div>
            <p className="text-xs text-red-800 dark:text-red-300">Administer into Anterolateral Mid-Thigh (Vastus Lateralis). Repeat every 5-15 min if symptoms persist.</p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AnaphylaxisRapidTriageFlowsheet;
