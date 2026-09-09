import React, { useState } from 'react';
import { Scale, CheckCircle2, AlertTriangle, ShieldCheck, RefreshCw } from 'lucide-react';

export const GravimetricCompoundingConsole: React.FC = () => {
  const [diluent, setDiluent] = useState('0.9% Sodium Chloride');
  const [diluentVol, setDiluentVol] = useState(250);
  const [drugAdditive, setDrugAdditive] = useState('Vancomycin 50mg/mL');
  const [drugVol, setDrugVol] = useState(20);
  const [tareWeight, setTareWeight] = useState(25.4);
  const [actualScaleWeight, setActualScaleWeight] = useState(296.8);

  // Gravimetric math
  const diluentDensity = diluent.includes('Sodium Chloride') ? 1.0046 : 1.0185;
  const drugDensity = 1.0250;
  const expectedNet = (diluentVol * diluentDensity) + (drugVol * drugDensity);
  const actualNet = actualScaleWeight - tareWeight;
  const variancePct = ((actualNet - expectedNet) / expectedNet) * 100;
  const isPass = Math.abs(variancePct) <= 2.5;

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Scale className="h-7 w-7 text-indigo-400" />
          <div>
            <h2 className="text-xl font-bold">Gravimetric Analytical Compounding Scale Verification</h2>
            <p className="text-xs text-slate-400">High-Precision Specific Gravity & Specific Volume (+/- 2.5% Tolerance Gate)</p>
          </div>
        </div>
        <span className={'px-3 py-1 rounded-full text-xs font-bold font-mono ' + (
          isPass ? 'bg-emerald-950 text-emerald-300 border border-emerald-700' : 'bg-rose-950 text-rose-300 border border-rose-700'
        )}>
          {isPass ? 'GRAVIMETRIC PASS' : 'OUT OF TOLERANCE'}
        </span>
      </div>

      <div className="grid grid-cols-3 gap-4 my-6">
        <div className="bg-slate-950 p-4 rounded-xl border border-slate-800 space-y-3">
          <h3 className="text-sm font-semibold text-slate-300">Compounding Parameters</h3>
          <div>
            <label className="text-xs text-slate-400 block mb-1">Base Diluent Bag</label>
            <select value={diluent} onChange={e => setDiluent(e.target.value)} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-slate-200">
              <option>0.9% Sodium Chloride (D: 1.0046 g/mL)</option>
              <option>5% Dextrose in Water (D5W) (D: 1.0185 g/mL)</option>
            </select>
          </div>
          <div>
            <label className="text-xs text-slate-400 block mb-1">Diluent Volume (mL)</label>
            <input type="number" value={diluentVol} onChange={e => setDiluentVol(Number(e.target.value))} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-slate-200" />
          </div>
          <div>
            <label className="text-xs text-slate-400 block mb-1">Active Ingredient Additive</label>
            <input type="text" value={drugAdditive} onChange={e => setDrugAdditive(e.target.value)} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-slate-200" />
          </div>
          <div>
            <label className="text-xs text-slate-400 block mb-1">Additive Volume (mL)</label>
            <input type="number" value={drugVol} onChange={e => setDrugVol(Number(e.target.value))} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-slate-200" />
          </div>
        </div>

        <div className="bg-slate-950 p-4 rounded-xl border border-slate-800 space-y-3">
          <h3 className="text-sm font-semibold text-slate-300">Live Scale Sensor (Mettler Toledo)</h3>
          <div>
            <label className="text-xs text-slate-400 block mb-1">Empty Bag Tare Weight (g)</label>
            <input type="number" step="0.1" value={tareWeight} onChange={e => setTareWeight(Number(e.target.value))} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-slate-200" />
          </div>
          <div>
            <label className="text-xs text-slate-400 block mb-1">Total Scale Gross Weight (g)</label>
            <input type="number" step="0.1" value={actualScaleWeight} onChange={e => setActualScaleWeight(Number(e.target.value))} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-slate-200" />
          </div>
          <div className="p-3 bg-slate-900 rounded-lg border border-slate-800 font-mono text-xs space-y-1">
            <div className="text-slate-400">Measured Net Weight: <strong className="text-white">{actualNet.toFixed(2)} g</strong></div>
            <div className="text-slate-400">Expected Theoretical: <strong className="text-indigo-300">{expectedNet.toFixed(2)} g</strong></div>
          </div>
        </div>

        <div className="bg-slate-950 p-4 rounded-xl border border-slate-800 flex flex-col justify-between">
          <div>
            <h3 className="text-sm font-semibold text-slate-300 mb-3">Analytical Verification Result</h3>
            <div className="text-center my-4">
              <span className="text-xs text-slate-400 block mb-1">Weight Variance</span>
              <span className={'text-3xl font-extrabold font-mono ' + (isPass ? 'text-emerald-400' : 'text-rose-400')}>
                {variancePct > 0 ? '+' + variancePct.toFixed(2) : variancePct.toFixed(2)}%
              </span>
              <p className="text-xs text-slate-400 mt-2 font-mono">Acceptable Limit: ± 2.50%</p>
            </div>
          </div>
          <button disabled={!isPass} className={'w-full py-2.5 rounded-lg text-xs font-bold uppercase tracking-wider flex items-center justify-center gap-1.5 ' + (
            isPass ? 'bg-emerald-600 hover:bg-emerald-500 text-white' : 'bg-slate-800 text-slate-500 cursor-not-allowed'
          )}>
            <ShieldCheck className="h-4 w-4" /> Print Chemo / IV Verification Label
          </button>
        </div>
      </div>
    </div>
  );
};
