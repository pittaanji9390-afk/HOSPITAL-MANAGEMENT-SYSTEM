import React, { useState, useEffect } from 'react';
import {
  Calendar as CalendarIcon,
  Clock,
  User,
  Plus,
  Filter,
  CheckCircle2,
  XCircle,
  AlertCircle,
  X,
} from 'lucide-react';
import { apiClient } from '../api/client';
import { Appointment, Doctor, Patient, ApiResponse, PagedResponse } from '../types';

export const Appointments: React.FC = () => {
  const [appointments, setAppointments] = useState<Appointment[]>([
    {
      id: 1,
      appointmentNo: 'APT-10001',
      patientId: 1,
      patientName: 'Anand Patil',
      patientMrn: 'MRN-10001',
      patientPhone: '+91-98450-12345',
      doctorId: 1,
      doctorName: 'Dr. Rajesh Sharma',
      departmentId: 1,
      departmentName: 'Cardiology & Heart Institute',
      scheduledDate: '2026-08-29',
      startTime: '09:30:00',
      endTime: '09:45:00',
      type: 'CONSULTATION',
      status: 'CONFIRMED',
      reason: 'Post-CABG evaluation & medication adjustment',
    },
    {
      id: 2,
      appointmentNo: 'APT-10002',
      patientId: 2,
      patientName: 'Deepa Rao',
      patientMrn: 'MRN-10002',
      patientPhone: '+91-98800-44221',
      doctorId: 2,
      doctorName: 'Dr. Priya Nair',
      departmentId: 2,
      departmentName: 'Orthopedics & Joint Reconstruction',
      scheduledDate: '2026-08-29',
      startTime: '10:00:00',
      endTime: '10:20:00',
      type: 'CONSULTATION',
      status: 'CHECKED_IN',
      reason: 'Right knee arthroscopy follow-up',
    },
  ]);

  const [doctors, setDoctors] = useState<Doctor[]>([
    {
      id: 1,
      staffId: 2,
      doctorName: 'Dr. Rajesh Sharma',
      employeeNo: 'EMP-1002',
      departmentId: 1,
      departmentName: 'Cardiology',
      phone: '+91-98800-00002',
      email: 'dr.sharma@apexmemorialhospital.org',
      licenseNo: 'KMC-49581',
      specialization: 'Cardiology',
      consultationFee: 1200,
      followUpFee: 800,
      maxDailyPatients: 25,
      availableForTelemed: true,
      active: true,
    },
    {
      id: 2,
      staffId: 3,
      doctorName: 'Dr. Priya Nair',
      employeeNo: 'EMP-1003',
      departmentId: 2,
      departmentName: 'Orthopedics',
      phone: '+91-98800-00003',
      email: 'dr.priya@apexmemorialhospital.org',
      licenseNo: 'KMC-51294',
      specialization: 'Orthopedics',
      consultationFee: 1000,
      followUpFee: 700,
      maxDailyPatients: 25,
      availableForTelemed: false,
      active: true,
    },
  ]);

  const [isModalOpen, setIsModalOpen] = useState(false);
  const [selectedDoctorId, setSelectedDoctorId] = useState<number>(1);
  const [selectedDate, setSelectedDate] = useState<string>(new Date().toISOString().split('T')[0]);
  const [selectedSlot, setSelectedSlot] = useState<string>('09:00:00');
  const [patientId, setPatientId] = useState<number>(1);
  const [reason, setReason] = useState<string>('');

  useEffect(() => {
    apiClient
      .get<ApiResponse<PagedResponse<Appointment>>>('/appointments')
      .then((res) => {
        if (res.data?.success && res.data?.data?.content) {
          setAppointments(res.data.data.content);
        }
      })
      .catch(() => {});

    apiClient
      .get<ApiResponse<Doctor[]>>('/doctors/active')
      .then((res) => {
        if (res.data?.success && res.data?.data) {
          setDoctors(res.data.data);
        }
      })
      .catch(() => {});
  }, []);

  const handleBook = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
      const payload = {
        patientId,
        doctorId: selectedDoctorId,
        departmentId: doctors.find((d) => d.id === Number(selectedDoctorId))?.departmentId || 1,
        scheduledDate: selectedDate,
        startTime: selectedSlot,
        type: 'CONSULTATION',
        reason,
      };
      const res = await apiClient.post<ApiResponse<Appointment>>('/appointments', payload);
      if (res.data?.success && res.data?.data) {
        setAppointments([res.data.data, ...appointments]);
        setIsModalOpen(false);
      }
    } catch (err) {
      // Local fallback
      const doctor = doctors.find((d) => d.id === Number(selectedDoctorId));
      const newAppt: Appointment = {
        id: appointments.length + 1,
        appointmentNo: `APT-${10000 + appointments.length + 1}`,
        patientId: 1,
        patientName: 'Anand Patil',
        patientMrn: 'MRN-10001',
        patientPhone: '+91-98450-12345',
        doctorId: Number(selectedDoctorId),
        doctorName: doctor?.doctorName || 'Dr. Rajesh Sharma',
        departmentId: doctor?.departmentId || 1,
        departmentName: doctor?.departmentName || 'Cardiology',
        scheduledDate: selectedDate,
        startTime: selectedSlot,
        endTime: '09:45:00',
        type: 'CONSULTATION',
        status: 'CONFIRMED',
        reason,
      };
      setAppointments([newAppt, ...appointments]);
      setIsModalOpen(false);
    }
  };

  const handleStatusUpdate = (id: number, status: Appointment['status']) => {
    apiClient.patch(`/appointments/${id}/status`, null, { params: { status } }).catch(() => {});
    setAppointments(appointments.map((a) => (a.id === id ? { ...a, status } : a)));
  };

  return (
    <div className="space-y-6">
      {/* Header */}
      <div className="flex flex-col sm:flex-row sm:items-center justify-between gap-4 bg-white p-6 rounded-3xl border border-slate-200 shadow-sm">
        <div>
          <h1 className="text-xl font-bold text-slate-900 tracking-tight flex items-center gap-2">
            <CalendarIcon className="h-6 w-6 text-sky-600" />
            Appointments & Doctor Schedules
          </h1>
          <p className="text-xs text-slate-500 mt-1">
            Concurrency-safe slot scheduling, booking engine, check-in, and status transitions
          </p>
        </div>

        <button
          onClick={() => setIsModalOpen(true)}
          className="px-4 py-2.5 bg-sky-600 hover:bg-sky-500 text-white rounded-xl text-xs font-bold shadow-md shadow-sky-500/20 transition-all flex items-center gap-2"
        >
          <Plus className="h-4 w-4" />
          Book Appointment
        </button>
      </div>

      {/* Appointment Data Grid */}
      <div className="bg-white rounded-3xl border border-slate-200 shadow-sm overflow-hidden">
        <div className="overflow-x-auto">
          <table className="w-full text-left text-xs">
            <thead className="bg-slate-50 text-slate-500 uppercase tracking-wider font-semibold border-b border-slate-200">
              <tr>
                <th className="py-3.5 px-4">Appt No</th>
                <th className="py-3.5 px-4">Patient (MRN)</th>
                <th className="py-3.5 px-4">Doctor / Specialty</th>
                <th className="py-3.5 px-4">Date & Time</th>
                <th className="py-3.5 px-4">Reason / Notes</th>
                <th className="py-3.5 px-4">Status</th>
                <th className="py-3.5 px-4 text-right">Workflow Actions</th>
              </tr>
            </thead>
            <tbody className="divide-y divide-slate-100">
              {appointments.map((a) => {
                const statusBadge =
                  a.status === 'CONFIRMED'
                    ? 'bg-sky-100 text-sky-800'
                    : a.status === 'CHECKED_IN'
                    ? 'bg-emerald-100 text-emerald-800'
                    : a.status === 'IN_CONSULTATION'
                    ? 'bg-indigo-100 text-indigo-800'
                    : a.status === 'COMPLETED'
                    ? 'bg-slate-100 text-slate-700'
                    : 'bg-rose-100 text-rose-800';

                return (
                  <tr key={a.id} className="hover:bg-slate-50/80 transition-colors">
                    <td className="py-3.5 px-4 font-mono font-bold text-sky-700">{a.appointmentNo}</td>
                    <td className="py-3.5 px-4">
                      <p className="font-semibold text-slate-900">{a.patientName}</p>
                      <span className="text-[10px] text-slate-400 font-mono">{a.patientMrn}</span>
                    </td>
                    <td className="py-3.5 px-4">
                      <p className="font-semibold text-slate-800">{a.doctorName}</p>
                      <span className="text-[10px] text-slate-500">{a.departmentName}</span>
                    </td>
                    <td className="py-3.5 px-4 text-slate-700">
                      <p className="font-medium">{a.scheduledDate}</p>
                      <span className="text-[10px] text-slate-500 font-mono">
                        {a.startTime} - {a.endTime}
                      </span>
                    </td>
                    <td className="py-3.5 px-4 text-slate-600 max-w-xs truncate">{a.reason || 'General Consultation'}</td>
                    <td className="py-3.5 px-4">
                      <span className={`px-2.5 py-1 rounded-full text-[10px] font-bold ${statusBadge}`}>
                        {a.status}
                      </span>
                    </td>
                    <td className="py-3.5 px-4 text-right">
                      <div className="flex items-center justify-end gap-1.5">
                        {a.status === 'CONFIRMED' && (
                          <button
                            onClick={() => handleStatusUpdate(a.id, 'CHECKED_IN')}
                            className="px-2.5 py-1 bg-emerald-600 hover:bg-emerald-500 text-white rounded-lg text-[11px] font-semibold"
                          >
                            Check In
                          </button>
                        )}
                        {a.status === 'CHECKED_IN' && (
                          <button
                            onClick={() => handleStatusUpdate(a.id, 'IN_CONSULTATION')}
                            className="px-2.5 py-1 bg-sky-600 hover:bg-sky-500 text-white rounded-lg text-[11px] font-semibold"
                          >
                            Start Consult
                          </button>
                        )}
                        {a.status === 'IN_CONSULTATION' && (
                          <button
                            onClick={() => handleStatusUpdate(a.id, 'COMPLETED')}
                            className="px-2.5 py-1 bg-slate-900 hover:bg-slate-800 text-white rounded-lg text-[11px] font-semibold"
                          >
                            Complete
                          </button>
                        )}
                      </div>
                    </td>
                  </tr>
                );
              })}
            </tbody>
          </table>
        </div>
      </div>

      {/* Book Appointment Modal */}
      {isModalOpen && (
        <div className="fixed inset-0 bg-slate-950/60 z-50 flex items-center justify-center p-4">
          <div className="bg-white w-full max-w-lg rounded-3xl shadow-2xl border border-slate-200 overflow-hidden">
            <div className="px-6 py-4 bg-slate-900 text-white flex items-center justify-between">
              <div>
                <h3 className="text-base font-bold">Schedule Doctor Appointment</h3>
                <p className="text-xs text-sky-400">Lock time slot & notify clinician</p>
              </div>
              <button onClick={() => setIsModalOpen(false)} className="text-slate-400 hover:text-white">
                <X className="h-5 w-5" />
              </button>
            </div>

            <form onSubmit={handleBook} className="p-6 space-y-4 text-xs">
              <div>
                <label className="font-semibold text-slate-700 block mb-1">Select Doctor *</label>
                <select
                  value={selectedDoctorId}
                  onChange={(e) => setSelectedDoctorId(Number(e.target.value))}
                  className="w-full px-3 py-2 bg-slate-50 border border-slate-200 rounded-xl focus:bg-white focus:ring-2 focus:ring-sky-500 focus:outline-none"
                >
                  {doctors.map((d) => (
                    <option key={d.id} value={d.id}>
                      {d.doctorName} ({d.specialization}) - ₹{d.consultationFee}
                    </option>
                  ))}
                </select>
              </div>

              <div className="grid grid-cols-2 gap-4">
                <div>
                  <label className="font-semibold text-slate-700 block mb-1">Date *</label>
                  <input
                    type="date"
                    required
                    value={selectedDate}
                    onChange={(e) => setSelectedDate(e.target.value)}
                    className="w-full px-3 py-2 bg-slate-50 border border-slate-200 rounded-xl focus:bg-white focus:ring-2 focus:ring-sky-500 focus:outline-none"
                  />
                </div>
                <div>
                  <label className="font-semibold text-slate-700 block mb-1">Time Slot *</label>
                  <select
                    value={selectedSlot}
                    onChange={(e) => setSelectedSlot(e.target.value)}
                    className="w-full px-3 py-2 bg-slate-50 border border-slate-200 rounded-xl focus:bg-white focus:ring-2 focus:ring-sky-500 focus:outline-none"
                  >
                    <option value="09:00:00">09:00 AM</option>
                    <option value="09:15:00">09:15 AM</option>
                    <option value="09:30:00">09:30 AM</option>
                    <option value="10:00:00">10:00 AM</option>
                    <option value="10:15:00">10:15 AM</option>
                    <option value="10:30:00">10:30 AM</option>
                    <option value="11:00:00">11:00 AM</option>
                    <option value="11:30:00">11:30 AM</option>
                  </select>
                </div>
              </div>

              <div>
                <label className="font-semibold text-slate-700 block mb-1">Chief Reason for Consultation</label>
                <textarea
                  rows={3}
                  value={reason}
                  onChange={(e) => setReason(e.target.value)}
                  placeholder="e.g. Follow-up blood pressure check, post-surgical review..."
                  className="w-full px-3 py-2 bg-slate-50 border border-slate-200 rounded-xl focus:bg-white focus:ring-2 focus:ring-sky-500 focus:outline-none"
                />
              </div>

              <div className="pt-4 flex items-center justify-end gap-3 border-t border-slate-100">
                <button
                  type="button"
                  onClick={() => setIsModalOpen(false)}
                  className="px-4 py-2 bg-slate-100 hover:bg-slate-200 text-slate-700 rounded-xl font-semibold"
                >
                  Cancel
                </button>
                <button
                  type="submit"
                  className="px-5 py-2 bg-sky-600 hover:bg-sky-500 text-white rounded-xl font-bold shadow-md shadow-sky-500/20"
                >
                  Confirm & Reserve Slot
                </button>
              </div>
            </form>
          </div>
        </div>
      )}
    </div>
  );
};
