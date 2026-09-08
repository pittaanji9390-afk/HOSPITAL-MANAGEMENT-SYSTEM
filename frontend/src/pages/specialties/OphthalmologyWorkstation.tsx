import React, { useState } from 'react';
import { Eye, Activity, AlertCircle, CheckCircle2 } from 'lucide-react';

export const OphthalmologyWorkstation: React.FC = () => {
  const [odIop, setOdIop] = useState<number>(24.0);
  const [osIop, setOsIop] = useState<number>(18.0);
  const [etdrs, setEtdrs] = useState<string>('MODERATE_NPDR');

  const isGlaucomaSuspect = odIop > 21.0 || osIop > 21.0;

  return (
    <div className="p-6 space-y-6 max-w-7xl mx-auto">
      <div className="flex items-center justify-between border-b pb-4">
        <div className="flex items-center space-x-3">
          <div className="p-3 bg-teal-100 dark:bg-teal-900/30 text-teal-600 rounded-xl">
            <Eye className="w-8 h-8" />
          </div>
          <div>
            <h1 className="text-2xl font-bold text-gray-900 dark:text-white">Ophthalmology & Retina/Glaucoma Console</h1>
            <p className="text-sm text-gray-500">Goldmann Applanation Tonometry (IOP), ETDRS Diabetic Retinopathy & Visual Acuity LogMAR</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-3 gap-6">
        <div className="lg:col-span-2 bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-6 shadow-sm">
          <h2 className="text-lg font-semibold flex items-center space-x-2 text-gray-900 dark:text-white">
            <Activity className="w-5 h-5 text-teal-500" />
            <span>Ocular Tonometry & Funduscopy</span>
          </h2>
          <div className="grid grid-cols-2 gap-4">
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">OD IOP (Right Eye - mmHg)</label>
              <input type="number" step="0.5" value={odIop} onChange={(e) => setOdIop(parseFloat(e.target.value) || 0)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">OS IOP (Left Eye - mmHg)</label>
              <input type="number" step="0.5" value={osIop} onChange={(e) => setOsIop(parseFloat(e.target.value) || 0)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
          </div>
        </div>

        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-6 shadow-sm">
          <h2 className="text-lg font-semibold flex items-center space-x-2 text-gray-900 dark:text-white">
            <AlertCircle className="w-5 h-5 text-teal-500" />
            <span>Glaucoma & Retina Triage</span>
          </h2>
          <div className="space-y-4">
            <div className={`p-4 rounded-xl ${isGlaucomaSuspect ? 'bg-amber-100 text-amber-900 dark:bg-amber-900/30 dark:text-amber-200' : 'bg-green-100 text-green-900'}`}>
              <div className="text-xs font-bold uppercase">{isGlaucomaSuspect ? '⚠️ OCULAR HYPERTENSION / GLAUCOMA SUSPECT' : '✅ IOP WITHIN NORMAL LIMITS'}</div>
              <div className="text-xs mt-1">{isGlaucomaSuspect ? 'Initiate topical Prostaglandin Analog (Latanoprost 0.005%) & schedule Humphrey Visual Field.' : 'Routine annual screening.'}</div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default OphthalmologyWorkstation;
