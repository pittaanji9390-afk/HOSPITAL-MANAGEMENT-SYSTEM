import React, { useState } from 'react';
import { DollarSign, FileCheck, AlertCircle, CreditCard, PieChart, ShieldCheck, ArrowUpRight, TrendingUp } from 'lucide-react';

export const HospitalBillingRevenueCycle: React.FC = () => {
  const [filter, setFilter] = useState('all');

  const claims = [
    { id: 'CLM-84920', patient: 'Ananya Deshmukh', payer: 'Star Health Insurance', amount: '₹1,45,800', drg: 'DRG-470 (Major Joint Replacement)', status: 'Approved', scrubScore: 98 },
    { id: 'CLM-84921', patient: 'Rohan Banerjee', payer: 'HDFC ERGO Health', amount: '₹3,20,500', drg: 'DRG-247 (Percutaneous CV with DES)', status: 'In Review', scrubScore: 92 },
    { id: 'CLM-84922', patient: 'Meenakshi Sundaram', payer: 'Ayushman Bharat (PM-JAY)', amount: '₹65,000', drg: 'DRG-194 (Pneumonia with CC)', status: 'Approved', scrubScore: 100 },
    { id: 'CLM-84923', patient: 'Farhan Zaidi', payer: 'Max Bupa Health', amount: '₹88,200', drg: 'DRG-392 (Esophagitis / GI Disorders)', status: 'Pre-Auth Pending', scrubScore: 84 },
  ];

  return (
    <div className="space-y-6">
      <div className="bg-slate-900 text-white p-6 rounded-2xl border border-slate-800 shadow-xl flex justify-between items-center">
        <div>
          <div className="flex items-center gap-3">
            <DollarSign className="w-8 h-8 text-emerald-400" />
            <h1 className="text-2xl font-bold">Revenue Cycle Management (RCM) & Claims Adjudication</h1>
          </div>
          <p className="text-slate-400 text-sm mt-1">Automated ANSI X12 837 / 835 Claim Scrubbing, DRG Classification & Split-Billing Ledger</p>
        </div>
        <div className="flex gap-4">
          <div className="bg-slate-800 px-4 py-2 rounded-xl border border-slate-700 text-center">
            <span className="text-xs text-slate-400 block">Clean Claim Rate</span>
            <span className="text-lg font-bold text-emerald-400">97.4%</span>
          </div>
          <div className="bg-slate-800 px-4 py-2 rounded-xl border border-slate-700 text-center">
            <span className="text-xs text-slate-400 block">Days in AR</span>
            <span className="text-lg font-bold text-indigo-400">21.8 Days</span>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-3 gap-4">
        <div className="bg-white p-5 rounded-2xl border border-slate-200 shadow-sm">
          <span className="text-xs text-slate-500 font-semibold uppercase">Total Claims Submitted (Month)</span>
          <p className="text-2xl font-bold text-slate-900 mt-1">₹42,85,400</p>
          <span className="text-xs text-emerald-600 flex items-center gap-1 mt-1 font-semibold">
            <TrendingUp className="w-3.5 h-3.5" /> +12.4% vs previous month
          </span>
        </div>
        <div className="bg-white p-5 rounded-2xl border border-slate-200 shadow-sm">
          <span className="text-xs text-slate-500 font-semibold uppercase">Pre-Authorization Turnaround</span>
          <p className="text-2xl font-bold text-slate-900 mt-1">4.2 Hours</p>
          <span className="text-xs text-indigo-600 block mt-1">AI-assisted clinical criteria validation</span>
        </div>
        <div className="bg-white p-5 rounded-2xl border border-slate-200 shadow-sm">
          <span className="text-xs text-slate-500 font-semibold uppercase">First-Pass Acceptance</span>
          <p className="text-2xl font-bold text-slate-900 mt-1">94.8%</p>
          <span className="text-xs text-emerald-600 block mt-1">Zero medical necessity denials this week</span>
        </div>
      </div>

      <div className="bg-white rounded-2xl border border-slate-200 shadow-sm p-6 space-y-4">
        <h3 className="font-bold text-base text-slate-900">Active Insurance Claims Queue</h3>
        <div className="overflow-x-auto">
          <table className="w-full text-left text-xs">
            <thead className="bg-slate-50 text-slate-600 uppercase font-semibold border-b border-slate-200">
              <tr>
                <th className="p-3">Claim ID</th>
                <th className="p-3">Patient Name</th>
                <th className="p-3">TPA / Payer</th>
                <th className="p-3">DRG Category</th>
                <th className="p-3">Claim Amount</th>
                <th className="p-3">Scrub Score</th>
                <th className="p-3">Status</th>
              </tr>
            </thead>
            <tbody className="divide-y divide-slate-100">
              {claims.map(c => (
                <tr key={c.id} className="hover:bg-slate-50 transition-colors">
                  <td className="p-3 font-bold text-slate-900">{c.id}</td>
                  <td className="p-3 font-semibold text-slate-800">{c.patient}</td>
                  <td className="p-3 text-slate-600">{c.payer}</td>
                  <td className="p-3 text-slate-500">{c.drg}</td>
                  <td className="p-3 font-bold text-slate-900">{c.amount}</td>
                  <td className="p-3">
                    <span className="px-2 py-0.5 rounded-full bg-emerald-100 text-emerald-800 font-bold">{c.scrubScore}%</span>
                  </td>
                  <td className="p-3">
                    <span className={`px-2.5 py-1 rounded-full font-semibold ${
                      c.status === 'Approved' ? 'bg-emerald-100 text-emerald-800' : 'bg-amber-100 text-amber-800'
                    }`}>{c.status}</span>
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
