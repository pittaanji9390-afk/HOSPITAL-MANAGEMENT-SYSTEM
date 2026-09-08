import React, { useState } from 'react';
import { Dna, ShieldAlert, CheckCircle, Search, Pill, FileText, AlertTriangle } from 'lucide-react';

export const PharmacogenomicsStation: React.FC = () => {
  const [search, setSearch] = useState('');

  const rules = [
    { gene: 'CYP2C19', phenotype: 'Poor Metabolizer (*2/*2, *2/*3)', drug: 'Clopidogrel (Plavix)', risk: 'CONTRAINDICATED', rec: 'Ineffective bioactivation. Switch to Prasugrel 10mg or Ticagrelor 90mg bid to prevent stent thrombosis.' },
    { gene: 'CYP2D6', phenotype: 'Ultrarapid Metabolizer (>= 3 copies)', drug: 'Codeine / Tramadol', risk: 'FATAL TOXICITY RISK', rec: 'Rapid conversion to active morphine causing fatal respiratory arrest. AVOID codeine/tramadol.' },
    { gene: 'TPMT / NUDT15', phenotype: 'Poor Metabolizer (Deficient)', drug: 'Azathioprine / 6-MP', risk: 'SEVERE MYELOSUPPRESSION', rec: 'Catastrophic bone marrow aplasia. Reduce dose by 90% or choose alternative immunosuppressant.' },
    { gene: 'HLA-B*57:01', phenotype: 'Positive Allele', drug: 'Abacavir (Ziagen)', risk: 'CONTRAINDICATED', rec: 'Severe immunological hypersensitivity reaction. Never administer or rechallenge.' },
    { gene: 'DPYD', phenotype: 'Complete DPD Deficiency (*2A)', drug: '5-Fluorouracil / Capecitabine', risk: 'FATAL TOXICITY', rec: 'Severe pancytopenic death. Fluoropyrimidines strictly contraindicated.' },
  ];

  const filtered = rules.filter(r => r.drug.toLowerCase().includes(search.toLowerCase()) || r.gene.toLowerCase().includes(search.toLowerCase()));

  return (
    <div className="space-y-6">
      <div className="flex justify-between items-center bg-indigo-950 text-white p-6 rounded-2xl border border-indigo-900 shadow-xl">
        <div>
          <div className="flex items-center gap-3">
            <Dna className="w-8 h-8 text-indigo-400" />
            <h1 className="text-2xl font-bold tracking-tight">Precision Pharmacogenomics & Genomic Dosing Station</h1>
          </div>
          <p className="text-indigo-300 text-sm mt-1">CPIC & PharmGKB Level-A Genotype-Guided Medication Safety Guards</p>
        </div>
      </div>

      <div className="relative">
        <Search className="w-5 h-5 absolute left-3 top-3.5 text-slate-400" />
        <input
          type="text"
          placeholder="Search gene (CYP2C19, TPMT, DPYD) or pharmaceutical drug name (Clopidogrel, Azathioprine)..."
          value={search}
          onChange={e => setSearch(e.target.value)}
          className="w-full pl-10 pr-4 py-3 rounded-xl border border-slate-300 focus:outline-none focus:ring-2 focus:ring-indigo-500 bg-white shadow-sm text-sm"
        />
      </div>

      <div className="grid grid-cols-1 gap-4">
        {filtered.map((item, idx) => (
          <div key={idx} className="bg-white border border-slate-200 rounded-2xl p-5 shadow-sm hover:border-indigo-300 transition-all">
            <div className="flex justify-between items-start">
              <div>
                <div className="flex items-center gap-2">
                  <span className="font-bold text-base text-slate-900">{item.drug}</span>
                  <span className="text-xs bg-indigo-100 text-indigo-800 font-semibold px-2 py-0.5 rounded-full">{item.gene}</span>
                </div>
                <p className="text-xs text-slate-500 mt-0.5">Phenotype: <strong className="text-slate-700">{item.phenotype}</strong></p>
              </div>
              <span className="text-xs font-bold px-3 py-1 bg-rose-100 text-rose-800 border border-rose-200 rounded-full flex items-center gap-1">
                <AlertTriangle className="w-3.5 h-3.5" />
                {item.risk}
              </span>
            </div>
            <div className="mt-3 p-3 bg-slate-50 rounded-xl border border-slate-200 text-xs text-slate-700 leading-relaxed">
              <strong>Clinical Action:</strong> {item.rec}
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};
