import React, { useState } from 'react';
import { Tag, CheckCircle2, XCircle, Search, ShieldCheck, Box, RefreshCw } from 'lucide-react';

export const RfidTrayInspectionConsole: React.FC = () => {
  const [selectedTray] = useState('TRAY-INST-1001 (Major Laparotomy Basic Set)');
  const [instruments, setInstruments] = useState([
    { id: 'INS-001', barcode: 'BC-LAP-01', name: '#3 Scalpel Handle', scanned: true },
    { id: 'INS-002', barcode: 'BC-LAP-02', name: 'Metzenbaum Scissors 7" Curved', scanned: true },
    { id: 'INS-003', barcode: 'BC-LAP-03', name: 'Mayo Scissors 6.75" Straight', scanned: true },
    { id: 'INS-004', barcode: 'BC-LAP-04', name: 'DeBakey Vascular Tissue Forceps 8"', scanned: true },
    { id: 'INS-005', barcode: 'BC-LAP-05', name: 'Russian Tissue Forceps 8"', scanned: true },
    { id: 'INS-006', barcode: 'BC-LAP-06', name: 'Balfour Abdominal Retractor Set', scanned: true },
    { id: 'INS-007', barcode: 'BC-LAP-07', name: 'Richardson Retractor Medium', scanned: true },
    { id: 'INS-008', barcode: 'BC-LAP-08', name: 'Crile Hemostatic Clamp Curv 5.5"', scanned: true },
    { id: 'INS-009', barcode: 'BC-LAP-09', name: 'Rochester-Pean Clamp 8"', scanned: false },
    { id: 'INS-010', barcode: 'BC-LAP-10', name: 'Allis Tissue Forceps 6"', scanned: true }
  ]);

  const handleScanItem = (id: string) => {
    setInstruments(prev => prev.map(i => i.id === id ? { ...i, scanned: true } : i));
  };

  const scannedCount = instruments.filter(i => i.scanned).length;
  const isComplete = scannedCount === instruments.length;

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Tag className="h-7 w-7 text-indigo-400" />
          <div>
            <h2 className="text-xl font-bold">RFID Surgical Tray Assembly & Count Verifier</h2>
            <p className="text-xs text-slate-400">2D Laser DataMatrix Micro-Scan & Instrument Integrity Check</p>
          </div>
        </div>
        <span className={'px-3 py-1 rounded-full text-xs font-mono font-bold ' + (
          isComplete ? 'bg-emerald-950 text-emerald-300 border border-emerald-700' : 'bg-amber-950 text-amber-300 border border-amber-700'
        )}>
          {isComplete ? 'TRAY 100% COMPLETE' : scannedCount + '/' + instruments.length + ' INSTRUMENTS VERIFIED'}
        </span>
      </div>

      <div className="my-6">
        <div className="flex justify-between items-center mb-3">
          <h3 className="text-sm font-semibold text-slate-300 flex items-center gap-2">
            <Box className="h-4 w-4 text-indigo-400" /> Tray Recipe: {selectedTray}
          </h3>
          <span className="text-xs font-mono text-slate-400">RFID Tag: E280-1122-3344</span>
        </div>

        <div className="overflow-x-auto">
          <table className="w-full text-left text-sm border border-slate-800 rounded-lg overflow-hidden">
            <thead className="bg-slate-950 text-slate-400 text-xs font-mono uppercase">
              <tr>
                <th className="p-3">Item Barcode</th>
                <th className="p-3">Instrument Description</th>
                <th className="p-3">Status</th>
                <th className="p-3">Action</th>
              </tr>
            </thead>
            <tbody className="divide-y divide-slate-800 bg-slate-900/60">
              {instruments.map(item => (
                <tr key={item.id} className="hover:bg-slate-800/50 transition">
                  <td className="p-3 font-mono text-xs text-slate-300">{item.barcode}</td>
                  <td className="p-3 font-medium text-slate-100">{item.name}</td>
                  <td className="p-3">
                    {item.scanned ? (
                      <span className="flex items-center gap-1.5 text-xs text-emerald-400 font-semibold"><CheckCircle2 className="h-4 w-4" /> Verified In Tray</span>
                    ) : (
                      <span className="flex items-center gap-1.5 text-xs text-rose-400 font-semibold"><XCircle className="h-4 w-4" /> Missing / Unscanned</span>
                    )}
                  </td>
                  <td className="p-3">
                    {!item.scanned && (
                      <button onClick={() => handleScanItem(item.id)} className="px-2.5 py-1 bg-indigo-600 hover:bg-indigo-500 rounded text-xs font-medium text-white transition">
                        Scan Item
                      </button>
                    )}
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
};
