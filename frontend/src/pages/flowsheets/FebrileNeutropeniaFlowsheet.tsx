import React, { useState } from 'react';
import { Flame, Clock, AlertTriangle, ShieldCheck } from 'lucide-react';

export const FebrileNeutropeniaFlowsheet: React.FC = () => {
  const [anc, setAnc] = useState<number>(350);
  const [temp, setTemp] = useState<number>(38.6);

  const isSevere = anc < 500 && temp >= 38.0;

  return (
    <div className="p-6 space-y-6 max-w-7xl mx-auto">
      <div className="flex items-center justify-between border-b pb-4">
        <div className="flex items-center space-x-3">
          <div className="p-3 bg-red-100 dark:bg-red-900/30 text-red-600 rounded-xl">
            <Flame className="w-8 h-8" />
          </div>
          <div>
            <h1 className="text-2xl font-bold text-gray-900 dark:text-white">Febrile Neutropenia 60-Minute Antibiotic Timer</h1>
            <p className="text-sm text-gray-500">Absolute Neutrophil Count (ANC), blood cultures & STAT IV antipseudomonal beta-lactam</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-2 gap-6">
        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-4 shadow-sm">
          <h2 className="text-lg font-semibold text-gray-900 dark:text-white">ANC & Temperature</h2>
          <div className="grid grid-cols-2 gap-4">
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">ANC (/uL)</label>
              <input type="number" value={anc} onChange={(e) => setAnc(parseInt(e.target.value) || 0)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Oral/Axillary Temp (°C)</label>
              <input type="number" step="0.1" value={temp} onChange={(e) => setTemp(parseFloat(e.target.value) || 0)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
          </div>
        </div>

        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-4 shadow-sm">
          <h2 className="text-lg font-semibold text-gray-900 dark:text-white">Emergency Directive</h2>
          <div className={`p-4 rounded-xl space-y-2 ${isSevere ? 'bg-red-500 text-white animate-pulse' : 'bg-green-100 text-green-900'}`}>
            <div className="text-xs font-bold uppercase">{isSevere ? '🚨 SEVERE FEBRILE NEUTROPENIA: INFUSE CEFEPIME 2g STAT' : 'ROUTINE SURVEILLANCE'}</div>
            <p className="text-xs">{isSevere ? 'Blood cultures x2 sets drawn immediately, then hang IV Cefepime within 60 minutes of fever spike.' : 'Continue neutropenic precautions and daily ANC tracking.'}</p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default FebrileNeutropeniaFlowsheet;
