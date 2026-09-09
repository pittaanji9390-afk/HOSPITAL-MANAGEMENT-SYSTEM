import React, { useState } from 'react';
import { NANDA_HEALTH_PROMOTION_CATALOG } from '../types/nandaHealthPromotion';
import { NANDA_NUTRITION_CATALOG } from '../types/nandaNutrition';
import { NANDA_ELIMINATION_CATALOG } from '../types/nandaElimination';
import { NANDA_ACTIVITY_REST_CATALOG } from '../types/nandaActivityRest';
import { NANDA_PERCEPTION_COGNITION_CATALOG } from '../types/nandaPerceptionCognition';
import { NANDA_COPING_STRESS_CATALOG } from '../types/nandaCopingStress';
import { NANDA_SAFETY_PROTECTION_CATALOG } from '../types/nandaSafetyProtection';
import { NANDA_COMFORT_PAIN_CATALOG } from '../types/nandaComfortPain';

export const NandaCarePlannerConsole: React.FC = () => {
  const [selectedDomain, setSelectedDomain] = useState<string>('All');
  const [patientId, setPatientId] = useState('PT-ICU-8821');
  const [activeCarePlans, setActiveCarePlans] = useState<any[]>([
    { id: 'CP-101', code: '00030', name: 'Impaired Gas Exchange', targetScore: 5, currentScore: 3, shiftEvaluation: 'SpO2 improved to 96% on 2L NC' },
    { id: 'CP-102', code: '00155', name: 'Risk for Falls', targetScore: 5, currentScore: 5, shiftEvaluation: 'Bed alarm active, zero falls documented' }
  ]);

  const allDiagnoses = [
    ...NANDA_HEALTH_PROMOTION_CATALOG,
    ...NANDA_NUTRITION_CATALOG,
    ...NANDA_ELIMINATION_CATALOG,
    ...NANDA_ACTIVITY_REST_CATALOG,
    ...NANDA_PERCEPTION_COGNITION_CATALOG,
    ...NANDA_COPING_STRESS_CATALOG,
    ...NANDA_SAFETY_PROTECTION_CATALOG,
    ...NANDA_COMFORT_PAIN_CATALOG
  ];

  const filteredDiagnoses = selectedDomain === 'All' 
    ? allDiagnoses 
    : allDiagnoses.filter(d => d.domain.toLowerCase().includes(selectedDomain.toLowerCase()));

  const addCarePlan = (diag: any) => {
    const newPlan = {
      id: `CP-${Date.now().toString().slice(-4)}`,
      code: diag.code,
      name: diag.diagnosisName,
      targetScore: 5,
      currentScore: 2,
      shiftEvaluation: 'Care plan initiated on admission'
    };
    setActiveCarePlans([...activeCarePlans, newPlan]);
  };

  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">NANDA-I Nursing Care Plan &amp; NOC Goal Tracker</h1>
          <p className="text-sm text-slate-400">Standardized Nursing Diagnoses, Interventions (NIC), and Outcome Metrics (NOC)</p>
        </div>
        <div className="flex gap-3">
          <input 
            type="text" 
            value={patientId} 
            onChange={(e) => setPatientId(e.target.value)}
            className="bg-slate-800 border border-slate-700 rounded px-3 py-1 text-sm text-white font-mono"
          />
          <button className="bg-emerald-600 hover:bg-emerald-500 text-white px-4 py-2 rounded text-sm font-semibold">
            Save Shift Care Plan
          </button>
        </div>
      </header>

      {/* Active Care Plans Matrix */}
      <div className="mb-8 bg-slate-800/80 p-5 rounded-xl border border-slate-700">
        <h2 className="text-lg font-semibold text-amber-400 mb-4">Active Nursing Care Plans for Patient: {patientId}</h2>
        <div className="space-y-4">
          {activeCarePlans.map((plan) => (
            <div key={plan.id} className="p-4 bg-slate-900/90 rounded-lg border border-slate-700/80 flex flex-col md:flex-row justify-between items-start md:items-center gap-4">
              <div className="flex-1">
                <div className="flex items-center gap-2">
                  <span className="px-2 py-0.5 bg-sky-900/60 text-sky-300 font-mono text-xs rounded">NANDA #{plan.code}</span>
                  <span className="font-semibold text-slate-200">{plan.name}</span>
                </div>
                <p className="text-xs text-slate-400 mt-1">Shift Evaluation Note: {plan.shiftEvaluation}</p>
              </div>
              <div className="flex items-center gap-4">
                <div className="text-right">
                  <span className="text-xs text-slate-400 block">NOC Likert Progress</span>
                  <span className="font-mono text-sm text-emerald-400 font-bold">{plan.currentScore} / {plan.targetScore}</span>
                </div>
                <input 
                  type="range" 
                  min="1" 
                  max="5" 
                  value={plan.currentScore}
                  onChange={(e) => {
                    const score = parseInt(e.target.value);
                    setActiveCarePlans(activeCarePlans.map(p => p.id === plan.id ? { ...p, currentScore: score } : p));
                  }}
                  className="w-24 accent-emerald-500"
                />
              </div>
            </div>
          ))}
        </div>
      </div>

      {/* Diagnosis Catalog Browser */}
      <div>
        <div className="flex justify-between items-center mb-4">
          <h2 className="text-lg font-semibold text-sky-300">NANDA-I Taxonomy Catalog</h2>
          <div className="flex gap-2">
            {['All', 'Nutrition', 'Elimination', 'Activity', 'Perception', 'Safety', 'Comfort'].map((dom) => (
              <button
                key={dom}
                onClick={() => setSelectedDomain(dom)}
                className={`px-3 py-1 rounded text-xs font-semibold ${selectedDomain === dom ? 'bg-sky-600 text-white' : 'bg-slate-800 text-slate-400 hover:bg-slate-700'}`}
              >
                {dom}
              </button>
            ))}
          </div>
        </div>

        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
          {filteredDiagnoses.map((diag) => (
            <div key={diag.code} className="p-4 bg-slate-800/60 rounded-lg border border-slate-700/60 flex flex-col justify-between">
              <div>
                <div className="flex justify-between items-start mb-2">
                  <span className="text-xs font-mono text-sky-400 font-bold">#{diag.code}</span>
                  <span className="text-xs bg-slate-700 px-2 py-0.5 rounded text-slate-300">{diag.domain}</span>
                </div>
                <h3 className="font-semibold text-slate-100 mb-2">{diag.diagnosisName}</h3>
                <div className="text-xs text-slate-400 space-y-1 mb-3">
                  <p><strong className="text-slate-300">Defining Chars:</strong> {diag.definingCharacteristics.slice(0, 2).join(', ')}</p>
                  <p><strong className="text-slate-300">Suggested NIC:</strong> {diag.suggestedNicInterventions.slice(0, 2).join(', ')}</p>
                </div>
              </div>
              <button 
                onClick={() => addCarePlan(diag)}
                className="w-full mt-2 bg-slate-700 hover:bg-sky-600 text-white text-xs font-medium py-1.5 rounded transition"
              >
                + Adopt Into Care Plan
              </button>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};
