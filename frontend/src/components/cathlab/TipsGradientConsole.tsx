import React, { useState } from 'react';

export const TipsGradientConsole: React.FC = () => {
  const [prePortal, setPrePortal] = useState<number>(32);
  const [preRa, setPreRa] = useState<number>(8);
  const [postPortal, setPostPortal] = useState<number>(18);
  const [postRa, setPostRa] = useState<number>(9);

  const prePsg = prePortal - preRa;
  const postPsg = postPortal - postRa;
  const isTargetAchieved = postPsg < 12;

  return (
    <div className="p-6 bg-slate-900 text-white rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-700">
        <div>
          <h2 className="text-2xl font-bold text-sky-400">TIPS Portosystemic Pressure Gradient Console</h2>
          <p className="text-sm text-slate-400">Portal Hypertension Decompression</p>
        </div>
        <span className="px-3 py-1 bg-sky-950 text-sky-300 border border-sky-700 rounded-full text-xs font-mono">
          PSG &lt; 12 mmHg Target
        </span>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mt-6">
        <div className="space-y-4">
          <div className="grid grid-cols-2 gap-3">
            <div>
              <label className="text-xs text-slate-300">Pre-TIPS Portal (mmHg)</label>
              <input
                type="number"
                value={prePortal}
                onChange={(e) => setPrePortal(Number(e.target.value))}
                className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
              />
            </div>
            <div>
              <label className="text-xs text-slate-300">Post-TIPS Portal (mmHg)</label>
              <input
                type="number"
                value={postPortal}
                onChange={(e) => setPostPortal(Number(e.target.value))}
                className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
              />
            </div>
          </div>
        </div>

        <div className="bg-slate-950 p-5 rounded-lg border border-slate-800 flex flex-col justify-between">
          <div className="grid grid-cols-2 gap-4 text-center">
            <div className="p-3 bg-slate-900 border border-slate-800 rounded-lg">
              <span className="text-xs text-slate-400">Pre-PSG</span>
              <p className="text-2xl font-bold text-slate-300 mt-1">{prePsg} mmHg</p>
            </div>
            <div className={isTargetAchieved ? 'p-3 bg-slate-900 border border-emerald-700 rounded-lg' : 'p-3 bg-slate-900 border border-red-700 rounded-lg'}>
              <span className="text-xs text-slate-400">Post-PSG</span>
              <p className={isTargetAchieved ? 'text-2xl font-bold mt-1 text-emerald-400' : 'text-2xl font-bold mt-1 text-red-400'}>
                {postPsg} mmHg
              </p>
            </div>
          </div>

          <button className="w-full mt-4 py-2.5 bg-sky-600 hover:bg-sky-500 font-semibold rounded-lg text-white transition-colors">
            Record TIPS Hemodynamic Log
          </button>
        </div>
      </div>
    </div>
  );
};
