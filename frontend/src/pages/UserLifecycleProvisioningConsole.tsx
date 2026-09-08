import React, { useState } from 'react';

export const UserLifecycleProvisioningConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">Staff Account Lifecycle &amp; Role Provisioning</h1>
          <p className="text-sm text-slate-400">Automated Onboarding, Role Deprovisioning &amp; Privileged Access Reviews</p>
        </div>
      </header>

      <div className="bg-slate-800/80 rounded-xl border border-slate-700 overflow-hidden font-mono text-xs">
        <table className="w-full text-left text-slate-300">
          <thead className="bg-slate-950 text-slate-400 uppercase">
            <tr>
              <th className="p-3">Employee ID</th>
              <th className="p-3">Full Name</th>
              <th className="p-3">Department</th>
              <th className="p-3">Assigned Role</th>
              <th className="p-3">Status</th>
              <th className="p-3 text-right">Actions</th>
            </tr>
          </thead>
          <tbody className="divide-y divide-slate-700/60 font-sans">
            <tr className="hover:bg-slate-800/50">
              <td className="p-3 font-mono font-bold text-sky-400">EMP-1001</td>
              <td className="p-3 font-semibold text-white">Dr. Gregory House</td>
              <td className="p-3">Internal Medicine</td>
              <td className="p-3 font-mono text-amber-300">ATTENDING_PHYSICIAN</td>
              <td className="p-3"><span className="px-2 py-0.5 bg-emerald-900/60 text-emerald-300 rounded font-bold text-xs">ACTIVE</span></td>
              <td className="p-3 text-right">
                <button className="bg-rose-700 hover:bg-rose-600 text-white px-3 py-1 rounded text-xs">Suspend</button>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  );
};
