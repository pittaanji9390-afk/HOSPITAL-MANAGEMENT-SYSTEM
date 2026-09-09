import React, { useState } from 'react';
import {
  Package,
  Barcode,
  Plus,
  Minus,
  CheckCircle2,
  AlertTriangle,
  Search,
} from 'lucide-react';

export const InventoryScannerScreen: React.FC = () => {
  const [items, setItems] = useState([
    { code: 'INV-IV-NS500', name: '0.9% Normal Saline 500 mL IV Infusion', stock: 450, unit: 'BOTTLE', min: 100 },
    { code: 'INV-SYR-5ML', name: '5 mL Disposable Luer-Lock Syringe', stock: 1200, unit: 'PIECE', min: 300 },
    { code: 'INV-CATH-18G', name: '18G Green IV Cannula Catheter', stock: 320, unit: 'PIECE', min: 80 },
    { code: 'INV-GLOVE-7.5', name: 'Sterile Surgical Gloves (Size 7.5)', stock: 40, unit: 'PAIR', min: 100 }, // Low stock
  ]);

  return (
    <div className="space-y-4 pb-20">
      <div className="p-4 bg-slate-800 rounded-2xl border border-slate-700 flex items-center justify-between">
        <div>
          <span className="text-[10px] font-bold text-sky-400 block">POINT-OF-CARE INVENTORY</span>
          <h3 className="text-sm font-bold text-white">Central Medical Supplies</h3>
        </div>
        <button className="p-2.5 bg-sky-600 active:bg-sky-500 rounded-xl text-white shadow-lg">
          <Barcode className="h-5 w-5" />
        </button>
      </div>

      <div className="space-y-3">
        {items.map((item) => {
          const isLow = item.stock <= item.min;
          return (
            <div key={item.code} className="p-4 bg-slate-800 rounded-2xl border border-slate-700 space-y-2 text-xs">
              <div className="flex items-start justify-between">
                <div>
                  <span className="font-mono text-[10px] text-sky-400 font-bold">{item.code}</span>
                  <h4 className="text-sm font-bold text-white mt-0.5">{item.name}</h4>
                </div>
                {isLow && (
                  <span className="px-2 py-0.5 rounded text-[10px] font-bold bg-rose-950 text-rose-300 border border-rose-800">
                    Low Stock
                  </span>
                )}
              </div>

              <div className="flex items-center justify-between pt-2 border-t border-slate-700/60">
                <span className="text-slate-400">Available: <strong className="text-white text-sm">{item.stock}</strong> {item.unit}s</span>
                <div className="flex items-center gap-1.5">
                  <button
                    onClick={() => {
                      setItems(items.map(i => i.code === item.code ? { ...i, stock: Math.max(0, i.stock - 1) } : i));
                    }}
                    className="p-1.5 bg-slate-900 active:bg-slate-700 rounded-lg text-slate-200"
                  >
                    <Minus className="h-4 w-4" />
                  </button>
                  <button
                    onClick={() => {
                      setItems(items.map(i => i.code === item.code ? { ...i, stock: i.stock + 1 } : i));
                    }}
                    className="p-1.5 bg-sky-600 active:bg-sky-500 rounded-lg text-white"
                  >
                    <Plus className="h-4 w-4" />
                  </button>
                </div>
              </div>
            </div>
          );
        })}
      </div>
    </div>
  );
};
