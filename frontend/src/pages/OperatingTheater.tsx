import React, { useState } from 'react';
import {
  Scissors,
  Calendar,
  Clock,
  User,
  Plus,
  CheckCircle2,
  AlertTriangle,
  Activity,
  FileCheck,
} from 'lucide-react';

interface SurgicalCase {
  id: number;
  caseNo: string;
  patientName: string;
  patientMrn: string;
  procedureName: string;
  operatingRoom: string;
  leadSurgeon: string;
  anesthesiologist: string;
  scheduledStartTime: string;
  durationMinutes: number;
  anesthesiaType: 'GENERAL' | 'SPINAL' | 'EPIDURAL' | 'LOCAL' | 'MAC';
  asaGrade: 'ASA_I' | 'ASA_II' | 'ASA_III' | 'ASA_IV' | 'ASA_V';
  status: 'SCHEDULED' | 'IN_THEATER' | 'RECOVERY' | 'COMPLETED';
}

export const OperatingTheater: React.FC = () => {
  const [cases, setCases] = useState<SurgicalCase[]>([
    {
      id: 1,
      caseNo: 'SURG-10001',
      patientName: 'Anand Patil',
      patientMrn: 'MRN-10001',
      procedureName: 'Coronary Artery Bypass Graft (CABG x 3 Vessels)',
      operatingRoom: 'OR Suite 1 (Cardiothoracic)',
      leadSurgeon: 'Dr. Rajesh Sharma',
      anesthesiologist: 'Dr. Vivek Mehra',
      scheduledStartTime: '08:00 AM',
      durationMinutes: 240,
      anesthesiaType: 'GENERAL',
      asaGrade: 'ASA_III',
      status: 'COMPLETED',
    },
    {
      id: 2,
      caseNo: 'SURG-10002',
      patientName: 'Deepa Rao',
      patientMrn: 'MRN-10002',
      procedureName: 'Arthroscopic Anterior Cruciate Ligament (ACL) Reconstruction',
      operatingRoom: 'OR Suite 2 (Orthopedics)',
      leadSurgeon: 'Dr. Priya Nair',
      anesthesiologist: 'Dr. Sunita Deshmukh',
      scheduledStartTime: '11:30 AM',
      durationMinutes: 90,
      anesthesiaType: 'SPINAL',
      asaGrade: 'ASA_I',
      status: 'IN_THEATER',
    },
    {
      id: 3,
      caseNo: 'SURG-10003',
      patientName: 'Vikram Singhania',
      patientMrn: 'MRN-10003',
      procedureName: 'Laparoscopic Cholecystectomy',
      operatingRoom: 'OR Suite 3 (Laparoscopy / GI)',
      leadSurgeon: 'Dr. Robert D\'Souza',
      anesthesiologist: 'Dr. Vivek Mehra',
      scheduledStartTime: '02:00 PM',
      durationMinutes: 60,
      anesthesiaType: 'GENERAL',
      asaGrade: 'ASA_II',
      status: 'SCHEDULED',
    },
  ]);

  return (
    <div className="space-y-6">
      {/* Header */}
      <div className="flex flex-col sm:flex-row sm:items-center justify-between gap-4 bg-white p-6 rounded-3xl border border-slate-200 shadow-sm">
        <div>
          <h1 className="text-xl font-bold text-slate-900 tracking-tight flex items-center gap-2">
            <Scissors className="h-6 w-6 text-sky-600" />
            Operating Theaters & Surgical Suite Management
          </h1>
          <p className="text-xs text-slate-500 mt-1">
            OR suite scheduling, WHO Surgical Safety Checklists, anesthesia records, and PACU recovery
          </p>
        </div>
      </div>

      {/* OR Suites Status */}
      <div className="grid grid-cols-1 md:grid-cols-3 gap-4">
        {['OR Suite 1 (Cardio)', 'OR Suite 2 (Ortho)', 'OR Suite 3 (Lap/GI)'].map((orName, i) => (
          <div key={i} className="p-4 bg-white rounded-2xl border border-slate-200 shadow-sm space-y-2">
            <div className="flex items-center justify-between">
              <span className="text-xs font-bold text-slate-900">{orName}</span>
              <span className={`h-2.5 w-2.5 rounded-full ${i === 1 ? 'bg-rose-500 animate-pulse' : 'bg-emerald-500'}`} />
            </div>
            <p className="text-[11px] text-slate-500">
              {i === 1 ? 'Procedure in Progress (Deepa Rao)' : 'Cleaned & Ready for Next Case'}
            </p>
          </div>
        ))}
      </div>

      {/* Surgical Schedule Table */}
      <div className="bg-white rounded-3xl border border-slate-200 shadow-sm overflow-hidden">
        <div className="overflow-x-auto">
          <table className="w-full text-left text-xs">
            <thead className="bg-slate-50 text-slate-500 uppercase tracking-wider font-semibold border-b border-slate-200">
              <tr>
                <th className="py-3.5 px-4">Case / MRN</th>
                <th className="py-3.5 px-4">Procedure Description</th>
                <th className="py-3.5 px-4">OR Suite</th>
                <th className="py-3.5 px-4">Surgical Team</th>
                <th className="py-3.5 px-4">Anesthesia / ASA</th>
                <th className="py-3.5 px-4">Time & Duration</th>
                <th className="py-3.5 px-4 text-right">Status</th>
              </tr>
            </thead>
            <tbody className="divide-y divide-slate-100">
              {cases.map((c) => {
                const statusBadge =
                  c.status === 'IN_THEATER'
                    ? 'bg-rose-100 text-rose-800'
                    : c.status === 'SCHEDULED'
                    ? 'bg-sky-100 text-sky-800'
                    : 'bg-emerald-100 text-emerald-800';

                return (
                  <tr key={c.id} className="hover:bg-slate-50/80 transition-colors">
                    <td className="py-3.5 px-4">
                      <span className="font-mono font-bold text-sky-700">{c.caseNo}</span>
                      <p className="font-semibold text-slate-900 mt-0.5">{c.patientName}</p>
                      <span className="text-[10px] text-slate-400 font-mono">{c.patientMrn}</span>
                    </td>
                    <td className="py-3.5 px-4 font-semibold text-slate-900 max-w-xs">{c.procedureName}</td>
                    <td className="py-3.5 px-4 text-slate-700 font-medium">{c.operatingRoom}</td>
                    <td className="py-3.5 px-4">
                      <p className="font-semibold text-slate-800">{c.leadSurgeon}</p>
                      <span className="text-[10px] text-slate-500 font-medium">
                        Anesthesia: {c.anesthesiologist}
                      </span>
                    </td>
                    <td className="py-3.5 px-4">
                      <span className="px-2 py-0.5 rounded text-[10px] font-bold bg-slate-100 text-slate-800">
                        {c.anesthesiaType} • {c.asaGrade}
                      </span>
                    </td>
                    <td className="py-3.5 px-4 text-slate-700">
                      <p className="font-medium">{c.scheduledStartTime}</p>
                      <span className="text-[10px] text-slate-500">{c.durationMinutes} mins estimated</span>
                    </td>
                    <td className="py-3.5 px-4 text-right">
                      <span className={`px-2.5 py-1 rounded-full text-[10px] font-bold ${statusBadge}`}>
                        {c.status}
                      </span>
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
