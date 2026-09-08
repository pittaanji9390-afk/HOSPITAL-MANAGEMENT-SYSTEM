import React, { useState } from 'react';

export const BreakGlassEmergencyAccessConsole: React.FC = () => {
  const [patientId, setPatientId] = useState('PT-EMERG-8812');
  const [reasonCategory, setReasonCategory] = useState('TRAUMA_ESI_1');
  const [justification, setJustification] = useState('');
  const [isElevated, setIsElevated] = useState(false);

  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-rose-400">Emergency "Break-Glass" Access Elevation</h1>
          <p className="text-sm text-slate-400">Emergency Override for STAT Resuscitation with Mandatory Immediate Audit</p>
        </div>
      </header>

      <div className="max-w-2xl bg-slate-800/90 p-6 rounded-xl border border-rose-900/80">
        <div className="p-4 bg-rose-950/40 border border-rose-800 rounded-lg mb-6 text-xs text-rose-200">
          <strong>LEGAL &amp; COMPLIANCE WARNING:</strong> All Break-Glass overrides are instantly flagged for Compliance Officer and Department Supervisor audit under HIPAA 45 CFR § 164.312.
        </div>

        <div className="space-y-4">
          <div>
            <label className="text-xs text-slate-400 block mb-1">Target Patient ID</label>
            <input 
              type="text" 
              value={patientId}
              onChange={(e) => setPatientId(e.target.value)}
              className="w-full bg-slate-900 border border-slate-700 rounded px-3 py-2 text-sm text-white font-mono"
            />
          </div>

          <div>
            <label className="text-xs text-slate-400 block mb-1">Emergency Justification Category</label>
            <select 
              value={reasonCategory}
              onChange={(e) => setReasonCategory(e.target.value)}
              className="w-full bg-slate-900 border border-slate-700 rounded px-3 py-2 text-sm text-slate-200"
            >
              <option value="TRAUMA_ESI_1">Level 1 Severe Trauma / Hemorrhage Resuscitation</option>
              <option value="CODE_BLUE">Inpatient Cardiac / Respiratory Arrest (Code Blue)</option>
              <option value="STAT_STROKE">STAT Acute Ischemic Stroke Thrombolysis Window</option>
              <option value="PSYCH_CRISIS">Acute Psych Crisis / Imminent Harm Prevention</option>
            </select>
          </div>

          <div>
            <label className="text-xs text-slate-400 block mb-1">Detailed Clinical Rationale (Mandatory)</label>
            <textarea 
              rows={3}
              value={justification}
              onChange={(e) => setJustification(e.target.value)}
              placeholder="Enter patient condition and immediate clinical urgency..."
              className="w-full bg-slate-900 border border-slate-700 rounded px-3 py-2 text-sm text-white"
            />
          </div>

          <button 
            onClick={() => setIsElevated(true)}
            className="w-full bg-rose-600 hover:bg-rose-500 text-white font-bold py-3 rounded-lg text-sm transition"
          >
            CONFIRM &amp; ACTIVATE 4-HOUR BREAK-GLASS OVERRIDE
          </button>
        </div>

        {isElevated && (
          <div className="mt-6 p-4 bg-emerald-950/60 border border-emerald-700 rounded-lg text-center">
            <span className="text-sm font-bold text-emerald-300 block">✓ BREAK-GLASS ELEVATION ACTIVE</span>
            <span className="text-xs text-slate-400 font-mono">Token: BG-TOK-88F41A99 | Expires in 3h 59m</span>
          </div>
        )}
      </div>
    </div>
  );
};
