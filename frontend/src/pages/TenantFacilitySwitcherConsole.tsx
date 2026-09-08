import React, { useState } from 'react';
import { FACILITY_BRANCH_CATALOG } from '../types/multiTenantHierarchy';

export const TenantFacilitySwitcherConsole: React.FC = () => {
  const [selectedFacility, setSelectedFacility] = useState('FAC-MAIN');

  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">Multi-Tenant Facility &amp; Organization Switcher</h1>
          <p className="text-sm text-slate-400">Enterprise Health System Partitioning, Campus Hierarchy &amp; CLIA License Audit</p>
        </div>
      </header>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
        {FACILITY_BRANCH_CATALOG.map((fac) => (
          <div 
            key={fac.facilityId}
            onClick={() => setSelectedFacility(fac.facilityId)}
            className={`p-5 rounded-xl border cursor-pointer transition ${selectedFacility === fac.facilityId ? 'bg-sky-950/50 border-sky-500 ring-2 ring-sky-500/50' : 'bg-slate-800/80 border-slate-700 hover:border-slate-600'}`}
          >
            <div className="flex justify-between items-start mb-3">
              <div>
                <span className="text-xs font-mono text-sky-400 font-bold">{fac.facilityId}</span>
                <h2 className="text-lg font-bold text-white">{fac.facilityName}</h2>
                <p className="text-xs text-slate-400">{fac.facilityType}</p>
              </div>
              <span className="px-3 py-1 bg-slate-700 text-slate-200 text-xs font-semibold rounded">
                {fac.traumaCenterLevel}
              </span>
            </div>

            <div className="grid grid-cols-3 gap-3 bg-slate-900/80 p-3 rounded-lg border border-slate-700/60 font-mono text-xs text-center mb-3">
              <div>
                <span className="text-slate-400 block">Total Beds</span>
                <span className="text-sm font-bold text-white">{fac.totalLicensedBeds}</span>
              </div>
              <div>
                <span className="text-slate-400 block">ICU Capacity</span>
                <span className="text-sm font-bold text-sky-300">{fac.icuBedCapacity} Beds</span>
              </div>
              <div>
                <span className="text-slate-400 block">CLIA Number</span>
                <span className="text-xs font-bold text-amber-300">{fac.cliaLicenseNumber}</span>
              </div>
            </div>

            <div className="text-right">
              <span className={`text-xs font-semibold ${selectedFacility === fac.facilityId ? 'text-emerald-400 font-bold' : 'text-slate-400'}`}>
                {selectedFacility === fac.facilityId ? '✓ ACTIVE ACTIVE CAMPUS' : 'Click to Switch Campus'}
              </span>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};
