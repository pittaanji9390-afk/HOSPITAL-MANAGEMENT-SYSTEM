import React, { useState } from 'react';
import {
  BookOpen,
  Search,
  CheckCircle2,
  Tag,
  Layers,
  FileText,
  Filter,
} from 'lucide-react';

interface TermEntry {
  code: string;
  name: string;
  system: 'ICD-10-CM' | 'SNOMED-CT' | 'LOINC' | 'CPT';
  category: string;
  details: string;
}

export const MedicalTerminology: React.FC = () => {
  const [query, setQuery] = useState('');
  const [selectedSystem, setSelectedSystem] = useState<string>('ALL');

  const terms: TermEntry[] = [
    { code: 'I10', name: 'Essential (primary) hypertension', system: 'ICD-10-CM', category: 'Circulatory System', details: 'High systemic arterial blood pressure' },
    { code: 'I21.0', name: 'ST elevation (STEMI) myocardial infarction of anterior wall', system: 'ICD-10-CM', category: 'Ischemic Heart Disease', details: 'Acute coronary transmural infarction' },
    { code: 'E11.9', name: 'Type 2 diabetes mellitus without complications', system: 'ICD-10-CM', category: 'Endocrine', details: 'Adult-onset non-insulin dependent diabetes' },
    { code: '38341003', name: 'Hypertensive disorder, systemic arterial (disorder)', system: 'SNOMED-CT', category: 'Disorder', details: 'SNOMED CT Concept ID for essential hypertension' },
    { code: '22298006', name: 'Myocardial infarction (disorder)', system: 'SNOMED-CT', category: 'Disorder', details: 'Acute ischemic necrosis of myocardium' },
    { code: '232717009', name: 'Coronary artery bypass graft (procedure)', system: 'SNOMED-CT', category: 'Procedure', details: 'Surgical myocardial revascularization' },
    { code: '2345-7', name: 'Glucose [Mass/volume] in Serum or Plasma', system: 'LOINC', category: 'Biochemistry', details: 'Ref: 70.0 - 99.0 mg/dL' },
    { code: '718-7', name: 'Hemoglobin [Mass/volume] in Blood', system: 'LOINC', category: 'Hematology', details: 'Ref: 13.5 - 17.5 g/dL' },
    { code: '42757-5', name: 'Troponin I.cardiac [Mass/volume] in Serum (hs-cTnI)', system: 'LOINC', category: 'Cardiac Marker', details: 'Ref: 0.0 - 0.04 ng/mL' },
    { code: '99204', name: 'Office/outpatient visit for new patient, 45-59 min', system: 'CPT', category: 'Evaluation & Management', details: 'RVU: 2.60 • Fee: ₹1,800' },
    { code: '33512', name: 'Coronary artery bypass, 3 venous grafts', system: 'CPT', category: 'Cardiothoracic Surgery', details: 'RVU: 27.20 • Fee: ₹240,000' },
    { code: '27447', name: 'Total Knee Arthroplasty (TKA)', system: 'CPT', category: 'Orthopedic Surgery', details: 'RVU: 20.72 • Fee: ₹160,000' },
  ];

  const filtered = terms.filter((t) => {
    const matchSys = selectedSystem === 'ALL' || t.system === selectedSystem;
    const matchQ =
      t.code.toLowerCase().includes(query.toLowerCase()) ||
      t.name.toLowerCase().includes(query.toLowerCase()) ||
      t.category.toLowerCase().includes(query.toLowerCase());
    return matchSys && matchQ;
  });

  return (
    <div className="space-y-6">
      {/* Header */}
      <div className="bg-white p-6 rounded-3xl border border-slate-200 shadow-sm">
        <h1 className="text-xl font-bold text-slate-900 tracking-tight flex items-center gap-2">
          <BookOpen className="h-6 w-6 text-sky-600" />
          International Medical Terminology & Coding Directory
        </h1>
        <p className="text-xs text-slate-500 mt-1">
          Universal clinical ontology search: ICD-10-CM, SNOMED-CT, LOINC, and CPT standards
        </p>
      </div>

      {/* Search & System Filter Bar */}
      <div className="bg-white p-4 rounded-2xl border border-slate-200 shadow-sm flex flex-col sm:flex-row gap-4 justify-between">
        <div className="relative flex-1">
          <Search className="absolute left-3.5 top-1/2 -translate-y-1/2 h-4 w-4 text-slate-400" />
          <input
            type="text"
            placeholder="Search clinical concept, diagnosis name, test, or code..."
            value={query}
            onChange={(e) => setQuery(e.target.value)}
            className="w-full pl-10 pr-4 py-2 bg-slate-50 border border-slate-200 rounded-xl text-xs focus:bg-white focus:outline-none focus:ring-2 focus:ring-sky-500"
          />
        </div>
        <div className="flex items-center gap-1.5 overflow-x-auto">
          {['ALL', 'ICD-10-CM', 'SNOMED-CT', 'LOINC', 'CPT'].map((sys) => (
            <button
              key={sys}
              onClick={() => setSelectedSystem(sys)}
              className={`px-3 py-2 rounded-xl text-xs font-semibold whitespace-nowrap transition-all ${
                selectedSystem === sys
                  ? 'bg-slate-900 text-white'
                  : 'bg-slate-100 text-slate-600 hover:bg-slate-200'
              }`}
            >
              {sys}
            </button>
          ))}
        </div>
      </div>

      {/* Results Table */}
      <div className="bg-white rounded-3xl border border-slate-200 shadow-sm overflow-hidden">
        <div className="overflow-x-auto">
          <table className="w-full text-left text-xs">
            <thead className="bg-slate-50 text-slate-500 uppercase tracking-wider font-semibold border-b border-slate-200">
              <tr>
                <th className="py-3.5 px-4">Standard Code</th>
                <th className="py-3.5 px-4">Coding System</th>
                <th className="py-3.5 px-4">Preferred Clinical Term</th>
                <th className="py-3.5 px-4">Category / Domain</th>
                <th className="py-3.5 px-4">Clinical Details</th>
              </tr>
            </thead>
            <tbody className="divide-y divide-slate-100">
              {filtered.map((item, idx) => (
                <tr key={idx} className="hover:bg-slate-50/80 transition-colors">
                  <td className="py-3.5 px-4 font-mono font-bold text-sky-700">{item.code}</td>
                  <td className="py-3.5 px-4">
                    <span className="px-2.5 py-0.5 rounded-full text-[10px] font-bold bg-slate-100 text-slate-800 border border-slate-200">
                      {item.system}
                    </span>
                  </td>
                  <td className="py-3.5 px-4 font-semibold text-slate-900">{item.name}</td>
                  <td className="py-3.5 px-4 text-slate-600">{item.category}</td>
                  <td className="py-3.5 px-4 text-slate-500 text-[11px]">{item.details}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
};
