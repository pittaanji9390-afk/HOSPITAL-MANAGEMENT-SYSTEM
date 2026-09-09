import React, { useState } from 'react';

export const AddressStandardizationConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">USPS CASS Address Standardization Studio</h1>
          <p className="text-sm text-slate-400">Address Abbreviation Expansion &amp; ZIP+4 Normalization</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <h2 className="text-base font-bold text-white mb-2">Normalized: 123 HEALTHCARE AVE STE 400</h2>
        <p className="text-xs text-slate-300">Raw Input: "123 Healthcare Avenue, Suite 400"</p>
      </div>
    </div>
  );
};
