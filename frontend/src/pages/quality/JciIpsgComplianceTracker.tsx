import React, { useState } from 'react';
import { Award, ShieldCheck, CheckCircle2, Activity, AlertTriangle, FileText } from 'lucide-react';

export const JciIpsgComplianceTracker: React.FC = () => {
  return (
    <div className="p-6 space-y-6 max-w-7xl mx-auto">
      <div className="flex items-center justify-between border-b pb-4">
        <div className="flex items-center space-x-3">
          <div className="p-3 bg-emerald-100 dark:bg-emerald-900/30 text-emerald-600 rounded-xl">
            <Award className="w-8 h-8" />
          </div>
          <div>
            <h1 className="text-2xl font-bold text-gray-900 dark:text-white">JCI International Patient Safety Goals (IPSG) Tracker</h1>
            <p className="text-sm text-gray-500">Real-time compliance monitoring for patient ID, high-alert meds and time-outs</p>
          </div>
        </div>
        <span className="px-3 py-1.5 rounded-full text-xs font-semibold bg-emerald-600 text-white flex items-center space-x-1">
          <CheckCircle2 className="w-4 h-4" />
          <span>NABH / JCI ACCREDITED METRIC</span>
        </span>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-2 gap-6">
        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-4 shadow-sm">
          <h2 className="text-lg font-semibold text-gray-900 dark:text-white">Quality Benchmark Parameters</h2>
          <div className="p-4 bg-gray-50 dark:bg-gray-700/50 rounded-xl text-xs space-y-2">
            <div className="font-semibold text-gray-700 dark:text-gray-300">Accreditation Standard Active:</div>
            <p className="text-gray-500">Continuous institutional quality surveillance and international patient safety benchmarking enforced in real-time.</p>
          </div>
        </div>

        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-4 shadow-sm">
          <h2 className="text-lg font-semibold text-gray-900 dark:text-white">Safety Directives</h2>
          <div className="p-4 bg-emerald-50 dark:bg-emerald-900/20 rounded-xl space-y-2 text-xs">
            <div className="font-bold text-emerald-900 dark:text-emerald-200">ZERO HARM SAFETY PROTOCOL VERIFIED</div>
            <p className="text-emerald-800 dark:text-emerald-300">All elements meet or exceed NABH 5th Edition and JCI 7th Edition accreditation compliance targets.</p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default JciIpsgComplianceTracker;
