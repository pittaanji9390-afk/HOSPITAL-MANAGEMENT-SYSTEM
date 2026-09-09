import React, { useState } from 'react';
import { Scissors, CheckSquare, ShieldCheck, AlertOctagon, UserCheck, Clock } from 'lucide-react';

export const SurgicalSafetySuite: React.FC = () => {
  const [phase, setPhase] = useState<'sign-in' | 'time-out' | 'sign-out'>('time-out');

  return (
    <div className="space-y-6">
      <div className="bg-emerald-950 text-white p-6 rounded-2xl border border-emerald-900 shadow-xl flex justify-between items-center">
        <div>
          <div className="flex items-center gap-3">
            <Scissors className="w-8 h-8 text-emerald-400" />
            <h1 className="text-2xl font-bold">WHO Surgical Safety & Perioperative Checklist</h1>
          </div>
          <p className="text-emerald-300 text-sm mt-1">Triple-Phase Verification to Eliminate Wrong-Site Surgery and Retained Surgical Items</p>
        </div>
        <span className="text-xs font-bold px-3 py-1 bg-emerald-800/80 text-emerald-200 border border-emerald-700 rounded-xl">OR-3: Total Knee Arthroplasty</span>
      </div>

      <div className="flex gap-2 p-1 bg-slate-100 rounded-xl border border-slate-200 max-w-md">
        <button
          onClick={() => setPhase('sign-in')}
          className={`flex-1 py-2 text-xs font-bold rounded-lg transition-all ${phase === 'sign-in' ? 'bg-white shadow text-emerald-800' : 'text-slate-600'}`}
        >
          1. Sign-In (Before Anesthesia)
        </button>
        <button
          onClick={() => setPhase('time-out')}
          className={`flex-1 py-2 text-xs font-bold rounded-lg transition-all ${phase === 'time-out' ? 'bg-white shadow text-emerald-800' : 'text-slate-600'}`}
        >
          2. Time-Out (Before Incision)
        </button>
        <button
          onClick={() => setPhase('sign-out')}
          className={`flex-1 py-2 text-xs font-bold rounded-lg transition-all ${phase === 'sign-out' ? 'bg-white shadow text-emerald-800' : 'text-slate-600'}`}
        >
          3. Sign-Out (Before Leaving OR)
        </button>
      </div>

      <div className="bg-white rounded-2xl border border-slate-200 shadow-sm p-6 space-y-4">
        <h3 className="font-bold text-base text-slate-900">
          {phase === 'sign-in' && 'Phase 1: Sign-In Verifications (Nurse & Anesthesiologist)'}
          {phase === 'time-out' && 'Phase 2: Time-Out Active Pause (Entire OR Surgical Team)'}
          {phase === 'sign-out' && 'Phase 3: Sign-Out & Specimen Check (Surgeon, Anesthetist & Scrub Nurse)'}
        </h3>

        <div className="space-y-3">
          {[
            'Patient has confirmed identity, site, procedure, and signed informed consent',
            'Surgical site marked with indelible marker by operating surgeon',
            'Pulse oximeter on patient and functioning (SpO2: 99%)',
            'Known allergy check: No known drug allergies (Penicillin-safe)',
            'Difficult airway / aspiration risk assessed (Equipment & video laryngoscope available)',
            'Risk of > 500 mL blood loss in adults (2 IV lines placed & 2 Units PRBC crossmatched)',
            'Prophylactic antibiotic administered within 60 minutes prior to surgical incision (Cefazolin 2g IV)'
          ].map((item, idx) => (
            <label key={idx} className="flex items-center gap-3 p-3 bg-slate-50 hover:bg-slate-100 rounded-xl border border-slate-200 cursor-pointer transition-all">
              <input type="checkbox" defaultChecked className="w-4 h-4 text-emerald-600 rounded border-slate-300 focus:ring-emerald-500" />
              <span className="text-xs font-medium text-slate-800">{item}</span>
            </label>
          ))}
        </div>
      </div>
    </div>
  );
};
