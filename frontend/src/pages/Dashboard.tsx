import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import {
  Users,
  Calendar,
  BedDouble,
  Flame,
  CreditCard,
  PlusCircle,
  TrendingUp,
  Clock,
  ArrowRight,
  Activity,
  AlertTriangle,
  UserCheck,
} from 'lucide-react';
import {
  AreaChart,
  Area,
  XAxis,
  YAxis,
  CartesianGrid,
  Tooltip,
  ResponsiveContainer,
  BarChart,
  Bar,
  PieChart,
  Pie,
  Cell,
} from 'recharts';
import { apiClient } from '../api/client';
import { DashboardStats, EmergencyCase, ApiResponse } from '../types';

const weeklyAdmissionsData = [
  { day: 'Mon', admissions: 18, discharges: 12 },
  { day: 'Tue', admissions: 24, discharges: 19 },
  { day: 'Wed', admissions: 22, discharges: 16 },
  { day: 'Thu', admissions: 30, discharges: 25 },
  { day: 'Fri', admissions: 28, discharges: 22 },
  { day: 'Sat', admissions: 14, discharges: 18 },
  { day: 'Sun', admissions: 12, discharges: 10 },
];

const departmentRevenueData = [
  { name: 'Cardiology', value: 450000, color: '#0ea5e9' },
  { name: 'Orthopedics', value: 380000, color: '#0d9488' },
  { name: 'Surgery', value: 320000, color: '#6366f1' },
  { name: 'Pediatrics', value: 180000, color: '#f59e0b' },
  { name: 'Diagnostics', value: 240000, color: '#ec4899' },
];

