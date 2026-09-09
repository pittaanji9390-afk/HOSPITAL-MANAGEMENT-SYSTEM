import React, { useState } from 'react';
import {
  User,
  Calendar,
  FileText,
  CreditCard,
  Pill,
  Clock,
  ChevronRight,
  ShieldCheck,
} from 'lucide-react';

export const PatientPortalScreen: React.FC = () => {
  return (
    <div className="space-y-4 pb-20">
      {/* Patient Welcome Banner */}
      <div className="p-5 bg-gradient-to-br from-sky-600 to-sky-800 rounded-3xl text-white space-y-2 shadow-xl">
        <div className="flex items-center justify-between">
          <span className="text-[11px] font-bold bg-white/20 px-2.5 py-0.5 rounded-full">
            Patient Mobile Portal
          </span>
          <span className="text-[10px] font-mono text-sky-200">MRN-10001</span>
        </div>
        <h2 className="text-lg font-bold">Welcome back, Anand!</h2>
        <p className="text-xs text-sky-100">
          Next Appointment: <strong className="text-white">Cardiology Follow-Up</strong> with Dr. Rajesh Sharma on 05-Sep at 10:00 AM
        </p>
      </div>

      {/* Quick Access Tiles */}
      <div className="grid grid-cols-2 gap-3 text-xs font-bold">
        <div className="p-4 bg-slate-800 rounded-2xl border border-slate-700/80 space-y-2">
          <Calendar className="h-6 w-6 text-sky-400" />
          <div>
            <h4 className="text-white">Book Appointment</h4>
            <p className="text-[10px] text-slate-400 font-normal mt-0.5">Choose doctor & slot</p>
          </div>
        </div>

        <div className="p-4 bg-slate-800 rounded-2xl border border-slate-700/80 space-y-2">
          <FileText className="h-6 w-6 text-emerald-400" />
          <div>
            <h4 className="text-white">Diagnostic Reports</h4>
            <p className="text-[10px] text-slate-400 font-normal mt-0.5">Lab & Radiology results</p>
          </div>
        </div>

        <div className="p-4 bg-slate-800 rounded-2xl border border-slate-700/80 space-y-2">
          <Pill className="h-6 w-6 text-amber-400" />
          <div>
            <h4 className="text-white">Active Prescriptions</h4>
            <p className="text-[10px] text-slate-400 font-normal mt-0.5">5 active medications</p>
          </div>
        </div>

        <div className="p-4 bg-slate-800 rounded-2xl border border-slate-700/80 space-y-2">
          <CreditCard className="h-6 w-6 text-purple-400" />
          <div>
            <h4 className="text-white">Invoices & Bills</h4>
            <p className="text-[10px] text-slate-400 font-normal mt-0.5">Instant online payment</p>
          </div>
        </div>
      </div>

      {/* Active Medications Checklist */}
      <div className="p-4 bg-slate-800 rounded-2xl border border-slate-700/80 space-y-3">
        <h3 className="text-xs font-bold text-slate-200 uppercase tracking-wider">
          Today's Medication Schedule
        </h3>
        <div className="space-y-2 text-xs">
          {[
            { name: 'Telmisartan 40mg', time: '08:00 AM (Morning)', taken: true },
            { name: 'Aspirin 81mg', time: '08:00 AM (Morning)', taken: true },
            { name: 'Ticagrelor 90mg', time: '08:00 PM (Night)', taken: false },
            { name: 'Atorvastatin 80mg', time: '10:00 PM (Bedtime)', taken: false },
          ].map((med, idx) => (
            <div
              key={idx}
              className={`p-3 rounded-xl flex items-center justify-between border ${
                med.taken
                  ? 'bg-emerald-950/40 border-emerald-800/60 text-emerald-300'
                  : 'bg-slate-900 border-slate-700 text-slate-300'
              }`}
            >
              <div>
                <span className="font-bold text-white block">{med.name}</span>
                <span className="text-[10px] text-slate-400">{med.time}</span>
              </div>
              <span className={`px-2 py-0.5 rounded text-[10px] font-bold ${med.taken ? 'bg-emerald-900 text-emerald-200' : 'bg-slate-800 text-slate-400'}`}>
                {med.taken ? 'Taken' : 'Due'}
              </span>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};
