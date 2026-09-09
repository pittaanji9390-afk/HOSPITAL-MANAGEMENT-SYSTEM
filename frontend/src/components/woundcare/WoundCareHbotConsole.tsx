import React, { useState } from 'react';

export const WoundCareHbotConsole: React.FC = () => {
  const [grade, setGrade] = useState<string>('GRADE_3_OSTEOMYELITIS');
  const [tcpo2, setTcpo2] = useState<number>(24);

  const isCandidate = tcpo2 < 30;

  return (
    <div className="p-6 bg-slate-900 text-white rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-700">
        <div>
          <h2 className="text-2xl font-bold text-teal-400">Hyperbaric Oxygen & Wound Healing Studio</h2>
          <p className="text-sm text-slate-400">Wagner Ulcer Classification & Transcutaneous Oxygen (TcPO2) Chamber Telemetry</p>
        </div>
        <span className="px-3 py-1 bg-teal-950 text-teal-300 border border-teal-700 rounded-full text-xs font-mono">
          Undersea & Hyperbaric Medical Society
        </span>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mt-6">
        <div className="space-y-4">
          <div>
            <label className="text-xs text-slate-300 font-semibold">Baseline Room Air TcPO2 (mmHg): {tcpo2} mmHg</label>
            <input
              type="number"
              value={tcpo2}
              onChange={(e) => setTcpo2(Number(e.target.value))}
              className="w-full mt-1 bg-slate-800 border border-slate-700 rounded p-2 text-white"
            />
          </div>
        </div>

        <div className="bg-slate-950 p-5 rounded-lg border border-slate-800 flex flex-col justify-between">
          <div className="text-center p-4 bg-slate-900 rounded-lg border border-slate-800">
            <span className="text-xs text-slate-400">Hypoxic Tissue Indication</span>
            <p className={isCandidate ? 'text-2xl font-bold text-emerald-400 mt-1' : 'text-2xl font-bold text-slate-400 mt-1'}>
              {isCandidate ? 'Severe Ischemia: 2.4 ATA HBOT Indicated' : 'Adequate Microvascular Perfusion'}
            </p>
          </div>

          <button className="w-full mt-4 py-2.5 bg-teal-600 hover:bg-teal-500 font-semibold rounded-lg text-white transition-colors">
            Schedule Hyperbaric Session
          </button>
        </div>
      </div>
    </div>
  );
};
