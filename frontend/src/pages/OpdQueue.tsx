import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import {
  UserCheck,
  Search,
  Clock,
  ArrowRight,
  Eye,
  AlertCircle,
  CheckCircle,
  FileText,
  Stethoscope,
} from 'lucide-react';
import { apiClient } from '../api/client';
import { OpdEncounter, PagedResponse, ApiResponse } from '../types';

export const OpdQueue: React.FC = () => {
  const navigate = useNavigate();
  const [encounters, setEncounters] = useState<OpdEncounter[]>([
    {
      id: 1,
      encounterNo: 'OPD-10001',
      patientId: 1,
      patientName: 'Anand Patil',
      patientMrn: 'MRN-10001',
      patientPhone: '+91-98450-12345',
      doctorId: 1,
      doctorName: 'Dr. Rajesh Sharma',
      departmentId: 1,
      departmentName: 'Cardiology',
      encounterDate: new Date().toISOString(),
      triagePriority: 'ROUTINE',
      chiefComplaint: 'Post-CABG evaluation and blood pressure check',
      status: 'WAITING',
    },
    {
      id: 2,
      encounterNo: 'OPD-10002',
      patientId: 2,
      patientName: 'Deepa Rao',
      patientMrn: 'MRN-10002',
      patientPhone: '+91-98800-44221',
      doctorId: 2,
      doctorName: 'Dr. Priya Nair',
      departmentId: 2,
      departmentName: 'Orthopedics',
      encounterDate: new Date().toISOString(),
      triagePriority: 'PRIORITY',
      chiefComplaint: 'Left shoulder restricted range of motion & pain',
      status: 'WITH_DOCTOR',
    },
  ]);

  useEffect(() => {
    apiClient
      .get<ApiResponse<PagedResponse<OpdEncounter>>>('/opd')
      .then((res) => {
        if (res.data?.success && res.data?.data?.content) {
          setEncounters(res.data.data.content);
        }
      })
      .catch(() => {});
  }, []);

  const handleStatusChange = (id: number, status: OpdEncounter['status']) => {
    apiClient.patch(`/opd/${id}`, null, { params: { status } }).catch(() => {});
    setEncounters(encounters.map((e) => (e.id === id ? { ...e, status } : e)));
  };

  return (
    <div className="space-y-6">
      <div className="flex flex-col sm:flex-row sm:items-center justify-between gap-4 bg-white p-6 rounded-3xl border border-slate-200 shadow-sm">
        <div>
          <h1 className="text-xl font-bold text-slate-900 tracking-tight flex items-center gap-2">
            <UserCheck className="h-6 w-6 text-sky-600" />
            Outpatient (OPD) Consultation Queue
          </h1>
          <p className="text-xs text-slate-500 mt-1">
            Real-time clinic waiting queue, triage prioritization, and consultation workflow
          </p>
        </div>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-3 gap-6">
        {/* Waiting Column */}
        <div className="bg-slate-100/80 p-4 rounded-3xl border border-slate-200/80 flex flex-col space-y-3">
          <div className="flex items-center justify-between px-2">
            <span className="text-xs font-bold text-slate-700 uppercase tracking-wider">
              Waiting ({encounters.filter((e) => e.status === 'WAITING').length})
            </span>
            <span className="h-2 w-2 rounded-full bg-amber-500"></span>
          </div>

          <div className="space-y-3">
            {encounters
              .filter((e) => e.status === 'WAITING')
              .map((enc) => (
                <div
                  key={enc.id}
                  className="bg-white p-4 rounded-2xl border border-slate-200 shadow-sm space-y-3 hover:border-sky-300 transition-all"
                >
                  <div className="flex items-center justify-between">
                    <span className="text-xs font-mono font-bold text-sky-700">{enc.encounterNo}</span>
                    <span className="px-2 py-0.5 rounded text-[10px] font-bold bg-amber-100 text-amber-800">
                      {enc.triagePriority}
                    </span>
                  </div>
                  <div>
                    <h4 className="text-xs font-bold text-slate-900">{enc.patientName}</h4>
                    <p className="text-[11px] text-slate-400 font-mono">{enc.patientMrn}</p>
                    <p className="text-xs text-slate-600 mt-1.5 line-clamp-2">{enc.chiefComplaint}</p>
                  </div>
                  <div className="pt-2 border-t border-slate-100 flex items-center justify-between">
                    <span className="text-[10px] text-slate-500 font-medium">{enc.doctorName}</span>
                    <button
                      onClick={() => handleStatusChange(enc.id, 'WITH_DOCTOR')}
                      className="px-3 py-1 bg-sky-600 hover:bg-sky-500 text-white rounded-lg text-xs font-semibold flex items-center gap-1"
                    >
                      Call In <ArrowRight className="h-3 w-3" />
                    </button>
                  </div>
                </div>
              ))}
          </div>
        </div>

        {/* With Doctor Column */}
        <div className="bg-sky-50/60 p-4 rounded-3xl border border-sky-200/80 flex flex-col space-y-3">
          <div className="flex items-center justify-between px-2">
            <span className="text-xs font-bold text-sky-900 uppercase tracking-wider">
              In Consultation ({encounters.filter((e) => e.status === 'WITH_DOCTOR').length})
            </span>
            <span className="h-2 w-2 rounded-full bg-sky-500 animate-pulse"></span>
          </div>

          <div className="space-y-3">
            {encounters
              .filter((e) => e.status === 'WITH_DOCTOR')
              .map((enc) => (
                <div
                  key={enc.id}
                  className="bg-white p-4 rounded-2xl border border-sky-300 shadow-md space-y-3"
                >
                  <div className="flex items-center justify-between">
                    <span className="text-xs font-mono font-bold text-sky-700">{enc.encounterNo}</span>
                    <span className="px-2 py-0.5 rounded text-[10px] font-bold bg-sky-100 text-sky-800">
                      With Doctor
                    </span>
                  </div>
                  <div>
                    <h4 className="text-xs font-bold text-slate-900">{enc.patientName}</h4>
                    <p className="text-[11px] text-slate-400 font-mono">{enc.patientMrn}</p>
                    <p className="text-xs text-slate-600 mt-1.5">{enc.chiefComplaint}</p>
                  </div>
                  <div className="pt-2 border-t border-slate-100 flex items-center justify-between">
                    <button
                      onClick={() => navigate(`/patients/${enc.patientId}`)}
                      className="text-xs font-semibold text-sky-600 hover:text-sky-700 flex items-center gap-1"
                    >
                      <Eye className="h-3.5 w-3.5" /> Open EMR
                    </button>
                    <button
                      onClick={() => handleStatusChange(enc.id, 'COMPLETED')}
                      className="px-3 py-1 bg-emerald-600 hover:bg-emerald-500 text-white rounded-lg text-xs font-semibold"
                    >
                      Complete Consult
                    </button>
                  </div>
                </div>
              ))}
          </div>
        </div>

        {/* Completed Column */}
        <div className="bg-slate-100/80 p-4 rounded-3xl border border-slate-200/80 flex flex-col space-y-3">
          <div className="flex items-center justify-between px-2">
            <span className="text-xs font-bold text-slate-700 uppercase tracking-wider">
              Completed Today ({encounters.filter((e) => e.status === 'COMPLETED').length})
            </span>
            <span className="h-2 w-2 rounded-full bg-emerald-500"></span>
          </div>

          <div className="space-y-3">
            {encounters
              .filter((e) => e.status === 'COMPLETED')
              .map((enc) => (
                <div
                  key={enc.id}
                  className="bg-white/80 p-4 rounded-2xl border border-slate-200 opacity-80 space-y-2"
                >
                  <div className="flex items-center justify-between">
                    <span className="text-xs font-mono font-semibold text-slate-600">{enc.encounterNo}</span>
                    <CheckCircle className="h-4 w-4 text-emerald-500" />
                  </div>
                  <h4 className="text-xs font-bold text-slate-800">{enc.patientName}</h4>
                  <p className="text-[11px] text-slate-500">{enc.doctorName}</p>
                </div>
              ))}
          </div>
        </div>
      </div>
    </div>
  );
};
