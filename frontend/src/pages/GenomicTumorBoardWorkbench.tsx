import React, { useState } from 'react';
import { Dna, Target, CheckCircle2, AlertOctagon, Sparkles, FileText, ArrowRight } from 'lucide-react';

export const GenomicTumorBoardWorkbench: React.FC = () => {
  const [selectedCase, setSelectedCase] = useState('CASE-101');

  const cases = [
    { id: 'CASE-101', patient: 'Sunil Nair (54M)', cancer: 'Stage IV NSCLC (Adenocarcinoma)', biomarker: 'EGFR Exon 19 Deletion (p.E746_A750del)', therapy: 'Osimertinib 80mg PO daily (3rd Gen TKI)', status: 'Actionable' },
    { id: 'CASE-102', patient: 'Deepa Kulkarni (48F)', cancer: 'Metastatic Breast Cancer', biomarker: 'HER2 IHC 3+ / FISH Amplified, PIK3CA H1047R', therapy: 'Trastuzumab + Pertuzumab + Docetaxel -> Alpelisib', status: 'Actionable' },
    { id: 'CASE-103', patient: 'Karan Ahuja (62M)', cancer: 'Advanced Colorectal Cancer', biomarker: 'KRAS G12D Mutated, MSI-High (dMMR)', therapy: 'Pembrolizumab 200mg IV q3w (Avoid Anti-EGFR)', status: 'Immune Eligible' },
  ];

  return (
    <div className="space-y-6">
      <div className="bg-slate-900 text-white p-6 rounded-2xl border border-slate-800 shadow-xl flex justify-between items-center">
        <div>
          <div className="flex items-center gap-3">
            <Dna className="w-8 h-8 text-pink-400" />
            <h1 className="text-2xl font-bold">Molecular Tumor Board & Precision Oncology Workbench</h1>
          </div>
          <p className="text-slate-400 text-sm mt-1">Next-Generation Sequencing (NGS) Variant Annotation, OncoKB Evidence Level & Clinical Trial Matching</p>
        </div>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-3 gap-4">
        {cases.map(c => (
          <div
            key={c.id}
            onClick={() => setSelectedCase(c.id)}
            className={`p-5 rounded-2xl border cursor-pointer transition-all ${
              selectedCase === c.id
                ? 'bg-slate-900 border-pink-500 shadow-lg ring-2 ring-pink-500/20'
                : 'bg-white border-slate-200 hover:border-slate-300 shadow-sm'
            }`}
          >
            <div className="flex justify-between items-center mb-2">
              <span className="text-xs font-bold px-2 py-0.5 rounded bg-slate-100 dark:bg-slate-800 text-slate-700 dark:text-slate-300">{c.id}</span>
              <span className="text-xs font-bold px-2 py-0.5 rounded bg-pink-100 text-pink-800">{c.status}</span>
            </div>
            <h3 className={`font-bold text-sm ${selectedCase === c.id ? 'text-white' : 'text-slate-900'}`}>{c.patient}</h3>
            <p className="text-xs text-slate-400 mt-0.5">{c.cancer}</p>
            <div className="mt-3 p-2.5 bg-slate-50 dark:bg-slate-800 rounded-xl border border-slate-200 dark:border-slate-700 text-xs">
              <span className="text-pink-600 dark:text-pink-400 font-bold block">Biomarker:</span>
              <span className="text-slate-700 dark:text-slate-300">{c.biomarker}</span>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};
