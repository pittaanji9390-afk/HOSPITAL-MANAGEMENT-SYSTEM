import React, { useState, useEffect } from 'react';
import {
  History,
  Search,
  Shield,
  Filter,
  Lock,
  Eye,
  UserCheck,
} from 'lucide-react';
import { apiClient } from '../api/client';
import { AuditLog, PagedResponse, ApiResponse } from '../types';

export const AuditLogs: React.FC = () => {
  const [logs, setLogs] = useState<AuditLog[]>([
    {
      id: 1,
      eventId: 'a1b2c3d4-e5f6-7890-abcd-ef1234567890',
      actorId: 'dr.sharma',
      actorRole: 'ROLE_DOCTOR',
      tenantId: 'MAIN_HOSPITAL',
      module: 'CLINICAL',
      action: 'CLINICAL_NOTE_FINALIZED',
      entityName: 'ClinicalNote',
      entityId: '1',
      ipAddress: '192.168.1.45',
      userAgent: 'Mozilla/5.0 (Windows NT 10.0; Win64; x64)',
      timestamp: '2026-08-28T10:30:00Z',
    },
    {
      id: 2,
      eventId: 'b2c3d4e5-f6a7-8901-bcde-f12345678901',
      actorId: 'pharm.kavita',
      actorRole: 'ROLE_PHARMACIST',
      tenantId: 'MAIN_HOSPITAL',
      module: 'PHARMACY',
      action: 'PHARMACY_DISPENSED',
      entityName: 'PharmacyDispensation',
      entityId: '1',
      ipAddress: '192.168.1.88',
      userAgent: 'Mozilla/5.0 (Windows NT 10.0; Win64; x64)',
      timestamp: '2026-08-28T10:40:00Z',
    },
    {
      id: 3,
      eventId: 'c3d4e5f6-a7b8-9012-cdef-123456789012',
      actorId: 'acc.suresh',
      actorRole: 'ROLE_ACCOUNTANT',
      tenantId: 'MAIN_HOSPITAL',
      module: 'BILLING',
      action: 'PAYMENT_COLLECTED',
      entityName: 'Payment',
      entityId: '1',
      ipAddress: '192.168.1.92',
      userAgent: 'Mozilla/5.0 (Windows NT 10.0; Win64; x64)',
      timestamp: '2026-08-28T10:45:00Z',
    },
  ]);

  return (
    <div className="space-y-6">
      <div className="flex flex-col sm:flex-row sm:items-center justify-between gap-4 bg-white p-6 rounded-3xl border border-slate-200 shadow-sm">
        <div>
          <h1 className="text-xl font-bold text-slate-900 tracking-tight flex items-center gap-2">
            <History className="h-6 w-6 text-sky-600" />
            Immutable Security & Compliance Audit Trail
          </h1>
          <p className="text-xs text-slate-500 mt-1">
            Tamper-evident logs of all clinical, financial, medication, and authentication events
          </p>
        </div>
      </div>

      <div className="bg-white rounded-3xl border border-slate-200 shadow-sm overflow-hidden">
        <div className="overflow-x-auto">
          <table className="w-full text-left text-xs">
            <thead className="bg-slate-50 text-slate-500 uppercase tracking-wider font-semibold border-b border-slate-200">
              <tr>
                <th className="py-3.5 px-4">Event ID</th>
                <th className="py-3.5 px-4">Actor / Role</th>
                <th className="py-3.5 px-4">Module</th>
                <th className="py-3.5 px-4">Action</th>
                <th className="py-3.5 px-4">Target Entity</th>
                <th className="py-3.5 px-4">IP Address</th>
                <th className="py-3.5 px-4">Timestamp (UTC)</th>
              </tr>
            </thead>
            <tbody className="divide-y divide-slate-100 font-mono">
              {logs.map((l) => (
                <tr key={l.id} className="hover:bg-slate-50/80 transition-colors">
                  <td className="py-3.5 px-4 font-bold text-slate-700 truncate max-w-[140px]">
                    {l.eventId}
                  </td>
                  <td className="py-3.5 px-4 font-sans">
                    <p className="font-semibold text-slate-900">{l.actorId}</p>
                    <span className="text-[10px] text-slate-400 font-mono">{l.actorRole}</span>
                  </td>
                  <td className="py-3.5 px-4 font-sans font-semibold text-sky-700">{l.module}</td>
                  <td className="py-3.5 px-4">
                    <span className="px-2 py-0.5 rounded text-[10px] font-bold bg-slate-100 text-slate-800">
                      {l.action}
                    </span>
                  </td>
                  <td className="py-3.5 px-4 font-sans text-slate-700">
                    {l.entityName} #{l.entityId}
                  </td>
                  <td className="py-3.5 px-4 text-slate-500">{l.ipAddress}</td>
                  <td className="py-3.5 px-4 text-slate-600 font-sans">
                    {new Date(l.timestamp).toLocaleString()}
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
