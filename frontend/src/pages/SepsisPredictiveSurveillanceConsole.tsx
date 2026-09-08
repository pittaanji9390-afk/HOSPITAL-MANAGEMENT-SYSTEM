import React, { useState } from 'react';
import { SAMPLE_SEPSIS_PREDICTIONS } from '../types/sepsisMlModel';

export const SepsisPredictiveSurveillanceConsole: React.FC = () => {
  const [data, setData] = useState(SAMPLE_SEPSIS_PREDICTIONS);

  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-rose-400">Sepsis Predictive ML &amp; SEP-1 Surveillance</h1>
          <p className="text-sm text-slate-400">Machine Learning Random Forest Early Sepsis Probability &amp; 1-Hour Bundle Tracker</p>
        </div>
      </header>

      <div className="space-y-4">
        {data.map((item) => (
          <div key={item.patientId} className="p-5 bg-slate-800/80 rounded-xl border border-rose-800/80">
            <div className="flex justify-between items-start mb-3">
              <div>
                <span className="text-xs font-mono text-rose-400 font-bold">{item.patientId}</span>
                <h2 className="text-xl font-bold text-white">Sepsis Probability: {item.predictedSepsisProbabilityPercent}%</h2>
              </div>
              <span className="px-3 py-1 bg-rose-900/80 text-rose-300 font-mono font-bold text-xs rounded animate-pulse">
                {item.riskTier}
              </span>
            </div>

            <div className="p-3 bg-slate-900/80 rounded border border-slate-700/60 mb-3 text-xs">
              <span className="text-rose-300 font-semibold block mb-1">Top Driving Biomarkers:</span>
              <ul className="list-disc list-inside text-slate-300 space-y-0.5">
                {item.topContributingFeatures.map((f, idx) => (
                  <li key={idx}>{f}</li>
                ))}
              </ul>
            </div>

            <p className="text-xs text-emerald-300 font-semibold">{item.clinicalRecommendation}</p>
          </div>
        ))}
      </div>
    </div>
  );
};
