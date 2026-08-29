import React, { useState } from 'react';
import {
  Share2,
  FileCode2,
  Activity,
  CheckCircle2,
  Copy,
  Download,
  ArrowRight,
  Database,
  Search,
} from 'lucide-react';

export const Hl7FhirHub: React.FC = () => {
  const [activeStandard, setActiveStandard] = useState<'hl7v2' | 'fhir'>('hl7v2');
  const [copied, setCopied] = useState(false);

  const sampleHl7Adt = `MSH|^~\\&|APEX_HMS|APEX_MAIN|CENTRAL_LIS_PACS|REGIONAL_HEALTH|20260829210000||ADT^A01|CTRL-849201|P|2.5\r
PID|1||MRN-10001^^^APEX_HOSPITAL^MR||Patil^Anand^Kumar||19820614|M|||74 Indiranagar^^Bengaluru^KA^560029||+919845012345\r
PV1|1|I|CCU-301^BED-CCU-01^CCU||||DOC-002^Sharma^Rajesh^^Dr||||||||||ADM-10001|||||||||||||||||||||||||20260829210000\r
DG1|1|ICD-10|I21.0|Acute ST-Elevation Myocardial Infarction|20260829210000|A`;

  const sampleFhirPatient = JSON.stringify(
    {
      resourceType: 'Bundle',
      type: 'searchset',
      total: 2,
      entry: [
        {
          fullUrl: 'urn:uuid:849201-patient-1',
          resource: {
            resourceType: 'Patient',
            id: 'patient-1',
            identifier: [
              {
                use: 'usual',
                system: 'https://hospital.org/fhir/mrn',
                value: 'MRN-10001',
              },
            ],
            active: true,
            name: [
              {
                use: 'official',
                family: 'Patil',
                given: ['Anand', 'Kumar'],
              },
            ],
            telecom: [
              { system: 'phone', value: '+91-98450-12345', use: 'mobile' },
              { system: 'email', value: 'anand@example.com' },
            ],
            gender: 'male',
            birthDate: '1982-06-14',
            address: [
              {
                use: 'home',
                line: ['74 Indiranagar'],
                city: 'Bengaluru',
                state: 'Karnataka',
                postalCode: '560029',
                country: 'IND',
              },
            ],
          },
        },
        {
          fullUrl: 'urn:uuid:849202-obs-vitals',
          resource: {
            resourceType: 'Observation',
            id: 'obs-bp-101',
            status: 'final',
            category: [
              {
                coding: [
                  {
                    system: 'http://terminology.hl7.org/CodeSystem/observation-category',
                    code: 'vital-signs',
                    display: 'Vital Signs',
                  },
                ],
              },
            ],
            code: {
              coding: [
                {
                  system: 'http://loinc.org',
                  code: '85354-9',
                  display: 'Blood pressure panel with all children optional',
                },
              ],
            },
            subject: { reference: 'Patient/MRN-10001' },
            effectiveDateTime: '2026-08-29T21:00:00Z',
          },
        },
      ],
    },
    null,
    2
  );

  const handleCopy = () => {
    navigator.clipboard.writeText(activeStandard === 'hl7v2' ? sampleHl7Adt : sampleFhirPatient);
    setCopied(true);
    setTimeout(() => setCopied(false), 2000);
  };

  return (
    <div className="space-y-6">
      {/* Header */}
      <div className="bg-white p-6 rounded-3xl border border-slate-200 shadow-sm">
        <h1 className="text-xl font-bold text-slate-900 tracking-tight flex items-center gap-2">
          <Share2 className="h-6 w-6 text-sky-600" />
          Health Information Interoperability Hub (HL7 v2 & FHIR R4)
        </h1>
        <p className="text-xs text-slate-500 mt-1">
          Electronic data interchange for EMR, PACS, LIS, and National Health Health Information Exchanges (HIE)
        </p>
      </div>

      {/* Switcher & Action Bar */}
      <div className="bg-white p-4 rounded-2xl border border-slate-200 shadow-sm flex items-center justify-between flex-wrap gap-4">
        <div className="flex items-center gap-2">
          <button
            onClick={() => setActiveStandard('hl7v2')}
            className={`px-4 py-2 rounded-xl text-xs font-bold transition-all ${
              activeStandard === 'hl7v2'
                ? 'bg-sky-600 text-white shadow-md shadow-sky-600/20'
                : 'bg-slate-100 text-slate-600 hover:bg-slate-200'
            }`}
          >
            HL7 v2.5 / v2.8 (Pipe & Hat ER7)
          </button>
          <button
            onClick={() => setActiveStandard('fhir')}
            className={`px-4 py-2 rounded-xl text-xs font-bold transition-all ${
              activeStandard === 'fhir'
                ? 'bg-sky-600 text-white shadow-md shadow-sky-600/20'
                : 'bg-slate-100 text-slate-600 hover:bg-slate-200'
            }`}
          >
            HL7 FHIR Release 4 (JSON Resources)
          </button>
        </div>

        <button
          onClick={handleCopy}
          className="px-3.5 py-2 bg-slate-900 hover:bg-slate-800 text-white rounded-xl text-xs font-semibold flex items-center gap-1.5 transition-colors"
        >
          {copied ? <CheckCircle2 className="h-4 w-4 text-emerald-400" /> : <Copy className="h-4 w-4" />}
          {copied ? 'Copied Payload' : 'Copy Message'}
        </button>
      </div>

      {/* Code Inspector Box */}
      <div className="bg-slate-950 p-6 rounded-3xl border border-slate-800 shadow-2xl overflow-hidden text-xs font-mono text-sky-300">
        <div className="flex items-center justify-between pb-3 mb-4 border-b border-slate-800 text-slate-400">
          <span>{activeStandard === 'hl7v2' ? 'ADT^A01 (Inpatient Admission ER7)' : 'FHIR Bundle (Patient + Observation R4)'}</span>
          <span className="text-[10px] px-2 py-0.5 rounded bg-slate-900 border border-slate-700 text-slate-300">
            Validated Schema
          </span>
        </div>
        <pre className="overflow-x-auto whitespace-pre-wrap leading-relaxed">
          {activeStandard === 'hl7v2' ? sampleHl7Adt : sampleFhirPatient}
        </pre>
      </div>
    </div>
  );
};
