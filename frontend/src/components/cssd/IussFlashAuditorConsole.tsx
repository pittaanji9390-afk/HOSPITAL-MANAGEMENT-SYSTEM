import React, { useState } from 'react';
import { AlertOctagon, ShieldAlert, CheckCircle2, XCircle } from 'lucide-react';

export const IussFlashAuditorConsole: React.FC = () => {
  const [incidents] = useState([
    { id: 'IUSS-01', or: 'OR Suite 4', inst: 'Curved Potts Scissors', reason: 'Dropped one-of-a-kind instrument during vascular dissection', isImplant: false, compliant: true },
    { id: 'IUSS-02', or: 'OR Suite 8', inst: 'Acetabular Reamer Head', reason: 'Convenience / rapid room turnover speed', isImplant: false, compliant: false }
  ]);

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <AlertOctagon className="h-7 w-7 text-rose-400" />
          <div>
            <h2 className="text-xl font-bold">Immediate-Use Steam Sterilization (IUSS / Flash) Auditor</h2>
            <p className="text-xs text-slate-400">Joint Commission & CMS Dropped Instrument Justification Review</p>
          </div>
        </div>
      </div>

      <div className="space-y-3 my-6">
        {incidents.map(i => (
          <div key={i.id} className="p-4 bg-slate-950 rounded-xl border border-slate-800 flex justify-between items-center">
            <div>
              <span className="text-xs font-mono text-slate-400">{i.id} • {i.or}</span>
              <h4 className="text-sm font-bold text-white mt-0.5">{i.inst}</h4>
              <p className="text-xs text-slate-300 mt-1">{i.reason}</p>
            </div>
            <span className={'px-3 py-1 rounded text-xs font-bold font-mono ' + (
              i.compliant ? 'bg-emerald-950 text-emerald-300 border border-emerald-800' : 'bg-rose-950 text-rose-300 border border-rose-800'
            )}>
              {i.compliant ? 'REGULATORY COMPLIANT' : 'PROHIBITED VIOLATION'}
            </span>
          </div>
        ))}
      </div>
    </div>
  );
};
