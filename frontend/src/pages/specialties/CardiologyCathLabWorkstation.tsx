import React, { useState } from 'react';
import { Heart, Activity, AlertCircle, Clock, Zap, CheckCircle2, Stethoscope, ShieldAlert } from 'lucide-react';

export const CardiologyCathLabWorkstation: React.FC = () => {
  const [stElevation, setStElevation] = useState<number>(2.5);
  const [territory, setTerritory] = useState<string>('ANTERIOR');
  const [age, setAge] = useState<number>(62);
  const [hasDiabetes, setHasDiabetes] = useState<boolean>(true);
  const [systolicBp, setSystolicBp] = useState<number>(115);
  const [heartRate, setHeartRate] = useState<number>(88);

  const isCathLabActivated = stElevation >= 1.5;
  const timiScore = (age >= 75 ? 3 : (age >= 65 ? 2 : 0)) + (hasDiabetes ? 1 : 0) + (systolicBp < 100 ? 3 : 0) + (heartRate > 100 ? 2 : 0) + (stElevation >= 2.0 ? 1 : 0);
  const graceMortality = Math.min(65.0, (age * 0.4) + (heartRate * 0.15) + (systolicBp < 100 ? 15.0 : 2.0));

  return (
    <div className="p-6 space-y-6 max-w-7xl mx-auto">
      <div className="flex items-center justify-between border-b pb-4">
        <div className="flex items-center space-x-3">
          <div className="p-3 bg-red-100 dark:bg-red-900/30 text-red-600 rounded-xl">
            <Heart className="w-8 h-8" />
          </div>
          <div>
            <h1 className="text-2xl font-bold text-gray-900 dark:text-white">Cardiology Cath Lab & STEMI Command Console</h1>
            <p className="text-sm text-gray-500">Real-time Door-to-Balloon (D2B) surveillance and TIMI / GRACE acute coronary risk engine</p>
          </div>
        </div>
        <div className="flex items-center space-x-3">
          <span className={`px-3 py-1.5 rounded-full text-xs font-semibold ${isCathLabActivated ? 'bg-red-500 text-white animate-pulse' : 'bg-green-100 text-green-700'}`}>
            {isCathLabActivated ? '🚨 CODE STEMI ACTIVE' : '✅ HEMODYNAMICS STABLE'}
          </span>
        </div>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-3 gap-6">
        <div className="lg:col-span-2 bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-6 shadow-sm">
          <h2 className="text-lg font-semibold flex items-center space-x-2 text-gray-900 dark:text-white">
            <Activity className="w-5 h-5 text-red-500" />
            <span>Acute Ischemia Parameters</span>
          </h2>
          <div className="grid grid-cols-2 gap-4">
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">ST-Segment Elevation (mm)</label>
              <input type="number" step="0.1" value={stElevation} onChange={(e) => setStElevation(parseFloat(e.target.value) || 0)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Infarct Territory</label>
              <select value={territory} onChange={(e) => setTerritory(e.target.value)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600">
                <option value="ANTERIOR">Anterior (LAD)</option>
                <option value="INFERIOR">Inferior (RCA)</option>
                <option value="LATERAL">Lateral (LCx)</option>
                <option value="POSTERIOR">Posterior</option>
              </select>
            </div>
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Patient Age (years)</label>
              <input type="number" value={age} onChange={(e) => setAge(parseInt(e.target.value) || 0)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Systolic BP (mmHg)</label>
              <input type="number" value={systolicBp} onChange={(e) => setSystolicBp(parseFloat(e.target.value) || 0)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
          </div>
          <div className="flex items-center space-x-2">
            <input type="checkbox" id="diabetes" checked={hasDiabetes} onChange={(e) => setHasDiabetes(e.target.checked)} className="rounded text-red-600" />
            <label htmlFor="diabetes" className="text-sm font-medium text-gray-700 dark:text-gray-300">History of Diabetes Mellitus / Prior Angina</label>
          </div>
        </div>

        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-6 shadow-sm">
          <h2 className="text-lg font-semibold flex items-center space-x-2 text-gray-900 dark:text-white">
            <Zap className="w-5 h-5 text-amber-500" />
            <span>Risk Stratification</span>
          </h2>
          <div className="space-y-4">
            <div className="p-4 bg-gray-50 dark:bg-gray-700/50 rounded-xl flex justify-between items-center">
              <span className="text-sm text-gray-600 dark:text-gray-300">TIMI Risk Score</span>
              <span className="text-xl font-bold text-red-600">{timiScore} / 14</span>
            </div>
            <div className="p-4 bg-gray-50 dark:bg-gray-700/50 rounded-xl flex justify-between items-center">
              <span className="text-sm text-gray-600 dark:text-gray-300">GRACE In-Hospital Mortality</span>
              <span className="text-xl font-bold text-amber-600">{graceMortality.toFixed(1)}%</span>
            </div>
            <div className="p-4 bg-red-50 dark:bg-red-900/20 border border-red-200 rounded-xl space-y-2">
              <div className="flex items-center space-x-2 text-red-700 font-semibold text-xs">
                <ShieldAlert className="w-4 h-4" />
                <span>DIRECTIVE PROTOCOL</span>
              </div>
              <p className="text-xs text-red-800 dark:text-red-300">Aspirin 325mg STAT + Ticagrelor 180mg load + Heparin 60 U/kg IV bolus. Transfer immediately to Cath Lab Suite 1.</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default CardiologyCathLabWorkstation;
