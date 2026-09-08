import React, { useState } from 'react';
import { Microscope, CheckCircle2, XCircle, ShieldAlert } from 'lucide-react';

export const VirtualCrossmatchStudio: React.FC = () => {
  const [dsaList] = useState([
    { locus: 'HLA-A*02:01', mfi: 820, threshold: 1000, isDsa: false },
    { locus: 'HLA-B*27:05', mfi: 450, threshold: 1000, isDsa: false },
    { locus: 'HLA-DRB1*04:01', mfi: 6200, threshold: 1000, isDsa: true }
  ]);

  const hasPositiveDsa = dsaList.some(d => d.isDsa);

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Microscope className="h-7 w-7 text-indigo-400" />
          <div>
            <h2 className="text-xl font-bold">Virtual Crossmatch (vXM) Luminex DSA Studio</h2>
            <p className="text-xs text-slate-400">Single Antigen Bead Anti-HLA Mean Fluorescence Intensity (MFI)</p>
          </div>
        </div>
        <span className={'px-3 py-1 rounded-full text-xs font-mono font-bold ' + (
          hasPositiveDsa ? 'bg-rose-950 text-rose-300 border border-rose-700' : 'bg-emerald-950 text-emerald-300 border border-emerald-700'
        )}>
          {hasPositiveDsa ? 'vXM POSITIVE (DSA DETECTED)' : 'vXM NEGATIVE (COMPATIBLE)'}
        </span>
      </div>

      <div className="space-y-3 my-6">
        {dsaList.map(d => (
          <div key={d.locus} className="p-3 bg-slate-950 rounded-lg border border-slate-800 flex justify-between items-center text-xs">
            <div>
              <span className="font-mono font-bold text-white">{d.locus}</span>
              <span className="text-slate-400 ml-3">Measured MFI: <strong>{d.mfi}</strong></span>
            </div>
            {d.isDsa ? (
              <span className="text-rose-400 font-bold flex items-center gap-1"><XCircle className="h-4 w-4" /> Strong DSA (&gt; 1000 MFI)</span>
            ) : (
              <span className="text-emerald-400 font-bold flex items-center gap-1"><CheckCircle2 className="h-4 w-4" /> Below Cutoff</span>
            )}
          </div>
        ))}
      </div>
    </div>
  );
};
