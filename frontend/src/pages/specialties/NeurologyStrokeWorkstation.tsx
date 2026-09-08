import React, { useState } from 'react';
import { Brain, Activity, Clock, ShieldCheck, AlertTriangle, FileText, CheckCircle2 } from 'lucide-react';

export const NeurologyStrokeWorkstation: React.FC = () => {
  const [nihss, setNihss] = useState<number>(14);
  const [weightKg, setWeightKg] = useState<number>(72);
  const [hoursFromOnset, setHoursFromOnset] = useState<number>(1.8);
  const [hasHemorrhage, setHasHemorrhage] = useState<boolean>(false);
  const [systolicBp, setSystolicBp] = useState<number>(165);

  const isTpaCandidate = hoursFromOnset <= 4.5 && !hasHemorrhage && systolicBp < 185 && nihss >= 4;
  const isThrombectomyCandidate = hoursFromOnset <= 24.0 && nihss >= 6 && !hasHemorrhage;
  const totalTpaDose = Math.min(90.0, weightKg * 0.9);
  const bolusTpaDose = totalTpaDose * 0.10;
  const infusionTpaDose = totalTpaDose * 0.90;

  return (
    <div className="p-6 space-y-6 max-w-7xl mx-auto">
      <div className="flex items-center justify-between border-b pb-4">
        <div className="flex items-center space-x-3">
          <div className="p-3 bg-purple-100 dark:bg-purple-900/30 text-purple-600 rounded-xl">
            <Brain className="w-8 h-8" />
          </div>
          <div>
            <h1 className="text-2xl font-bold text-gray-900 dark:text-white">Neurology Acute Stroke & NIHSS Command Console</h1>
            <p className="text-sm text-gray-500">Door-to-Needle (D2N) 45-minute target, IV Alteplase / Tenecteplase calculator & EVT triage</p>
          </div>
        </div>
        <span className={`px-3 py-1.5 rounded-full text-xs font-semibold ${isTpaCandidate ? 'bg-purple-600 text-white animate-pulse' : 'bg-gray-200 text-gray-700'}`}>
          {isTpaCandidate ? '⚡ IV THROMBOLYSIS ELIGIBLE' : '⚠️ THROMBOLYSIS CONTRAINDICATED'}
        </span>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-3 gap-6">
        <div className="lg:col-span-2 bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-6 shadow-sm">
          <h2 className="text-lg font-semibold flex items-center space-x-2 text-gray-900 dark:text-white">
            <Activity className="w-5 h-5 text-purple-500" />
            <span>Stroke Assessment Parameters</span>
          </h2>
          <div className="grid grid-cols-2 gap-4">
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">NIHSS Score (0 - 42)</label>
              <input type="number" min="0" max="42" value={nihss} onChange={(e) => setNihss(parseInt(e.target.value) || 0)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Hours from Last Known Well</label>
              <input type="number" step="0.1" value={hoursFromOnset} onChange={(e) => setHoursFromOnset(parseFloat(e.target.value) || 0)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Patient Weight (kg)</label>
              <input type="number" value={weightKg} onChange={(e) => setWeightKg(parseFloat(e.target.value) || 0)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Systolic Blood Pressure (mmHg)</label>
              <input type="number" value={systolicBp} onChange={(e) => setSystolicBp(parseFloat(e.target.value) || 0)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
          </div>
          <div className="flex items-center space-x-2">
            <input type="checkbox" id="hemorrhage" checked={hasHemorrhage} onChange={(e) => setHasHemorrhage(e.target.checked)} className="rounded text-purple-600" />
            <label htmlFor="hemorrhage" className="text-sm font-medium text-red-600 dark:text-red-400">CT Evidence of Intracranial Hemorrhage (ICH)</label>
          </div>
        </div>

        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-6 shadow-sm">
          <h2 className="text-lg font-semibold flex items-center space-x-2 text-gray-900 dark:text-white">
            <Clock className="w-5 h-5 text-purple-500" />
            <span>Alteplase (rtPA) Dosing</span>
          </h2>
          <div className="space-y-3">
            <div className="p-3 bg-purple-50 dark:bg-purple-900/20 rounded-xl flex justify-between items-center">
              <span className="text-xs text-purple-800 dark:text-purple-300 font-medium">Total Dose (0.9 mg/kg)</span>
              <span className="text-lg font-bold text-purple-900 dark:text-white">{totalTpaDose.toFixed(1)} mg</span>
            </div>
            <div className="p-3 bg-gray-50 dark:bg-gray-700/50 rounded-xl flex justify-between items-center">
              <span className="text-xs text-gray-600 dark:text-gray-300">10% IV Bolus (Over 1 min)</span>
              <span className="text-md font-bold text-gray-800 dark:text-white">{bolusTpaDose.toFixed(1)} mg</span>
            </div>
            <div className="p-3 bg-gray-50 dark:bg-gray-700/50 rounded-xl flex justify-between items-center">
              <span className="text-xs text-gray-600 dark:text-gray-300">90% IV Infusion (Over 60 min)</span>
              <span className="text-md font-bold text-gray-800 dark:text-white">{infusionTpaDose.toFixed(1)} mg</span>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default NeurologyStrokeWorkstation;
