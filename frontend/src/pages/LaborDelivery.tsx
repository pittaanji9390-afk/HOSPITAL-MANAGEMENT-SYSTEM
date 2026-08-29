import React, { useState } from 'react';
import {
  Heart,
  Baby,
  Activity,
  Clock,
  CheckCircle2,
  AlertTriangle,
  Plus,
} from 'lucide-react';
import {
  LineChart,
  Line,
  XAxis,
  YAxis,
  CartesianGrid,
  Tooltip,
  ResponsiveContainer,
} from 'recharts';

export const LaborDelivery: React.FC = () => {
  const partographData = [
    { time: '08:00', dilation: 4, alert: 4, action: null },
    { time: '10:00', dilation: 5, alert: 6, action: null },
    { time: '12:00', dilation: 7, alert: 8, action: 4 },
    { time: '14:00', dilation: 9, alert: 10, action: 6 },
    { time: '15:30', dilation: 10, alert: 10, action: 7.5 },
  ];

  return (
    <div className="space-y-6">
      {/* Header */}
      <div className="bg-white p-6 rounded-3xl border border-slate-200 shadow-sm">
        <h1 className="text-xl font-bold text-slate-900 tracking-tight flex items-center gap-2">
          <Baby className="h-6 w-6 text-rose-500" />
          Obstetrics & Labor & Delivery (L&D) Suite
        </h1>
        <p className="text-xs text-slate-500 mt-1">
          WHO Partograph labor curve monitoring, fetal cardiotocography (CTG), and Postpartum Hemorrhage (PPH) safety bundles
        </p>
      </div>

      {/* Partograph Visualizer */}
      <div className="bg-white p-6 rounded-3xl border border-slate-200 shadow-sm space-y-4">
        <div className="flex items-center justify-between flex-wrap gap-2">
          <div>
            <h3 className="text-sm font-bold text-slate-900">
              Active Partograph Curve — Patient: Deepa Rao (G2P1, 39w2d)
            </h3>
            <p className="text-xs text-slate-500">Cervical Dilation (cm) vs WHO Alert and Action Lines</p>
          </div>
          <span className="px-3 py-1 bg-emerald-100 text-emerald-800 rounded-full text-xs font-bold">
            Normal Progress (Above Action Line)
          </span>
        </div>

        <div className="h-64 w-full">
          <ResponsiveContainer width="100%" height="100%">
            <LineChart data={partographData}>
              <CartesianGrid strokeDasharray="3 3" vertical={false} stroke="#f1f5f9" />
              <XAxis dataKey="time" tick={{ fontSize: 12, fill: '#64748b' }} />
              <YAxis domain={[0, 10]} ticks={[0, 2, 4, 6, 8, 10]} tick={{ fontSize: 12, fill: '#64748b' }} unit=" cm" />
              <Tooltip />
              <Line type="monotone" dataKey="dilation" name="Cervical Dilation (cm)" stroke="#0ea5e9" strokeWidth={3} dot={{ r: 5 }} />
              <Line type="monotone" dataKey="alert" name="Alert Line" stroke="#f59e0b" strokeDasharray="5 5" strokeWidth={2} />
              <Line type="monotone" dataKey="action" name="Action Line" stroke="#ef4444" strokeDasharray="5 5" strokeWidth={2} />
            </LineChart>
          </ResponsiveContainer>
        </div>
      </div>
    </div>
  );
};
