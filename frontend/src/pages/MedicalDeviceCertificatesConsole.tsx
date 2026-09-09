import React, { useState } from 'react';

export const MedicalDeviceCertificatesConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">Medical Device X.509 Certificate Manager</h1>
          <p className="text-sm text-slate-400">FDA Pre-Market Cybersecurity Guidance &amp; mTLS Device Identity Ledger</p>
        </div>
      </header>

      <div className="space-y-4">
        <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
          <div className="flex justify-between items-start mb-2">
            <div>
              <span className="text-xs font-mono text-sky-400 font-bold">PUMP-ALARIS-9921</span>
              <h2 className="text-base font-bold text-white">BD Alaris 8015 PCU Infusion Pump</h2>
            </div>
            <span className="px-2 py-0.5 bg-emerald-900/60 text-emerald-300 rounded text-xs font-bold font-mono">mTLS VALID</span>
          </div>
          <p className="text-xs text-slate-400 font-mono">Thumbprint: E8A271B49C018274112 | Expires: 2027-09-08</p>
        </div>
      </div>
    </div>
  );
};
