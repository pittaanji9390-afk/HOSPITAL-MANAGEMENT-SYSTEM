import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import {
  Users,
  Search,
  Plus,
  Filter,
  Eye,
  Edit,
  Phone,
  Mail,
  MapPin,
  Calendar,
  X,
  CheckCircle2,
} from 'lucide-react';
import { apiClient } from '../api/client';
import { Patient, PagedResponse, ApiResponse } from '../types';

export const Patients: React.FC = () => {
  const navigate = useNavigate();
  const [patients, setPatients] = useState<Patient[]>([
    {
      id: 1,
      mrn: 'MRN-10001',
      firstName: 'Anand',
      lastName: 'Patil',
      dob: '1982-06-14',
      gender: 'MALE',
      bloodGroup: 'O+',
      phone: '+91-98450-12345',
      email: 'anand.patil@example.com',
      city: 'Bengaluru',
      state: 'Karnataka',
      emergencyContactName: 'Sunita Patil',
      emergencyContactPhone: '+91-98450-54321',
      status: 'ACTIVE',
    },
    {
      id: 2,
      mrn: 'MRN-10002',
      firstName: 'Deepa',
      lastName: 'Rao',
      dob: '1990-11-20',
      gender: 'FEMALE',
      bloodGroup: 'B+',
      phone: '+91-98800-44221',
      email: 'deepa.rao@example.com',
      city: 'Bengaluru',
      state: 'Karnataka',
      emergencyContactName: 'Manish Rao',
      emergencyContactPhone: '+91-98800-11223',
      status: 'ACTIVE',
    },
    {
      id: 3,
      mrn: 'MRN-10003',
      firstName: 'Vikram',
      lastName: 'Singhania',
      dob: '1975-03-08',
      gender: 'MALE',
      bloodGroup: 'AB+',
      phone: '+91-99450-77889',
      email: 'vikram.s@example.com',
      city: 'Mysuru',
      state: 'Karnataka',
      emergencyContactName: 'Pooja Singhania',
      emergencyContactPhone: '+91-99450-99887',
      status: 'ACTIVE',
    },
  ]);

  const [searchQuery, setSearchQuery] = useState('');
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [formData, setFormData] = useState({
    firstName: '',
    middleName: '',
    lastName: '',
    dob: '1995-01-01',
    gender: 'MALE',
    bloodGroup: 'O+',
    phone: '',
    email: '',
    addressLine1: '',
    city: 'Bengaluru',
    state: 'Karnataka',
    postalCode: '560001',
    emergencyContactName: '',
    emergencyContactPhone: '',
  });

  const fetchPatients = () => {
    apiClient
      .get<ApiResponse<PagedResponse<Patient>>>('/patients', {
        params: { query: searchQuery || undefined },
      })
      .then((res) => {
        if (res.data?.success && res.data?.data?.content) {
          setPatients(res.data.data.content);
        }
      })
      .catch(() => {});
  };

  useEffect(() => {
    fetchPatients();
  }, [searchQuery]);

  const handleCreatePatient = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
      const res = await apiClient.post<ApiResponse<Patient>>('/patients', formData);
      if (res.data?.success && res.data?.data) {
        setPatients([res.data.data, ...patients]);
        setIsModalOpen(false);
        setFormData({
          firstName: '',
          middleName: '',
          lastName: '',
          dob: '1995-01-01',
          gender: 'MALE',
          bloodGroup: 'O+',
          phone: '',
          email: '',
          addressLine1: '',
          city: 'Bengaluru',
          state: 'Karnataka',
          postalCode: '560001',
          emergencyContactName: '',
          emergencyContactPhone: '',
        });
      }
    } catch (err) {
      // Fallback local creation
      const newMockPatient: Patient = {
        id: patients.length + 1,
        mrn: `MRN-${10000 + patients.length + 1}`,
        firstName: formData.firstName,
        lastName: formData.lastName,
        dob: formData.dob,
        gender: formData.gender as any,
        bloodGroup: formData.bloodGroup,
        phone: formData.phone,
        email: formData.email,
        city: formData.city,
        state: formData.state,
        emergencyContactName: formData.emergencyContactName,
        emergencyContactPhone: formData.emergencyContactPhone,
        status: 'ACTIVE',
      };
      setPatients([newMockPatient, ...patients]);
      setIsModalOpen(false);
    }
  };

  return (
    <div className="space-y-6">
      {/* Header & Intake Action */}
      <div className="flex flex-col sm:flex-row sm:items-center justify-between gap-4 bg-white p-6 rounded-3xl border border-slate-200 shadow-sm">
        <div>
          <h1 className="text-xl font-bold text-slate-900 tracking-tight flex items-center gap-2">
            <Users className="h-6 w-6 text-sky-600" />
            Master Patient Index (MPI)
          </h1>
          <p className="text-xs text-slate-500 mt-1">
            Centralized patient identification, demographics, contact data, and clinical history
          </p>
        </div>

        <button
          onClick={() => setIsModalOpen(true)}
          className="px-4 py-2.5 bg-sky-600 hover:bg-sky-500 text-white rounded-xl text-xs font-bold shadow-md shadow-sky-500/20 transition-all flex items-center gap-2"
        >
          <Plus className="h-4 w-4" />
          Register New Patient
        </button>
      </div>

      {/* Search & Filter Bar */}
      <div className="bg-white p-4 rounded-2xl border border-slate-200 shadow-sm flex flex-col sm:flex-row gap-4 justify-between">
        <div className="relative flex-1">
          <Search className="absolute left-3.5 top-1/2 -translate-y-1/2 h-4 w-4 text-slate-400" />
          <input
            type="text"
            placeholder="Search by Patient MRN, First/Last Name, Phone number, or Email..."
            value={searchQuery}
            onChange={(e) => setSearchQuery(e.target.value)}
            className="w-full pl-10 pr-4 py-2 bg-slate-50 border border-slate-200 rounded-xl text-xs focus:bg-white focus:outline-none focus:ring-2 focus:ring-sky-500"
          />
        </div>
        <div className="flex items-center gap-2">
          <button className="px-3.5 py-2 bg-slate-100 hover:bg-slate-200 text-slate-700 text-xs font-semibold rounded-xl flex items-center gap-1.5 transition-colors">
            <Filter className="h-4 w-4 text-slate-500" />
            Filter Status
          </button>
        </div>
      </div>

      {/* Patients Data Grid */}
      <div className="bg-white rounded-3xl border border-slate-200 shadow-sm overflow-hidden">
        <div className="overflow-x-auto">
          <table className="w-full text-left text-xs">
            <thead className="bg-slate-50 text-slate-500 uppercase tracking-wider font-semibold border-b border-slate-200">
              <tr>
                <th className="py-3.5 px-4">MRN Number</th>
                <th className="py-3.5 px-4">Patient Name</th>
                <th className="py-3.5 px-4">DOB / Age / Gender</th>
                <th className="py-3.5 px-4">Blood Group</th>
                <th className="py-3.5 px-4">Phone / Email</th>
                <th className="py-3.5 px-4">Location</th>
                <th className="py-3.5 px-4">Status</th>
                <th className="py-3.5 px-4 text-right">Actions</th>
              </tr>
            </thead>
            <tbody className="divide-y divide-slate-100">
              {patients.map((p) => {
                const age = new Date().getFullYear() - new Date(p.dob).getFullYear();
                return (
                  <tr key={p.id} className="hover:bg-slate-50/80 transition-colors">
                    <td className="py-3.5 px-4 font-mono font-bold text-sky-700">
                      {p.mrn}
                    </td>
                    <td className="py-3.5 px-4 font-semibold text-slate-900">
                      {p.firstName} {p.middleName ? `${p.middleName} ` : ''}{p.lastName}
                    </td>
                    <td className="py-3.5 px-4 text-slate-600">
                      {p.dob} ({age} yrs) • {p.gender}
                    </td>
                    <td className="py-3.5 px-4">
                      <span className="px-2 py-0.5 rounded font-bold text-[11px] bg-rose-50 text-rose-600 border border-rose-200">
                        {p.bloodGroup || 'Unknown'}
                      </span>
                    </td>
                    <td className="py-3.5 px-4">
                      <div className="flex flex-col">
                        <span className="text-slate-900 font-medium">{p.phone}</span>
                        <span className="text-[10px] text-slate-400">{p.email || 'N/A'}</span>
                      </div>
                    </td>
                    <td className="py-3.5 px-4 text-slate-600">{p.city}, {p.state}</td>
                    <td className="py-3.5 px-4">
                      <span className="px-2.5 py-1 rounded-full text-[10px] font-bold bg-emerald-100 text-emerald-800">
                        {p.status}
                      </span>
                    </td>
                    <td className="py-3.5 px-4 text-right">
                      <button
                        onClick={() => navigate(`/patients/${p.id}`)}
                        className="px-3 py-1.5 bg-slate-900 hover:bg-sky-600 text-white rounded-xl text-xs font-semibold shadow-sm transition-colors inline-flex items-center gap-1"
                      >
                        <Eye className="h-3.5 w-3.5" />
                        EMR Record
                      </button>
                    </td>
                  </tr>
                );
              })}
            </tbody>
          </table>
        </div>
      </div>

      {/* Registration Slide-over / Modal */}
      {isModalOpen && (
        <div className="fixed inset-0 bg-slate-950/60 z-50 flex items-center justify-center p-4">
          <div className="bg-white w-full max-w-2xl rounded-3xl shadow-2xl border border-slate-200 overflow-hidden flex flex-col max-h-[90vh]">
            <div className="px-6 py-4 bg-slate-900 text-white flex items-center justify-between">
              <div>
                <h3 className="text-base font-bold">Patient Registration Intake</h3>
                <p className="text-xs text-sky-400">Generate Unique Medical Record Number (MRN)</p>
              </div>
              <button
                onClick={() => setIsModalOpen(false)}
                className="text-slate-400 hover:text-white"
              >
                <X className="h-5 w-5" />
              </button>
            </div>

            <form onSubmit={handleCreatePatient} className="p-6 overflow-y-auto space-y-4">
              <div className="grid grid-cols-1 sm:grid-cols-3 gap-4">
                <div>
                  <label className="text-xs font-semibold text-slate-700 block mb-1">
                    First Name *
                  </label>
                  <input
                    type="text"
                    required
                    value={formData.firstName}
                    onChange={(e) => setFormData({ ...formData, firstName: e.target.value })}
                    className="w-full px-3 py-2 bg-slate-50 border border-slate-200 rounded-xl text-xs focus:bg-white focus:ring-2 focus:ring-sky-500 focus:outline-none"
                  />
                </div>
                <div>
                  <label className="text-xs font-semibold text-slate-700 block mb-1">
                    Middle Name
                  </label>
                  <input
                    type="text"
                    value={formData.middleName}
                    onChange={(e) => setFormData({ ...formData, middleName: e.target.value })}
                    className="w-full px-3 py-2 bg-slate-50 border border-slate-200 rounded-xl text-xs focus:bg-white focus:ring-2 focus:ring-sky-500 focus:outline-none"
                  />
                </div>
                <div>
                  <label className="text-xs font-semibold text-slate-700 block mb-1">
                    Last Name *
                  </label>
                  <input
                    type="text"
                    required
                    value={formData.lastName}
                    onChange={(e) => setFormData({ ...formData, lastName: e.target.value })}
                    className="w-full px-3 py-2 bg-slate-50 border border-slate-200 rounded-xl text-xs focus:bg-white focus:ring-2 focus:ring-sky-500 focus:outline-none"
                  />
                </div>
              </div>

              <div className="grid grid-cols-1 sm:grid-cols-3 gap-4">
                <div>
                  <label className="text-xs font-semibold text-slate-700 block mb-1">
                    Date of Birth *
                  </label>
                  <input
                    type="date"
                    required
                    value={formData.dob}
                    onChange={(e) => setFormData({ ...formData, dob: e.target.value })}
                    className="w-full px-3 py-2 bg-slate-50 border border-slate-200 rounded-xl text-xs focus:bg-white focus:ring-2 focus:ring-sky-500 focus:outline-none"
                  />
                </div>
                <div>
                  <label className="text-xs font-semibold text-slate-700 block mb-1">Gender *</label>
                  <select
                    value={formData.gender}
                    onChange={(e) => setFormData({ ...formData, gender: e.target.value })}
                    className="w-full px-3 py-2 bg-slate-50 border border-slate-200 rounded-xl text-xs focus:bg-white focus:ring-2 focus:ring-sky-500 focus:outline-none"
                  >
                    <option value="MALE">Male</option>
                    <option value="FEMALE">Female</option>
                    <option value="OTHER">Other</option>
                  </select>
                </div>
                <div>
                  <label className="text-xs font-semibold text-slate-700 block mb-1">
                    Blood Group
                  </label>
                  <select
                    value={formData.bloodGroup}
                    onChange={(e) => setFormData({ ...formData, bloodGroup: e.target.value })}
                    className="w-full px-3 py-2 bg-slate-50 border border-slate-200 rounded-xl text-xs focus:bg-white focus:ring-2 focus:ring-sky-500 focus:outline-none"
                  >
                    <option value="A+">A+</option>
                    <option value="A-">A-</option>
                    <option value="B+">B+</option>
                    <option value="B-">B-</option>
                    <option value="AB+">AB+</option>
                    <option value="AB-">AB-</option>
                    <option value="O+">O+</option>
                    <option value="O-">O-</option>
                  </select>
                </div>
              </div>

              <div className="grid grid-cols-1 sm:grid-cols-2 gap-4">
                <div>
                  <label className="text-xs font-semibold text-slate-700 block mb-1">
                    Phone Number *
                  </label>
                  <input
                    type="tel"
                    required
                    value={formData.phone}
                    onChange={(e) => setFormData({ ...formData, phone: e.target.value })}
                    placeholder="+91-98765-43210"
                    className="w-full px-3 py-2 bg-slate-50 border border-slate-200 rounded-xl text-xs focus:bg-white focus:ring-2 focus:ring-sky-500 focus:outline-none"
                  />
                </div>
                <div>
                  <label className="text-xs font-semibold text-slate-700 block mb-1">
                    Email Address
                  </label>
                  <input
                    type="email"
                    value={formData.email}
                    onChange={(e) => setFormData({ ...formData, email: e.target.value })}
                    placeholder="patient@example.com"
                    className="w-full px-3 py-2 bg-slate-50 border border-slate-200 rounded-xl text-xs focus:bg-white focus:ring-2 focus:ring-sky-500 focus:outline-none"
                  />
                </div>
              </div>

              <div>
                <label className="text-xs font-semibold text-slate-700 block mb-1">
                  Address Line 1
                </label>
                <input
                  type="text"
                  value={formData.addressLine1}
                  onChange={(e) => setFormData({ ...formData, addressLine1: e.target.value })}
                  placeholder="Street / Building"
                  className="w-full px-3 py-2 bg-slate-50 border border-slate-200 rounded-xl text-xs focus:bg-white focus:ring-2 focus:ring-sky-500 focus:outline-none"
                />
              </div>

              <div className="grid grid-cols-1 sm:grid-cols-2 gap-4">
                <div>
                  <label className="text-xs font-semibold text-slate-700 block mb-1">
                    Emergency Contact Name
                  </label>
                  <input
                    type="text"
                    value={formData.emergencyContactName}
                    onChange={(e) =>
                      setFormData({ ...formData, emergencyContactName: e.target.value })
                    }
                    className="w-full px-3 py-2 bg-slate-50 border border-slate-200 rounded-xl text-xs focus:bg-white focus:ring-2 focus:ring-sky-500 focus:outline-none"
                  />
                </div>
                <div>
                  <label className="text-xs font-semibold text-slate-700 block mb-1">
                    Emergency Contact Phone
                  </label>
                  <input
                    type="tel"
                    value={formData.emergencyContactPhone}
                    onChange={(e) =>
                      setFormData({ ...formData, emergencyContactPhone: e.target.value })
                    }
                    className="w-full px-3 py-2 bg-slate-50 border border-slate-200 rounded-xl text-xs focus:bg-white focus:ring-2 focus:ring-sky-500 focus:outline-none"
                  />
                </div>
              </div>

              <div className="pt-4 flex items-center justify-end gap-3 border-t border-slate-100">
                <button
                  type="button"
                  onClick={() => setIsModalOpen(false)}
                  className="px-4 py-2 bg-slate-100 hover:bg-slate-200 text-slate-700 rounded-xl text-xs font-semibold"
                >
                  Cancel
                </button>
                <button
                  type="submit"
                  className="px-5 py-2 bg-sky-600 hover:bg-sky-500 text-white rounded-xl text-xs font-bold shadow-md shadow-sky-500/20"
                >
                  Register & Create MRN
                </button>
              </div>
            </form>
          </div>
        </div>
      )}
    </div>
  );
};
