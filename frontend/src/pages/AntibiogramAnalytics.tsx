import React, { useState } from 'react';
import {
  Bug,
  ShieldAlert,
  Activity,
  CheckCircle2,
  AlertTriangle,
  FileSpreadsheet,
  Filter,
} from 'lucide-react';

interface AntibiogramRow {
  organism: string;
  isolatesCount: number;
  sensitivities: { [antibiotic: string]: number }; // percentage sensitive
}

export const AntibiogramAnalytics: React.FC = () => {
  const antibiotics = ['Amox-Clav', 'Ceftriaxone', 'Piperacillin-Tazo', 'Meropenem', 'Vancomycin', 'Colistin'];

  const data: AntibiogramRow[] = [
    {
      organism: 'Escherichia coli (Urine/Blood)',
      isolatesCount: 420,
      sensitivities: {
        'Amox-Clav': 62,
        Ceftriaxone: 54,
        'Piperacillin-Tazo': 88,
        Meropenem: 96,
        Vancomycin: 0, // Intrinsic resistant
        Colistin: 99,
      },
    },
    {
      organism: 'Klebsiella pneumoniae (Respiratory/Sputum)',
      isolatesCount: 280,
      sensitivities: {
        'Amox-Clav': 48,
        Ceftriaxone: 42,
        'Piperacillin-Tazo': 78,
        Meropenem: 89,
        Vancomycin: 0,
        Colistin: 97,
      },
    },
    {
      organism: 'Pseudomonas aeruginosa (Wound/Pus)',
      isolatesCount: 150,
      sensitivities: {
        'Amox-Clav': 0,
        Ceftriaxone: 0,
        'Piperacillin-Tazo': 84,
        Meropenem: 82,
        Vancomycin: 0,
        Colistin: 98,
      },
    },
    {
      organism: 'Staphylococcus aureus (MRSA / MSSA)',
      isolatesCount: 310,
      sensitivities: {
        'Amox-Clav': 58, // MSSA only
        Ceftriaxone: 58,
        'Piperacillin-Tazo': 58,
        Meropenem: 58,
        Vancomycin: 100, // 100% Vancomycin sensitive
        Colistin: 0,
      },
    },
  ];

  const getHeatmapColor = (pct: number) => {
    if (pct === 0) return 'bg-slate-100 text-slate-400';
    if (pct >= 85) return 'bg-emerald-100 text-emerald-900 font-bold';
    if (pct >= 60) return 'bg-amber-100 text-amber-900 font-semibold';
    return 'bg-rose-100 text-rose-900 font-bold';
  };

  return (
    <div className="space-y-6">
      {/* Header */}
      <div className="flex flex-col sm:flex-row sm:items-center justify-between gap-4 bg-white p-6 rounded-3xl border border-slate-200 shadow-sm">
        <div>
          <h1 className="text-xl font-bold text-slate-900 tracking-tight flex items-center gap-2">
            <Bug className="h-6 w-6 text-sky-600" />
            Hospital Cumulative Antibiogram & Resistance Surveillance
          </h1>
          <p className="text-xs text-slate-500 mt-1">
            Annual CLSI M39 microbiology antibiogram for empiric antimicrobial therapy guidance
          </p>
        </div>

        <div className="flex items-center gap-2 px-3 py-1.5 bg-sky-50 text-sky-800 border border-sky-200 rounded-xl text-xs font-semibold">
          <FileSpreadsheet className="h-4 w-4 text-sky-600" />
          <span>Cumulative Sample Size: 1,160 Isolates</span>
        </div>
      </div>

      {/* Antibiogram Heatmap Table */}
      <div className="bg-white rounded-3xl border border-slate-200 shadow-sm overflow-hidden">
        <div className="overflow-x-auto">
          <table className="w-full text-left text-xs">
            <thead className="bg-slate-50 text-slate-500 uppercase tracking-wider font-semibold border-b border-slate-200">
              <tr>
                <th className="py-3.5 px-4">Bacterial Pathogen</th>
                <th className="py-3.5 px-4">Isolates</th>
                {antibiotics.map((ab) => (
                  <th key={ab} className="py-3.5 px-4 text-center">{ab}</th>
                ))}
              </tr>
            </thead>
            <tbody className="divide-y divide-slate-100">
              {data.map((row, idx) => (
                <tr key={idx} className="hover:bg-slate-50/80 transition-colors">
                  <td className="py-3.5 px-4 font-bold text-slate-900 italic">{row.organism}</td>
                  <td className="py-3.5 px-4 text-slate-500 font-semibold">{row.isolatesCount}</td>
                  {antibiotics.map((ab) => {
                    const sens = row.sensitivities[ab] || 0;
                    return (
                      <td key={ab} className="py-3.5 px-4 text-center">
                        <span className={`px-2.5 py-1 rounded-lg text-xs inline-block min-w-[48px] ${getHeatmapColor(sens)}`}>
                          {sens > 0 ? `${sens}%` : '—'}
                        </span>
                      </td>
                    );
                  })}
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
};
