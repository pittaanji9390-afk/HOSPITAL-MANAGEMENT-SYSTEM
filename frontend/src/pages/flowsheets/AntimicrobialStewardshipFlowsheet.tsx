import React, { useState } from 'react';
import { Pill, CheckCircle2, ArrowRight } from 'lucide-react';

export const AntimicrobialStewardshipFlowsheet: React.FC = () => {
  return (
    <div className="p-6 space-y-6 max-w-7xl mx-auto">
      <div className="flex items-center justify-between border-b pb-4">
        <div className="flex items-center space-x-3">
          <div className="p-3 bg-teal-100 dark:bg-teal-900/30 text-teal-600 rounded-xl">
            <Pill className="w-8 h-8" />
          </div>
          <div>
            <h1 className="text-2xl font-bold text-gray-900 dark:text-white">Antimicrobial Stewardship 48h Culture De-escalation Console</h1>
            <p className="text-sm text-gray-500">Automated micro-culture sensitivity matcher and IV-to-oral bioavailability conversion steerer</p>
          </div>
        </div>
      </div>

      <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-4 shadow-sm">
        <h2 className="text-lg font-semibold text-gray-900 dark:text-white">Active Stewardship Opportunities</h2>
        <div className="p-4 bg-teal-50 dark:bg-teal-900/20 rounded-xl space-y-2">
          <div className="flex items-center justify-between">
            <span className="font-bold text-teal-900 dark:text-teal-200 text-sm">Patient: Jane Doe (MRN-88192) - Bed ICU-02</span>
            <span className="px-2.5 py-1 bg-teal-600 text-white text-xs font-semibold rounded-full">ACTIONABLE</span>
          </div>
          <div className="text-xs text-teal-800 dark:text-teal-300">
            Blood Culture Final: <strong className="text-teal-950 dark:text-white">MSSA (Methicillin-Susceptible Staph aureus)</strong>
          </div>
          <div className="p-3 bg-white dark:bg-gray-800 rounded-lg flex items-center justify-between text-xs font-semibold">
            <span className="text-red-500">Current: Vancomycin 1500mg IV Q12H</span>
            <ArrowRight className="w-4 h-4 text-gray-400" />
            <span className="text-emerald-600">Recommended: Cefazolin 2g IV Q8H (Superior MSSA clearance)</span>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AntimicrobialStewardshipFlowsheet;
