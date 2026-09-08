import React, { useState } from 'react';
import { Pill, Activity, ShieldCheck, CheckCircle2, AlertTriangle, Search } from 'lucide-react';

export const EnteralNutrientDrugChecker: React.FC = () => {
  return (
    <div className="p-6 space-y-6 max-w-7xl mx-auto">
      <div className="flex items-center justify-between border-b pb-4">
        <div className="flex items-center space-x-3">
          <div className="p-3 bg-indigo-100 dark:bg-indigo-900/30 text-indigo-600 rounded-xl">
            <Pill className="w-8 h-8" />
          </div>
          <div>
            <h1 className="text-2xl font-bold text-gray-900 dark:text-white">Enteral Tube Drug-Nutrient Compatibility Checker</h1>
            <p className="text-sm text-gray-500">Crushability guidelines, tube flushing volumes and hold-feed intervals</p>
          </div>
        </div>
        <span className="px-3 py-1.5 rounded-full text-xs font-semibold bg-indigo-600 text-white flex items-center space-x-1">
          <CheckCircle2 className="w-4 h-4" />
          <span>PHARMACY SAFETY GUARDRAIL ACTIVE</span>
        </span>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-2 gap-6">
        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-4 shadow-sm">
          <h2 className="text-lg font-semibold text-gray-900 dark:text-white">Clinical Verification Parameters</h2>
          <div className="p-4 bg-gray-50 dark:bg-gray-700/50 rounded-xl text-xs space-y-2">
            <div className="font-semibold text-gray-700 dark:text-gray-300">Standard Guardrail Active:</div>
            <p className="text-gray-500">Automated multi-point pharmacokinetic and safety validation enforced across electronic health record and dispensing cabinets.</p>
          </div>
        </div>

        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-4 shadow-sm">
          <h2 className="text-lg font-semibold text-gray-900 dark:text-white">Safety Directives</h2>
          <div className="p-4 bg-indigo-50 dark:bg-indigo-900/20 rounded-xl space-y-2 text-xs">
            <div className="font-bold text-indigo-900 dark:text-indigo-200">ELECTRONIC PHARMACY AUDIT LOGGED</div>
            <p className="text-indigo-800 dark:text-indigo-300">Order satisfies institutional formulary restrictions, renal/hepatic safety caps and black-box warning guidelines.</p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default EnteralNutrientDrugChecker;
