import React from 'react';
import {
  Settings as SettingsIcon,
  Building2,
  Lock,
  Hash,
  Shield,
  Clock,
  Coins,
  CheckCircle2,
} from 'lucide-react';

export const Settings: React.FC = () => {
  return (
    <div className="space-y-6">
      <div className="bg-white p-6 rounded-3xl border border-slate-200 shadow-sm">
        <h1 className="text-xl font-bold text-slate-900 tracking-tight flex items-center gap-2">
          <SettingsIcon className="h-6 w-6 text-sky-600" />
          System Configuration & Hospital Profile
        </h1>
        <p className="text-xs text-slate-500 mt-1">
          Hospital metadata, sequence numbering generators, currency, and security parameters
        </p>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
        {/* Hospital Details Card */}
        <div className="bg-white p-6 rounded-3xl border border-slate-200 shadow-sm space-y-4">
          <div className="flex items-center gap-2 text-slate-900 font-bold text-sm">
            <Building2 className="h-4 w-4 text-sky-600" />
            Registered Hospital Profile
          </div>
          <div className="space-y-3 text-xs">
            <div>
              <span className="text-slate-400 font-semibold uppercase text-[10px]">Hospital Name</span>
              <p className="font-bold text-slate-900 mt-0.5">Apex Memorial Super-Speciality Hospital</p>
            </div>
            <div>
              <span className="text-slate-400 font-semibold uppercase text-[10px]">Branch Identifier</span>
              <p className="font-semibold text-slate-800 mt-0.5">AMSSH-01 (Bengaluru Central)</p>
            </div>
            <div>
              <span className="text-slate-400 font-semibold uppercase text-[10px]">Physical Address</span>
              <p className="text-slate-700 mt-0.5">45 Healthcare Boulevard, Medical Enclave, Bengaluru, KA 560029</p>
            </div>
            <div>
              <span className="text-slate-400 font-semibold uppercase text-[10px]">Emergency Hotline</span>
              <p className="font-bold text-rose-600 mt-0.5">+91-80-4958-3999</p>
            </div>
          </div>
        </div>

        {/* Numbering Sequences Card */}
        <div className="bg-white p-6 rounded-3xl border border-slate-200 shadow-sm space-y-4">
          <div className="flex items-center gap-2 text-slate-900 font-bold text-sm">
            <Hash className="h-4 w-4 text-sky-600" />
            Collision-Free Sequence Generators
          </div>
          <div className="grid grid-cols-2 gap-3 text-xs font-mono">
            <div className="p-3 bg-slate-50 rounded-2xl border border-slate-100">
              <span className="text-[10px] text-slate-400 font-sans font-semibold">PATIENT MRN</span>
              <p className="font-bold text-sky-700 mt-1">MRN-10001</p>
            </div>
            <div className="p-3 bg-slate-50 rounded-2xl border border-slate-100">
              <span className="text-[10px] text-slate-400 font-sans font-semibold">INVOICE NO</span>
              <p className="font-bold text-sky-700 mt-1">INV-10001</p>
            </div>
            <div className="p-3 bg-slate-50 rounded-2xl border border-slate-100">
              <span className="text-[10px] text-slate-400 font-sans font-semibold">APPOINTMENT NO</span>
              <p className="font-bold text-sky-700 mt-1">APT-10001</p>
            </div>
            <div className="p-3 bg-slate-50 rounded-2xl border border-slate-100">
              <span className="text-[10px] text-slate-400 font-sans font-semibold">PRESCRIPTION NO</span>
              <p className="font-bold text-sky-700 mt-1">RX-10001</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};
