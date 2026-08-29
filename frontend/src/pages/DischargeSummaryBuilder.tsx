import React, { useState } from 'react';
import {
  FileText,
  Printer,
  Copy,
  CheckCircle2,
  AlertTriangle,
  Send,
  Calendar,
  User,
} from 'lucide-react';

export const DischargeSummaryBuilder: React.FC = () => {
  const [patientName, setPatientName] = useState('Anand Patil');
  const [mrn, setMrn] = useState('MRN-10001');
  const [admissionNo, setAdmissionNo] = useState('IPD-10001');
  const [primaryDiag, setPrimaryDiag] = useState('Acute ST-Elevation Anterior Wall Myocardial Infarction (ICD-10: I21.0)');
  const [hospitalCourse, setHospitalCourse] = useState('Patient presented with acute crushing chest pain. Emergency coronary angiography performed via right radial approach revealed 95% proximal LAD stenosis. Successful Primary PCI with 1x Drug-Eluting Stent (DES). Post-procedure CCU course was uneventful without arrhythmia or heart failure.');
  const [dischargeMeds, setDischargeMeds] = useState('1. Aspirin 81 mg PO Daily\n2. Ticagrelor 90 mg PO BID\n3. Atorvastatin 80 mg PO Nightly\n4. Metoprolol Succinate 25 mg PO Daily\n5. Ramipril 2.5 mg PO Daily');
  const [followUp, setFollowUp] = useState('Cardiology OPD with Dr. Rajesh Sharma on 05-Sep-2026 at 10:00 AM');

  const [copied, setCopied] = useState(false);

  const fullDocument = `================================================================================
                    APEX MULTI-SPECIALTY HOSPITAL & HEART INSTITUTE
                  CLINICAL DISCHARGE SUMMARY & CARE CONTINUITY
================================================================================

PATIENT DEMOGRAPHICS & ENCOUNTER DETAILS
--------------------------------------------------------------------------------
Patient Name    : ${patientName} (MALE, 44 yrs)
MRN             : ${mrn} | Admission No: ${admissionNo}
Admission Date  : 26-Aug-2026 | Discharge Date: 29-Aug-2026
Attending Doctor: Dr. Rajesh Sharma, MD, DM (Cardiology)
Ward / Bed      : CCU-301 / Bed 1

FINAL CLINICAL DIAGNOSIS
--------------------------------------------------------------------------------
Primary Diagnosis   : ${primaryDiag}
Secondary Diagnoses : Essential Hypertension (I10); Dyslipidemia (E78.5)

HOSPITAL COURSE & INTERVENTIONS
--------------------------------------------------------------------------------
${hospitalCourse}

DISCHARGE MEDICATIONS & RECONCILIATION
--------------------------------------------------------------------------------
${dischargeMeds}

DISCHARGE INSTRUCTIONS & ADVICE
--------------------------------------------------------------------------------
  ✓ Low sodium cardiac diet (< 2g sodium/day).
  ✓ Dual antiplatelet therapy (DAPT) compliance is critical. DO NOT STOP without consulting cardiologist.
  ✓ Graduated walking exercises; avoid heavy lifting > 5 kg for 2 weeks.

FOLLOW-UP SCHEDULE
--------------------------------------------------------------------------------
  ${followUp}

EMERGENCY RED FLAGS (REPORT TO EMERGENCY DEPARTMENT IMMEDIATELY):
--------------------------------------------------------------------------------
  ⚠ Recurrent chest pain, pressure, or heaviness radiating to arm/jaw.
  ⚠ Sudden onset of breathlessness, lightheadedness, or fainting.
  ⚠ Unusual bleeding or severe bruising.

================================================================================
Attending Cardiologist Signature: Dr. Rajesh Sharma, MD, DM
Date: 29-Aug-2026`;

  const handleCopy = () => {
    navigator.clipboard.writeText(fullDocument);
    setCopied(true);
    setTimeout(() => setCopied(false), 2000);
  };

  return (
    <div className="space-y-6">
      {/* Header */}
      <div className="flex flex-col sm:flex-row sm:items-center justify-between gap-4 bg-white p-6 rounded-3xl border border-slate-200 shadow-sm">
        <div>
          <h1 className="text-xl font-bold text-slate-900 tracking-tight flex items-center gap-2">
            <FileText className="h-6 w-6 text-sky-600" />
            Clinical Discharge Summary & Continuity of Care Builder
          </h1>
          <p className="text-xs text-slate-500 mt-1">
            Standardized discharge summary authoring, medication reconciliation, and patient handover instructions
          </p>
        </div>

        <button
          onClick={handleCopy}
          className="px-4 py-2 bg-slate-900 hover:bg-slate-800 text-white rounded-xl text-xs font-semibold flex items-center gap-2 transition-colors self-start sm:self-auto"
        >
          {copied ? <CheckCircle2 className="h-4 w-4 text-emerald-400" /> : <Copy className="h-4 w-4" />}
          {copied ? 'Copied to Clipboard' : 'Copy Summary'}
        </button>
      </div>

      {/* Editor & Preview Split */}
      <div className="grid grid-cols-1 lg:grid-cols-2 gap-6">
        {/* Editor Form */}
        <div className="bg-white p-6 rounded-3xl border border-slate-200 shadow-sm space-y-4 text-xs">
          <h3 className="text-sm font-bold text-slate-900">Clinical Narrative Inputs</h3>

          <div className="grid grid-cols-2 gap-3">
            <div>
              <label className="font-semibold text-slate-700 block mb-1">Patient Name</label>
              <input
                type="text"
                value={patientName}
                onChange={(e) => setPatientName(e.target.value)}
                className="w-full px-3 py-2 bg-slate-50 border border-slate-200 rounded-xl focus:bg-white focus:outline-none focus:ring-2 focus:ring-sky-500"
              />
            </div>
            <div>
              <label className="font-semibold text-slate-700 block mb-1">MRN / Admission No</label>
              <input
                type="text"
                value={`${mrn} / ${admissionNo}`}
                disabled
                className="w-full px-3 py-2 bg-slate-100 border border-slate-200 rounded-xl text-slate-500 font-mono"
              />
            </div>
          </div>

          <div>
            <label className="font-semibold text-slate-700 block mb-1">Final Primary Diagnosis</label>
            <input
              type="text"
              value={primaryDiag}
              onChange={(e) => setPrimaryDiag(e.target.value)}
              className="w-full px-3 py-2 bg-slate-50 border border-slate-200 rounded-xl focus:bg-white focus:outline-none focus:ring-2 focus:ring-sky-500"
            />
          </div>

          <div>
            <label className="font-semibold text-slate-700 block mb-1">Hospital Course & Interventions</label>
            <textarea
              rows={4}
              value={hospitalCourse}
              onChange={(e) => setHospitalCourse(e.target.value)}
              className="w-full px-3 py-2 bg-slate-50 border border-slate-200 rounded-xl focus:bg-white focus:outline-none focus:ring-2 focus:ring-sky-500 leading-relaxed"
            />
          </div>

          <div>
            <label className="font-semibold text-slate-700 block mb-1">Discharge Medications</label>
            <textarea
              rows={4}
              value={dischargeMeds}
              onChange={(e) => setDischargeMeds(e.target.value)}
              className="w-full px-3 py-2 bg-slate-50 border border-slate-200 rounded-xl font-mono text-xs focus:bg-white focus:outline-none focus:ring-2 focus:ring-sky-500 leading-relaxed"
            />
          </div>
        </div>

        {/* Live Document Preview */}
        <div className="bg-slate-950 p-6 rounded-3xl border border-slate-800 shadow-2xl text-xs font-mono text-slate-200 overflow-hidden flex flex-col justify-between">
          <div className="overflow-y-auto max-h-[600px] whitespace-pre-wrap leading-relaxed">
            {fullDocument}
          </div>
        </div>
      </div>
    </div>
  );
};
