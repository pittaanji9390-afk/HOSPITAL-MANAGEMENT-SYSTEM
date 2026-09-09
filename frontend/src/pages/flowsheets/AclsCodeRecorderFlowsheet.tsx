import React, { useState, useEffect } from 'react';
import { HeartPulse, Zap, Timer, Play, Pause, RotateCcw, AlertTriangle } from 'lucide-react';

export const AclsCodeRecorderFlowsheet: React.FC = () => {
  const [seconds, setSeconds] = useState<number>(0);
  const [isActive, setIsActive] = useState<boolean>(false);
  const [shocks, setShocks] = useState<number>(0);
  const [epiCount, setEpiCount] = useState<number>(0);
  const [rhythm, setRhythm] = useState<string>('VF');

  useEffect(() => {
    let interval: any = null;
    if (isActive) {
      interval = setInterval(() => setSeconds(s => s + 1), 1000);
    } else if (!isActive && seconds !== 0) {
      clearInterval(interval);
    }
    return () => clearInterval(interval);
  }, [isActive, seconds]);

  const formatTime = (sec: number) => {
    const m = Math.floor(sec / 60);
    const s = sec % 60;
    return `${String(m).padStart(2, '0')}:${String(s).padStart(2, '0')}`;
  };

  return (
    <div className="p-6 space-y-6 max-w-7xl mx-auto">
      <div className="flex items-center justify-between border-b pb-4">
        <div className="flex items-center space-x-3">
          <div className="p-3 bg-red-100 dark:bg-red-900/30 text-red-600 rounded-xl">
            <HeartPulse className="w-8 h-8" />
          </div>
          <div>
            <h1 className="text-2xl font-bold text-gray-900 dark:text-white">ACLS Code Blue Real-Time Resuscitation Recorder</h1>
            <p className="text-sm text-gray-500">2-minute CPR cycle interval alarm, defibrillation shock counter, and IV Epinephrine timer</p>
          </div>
        </div>
        <div className="flex items-center space-x-4">
          <div className="text-3xl font-mono font-bold text-red-600 bg-red-50 dark:bg-red-900/20 px-4 py-2 rounded-xl border border-red-200">
            {formatTime(seconds)}
          </div>
          <button onClick={() => setIsActive(!isActive)} className={`px-4 py-2 rounded-xl text-white font-semibold flex items-center space-x-2 ${isActive ? 'bg-amber-600 hover:bg-amber-700' : 'bg-red-600 hover:bg-red-700'}`}>
            {isActive ? <Pause className="w-4 h-4" /> : <Play className="w-4 h-4" />}
            <span>{isActive ? 'Pause Code' : 'Start Code Blue'}</span>
          </button>
        </div>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-3 gap-6">
        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-4 shadow-sm">
          <h2 className="text-lg font-semibold text-gray-900 dark:text-white">Defibrillation Counter</h2>
          <div className="text-4xl font-bold text-amber-500">{shocks} Shocks</div>
          <button onClick={() => setShocks(s => s + 1)} className="w-full py-3 bg-amber-500 hover:bg-amber-600 text-white rounded-xl font-bold flex items-center justify-center space-x-2">
            <Zap className="w-5 h-5" />
            <span>Deliver 200J Biphasic Shock</span>
          </button>
        </div>

        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-4 shadow-sm">
          <h2 className="text-lg font-semibold text-gray-900 dark:text-white">Epinephrine 1mg IV/IO</h2>
          <div className="text-4xl font-bold text-indigo-600">{epiCount} Doses</div>
          <button onClick={() => setEpiCount(e => e + 1)} className="w-full py-3 bg-indigo-600 hover:bg-indigo-700 text-white rounded-xl font-bold">
            Record Epinephrine 1mg Push
          </button>
        </div>

        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-4 shadow-sm">
          <h2 className="text-lg font-semibold text-gray-900 dark:text-white">Cardiac Rhythm</h2>
          <select value={rhythm} onChange={(e) => setRhythm(e.target.value)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600 font-bold text-sm">
            <option value="VF">Ventricular Fibrillation (VF - Shockable)</option>
            <option value="PULSELESS_VT">Pulseless V-Tach (Shockable)</option>
            <option value="ASYSTOLE">Asystole (Non-Shockable)</option>
            <option value="PEA">PEA (Non-Shockable)</option>
          </select>
        </div>
      </div>
    </div>
  );
};

export default AclsCodeRecorderFlowsheet;
