import React, { useState } from 'react';
import { SAMPLE_PICCO_PROFILE } from '../types/piccoHemodynamics';

export const PiccoHemodynamicsConsole: React.FC = () => {
  const [data, setData] = useState(SAMPLE_PICCO_PROFILE);

  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">PiCCO Transpulmonary Thermodilution Console</h1>
          <p className="text-sm text-slate-400">Volumetric Hemodynamics: EVLWI, GEDVI, SVV &amp; Continuous Cardiac Index (CCI)</p>
        </div>
      </header>

      <div className="grid grid-cols-2 md:grid-cols-4 gap-4 mb-6">
        <div className="p-4 bg-slate-800/80 rounded-xl border border-slate-700 text-center font-mono">
          <span className="text-xs text-slate-400 block font-sans">Cardiac Index (CI)</span>
          <span className="text-2xl font-bold text-rose-400">{data.cardiacIndexCi} L/min/m²</span>
        </div>
        <div className="p-4 bg-slate-800/80 rounded-xl border border-slate-700 text-center font-mono">
          <span className="text-xs text-slate-400 block font-sans">Lung Water (EVLWI)</span>
          <span className="text-2xl font-bold text-amber-400">{data.extravascularLungWaterIndexEvlwi} mL/kg</span>
        </div>
        <div className="p-4 bg-slate-800/80 rounded-xl border border-slate-700 text-center font-mono">
          <span className="text-xs text-slate-400 block font-sans">Preload (GEDVI)</span>
          <span className="text-2xl font-bold text-sky-400">{data.globalEndDiastolicVolumeIndexGedvi} mL/m²</span>
        </div>
        <div className="p-4 bg-slate-800/80 rounded-xl border border-slate-700 text-center font-mono">
          <span className="text-xs text-slate-400 block font-sans">SVV Fluid Response</span>
          <span className="text-2xl font-bold text-emerald-400">{data.strokeVolumeVariationSvv}%</span>
        </div>
      </div>

      <div className="p-4 bg-slate-800/90 rounded-xl border border-slate-700">
        <span className="text-xs text-slate-400 uppercase font-bold block mb-1">Clinical Decision Support:</span>
        <p className="text-sm text-amber-300">{data.clinicalGuidance}</p>
      </div>
    </div>
  );
};
