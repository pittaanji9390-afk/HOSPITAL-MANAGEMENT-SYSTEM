import React, { useState, useEffect } from 'react';
import {
  BedDouble,
  Plus,
  ArrowRight,
  Filter,
  CheckCircle2,
  AlertTriangle,
  LogOut,
  User,
  Activity,
  X,
} from 'lucide-react';
import { apiClient } from '../api/client';
import { Bed, IpdAdmission, PagedResponse, ApiResponse } from '../types';

export const IpdWards: React.FC = () => {
  const [beds, setBeds] = useState<Bed[]>([
    { id: 1, bedNumber: 'BED-MGW-01', roomId: 1, roomNumber: 'MGW-101', wardId: 1, wardName: 'Male General Ward (North)', ratePerDay: 1200, status: 'OCCUPIED' },
    { id: 2, bedNumber: 'BED-MGW-02', roomId: 1, roomNumber: 'MGW-101', wardId: 1, wardName: 'Male General Ward (North)', ratePerDay: 1200, status: 'AVAILABLE' },
    { id: 3, bedNumber: 'BED-MGW-03', roomId: 1, roomNumber: 'MGW-101', wardId: 1, wardName: 'Male General Ward (North)', ratePerDay: 1200, status: 'AVAILABLE' },
    { id: 4, bedNumber: 'BED-FGW-01', roomId: 2, roomNumber: 'FGW-201', wardId: 2, wardName: 'Female General Ward (South)', ratePerDay: 1200, status: 'OCCUPIED' },
    { id: 5, bedNumber: 'BED-FGW-02', roomId: 2, roomNumber: 'FGW-201', wardId: 2, wardName: 'Female General Ward (South)', ratePerDay: 1200, status: 'CLEANING' },
    { id: 6, bedNumber: 'BED-CCU-01', roomId: 3, roomNumber: 'CCU-301', wardId: 3, wardName: 'Coronary Intensive Care Unit (CCU)', ratePerDay: 8500, status: 'OCCUPIED' },
    { id: 7, bedNumber: 'BED-CCU-02', roomId: 3, roomNumber: 'CCU-301', wardId: 3, wardName: 'Coronary Intensive Care Unit (CCU)', ratePerDay: 8500, status: 'AVAILABLE' },
    { id: 8, bedNumber: 'BED-STE-401', roomId: 4, roomNumber: 'STE-401', wardId: 4, wardName: 'Executive Deluxe Suites', ratePerDay: 6500, status: 'AVAILABLE' },
  ]);

  const [admissions, setAdmissions] = useState<IpdAdmission[]>([
    {
      id: 1,
      admissionNo: 'IPD-10001',
      patientId: 1,
      patientName: 'Anand Patil',
      patientMrn: 'MRN-10001',
      patientPhone: '+91-98450-12345',
      primaryDoctorId: 1,
      primaryDoctorName: 'Dr. Rajesh Sharma',
      departmentId: 1,
      departmentName: 'Cardiology',
      wardId: 3,
      wardName: 'Coronary Intensive Care Unit (CCU)',
      bedId: 6,
      bedNumber: 'BED-CCU-01',
      roomNumber: 'CCU-301',
      admissionDate: '2026-08-27T14:30:00Z',
      admissionType: 'PLANNED',
      admissionReason: 'Severe Unstable Angina pectoris requiring continuous telemetry',
      provisionalDiagnosis: 'Non-ST Elevation Myocardial Infarction (NSTEMI)',
      status: 'ADMITTED',
    },
  ]);

  const [isAdmitModalOpen, setIsAdmitModalOpen] = useState(false);
  const [selectedWardFilter, setSelectedWardFilter] = useState<string>('ALL');

  useEffect(() => {
    apiClient
      .get<ApiResponse<PagedResponse<IpdAdmission>>>('/ipd/admissions')
      .then((res) => {
        if (res.data?.success && res.data?.data?.content) {
          setAdmissions(res.data.data.content);
        }
      })
      .catch(() => {});
  }, []);

  const filteredBeds =
    selectedWardFilter === 'ALL'
      ? beds
      : beds.filter((b) => b.wardName.includes(selectedWardFilter));

  return (
    <div className="space-y-6">
      {/* Header */}
      <div className="flex flex-col sm:flex-row sm:items-center justify-between gap-4 bg-white p-6 rounded-3xl border border-slate-200 shadow-sm">
        <div>
          <h1 className="text-xl font-bold text-slate-900 tracking-tight flex items-center gap-2">
            <BedDouble className="h-6 w-6 text-sky-600" />
            Inpatient Department (IPD) & Wards
          </h1>
          <p className="text-xs text-slate-500 mt-1">
            Real-time bed matrix, occupancy management, transfers, and admission workflows
          </p>
        </div>

        <button
          onClick={() => setIsAdmitModalOpen(true)}
          className="px-4 py-2.5 bg-sky-600 hover:bg-sky-500 text-white rounded-xl text-xs font-bold shadow-md shadow-sky-500/20 transition-all flex items-center gap-2"
        >
          <Plus className="h-4 w-4" />
          Admit Inpatient
        </button>
      </div>

      {/* Ward Filter Pills & Live Bed Status Matrix */}
      <div className="bg-white p-6 rounded-3xl border border-slate-200 shadow-sm space-y-6">
        <div className="flex items-center justify-between flex-wrap gap-4">
          <div>
            <h3 className="text-sm font-bold text-slate-900">Hospital Bed Availability Matrix</h3>
            <p className="text-xs text-slate-500">Visual occupancy layout by ward & room</p>
          </div>
          <div className="flex items-center gap-2">
            {['ALL', 'Male General', 'Female General', 'CCU', 'Deluxe'].map((tab) => (
              <button
                key={tab}
                onClick={() => setSelectedWardFilter(tab)}
                className={`px-3 py-1.5 rounded-xl text-xs font-semibold transition-all ${
                  selectedWardFilter === tab
                    ? 'bg-slate-900 text-white'
                    : 'bg-slate-100 text-slate-600 hover:bg-slate-200'
                }`}
              >
                {tab}
              </button>
            ))}
          </div>
        </div>

        {/* Visual Bed Grid */}
        <div className="grid grid-cols-2 sm:grid-cols-4 lg:grid-cols-8 gap-3">
          {filteredBeds.map((bed) => {
            const statusConfig = {
              AVAILABLE: { bg: 'bg-emerald-50 border-emerald-300 text-emerald-800', dot: 'bg-emerald-500' },
              OCCUPIED: { bg: 'bg-rose-50 border-rose-300 text-rose-800', dot: 'bg-rose-500' },
              RESERVED: { bg: 'bg-amber-50 border-amber-300 text-amber-800', dot: 'bg-amber-500' },
              CLEANING: { bg: 'bg-indigo-50 border-indigo-300 text-indigo-800', dot: 'bg-indigo-500' },
              MAINTENANCE: { bg: 'bg-slate-100 border-slate-300 text-slate-600', dot: 'bg-slate-400' },
              OUT_OF_SERVICE: { bg: 'bg-slate-100 border-slate-300 text-slate-400', dot: 'bg-slate-300' },
            }[bed.status];

            return (
              <div
                key={bed.id}
                className={`p-3 rounded-2xl border ${statusConfig.bg} flex flex-col justify-between h-28 transition-all hover:scale-105`}
              >
                <div className="flex items-center justify-between">
                  <span className="text-[10px] font-bold font-mono">{bed.bedNumber}</span>
                  <span className={`h-2 w-2 rounded-full ${statusConfig.dot}`} />
                </div>
                <div>
                  <p className="text-[11px] font-semibold truncate">{bed.roomNumber}</p>
                  <p className="text-[9px] opacity-75 truncate">{bed.wardName}</p>
                </div>
                <div className="text-[10px] font-bold uppercase tracking-wider">{bed.status}</div>
              </div>
            );
          })}
        </div>
      </div>

      {/* Active Admissions Table */}
      <div className="bg-white rounded-3xl border border-slate-200 shadow-sm overflow-hidden">
        <div className="p-5 border-b border-slate-100 flex items-center justify-between">
          <div>
            <h3 className="text-sm font-bold text-slate-900">Current Inpatient Census</h3>
            <p className="text-xs text-slate-500">Active admitted patients, assigned beds, and attending clinicians</p>
          </div>
        </div>

        <div className="overflow-x-auto">
          <table className="w-full text-left text-xs">
            <thead className="bg-slate-50 text-slate-500 uppercase tracking-wider font-semibold border-b border-slate-200">
              <tr>
                <th className="py-3.5 px-4">Admission No</th>
                <th className="py-3.5 px-4">Patient Name (MRN)</th>
                <th className="py-3.5 px-4">Ward / Room / Bed</th>
                <th className="py-3.5 px-4">Attending Doctor</th>
                <th className="py-3.5 px-4">Admission Reason</th>
                <th className="py-3.5 px-4">Admitted At</th>
                <th className="py-3.5 px-4 text-right">Actions</th>
              </tr>
            </thead>
            <tbody className="divide-y divide-slate-100">
              {admissions.map((adm) => (
                <tr key={adm.id} className="hover:bg-slate-50/80 transition-colors">
                  <td className="py-3.5 px-4 font-mono font-bold text-sky-700">{adm.admissionNo}</td>
                  <td className="py-3.5 px-4">
                    <p className="font-semibold text-slate-900">{adm.patientName}</p>
                    <span className="text-[10px] text-slate-400 font-mono">{adm.patientMrn}</span>
                  </td>
                  <td className="py-3.5 px-4">
                    <p className="font-semibold text-slate-800">{adm.bedNumber}</p>
                    <span className="text-[10px] text-slate-500">{adm.wardName}</span>
                  </td>
                  <td className="py-3.5 px-4 text-slate-700 font-medium">{adm.primaryDoctorName}</td>
                  <td className="py-3.5 px-4 text-slate-600 max-w-xs truncate">{adm.admissionReason}</td>
                  <td className="py-3.5 px-4 text-slate-600">{new Date(adm.admissionDate).toLocaleDateString()}</td>
                  <td className="py-3.5 px-4 text-right">
                    <button
                      onClick={() => {
                        apiClient
                          .post(`/ipd/admissions/${adm.id}/discharge`, {
                            dischargeType: 'ROUTINE',
                            dischargeSummary: 'Patient stable, discharged with follow-up instructions.',
                          })
                          .catch(() => {});
                        setAdmissions(admissions.filter((a) => a.id !== adm.id));
                      }}
                      className="px-3 py-1 bg-slate-900 hover:bg-rose-600 text-white rounded-lg text-[11px] font-semibold transition-colors"
                    >
                      Discharge
                    </button>
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
