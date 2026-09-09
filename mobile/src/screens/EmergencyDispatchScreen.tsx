import React, { useState } from 'react';
import {
  Flame,
  Radio,
  MapPin,
  Clock,
  Phone,
  ShieldAlert,
  CheckCircle2,
} from 'lucide-react';

export const EmergencyDispatchScreen: React.FC = () => {
  return (
    <div className="space-y-4 pb-20">
      <div className="p-4 bg-rose-950/60 border border-rose-800 rounded-2xl flex items-center justify-between">
        <div>
          <span className="text-[10px] font-bold text-rose-300 block">AMBULANCE GPS DISPATCH</span>
          <h3 className="text-sm font-bold text-white">Active Emergency Fleet</h3>
        </div>
        <span className="px-2.5 py-1 rounded-full text-[10px] font-bold bg-rose-600 text-white animate-pulse">
          2 Active Calls
        </span>
      </div>

      <div className="space-y-3">
        {[
          {
            unit: 'Ambulance Unit 01 (ALS Mobile ICU)',
            driver: 'Sanjay Yadav (Paramedic)',
            location: 'Indiranagar 100ft Road (3.2 km away)',
            eta: 'ETA 6 mins',
            status: 'EN_ROUTE_TO_HOSPITAL',
            patient: 'Male 58y, Severe Chest Pain / STEMI suspected',
          },
          {
            unit: 'Ambulance Unit 02 (BLS)',
            driver: 'Manoj Kumar',
            location: 'Koramangala 4th Block',
            eta: 'ETA 14 mins',
            status: 'DISPATCHED_TO_SCENE',
            patient: 'Female 72y, Syncope / Fall',
          },
        ].map((amb, idx) => (
          <div key={idx} className="p-4 bg-slate-800 rounded-2xl border border-slate-700 space-y-2.5 text-xs">
            <div className="flex items-start justify-between">
              <div>
                <span className="font-bold text-white block text-sm">{amb.unit}</span>
                <span className="text-[11px] text-slate-400 font-medium">{amb.driver}</span>
              </div>
              <span className="px-2 py-0.5 rounded text-[10px] font-bold bg-rose-900 text-rose-200">
                {amb.eta}
              </span>
            </div>

            <div className="p-2.5 bg-slate-900 rounded-xl border border-slate-800 text-[11px] space-y-1">
              <p className="text-slate-300"><strong>Patient:</strong> {amb.patient}</p>
              <p className="text-sky-400 flex items-center gap-1"><MapPin className="h-3 w-3" /> {amb.location}</p>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};
