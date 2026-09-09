import React, { useState } from 'react';
import { GitBranch, CheckCircle2, Clock, AlertTriangle, ArrowRight, UserCheck, ShieldAlert, Sparkles, Activity } from 'lucide-react';

export const ClinicalPathwayVisualizer: React.FC = () => {
  const [selectedPathway, setSelectedPathway] = useState('STEMI');
  const [currentStepIndex, setCurrentStepIndex] = useState(2);

  const pathways = [
    { id: 'STEMI', name: 'Hyperacute STEMI Door-to-Balloon Pathway', timeTarget: '< 90 min', activePatients: 2, severity: 'EMERGENCY' },
    { id: 'STROKE', name: 'Acute Ischemic Stroke TNK / Thrombectomy Pathway', timeTarget: '< 60 min Door-to-Needle', activePatients: 1, severity: 'EMERGENCY' },
    { id: 'SEPSIS', name: 'Surviving Sepsis Campaign Hour-1 Bundle', timeTarget: '< 60 min', activePatients: 4, severity: 'CRITICAL' },
    { id: 'TRAUMA', name: 'Level 1 Trauma Code Red Resuscitation', timeTarget: '< 30 min', activePatients: 1, severity: 'CRITICAL' },
  ];

  const stemiSteps = [
    { step: 'Step 1: First Medical Contact (FMC) & 12-Lead ECG', targetTime: '0 - 10 min', status: 'COMPLETED', action: 'Obtain 12-lead ECG; detect >= 1mm ST-elevation in contiguous leads; activate Cardiac Catheterization Lab immediately.' },
    { step: 'Step 2: Emergency Department Antiplatelet Loading & Anticoagulation', targetTime: '10 - 20 min', status: 'COMPLETED', action: 'Administer Chewable Aspirin 300mg + Ticagrelor 180mg PO + IV Unfractionated Heparin 70-100 U/kg bolus.' },
    { step: 'Step 3: Direct Transfer to Cardiac Cath Lab Table', targetTime: '20 - 45 min', status: 'IN_PROGRESS', action: 'Bypass CCU/Wards directly to Cath Lab; prepare right radial artery access; ultrasound guidance.' },
    { step: 'Step 4: Culprit Lesion Crossing & Balloon Angioplasty / DES Placement', targetTime: '45 - 90 min', status: 'PENDING', action: 'Primary PCI with Drug-Eluting Stent (DES); achieve TIMI 3 flow; intracoronary vasodilators as needed.' },
    { step: 'Step 5: Post-PCI Coronary Care Unit (CCU) Continuous Telemetry & GDMT', targetTime: 'Post-Op 24-48h', status: 'PENDING', action: 'Four-pillar GDMT initiation (High-dose Statin, Beta-blocker, ACEi/ARB, DAPT maintenance) + serial hs-cTnI.' }
  ];

  return (
    <div className="space-y-6">
      <div className="bg-slate-900 text-white p-6 rounded-2xl border border-slate-800 shadow-xl flex justify-between items-center">
        <div>
          <div className="flex items-center gap-3">
            <GitBranch className="w-8 h-8 text-indigo-400" />
            <h1 className="text-2xl font-bold tracking-tight">Clinical Pathway Orchestration & Protocol Visualizer</h1>
          </div>
          <p className="text-slate-400 text-sm mt-1">Real-time Closed-Loop Clinical Process Verification & Quality Benchmark Engine</p>
        </div>
        <div className="flex gap-3">
          <div className="bg-slate-800 px-4 py-2 rounded-xl border border-slate-700 text-center">
            <span className="text-xs text-slate-400 block">Total Active Pathways</span>
            <span className="text-lg font-bold text-indigo-400">8 Enrolled</span>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-4 gap-4">
        {pathways.map(pw => (
          <div
            key={pw.id}
            onClick={() => setSelectedPathway(pw.id)}
            className={`p-4 rounded-2xl border cursor-pointer transition-all ${
              selectedPathway === pw.id
                ? 'bg-indigo-950/40 border-indigo-500 shadow-md ring-2 ring-indigo-500/20'
                : 'bg-white border-slate-200 hover:border-slate-300 shadow-sm'
            }`}
          >
            <div className="flex justify-between items-center mb-1">
              <span className="text-xs font-bold text-slate-400">{pw.id}</span>
              <span className="text-xs font-bold px-2 py-0.5 rounded bg-rose-100 text-rose-700">{pw.severity}</span>
            </div>
            <h3 className="font-bold text-sm text-slate-900 mt-1">{pw.name}</h3>
            <div className="mt-3 flex justify-between text-xs text-slate-500">
              <span>Target: <strong>{pw.timeTarget}</strong></span>
              <span>Active: <strong className="text-indigo-600">{pw.activePatients}</strong></span>
            </div>
          </div>
        ))}
      </div>

      <div className="bg-white rounded-2xl border border-slate-200 p-6 shadow-sm space-y-6">
        <div className="flex justify-between items-center border-b border-slate-100 pb-4">
          <div>
            <h2 className="text-lg font-bold text-slate-900 flex items-center gap-2">
              <Activity className="w-5 h-5 text-indigo-600" />
              Active Protocol Execution Flow: {selectedPathway}
            </h2>
            <p className="text-xs text-slate-500 mt-0.5">Assigned Patient: Rajesh Verma (56M) | MRN-9482 | Door Time: 14:02</p>
          </div>
          <span className="text-xs font-semibold px-3 py-1 bg-emerald-100 text-emerald-800 rounded-full flex items-center gap-1">
            <Clock className="w-3.5 h-3.5" />
            Elapsed: 28 min (On Schedule)
          </span>
        </div>

        <div className="space-y-4">
          {stemiSteps.map((s, idx) => (
            <div
              key={idx}
              className={`p-4 rounded-xl border transition-all flex items-start gap-4 ${
                s.status === 'COMPLETED'
                  ? 'bg-emerald-50/60 border-emerald-200'
                  : s.status === 'IN_PROGRESS'
                  ? 'bg-indigo-50 border-indigo-300 shadow-sm'
                  : 'bg-slate-50 border-slate-200 opacity-60'
              }`}
            >
              <div className="mt-0.5">
                {s.status === 'COMPLETED' && <CheckCircle2 className="w-5 h-5 text-emerald-600" />}
                {s.status === 'IN_PROGRESS' && <Clock className="w-5 h-5 text-indigo-600 animate-spin" />}
                {s.status === 'PENDING' && <div className="w-5 h-5 rounded-full border-2 border-slate-300" />}
              </div>
              <div className="flex-1">
                <div className="flex justify-between items-center">
                  <h4 className="font-bold text-sm text-slate-900">{s.step}</h4>
                  <span className="text-xs font-medium text-slate-500">{s.targetTime}</span>
                </div>
                <p className="text-xs text-slate-600 mt-1 leading-relaxed">{s.action}</p>
              </div>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};
