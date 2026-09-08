import React, { useState } from 'react';
import { ShieldAlert, Activity, CheckCircle2, AlertOctagon } from 'lucide-react';

export const TransfusionHemovigilanceFlowsheet: React.FC = () => {
  const [baselineTemp, setBaselineTemp] = useState<number>(37.0);
  const [currentTemp, setCurrentTemp] = useState<number>(38.4);
  const [hasDyspnea, setHasDyspnea] = useState<boolean>(false);
  const [hasHypotension, setHasHypotension] = useState<boolean>(false);

  const deltaTemp = currentTemp - baselineTemp;
  const isReaction = deltaTemp >= 1.0 || hasDyspnea || hasHypotension;

  return (
    <div className="p-6 space-y-6 max-w-7xl mx-auto">
      <div className="flex items-center justify-between border-b pb-4">
        <div className="flex items-center space-x-3">
          <div className="p-3 bg-red-100 dark:bg-red-900/30 text-red-600 rounded-xl">
            <ShieldAlert className="w-8 h-8" />
          </div>
          <div>
            <h1 className="text-2xl font-bold text-gray-900 dark:text-white">Blood Transfusion Hemovigilance Monitor</h1>
            <p className="text-sm text-gray-500">15-minute vital sign surveillance, acute hemolytic reaction triggers and TRALI/TACO alerts</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-2 gap-6">
        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-4 shadow-sm">
          <h2 className="text-lg font-semibold text-gray-900 dark:text-white">Vital Signs Comparison</h2>
          <div className="grid grid-cols-2 gap-4">
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Baseline Temp (°C)</label>
              <input type="number" step="0.1" value={baselineTemp} onChange={(e) => setBaselineTemp(parseFloat(e.target.value) || 0)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">15-min Transfusion Temp (°C)</label>
              <input type="number" step="0.1" value={currentTemp} onChange={(e) => setCurrentTemp(parseFloat(e.target.value) || 0)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
          </div>
        </div>

        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-4 shadow-sm">
          <h2 className="text-lg font-semibold text-gray-900 dark:text-white">Hemovigilance Safety Triage</h2>
          <div className={`p-4 rounded-xl space-y-2 ${isReaction ? 'bg-red-500 text-white animate-pulse' : 'bg-green-100 text-green-900'}`}>
            <div className="text-xs font-bold uppercase">{isReaction ? '🚨 STOP TRANSFUSION IMMEDIATELY' : '✅ TRANSFUSION PROCEEDING NORMALLY'}</div>
            <p className="text-xs">{isReaction ? 'Disconnect blood unit tubing. Maintain IV line with new 0.9% Normal Saline. Return blood bag to Blood Bank for DAT and workup.' : 'Continue infusion at prescribed flow rate. Recheck vitals at 30 min and 60 min.'}</p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default TransfusionHemovigilanceFlowsheet;
