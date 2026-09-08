import React, { useState } from 'react';
import { Wind, Gauge, Activity, AlertOctagon, CheckCircle2 } from 'lucide-react';

export const PulmonologyVentilatorWorkstation: React.FC = () => {
  const [paO2, setPaO2] = useState<number>(92);
  const [fiO2, setFiO2] = useState<number>(0.40);
  const [respRate, setRespRate] = useState<number>(18);
  const [tidalVolume, setTidalVolume] = useState<number>(0.45);
  const [peep, setPeep] = useState<number>(5.0);

  const pfRatio = paO2 / Math.max(0.21, fiO2);
  const rsbi = respRate / Math.max(0.1, tidalVolume);
  const isExtubationReady = rsbi < 105 && pfRatio >= 200 && peep <= 8.0;

  return (
    <div className="p-6 space-y-6 max-w-7xl mx-auto">
      <div className="flex items-center justify-between border-b pb-4">
        <div className="flex items-center space-x-3">
          <div className="p-3 bg-cyan-100 dark:bg-cyan-900/30 text-cyan-600 rounded-xl">
            <Wind className="w-8 h-8" />
          </div>
          <div>
            <h1 className="text-2xl font-bold text-gray-900 dark:text-white">Pulmonology & Ventilator Weaning Console</h1>
            <p className="text-sm text-gray-500">ARDS Berlin Severity Grading, Tobin RSBI Index & Spontaneous Breathing Trial (SBT) Protocol</p>
          </div>
        </div>
        <span className={`px-3 py-1.5 rounded-full text-xs font-semibold ${isExtubationReady ? 'bg-emerald-600 text-white' : 'bg-amber-500 text-white'}`}>
          {isExtubationReady ? '✅ SBT EXTUBATION READY' : '⏳ MECHANICAL VENTILATION DEPENDENT'}
        </span>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-3 gap-6">
        <div className="lg:col-span-2 bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-6 shadow-sm">
          <h2 className="text-lg font-semibold flex items-center space-x-2 text-gray-900 dark:text-white">
            <Gauge className="w-5 h-5 text-cyan-500" />
            <span>Ventilator & ABG Parameters</span>
          </h2>
          <div className="grid grid-cols-2 gap-4">
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">PaO2 (mmHg)</label>
              <input type="number" value={paO2} onChange={(e) => setPaO2(parseFloat(e.target.value) || 0)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">FiO2 Fraction (0.21 - 1.0)</label>
              <input type="number" step="0.05" value={fiO2} onChange={(e) => setFiO2(parseFloat(e.target.value) || 0.21)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Respiratory Rate (breaths/min)</label>
              <input type="number" value={respRate} onChange={(e) => setRespRate(parseInt(e.target.value) || 0)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Tidal Volume (Liters)</label>
              <input type="number" step="0.05" value={tidalVolume} onChange={(e) => setTidalVolume(parseFloat(e.target.value) || 0.1)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
          </div>
        </div>

        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-6 shadow-sm">
          <h2 className="text-lg font-semibold flex items-center space-x-2 text-gray-900 dark:text-white">
            <Activity className="w-5 h-5 text-cyan-500" />
            <span>Weaning Indices</span>
          </h2>
          <div className="space-y-4">
            <div className="p-4 bg-gray-50 dark:bg-gray-700/50 rounded-xl flex justify-between items-center">
              <span className="text-sm text-gray-600 dark:text-gray-300">P/F Ratio</span>
              <span className="text-xl font-bold text-cyan-600">{pfRatio.toFixed(1)}</span>
            </div>
            <div className="p-4 bg-gray-50 dark:bg-gray-700/50 rounded-xl flex justify-between items-center">
              <span className="text-sm text-gray-600 dark:text-gray-300">Tobin RSBI</span>
              <span className="text-xl font-bold text-indigo-600">{rsbi.toFixed(1)} bpm/L</span>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default PulmonologyVentilatorWorkstation;
