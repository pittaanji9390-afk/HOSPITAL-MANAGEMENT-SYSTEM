import React, { useState } from 'react';

export const EkosThrombolysisConsole: React.FC = () => {
  const [tpaRate, setTpaRate] = useState<number>(0.5);
  const [fibrinogen, setFibrinogen] = useState<number>(180);

  const isHypofibrinogenemia = fibrinogen < 150;

  return (
    <div className="p-6 bg-slate-900 text-white rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-700">
        <div>
          <h2 className="text-2xl font-bold text-purple-400">EKOS Ultrasound Thrombolysis Infusion Studio</h2>
          <p className="text-sm text-slate-400">Acoustic Pulse Dissociation & tPA Fibrinogen Surveillance</p>
        </div>
        <span className="px-3 py-1 bg-purple-950 text-purple-300 border border-purple-700 rounded-full text-xs font-mono">
          EKOSONIC Telemetry
        </span>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mt-6">
        <div className="space-y-4">
          <div>
            <label className="text-xs text-slate-300 font-semibold">tPA Infusion Rate: {tpaRate} mg/hr</label>
            <input
              type="number"
              step="0.25"
              value={tpaRate}
              onChange={(e) => setTpaRate(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>
        </div>

        <div className="bg-slate-950 p-5 rounded-lg border border-slate-800 flex flex-col justify-between">
          <div className="space-y-2 text-sm">
            <div className="flex justify-between py-1 border-b border-slate-800">
              <span className="text-slate-400">Bleeding Risk Cutoff:</span>
              <span className={isHypofibrinogenemia ? 'font-bold text-red-400' : 'text-emerald-400'}>
                {isHypofibrinogenemia ? 'REDUCE / HOLD tPA (<150 mg/dL)' : 'SAFE WINDOW (>=150 mg/dL)'}
              </span>
            </div>
          </div>

          <button className="w-full mt-4 py-2.5 bg-purple-600 hover:bg-purple-500 font-semibold rounded-lg text-white transition-colors">
            Update Thrombolysis Infusion Rate
          </button>
        </div>
      </div>
    </div>
  );
};
