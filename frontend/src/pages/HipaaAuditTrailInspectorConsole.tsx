import React, { useState } from 'react';
import { SAMPLE_AUDIT_LOGS } from '../types/hipaaAudit';

export const HipaaAuditTrailInspectorConsole: React.FC = () => {
  const [logs, setLogs] = useState(SAMPLE_AUDIT_LOGS);

  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">HIPAA Security Rule Real-Time Audit Trail Inspector</h1>
          <p className="text-sm text-slate-400">45 CFR § 164.312(b) Audit Controls &amp; PHI Access Log Forensics</p>
        </div>
      </header>

      <div className="bg-slate-800/80 rounded-xl border border-slate-700 overflow-hidden font-mono text-xs">
        <table className="w-full text-left text-slate-300">
          <thead className="bg-slate-950 text-slate-400 uppercase">
            <tr>
              <th className="p-3">Event ID</th>
              <th className="p-3">Timestamp</th>
              <th className="p-3">User</th>
              <th className="p-3">Role</th>
              <th className="p-3">Patient</th>
              <th className="p-3">Action</th>
              <th className="p-3">IP Address</th>
              <th className="p-3">Justification</th>
            </tr>
          </thead>
          <tbody className="divide-y divide-slate-700/60">
            {logs.map((log) => (
              <tr key={log.eventId} className="hover:bg-slate-800/50">
                <td className="p-3 font-bold text-sky-400">{log.eventId}</td>
                <td className="p-3 text-slate-300">{log.timestamp}</td>
                <td className="p-3 text-white font-bold">{log.userId}</td>
                <td className="p-3 text-slate-300">{log.userRole}</td>
                <td className="p-3 text-amber-400 font-bold">{log.patientId}</td>
                <td className="p-3">
                  <span className={`px-2 py-0.5 rounded font-bold ${log.actionType === 'BREAK_GLASS' ? 'bg-rose-900/80 text-rose-300 animate-pulse' : 'bg-sky-900/60 text-sky-300'}`}>
                    {log.actionType}
                  </span>
                </td>
                <td className="p-3 text-slate-400">{log.clientIpAddress}</td>
                <td className="p-3 text-slate-300 font-sans">{log.justificationNote}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};
