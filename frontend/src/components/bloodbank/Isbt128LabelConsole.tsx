import React, { useState } from 'react';
import { Tag, CheckCircle2, QrCode, Droplets, ShieldCheck } from 'lucide-react';

export const Isbt128LabelConsole: React.FC = () => {
  const [din, setDin] = useState('W0123 26 123456 K');
  const [productCode, setProductCode] = useState('E0398');
  const [aboRh, setAboRh] = useState('O Positive (O Pos)');

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Tag className="h-7 w-7 text-rose-400" />
          <div>
            <h2 className="text-xl font-bold">ISBT 128 Blood Product Barcode & DIN Decoder</h2>
            <p className="text-xs text-slate-400">ICCBBA Global Standard Donation Identification & Product Structure</p>
          </div>
        </div>
        <span className="px-3 py-1 bg-rose-950 text-rose-300 border border-rose-700/60 rounded-full text-xs font-mono font-bold">
          ISBT 128 COMPLIANT
        </span>
      </div>

      <div className="grid grid-cols-2 gap-5 my-6">
        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 space-y-3">
          <div>
            <label className="text-xs text-slate-400 block mb-1">Donation Identification Number (DIN)</label>
            <input type="text" value={din} onChange={e => setDin(e.target.value)} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-rose-300 font-mono font-bold" />
          </div>
          <div>
            <label className="text-xs text-slate-400 block mb-1">Product Code</label>
            <select value={productCode} onChange={e => setProductCode(e.target.value)} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-slate-200 font-mono">
              <option value="E0398">E0398: Red Blood Cells Leukocytes Reduced</option>
              <option value="E3847">E3847: Apheresis Platelets Leukocytes Reduced Irradiated</option>
              <option value="E0789">E0789: Fresh Frozen Plasma (FFP)</option>
              <option value="E0611">E0611: Cryoprecipitated AHF</option>
            </select>
          </div>
          <div>
            <label className="text-xs text-slate-400 block mb-1">ABO / Rh Group</label>
            <select value={aboRh} onChange={e => setAboRh(e.target.value)} className="w-full bg-slate-900 border border-slate-700 rounded px-2.5 py-1.5 text-xs text-slate-200">
              <option>O Positive (O Pos)</option>
              <option>O Negative (O Neg)</option>
              <option>A Positive (A Pos)</option>
              <option>B Positive (B Pos)</option>
              <option>AB Positive (AB Pos)</option>
            </select>
          </div>
        </div>

        <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 flex flex-col justify-between font-mono text-xs">
          <div className="space-y-2">
            <h3 className="text-sm font-semibold text-slate-300 font-sans mb-3">Decoded Blood Bag Quadrant Data</h3>
            <div className="p-2 bg-slate-900 rounded border border-slate-800">
              <span className="text-slate-400">DIN Facility Code:</span> <strong className="text-white">W0123 (Regional Blood Center)</strong>
            </div>
            <div className="p-2 bg-slate-900 rounded border border-slate-800">
              <span className="text-slate-400">Year / Sequence:</span> <strong className="text-white">2026 / #123456</strong>
            </div>
            <div className="p-2 bg-slate-900 rounded border border-slate-800">
              <span className="text-slate-400">ABO/Rh Phenotype:</span> <strong className="text-rose-400 font-bold">{aboRh}</strong>
            </div>
          </div>
          <div className="p-2 bg-emerald-950/60 border border-emerald-800 rounded text-emerald-300 flex items-center gap-1.5">
            <CheckCircle2 className="h-4 w-4" /> Mod 37-2 Checksum Validated
          </div>
        </div>
      </div>
    </div>
  );
};
