import React, { useState } from 'react';
import {
  GitFork,
  Activity,
  HeartPulse,
  Flame,
  CheckCircle2,
  Clock,
  FileText,
  AlertTriangle,
  ChevronRight,
} from 'lucide-react';

export const ClinicalPathways: React.FC = () => {
  const [selectedPathway, setSelectedPathway] = useState<'stemi' | 'hf' | 'sepsis'>('stemi');

  const pathways = {
    stemi: {
      title: 'Acute ST-Elevation Myocardial Infarction (STEMI)',
      icd10: 'I21.0 - I21.3',
      targetTime: 'Door-to-Balloon < 90 Minutes',
      steps: [
        {
          time: '0 - 10 min',
          title: 'Emergency Triage & Stat 12-Lead ECG',
          details: 'Acquire and interpret ECG within 10 minutes. Establish 2 large-bore peripheral IV lines.',
          orders: ['12-Lead ECG Stat', 'Point-of-Care Cardiac Troponin I', 'Continuous Telemetry', 'CBC, Electrolytes, PT/INR'],
        },
        {
          time: '10 - 20 min',
          title: 'Loading Antiplatelets & Cath Lab Activation',
          details: 'Trigger Code STEMI to Cath Lab team. Administer dual antiplatelet therapy (DAPT) loading.',
          orders: ['Aspirin 325 mg chewed', 'Ticagrelor 180 mg oral loading', 'Unfractionated Heparin 60 U/kg IV', 'Atorvastatin 80 mg oral'],
        },
        {
          time: '20 - 90 min',
          title: 'Primary Percutaneous Coronary Intervention (PCI)',
          details: 'Emergency coronary angiography and culprit lesion drug-eluting stenting.',
          orders: ['Coronary Angiography', 'Drug-Eluting Stent Implantation', 'Post-PCI CCU Admission'],
        },
      ],
      discharge: [
        'LVEF documented by echocardiogram',
        'Patient established on GDMT (DAPT + Statin + Beta-blocker + ACEi/ARNI)',
        'Cardiac rehabilitation referral scheduled',
      ],
    },
    sepsis: {
      title: 'Surviving Sepsis Campaign 1-Hour Bundle',
      icd10: 'A41.9 / R65.20',
      targetTime: 'Bundle Completion < 60 Minutes',
      steps: [
        {
          time: '0 - 15 min',
          title: 'Recognition & Stat Blood Lactate',
          details: 'Screen with qSOFA or NEWS-2. Draw venous/arterial lactate immediately.',
          orders: ['Stat Blood Lactate', 'qSOFA Bedside Assessment', 'ABG / VBG'],
        },
        {
          time: '15 - 45 min',
          title: 'Blood Cultures & Empiric Antimicrobials',
          details: 'Draw 2 sets of blood cultures before starting antibiotics. Do not delay antibiotics > 45 mins.',
          orders: ['Blood Cultures x 2 Sets', 'Broad-Spectrum IV Antibiotics (e.g. Piperacillin-Tazobactam + Vancomycin)'],
        },
        {
          time: '45 - 60 min',
          title: 'Rapid Crystalloid Resuscitation & Vasopressors',
          details: 'Infuse 30 mL/kg balanced crystalloids for hypotension or lactate >= 4.0 mmol/L.',
          orders: ['IV Plasmalyte / Ringer Lactate 30 mL/kg', 'Norepinephrine Infusion (Target MAP >= 65 mmHg)'],
        },
      ],
      discharge: [
        'Resolution of systemic inflammatory signs and clear lactate clearance (< 2.0 mmol/L)',
        'Transition to targeted oral antimicrobial therapy based on culture sensitivities',
      ],
    },
    hf: {
      title: 'Acute Decompensated Heart Failure (ADHF)',
      icd10: 'I50.9',
      targetTime: 'Diuretic Initiation < 60 Minutes',
      steps: [
        {
          time: '0 - 60 min',
          title: 'Hemodynamic Profiling & IV Diuresis',
          details: 'Determine Warm/Wet status. Initiate IV loop diuretics at 2.5x oral home dose.',
          orders: ['IV Furosemide 40-80 mg stat', 'Stat NT-proBNP / BNP', 'Strict Intake/Output Charting', 'Daily Weights'],
        },
        {
          time: '24 - 48 hours',
          title: 'Diuretic Titration & GDMT Optimization',
          details: 'Evaluate spot urinary sodium and 24-hr net fluid balance (Target: -1.5 to -2.0 L/day).',
          orders: ['Daily Metabolic Panel', 'Initiate SGLT2i (Empagliflozin 10mg)', 'Titrate ARNI / Beta-blocker'],
        },
      ],
      discharge: [
        'Euvolemia achieved (no orthopnea, JVP normal, trace/no peripheral edema)',
        'Stable on oral diuretic regimen >= 24 hours',
        'Patient educated on low-sodium diet and daily weight tracking',
      ],
    },
  };

  const current = pathways[selectedPathway];

  return (
    <div className="space-y-6">
      {/* Header */}
      <div className="bg-white p-6 rounded-3xl border border-slate-200 shadow-sm">
        <h1 className="text-xl font-bold text-slate-900 tracking-tight flex items-center gap-2">
          <GitFork className="h-6 w-6 text-sky-600" />
          Standardized Inpatient Clinical Pathways & Care Protocols
        </h1>
        <p className="text-xs text-slate-500 mt-1">
          Evidence-based clinical guidelines, timed order sets, and milestone checklists
        </p>
      </div>

      {/* Pathway Switcher */}
      <div className="flex gap-3 flex-wrap">
        {[
          { key: 'stemi', label: 'Code STEMI (Acute Infarct)', icon: HeartPulse },
          { key: 'sepsis', label: 'Surviving Sepsis 1-Hour', icon: Flame },
          { key: 'hf', label: 'Decompensated Heart Failure', icon: Activity },
        ].map((p) => {
          const Icon = p.icon;
          const isSelected = selectedPathway === p.key;
          return (
            <button
              key={p.key}
              onClick={() => setSelectedPathway(p.key as any)}
              className={`px-4 py-3 rounded-2xl text-xs font-bold transition-all flex items-center gap-2 ${
                isSelected
                  ? 'bg-slate-900 text-white shadow-lg shadow-slate-900/20'
                  : 'bg-white text-slate-700 hover:bg-slate-50 border border-slate-200'
              }`}
            >
              <Icon className="h-4 w-4" />
              {p.label}
            </button>
          );
        })}
      </div>

      {/* Pathway Content Card */}
      <div className="bg-white p-6 rounded-3xl border border-slate-200 shadow-sm space-y-6">
        <div className="flex items-center justify-between flex-wrap gap-2 pb-4 border-b border-slate-100">
          <div>
            <span className="text-[10px] font-bold text-sky-600 uppercase tracking-wider">
              ICD-10 Primary: {current.icd10}
            </span>
            <h2 className="text-lg font-bold text-slate-900 mt-0.5">{current.title}</h2>
          </div>
          <span className="px-3 py-1 rounded-full text-xs font-bold bg-amber-50 text-amber-800 border border-amber-200">
            Target: {current.targetTime}
          </span>
        </div>

        {/* Steps Timeline */}
        <div className="space-y-4">
          <h3 className="text-xs font-bold text-slate-900 uppercase tracking-wider">
            Sequential Care Milestones
          </h3>
          <div className="space-y-4">
            {current.steps.map((step, idx) => (
              <div
                key={idx}
                className="p-4 bg-slate-50 rounded-2xl border border-slate-200/80 space-y-3"
              >
                <div className="flex items-center justify-between">
                  <span className="px-2.5 py-0.5 rounded-full text-[10px] font-bold bg-sky-100 text-sky-800">
                    {step.time}
                  </span>
                  <span className="text-xs font-bold text-slate-900">{step.title}</span>
                </div>
                <p className="text-xs text-slate-600 leading-relaxed">{step.details}</p>
                <div className="pt-2 border-t border-slate-200/60">
                  <span className="text-[10px] font-bold text-slate-500 uppercase block mb-1.5">
                    Standard Order Set:
                  </span>
                  <div className="flex flex-wrap gap-1.5">
                    {step.orders.map((ord, oIdx) => (
                      <span
                        key={oIdx}
                        className="px-2 py-0.5 bg-white border border-slate-200 rounded text-[11px] font-medium text-slate-700"
                      >
                        ✓ {ord}
                      </span>
                    ))}
                  </div>
                </div>
              </div>
            ))}
          </div>
        </div>

        {/* Discharge Readiness Criteria */}
        <div className="pt-4 border-t border-slate-100 space-y-3">
          <h3 className="text-xs font-bold text-slate-900 uppercase tracking-wider">
            Mandatory Discharge Readiness Checklist
          </h3>
          <div className="space-y-2">
            {current.discharge.map((crit, cIdx) => (
              <div key={cIdx} className="flex items-center gap-2 text-xs text-slate-700">
                <CheckCircle2 className="h-4 w-4 text-emerald-600 shrink-0" />
                <span>{crit}</span>
              </div>
            ))}
          </div>
        </div>
      </div>
    </div>
  );
};
