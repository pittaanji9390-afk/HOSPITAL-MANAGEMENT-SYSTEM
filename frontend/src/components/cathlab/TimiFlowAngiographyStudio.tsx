import React, { useState } from 'react';

export const TimiFlowAngiographyStudio: React.FC = () => {
  const [vessel, setVessel] = useState<string>('LAD');
  const [preTimi, setPreTimi] = useState<string>('TIMI_0_NO_PERFUSION');
  const [postTimi, setPostTimi] = useState<string>('TIMI_3_NORMAL_PERFUSION');
  const [postMbg, setPostMbg] = useState<string>('MBG_3_NORMAL_BLUSH');
  const [frameCount, setFrameCount] = useState<number>(36);

  const ctfc = vessel === 'LAD' ? Math.round(frameCount / 1.7) : frameCount;
  const isNoReflow = (postTimi === 'TIMI_0_NO_PERFUSION' || postTimi === 'TIMI_1_FAINT_PERFUSION' || postMbg === 'MBG_0_NO_BLUSH');

  return (
    <div className="p-6 bg-slate-900 text-white rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-700">
        <div>
          <h2 className="text-2xl font-bold text-rose-400">TIMI Flow & Myocardial Blush Perfusion Studio</h2>
          <p className="text-sm text-slate-400">Coronary Angiography Reperfusion & Microvascular Blush Quantification</p>
        </div>
        <span className="px-3 py-1 bg-rose-950 text-rose-300 border border-rose-700 rounded-full text-xs font-mono">
          ACC/AHA PCI Class I
        </span>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mt-6">
        <div className="space-y-4">
          <div>
            <label className="text-xs text-slate-300 font-semibold">Culprit Coronary Vessel</label>
            <select
              value={vessel}
              onChange={(e) => setVessel(e.target.value)}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded-lg p-2.5 text-white"
            >
              <option value="LAD">Left Anterior Descending (LAD)</option>
              <option value="RCA">Right Coronary Artery (RCA)</option>
              <option value="LCx">Left Circumflex (LCx)</option>
              <option value="Ramus">Ramus Intermedius</option>
              <option value="SVG">Saphenous Vein Graft (SVG)</option>
            </select>
          </div>

          <div>
            <label className="text-xs text-slate-300 font-semibold">Baseline Pre-PCI TIMI Flow</label>
            <select
              value={preTimi}
              onChange={(e) => setPreTimi(e.target.value)}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded-lg p-2.5 text-white"
            >
              <option value="TIMI_0_NO_PERFUSION">TIMI 0 (Complete Occlusion / No Antegrade Flow)</option>
              <option value="TIMI_1_FAINT_PERFUSION">TIMI 1 (Faint Flow / Incomplete Opacification)</option>
              <option value="TIMI_2_DELAYED_PERFUSION">TIMI 2 (Sluggish / Delayed Clearing)</option>
              <option value="TIMI_3_NORMAL_PERFUSION">TIMI 3 (Normal Brisk Perfusion)</option>
            </select>
          </div>

          <div>
            <label className="text-xs text-slate-300 font-semibold">Post-PCI Final TIMI Flow Grade</label>
            <select
              value={postTimi}
              onChange={(e) => setPostTimi(e.target.value)}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded-lg p-2.5 text-white"
            >
              <option value="TIMI_3_NORMAL_PERFUSION">TIMI 3 (Optimal Epicardial Flow)</option>
              <option value="TIMI_2_DELAYED_PERFUSION">TIMI 2 (Slow-Flow Phenomenon)</option>
              <option value="TIMI_1_FAINT_PERFUSION">TIMI 1 (No-Reflow / Dissection)</option>
              <option value="TIMI_0_NO_PERFUSION">TIMI 0 (Acute Closure / Stent Thrombosis)</option>
            </select>
          </div>

          <div>
            <label className="text-xs text-slate-300 font-semibold">Myocardial Blush Grade (MBG)</label>
            <select
              value={postMbg}
              onChange={(e) => setPostMbg(e.target.value)}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded-lg p-2.5 text-white"
            >
              <option value="MBG_3_NORMAL_BLUSH">MBG 3 (Normal Dense Myocardial Blush & Brisk Washout)</option>
              <option value="MBG_2_MODERATE_BLUSH">MBG 2 (Moderate Blush / Delayed Washout)</option>
              <option value="MBG_1_MINIMAL_BLUSH">MBG 1 (Minimal Blush)</option>
              <option value="MBG_0_NO_BLUSH">MBG 0 (No Microvascular Blush - Obstruction)</option>
            </select>
          </div>

          <div>
            <label className="text-xs text-slate-300 font-semibold">Raw TIMI Frame Count (at 30 fps)</label>
            <input
              type="number"
              value={frameCount}
              onChange={(e) => setFrameCount(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded-lg p-2.5 text-white"
            />
          </div>
        </div>

        <div className="bg-slate-950 p-5 rounded-lg border border-slate-800 flex flex-col justify-between">
          <div>
            <h3 className="text-sm font-semibold text-slate-300 mb-3">Reperfusion Assessment Summary</h3>
            <div className="space-y-2 text-sm">
              <div className="flex justify-between py-1 border-b border-slate-800">
                <span className="text-slate-400">Target Vessel:</span>
                <span className="font-mono text-cyan-300">{vessel}</span>
              </div>
              <div className="flex justify-between py-1 border-b border-slate-800">
                <span className="text-slate-400">Corrected Frame Count (cTFC):</span>
                <span className="font-mono text-emerald-400">{ctfc} frames</span>
              </div>
              <div className="flex justify-between py-1 border-b border-slate-800">
                <span className="text-slate-400">No-Reflow / Slow-Flow:</span>
                <span className={isNoReflow ? 'font-bold text-red-400' : 'text-emerald-400'}>
                  {isNoReflow ? 'POSITIVE (Action Required)' : 'NEGATIVE (Patent)'}
                </span>
              </div>
            </div>

            <div className="mt-4 p-3 rounded bg-slate-900 border border-slate-700 text-xs">
              <p className="font-semibold text-rose-300">Clinical Recommendation:</p>
              <p className="text-slate-300 mt-1">
                {isNoReflow
                  ? 'Intracoronary Adenosine (100-200 mcg) or Nicardipine (200 mcg) recommended.'
                  : 'Optimal microvascular and epicardial reperfusion achieved. Initiate guideline DAPT.'}
              </p>
            </div>
          </div>

          <button className="w-full mt-4 py-2.5 bg-rose-600 hover:bg-rose-500 font-semibold rounded-lg text-white transition-colors">
            Transmit Angiography Perfusion Report
          </button>
        </div>
      </div>
    </div>
  );
};
