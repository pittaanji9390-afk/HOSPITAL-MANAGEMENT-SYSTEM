import React, { useState } from 'react';
import { ShieldCheck, UserCheck, Key, RefreshCw, FileText, CheckCircle2 } from 'lucide-react';

export const AbdmAdminConsole: React.FC = () => {
  const [abhaAddress, setAbhaAddress] = useState<string>('anji.pitta@abdm');
  const [consentStatus, setConsentStatus] = useState<string>('GRANTED');
  const [isLinking, setIsLinking] = useState<boolean>(false);

  return (
    <div className="p-6 space-y-6 max-w-7xl mx-auto">
      <div className="flex items-center justify-between border-b pb-4">
        <div className="flex items-center space-x-3">
          <div className="p-3 bg-emerald-100 dark:bg-emerald-900/30 text-emerald-600 rounded-xl">
            <ShieldCheck className="w-8 h-8" />
          </div>
          <div>
            <h1 className="text-2xl font-bold text-gray-900 dark:text-white">ABDM / NDHM National Gateway Console</h1>
            <p className="text-sm text-gray-500">Ayushman Bharat Digital Mission Milestones M1 (ABHA), M2 (HIP Linking), and M3 (HIU Consent)</p>
          </div>
        </div>
        <span className="px-3 py-1.5 rounded-full text-xs font-semibold bg-emerald-600 text-white flex items-center space-x-1">
          <CheckCircle2 className="w-4 h-4" />
          <span>PRODUCTION GATEWAY ACTIVE</span>
        </span>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-3 gap-6">
        <div className="lg:col-span-2 bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-6 shadow-sm">
          <h2 className="text-lg font-semibold flex items-center space-x-2 text-gray-900 dark:text-white">
            <UserCheck className="w-5 h-5 text-emerald-500" />
            <span>ABHA Address & Care Context Linking</span>
          </h2>
          <div className="grid grid-cols-2 gap-4">
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">ABHA Address (PHR Handle)</label>
              <input type="text" value={abhaAddress} onChange={(e) => setAbhaAddress(e.target.value)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">HIP Identifier</label>
              <input type="text" disabled value="IN-AP-HOSP-001 (Apollo/AIIMS Hub)" className="w-full px-3 py-2 border rounded-lg bg-gray-100 dark:bg-gray-700 dark:border-gray-600" />
            </div>
          </div>
          <button onClick={() => setIsLinking(true)} className="px-4 py-2 bg-emerald-600 hover:bg-emerald-700 text-white rounded-lg text-sm font-semibold flex items-center space-x-2">
            <RefreshCw className={`w-4 h-4 ${isLinking ? 'animate-spin' : ''}`} />
            <span>Link Encounter Care Context (FHIR R4)</span>
          </button>
        </div>

        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-6 shadow-sm">
          <h2 className="text-lg font-semibold flex items-center space-x-2 text-gray-900 dark:text-white">
            <Key className="w-5 h-5 text-emerald-500" />
            <span>Consent Artefact Details</span>
          </h2>
          <div className="space-y-4 text-xs">
            <div className="p-3 bg-gray-50 dark:bg-gray-700/50 rounded-xl space-y-1">
              <span className="font-semibold text-gray-700 dark:text-gray-300">Consent Artefact UUID</span>
              <p className="font-mono text-gray-500">772a910e-881b-4fc1-b210-948201948201</p>
            </div>
            <div className="p-3 bg-gray-50 dark:bg-gray-700/50 rounded-xl space-y-1">
              <span className="font-semibold text-gray-700 dark:text-gray-300">Authorized HI Types</span>
              <p className="text-emerald-600 font-medium">DiagnosticReport, Prescription, DischargeSummary</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AbdmAdminConsole;
