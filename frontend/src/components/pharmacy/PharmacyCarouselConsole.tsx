import React, { useState } from 'react';
import { Layers, Lightbulb, CheckCircle2, RotateCw, ArrowRight } from 'lucide-react';

interface CarouselItem {
  shelf: number;
  bin: number;
  medName: string;
  ndc: string;
  qty: number;
  lightColor: string;
}

export const PharmacyCarouselConsole: React.FC = () => {
  const [activeShelf, setActiveShelf] = useState(4);
  const [items] = useState<CarouselItem[]>([
    { shelf: 4, bin: 12, medName: 'Amoxicillin 500mg Caps', ndc: '00093-0145-01', qty: 1200, lightColor: '#10B981' },
    { shelf: 4, bin: 13, medName: 'Losartan Potassium 50mg', ndc: '00006-0749-54', qty: 950, lightColor: '#10B981' },
    { shelf: 2, bin: 5, medName: 'Atorvastatin Calcium 20mg', ndc: '00069-3150-66', qty: 1400, lightColor: '#3B82F6' },
    { shelf: 8, bin: 1, medName: 'Metformin HCl 500mg ER', ndc: '00781-1506-10', qty: 2100, lightColor: '#F59E0B' }
  ]);

  return (
    <div className="p-6 bg-slate-900 text-slate-100 rounded-xl shadow-2xl border border-slate-800">
      <div className="flex items-center justify-between pb-4 border-b border-slate-800">
        <div className="flex items-center gap-3">
          <Layers className="h-7 w-7 text-indigo-400" />
          <div>
            <h2 className="text-xl font-bold">Vertical Carousel & Pick-to-Light Orchestrator</h2>
            <p className="text-xs text-slate-400">Automated High-Density Storage & Shelf Positioning Director</p>
          </div>
        </div>
        <div className="flex items-center gap-2">
          <button onClick={() => setActiveShelf((activeShelf % 8) + 1)} className="px-3 py-1.5 bg-indigo-600 hover:bg-indigo-500 rounded text-xs flex items-center gap-1.5 transition">
            <RotateCw className="h-3.5 w-3.5" /> Rotate To Shelf #{((activeShelf % 8) + 1)}
          </button>
        </div>
      </div>

      <div className="my-6">
        <h3 className="text-sm font-semibold text-slate-300 mb-3 flex items-center gap-2">
          <Lightbulb className="h-4 w-4 text-amber-400" /> Active Shelf View (Tier #{activeShelf})
        </h3>
        <div className="grid grid-cols-2 gap-4">
          {items.filter(i => i.shelf === activeShelf).map(item => (
            <div key={item.bin} className="p-4 bg-slate-950 rounded-xl border border-slate-800 relative overflow-hidden">
              <div className="absolute top-0 right-0 w-2 h-full" style={{ backgroundColor: item.lightColor }} />
              <span className="text-xs font-mono px-2 py-0.5 bg-slate-900 text-slate-300 rounded font-bold">Bin #{item.bin}</span>
              <h4 className="text-base font-bold text-white mt-2">{item.medName}</h4>
              <p className="text-xs text-slate-400 font-mono mt-1">NDC: {item.ndc}</p>
              <div className="mt-3 flex justify-between items-center text-xs">
                <span className="text-slate-400">Inventory: <strong className="text-white">{item.qty} units</strong></span>
                <span className="text-emerald-400 font-bold flex items-center gap-1"><CheckCircle2 className="h-3.5 w-3.5" /> Pick Illuminated</span>
              </div>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};
