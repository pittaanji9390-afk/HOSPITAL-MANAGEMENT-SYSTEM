import React, { useState } from 'react';
import { Stethoscope, Activity, ShieldAlert, Award } from 'lucide-react';

export const GastroenterologyWorkstation: React.FC = () => {
  const [bilirubin, setBilirubin] = useState<number>(2.4);
  const [inr, setInr] = useState<number>(1.6);
  const [creatinine, setCreatinine] = useState<number>(1.5);
  const [sodium, setSodium] = useState<number>(132);
  const [albumin, setAlbumin] = useState<number>(2.9);
  const [forrest, setForrest] = useState<string>('IIa');

  const meld = 1.33 * 0.0 + 4.56 * Math.log(Math.max(1.0, bilirubin)) + 0.82 * (137.0 - Math.min(137.0, Math.max(125.0, sodium))) - 0.24 * (137.0 - Math.min(137.0, Math.max(125.0, sodium))) * Math.log(Math.max(1.0, bilirubin)) + 9.09 * Math.log(Math.max(1.0, inr)) + 11.14 * Math.log(Math.max(1.0, creatinine)) + 1.85 * (3.5 - Math.min(3.5, albumin)) - 1.83 * (3.5 - Math.min(3.5, albumin)) * Math.log(Math.max(1.0, inr)) + 6.0;

  return (
    <div className="p-6 space-y-6 max-w-7xl mx-auto">
      <div className="flex items-center justify-between border-b pb-4">
        <div className="flex items-center space-x-3">
          <div className="p-3 bg-amber-100 dark:bg-amber-900/30 text-amber-600 rounded-xl">
            <Stethoscope className="w-8 h-8" />
          </div>
          <div>
            <h1 className="text-2xl font-bold text-gray-900 dark:text-white">Gastroenterology & Endoscopy Workstation</h1>
            <p className="text-sm text-gray-500">MELD 3.0 liver priority calculator, Forrest peptic ulcer bleeding classification & hemostasis directives</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-3 gap-6">
        <div className="lg:col-span-2 bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-6 shadow-sm">
          <h2 className="text-lg font-semibold flex items-center space-x-2 text-gray-900 dark:text-white">
            <Activity className="w-5 h-5 text-amber-500" />
            <span>Hepatic & Endoscopy Biomarkers</span>
          </h2>
          <div className="grid grid-cols-2 gap-4">
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Total Bilirubin (mg/dL)</label>
              <input type="number" step="0.1" value={bilirubin} onChange={(e) => setBilirubin(parseFloat(e.target.value) || 1)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">INR (Coagulation)</label>
              <input type="number" step="0.1" value={inr} onChange={(e) => setInr(parseFloat(e.target.value) || 1)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Serum Creatinine (mg/dL)</label>
              <input type="number" step="0.1" value={creatinine} onChange={(e) => setCreatinine(parseFloat(e.target.value) || 1)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Forrest Ulcer Grade</label>
              <select value={forrest} onChange={(e) => setForrest(e.target.value)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600">
                <option value="Ia">Ia - Spurting Arterial Hemorrhage</option>
                <option value="Ib">Ib - Oozing Hemorrhage</option>
                <option value="IIa">IIa - Non-bleeding Visible Vessel</option>
                <option value="IIb">IIb - Adherent Clot</option>
                <option value="III">III - Clean Base Ulcer</option>
              </select>
            </div>
          </div>
        </div>

        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-6 shadow-sm">
          <h2 className="text-lg font-semibold flex items-center space-x-2 text-gray-900 dark:text-white">
            <Award className="w-5 h-5 text-amber-500" />
            <span>MELD 3.0 Score</span>
          </h2>
          <div className="space-y-4">
            <div className="p-4 bg-amber-50 dark:bg-amber-900/20 rounded-xl flex justify-between items-center">
              <span className="text-sm text-amber-900 dark:text-amber-200 font-medium">Calculated MELD 3.0</span>
              <span className="text-2xl font-bold text-amber-700 dark:text-amber-400">{meld.toFixed(1)}</span>
            </div>
            <div className="p-4 bg-gray-50 dark:bg-gray-700/50 rounded-xl space-y-2">
              <div className="text-xs font-bold text-gray-700 dark:text-gray-300">ENDOSCOPIC DIRECTIVE</div>
              <p className="text-xs text-gray-600 dark:text-gray-400">Deploy dual-modality hemostasis (Epinephrine 1:10000 + Hemoclips) followed by continuous IV Pantoprazole 8mg/hr for 72h.</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default GastroenterologyWorkstation;
