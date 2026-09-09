import React, { useState } from 'react';
import { CLINICAL_PERMISSIONS_CATALOG } from '../types/rbacPermissions';

export const RbacPermissionMatrixConsole: React.FC = () => {
  const [selectedRole, setSelectedRole] = useState('ATTENDING_PHYSICIAN');

  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">Enterprise RBAC Permission Matrix Console</h1>
          <p className="text-sm text-slate-400">Granular Role Assignment, Dual-Signoff Constraints &amp; Action Enforcements</p>
        </div>
        <div className="flex gap-2">
          {['CHIEF_MEDICAL_OFFICER', 'ATTENDING_PHYSICIAN', 'ICU_STAFF_NURSE', 'PHARMACIST'].map(role => (
            <button
              key={role}
              onClick={() => setSelectedRole(role)}
              className={`px-3 py-1.5 rounded text-xs font-semibold ${selectedRole === role ? 'bg-sky-600 text-white' : 'bg-slate-800 text-slate-400 hover:bg-slate-700'}`}
            >
              {role.replace(/_/g, ' ')}
            </button>
          ))}
        </div>
      </header>

      <div className="bg-slate-800/80 rounded-xl border border-slate-700 overflow-hidden">
        <table className="w-full text-left text-xs text-slate-300">
          <thead className="bg-slate-950 text-slate-400 uppercase font-mono">
            <tr>
              <th className="p-3">Action Code</th>
              <th className="p-3">Module</th>
              <th className="p-3">Description</th>
              <th className="p-3">Risk Level</th>
              <th className="p-3">Dual Sign-Off</th>
              <th className="p-3 text-right">Status</th>
            </tr>
          </thead>
          <tbody className="divide-y divide-slate-700/60">
            {CLINICAL_PERMISSIONS_CATALOG.map((p) => (
              <tr key={p.permissionCode} className="hover:bg-slate-800/50">
                <td className="p-3 font-mono font-bold text-sky-400">{p.permissionCode}</td>
                <td className="p-3 text-slate-300">{p.module}</td>
                <td className="p-3 text-slate-200">{p.description}</td>
                <td className="p-3">
                  <span className={`px-2 py-0.5 rounded text-xs font-bold ${p.isHighRiskAction ? 'bg-rose-900/60 text-rose-300 border border-rose-700' : 'bg-slate-700 text-slate-300'}`}>
                    {p.isHighRiskAction ? 'HIGH RISK' : 'STANDARD'}
                  </span>
                </td>
                <td className="p-3">
                  <span className={`px-2 py-0.5 rounded text-xs font-bold ${p.requiresTwoPersonVerification ? 'bg-amber-900/60 text-amber-300 border border-amber-700' : 'bg-slate-700 text-slate-300'}`}>
                    {p.requiresTwoPersonVerification ? 'REQUIRED' : 'NO'}
                  </span>
                </td>
                <td className="p-3 text-right">
                  <span className="text-emerald-400 font-bold">GRANTED</span>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};
