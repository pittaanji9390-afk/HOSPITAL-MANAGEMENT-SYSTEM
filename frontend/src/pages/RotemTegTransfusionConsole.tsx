import React, { useState } from 'react';

export const RotemTegTransfusionConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">ROTEM / TEG Guided Hemostasis Console</h1>
          <p className="text-sm text-slate-400">Goal-Directed Transfusion: EXTEM, FIBTEM, INTEM &amp; TXA Hyperfibrinolysis</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <h2 className="text-base font-bold text-white mb-2">FIBTEM A10: 6 mm (Severe Hypofibrinogenemia)</h2>
        <p className="text-xs text-rose-300">Action: Transfuse 10 Units Cryoprecipitate or 2g Fibrinogen Concentrate STAT.</p>
      </div>
    </div>
  );
};
