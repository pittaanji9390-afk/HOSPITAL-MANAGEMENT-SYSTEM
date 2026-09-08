import React, { useState } from 'react';
import { Sparkles, Activity, ShieldAlert } from 'lucide-react';

export const DermatologyWoundWorkstation: React.FC = () => {
  const [sensory, setSensory] = useState<number>(2);
  const [moisture, setMoisture] = useState<number>(2);
  const [activity, setActivity] = useState<number>(2);
  const [mobility, setMobility] = useState<number>(2);
  const [nutrition, setNutrition] = useState<number>(2);
  const [friction, setFriction] = useState<number>(1);
  const [pasi, setPasi] = useState<number>(12.5);

  const braden = sensory + moisture + activity + mobility + nutrition + friction;
  const risk = braden <= 9 ? 'VERY_HIGH_RISK' : (braden <= 12 ? 'HIGH_RISK' : (braden <= 14 ? 'MODERATE_RISK' : (braden <= 18 ? 'MILD_RISK' : 'NO_RISK')));

  return (
    <div className="p-6 space-y-6 max-w-7xl mx-auto">
      <div className="flex items-center justify-between border-b pb-4">
        <div className="flex items-center space-x-3">
          <div className="p-3 bg-orange-100 dark:bg-orange-900/30 text-orange-600 rounded-xl">
            <Sparkles className="w-8 h-8" />
          </div>
          <div>
            <h1 className="text-2xl font-bold text-gray-900 dark:text-white">Dermatology & Wound Care Braden Console</h1>
            <p className="text-sm text-gray-500">Braden Pressure Injury Risk Scale, PUSH tool wound healing & PASI Psoriasis Area Index</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-3 gap-6">
        <div className="lg:col-span-2 bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-6 shadow-sm">
          <h2 className="text-lg font-semibold flex items-center space-x-2 text-gray-900 dark:text-white">
            <Activity className="w-5 h-5 text-orange-500" />
            <span>Braden Risk Scoring Matrix</span>
          </h2>
          <div className="grid grid-cols-3 gap-4">
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Sensory Perception (1-4)</label>
              <input type="number" min="1" max="4" value={sensory} onChange={(e) => setSensory(parseInt(e.target.value) || 1)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Moisture (1-4)</label>
              <input type="number" min="1" max="4" value={moisture} onChange={(e) => setMoisture(parseInt(e.target.value) || 1)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Activity (1-4)</label>
              <input type="number" min="1" max="4" value={activity} onChange={(e) => setActivity(parseInt(e.target.value) || 1)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Mobility (1-4)</label>
              <input type="number" min="1" max="4" value={mobility} onChange={(e) => setMobility(parseInt(e.target.value) || 1)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Nutrition (1-4)</label>
              <input type="number" min="1" max="4" value={nutrition} onChange={(e) => setNutrition(parseInt(e.target.value) || 1)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Friction & Shear (1-3)</label>
              <input type="number" min="1" max="3" value={friction} onChange={(e) => setFriction(parseInt(e.target.value) || 1)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
          </div>
        </div>

        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-6 shadow-sm">
          <h2 className="text-lg font-semibold flex items-center space-x-2 text-gray-900 dark:text-white">
            <ShieldAlert className="w-5 h-5 text-orange-500" />
            <span>Pressure Injury Risk</span>
          </h2>
          <div className="space-y-4">
            <div className="p-4 bg-orange-50 dark:bg-orange-900/20 rounded-xl flex justify-between items-center">
              <span className="text-sm text-orange-900 dark:text-orange-200 font-medium">Total Braden Score</span>
              <span className="text-2xl font-bold text-orange-700 dark:text-orange-400">{braden} / 23</span>
            </div>
            <div className="p-4 bg-gray-50 dark:bg-gray-700/50 rounded-xl flex justify-between items-center">
              <span className="text-sm text-gray-600 dark:text-gray-300">Risk Category</span>
              <span className="text-md font-bold text-red-600">{risk}</span>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default DermatologyWoundWorkstation;
