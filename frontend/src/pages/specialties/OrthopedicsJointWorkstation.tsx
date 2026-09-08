import React, { useState } from 'react';
import { Shield, Activity, Award, CheckCircle } from 'lucide-react';

export const OrthopedicsJointWorkstation: React.FC = () => {
  const [pain, setPain] = useState<number>(44);
  const [func, setFunc] = useState<number>(38);
  const [deformity, setDeformity] = useState<number>(4);
  const [motion, setMotion] = useState<number>(5);
  const [bearing, setBearing] = useState<string>('CERAMIC_ON_POLYETHYLENE');

  const totalHhs = pain + func + deformity + motion;
  const grade = totalHhs >= 90 ? 'EXCELLENT' : (totalHhs >= 80 ? 'GOOD' : (totalHhs >= 70 ? 'FAIR' : 'POOR'));

  return (
    <div className="p-6 space-y-6 max-w-7xl mx-auto">
      <div className="flex items-center justify-between border-b pb-4">
        <div className="flex items-center space-x-3">
          <div className="p-3 bg-blue-100 dark:bg-blue-900/30 text-blue-600 rounded-xl">
            <Shield className="w-8 h-8" />
          </div>
          <div>
            <h1 className="text-2xl font-bold text-gray-900 dark:text-white">Orthopedics & Joint Arthroplasty Registry</h1>
            <p className="text-sm text-gray-500">Harris Hip Score (HHS), Knee Society Score, FDA UDI implant tracking & VTE prophylaxis</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-3 gap-6">
        <div className="lg:col-span-2 bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-6 shadow-sm">
          <h2 className="text-lg font-semibold flex items-center space-x-2 text-gray-900 dark:text-white">
            <Activity className="w-5 h-5 text-blue-500" />
            <span>Harris Hip Functional Scoring</span>
          </h2>
          <div className="grid grid-cols-2 gap-4">
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Pain Score (0 - 44)</label>
              <input type="number" max="44" value={pain} onChange={(e) => setPain(parseFloat(e.target.value) || 0)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Function Score (0 - 47)</label>
              <input type="number" max="47" value={func} onChange={(e) => setFunc(parseFloat(e.target.value) || 0)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Deformity (0 - 4)</label>
              <input type="number" max="4" value={deformity} onChange={(e) => setDeformity(parseFloat(e.target.value) || 0)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Range of Motion (0 - 5)</label>
              <input type="number" max="5" value={motion} onChange={(e) => setMotion(parseFloat(e.target.value) || 0)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
          </div>
        </div>

        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-6 shadow-sm">
          <h2 className="text-lg font-semibold flex items-center space-x-2 text-gray-900 dark:text-white">
            <Award className="w-5 h-5 text-blue-500" />
            <span>Outcome Grade</span>
          </h2>
          <div className="space-y-4">
            <div className="p-4 bg-blue-50 dark:bg-blue-900/20 rounded-xl flex justify-between items-center">
              <span className="text-sm text-blue-900 dark:text-blue-200 font-medium">Total HHS Score</span>
              <span className="text-2xl font-bold text-blue-700 dark:text-blue-400">{totalHhs} / 100</span>
            </div>
            <div className="p-4 bg-gray-50 dark:bg-gray-700/50 rounded-xl flex justify-between items-center">
              <span className="text-sm text-gray-600 dark:text-gray-300">Clinical Outcome</span>
              <span className="text-md font-bold text-emerald-600">{grade}</span>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default OrthopedicsJointWorkstation;