export const Dashboard: React.FC = () => {
  const navigate = useNavigate();
  const [stats, setStats] = useState<DashboardStats>({
    totalPatients: 1420,
    todayAppointments: 48,
    activeAdmissions: 28,
    availableBeds: 12,
    occupiedBeds: 28,
    activeEmergencyCases: 4,
    todayRevenue: 185400,
    outstandingBalance: 34200,
  });

  const [emergencyQueue, setEmergencyQueue] = useState<EmergencyCase[]>([
    {
      id: 1,
      caseNo: 'EMR-10001',
      patientName: 'Karan Malhotra',
      patientMrn: 'MRN-10022',
      arrivalTime: new Date().toISOString(),
      modeOfArrival: 'AMBULANCE',
      triageLevel: 1,
      triagePriority: 'CRITICAL',
      attendingDoctorName: 'Dr. Rajesh Sharma',
      chiefComplaint: 'Severe Acute Chest Pain & Hypotension',
      status: 'UNDER_TREATMENT',
    },
    {
      id: 2,
      caseNo: 'EMR-10002',
      patientName: 'Meera Deshmukh',
      patientMrn: 'MRN-10034',
      arrivalTime: new Date(Date.now() - 15 * 60000).toISOString(),
      modeOfArrival: 'WALK_IN',
      triageLevel: 2,
      triagePriority: 'URGENT',
      attendingDoctorName: 'Dr. Priya Nair',
      chiefComplaint: 'Compound Right Tibia Fracture following fall',
      status: 'TRIAGED',
    },
    {
      id: 3,
      caseNo: 'EMR-10003',
      patientName: 'Rohan Gupta (Child)',
      patientMrn: 'MRN-10041',
      arrivalTime: new Date(Date.now() - 35 * 60000).toISOString(),
      modeOfArrival: 'WALK_IN',
      triageLevel: 3,
      triagePriority: 'MODERATE',
      attendingDoctorName: 'Dr. Robert D\'Souza',
      chiefComplaint: 'High Grade Fever (103.4°F) with Dehydration',
      status: 'TRIAGED',
    },
  ]);

  useEffect(() => {
    apiClient
      .get<ApiResponse<DashboardStats>>('/reports/dashboard-stats')
      .then((res) => {
        if (res.data?.success && res.data?.data) {
          setStats(res.data.data);
        }
      })
      .catch(() => {
        // Fallback default mock values initialized above
      });

    apiClient
      .get<ApiResponse<EmergencyCase[]>>('/emergency/active-queue')
      .then((res) => {
        if (res.data?.success && res.data?.data && res.data.data.length > 0) {
          setEmergencyQueue(res.data.data);
        }
      })
      .catch(() => {});
  }, []);

  return (
    <div className="space-y-8">
      {/* Top Banner & Quick Intake Shortcuts */}
      <div className="flex flex-col md:flex-row md:items-center justify-between gap-4 bg-white p-6 rounded-3xl border border-slate-200/80 shadow-sm">
        <div>
          <h1 className="text-xl font-bold text-slate-900 tracking-tight">
            Apex Memorial Hospital Operations Hub
          </h1>
          <p className="text-xs text-slate-500 mt-1">
            Real-time clinical throughput, bed capacity, emergency triage, and revenue indicators
          </p>
        </div>

        <div className="flex flex-wrap gap-2">
          <button
            onClick={() => navigate('/patients')}
            className="px-3.5 py-2 bg-sky-600 hover:bg-sky-500 text-white rounded-xl text-xs font-semibold shadow-sm transition-colors flex items-center gap-1.5"
          >
            <PlusCircle className="h-4 w-4" />
            New Patient Intake
          </button>
          <button
            onClick={() => navigate('/appointments')}
            className="px-3.5 py-2 bg-slate-800 hover:bg-slate-700 text-white rounded-xl text-xs font-semibold shadow-sm transition-colors flex items-center gap-1.5"
          >
            <Calendar className="h-4 w-4" />
            Book Appointment
          </button>
          <button
            onClick={() => navigate('/emergency')}
            className="px-3.5 py-2 bg-rose-600 hover:bg-rose-500 text-white rounded-xl text-xs font-semibold shadow-sm transition-colors flex items-center gap-1.5"
          >
            <Flame className="h-4 w-4" />
            ER Triage
          </button>
        </div>
      </div>

      {/* KPI Stat Cards Grid */}
      <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-4">
        {/* Total Patients */}
        <div className="bg-white p-5 rounded-2xl border border-slate-200 shadow-sm flex items-center justify-between">
          <div>
            <p className="text-[11px] font-semibold tracking-wider text-slate-500 uppercase">
              Total Active Patients
            </p>
            <h3 className="text-2xl font-bold text-slate-900 mt-1">{stats.totalPatients}</h3>
            <span className="inline-flex items-center gap-1 text-[11px] font-medium text-emerald-600 mt-1">
              <TrendingUp className="h-3 w-3" /> +14 new today
            </span>
          </div>
          <div className="h-12 w-12 rounded-2xl bg-sky-50 text-sky-600 flex items-center justify-center">
            <Users className="h-6 w-6" />
          </div>
        </div>

        {/* Appointments Today */}
        <div className="bg-white p-5 rounded-2xl border border-slate-200 shadow-sm flex items-center justify-between">
          <div>
            <p className="text-[11px] font-semibold tracking-wider text-slate-500 uppercase">
              Today's Consultations
            </p>
            <h3 className="text-2xl font-bold text-slate-900 mt-1">{stats.todayAppointments}</h3>
            <span className="inline-flex items-center gap-1 text-[11px] font-medium text-sky-600 mt-1">
              <Clock className="h-3 w-3" /> 8 in queue now
            </span>
          </div>
          <div className="h-12 w-12 rounded-2xl bg-teal-50 text-teal-600 flex items-center justify-center">
            <UserCheck className="h-6 w-6" />
          </div>
        </div>

        {/* Inpatient Bed Occupancy */}
        <div className="bg-white p-5 rounded-2xl border border-slate-200 shadow-sm flex items-center justify-between">
          <div>
            <p className="text-[11px] font-semibold tracking-wider text-slate-500 uppercase">
              Inpatient Wards
            </p>
            <h3 className="text-2xl font-bold text-slate-900 mt-1">
              {stats.occupiedBeds}{' '}
              <span className="text-xs font-normal text-slate-500">/ {stats.occupiedBeds + stats.availableBeds} beds</span>
            </h3>
            <span className="inline-flex items-center gap-1 text-[11px] font-medium text-emerald-600 mt-1">
              {stats.availableBeds} beds available
            </span>
          </div>
          <div className="h-12 w-12 rounded-2xl bg-indigo-50 text-indigo-600 flex items-center justify-center">
            <BedDouble className="h-6 w-6" />
          </div>
        </div>

        {/* Revenue Collected */}
        <div className="bg-white p-5 rounded-2xl border border-slate-200 shadow-sm flex items-center justify-between">
          <div>
            <p className="text-[11px] font-semibold tracking-wider text-slate-500 uppercase">
              Today's Revenue
            </p>
            <h3 className="text-2xl font-bold text-slate-900 mt-1">
              ₹{stats.todayRevenue.toLocaleString()}
            </h3>
            <span className="inline-flex items-center gap-1 text-[11px] font-medium text-amber-600 mt-1">
              ₹{stats.outstandingBalance.toLocaleString()} pending AR
            </span>
          </div>
          <div className="h-12 w-12 rounded-2xl bg-emerald-50 text-emerald-600 flex items-center justify-center">
            <CreditCard className="h-6 w-6" />
          </div>
        </div>
      </div>

      {/* Main Visualizations Row */}
      <div className="grid grid-cols-1 lg:grid-cols-3 gap-6">
        {/* Weekly Inpatient Admissions & Discharges Trend */}
        <div className="lg:col-span-2 bg-white p-6 rounded-3xl border border-slate-200 shadow-sm">
          <div className="flex items-center justify-between mb-6">
            <div>
              <h3 className="text-sm font-bold text-slate-900">Inpatient Admissions vs Discharges</h3>
              <p className="text-xs text-slate-500">Weekly patient throughput across all wards</p>
            </div>
            <div className="flex items-center gap-4 text-xs">
              <span className="flex items-center gap-1.5 text-sky-600 font-medium">
                <span className="h-2.5 w-2.5 rounded-full bg-sky-500"></span> Admissions
              </span>
              <span className="flex items-center gap-1.5 text-teal-600 font-medium">
                <span className="h-2.5 w-2.5 rounded-full bg-teal-500"></span> Discharges
              </span>
            </div>
          </div>
          <div className="h-64 w-full">
            <ResponsiveContainer width="100%" height="100%">
              <AreaChart data={weeklyAdmissionsData}>
                <defs>
                  <linearGradient id="colorAdm" x1="0" y1="0" x2="0" y2="1">
                    <stop offset="5%" stopColor="#0ea5e9" stopOpacity={0.3} />
                    <stop offset="95%" stopColor="#0ea5e9" stopOpacity={0} />
                  </linearGradient>
                  <linearGradient id="colorDis" x1="0" y1="0" x2="0" y2="1">
                    <stop offset="5%" stopColor="#0d9488" stopOpacity={0.3} />
                    <stop offset="95%" stopColor="#0d9488" stopOpacity={0} />
                  </linearGradient>
                </defs>
                <CartesianGrid strokeDasharray="3 3" vertical={false} stroke="#f1f5f9" />
                <XAxis dataKey="day" tickLine={false} axisLine={false} tick={{ fontSize: 12, fill: '#64748b' }} />
                <YAxis tickLine={false} axisLine={false} tick={{ fontSize: 12, fill: '#64748b' }} />
                <Tooltip />
                <Area type="monotone" dataKey="admissions" stroke="#0ea5e9" strokeWidth={2} fillOpacity={1} fill="url(#colorAdm)" />
                <Area type="monotone" dataKey="discharges" stroke="#0d9488" strokeWidth={2} fillOpacity={1} fill="url(#colorDis)" />
              </AreaChart>
            </ResponsiveContainer>
          </div>
        </div>

        {/* Department Revenue Breakdown */}
        <div className="bg-white p-6 rounded-3xl border border-slate-200 shadow-sm flex flex-col justify-between">
          <div>
            <h3 className="text-sm font-bold text-slate-900">Clinical Revenue by Specialty</h3>
            <p className="text-xs text-slate-500 mb-4">Current financial cycle distribution</p>
            <div className="h-44 w-full">
              <ResponsiveContainer width="100%" height="100%">
                <PieChart>
                  <Pie
                    data={departmentRevenueData}
                    innerRadius={45}
                    outerRadius={70}
                    paddingAngle={4}
                    dataKey="value"
                  >
                    {departmentRevenueData.map((entry, index) => (
                      <Cell key={`cell-${index}`} fill={entry.color} />
                    ))}
                  </Pie>
                  <Tooltip />
                </PieChart>
              </ResponsiveContainer>
            </div>
          </div>
          <div className="space-y-1.5 pt-4 border-t border-slate-100">
            {departmentRevenueData.map((item, i) => (
              <div key={i} className="flex items-center justify-between text-xs">
                <span className="flex items-center gap-2 text-slate-600">
                  <span className="h-2 w-2 rounded-full" style={{ backgroundColor: item.color }} />
                  {item.name}
                </span>
                <span className="font-semibold text-slate-900">
                  ₹{(item.value / 1000).toFixed(0)}k
                </span>
              </div>
            ))}
          </div>
        </div>
      </div>

      {/* Emergency Active Triage Live Dashboard Queue */}
      <div className="bg-white p-6 rounded-3xl border border-slate-200 shadow-sm">
        <div className="flex items-center justify-between mb-4">
          <div className="flex items-center gap-3">
            <div className="h-8 w-8 rounded-xl bg-rose-100 text-rose-600 flex items-center justify-center">
              <Flame className="h-5 w-5 animate-pulse" />
            </div>
            <div>
              <h3 className="text-sm font-bold text-slate-900">Emergency & Resuscitation Active Queue</h3>
              <p className="text-xs text-slate-500">Live clinical severity classification (ESI 1-5)</p>
            </div>
          </div>
          <button
            onClick={() => navigate('/emergency')}
            className="text-xs font-semibold text-sky-600 hover:text-sky-700 flex items-center gap-1"
          >
            Open ER Board <ArrowRight className="h-3.5 w-3.5" />
          </button>
        </div>

        <div className="overflow-x-auto">
          <table className="w-full text-left text-xs">
            <thead className="bg-slate-50 text-slate-500 uppercase tracking-wider font-semibold border-y border-slate-200">
              <tr>
                <th className="py-3 px-4">Case / MRN</th>
                <th className="py-3 px-4">Patient Name</th>
                <th className="py-3 px-4">Triage Priority</th>
                <th className="py-3 px-4">Chief Complaint</th>
                <th className="py-3 px-4">Attending Physician</th>
                <th className="py-3 px-4">Status</th>
                <th className="py-3 px-4 text-right">Action</th>
              </tr>
            </thead>
            <tbody className="divide-y divide-slate-100">
              {emergencyQueue.map((c) => {
                const priorityBadge =
                  c.triagePriority === 'CRITICAL'
                    ? 'bg-rose-500 text-white'
                    : c.triagePriority === 'URGENT'
                    ? 'bg-amber-500 text-white'
                    : 'bg-sky-500 text-white';

                return (
                  <tr key={c.id} className="hover:bg-slate-50/80 transition-colors">
                    <td className="py-3.5 px-4 font-mono font-bold text-slate-800">
                      {c.caseNo}
                      <span className="block text-[10px] font-normal text-slate-400">{c.patientMrn}</span>
                    </td>
                    <td className="py-3.5 px-4 font-semibold text-slate-900">{c.patientName}</td>
                    <td className="py-3.5 px-4">
                      <span className={`px-2.5 py-1 rounded-full text-[10px] font-bold uppercase tracking-wider ${priorityBadge}`}>
                        Level {c.triageLevel} • {c.triagePriority}
                      </span>
                    </td>
                    <td className="py-3.5 px-4 text-slate-600 max-w-xs truncate">{c.chiefComplaint}</td>
                    <td className="py-3.5 px-4 text-slate-700 font-medium">{c.attendingDoctorName}</td>
                    <td className="py-3.5 px-4">
                      <span className="px-2 py-0.5 rounded-md text-[10px] font-semibold bg-slate-100 text-slate-700">
                        {c.status}
                      </span>
                    </td>
                    <td className="py-3.5 px-4 text-right">
                      <button
                        onClick={() => navigate('/emergency')}
                        className="px-3 py-1 bg-slate-900 hover:bg-slate-800 text-white rounded-lg text-[11px] font-medium transition-colors"
                      >
                        Attend
                      </button>
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
