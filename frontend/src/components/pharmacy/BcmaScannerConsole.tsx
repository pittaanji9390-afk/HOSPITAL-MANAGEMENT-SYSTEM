import React, { useState } from 'react';
import { Scan, CheckCircle2, XCircle, AlertTriangle, ShieldCheck, User } from 'lucide-react';

export const BcmaScannerConsole: React.FC = () => {
  const [patientWristband] = useState('MRN-998822');
  const [medBarcode] = useState('00409-1443-04');
  const [scannedWristband, setScannedWristband] = useState('MRN-998822');
  const [scannedMed, setScannedMed] = useState('00409-1443-04');
  const [dose, setDose] = useState('4.0');
  const [route] = useState('IV Infusion');

  const rightPatient = patientWristband.trim() === scannedWristband.trim();
  const rightMed = medBarcode.trim() === scannedMed.trim();
  const rightDose = Number(dose) === 4.0;
  const rightRoute = route === 'IV Infusion';
  const rightTime = true;

  const allPassed = rightPatient && rightMed && rightDose && rightRoute && rightTime;

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Scan className="h-7 w-7 text-indigo-400 animate-pulse" />
          <div>
            <h2 className="text-xl font-bold">BCMA 5-Rights Point-of-Care Barcode Verifier</h2>
            <p className="text-xs text-slate-400">GS1 2D DataMatrix Handheld Optical Interceptor</p>
          </div>
        </div>
        <span className={'px-3 py-1 rounded-full text-xs font-mono font-bold ' + (
          allPassed ? 'bg-emerald-950 text-emerald-300 border border-emerald-700' : 'bg-rose-950 text-rose-300 border border-rose-700'
        )}>
          {allPassed ? 'SAFE TO ADMINISTER' : 'BCMA SAFETY INTERCEPT'}
        </span>
      </div>

      <div className="grid grid-cols-2 gap-5 my-6">
        <div className="bg-slate-950 p-4 rounded-xl border border-slate-800 space-y-3">
          <h3 className="text-sm font-semibold text-slate-300">Scanner Inputs (Handheld Terminal)</h3>
          <div>
            <label className="text-xs text-slate-400 block mb-1">Scanned Patient Wristband Barcode</label>
            <input type="text" value={scannedWristband} onChange={e => setScannedWristband(e.target.value)} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-slate-200 font-mono" />
          </div>
          <div>
            <label className="text-xs text-slate-400 block mb-1">Scanned Medication GS1 DataMatrix</label>
            <input type="text" value={scannedMed} onChange={e => setScannedMed(e.target.value)} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-slate-200 font-mono" />
          </div>
          <div>
            <label className="text-xs text-slate-400 block mb-1">Administered Dose (mg)</label>
            <input type="text" value={dose} onChange={e => setDose(e.target.value)} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-slate-200 font-mono" />
          </div>
        </div>

        <div className="bg-slate-950 p-4 rounded-xl border border-slate-800 flex flex-col justify-between">
          <h3 className="text-sm font-semibold text-slate-300 mb-2">5-Rights Real-Time Verification</h3>
          <div className="space-y-2 text-xs">
            <div className="flex justify-between items-center p-2 rounded bg-slate-900 border border-slate-800">
              <span className="text-slate-300">1. Right Patient (MRN-998822)</span>
              {rightPatient ? <CheckCircle2 className="h-4 w-4 text-emerald-400" /> : <XCircle className="h-4 w-4 text-rose-400" />}
            </div>
            <div className="flex justify-between items-center p-2 rounded bg-slate-900 border border-slate-800">
              <span className="text-slate-300">2. Right Drug (Norepinephrine 4mg/4mL)</span>
              {rightMed ? <CheckCircle2 className="h-4 w-4 text-emerald-400" /> : <XCircle className="h-4 w-4 text-rose-400" />}
            </div>
            <div className="flex justify-between items-center p-2 rounded bg-slate-900 border border-slate-800">
              <span className="text-slate-300">3. Right Dose (4.0 mg)</span>
              {rightDose ? <CheckCircle2 className="h-4 w-4 text-emerald-400" /> : <XCircle className="h-4 w-4 text-rose-400" />}
            </div>
            <div className="flex justify-between items-center p-2 rounded bg-slate-900 border border-slate-800">
              <span className="text-slate-300">4. Right Route (IV Infusion)</span>
              {rightRoute ? <CheckCircle2 className="h-4 w-4 text-emerald-400" /> : <XCircle className="h-4 w-4 text-rose-400" />}
            </div>
            <div className="flex justify-between items-center p-2 rounded bg-slate-900 border border-slate-800">
              <span className="text-slate-300">5. Right Time (Within 60 min window)</span>
              {rightTime ? <CheckCircle2 className="h-4 w-4 text-emerald-400" /> : <XCircle className="h-4 w-4 text-rose-400" />}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};
