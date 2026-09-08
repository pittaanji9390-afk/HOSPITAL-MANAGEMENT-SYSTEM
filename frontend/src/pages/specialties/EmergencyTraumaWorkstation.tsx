import React, { useState } from 'react';
import { Siren, AlertTriangle, ShieldCheck, HeartPulse, Activity, Zap } from 'lucide-react';

export const EmergencyTraumaWorkstation: React.FC = () => {
  const [lifesaving, setLifesaving] = useState<boolean>(false);
  const [highRisk, setHighRisk] = useState<boolean>(true);
  const [resources, setResources] = useState<number>(3);
  const [gcs, setGcs] = useState<number>(14);
  const [sbp, setSbp] = useState<number>(95);
  const [rr, setRr] = useState<number>(22);

  let esi = 5;
  let cat = 'NON_URGENT';
  if (lifesaving) { esi = 1; cat = 'RESUSCITATION_IMMEDIATE'; }
  else if (highRisk) { esi = 2; cat = 'EMERGENT_HIGH_RISK'; }
  else if (resources >= 2) { esi = 3; cat = 'URGENT_MULTIPLE_RESOURCES'; }
  else if (resources === 1) { esi = 4; cat = 'LESS_URGENT_SINGLE_RESOURCE'; }

  const gcsCoded = gcs >= 13 ? 4 : (gcs >= 9 ? 3 : (gcs >= 6 ? 2 : (gcs >= 4 ? 1 : 0)));
  const sbpCoded = sbp > 89 ? 4 : (sbp >= 76 ? 3 : (sbp >= 50 ? 2 : (sbp >= 1 ? 1 : 0)));
  const rrCoded = (rr >= 10 && rr <= 29) ? 4 : (rr > 29 ? 3 : (rr >= 6 ? 2 : (rr >= 1 ? 1 : 0)));
  const rts = (0.9368 * gcsCoded) + (0.7326 * sbpCoded) + (0.2908 * rrCoded);
  const isMtp = rts < 6.0 || sbp < 90.0;

  return (
    <div className="p-6 space-y-6 max-w-7xl mx-auto">
      <div className="flex items-center justify-between border-b pb-4">
        <div className="flex items-center space-x-3">
          <div className="p-3 bg-red-100 dark:bg-red-900/30 text-red-600 rounded-xl">
            <Siren className="w-8 h-8" />
          </div>
          <div>
            <h1 className="text-2xl font-bold text-gray-900 dark:text-white">Emergency Department ESI & Trauma Command Board</h1>
            <p className="text-sm text-gray-500">Emergency Severity Index (ESI-5), Revised Trauma Score & Massive Transfusion Protocol</p>
          </div>
        </div>
        <span className={`px-3 py-1.5 rounded-full text-xs font-semibold ${esi === 1 ? 'bg-red-600 text-white animate-bounce' : (esi === 2 ? 'bg-orange-500 text-white' : 'bg-blue-600 text-white')}`}>
          ESI LEVEL {esi}: {cat}
        </span>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-3 gap-6">
        <div className="lg:col-span-2 bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-6 shadow-sm">
          <h2 className="text-lg font-semibold flex items-center space-x-2 text-gray-900 dark:text-white">
            <Activity className="w-5 h-5 text-red-500" />
            <span>Triage & Vital Criteria</span>
          </h2>
          <div className="space-y-4">
            <div className="flex items-center space-x-2">
              <input type="checkbox" id="life" checked={lifesaving} onChange={(e) => setLifesaving(e.target.checked)} className="rounded text-red-600" />
              <label htmlFor="life" className="text-sm font-semibold text-red-600">Requires Immediate Lifesaving Intervention (Intubation, Defibrillation, Amputations)</label>
            </div>
            <div className="flex items-center space-x-2">
              <input type="checkbox" id="highrisk" checked={highRisk} onChange={(e) => setHighRisk(e.target.checked)} className="rounded text-orange-600" />
              <label htmlFor="highrisk" className="text-sm font-medium text-gray-700 dark:text-gray-300">High Risk Situation, Confused/Lethargic, or Severe Pain/Distress</label>
            </div>
            <div className="grid grid-cols-3 gap-4 pt-2">
              <div>
                <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">GCS Score (3-15)</label>
                <input type="number" min="3" max="15" value={gcs} onChange={(e) => setGcs(parseInt(e.target.value) || 3)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
              </div>
              <div>
                <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Systolic BP (mmHg)</label>
                <input type="number" value={sbp} onChange={(e) => setSbp(parseFloat(e.target.value) || 0)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
              </div>
              <div>
                <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Respiratory Rate</label>
                <input type="number" value={rr} onChange={(e) => setRr(parseInt(e.target.value) || 0)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
              </div>
            </div>
          </div>
        </div>

        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-6 shadow-sm">
          <h2 className="text-lg font-semibold flex items-center space-x-2 text-gray-900 dark:text-white">
            <HeartPulse className="w-5 h-5 text-red-500" />
            <span>Trauma Severity Index</span>
          </h2>
          <div className="space-y-4">
            <div className="p-4 bg-gray-50 dark:bg-gray-700/50 rounded-xl flex justify-between items-center">
              <span className="text-sm text-gray-600 dark:text-gray-300">Revised Trauma Score (RTS)</span>
              <span className="text-xl font-bold text-red-600">{rts.toFixed(2)} / 7.84</span>
            </div>
            <div className={`p-4 rounded-xl space-y-1 ${isMtp ? 'bg-red-500 text-white animate-pulse' : 'bg-green-100 text-green-800'}`}>
              <div className="text-xs font-bold uppercase">{isMtp ? '🚨 MASSIVE TRANSFUSION PROTOCOL ACTIVATED' : '✅ HEMODYNAMICALLY STABLE'}</div>
              <div className="text-xs opacity-90">{isMtp ? '1:1:1 PRBC : FFP : Platelets blood cooler dispatched to Trauma Bay.' : 'Standard peripheral IV access and type & screen.'}</div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default EmergencyTraumaWorkstation;
