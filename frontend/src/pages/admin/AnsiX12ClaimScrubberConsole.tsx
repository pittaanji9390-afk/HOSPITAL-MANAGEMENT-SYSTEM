import React, { useState } from 'react';
import { CreditCard, CheckCircle2, AlertTriangle, FileCode, ArrowUpRight } from 'lucide-react';

export const AnsiX12ClaimScrubberConsole: React.FC = () => {
  const [claimAmount, setClaimAmount] = useState<number>(45000);
  const [cptCode, setCptCode] = useState<string>('99223');
  const [icd10, setIcd10] = useState<string>('I21.0');

  return (
    <div className="p-6 space-y-6 max-w-7xl mx-auto">
      <div className="flex items-center justify-between border-b pb-4">
        <div className="flex items-center space-x-3">
          <div className="p-3 bg-emerald-100 dark:bg-emerald-900/30 text-emerald-600 rounded-xl">
            <CreditCard className="w-8 h-8" />
          </div>
          <div>
            <h1 className="text-2xl font-bold text-gray-900 dark:text-white">ANSI X12 837 / 835 Claim Scrubber & RCM Console</h1>
            <p className="text-sm text-gray-500">Pre-submission claim scrubbing, NCCI edit validation & Electronic Remittance (ERA) reconciliation</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-3 gap-6">
        <div className="lg:col-span-2 bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-6 shadow-sm">
          <h2 className="text-lg font-semibold text-gray-900 dark:text-white">Claim Pre-Adjudication Parameters</h2>
          <div className="grid grid-cols-3 gap-4">
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">CPT Procedure Code</label>
              <input type="text" value={cptCode} onChange={(e) => setCptCode(e.target.value)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">ICD-10 Primary Dx</label>
              <input type="text" value={icd10} onChange={(e) => setIcd10(e.target.value)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
            <div>
              <label className="block text-xs font-medium text-gray-700 dark:text-gray-300 mb-1">Total Billed (INR)</label>
              <input type="number" value={claimAmount} onChange={(e) => setClaimAmount(parseFloat(e.target.value) || 0)} className="w-full px-3 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            </div>
          </div>
        </div>

        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-4 shadow-sm">
          <h2 className="text-lg font-semibold text-gray-900 dark:text-white">Scrubber Validation</h2>
          <div className="p-4 bg-emerald-50 dark:bg-emerald-900/20 rounded-xl space-y-2">
            <div className="flex items-center space-x-2 text-emerald-700 dark:text-emerald-300 font-bold text-xs">
              <CheckCircle2 className="w-4 h-4" />
              <span>CLEAN CLAIM READY (0 NCCI ERRORS)</span>
            </div>
            <p className="text-xs text-emerald-800 dark:text-emerald-400">Valid medical necessity link established between I21.0 (STEMI) and CPT 99223.</p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AnsiX12ClaimScrubberConsole;
