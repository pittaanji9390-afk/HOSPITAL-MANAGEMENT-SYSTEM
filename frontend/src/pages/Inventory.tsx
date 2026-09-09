import React, { useState, useEffect } from 'react';
import {
  Boxes,
  Search,
  AlertTriangle,
  Plus,
  ArrowRight,
  TrendingDown,
  Package,
} from 'lucide-react';
import { apiClient } from '../api/client';
import { InventoryItem, PagedResponse, ApiResponse } from '../types';

export const Inventory: React.FC = () => {
  const [items, setItems] = useState<InventoryItem[]>([
    {
      id: 1,
      code: 'INV-GLOVE-M',
      name: 'Nitrile Examination Gloves (Medium, Box of 100)',
      categoryName: 'Medical Consumables',
      unitOfMeasure: 'BOX',
      currentStock: 450,
      minimumStock: 50,
      reorderQuantity: 200,
      unitCost: 350.0,
      active: true,
    },
    {
      id: 2,
      code: 'INV-SYR-5ML',
      name: 'Sterile Disposable Syringes 5ml with 22G Needle',
      categoryName: 'Surgical Disposables',
      unitOfMeasure: 'BOX',
      currentStock: 800,
      minimumStock: 100,
      reorderQuantity: 500,
      unitCost: 180.0,
      active: true,
    },
    {
      id: 3,
      code: 'INV-IV-SET',
      name: 'IV Infusion Administration Set with Air Vent',
      categoryName: 'Infusion & Catheters',
      unitOfMeasure: 'PCS',
      currentStock: 1200,
      minimumStock: 200,
      reorderQuantity: 1000,
      unitCost: 45.0,
      active: true,
    },
  ]);

  return (
    <div className="space-y-6">
      <div className="flex flex-col sm:flex-row sm:items-center justify-between gap-4 bg-white p-6 rounded-3xl border border-slate-200 shadow-sm">
        <div>
          <h1 className="text-xl font-bold text-slate-900 tracking-tight flex items-center gap-2">
            <Boxes className="h-6 w-6 text-sky-600" />
            Central Hospital Consumables Inventory
          </h1>
          <p className="text-xs text-slate-500 mt-1">
            Surgical disposables, consumables stock ledger, purchase orders, and safety reorder levels
          </p>
        </div>
      </div>

      <div className="bg-white rounded-3xl border border-slate-200 shadow-sm overflow-hidden">
        <div className="overflow-x-auto">
          <table className="w-full text-left text-xs">
            <thead className="bg-slate-50 text-slate-500 uppercase tracking-wider font-semibold border-b border-slate-200">
              <tr>
                <th className="py-3.5 px-4">Item Code</th>
                <th className="py-3.5 px-4">Supplies Name</th>
                <th className="py-3.5 px-4">Category</th>
                <th className="py-3.5 px-4">Unit of Measure</th>
                <th className="py-3.5 px-4">Current Stock</th>
                <th className="py-3.5 px-4">Unit Cost</th>
                <th className="py-3.5 px-4 text-right">Status</th>
              </tr>
            </thead>
            <tbody className="divide-y divide-slate-100">
              {items.map((item) => (
                <tr key={item.id} className="hover:bg-slate-50/80 transition-colors">
                  <td className="py-3.5 px-4 font-mono font-bold text-sky-700">{item.code}</td>
                  <td className="py-3.5 px-4 font-semibold text-slate-900">{item.name}</td>
                  <td className="py-3.5 px-4 text-slate-600">{item.categoryName}</td>
                  <td className="py-3.5 px-4 text-slate-700">{item.unitOfMeasure}</td>
                  <td className="py-3.5 px-4 font-bold text-slate-900">{item.currentStock} units</td>
                  <td className="py-3.5 px-4 text-slate-700">₹{item.unitCost.toFixed(2)}</td>
                  <td className="py-3.5 px-4 text-right">
                    <span className="px-2.5 py-1 rounded-full text-[10px] font-bold bg-emerald-100 text-emerald-800">
                      Adequate
                    </span>
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
