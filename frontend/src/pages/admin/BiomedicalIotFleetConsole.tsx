import React, { useState } from 'react';
import { Wifi, Activity, BatteryCharging, AlertOctagon, CheckCircle2 } from 'lucide-react';

export const BiomedicalIotFleetConsole: React.FC = () => {
  const devices = [
    { serial: 'VENT-ICU-04', type: 'HAMILTON-G5 VENTILATOR', bed: 'ICU-BED-04', status: 'ONLINE', param: 'Vt 450 mL | PEEP 5.0 | P/F 240' },
    { serial: 'PUMP-ICU-09', type: 'ALARIS INFUSION PUMP', bed: 'ICU-BED-09', status: 'ONLINE', param: 'Norepinephrine 0.08 mcg/kg/min' },
    { serial: 'MON-CCU-02', type: 'PHILIPS INTELLIVUE MX800', bed: 'CCU-BED-02', status: 'ALARM', param: 'HR 118 | ST Elevation +2.4 mm' },
  ];

  return (
    <div className="p-6 space-y-6 max-w-7xl mx-auto">
      <div className="flex items-center justify-between border-b pb-4">
        <div className="flex items-center space-x-3">
          <div className="p-3 bg-cyan-100 dark:bg-cyan-900/30 text-cyan-600 rounded-xl">
            <Wifi className="w-8 h-8" />
          </div>
          <div>
            <h1 className="text-2xl font-bold text-gray-900 dark:text-white">Biomedical IoT Telemetry Fleet Manager</h1>
            <p className="text-sm text-gray-500">IEEE 11073 device telemetry streams, MQTT shadows & critical bedside alarms</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-3 gap-6">
        {devices.map((d, i) => (
          <div key={i} className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-4 shadow-sm">
            <div className="flex justify-between items-center">
              <span className="font-bold text-sm text-gray-900 dark:text-white">{d.serial}</span>
              <span className={`px-2.5 py-1 rounded-full text-xs font-semibold ${d.status === 'ALARM' ? 'bg-red-500 text-white animate-pulse' : 'bg-green-100 text-green-700'}`}>
                {d.status}
              </span>
            </div>
            <div className="text-xs text-gray-500">{d.type} • {d.bed}</div>
            <div className="p-3 bg-gray-50 dark:bg-gray-700/50 rounded-xl font-mono text-xs text-cyan-700 dark:text-cyan-300">
              {d.param}
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default BiomedicalIotFleetConsole;
