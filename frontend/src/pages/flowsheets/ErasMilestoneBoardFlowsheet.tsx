import React, { useState } from 'react';
import { Award, CheckCircle2, Clock } from 'lucide-react';

export const ErasMilestoneBoardFlowsheet: React.FC = () => {
  return (
    <div className="p-6 space-y-6 max-w-7xl mx-auto">
      <div className="flex items-center justify-between border-b pb-4">
        <div className="flex items-center space-x-3">
          <div className="p-3 bg-emerald-100 dark:bg-emerald-900/30 text-emerald-600 rounded-xl">
            <Award className="w-8 h-8" />
          </div>
          <div>
            <h1 className="text-2xl font-bold text-gray-900 dark:text-white">ERAS Surgical Fast-Track Milestone Board</h1>
            <p className="text-sm text-gray-500">Enhanced Recovery After Surgery multimodal pain management, early feeding and ambulation milestones</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-3 gap-6">
        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-4 shadow-sm">
          <h2 className="text-md font-bold text-emerald-600">POD 0: Day of Surgery</h2>
          <ul className="text-xs space-y-2 text-gray-600 dark:text-gray-300">
            <li className="flex items-center space-x-2"><CheckCircle2 className="w-4 h-4 text-emerald-500" /><span>Clear liquids tolerated</span></li>
            <li className="flex items-center space-x-2"><CheckCircle2 className="w-4 h-4 text-emerald-500" /><span>Out of bed to chair &gt;= 2 hours</span></li>
          </ul>
        </div>
        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-4 shadow-sm">
          <h2 className="text-md font-bold text-emerald-600">POD 1: Mobilization & Diet</h2>
          <ul className="text-xs space-y-2 text-gray-600 dark:text-gray-300">
            <li className="flex items-center space-x-2"><CheckCircle2 className="w-4 h-4 text-emerald-500" /><span>Foley catheter removed</span></li>
            <li className="flex items-center space-x-2"><CheckCircle2 className="w-4 h-4 text-emerald-500" /><span>Regular solid diet resumed</span></li>
          </ul>
        </div>
        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-4 shadow-sm">
          <h2 className="text-md font-bold text-emerald-600">POD 2: Discharge Readiness</h2>
          <ul className="text-xs space-y-2 text-gray-600 dark:text-gray-300">
            <li className="flex items-center space-x-2"><CheckCircle2 className="w-4 h-4 text-emerald-500" /><span>Oral analgesia well controlled</span></li>
            <li className="flex items-center space-x-2"><CheckCircle2 className="w-4 h-4 text-emerald-500" /><span>Safe independent ambulation</span></li>
          </ul>
        </div>
      </div>
    </div>
  );
};

export default ErasMilestoneBoardFlowsheet;
