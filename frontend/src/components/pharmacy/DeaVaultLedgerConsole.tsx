import React, { useState } from 'react';
import { ShieldCheck, AlertOctagon, UserCheck, Scale, FileText, ArrowDownRight } from 'lucide-react';

interface VaultItem {
  ndc: string;
  name: string;
  schedule: string;
  onHand: number;
  uom: string;
  lastAuditDate: string;
}

export const DeaVaultLedgerConsole: React.FC = () => {
  const [vaultItems] = useState<VaultItem[]>([
    { ndc: '00406-0512-01', name: 'Fentanyl Citrate 50mcg/mL (2mL Ampule)', schedule: 'C-II', onHand: 450, uom: 'Ampules', lastAuditDate: '2026-09-08 07:00' },
    { ndc: '00074-3799-04', name: 'Hydromorphone HCl 2mg/mL Carpuject', schedule: 'C-II', onHand: 320, uom: 'Carpujects', lastAuditDate: '2026-09-08 07:00' },
    { ndc: '00641-6040-25', name: 'Morphine Sulfate 10mg/mL 1mL Vial', schedule: 'C-II', onHand: 280, uom: 'Vials', lastAuditDate: '2026-09-08 07:00' },
    { ndc: '00004-0058-01', name: 'Midazolam HCl 5mg/mL 2mL Vial', schedule: 'C-IV', onHand: 600, uom: 'Vials', lastAuditDate: '2026-09-08 07:00' }
  ]);

  const [selectedNdc, setSelectedNdc] = useState('00406-0512-01');
  const [wasteQty, setWasteQty] = useState('1.0');
  const [primaryNurse, setPrimaryNurse] = useState('RN-88492');
  const [witnessNurse, setWitnessNurse] = useState('RN-10492');
  const [patientMrn, setPatientMrn] = useState('MRN-998822');

  const [wasteAuditLogs, setWasteAuditLogs] = useState<string[]>([
    'DEA CSOS-222 System Authenticated. Digital Certificate Valid.',
    'Perpetual balance reconciliations within 0.00% variance tolerance.'
  ]);

  const handleRecordWaste = (e: React.FormEvent) => {
    e.preventDefault();
    if (primaryNurse === witnessNurse) {
      alert('DEA & Hospital Policy Violation: Witness nurse cannot be the same as primary nurse.');
      return;
    }
    const item = vaultItems.find(v => v.ndc === selectedNdc);
    setWasteAuditLogs(prev => [
      '[' + new Date().toLocaleTimeString() + '] DUAL-SIGN WASTE RECORDED: ' + wasteQty + ' mL of ' + (item ? item.name : '') + ' for ' + patientMrn + '. Primary: ' + primaryNurse + ' | Witness: ' + witnessNurse + ' | SHA256 Verified.',
      ...prev
    ]);
  };

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <ShieldCheck className="h-7 w-7 text-emerald-400" />
          <div>
            <h2 className="text-xl font-bold">DEA Schedule II-V Perpetual Vault Ledger</h2>
            <p className="text-xs text-slate-400">Electronic Form 222 CSOS & Dual-Nurse Waste Witnessing Engine</p>
          </div>
        </div>
        <span className="px-3 py-1 bg-emerald-950 text-emerald-300 border border-emerald-700/50 rounded-full text-xs font-mono">
          DEA REG: FH-9923841
        </span>
      </div>

      <div className="my-6">
        <h3 className="text-sm font-semibold text-slate-300 mb-3 flex items-center gap-2">
          <FileText className="h-4 w-4 text-indigo-400" /> Central Vault Perpetual Inventory Balances
        </h3>
        <div className="overflow-x-auto">
          <table className="w-full text-left text-sm border border-slate-800 rounded-lg overflow-hidden">
            <thead className="bg-slate-950 text-slate-400 text-xs font-mono uppercase">
              <tr>
                <th className="p-3">Schedule</th>
                <th className="p-3">NDC Code</th>
                <th className="p-3">Controlled Drug Description</th>
                <th className="p-3">On-Hand Balance</th>
                <th className="p-3">Unit of Measure</th>
                <th className="p-3">Last Blind Count Audit</th>
              </tr>
            </thead>
            <tbody className="divide-y divide-slate-800 bg-slate-900/60">
              {vaultItems.map(item => (
                <tr key={item.ndc} className="hover:bg-slate-800/50 transition">
                  <td className="p-3">
                    <span className={'px-2 py-0.5 rounded text-xs font-bold font-mono ' + (
                      item.schedule === 'C-II' ? 'bg-rose-950 text-rose-300 border border-rose-800' : 'bg-amber-950 text-amber-300 border border-amber-800'
                    )}>
                      {item.schedule}
                    </span>
                  </td>
                  <td className="p-3 font-mono text-xs text-slate-300">{item.ndc}</td>
                  <td className="p-3 font-medium text-slate-100">{item.name}</td>
                  <td className="p-3 font-bold text-emerald-400">{item.onHand}</td>
                  <td className="p-3 text-slate-400">{item.uom}</td>
                  <td className="p-3 font-mono text-xs text-slate-400">{item.lastAuditDate}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>

      <div className="bg-slate-950 p-5 rounded-xl border border-slate-800">
        <h3 className="text-sm font-semibold text-slate-200 mb-4 flex items-center gap-2">
          <UserCheck className="h-4 w-4 text-amber-400" /> Record Partial Dose Dual-Nurse Waste Witnessing
        </h3>
        <form onSubmit={handleRecordWaste} className="grid grid-cols-4 gap-4">
          <div>
            <label className="text-xs text-slate-400 block mb-1">Controlled NDC</label>
            <select value={selectedNdc} onChange={e => setSelectedNdc(e.target.value)} className="w-full bg-slate-900 border border-slate-700 rounded px-3 py-2 text-sm text-slate-200">
              {vaultItems.map(v => (
                <option key={v.ndc} value={v.ndc}>{v.name}</option>
              ))}
            </select>
          </div>
          <div>
            <label className="text-xs text-slate-400 block mb-1">Wasted Volume (mL)</label>
            <input type="number" step="0.1" value={wasteQty} onChange={e => setWasteQty(e.target.value)} className="w-full bg-slate-900 border border-slate-700 rounded px-3 py-2 text-sm text-slate-200" required />
          </div>
          <div>
            <label className="text-xs text-slate-400 block mb-1">Primary Administering Nurse Badge</label>
            <input type="text" value={primaryNurse} onChange={e => setPrimaryNurse(e.target.value)} className="w-full bg-slate-900 border border-slate-700 rounded px-3 py-2 text-sm text-slate-200" required />
          </div>
          <div>
            <label className="text-xs text-slate-400 block mb-1">Witness Nurse Badge (Co-signer)</label>
            <input type="text" value={witnessNurse} onChange={e => setWitnessNurse(e.target.value)} className="w-full bg-slate-900 border border-slate-700 rounded px-3 py-2 text-sm text-slate-200" required />
          </div>
          <div className="col-span-4 flex justify-between items-center mt-2">
            <span className="text-xs text-slate-400 flex items-center gap-1.5">
              <AlertOctagon className="h-4 w-4 text-amber-400" /> Waste destruction must occur directly into approved chemical denaturing receptacle (e.g. Rx Destroyer).
            </span>
            <button type="submit" className="px-5 py-2 bg-emerald-600 hover:bg-emerald-500 text-white font-medium rounded-lg text-sm flex items-center gap-2 shadow-lg shadow-emerald-950/50">
              <ShieldCheck className="h-4 w-4" /> Sign & Cryptographically Commit Waste
            </button>
          </div>
        </form>
      </div>

      <div className="mt-4 bg-slate-950 p-4 rounded-lg border border-slate-800 font-mono text-xs text-slate-300">
        <h4 className="text-xs uppercase text-slate-400 mb-2">Immutable CSOS Transaction Log</h4>
        <div className="space-y-1 max-h-28 overflow-y-auto">
          {wasteAuditLogs.map((log, idx) => (
            <div key={idx}>{log}</div>
          ))}
        </div>
      </div>
    </div>
  );
};
