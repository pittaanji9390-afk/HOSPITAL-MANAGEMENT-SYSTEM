import React, { useState } from 'react';

export const DeviceTrustGeofenceConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">Workstation IP Whitelisting &amp; Geofencing Console</h1>
          <p className="text-sm text-slate-400">Subnet Isolation for ICU, OR, and Inpatient Narcotic Dispensing Vaults</p>
        </div>
      </header>

      <div className="bg-slate-800/80 rounded-xl border border-slate-700 p-5">
        <h2 className="text-base font-bold text-white mb-4">Authorized Clinical Subnets</h2>
        <div className="space-y-3 font-mono text-xs">
          <div className="p-3 bg-slate-900/80 rounded border border-slate-700/60 flex justify-between items-center">
            <div>
              <span className="text-sky-300 font-bold block">10.240.10.0/24</span>
              <span className="text-slate-400 font-sans">Operating Rooms &amp; Anesthesia Workstations</span>
            </div>
            <span className="px-2 py-1 bg-emerald-900/60 text-emerald-300 rounded font-sans font-semibold">ACTIVE</span>
          </div>
          <div className="p-3 bg-slate-900/80 rounded border border-slate-700/60 flex justify-between items-center">
            <div>
              <span className="text-sky-300 font-bold block">10.240.12.0/24</span>
              <span className="text-slate-400 font-sans">Intensive Care Unit Bedside Touchscreens</span>
            </div>
            <span className="px-2 py-1 bg-emerald-900/60 text-emerald-300 rounded font-sans font-semibold">ACTIVE</span>
          </div>
        </div>
      </div>
    </div>
  );
};
