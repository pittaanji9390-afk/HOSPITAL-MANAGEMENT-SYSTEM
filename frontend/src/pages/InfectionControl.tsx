import React, { useState } from 'react';
import {
  ShieldAlert,
  Bug,
  Activity,
  CheckCircle2,
  AlertTriangle,
  FileCheck,
  Search,
} from 'lucide-react';

export const InfectionControl: React.FC = () => {
  const [activeTab, setActiveTab] = useState<'surveillance' | 'antibiogram' | 'restricted'>('surveillance');

  const haiCases = [
    {
      id: 'HAI-101',
      patientName: 'Anand Patil',
      patientMrn: 'MRN-10001',
      type: 'CAUTI',
      device: 'Foley Catheter',
      daysInSitu: 4,
      organism: 'Escherichia coli (ESBL-producing)',
      status: 'UNDER_TREATMENT',
      bundleScore: '100% Compliant',
    },
    {
      id: 'HAI-102',
      patientName: 'Kishore Kumar',
      patientMrn: 'MRN-10042',
      type: 'CLABSI',
      device: 'Right IJ Central Line',
      daysInSitu: 7,
      organism: 'Staphylococcus epidermidis (MRSE)',
      status: 'INVESTIGATING',
      bundleScore: '85% Compliant',
    },
  ];

  const restrictedAntibiotics = [
    {
      code: 'REST-COLIS',
      name: 'Colistin (Polymyxin E)',
      class: 'Polymyxin',
      indication: 'Carbapenem-resistant Gram-negative bacteremia/pneumonia',
      status: 'Pre-Authorization Required',
    },
    {
      code: 'REST-MERO',
      name: 'Meropenem / Imipenem',
      class: 'Carbapenem',
      indication: 'Documented ESBL sepsis or high-risk septic shock',
      status: '72-Hour Timeout Rule',
    },
    {
      code: 'REST-DAPTO',
      name: 'Daptomycin',
      class: 'Lipopeptide',
      indication: 'VRE bacteremia / MRSA endocarditis',
      status: 'Infectious Disease Approval Needed',
    },
  ];

  return (
    <div className="space-y-6">
      {/* Header */}
      <div className="flex flex-col sm:flex-row sm:items-center justify-between gap-4 bg-white p-6 rounded-3xl border border-slate-200 shadow-sm">
        <div>
          <h1 className="text-xl font-bold text-slate-900 tracking-tight flex items-center gap-2">
            <ShieldAlert className="h-6 w-6 text-rose-600" />
            Hospital Infection Prevention & Antimicrobial Stewardship (AMS)
          </h1>
          <p className="text-xs text-slate-500 mt-1">
            HAI Surveillance (CAUTI, CLABSI, SSI, VAP), restricted antibiotic timeouts, and cumulative antibiogram
          </p>
        </div>

        <div className="flex items-center gap-2 px-3 py-1.5 bg-emerald-50 text-emerald-800 border border-emerald-200 rounded-xl text-xs font-bold">
          <CheckCircle2 className="h-4 w-4 text-emerald-600" />
          <span>NABH / JCI Infection Control Standards Active</span>
        </div>
      </div>

      {/* Navigation Switcher */}
      <div className="flex border-b border-slate-200 gap-2 text-xs font-bold">
        {[
          { key: 'surveillance', label: 'Active HAI Surveillance Cases' },
          { key: 'restricted', label: 'Restricted Antimicrobial Formulary' },
        ].map((tab) => (
          <button
            key={tab.key}
            onClick={() => setActiveTab(tab.key as any)}
            className={`pb-3 px-4 transition-all border-b-2 ${
              activeTab === tab.key
                ? 'border-rose-600 text-rose-600 font-black'
                : 'border-transparent text-slate-500 hover:text-slate-800'
            }`}
          >
            {tab.label}
          </button>
        ))}
      </div>

      {/* Surveillance Table */}
      {activeTab === 'surveillance' && (
        <div className="bg-white rounded-3xl border border-slate-200 shadow-sm overflow-hidden">
          <div className="overflow-x-auto">
            <table className="w-full text-left text-xs">
              <thead className="bg-slate-50 text-slate-500 uppercase tracking-wider font-semibold border-b border-slate-200">
                <tr>
                  <th className="py-3.5 px-4">Case ID / Patient</th>
                  <th className="py-3.5 px-4">Infection Classification</th>
                  <th className="py-3.5 px-4">Device & Days in Situ</th>
                  <th className="py-3.5 px-4">Cultured Pathogen</th>
                  <th className="py-3.5 px-4">Care Bundle Audit</th>
                  <th className="py-3.5 px-4 text-right">Status</th>
                </tr>
              </thead>
              <tbody className="divide-y divide-slate-100">
                {haiCases.map((c) => (
                  <tr key={c.id} className="hover:bg-slate-50/80 transition-colors">
                    <td className="py-3.5 px-4">
                      <span className="font-mono font-bold text-rose-700">{c.id}</span>
                      <p className="font-semibold text-slate-900 mt-0.5">{c.patientName}</p>
                      <span className="text-[10px] text-slate-400 font-mono">{c.patientMrn}</span>
                    </td>
                    <td className="py-3.5 px-4">
                      <span className="px-2.5 py-0.5 rounded-full text-[10px] font-bold bg-rose-100 text-rose-800">
                        {c.type}
                      </span>
                    </td>
                    <td className="py-3.5 px-4 text-slate-700">
                      <p className="font-semibold">{c.device}</p>
                      <span className="text-[10px] text-slate-500">{c.daysInSitu} calendar days</span>
                    </td>
                    <td className="py-3.5 px-4 font-mono font-semibold text-slate-800">{c.organism}</td>
                    <td className="py-3.5 px-4 text-emerald-700 font-bold">{c.bundleScore}</td>
                    <td className="py-3.5 px-4 text-right">
                      <span className="px-2 py-0.5 rounded text-[10px] font-bold bg-slate-100 text-slate-700">
                        {c.status}
                      </span>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      )}

      {/* Restricted Antimicrobials */}
      {activeTab === 'restricted' && (
        <div className="bg-white rounded-3xl border border-slate-200 shadow-sm overflow-hidden">
          <div className="overflow-x-auto">
            <table className="w-full text-left text-xs">
              <thead className="bg-slate-50 text-slate-500 uppercase tracking-wider font-semibold border-b border-slate-200">
                <tr>
                  <th className="py-3.5 px-4">Antibiotic Code</th>
                  <th className="py-3.5 px-4">Antimicrobial Name</th>
                  <th className="py-3.5 px-4">Drug Class</th>
                  <th className="py-3.5 px-4">Approved Clinical Indications</th>
                  <th className="py-3.5 px-4 text-right">Stewardship Rule</th>
                </tr>
              </thead>
              <tbody className="divide-y divide-slate-100">
                {restrictedAntibiotics.map((a) => (
                  <tr key={a.code} className="hover:bg-slate-50/80 transition-colors">
                    <td className="py-3.5 px-4 font-mono font-bold text-sky-700">{a.code}</td>
                    <td className="py-3.5 px-4 font-bold text-slate-900">{a.name}</td>
                    <td className="py-3.5 px-4 text-slate-600">{a.class}</td>
                    <td className="py-3.5 px-4 text-slate-700 max-w-sm">{a.indication}</td>
                    <td className="py-3.5 px-4 text-right font-bold text-rose-700">{a.status}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      )}
    </div>
  );
};
