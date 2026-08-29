import React, { useState, useEffect } from 'react';
import {
  HeartPulse,
  Search,
  Droplet,
  ShieldCheck,
  CheckCircle2,
  Calendar,
  AlertTriangle,
} from 'lucide-react';
import { apiClient } from '../api/client';
import { BloodStockSummary, ApiResponse } from '../types';

export const BloodBank: React.FC = () => {
  const [stockSummary, setStockSummary] = useState<BloodStockSummary[]>([
    { bloodGroup: 'O+', count: 18 },
    { bloodGroup: 'O-', count: 6 },
    { bloodGroup: 'A+', count: 14 },
    { bloodGroup: 'A-', count: 4 },
    { bloodGroup: 'B+', count: 16 },
    { bloodGroup: 'B-', count: 3 },
    { bloodGroup: 'AB+', count: 8 },
    { bloodGroup: 'AB-', count: 2 },
  ]);

  useEffect(() => {
    apiClient
      .get<ApiResponse<BloodStockSummary[]>>('/blood-bank/stock-summary')
      .then((res) => {
        if (res.data?.success && res.data?.data && res.data.data.length > 0) {
          setStockSummary(res.data.data);
        }
      })
      .catch(() => {});
  }, []);

  return (
    <div className="space-y-6">
      <div className="flex flex-col sm:flex-row sm:items-center justify-between gap-4 bg-white p-6 rounded-3xl border border-slate-200 shadow-sm">
        <div>
          <h1 className="text-xl font-bold text-slate-900 tracking-tight flex items-center gap-2">
            <HeartPulse className="h-6 w-6 text-rose-600" />
            Transfusion Medicine & Blood Bank Hub
          </h1>
          <p className="text-xs text-slate-500 mt-1">
            Refrigeration storage, donor registry, blood units inventory, testing, and cross-matching
          </p>
        </div>
      </div>

      {/* Blood Group Cards Grid */}
      <div className="grid grid-cols-2 sm:grid-cols-4 gap-4">
        {stockSummary.map((item) => (
          <div
            key={item.bloodGroup}
            className="p-5 bg-white rounded-3xl border border-rose-100 shadow-sm flex items-center justify-between hover:border-rose-300 transition-all"
          >
            <div>
              <span className="text-2xl font-black text-rose-600 font-mono">{item.bloodGroup}</span>
              <p className="text-xs font-semibold text-slate-700 mt-1">
                {item.count} Tested Bags
              </p>
              <span className="text-[10px] text-emerald-600 font-medium">Safe & Available</span>
            </div>
            <div className="h-12 w-12 rounded-2xl bg-rose-50 text-rose-600 flex items-center justify-center">
              <Droplet className="h-6 w-6" />
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};
