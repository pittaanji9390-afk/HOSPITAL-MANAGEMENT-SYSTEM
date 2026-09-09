import React, { useState } from 'react';
import { Droplets, Clock, AlertCircle, CheckCircle2 } from 'lucide-react';

export const HypoglycemiaRule15Flowsheet: React.FC = () => {
  const [glucose, setGlucose] = useState<number>(58);
  const [canSwallow, setCanSwallow] = useState<boolean>(true);

  const isSevere = glucose < 54 || !canSwallow;

  return (
    <div className="p-6 space-y-6 max-w-7xl mx-auto">
      <div className="flex items-center justify-between border-b pb-4">
        <div className="flex items-center space-x-3">
          <div className="p-3 bg-amber-100 dark:bg-amber-900/30 text-amber-600 rounded-xl">
            <Droplets className="w-8 h-8" />
          </div>
          <div>
            <h1 className="text-2xl font-bold text-gray-900 dark:text-white">Hypoglycemia Rule-of-15 Nurse Tracker</h1>
            <p className="text-sm text-gray-500">Fast-acting carbohydrate titration, IV D50W push directive & 15-minute recheck countdown</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-2 gap-6">
        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-4 shadow-sm">
          <h2 className="text-lg font-semibold text-gray-900 dark:text-white">Bedside Blood Glucose (POC)</h2>
          <div>
            <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Capillary Glucose (mg/dL)</label>
            <input type="number" value={glucose} onChange={(e) => setGlucose(parseFloat(e.target.value) || 0)} className="w-full px-4 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600 text-lg font-bold" />
          </div>
          <div className="flex items-center space-x-2">
            <input type="checkbox" id="swallow" checked={canSwallow} onChange={(e) => setCanSwallow(e.target.checked)} className="rounded text-amber-600" />
            <label htmlFor="swallow" className="text-sm font-medium text-gray-700 dark:text-gray-300">Patient is Alert & Able to Swallow Safely</label>
          </div>
        </div>

        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-4 shadow-sm">
          <h2 className="text-lg font-semibold text-gray-900 dark:text-white">Nursing Action Directive</h2>
          <div className={`p-4 rounded-xl space-y-2 ${isSevere ? 'bg-red-500 text-white' : 'bg-amber-100 text-amber-900 dark:bg-amber-900/30 dark:text-amber-200'}`}>
            <div className="text-xs font-bold uppercase">{isSevere ? '🚨 ADMINISTER D50W 25g (50 mL) IV PUSH STAT' : '⚡ ADMINISTER 15g FAST-ACTING CARBOHYDRATES'}</div>
            <p className="text-xs">{isSevere ? 'Administer D50W over 2-3 minutes. Recheck blood glucose in exactly 15 minutes.' : 'Provide 4 oz fruit juice or 4 glucose tablets. Recheck blood glucose in 15 minutes.'}</p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default HypoglycemiaRule15Flowsheet;
