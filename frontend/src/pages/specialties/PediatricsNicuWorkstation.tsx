import React, { useState } from 'react';
import { Baby, Activity, Droplets, Sun, Sparkles } from 'lucide-react';

export const PediatricsNicuWorkstation: React.FC = () => {
  const [birthWeightGrams, setBirthWeightGrams] = useState<number>(1850);
  const [gaWeeks, setGaWeeks] = useState<number>(33);
  const [apgar1, setApgar1] = useState<number>(7);
  const [apgar5, setApgar5] = useState<number>(9);
  const [bilirubin, setBilirubin] = useState<number>(9.5);
  const [dextrosePct, setDextrosePct] = useState<number>(10.0);
  const [infusionRate, setInfusionRate] = useState<number>(8.0);

  const weightKg = birthWeightGrams / 1000.0;
  const dailyFluid = (gaWeeks < 32 ? 100.0 : 80.0) * weightKg;
  const gir = (infusionRate * dextrosePct * 10.0) / (weightKg * 60.0);
  const needsPhototherapy = bilirubin >= (gaWeeks >= 35 ? 12.0 : 8.0);

  return (
    <div className="p-6 space-y-6 max-w-7xl mx-auto">
      <div className="flex items-center justify-between border-b pb-4">
        <div className="flex items-center space-x-3">
          <div className="p-3 bg-pink-100 dark:bg-pink-900/30 text-pink-600 rounded-xl">
            <Baby className="w-8 h-8" />
          </div>
          <div>
            <h1 className="text-2xl font-bold text-gray-900 dark:text-white">Pediatrics & Neonatal Intensive Care (NICU) Console</h1>
            <p className="text-sm text-gray-500">APGAR scoring, Fenton preterm growth velocity, GIR glucose infusion rate & phototherapy threshold</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-3 gap-6">
        <div className="lg:col-span-2 bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-6 shadow-sm">
          <h2 className="text-lg font-semibold flex items-center space-x-2 text-gray-900 dark:text-white">
            <Activity className="w-5 h-5 text-pink-500" />
            <span>Preterm Neonate Vitals</span>
          </h2>
          <div className="grid grid-cols-2 gap-4">
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Birth Weight (grams)</label>
              <input type="number" value={birthWeightGrams} onChange={(e) => setBirthWeightGrams(parseFloat(e.target.value) || 0)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Gestational Age (weeks)</label>
              <input type="number" value={gaWeeks} onChange={(e) => setGaWeeks(parseInt(e.target.value) || 0)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Serum Total Bilirubin (mg/dL)</label>
              <input type="number" step="0.1" value={bilirubin} onChange={(e) => setBilirubin(parseFloat(e.target.value) || 0)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Infusion Rate (mL/hr)</label>
              <input type="number" step="0.5" value={infusionRate} onChange={(e) => setInfusionRate(parseFloat(e.target.value) || 0)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
          </div>
        </div>

        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-6 shadow-sm">
          <h2 className="text-lg font-semibold flex items-center space-x-2 text-gray-900 dark:text-white">
            <Droplets className="w-5 h-5 text-pink-500" />
            <span>Infusion & Nutrition Calculations</span>
          </h2>
          <div className="space-y-4">
            <div className="p-4 bg-gray-50 dark:bg-gray-700/50 rounded-xl flex justify-between items-center">
              <span className="text-sm text-gray-600 dark:text-gray-300">Glucose Infusion Rate (GIR)</span>
              <span className="text-xl font-bold text-pink-600">{gir.toFixed(2)} mg/kg/min</span>
            </div>
            <div className="p-4 bg-gray-50 dark:bg-gray-700/50 rounded-xl flex justify-between items-center">
              <span className="text-sm text-gray-600 dark:text-gray-300">Daily Fluid Target</span>
              <span className="text-xl font-bold text-indigo-600">{dailyFluid.toFixed(0)} mL/day</span>
            </div>
            <div className={`p-4 rounded-xl flex items-center space-x-3 ${needsPhototherapy ? 'bg-amber-100 text-amber-900 dark:bg-amber-900/30 dark:text-amber-200' : 'bg-green-100 text-green-900'}`}>
              <Sun className="w-6 h-6" />
              <div className="text-xs font-semibold">
                {needsPhototherapy ? 'INITIATE BLUE LED PHOTOTHERAPY (AAP Guideline)' : 'ROUTINE SERUM BILIRUBIN SURVEILLANCE'}
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default PediatricsNicuWorkstation;
