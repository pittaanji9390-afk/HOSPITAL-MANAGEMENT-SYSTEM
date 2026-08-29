import React, { useState, useEffect } from 'react';
import {
  Pill,
  Search,
  AlertTriangle,
  Package,
  Plus,
  CheckCircle2,
  Calendar,
  Layers,
} from 'lucide-react';
import { apiClient } from '../api/client';
import { Medicine, MedicineBatch, PagedResponse, ApiResponse } from '../types';

export const Pharmacy: React.FC = () => {
  const [medicines, setMedicines] = useState<Medicine[]>([
    {
      id: 1,
      code: 'MED-AUG625',
      brandName: 'Augmentin 625 Duo',
      genericName: 'Amoxicillin (500mg) + Clavulanic Acid (125mg)',
      categoryId: 1,
      categoryName: 'Antibiotics & Antimicrobials',
      dosageForm: 'TABLET',
      strength: '625mg',
      manufacturer: 'GlaxoSmithKline',
      prescriptionRequired: true,
      narcotic: false,
      reorderLevel: 100,
      totalStock: 500,
      active: true,
    },
    {
      id: 2,
      code: 'MED-TEL40',
      brandName: 'Telma 40',
      genericName: 'Telmisartan',
      categoryId: 2,
      categoryName: 'Cardiovascular & Antihypertensives',
      dosageForm: 'TABLET',
      strength: '40mg',
      manufacturer: 'Glenmark Pharmaceuticals',
      prescriptionRequired: true,
      narcotic: false,
      reorderLevel: 150,
      totalStock: 800,
      active: true,
    },
    {
      id: 3,
      code: 'MED-PCM650',
      brandName: 'Dolo 650',
      genericName: 'Paracetamol',
      categoryId: 3,
      categoryName: 'Analgesics & NSAIDs',
      dosageForm: 'TABLET',
      strength: '650mg',
      manufacturer: 'Micro Labs Ltd',
      prescriptionRequired: false,
      narcotic: false,
      reorderLevel: 300,
      totalStock: 2500,
      active: true,
    },
  ]);

  const [searchQuery, setSearchQuery] = useState('');

  useEffect(() => {
    apiClient
      .get<ApiResponse<PagedResponse<Medicine>>>('/pharmacy/medicines', {
        params: { query: searchQuery || undefined },
      })
      .then((res) => {
        if (res.data?.success && res.data?.data?.content) {
          setMedicines(res.data.data.content);
        }
      })
      .catch(() => {});
  }, [searchQuery]);

  return (
    <div className="space-y-6">
      {/* Header */}
      <div className="flex flex-col sm:flex-row sm:items-center justify-between gap-4 bg-white p-6 rounded-3xl border border-slate-200 shadow-sm">
        <div>
          <h1 className="text-xl font-bold text-slate-900 tracking-tight flex items-center gap-2">
            <Pill className="h-6 w-6 text-sky-600" />
            Central Pharmacy & Dispensing Station
          </h1>
          <p className="text-xs text-slate-500 mt-1">
            Medicine catalog, FEFO batch stock inspection, expiry alerts, and prescription fulfillment
          </p>
        </div>
      </div>

      {/* Search Bar */}
      <div className="bg-white p-4 rounded-2xl border border-slate-200 shadow-sm">
        <div className="relative">
          <Search className="absolute left-3.5 top-1/2 -translate-y-1/2 h-4 w-4 text-slate-400" />
          <input
            type="text"
            placeholder="Search medicine brand name, generic formulation, or code..."
            value={searchQuery}
            onChange={(e) => setSearchQuery(e.target.value)}
            className="w-full pl-10 pr-4 py-2 bg-slate-50 border border-slate-200 rounded-xl text-xs focus:bg-white focus:outline-none focus:ring-2 focus:ring-sky-500"
          />
        </div>
      </div>

      {/* Medicine Catalog Grid */}
      <div className="bg-white rounded-3xl border border-slate-200 shadow-sm overflow-hidden">
        <div className="overflow-x-auto">
          <table className="w-full text-left text-xs">
            <thead className="bg-slate-50 text-slate-500 uppercase tracking-wider font-semibold border-b border-slate-200">
              <tr>
                <th className="py-3.5 px-4">Code</th>
                <th className="py-3.5 px-4">Brand / Generic Name</th>
                <th className="py-3.5 px-4">Category</th>
                <th className="py-3.5 px-4">Dosage Form & Strength</th>
                <th className="py-3.5 px-4">Manufacturer</th>
                <th className="py-3.5 px-4">Current Stock</th>
                <th className="py-3.5 px-4 text-right">Status</th>
              </tr>
            </thead>
            <tbody className="divide-y divide-slate-100">
              {medicines.map((m) => (
                <tr key={m.id} className="hover:bg-slate-50/80 transition-colors">
                  <td className="py-3.5 px-4 font-mono font-bold text-sky-700">{m.code}</td>
                  <td className="py-3.5 px-4">
                    <p className="font-semibold text-slate-900">{m.brandName}</p>
                    <span className="text-[10px] text-slate-500">{m.genericName}</span>
                  </td>
                  <td className="py-3.5 px-4 text-slate-600">{m.categoryName}</td>
                  <td className="py-3.5 px-4 text-slate-700">
                    {m.dosageForm} • <span className="font-semibold">{m.strength}</span>
                  </td>
                  <td className="py-3.5 px-4 text-slate-600">{m.manufacturer || 'Standard'}</td>
                  <td className="py-3.5 px-4">
                    <span className={`font-bold ${m.totalStock <= m.reorderLevel ? 'text-rose-600' : 'text-slate-900'}`}>
                      {m.totalStock} units
                    </span>
                    {m.totalStock <= m.reorderLevel && (
                      <span className="block text-[10px] text-rose-500 font-semibold">Low Stock Alert</span>
                    )}
                  </td>
                  <td className="py-3.5 px-4 text-right">
                    <span className="px-2.5 py-1 rounded-full text-[10px] font-bold bg-emerald-100 text-emerald-800">
                      In Stock
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
