import React, { useState } from 'react';
import { SAMPLE_FHIR_PATIENT } from '../types/fhirPatient';

export const FhirPatientViewerConsole: React.FC = () => {
  const [patient, setPatient] = useState(SAMPLE_FHIR_PATIENT);

  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">FHIR R4 Patient Resource &amp; US Core Viewer</h1>
          <p className="text-sm text-slate-400">HL7 FHIR R4 Standardized Demographic Schema and JSON Payload Inspector</p>
        </div>
      </header>

      <div className="grid grid-cols-1 lg:grid-cols-2 gap-6">
        <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
          <h2 className="text-base font-bold text-white mb-4">Parsed Clinical Demographics</h2>
          <div className="space-y-3 text-xs">
            <div className="flex justify-between border-b border-slate-700/60 pb-2">
              <span className="text-slate-400">Resource ID / MRN:</span>
              <span className="font-mono text-sky-300 font-bold">{patient.id} ({patient.identifier[0].value})</span>
            </div>
            <div className="flex justify-between border-b border-slate-700/60 pb-2">
              <span className="text-slate-400">Full Name:</span>
              <span className="text-white font-bold">{patient.name[0].given.join(' ')} {patient.name[0].family}</span>
            </div>
            <div className="flex justify-between border-b border-slate-700/60 pb-2">
              <span className="text-slate-400">Date of Birth / Gender:</span>
              <span className="text-slate-200">{patient.birthDate} ({patient.gender.toUpperCase()})</span>
            </div>
            <div className="flex justify-between border-b border-slate-700/60 pb-2">
              <span className="text-slate-400">Primary Contact Phone:</span>
              <span className="font-mono text-emerald-300">{patient.telecom[0].value}</span>
            </div>
          </div>
        </div>

        <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
          <h2 className="text-base font-bold text-sky-300 mb-4">FHIR R4 JSON Representation</h2>
          <pre className="p-3 bg-slate-950 rounded border border-slate-800 text-xs font-mono text-sky-200 overflow-x-auto max-h-96">
            {JSON.stringify(patient, null, 2)}
          </pre>
        </div>
      </div>
    </div>
  );
};
