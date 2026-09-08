import React, { useState } from 'react';
import { Film, Zap, Activity, AlertTriangle, ShieldCheck } from 'lucide-react';

export const RadiologyRisWorkstation: React.FC = () => {
  const [modality, setModality] = useState<string>('CT');
  const [acrScore, setAcrScore] = useState<number>(8);
  const [examDose, setExamDose] = useState<number>(7.5);
  const [priorDose, setPriorDose] = useState<number>(42.0);

  const totalDose = priorDose + examDose;
  const isHighExposure = totalDose >= 100.0;

  return (
    <div className="p-6 space-y-6 max-w-7xl mx-auto">
      <div className="flex items-center justify-between border-b pb-4">
        <div className="flex items-center space-x-3">
          <div className="p-3 bg-blue-100 dark:bg-blue-900/30 text-blue-600 rounded-xl">
            <Film className="w-8 h-8" />
          </div>
          <div>
            <h1 className="text-2xl font-bold text-gray-900 dark:text-white">Radiology RIS & Radiation Dose Index Registry</h1>
            <p className="text-sm text-gray-500">DICOM Modality Worklist (MWL), ACR Appropriateness Criteria & Cumulative Lifetime Dose (mSv)</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-3 gap-6">
        <div className="lg:col-span-2 bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-6 shadow-sm">
          <h2 className="text-lg font-semibold flex items-center space-x-2 text-gray-900 dark:text-white">
            <Activity className="w-5 h-5 text-blue-500" />
            <span>Imaging Protocol Parameters</span>
          </h2>
          <div className="grid grid-cols-2 gap-4">
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Imaging Modality</label>
              <select value={modality} onChange={(e) => setModality(e.target.value)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600">
                <option value="CT">Computed Tomography (CT)</option>
                <option value="MRI">Magnetic Resonance Imaging (MRI - 0 mSv)</option>
                <option value="XRAY">Digital Radiography (X-Ray)</option>
                <option value="PET">PET-CT Molecular Imaging</option>
              </select>
            </div>
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">ACR Appropriateness Score (1 - 9)</label>
              <input type="number" min="1" max="9" value={acrScore} onChange={(e) => setAcrScore(parseInt(e.target.value) || 1)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Estimated Exam Dose (mSv)</label>
              <input type="number" step="0.5" value={examDose} onChange={(e) => setExamDose(parseFloat(e.target.value) || 0)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Prior Lifetime Dose (mSv)</label>
              <input type="number" step="1.0" value={priorDose} onChange={(e) => setPriorDose(parseFloat(e.target.value) || 0)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
          </div>
        </div>

        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-6 shadow-sm">
          <h2 className="text-lg font-semibold flex items-center space-x-2 text-gray-900 dark:text-white">
            <Zap className="w-5 h-5 text-amber-500" />
            <span>Radiation Guardrail</span>
          </h2>
          <div className="space-y-4">
            <div className="p-4 bg-gray-50 dark:bg-gray-700/50 rounded-xl flex justify-between items-center">
              <span className="text-sm text-gray-600 dark:text-gray-300">New Cumulative Dose</span>
              <span className="text-xl font-bold text-blue-600">{totalDose.toFixed(1)} mSv</span>
            </div>
            <div className={`p-4 rounded-xl ${isHighExposure ? 'bg-amber-100 text-amber-900' : 'bg-green-100 text-green-900'}`}>
              <div className="text-xs font-bold uppercase">{isHighExposure ? '⚠️ HIGH CUMULATIVE RADIATION EXPOSURE' : '✅ DOSE WITHIN ALARA SAFETY LIMIT'}</div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default RadiologyRisWorkstation;
