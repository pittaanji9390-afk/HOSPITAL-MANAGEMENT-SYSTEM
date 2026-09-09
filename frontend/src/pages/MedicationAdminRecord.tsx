import React, { useState } from 'react';
import {
  Pill,
  Clock,
  CheckCircle2,
  AlertTriangle,
  Barcode,
  User,
  ShieldCheck,
  Search,
} from 'lucide-react';

interface EmarSchedule {
  id: number;
  patientName: string;
  patientMrn: string;
  bedNumber: string;
  medicineName: string;
  dose: string;
  route: string;
  scheduledTime: string;
  administeredTime?: string;
  administeredBy?: string;
  status: 'DUE' | 'ADMINISTERED' | 'HELD' | 'REFUSED';
  instructions?: string;
}

export const MedicationAdminRecord: React.FC = () => {
  const [schedules, setSchedules] = useState<EmarSchedule[]>([
    {
      id: 1,
      patientName: 'Anand Patil',
      patientMrn: 'MRN-10001',
      bedNumber: 'BED-CCU-01',
      medicineName: 'Telma 40 (Telmisartan)',
      dose: '40mg (1 Tablet)',
      route: 'ORAL',
      scheduledTime: '08:00 AM',
      administeredTime: '08:05 AM',
      administeredBy: 'Sarah Mathew (Staff Nurse)',
      status: 'ADMINISTERED',
      instructions: 'Give with water after breakfast',
    },
    {
      id: 2,
      patientName: 'Anand Patil',
      patientMrn: 'MRN-10001',
      bedNumber: 'BED-CCU-01',
      medicineName: 'Atorva 20 (Atorvastatin)',
      dose: '20mg (1 Tablet)',
      route: 'ORAL',
      scheduledTime: '10:00 PM',
      status: 'DUE',
      instructions: 'Bedtime dose',
    },
    {
      id: 3,
      patientName: 'Deepa Rao',
      patientMrn: 'MRN-10002',
      bedNumber: 'BED-FGW-01',
      medicineName: 'Augmentin 625 (Amox-Clav)',
      dose: '625mg (1 Tablet)',
      route: 'ORAL',
      scheduledTime: '02:00 PM',
      status: 'DUE',
      instructions: 'Post-operative antibiotic prophylaxis',
    },
  ]);

  const handleAdminister = (id: number) => {
    setSchedules(
      schedules.map((s) => {
        if (s.id === id) {
          return {
            ...s,
            status: 'ADMINISTERED',
            administeredTime: new Date().toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' }),
            administeredBy: 'Sarah Mathew (Staff Nurse)',
          };
        }
        return s;
      })
    );
  };

  return (
    <div className="space-y-6">
      {/* Header */}
      <div className="flex flex-col sm:flex-row sm:items-center justify-between gap-4 bg-white p-6 rounded-3xl border border-slate-200 shadow-sm">
        <div>
          <h1 className="text-xl font-bold text-slate-900 tracking-tight flex items-center gap-2">
            <Pill className="h-6 w-6 text-sky-600" />
            Electronic Medication Administration Record (eMAR)
          </h1>
          <p className="text-xs text-slate-500 mt-1">
            Nurse barcode verification, 5 Rights of Medication Administration, and shift dosing ledger
          </p>
        </div>

        <div className="flex items-center gap-2 px-3 py-1.5 bg-emerald-50 text-emerald-800 border border-emerald-200 rounded-xl text-xs font-semibold">
          <ShieldCheck className="h-4 w-4 text-emerald-600" />
          <span>Barcode Scanner Active</span>
        </div>
      </div>

      {/* Dosing Grid */}
      <div className="bg-white rounded-3xl border border-slate-200 shadow-sm overflow-hidden">
        <div className="overflow-x-auto">
          <table className="w-full text-left text-xs">
            <thead className="bg-slate-50 text-slate-500 uppercase tracking-wider font-semibold border-b border-slate-200">
              <tr>
                <th className="py-3.5 px-4">Patient / Location</th>
                <th className="py-3.5 px-4">Medication & Dose</th>
                <th className="py-3.5 px-4">Route</th>
                <th className="py-3.5 px-4">Scheduled Time</th>
                <th className="py-3.5 px-4">Administration Record</th>
                <th className="py-3.5 px-4">Status</th>
                <th className="py-3.5 px-4 text-right">Nurse Action</th>
              </tr>
            </thead>
            <tbody className="divide-y divide-slate-100">
              {schedules.map((s) => {
                const statusBadge =
                  s.status === 'ADMINISTERED'
                    ? 'bg-emerald-100 text-emerald-800'
                    : s.status === 'DUE'
                    ? 'bg-amber-100 text-amber-800'
                    : 'bg-rose-100 text-rose-800';

                return (
                  <tr key={s.id} className="hover:bg-slate-50/80 transition-colors">
                    <td className="py-3.5 px-4">
                      <p className="font-semibold text-slate-900">{s.patientName}</p>
                      <span className="text-[10px] text-slate-400 font-mono">
                        {s.patientMrn} • <span className="text-sky-700 font-bold">{s.bedNumber}</span>
                      </span>
                    </td>
                    <td className="py-3.5 px-4">
                      <p className="font-bold text-slate-900">{s.medicineName}</p>
                      <span className="text-[11px] text-slate-600">{s.dose}</span>
                      {s.instructions && (
                        <p className="text-[10px] text-slate-400 mt-0.5">{s.instructions}</p>
                      )}
                    </td>
                    <td className="py-3.5 px-4">
                      <span className="px-2 py-0.5 rounded text-[10px] font-bold bg-slate-100 text-slate-700">
                        {s.route}
                      </span>
                    </td>
                    <td className="py-3.5 px-4 font-semibold text-slate-800">{s.scheduledTime}</td>
                    <td className="py-3.5 px-4">
                      {s.administeredTime ? (
                        <div>
                          <p className="font-semibold text-emerald-700">Given at {s.administeredTime}</p>
                          <span className="text-[10px] text-slate-500">{s.administeredBy}</span>
                        </div>
                      ) : (
                        <span className="text-slate-400">Not administered yet</span>
                      )}
                    </td>
                    <td className="py-3.5 px-4">
                      <span className={`px-2.5 py-1 rounded-full text-[10px] font-bold ${statusBadge}`}>
                        {s.status}
                      </span>
                    </td>
                    <td className="py-3.5 px-4 text-right">
                      {s.status === 'DUE' && (
                        <button
                          onClick={() => handleAdminister(s.id)}
                          className="px-3 py-1.5 bg-emerald-600 hover:bg-emerald-500 text-white rounded-xl font-bold text-xs shadow-sm transition-colors"
                        >
                          Verify & Give
                        </button>
                      )}
                    </td>
                  </tr>
                );
              })}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
};
