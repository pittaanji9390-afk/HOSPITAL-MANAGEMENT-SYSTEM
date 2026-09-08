import React, { useState } from 'react';

export const VascularClosureMonitor: React.FC = () => {
  const [device, setDevice] = useState<string>('ANGIO_SEAL_VIP');
  const [site, setSite] = useState<string>('RIGHT_FEMORAL');

  return (
    <div className="p-6 bg-slate-900 text-white rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-700">
        <div>
          <h2 className="text-2xl font-bold text-violet-400">Vascular Closure Device & Access Site Monitor</h2>
          <p className="text-sm text-slate-400">Femoral / Radial Hemostasis Tracking & Bed Rest Protocol Engine</p>
        </div>
        <span className="px-3 py-1 bg-violet-950 text-violet-300 border border-violet-700 rounded-full text-xs font-mono">
          Hemostasis Protocol
        </span>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mt-6">
        <div className="space-y-4">
          <div>
            <label className="text-xs text-slate-300 font-semibold">Closure Device</label>
            <select
              value={device}
              onChange={(e) => setDevice(e.target.value)}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded-lg p-2.5 text-white"
            >
              <option value="ANGIO_SEAL_VIP">Angio-Seal VIP 6F/8F</option>
              <option value="PERCLOSE_PROGLIDE">Perclose ProGlide</option>
              <option value="MANTA_LARGE_BORE">MANTA 14F/18F</option>
              <option value="TR_BAND">TR Band (Radial)</option>
            </select>
          </div>
        </div>

        <div className="bg-slate-950 p-5 rounded-lg border border-slate-800 flex flex-col justify-between">
          <div className="space-y-2 text-sm">
            <div className="flex justify-between py-1 border-b border-slate-800">
              <span className="text-slate-400">Required Bed Rest:</span>
              <span className="font-mono text-violet-300">{site.includes('RADIAL') ? '0 Hours (Ambulate)' : '2 Hours Flat'}</span>
            </div>
          </div>

          <button className="w-full mt-4 py-2.5 bg-violet-600 hover:bg-violet-500 font-semibold rounded-lg text-white transition-colors">
            Confirm Access Site Closure
          </button>
        </div>
      </div>
    </div>
  );
};
