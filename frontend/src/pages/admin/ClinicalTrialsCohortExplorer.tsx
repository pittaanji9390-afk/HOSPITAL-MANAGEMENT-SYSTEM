import React, { useState } from 'react';
import { Dna, Search, Users, Award, CheckCircle2 } from 'lucide-react';

export const ClinicalTrialsCohortExplorer: React.FC = () => {
  const [biomarker, setBiomarker] = useState<string>('EGFR L858R');

  return (
    <div className="p-6 space-y-6 max-w-7xl mx-auto">
      <div className="flex items-center justify-between border-b pb-4">
        <div className="flex items-center space-x-3">
          <div className="p-3 bg-purple-100 dark:bg-purple-900/30 text-purple-600 rounded-xl">
            <Dna className="w-8 h-8" />
          </div>
          <div>
            <h1 className="text-2xl font-bold text-gray-900 dark:text-white">Clinical Trials Genomic Cohort Screening Engine</h1>
            <p className="text-sm text-gray-500">Next-Generation Sequencing (NGS) oncology mutation matcher & clinical trial enrollment</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-3 gap-6">
        <div className="lg:col-span-2 bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-4 shadow-sm">
          <h2 className="text-lg font-semibold text-gray-900 dark:text-white">Active Biomarker Screening</h2>
          <div className="flex space-x-4">
            <input type="text" value={biomarker} onChange={(e) => setBiomarker(e.target.value)} className="px-4 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
            <button className="px-4 py-2 bg-purple-600 hover:bg-purple-700 text-white rounded-lg text-sm font-semibold">Match Cohorts</button>
          </div>
          <div className="p-4 bg-purple-50 dark:bg-purple-900/20 rounded-xl text-xs space-y-2">
            <span className="font-bold text-purple-900 dark:text-purple-300">Matched Trial: NCT04928192 (Osimertinib 3rd Gen TKI Combination)</span>
            <p className="text-purple-800 dark:text-purple-400">14 Inpatient candidates identified meeting inclusion criteria (Stage IV NSCLC + EGFR L858R + ECOG 0-1).</p>
          </div>
        </div>

        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-4 shadow-sm">
          <h2 className="text-lg font-semibold text-gray-900 dark:text-white">Enrollment Funnel</h2>
          <div className="p-4 bg-gray-50 dark:bg-gray-700/50 rounded-xl flex justify-between items-center">
            <span className="text-xs text-gray-600 dark:text-gray-300">Screened Patients</span>
            <span className="text-lg font-bold text-purple-600">1,248</span>
          </div>
          <div className="p-4 bg-gray-50 dark:bg-gray-700/50 rounded-xl flex justify-between items-center">
            <span className="text-xs text-gray-600 dark:text-gray-300">Eligible Candidates</span>
            <span className="text-lg font-bold text-emerald-600">14</span>
          </div>
        </div>
      </div>
    </div>
  );
};

export default ClinicalTrialsCohortExplorer;
