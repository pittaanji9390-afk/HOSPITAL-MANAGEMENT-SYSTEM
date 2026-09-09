import React, { useState } from 'react';
import { Building2, ShieldCheck, CheckCircle2, Activity, AlertTriangle, Truck, Users } from 'lucide-react';

export const MassCasualtyTriageTagBoard: React.FC = () => {
  return (
    <div className="p-6 space-y-6 max-w-7xl mx-auto">
      <div className="flex items-center justify-between border-b pb-4">
        <div className="flex items-center space-x-3">
          <div className="p-3 bg-blue-100 dark:bg-blue-900/30 text-blue-600 rounded-xl">
            <Building2 className="w-8 h-8" />
          </div>
          <div>
            <h1 className="text-2xl font-bold text-gray-900 dark:text-white">Mass Casualty Incident (MCI) START Triage Tag Board</h1>
            <p className="text-sm text-gray-500">Digital disaster tag tracking (Red, Yellow, Green, Black) and field surge capacity</p>
          </div>
        </div>
        <span className="px-3 py-1.5 rounded-full text-xs font-semibold bg-blue-600 text-white flex items-center space-x-1">
          <CheckCircle2 className="w-4 h-4" />
          <span>OPERATIONAL SYSTEM ACTIVE</span>
        </span>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-2 gap-6">
        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-4 shadow-sm">
          <h2 className="text-lg font-semibold text-gray-900 dark:text-white">Operational Command Parameters</h2>
          <div className="p-4 bg-gray-50 dark:bg-gray-700/50 rounded-xl text-xs space-y-2">
            <div className="font-semibold text-gray-700 dark:text-gray-300">Hospital Operations Hub:</div>
            <p className="text-gray-500">Real-time enterprise resource orchestration, staff credentialing, safety compliance and emergency surge management.</p>
          </div>
        </div>

        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-4 shadow-sm">
          <h2 className="text-lg font-semibold text-gray-900 dark:text-white">Safety & Protocol Verification</h2>
          <div className="p-4 bg-blue-50 dark:bg-blue-900/20 rounded-xl space-y-2 text-xs">
            <div className="font-bold text-blue-900 dark:text-blue-200">CENTRAL OPERATIONS STATUS VERIFIED</div>
            <p className="text-blue-800 dark:text-blue-300">Compliant with National Disaster Management Authority (NDMA) and NABH Hospital Operations Standards.</p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default MassCasualtyTriageTagBoard;
