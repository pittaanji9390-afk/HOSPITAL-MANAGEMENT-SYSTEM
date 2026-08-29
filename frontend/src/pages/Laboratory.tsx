import React, { useState, useEffect } from 'react';
import {
  TestTube2,
  Search,
  CheckCircle2,
  AlertTriangle,
  Clock,
  Plus,
  Barcode,
} from 'lucide-react';
import { apiClient } from '../api/client';
import { LabOrder, LabTest, PagedResponse, ApiResponse } from '../types';

export const Laboratory: React.FC = () => {
  const [orders, setOrders] = useState<LabOrder[]>([
    {
      id: 1,
      orderNo: 'LAB-10001',
      patientId: 1,
      patientName: 'Anand Patil',
      patientMrn: 'MRN-10001',
      doctorId: 1,
      doctorName: 'Dr. Rajesh Sharma',
      priority: 'ROUTINE',
      clinicalIndication: 'Routine fasting metabolic profile evaluation',
      status: 'COMPLETED',
      orderedAt: '2026-08-28T09:00:00Z',
      items: [
        {
          id: 1,
          testId: 2,
          testCode: 'LAB-GLUC-F',
          testName: 'Fasting Blood Glucose (FBG)',
          category: 'BIOCHEMISTRY',
          specimenType: 'SERUM',
          sampleBarcode: 'SMP-849201',
          resultValue: '92.0 mg/dL',
          resultNumeric: 92.0,
          normalRangeSnapshot: '70.0 - 100.0 mg/dL',
          abnormal: false,
          critical: false,
          verifiedByName: 'Rahul Sen (Lead Tech)',
          verifiedAt: '2026-08-28T11:30:00Z',
          status: 'VERIFIED',
        },
        {
          id: 2,
          testId: 3,
          testCode: 'LAB-HBA1C',
          testName: 'Glycated Hemoglobin (HbA1c)',
          category: 'BIOCHEMISTRY',
          specimenType: 'BLOOD',
          sampleBarcode: 'SMP-849202',
          resultValue: '5.4 %',
          resultNumeric: 5.4,
          normalRangeSnapshot: '4.0 - 5.6 %',
          abnormal: false,
          critical: false,
          verifiedByName: 'Rahul Sen (Lead Tech)',
          verifiedAt: '2026-08-28T11:30:00Z',
          status: 'VERIFIED',
        },
      ],
    },
    {
      id: 2,
      orderNo: 'LAB-10002',
      patientId: 2,
      patientName: 'Deepa Rao',
      patientMrn: 'MRN-10002',
      doctorId: 2,
      doctorName: 'Dr. Priya Nair',
      priority: 'URGENT',
      clinicalIndication: 'Pre-operative complete blood count',
      status: 'IN_PROCESS',
      orderedAt: '2026-08-29T08:30:00Z',
      items: [
        {
          id: 3,
          testId: 1,
          testCode: 'LAB-CBC',
          testName: 'Complete Blood Count (CBC)',
          category: 'HEMATOLOGY',
          specimenType: 'BLOOD',
          sampleBarcode: 'SMP-934812',
          abnormal: false,
          critical: false,
          status: 'COLLECTED',
        },
      ],
    },
  ]);

  useEffect(() => {
    apiClient
      .get<ApiResponse<PagedResponse<LabOrder>>>('/laboratory/orders')
      .then((res) => {
        if (res.data?.success && res.data?.data?.content) {
          setOrders(res.data.data.content);
        }
      })
      .catch(() => {});
  }, []);

  return (
    <div className="space-y-6">
      {/* Header */}
      <div className="flex flex-col sm:flex-row sm:items-center justify-between gap-4 bg-white p-6 rounded-3xl border border-slate-200 shadow-sm">
        <div>
          <h1 className="text-xl font-bold text-slate-900 tracking-tight flex items-center gap-2">
            <TestTube2 className="h-6 w-6 text-sky-600" />
            Laboratory Diagnostic Center
          </h1>
          <p className="text-xs text-slate-500 mt-1">
            Specimen intake, barcode verification, abnormal flag detection, and pathologist reports
          </p>
        </div>
      </div>

      {/* Lab Orders List */}
      <div className="space-y-4">
        {orders.map((order) => (
          <div key={order.id} className="bg-white p-6 rounded-3xl border border-slate-200 shadow-sm space-y-4">
            <div className="flex items-center justify-between flex-wrap gap-2">
              <div>
                <span className="font-mono font-bold text-xs text-sky-700">{order.orderNo}</span>
                <h3 className="text-sm font-bold text-slate-900">
                  {order.patientName}{' '}
                  <span className="text-xs font-normal text-slate-400 font-mono">({order.patientMrn})</span>
                </h3>
                <p className="text-xs text-slate-500">
                  Ordered by {order.doctorName} • Priority:{' '}
                  <span className="font-semibold text-slate-700">{order.priority}</span>
                </p>
              </div>

              <span className="px-2.5 py-1 rounded-full text-[10px] font-bold bg-sky-100 text-sky-800">
                {order.status}
              </span>
            </div>

            {/* Test Items Table */}
            <div className="overflow-x-auto">
              <table className="w-full text-left text-xs border border-slate-100 rounded-xl">
                <thead className="bg-slate-50 text-slate-500 font-semibold">
                  <tr>
                    <th className="py-2.5 px-3">Test Name / Code</th>
                    <th className="py-2.5 px-3">Specimen</th>
                    <th className="py-2.5 px-3">Barcode</th>
                    <th className="py-2.5 px-3">Result Value</th>
                    <th className="py-2.5 px-3">Reference Range</th>
                    <th className="py-2.5 px-3">Technician / Verifier</th>
                    <th className="py-2.5 px-3 text-right">Status</th>
                  </tr>
                </thead>
                <tbody className="divide-y divide-slate-100">
                  {order.items.map((item) => (
                    <tr key={item.id}>
                      <td className="py-2.5 px-3 font-semibold text-slate-900">
                        {item.testName}
                        <span className="block text-[10px] text-slate-400 font-mono">{item.testCode}</span>
                      </td>
                      <td className="py-2.5 px-3 text-slate-600">{item.specimenType}</td>
                      <td className="py-2.5 px-3 font-mono text-[11px] text-slate-700">
                        {item.sampleBarcode || 'Unassigned'}
                      </td>
                      <td className="py-2.5 px-3 font-bold text-slate-900">
                        {item.resultValue || 'Pending Result'}
                      </td>
                      <td className="py-2.5 px-3 text-slate-600 font-mono text-[11px]">
                        {item.normalRangeSnapshot || 'Standard'}
                      </td>
                      <td className="py-2.5 px-3 text-slate-600">{item.verifiedByName || 'Pending verification'}</td>
                      <td className="py-2.5 px-3 text-right">
                        <span className="px-2 py-0.5 rounded text-[10px] font-semibold bg-slate-100 text-slate-700">
                          {item.status}
                        </span>
                      </td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};
