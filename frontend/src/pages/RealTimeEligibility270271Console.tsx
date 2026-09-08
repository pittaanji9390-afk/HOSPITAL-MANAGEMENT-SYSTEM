import React, { useState } from 'react';
import { SAMPLE_270_INQUIRY } from '../types/edi270Request';

export const RealTimeEligibility270271Console: React.FC = () => {
  const [inquiry, setInquiry] = useState(SAMPLE_270_INQUIRY);

  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">Real-Time Eligibility &amp; Benefits (270/271)</h1>
          <p className="text-sm text-slate-400">Instant Insurance Verification, Co-pay Breakdown &amp; Deductible Balance</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700">
        <h2 className="text-base font-bold text-white mb-2">Payer: Blue Cross PPO (Member: {inquiry.patientMemberId})</h2>
        <p className="text-xs text-emerald-400 font-mono">STATUS: ACTIVE COVERAGE | Co-pay: $25 PCP / $50 Specialist / $250 ER</p>
      </div>
    </div>
  );
};
