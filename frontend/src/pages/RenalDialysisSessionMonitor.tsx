import React, { useState } from 'react';
import { ShieldCheck, Search, Filter, Plus, FileText, CheckCircle2, AlertTriangle, ArrowRight } from 'lucide-react';

export const RenalDialysisSessionMonitor: React.FC = () => {
  const [searchTerm, setSearchTerm] = useState('');
  const [activeTab, setActiveTab] = useState('active');

  const items = [
    { id: '1', name: 'Standard Clinical Protocol Alpha', category: 'High Complexity', status: 'Active', updated: '2026-09-08' },
    { id: '2', name: 'Standard Clinical Protocol Beta', category: 'Emergency Pathway', status: 'Review', updated: '2026-09-07' },
    { id: '3', name: 'Standard Clinical Protocol Gamma', category: 'Subspecialty Guidance', status: 'Active', updated: '2026-09-06' },
    { id: '4', name: 'Standard Clinical Protocol Delta', category: 'Critical Care Guideline', status: 'Active', updated: '2026-09-05' },
  ];

  return (
    <div className="space-y-6">
      <div className="bg-slate-900 text-white p-6 rounded-2xl border border-slate-800 shadow-xl flex justify-between items-center">
        <div>
          <h1 className="text-2xl font-bold tracking-tight">Hemodialysis Flowsheet & spKt/V Adequacy Monitor</h1>
          <p className="text-slate-400 text-sm mt-1">Enterprise Clinical Workstation with Real-Time Medical Decision Validation</p>
        </div>
        <div className="flex gap-2">
          <button className="bg-indigo-600 hover:bg-indigo-700 text-white text-xs font-semibold px-4 py-2.5 rounded-xl shadow-sm transition-all flex items-center gap-1.5">
            <Plus className="w-4 h-4" />
            New Entry
          </button>
        </div>
      </div>

      <div className="flex gap-4">
        <div className="relative flex-1">
          <Search className="w-5 h-5 absolute left-3 top-3 text-slate-400" />
          <input
            type="text"
            placeholder="Search records, diagnostic criteria, or guidelines..."
            value={searchTerm}
            onChange={e => setSearchTerm(e.target.value)}
            className="w-full pl-10 pr-4 py-2.5 rounded-xl border border-slate-300 focus:outline-none focus:ring-2 focus:ring-indigo-500 bg-white text-sm"
          />
        </div>
        <button className="px-4 py-2.5 rounded-xl border border-slate-300 bg-white text-slate-700 text-sm font-medium hover:bg-slate-50 flex items-center gap-2">
          <Filter className="w-4 h-4" />
          Filter
        </button>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
        {items.map(item => (
          <div key={item.id} className="bg-white border border-slate-200 rounded-2xl p-5 shadow-sm hover:border-indigo-400 transition-all">
            <div className="flex justify-between items-start mb-2">
              <span className="text-xs font-bold px-2.5 py-0.5 rounded-full bg-slate-100 text-slate-700">ID: #{item.id}</span>
              <span className="text-xs font-semibold px-2 py-0.5 rounded bg-emerald-100 text-emerald-800 flex items-center gap-1">
                <CheckCircle2 className="w-3 h-3" />
                {item.status}
              </span>
            </div>
            <h3 className="font-bold text-base text-slate-900">{item.name}</h3>
            <p className="text-xs text-slate-500 mt-1">Classification: <strong className="text-slate-700">{item.category}</strong></p>
            <div className="mt-4 pt-3 border-t border-slate-100 flex justify-between items-center text-xs text-slate-400">
              <span>Last Synchronized: {item.updated}</span>
              <button className="text-indigo-600 font-semibold hover:text-indigo-800 flex items-center gap-1">
                View Full Protocol <ArrowRight className="w-3.5 h-3.5" />
              </button>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};
