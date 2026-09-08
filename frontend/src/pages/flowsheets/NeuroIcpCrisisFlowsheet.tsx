import React, { useState } from 'react';
import { Brain, Activity, ShieldAlert } from 'lucide-react';

export const NeuroIcpCrisisFlowsheet: React.FC = () => {
  const [icp, setIcp] = useState<number>(22.0);
  const [map, setMap] = useState<number>(85.0);

  const cpp = map - icp;
  const isCrisis = icp >= 20.0 || cpp < 60.0;

  return (
    <div className="p-6 space-y-6 max-w-7xl mx-auto">
      <div className="flex items-center justify-between border-b pb-4">
        <div className="flex items-center space-x-3">
          <div className="p-3 bg-purple-100 dark:bg-purple-900/30 text-purple-600 rounded-xl">
            <Brain className="w-8 h-8" />
          </div>
          <div>
            <h1 className="text-2xl font-bold text-gray-900 dark:text-white">Neuro-ICU ICP & CPP Hemodynamics Flowsheet</h1>
            <p className="text-sm text-gray-500">Cerebral Perfusion Pressure (CPP = MAP - ICP), 3% Hypertonic Saline and EVD drainage protocol</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-2 gap-6">
        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-4 shadow-sm">
          <h2 className="text-lg font-semibold text-gray-900 dark:text-white">Intracranial Hemodynamics</h2>
          <div className="grid grid-cols-2 gap-4">
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">ICP (mmHg)</label>
              <input type="number" step="0.5" value={icp} onChange={(e) => setIcp(parseFloat(e.target.value) || 0)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Mean Arterial Pressure (mmHg)</label>
              <input type="number" step="1" value={map} onChange={(e) => setMap(parseFloat(e.target.value) || 0)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
          </div>
        </div>

        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-4 shadow-sm">
          <h2 className="text-lg font-semibold text-gray-900 dark:text-white">Calculated CPP & Interventions</h2>
          <div className={`p-4 rounded-xl space-y-2 ${isCrisis ? 'bg-red-500 text-white' : 'bg-green-100 text-green-900'}`}>
            <div className="text-xs font-bold uppercase">{isCrisis ? '🚨 ICP CRISIS: ADMINISTER 3% NaCl 250 mL BOLUS' : '✅ CPP ADEQUATE (>= 60 mmHg)'}</div>
            <div className="text-sm font-bold">Calculated CPP: {cpp.toFixed(1)} mmHg</div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default NeuroIcpCrisisFlowsheet;
