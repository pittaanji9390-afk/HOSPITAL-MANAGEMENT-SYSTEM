import React, { useState, useEffect } from 'react';
import {
  ScanLine,
  Search,
  Eye,
  CheckCircle2,
  Calendar,
  Layers,
  Image as ImageIcon,
} from 'lucide-react';
import { apiClient } from '../api/client';
import { RadiologyOrder, PagedResponse, ApiResponse } from '../types';

export const Radiology: React.FC = () => {
  const [orders, setOrders] = useState<RadiologyOrder[]>([
    {
      id: 1,
      orderNo: 'RAD-10001',
      patientId: 1,
      patientName: 'Anand Patil',
      patientMrn: 'MRN-10001',
      doctorId: 1,
      doctorName: 'Dr. Rajesh Sharma',
      examinationId: 1,
      examinationName: 'Chest X-Ray PA View',
      modality: 'X_RAY',
      bodyPart: 'Chest / Thorax',
      priority: 'ROUTINE',
      clinicalHistory: 'Post-CABG evaluation for cardiopulmonary stability',
      findings:
        'Normal cardiac silhouette. No pleural effusion or pneumothorax identified. Clear lung parenchyma bilaterally. Sternal wires intact and in anatomical alignment.',
      impression: 'Normal post-surgical chest radiography.',
      status: 'REPORTED',
      createdAt: '2026-08-28T11:00:00Z',
    },
    {
      id: 2,
      orderNo: 'RAD-10002',
      patientId: 2,
      patientName: 'Deepa Rao',
      patientMrn: 'MRN-10002',
      doctorId: 2,
      doctorName: 'Dr. Priya Nair',
      examinationId: 5,
      examinationName: 'MRI Lumbar Spine with Screening',
      modality: 'MRI',
      bodyPart: 'Lumbar Spine',
      priority: 'ROUTINE',
      clinicalHistory: 'L4-L5 disc protrusion evaluation',
      status: 'SCHEDULED',
      createdAt: '2026-08-29T09:15:00Z',
    },
  ]);

  useEffect(() => {
    apiClient
      .get<ApiResponse<PagedResponse<RadiologyOrder>>>('/radiology/orders')
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
            <ScanLine className="h-6 w-6 text-sky-600" />
            Radiology & Diagnostic Imaging
          </h1>
          <p className="text-xs text-slate-500 mt-1">
            X-Ray, CT Scan, MRI, Ultrasound modalities, PACS linkage, and radiologist impressions
          </p>
        </div>
      </div>

      {/* Radiology Orders List */}
      <div className="space-y-4">
        {orders.map((order) => (
          <div key={order.id} className="bg-white p-6 rounded-3xl border border-slate-200 shadow-sm space-y-4">
            <div className="flex items-center justify-between flex-wrap gap-2">
              <div>
                <span className="font-mono font-bold text-xs text-sky-700">{order.orderNo}</span>
                <h3 className="text-sm font-bold text-slate-900">
                  {order.examinationName}{' '}
                  <span className="text-xs font-normal text-slate-500">
                    ({order.modality} • {order.bodyPart})
                  </span>
                </h3>
                <p className="text-xs text-slate-500">
                  Patient: <span className="font-semibold text-slate-800">{order.patientName}</span> ({order.patientMrn}) • Ordered by {order.doctorName}
                </p>
              </div>

              <span className="px-2.5 py-1 rounded-full text-[10px] font-bold bg-sky-100 text-sky-800">
                {order.status}
              </span>
            </div>

            {order.findings && (
              <div className="p-4 bg-slate-50 rounded-2xl border border-slate-100 space-y-2 text-xs">
                <div>
                  <span className="font-bold text-slate-700 uppercase text-[10px]">Findings:</span>
                  <p className="text-slate-800 leading-relaxed mt-0.5">{order.findings}</p>
                </div>
                {order.impression && (
                  <div className="pt-2 border-t border-slate-200/60">
                    <span className="font-bold text-sky-700 uppercase text-[10px]">Impression:</span>
                    <p className="font-semibold text-slate-900 mt-0.5">{order.impression}</p>
                  </div>
                )}
              </div>
            )}
          </div>
        ))}
      </div>
    </div>
  );
};
