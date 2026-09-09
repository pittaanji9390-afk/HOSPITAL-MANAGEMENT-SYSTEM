import React, { useState } from 'react';
import { Lock, ShieldAlert, Key, UserCheck, AlertOctagon } from 'lucide-react';

export const PyxisNarcoticsAuditConsole: React.FC = () => {
  return (
    <div className="p-6 space-y-6 max-w-7xl mx-auto">
      <div className="flex items-center justify-between border-b pb-4">
        <div className="flex items-center space-x-3">
          <div className="p-3 bg-amber-100 dark:bg-amber-900/30 text-amber-600 rounded-xl">
            <Lock className="w-8 h-8" />
          </div>
          <div>
            <h1 className="text-2xl font-bold text-gray-900 dark:text-white">Pyxis ADC Controlled Substances & Narcotics Vault Audit</h1>
            <p className="text-sm text-gray-500">DEA Schedule II-V dual-witness signoff logs, waste discrepancy tracking & inventory audit</p>
          </div>
        </div>
      </div>

      <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-6 shadow-sm">
        <div className="overflow-x-auto">
          <table className="w-full text-left text-xs">
            <thead className="bg-gray-50 dark:bg-gray-700/50 uppercase text-gray-500">
              <tr>
                <th className="p-3">Timestamp</th>
                <th className="p-3">Cabinet</th>
                <th className="p-3">Controlled Substance</th>
                <th className="p-3">Action</th>
                <th className="p-3">Nurse ID</th>
                <th className="p-3">Witness Nurse ID</th>
                <th className="p-3">Status</th>
              </tr>
            </thead>
            <tbody className="divide-y dark:divide-gray-700">
              <tr>
                <td className="p-3">2026-09-08 16:30</td>
                <td className="p-3 font-semibold">ICU-ADC-01</td>
                <td className="p-3 font-bold text-red-600">Fentanyl 100mcg/2mL Ampul</td>
                <td className="p-3">DISPENSE + WASTE 50mcg</td>
                <td className="p-3">RN-8821</td>
                <td className="p-3">RN-4412</td>
                <td className="p-3 font-semibold text-green-600">DUAL-VERIFIED</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
};

export default PyxisNarcoticsAuditConsole;
