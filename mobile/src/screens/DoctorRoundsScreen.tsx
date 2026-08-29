import React, { useState } from 'react';
import {
  User,
  BedDouble,
  FileText,
  Pill,
  CheckCircle2,
  ChevronRight,
  Stethoscope,
  Clock,
} from 'lucide-react';

interface InpatientRound {
  id: number;
  name: string;
  mrn: string;
  location: string;
  diagnosis: string;
  dayOfAdmission: number;
  status: 'PENDING_ROUND' | 'SEEN';
}

export const DoctorRoundsScreen: React.FC = () => {
  const [patients, setPatients] = useState<InpatientRound[]>([
    {
      id: 1,
      name: 'Anand Patil',
      mrn: 'MRN-10001',
      location: 'CCU-301 / Bed 1',
      diagnosis: 'STEMI Anterior Wall (Post-PCI Day 3)',
      dayOfAdmission: 3,
      status: 'SEEN',
    },
    {
      id: 2,
      name: 'Deepa Rao',
      mrn: 'MRN-10002',
      location: 'FGW-102 / Bed 4',
      diagnosis: 'ACL Reconstruction (Post-Op Day 1)',
      dayOfAdmission: 1,
      status: 'PENDING_ROUND',
    },
    {
      id: 3,
      name: 'Vikram Singhania',
      mrn: 'MRN-10003',
      location: 'MGW-204 / Bed 2',
      diagnosis: 'Laparoscopic Cholecystectomy',
      dayOfAdmission: 2,
      status: 'PENDING_ROUND',
    },
  ]);

  const markSeen = (id: number) => {
    setPatients(
      patients.map((p) => (p.id === id ? { ...p, status: 'SEEN' } : p))
    );
  };

  return (
    <div className="space-y-4 pb-20">
      {/* Header */}
      <div className="p-4 bg-slate-800/80 border border-slate-700/80 rounded-2xl flex items-center justify-between">
        <div>
          <h2 className="text-sm font-bold text-white flex items-center gap-2">
            <Stethoscope className="h-4 w-4 text-sky-400" />
            Inpatient Morning Rounds
          </h2>
          <p className="text-[11px] text-slate-400 mt-0.5">
            {patients.filter((p) => p.status === 'SEEN').length} of {patients.length} patients seen
          </p>
        </div>
      </div>

      {/* Patient Cards */}
      <div className="space-y-3">
        {patients.map((p) => (
          <div
            key={p.id}
            className="p-4 bg-slate-800 rounded-2xl border border-slate-700/80 space-y-3"
          >
            <div className="flex items-start justify-between">
              <div>
                <span className="text-[10px] font-mono text-sky-400 font-bold">{p.mrn}</span>
                <h3 className="text-sm font-bold text-white mt-0.5">{p.name}</h3>
                <p className="text-[11px] text-slate-300 font-medium mt-0.5">{p.diagnosis}</p>
                <span className="text-[10px] text-slate-500 font-medium">
                  {p.location} • Day {p.dayOfAdmission} of Admission
                </span>
              </div>

              <span
                className={`px-2.5 py-1 rounded-full text-[10px] font-bold ${
                  p.status === 'SEEN'
                    ? 'bg-emerald-950 text-emerald-300 border border-emerald-800'
                    : 'bg-amber-950 text-amber-300 border border-amber-800'
                }`}
              >
                {p.status === 'SEEN' ? 'Seen' : 'Pending'}
              </span>
            </div>

            <div className="pt-3 border-t border-slate-700/60 flex items-center justify-between gap-2">
              <button className="flex-1 py-2 bg-slate-900 active:bg-slate-700 text-slate-200 rounded-xl text-xs font-semibold flex items-center justify-center gap-1.5">
                <FileText className="h-3.5 w-3.5 text-sky-400" />
                SOAP Note
              </button>
              <button className="flex-1 py-2 bg-slate-900 active:bg-slate-700 text-slate-200 rounded-xl text-xs font-semibold flex items-center justify-center gap-1.5">
                <Pill className="h-3.5 w-3.5 text-emerald-400" />
                Rx Orders
              </button>
              {p.status === 'PENDING_ROUND' && (
                <button
                  onClick={() => markSeen(p.id)}
                  className="px-3 py-2 bg-sky-600 active:bg-sky-500 text-white rounded-xl text-xs font-bold"
                >
                  Mark Seen
                </button>
              )}
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};
