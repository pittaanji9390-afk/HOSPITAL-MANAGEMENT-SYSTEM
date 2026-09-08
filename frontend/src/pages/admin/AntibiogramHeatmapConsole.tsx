import React, { useState } from 'react';
import { ShieldCheck, Flame, Activity, CheckCircle2 } from 'lucide-react';

export const AntibiogramHeatmapConsole: React.FC = () => {
  return (
    <div className="p-6 space-y-6 max-w-7xl mx-auto">
      <div className="flex items-center justify-between border-b pb-4">
        <div className="flex items-center space-x-3">
          <div className="p-3 bg-red-100 dark:bg-red-900/30 text-red-600 rounded-xl">
            <ShieldCheck className="w-8 h-8" />
          </div>
          <div>
            <h1 className="text-2xl font-bold text-gray-900 dark:text-white">Infection Control Cumulative Antibiogram Heatmap</h1>
            <p className="text-sm text-gray-500">CLSI M39-A4 cumulative antimicrobial susceptibility surveillance & stewardship alerts</p>
          </div>
        </div>
      </div>

      <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-6 shadow-sm">
        <div className="overflow-x-auto">
          <table className="w-full text-left text-xs">
            <thead className="bg-gray-50 dark:bg-gray-700/50 uppercase text-gray-500">
              <tr>
                <th className="p-3">Pathogen</th>
                <th className="p-3">Meropenem</th>
                <th className="p-3">Vancomycin</th>
                <th className="p-3">Colistin</th>
                <th className="p-3">Ciprofloxacin</th>
                <th className="p-3">Cefepime</th>
              </tr>
            </thead>
            <tbody className="divide-y dark:divide-gray-700 font-bold">
              <tr>
                <td className="p-3 text-gray-900 dark:text-white">Klebsiella pneumoniae (n=142)</td>
                <td className="p-3 text-emerald-600">88% (S)</td>
                <td className="p-3 text-gray-400">N/A</td>
                <td className="p-3 text-emerald-600">98% (S)</td>
                <td className="p-3 text-red-600">42% (R)</td>
                <td className="p-3 text-amber-600">64% (I)</td>
              </tr>
              <tr>
                <td className="p-3 text-gray-900 dark:text-white">MRSA (Staph aureus) (n=88)</td>
                <td className="p-3 text-red-600">0% (R)</td>
                <td className="p-3 text-emerald-600">100% (S)</td>
                <td className="p-3 text-gray-400">N/A</td>
                <td className="p-3 text-red-600">35% (R)</td>
                <td className="p-3 text-red-600">0% (R)</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
};

export default AntibiogramHeatmapConsole;
