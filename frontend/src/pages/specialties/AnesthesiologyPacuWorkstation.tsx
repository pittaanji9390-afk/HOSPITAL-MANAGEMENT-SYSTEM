import React, { useState } from 'react';
import { Activity, ShieldCheck, Clock, CheckCircle2 } from 'lucide-react';

export const AnesthesiologyPacuWorkstation: React.FC = () => {
  const [asa, setAsa] = useState<string>('ASA_III');
  const [mallampati, setMallampati] = useState<number>(2);
  const [activity, setActivity] = useState<number>(2);
  const [respiration, setRespiration] = useState<number>(2);
  const [circulation, setCirculation] = useState<number>(2);
  const [consciousness, setConsciousness] = useState<number>(2);
  const [o2Sat, setO2Sat] = useState<number>(2);

  const aldrete = activity + respiration + circulation + consciousness + o2Sat;
  const isDischargeReady = aldrete >= 9;

  return (
    <div className="p-6 space-y-6 max-w-7xl mx-auto">
      <div className="flex items-center justify-between border-b pb-4">
        <div className="flex items-center space-x-3">
          <div className="p-3 bg-violet-100 dark:bg-violet-900/30 text-violet-600 rounded-xl">
            <Activity className="w-8 h-8" />
          </div>
          <div>
            <h1 className="text-2xl font-bold text-gray-900 dark:text-white">Anesthesiology & PACU Recovery Flowsheet</h1>
            <p className="text-sm text-gray-500">ASA Physical Status, Mallampati Airway Grade & Modified Aldrete Discharge Score (Target >= 9/10)</p>
          </div>
        </div>
        <span className={`px-3 py-1.5 rounded-full text-xs font-semibold ${isDischargeReady ? 'bg-emerald-600 text-white' : 'bg-amber-500 text-white'}`}>
          {isDischargeReady ? '✅ PACU DISCHARGE CRITERIA MET' : '⏳ PACU OBSERVATION IN PROGRESS'}
        </span>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-3 gap-6">
        <div className="lg:col-span-2 bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-6 shadow-sm">
          <h2 className="text-lg font-semibold flex items-center space-x-2 text-gray-900 dark:text-white">
            <Activity className="w-5 h-5 text-violet-500" />
            <span>Modified Aldrete Score Components (0-2 each)</span>
          </h2>
          <div className="grid grid-cols-2 gap-4">
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Activity (Moves Extremities)</label>
              <input type="number" min="0" max="2" value={activity} onChange={(e) => setActivity(parseInt(e.target.value) || 0)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Respiration (Breathing/Cough)</label>
              <input type="number" min="0" max="2" value={respiration} onChange={(e) => setRespiration(parseInt(e.target.value) || 0)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Circulation (BP +/- 20% Pre-op)</label>
              <input type="number" min="0" max="2" value={circulation} onChange={(e) => setCirculation(parseInt(e.target.value) || 0)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Consciousness (Fully Awake)</label>
              <input type="number" min="0" max="2" value={consciousness} onChange={(e) => setConsciousness(parseInt(e.target.value) || 0)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
          </div>
        </div>

        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-6 shadow-sm">
          <h2 className="text-lg font-semibold flex items-center space-x-2 text-gray-900 dark:text-white">
            <Clock className="w-5 h-5 text-violet-500" />
            <span>PACU Summary</span>
          </h2>
          <div className="space-y-4">
            <div className="p-4 bg-violet-50 dark:bg-violet-900/20 rounded-xl flex justify-between items-center">
              <span className="text-sm text-violet-900 dark:text-violet-200 font-medium">Total Aldrete Score</span>
              <span className="text-2xl font-bold text-violet-700 dark:text-violet-400">{aldrete} / 10</span>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AnesthesiologyPacuWorkstation;
