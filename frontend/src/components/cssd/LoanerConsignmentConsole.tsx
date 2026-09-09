import React, { useState } from 'react';
import { Truck, CheckCircle2, Clock, Calendar } from 'lucide-react';

export const LoanerConsignmentConsole: React.FC = () => {
  const [loaners] = useState([
    { id: 'LOAN-STK-01', vendor: 'Stryker Ortho', set: 'Triathlon Total Knee Revision (5 Trays)', surgeon: 'Dr. Jenkins', arrival: '28 hrs prior to OR', compliant: true },
    { id: 'LOAN-DEP-02', vendor: 'DePuy Synthes', set: 'EXPEDIUM Spine Stabilization (4 Trays)', surgeon: 'Dr. Miller', arrival: '26 hrs prior to OR', compliant: true }
  ]);

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Truck className="h-7 w-7 text-indigo-400" />
          <div>
            <h2 className="text-xl font-bold">Orthopedic / Spine Vendor Loaner Intake</h2>
            <p className="text-xs text-slate-400">Mandatory 24-Hour Pre-Op Reprocessing Delivery SLA Monitor</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-2 gap-4 my-6">
        {loaners.map(l => (
          <div key={l.id} className="p-4 bg-slate-950 rounded-xl border border-slate-800">
            <span className="text-xs font-mono text-slate-400">{l.id} • {l.vendor}</span>
            <h3 className="text-sm font-bold text-white mt-1">{l.set}</h3>
            <p className="text-xs text-slate-400 mt-1">Surgeon: {l.surgeon}</p>
            <div className="mt-3 flex items-center gap-2 text-xs text-emerald-400 font-bold">
              <CheckCircle2 className="h-4 w-4" /> Delivered: {l.arrival} (24-Hr SLA Met)
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};
