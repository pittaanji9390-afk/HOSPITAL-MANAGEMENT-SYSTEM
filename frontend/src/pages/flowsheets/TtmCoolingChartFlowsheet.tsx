import React, { useState } from 'react';
import { Snowflake, Thermometer, Activity, Clock } from 'lucide-react';

export const TtmCoolingChartFlowsheet: React.FC = () => {
  const [targetTemp, setTargetTemp] = useState<number>(36.0);
  const [coreTemp, setCoreTemp] = useState<number>(35.8);

  return (
    <div className="p-6 space-y-6 max-w-7xl mx-auto">
      <div className="flex items-center justify-between border-b pb-4">
        <div className="flex items-center space-x-3">
          <div className="p-3 bg-blue-100 dark:bg-blue-900/30 text-blue-600 rounded-xl">
            <Snowflake className="w-8 h-8" />
          </div>
          <div>
            <h1 className="text-2xl font-bold text-gray-900 dark:text-white">Targeted Temperature Management (TTM) Cooling Chart</h1>
            <p className="text-sm text-gray-500">Post-cardiac arrest neuroprotective cooling maintenance and controlled 0.25°C/hr rewarming flowsheet</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-2 gap-6">
        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-4 shadow-sm">
          <h2 className="text-lg font-semibold text-gray-900 dark:text-white">Temperature Controls</h2>
          <div className="grid grid-cols-2 gap-4">
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Target Core Temp (°C)</label>
              <input type="number" step="0.5" value={targetTemp} onChange={(e) => setTargetTemp(parseFloat(e.target.value) || 36)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Current Esophageal/Bladder Temp (°C)</label>
              <input type="number" step="0.1" value={coreTemp} onChange={(e) => setCoreTemp(parseFloat(e.target.value) || 36)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
          </div>
        </div>

        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-4 shadow-sm">
          <h2 className="text-lg font-semibold text-gray-900 dark:text-white">BSAS Shivering Protocol</h2>
          <div className="p-4 bg-blue-50 dark:bg-blue-900/20 rounded-xl text-xs space-y-1">
            <span className="font-bold text-blue-900 dark:text-blue-200">Bedside Shivering Assessment Scale (BSAS)</span>
            <p className="text-blue-800 dark:text-blue-300">Target BSAS 0. Administer scheduled IV Acetaminophen + IV Magnesium Sulfate (maintain serum Mg 3.0-4.0 mg/dL).</p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default TtmCoolingChartFlowsheet;
