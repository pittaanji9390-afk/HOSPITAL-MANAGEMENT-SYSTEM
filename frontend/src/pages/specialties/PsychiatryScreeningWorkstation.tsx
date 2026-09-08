import React, { useState } from 'react';
import { Smile, AlertOctagon, ShieldAlert, Activity } from 'lucide-react';

export const PsychiatryScreeningWorkstation: React.FC = () => {
  const [phq9, setPhq9] = useState<number>(18);
  const [gad7, setGad7] = useState<number>(14);
  const [ciwa, setCiwa] = useState<number>(12);
  const [suicidal, setSuicidal] = useState<boolean>(true);

  const depSeverity = phq9 >= 20 ? 'SEVERE' : (phq9 >= 15 ? 'MODERATELY_SEVERE' : (phq9 >= 10 ? 'MODERATE' : 'MILD'));

  return (
    <div className="p-6 space-y-6 max-w-7xl mx-auto">
      <div className="flex items-center justify-between border-b pb-4">
        <div className="flex items-center space-x-3">
          <div className="p-3 bg-indigo-100 dark:bg-indigo-900/30 text-indigo-600 rounded-xl">
            <Smile className="w-8 h-8" />
          </div>
          <div>
            <h1 className="text-2xl font-bold text-gray-900 dark:text-white">Psychiatry & Behavioral Health Screener</h1>
            <p className="text-sm text-gray-500">PHQ-9 Depression, GAD-7 Anxiety, CIWA-Ar Alcohol Withdrawal & Suicide Precautions</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-3 gap-6">
        <div className="lg:col-span-2 bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-6 shadow-sm">
          <h2 className="text-lg font-semibold flex items-center space-x-2 text-gray-900 dark:text-white">
            <Activity className="w-5 h-5 text-indigo-500" />
            <span>Validated Psychometric Batteries</span>
          </h2>
          <div className="grid grid-cols-3 gap-4">
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">PHQ-9 (0-27)</label>
              <input type="number" min="0" max="27" value={phq9} onChange={(e) => setPhq9(parseInt(e.target.value) || 0)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">GAD-7 (0-21)</label>
              <input type="number" min="0" max="21" value={gad7} onChange={(e) => setGad7(parseInt(e.target.value) || 0)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">CIWA-Ar (0-67)</label>
              <input type="number" min="0" max="67" value={ciwa} onChange={(e) => setCiwa(parseInt(e.target.value) || 0)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
          </div>
          <div className="flex items-center space-x-2 pt-2">
            <input type="checkbox" id="suicide" checked={suicidal} onChange={(e) => setSuicidal(e.target.checked)} className="rounded text-red-600" />
            <label htmlFor="suicide" className="text-sm font-semibold text-red-600 dark:text-red-400">Positive for Suicidal Ideation / Item #9 Active Thoughts</label>
          </div>
        </div>

        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-6 shadow-sm">
          <h2 className="text-lg font-semibold flex items-center space-x-2 text-gray-900 dark:text-white">
            <ShieldAlert className="w-5 h-5 text-red-500" />
            <span>Safety & Care Directives</span>
          </h2>
          <div className="space-y-4">
            <div className={`p-4 rounded-xl ${suicidal ? 'bg-red-500 text-white animate-pulse' : 'bg-green-100 text-green-900'}`}>
              <div className="text-xs font-bold uppercase">{suicidal ? '🚨 1:1 CONTINUOUS SITTER MANDATORY' : 'STANDARD OBSERVATION'}</div>
              <div className="text-xs mt-1">{suicidal ? 'Ligature-resistant room sweep, remove personal items, emergency psych consult STAT.' : 'Routine outpatient mental health referral.'}</div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default PsychiatryScreeningWorkstation;
