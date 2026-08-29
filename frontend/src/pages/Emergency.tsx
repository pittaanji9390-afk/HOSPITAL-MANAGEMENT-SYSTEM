import React, { useState, useEffect } from 'react';
import {
  Flame,
  Plus,
  AlertTriangle,
  Clock,
  HeartPulse,
  Activity,
  User,
  X,
  CheckCircle2,
  Ambulance,
} from 'lucide-react';
import { apiClient } from '../api/client';
import { EmergencyCase, ApiResponse } from '../types';

export const Emergency: React.FC = () => {
  const [cases, setCases] = useState<EmergencyCase[]>([
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
      chiefComplaint: 'Severe Acute Chest Pain, Diaphoresis & Hypotension (BP 80/50)',
      traumaDetails: 'Possible STEMI. Immediate cath-lab activation required.',
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
      chiefComplaint: 'Compound Right Tibia Fracture following 2-wheeler accident',
      traumaDetails: 'Active bleeding controlled with compression. Splint applied.',
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
      chiefComplaint: 'High Grade Fever (103.4°F) with Lethargy and Dehydration',
      traumaDetails: 'Febrile illness. IV rehydration running.',
      status: 'TRIAGED',
    },
  ]);

  const [isModalOpen, setIsModalOpen] = useState(false);
  const [formData, setFormData] = useState({
    patientName: '',
    anonymousIdentifier: '',
    modeOfArrival: 'AMBULANCE',
    triageLevel: 1,
    triagePriority: 'CRITICAL',
    chiefComplaint: '',
    traumaDetails: '',
  });

  useEffect(() => {
    apiClient
      .get<ApiResponse<EmergencyCase[]>>('/emergency/active-queue')
      .then((res) => {
        if (res.data?.success && res.data?.data && res.data.data.length > 0) {
          setCases(res.data.data);
        }
      })
      .catch(() => {});
  }, []);

  const handleIntake = (e: React.FormEvent) => {
    e.preventDefault();
    const newCase: EmergencyCase = {
      id: cases.length + 1,
      caseNo: `EMR-${10000 + cases.length + 1}`,
      patientName: formData.patientName || formData.anonymousIdentifier || 'Trauma Patient',
      patientMrn: 'MRN-EMR-TEMP',
      arrivalTime: new Date().toISOString(),
      modeOfArrival: formData.modeOfArrival as any,
      triageLevel: Number(formData.triageLevel),
      triagePriority: formData.triagePriority as any,
      attendingDoctorName: 'Dr. Rajesh Sharma (ER Physician)',
      chiefComplaint: formData.chiefComplaint,
      traumaDetails: formData.traumaDetails,
      status: 'TRIAGED',
    };
    setCases([newCase, ...cases]);
    setIsModalOpen(false);
  };

  return (
    <div className="space-y-6">
      {/* Header */}
      <div className="flex flex-col sm:flex-row sm:items-center justify-between gap-4 bg-white p-6 rounded-3xl border border-slate-200 shadow-sm">
        <div>
          <h1 className="text-xl font-bold text-slate-900 tracking-tight flex items-center gap-2">
            <Flame className="h-6 w-6 text-rose-600" />
            Emergency & Resuscitation Center
          </h1>
          <p className="text-xs text-slate-500 mt-1">
            Emergency Severity Index (ESI 1-5) rapid intake, color-coded priority queues, and trauma workflows
          </p>
        </div>

        <button
          onClick={() => setIsModalOpen(true)}
          className="px-4 py-2.5 bg-rose-600 hover:bg-rose-500 text-white rounded-xl text-xs font-bold shadow-md shadow-rose-500/20 transition-all flex items-center gap-2"
        >
          <Plus className="h-4 w-4" />
          Rapid Emergency Intake
        </button>
      </div>

      {/* Real-time Triage Priority Grid */}
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
        {cases.map((c) => {
          const priorityStyles = {
            CRITICAL: {
              card: 'border-rose-300 bg-rose-50/40',
              badge: 'bg-rose-600 text-white',
              title: 'text-rose-900',
            },
            URGENT: {
              card: 'border-amber-300 bg-amber-50/40',
              badge: 'bg-amber-600 text-white',
              title: 'text-amber-900',
            },
            MODERATE: {
              card: 'border-sky-300 bg-sky-50/40',
              badge: 'bg-sky-600 text-white',
              title: 'text-sky-900',
            },
            LOW: {
              card: 'border-slate-300 bg-slate-50',
              badge: 'bg-slate-600 text-white',
              title: 'text-slate-900',
            },
          }[c.triagePriority];

          return (
            <div
              key={c.id}
              className={`p-5 rounded-3xl border ${priorityStyles.card} shadow-sm flex flex-col justify-between space-y-4 bg-white`}
            >
              <div>
                <div className="flex items-center justify-between">
                  <span className="font-mono font-bold text-xs text-slate-900">{c.caseNo}</span>
                  <span className={`px-2.5 py-0.5 rounded-full text-[10px] font-bold uppercase tracking-wider ${priorityStyles.badge}`}>
                    ESI {c.triageLevel} • {c.triagePriority}
                  </span>
                </div>

                <h3 className="text-sm font-bold text-slate-900 mt-2">{c.patientName}</h3>
                <p className="text-[11px] text-slate-500 font-mono">{c.patientMrn}</p>

                <div className="mt-3 p-3 bg-slate-50 rounded-2xl border border-slate-100 space-y-1 text-xs">
                  <p className="font-semibold text-slate-800">Chief Complaint:</p>
                  <p className="text-slate-600 leading-relaxed">{c.chiefComplaint}</p>
                </div>

                {c.traumaDetails && (
                  <p className="text-[11px] text-rose-700 font-medium mt-2">
                    Trauma Notes: {c.traumaDetails}
                  </p>
                )}
              </div>

              <div className="pt-3 border-t border-slate-100 flex items-center justify-between text-xs">
                <div>
                  <span className="text-[10px] text-slate-400 font-semibold block">PHYSICIAN</span>
                  <span className="font-medium text-slate-800">{c.attendingDoctorName}</span>
                </div>
                <button
                  onClick={() => setCases(cases.filter((x) => x.id !== c.id))}
                  className="px-3 py-1.5 bg-slate-900 hover:bg-emerald-600 text-white rounded-xl font-semibold text-[11px] transition-colors"
                >
                  Admit to ICU/Ward
                </button>
              </div>
            </div>
          );
        })}
      </div>

      {/* Emergency Intake Modal */}
      {isModalOpen && (
        <div className="fixed inset-0 bg-slate-950/60 z-50 flex items-center justify-center p-4">
          <div className="bg-white w-full max-w-lg rounded-3xl shadow-2xl border border-slate-200 overflow-hidden">
            <div className="px-6 py-4 bg-rose-600 text-white flex items-center justify-between">
              <div>
                <h3 className="text-base font-bold">Emergency Rapid Intake</h3>
                <p className="text-xs text-rose-100">Assign ESI Severity & Notify Resuscitation Bay</p>
              </div>
              <button onClick={() => setIsModalOpen(false)} className="text-white">
                <X className="h-5 w-5" />
              </button>
            </div>

            <form onSubmit={handleIntake} className="p-6 space-y-4 text-xs">
              <div>
                <label className="font-semibold text-slate-700 block mb-1">Patient Name / Identifier</label>
                <input
                  type="text"
                  required
                  placeholder="e.g. John Doe or Trauma Unknown #4"
                  value={formData.patientName}
                  onChange={(e) => setFormData({ ...formData, patientName: e.target.value })}
                  className="w-full px-3 py-2 bg-slate-50 border border-slate-200 rounded-xl focus:bg-white focus:ring-2 focus:ring-rose-500 focus:outline-none"
                />
              </div>

              <div className="grid grid-cols-2 gap-4">
                <div>
                  <label className="font-semibold text-slate-700 block mb-1">ESI Triage Level</label>
                  <select
                    value={formData.triageLevel}
                    onChange={(e) => {
                      const lvl = Number(e.target.value);
                      const priority = lvl === 1 ? 'CRITICAL' : lvl === 2 ? 'URGENT' : lvl === 3 ? 'MODERATE' : 'LOW';
                      setFormData({ ...formData, triageLevel: lvl, triagePriority: priority });
                    }}
                    className="w-full px-3 py-2 bg-slate-50 border border-slate-200 rounded-xl focus:bg-white focus:ring-2 focus:ring-rose-500 focus:outline-none"
                  >
                    <option value={1}>Level 1 - Resuscitation (Critical)</option>
                    <option value={2}>Level 2 - Emergent (Urgent)</option>
                    <option value={3}>Level 3 - Urgent (Moderate)</option>
                    <option value={4}>Level 4 - Less Urgent</option>
                    <option value={5}>Level 5 - Non-Urgent</option>
                  </select>
                </div>
                <div>
                  <label className="font-semibold text-slate-700 block mb-1">Mode of Arrival</label>
                  <select
                    value={formData.modeOfArrival}
                    onChange={(e) => setFormData({ ...formData, modeOfArrival: e.target.value })}
                    className="w-full px-3 py-2 bg-slate-50 border border-slate-200 rounded-xl focus:bg-white focus:ring-2 focus:ring-rose-500 focus:outline-none"
                  >
                    <option value="AMBULANCE">Ambulance</option>
                    <option value="WALK_IN">Walk In</option>
                    <option value="POLICE">Police</option>
                    <option value="TRANSFER">Transfer from Clinic</option>
                  </select>
                </div>
              </div>

              <div>
                <label className="font-semibold text-slate-700 block mb-1">Chief Complaint & Vitals</label>
                <textarea
                  rows={3}
                  required
                  placeholder="Severe acute symptoms, vitals on arrival, trauma description..."
                  value={formData.chiefComplaint}
                  onChange={(e) => setFormData({ ...formData, chiefComplaint: e.target.value })}
                  className="w-full px-3 py-2 bg-slate-50 border border-slate-200 rounded-xl focus:bg-white focus:ring-2 focus:ring-rose-500 focus:outline-none"
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
                  className="px-5 py-2 bg-rose-600 hover:bg-rose-500 text-white rounded-xl font-bold shadow-md shadow-rose-500/20"
                >
                  Trigger Emergency Intake
                </button>
              </div>
            </form>
          </div>
        </div>
      )}
    </div>
  );
};
