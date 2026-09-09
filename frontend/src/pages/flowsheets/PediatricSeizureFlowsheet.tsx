import React, { useState } from 'react';
import { Zap, Timer, AlertOctagon } from 'lucide-react';

export const PediatricSeizureFlowsheet: React.FC = () => {
  const [weightKg, setWeightKg] = useState<number>(18);
  const midazolamDose = Math.min(10.0, weightKg * 0.20);

  return (
    <div className="p-6 space-y-6 max-w-7xl mx-auto">
      <div className="flex items-center justify-between border-b pb-4">
        <div className="flex items-center space-x-3">
          <div className="p-3 bg-purple-100 dark:bg-purple-900/30 text-purple-600 rounded-xl">
            <Zap className="w-8 h-8" />
          </div>
          <div>
            <h1 className="text-2xl font-bold text-gray-900 dark:text-white">Pediatric Status Epilepticus Timed Rescue Console</h1>
            <p className="text-sm text-gray-500">Weight-based Intranasal Midazolam, IV Keppra loading dose and refractory seizure timer</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-2 gap-6">
        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-4 shadow-sm">
          <h2 className="text-lg font-semibold text-gray-900 dark:text-white">Child Weight</h2>
          <div>
            <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Weight (kg)</label>
            <input type="number" value={weightKg} onChange={(e) => setWeightKg(parseFloat(e.target.value) || 0)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600 font-bold" />
          </div>
        </div>

        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-4 shadow-sm">
          <h2 className="text-lg font-semibold text-gray-900 dark:text-white">Tier-1 Rescue Benzodiazepine</h2>
          <div className="p-4 bg-purple-50 dark:bg-purple-900/20 rounded-xl space-y-1">
            <div className="text-xl font-bold text-purple-900 dark:text-white">Intranasal Midazolam: {midazolamDose.toFixed(1)} mg (5 mg/mL)</div>
            <p className="text-xs text-purple-700 dark:text-purple-300">Deliver half dose into each nostril via mucosal atomizer device. Repeat once at 5 minutes if still seizing.</p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default PediatricSeizureFlowsheet;
