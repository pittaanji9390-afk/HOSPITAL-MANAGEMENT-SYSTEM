import React, { useState } from 'react';
import { Lock, Unlock, ShieldAlert, Cpu, CheckCircle2, RefreshCw, Key } from 'lucide-react';

interface Pocket {
  id: string;
  row: number;
  col: number;
  medName: string;
  ndc: string;
  qty: number;
  isUnlocked: boolean;
}

export const PyxisDrawerConsole: React.FC = () => {
  const [selectedCabinet, setSelectedCabinet] = useState('CAB-ICU-01');
  const [selectedDrawer, setSelectedDrawer] = useState('DRW-02 (Matrix High-Alert)');
  const [nurseBadge, setNurseBadge] = useState('RN-88492');
  const [rxOrder, setRxOrder] = useState('RX-2026-99120');

  const [pockets, setPockets] = useState<Pocket[]>([
    { id: 'PKT-A1', row: 1, col: 1, medName: 'Norepinephrine 4mg/4mL', ndc: '00409-1443-04', qty: 6, isUnlocked: false },
    { id: 'PKT-A2', row: 1, col: 2, medName: 'Vasopressin 20 units/mL', ndc: '42023-119-25', qty: 4, isUnlocked: false },
    { id: 'PKT-A3', row: 1, col: 3, medName: 'Epinephrine 1mg/mL', ndc: '70518-0321-0', qty: 12, isUnlocked: false },
    { id: 'PKT-A4', row: 1, col: 4, medName: 'Amiodarone 150mg/3mL', ndc: '00641-6002-10', qty: 8, isUnlocked: false },
    { id: 'PKT-B1', row: 2, col: 1, medName: 'Fentanyl 100mcg/2mL', ndc: '00406-0512-01', qty: 5, isUnlocked: false },
    { id: 'PKT-B2', row: 2, col: 2, medName: 'Midazolam 5mg/mL', ndc: '00004-0058-01', qty: 10, isUnlocked: false },
    { id: 'PKT-B3', row: 2, col: 3, medName: 'Hydromorphone 2mg/mL', ndc: '00074-3799-04', qty: 3, isUnlocked: false },
    { id: 'PKT-B4', row: 2, col: 4, medName: 'Morphine 10mg/mL', ndc: '00641-6040-25', qty: 7, isUnlocked: false }
  ]);

  const [activeLog, setActiveLog] = useState<string[]>([
    'CAN-Bus Solenoid Controller online. Baud: 500kbps.',
    'Drawer closed and locked. Microswitch engaged.'
  ]);

  const handleUnlockPocket = (id: string) => {
    setPockets(prev => prev.map(p => p.id === id ? { ...p, isUnlocked: true, qty: Math.max(0, p.qty - 1) } : p));
    const target = pockets.find(p => p.id === id);
    setActiveLog(prev => [
      '[' + new Date().toLocaleTimeString() + '] SOLENOID RELEASE: ' + id + ' (' + (target ? target.medName : '') + ') unlocked for Nurse ' + nurseBadge + ' (Order ' + rxOrder + ')',
      ...prev
    ]);
  };

  const handleLockAll = () => {
    setPockets(prev => prev.map(p => ({ ...p, isUnlocked: false })));
    setActiveLog(prev => ['[' + new Date().toLocaleTimeString() + '] ALL SOLENOIDS ENGAGED: Drawer locked.', ...prev]);
  };

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Cpu className="h-7 w-7 text-indigo-400 animate-pulse" />
          <div>
            <h2 className="text-xl font-bold tracking-wide">Pyxis MedStation Automated Dispensing Cabinet (ADC)</h2>
            <p className="text-xs text-slate-400">RS-485 Solenoid Matrix & Bio-ID Microswitch Controller</p>
          </div>
        </div>
        <div className="flex gap-2">
          <button onClick={handleLockAll} className="px-3 py-1.5 bg-rose-600/20 text-rose-300 hover:bg-rose-600/30 border border-rose-500/40 rounded text-xs flex items-center gap-1.5 transition">
            <Lock className="h-4 w-4" /> Lock All Solenoids
          </button>
        </div>
      </div>

      <div className="grid grid-cols-3 gap-4 my-4">
        <div className="bg-slate-950 p-3 rounded-lg border border-slate-800">
          <label className="text-xs text-slate-400 block mb-1">Target ADC Tower</label>
          <select value={selectedCabinet} onChange={e => setSelectedCabinet(e.target.value)} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1 text-sm text-slate-200">
            <option>CAB-ICU-01 (Intensive Care)</option>
            <option>CAB-ER-02 (Emergency Resuscitation)</option>
            <option>CAB-OR-03 (Surgical Suite)</option>
          </select>
        </div>
        <div className="bg-slate-950 p-3 rounded-lg border border-slate-800">
          <label className="text-xs text-slate-400 block mb-1">Nurse Badge Bio-ID</label>
          <input type="text" value={nurseBadge} onChange={e => setNurseBadge(e.target.value)} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1 text-sm text-slate-200" />
        </div>
        <div className="bg-slate-950 p-3 rounded-lg border border-slate-800">
          <label className="text-xs text-slate-400 block mb-1">Prescription Order Ref</label>
          <input type="text" value={rxOrder} onChange={e => setRxOrder(e.target.value)} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1 text-sm text-slate-200" />
        </div>
      </div>

      <div className="my-6">
        <h3 className="text-sm font-semibold text-slate-300 mb-3 flex items-center gap-2">
          <Key className="h-4 w-4 text-amber-400" /> Drawer Matrix Pocket Layout: {selectedDrawer}
        </h3>
        <div className="grid grid-cols-4 gap-4">
          {pockets.map(p => (
            <div
              key={p.id}
              className={'p-4 rounded-xl border transition-all duration-200 ' + (
                p.isUnlocked
                  ? 'bg-emerald-950/40 border-emerald-500 shadow-lg shadow-emerald-950/50'
                  : 'bg-slate-800/60 border-slate-700 hover:border-indigo-500'
              )}
            >
              <div className="flex justify-between items-start mb-2">
                <span className="text-xs font-mono font-bold px-2 py-0.5 rounded bg-slate-900 text-slate-300">{p.id}</span>
                {p.isUnlocked ? (
                  <span className="text-xs text-emerald-400 flex items-center gap-1 font-semibold"><Unlock className="h-3 w-3" /> OPEN</span>
                ) : (
                  <span className="text-xs text-slate-400 flex items-center gap-1"><Lock className="h-3 w-3" /> LOCKED</span>
                )}
              </div>
              <h4 className="text-sm font-bold text-slate-100">{p.medName}</h4>
              <p className="text-xs text-slate-400 font-mono mt-1">NDC: {p.ndc}</p>
              <div className="mt-3 flex justify-between items-center">
                <span className="text-xs text-slate-300">Qty: <strong className="text-white">{p.qty}</strong></span>
                {!p.isUnlocked ? (
                  <button
                    onClick={() => handleUnlockPocket(p.id)}
                    className="px-2.5 py-1 bg-indigo-600 hover:bg-indigo-500 text-white rounded text-xs font-medium flex items-center gap-1"
                  >
                    Release Pocket
                  </button>
                ) : (
                  <span className="text-xs text-emerald-300 flex items-center gap-1"><CheckCircle2 className="h-3.5 w-3.5" /> Dispensed</span>
                )}
              </div>
            </div>
          ))}
        </div>
      </div>

      <div className="bg-slate-950 p-4 rounded-lg border border-slate-800">
        <h4 className="text-xs font-mono text-slate-400 uppercase tracking-wider mb-2">CAN-Bus Solenoid Audit Telemetry Stream</h4>
        <div className="font-mono text-xs space-y-1 max-h-32 overflow-y-auto text-slate-300">
          {activeLog.map((log, idx) => (
            <div key={idx} className="leading-relaxed">{log}</div>
          ))}
        </div>
      </div>
    </div>
  );
};
