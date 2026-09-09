import React, { useState } from 'react';
import {
  Calculator,
  Activity,
  HeartPulse,
  Brain,
  Stethoscope,
  AlertTriangle,
  CheckCircle2,
  HelpCircle,
} from 'lucide-react';

export const ClinicalCalculators: React.FC = () => {
  const [activeTab, setActiveTab] = useState<'mews' | 'gcs' | 'curb65' | 'egfr' | 'anion'>('mews');

  // MEWS State
  const [sbp, setSbp] = useState<number>(120);
  const [hr, setHr] = useState<number>(75);
  const [rr, setRr] = useState<number>(16);
  const [temp, setTemp] = useState<number>(37.0);
  const [avpu, setAvpu] = useState<'ALERT' | 'VOICE' | 'PAIN' | 'UNRESPONSIVE'>('ALERT');

  // GCS State
  const [eye, setEye] = useState<number>(4);
  const [verbal, setVerbal] = useState<number>(5);
  const [motor, setMotor] = useState<number>(6);

  // CURB-65 State
  const [curbConfusion, setCurbConfusion] = useState(false);
  const [curbUrea, setCurbUrea] = useState<number>(5.0);
  const [curbRr, setCurbRr] = useState<number>(18);
  const [curbSbp, setCurbSbp] = useState<number>(120);
  const [curbDbp, setCurbDbp] = useState<number>(80);
  const [curbAge, setCurbAge] = useState<number>(60);

  // eGFR State
  const [creat, setCreat] = useState<number>(1.0);
  const [egfrAge, setEgfrAge] = useState<number>(50);
  const [isFemale, setIsFemale] = useState(false);

  // Anion Gap State
  const [na, setNa] = useState<number>(140);
  const [cl, setCl] = useState<number>(102);
  const [hco3, setHco3] = useState<number>(24);

  // Calculations
  const calculateMews = () => {
    let score = 0;
    if (sbp <= 70) score += 3;
    else if (sbp <= 80) score += 2;
    else if (sbp <= 100) score += 1;
    else if (sbp >= 200) score += 2;

    if (hr < 40) score += 2;
    else if (hr <= 50) score += 1;
    else if (hr >= 130) score += 3;
    else if (hr >= 111) score += 2;
    else if (hr >= 101) score += 1;

    if (rr < 9) score += 2;
    else if (rr >= 30) score += 3;
    else if (rr >= 21) score += 2;
    else if (rr >= 15) score += 1;

    if (temp < 35.0) score += 2;
    else if (temp >= 38.5) score += 2;

    if (avpu === 'VOICE') score += 1;
    else if (avpu === 'PAIN') score += 2;
    else if (avpu === 'UNRESPONSIVE') score += 3;

    return score;
  };

  const mewsScore = calculateMews();
  const totalGcs = eye + verbal + motor;

  const curbScore =
    (curbConfusion ? 1 : 0) +
    (curbUrea > 7.0 ? 1 : 0) +
    (curbRr >= 30 ? 1 : 0) +
    (curbSbp < 90 || curbDbp <= 60 ? 1 : 0) +
    (curbAge >= 65 ? 1 : 0);

  const calculateEgfr = () => {
    const k = isFemale ? 0.7 : 0.9;
    const a = isFemale ? -0.241 : -0.302;
    const scrOverK = creat / k;
    const minPart = Math.pow(Math.min(scrOverK, 1.0), a);
    const maxPart = Math.pow(Math.max(scrOverK, 1.0), -1.2);
    const agePart = Math.pow(0.9938, egfrAge);
    const genderMult = isFemale ? 1.012 : 1.0;
    return (142.0 * minPart * maxPart * agePart * genderMult).toFixed(1);
  };

  const anionGap = na - (cl + hco3);

  return (
    <div className="space-y-6">
      {/* Header */}
      <div className="bg-white p-6 rounded-3xl border border-slate-200 shadow-sm">
        <h1 className="text-xl font-bold text-slate-900 tracking-tight flex items-center gap-2">
          <Calculator className="h-6 w-6 text-sky-600" />
          Clinical Decision Support & Bedside Calculators
        </h1>
        <p className="text-xs text-slate-500 mt-1">
          Validated physiological algorithms, early warning systems, and diagnostic risk scoring
        </p>
      </div>

      {/* Tabs */}
      <div className="flex border-b border-slate-200 gap-2 overflow-x-auto text-xs font-semibold">
        {[
          { key: 'mews', label: 'Modified Early Warning (MEWS)', icon: Activity },
          { key: 'gcs', label: 'Glasgow Coma Scale (GCS)', icon: Brain },
          { key: 'curb65', label: 'CURB-65 Pneumonia Risk', icon: Stethoscope },
          { key: 'egfr', label: 'CKD-EPI eGFR (Renal Function)', icon: HeartPulse },
          { key: 'anion', label: 'Serum Anion Gap (Acid-Base)', icon: Calculator },
        ].map((tab) => {
          const Icon = tab.icon;
          const isActive = activeTab === tab.key;
          return (
            <button
              key={tab.key}
              onClick={() => setActiveTab(tab.key as any)}
              className={`pb-3 px-4 flex items-center gap-2 border-b-2 transition-all whitespace-nowrap ${
                isActive
                  ? 'border-sky-600 text-sky-600 font-bold'
                  : 'border-transparent text-slate-500 hover:text-slate-800'
              }`}
            >
              <Icon className="h-4 w-4" />
              {tab.label}
            </button>
          );
        })}
      </div>

      {/* MEWS Calculator Panel */}
      {activeTab === 'mews' && (
        <div className="grid grid-cols-1 lg:grid-cols-3 gap-6">
          <div className="lg:col-span-2 bg-white p-6 rounded-3xl border border-slate-200 shadow-sm space-y-4 text-xs">
            <h3 className="text-sm font-bold text-slate-900">Bedside Vital Signs Input</h3>

            <div className="grid grid-cols-1 sm:grid-cols-2 gap-4">
              <div>
                <label className="font-semibold text-slate-700 block mb-1">
                  Systolic Blood Pressure (mmHg)
                </label>
                <input
                  type="number"
                  value={sbp}
                  onChange={(e) => setSbp(Number(e.target.value))}
                  className="w-full px-3 py-2 bg-slate-50 border border-slate-200 rounded-xl focus:bg-white focus:ring-2 focus:ring-sky-500 focus:outline-none"
                />
              </div>
              <div>
                <label className="font-semibold text-slate-700 block mb-1">Heart Rate (BPM)</label>
                <input
                  type="number"
                  value={hr}
                  onChange={(e) => setHr(Number(e.target.value))}
                  className="w-full px-3 py-2 bg-slate-50 border border-slate-200 rounded-xl focus:bg-white focus:ring-2 focus:ring-sky-500 focus:outline-none"
                />
              </div>
              <div>
                <label className="font-semibold text-slate-700 block mb-1">
                  Respiratory Rate (breaths/min)
                </label>
                <input
                  type="number"
                  value={rr}
                  onChange={(e) => setRr(Number(e.target.value))}
                  className="w-full px-3 py-2 bg-slate-50 border border-slate-200 rounded-xl focus:bg-white focus:ring-2 focus:ring-sky-500 focus:outline-none"
                />
              </div>
              <div>
                <label className="font-semibold text-slate-700 block mb-1">
                  Body Temperature (°C)
                </label>
                <input
                  type="number"
                  step="0.1"
                  value={temp}
                  onChange={(e) => setTemp(Number(e.target.value))}
                  className="w-full px-3 py-2 bg-slate-50 border border-slate-200 rounded-xl focus:bg-white focus:ring-2 focus:ring-sky-500 focus:outline-none"
                />
              </div>
            </div>

            <div>
              <label className="font-semibold text-slate-700 block mb-1">
                AVPU Neurological Consciousness Level
              </label>
              <select
                value={avpu}
                onChange={(e) => setAvpu(e.target.value as any)}
                className="w-full px-3 py-2 bg-slate-50 border border-slate-200 rounded-xl focus:bg-white focus:ring-2 focus:ring-sky-500 focus:outline-none"
              >
                <option value="ALERT">Alert (A)</option>
                <option value="VOICE">Responds to Voice (V)</option>
                <option value="PAIN">Responds to Pain (P)</option>
                <option value="UNRESPONSIVE">Unresponsive (U)</option>
              </select>
            </div>
          </div>

          <div
            className={`p-6 rounded-3xl border shadow-sm flex flex-col justify-between ${
              mewsScore >= 5
                ? 'bg-rose-50 border-rose-300'
                : mewsScore >= 4
                ? 'bg-amber-50 border-amber-300'
                : 'bg-emerald-50 border-emerald-300'
            }`}
          >
            <div>
              <span className="text-[10px] font-bold uppercase tracking-wider text-slate-500">
                Calculated MEWS Score
              </span>
              <h2 className="text-4xl font-black text-slate-900 mt-1">{mewsScore}</h2>
              <p className="text-xs font-bold mt-2 uppercase">
                {mewsScore >= 5
                  ? 'CRITICAL PHYSIOLOGICAL DETERIORATION'
                  : mewsScore >= 4
                  ? 'HIGH CLINICAL RISK'
                  : mewsScore >= 2
                  ? 'MEDIUM CLINICAL RISK'
                  : 'LOW STABLE RISK'}
              </p>
              <div className="mt-4 p-3 bg-white/80 rounded-2xl text-xs space-y-1">
                <p className="font-bold text-slate-800">Action Protocol:</p>
                <p className="text-slate-600 leading-relaxed">
                  {mewsScore >= 5
                    ? 'Trigger Medical Emergency Team (MET) / Rapid Response Team. Immediate bedside evaluation by ICU specialist.'
                    : mewsScore >= 4
                    ? 'Urgent clinical review by attending physician within 30 minutes. Monitor vitals hourly.'
                    : mewsScore >= 2
                    ? 'Inform charge nurse. Increase vital signs frequency to q2h-q4h.'
                    : 'Routine ward nursing observation per standard hospital protocol (q8h).'}
                </p>
              </div>
            </div>
          </div>
        </div>
      )}

      {/* GCS Calculator Panel */}
      {activeTab === 'gcs' && (
        <div className="grid grid-cols-1 lg:grid-cols-3 gap-6">
          <div className="lg:col-span-2 bg-white p-6 rounded-3xl border border-slate-200 shadow-sm space-y-4 text-xs">
            <h3 className="text-sm font-bold text-slate-900">Glasgow Coma Scale Parameters</h3>

            <div>
              <label className="font-semibold text-slate-700 block mb-1">
                Eye Opening Response (E: 1 - 4)
              </label>
              <select
                value={eye}
                onChange={(e) => setEye(Number(e.target.value))}
                className="w-full px-3 py-2 bg-slate-50 border border-slate-200 rounded-xl focus:bg-white focus:ring-2 focus:ring-sky-500 focus:outline-none"
              >
                <option value={4}>4 - Spontaneous Eye Opening</option>
                <option value={3}>3 - Eye Opening to Verbal Command / Speech</option>
                <option value={2}>2 - Eye Opening to Painful Stimulus</option>
                <option value={1}>1 - No Eye Opening</option>
              </select>
            </div>

            <div>
              <label className="font-semibold text-slate-700 block mb-1">
                Best Verbal Response (V: 1 - 5)
              </label>
              <select
                value={verbal}
                onChange={(e) => setVerbal(Number(e.target.value))}
                className="w-full px-3 py-2 bg-slate-50 border border-slate-200 rounded-xl focus:bg-white focus:ring-2 focus:ring-sky-500 focus:outline-none"
              >
                <option value={5}>5 - Oriented and Converses Normally</option>
                <option value={4}>4 - Disoriented and Confused</option>
                <option value={3}>3 - Inappropriate Words</option>
                <option value={2}>2 - Incomprehensible Sounds / Moaning</option>
                <option value={1}>1 - No Verbal Response</option>
              </select>
            </div>

            <div>
              <label className="font-semibold text-slate-700 block mb-1">
                Best Motor Response (M: 1 - 6)
              </label>
              <select
                value={motor}
                onChange={(e) => setMotor(Number(e.target.value))}
                className="w-full px-3 py-2 bg-slate-50 border border-slate-200 rounded-xl focus:bg-white focus:ring-2 focus:ring-sky-500 focus:outline-none"
              >
                <option value={6}>6 - Obeys Commands</option>
                <option value={5}>5 - Localizes to Pain</option>
                <option value={4}>4 - Flexion / Normal Withdrawal from Pain</option>
                <option value={3}>3 - Abnormal Flexion (Decorticate Posturing)</option>
                <option value={2}>2 - Extension (Decerebrate Posturing)</option>
                <option value={1}>1 - No Motor Response (Flaccid)</option>
              </select>
            </div>
          </div>

          <div
            className={`p-6 rounded-3xl border shadow-sm flex flex-col justify-between ${
              totalGcs <= 8
                ? 'bg-rose-50 border-rose-300'
                : totalGcs <= 12
                ? 'bg-amber-50 border-amber-300'
                : 'bg-emerald-50 border-emerald-300'
            }`}
          >
            <div>
              <span className="text-[10px] font-bold uppercase tracking-wider text-slate-500">
                Total GCS Score (E{eye}V{verbal}M{motor})
              </span>
              <h2 className="text-4xl font-black text-slate-900 mt-1">{totalGcs} / 15</h2>
              <p className="text-xs font-bold mt-2 uppercase">
                {totalGcs <= 8
                  ? 'Severe Brain Injury (Coma)'
                  : totalGcs <= 12
                  ? 'Moderate Brain Injury'
                  : 'Mild / Normal Neurological State'}
              </p>
              {totalGcs <= 8 && (
                <div className="mt-4 p-3 bg-rose-500 text-white rounded-2xl text-xs font-semibold flex items-center gap-2">
                  <AlertTriangle className="h-5 w-5 shrink-0" />
                  <span>GCS ≤ 8: Endotracheal Intubation & Airway Protection Indicated.</span>
                </div>
              )}
            </div>
          </div>
        </div>
      )}

      {/* CKD-EPI eGFR Calculator Panel */}
      {activeTab === 'egfr' && (
        <div className="grid grid-cols-1 lg:grid-cols-3 gap-6">
          <div className="lg:col-span-2 bg-white p-6 rounded-3xl border border-slate-200 shadow-sm space-y-4 text-xs">
            <h3 className="text-sm font-bold text-slate-900">
              CKD-EPI 2021 Refit Equation (Race-Free)
            </h3>

            <div className="grid grid-cols-1 sm:grid-cols-3 gap-4">
              <div>
                <label className="font-semibold text-slate-700 block mb-1">
                  Serum Creatinine (mg/dL)
                </label>
                <input
                  type="number"
                  step="0.01"
                  value={creat}
                  onChange={(e) => setCreat(Number(e.target.value))}
                  className="w-full px-3 py-2 bg-slate-50 border border-slate-200 rounded-xl focus:bg-white focus:ring-2 focus:ring-sky-500 focus:outline-none"
                />
              </div>
              <div>
                <label className="font-semibold text-slate-700 block mb-1">Patient Age (Years)</label>
                <input
                  type="number"
                  value={egfrAge}
                  onChange={(e) => setEgfrAge(Number(e.target.value))}
                  className="w-full px-3 py-2 bg-slate-50 border border-slate-200 rounded-xl focus:bg-white focus:ring-2 focus:ring-sky-500 focus:outline-none"
                />
              </div>
              <div>
                <label className="font-semibold text-slate-700 block mb-1">Biological Sex</label>
                <select
                  value={isFemale ? 'FEMALE' : 'MALE'}
                  onChange={(e) => setIsFemale(e.target.value === 'FEMALE')}
                  className="w-full px-3 py-2 bg-slate-50 border border-slate-200 rounded-xl focus:bg-white focus:ring-2 focus:ring-sky-500 focus:outline-none"
                >
                  <option value="MALE">Male</option>
                  <option value="FEMALE">Female</option>
                </select>
              </div>
            </div>
          </div>

          <div className="p-6 bg-sky-50 border border-sky-200 rounded-3xl shadow-sm flex flex-col justify-between">
            <div>
              <span className="text-[10px] font-bold uppercase tracking-wider text-sky-700">
                Estimated GFR (eGFR)
              </span>
              <h2 className="text-4xl font-black text-sky-900 mt-1">
                {calculateEgfr()}{' '}
                <span className="text-sm font-normal text-sky-700">mL/min/1.73m²</span>
              </h2>
              <p className="text-xs font-semibold text-sky-800 mt-2">
                {Number(calculateEgfr()) >= 90
                  ? 'Stage 1: Normal or high GFR'
                  : Number(calculateEgfr()) >= 60
                  ? 'Stage 2: Mildly decreased GFR'
                  : Number(calculateEgfr()) >= 45
                  ? 'Stage 3a: Mild-to-moderately decreased GFR'
                  : Number(calculateEgfr()) >= 30
                  ? 'Stage 3b: Moderately-to-severely decreased GFR'
                  : Number(calculateEgfr()) >= 15
                  ? 'Stage 4: Severely decreased GFR'
                  : 'Stage 5: Kidney Failure (ESRD)'}
              </p>
            </div>
          </div>
        </div>
      )}
    </div>
  );
};
