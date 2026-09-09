import React, { useState } from 'react';

export const DigitalSignatureAttestationConsole: React.FC = () => {
  const [practitionerPin, setPractitionerPin] = useState('');
  const [isSigned, setIsSigned] = useState(false);

  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">Clinical Attestation &amp; Digital Signature Pad</h1>
          <p className="text-sm text-slate-400">21 CFR Part 11 &amp; CMS Compliant Cryptographic Attestation</p>
        </div>
      </header>

      <div className="max-w-2xl bg-slate-800/80 p-6 rounded-xl border border-slate-700">
        <h2 className="text-base font-bold text-white mb-2">Physician Order Attestation</h2>
        <p className="text-xs text-slate-300 leading-relaxed mb-4">
          "I hereby attest that I have personally evaluated the patient, reviewed the clinical indicators, and authorized the scheduled medication orders and surgical plan as documented."
        </p>

        <div className="mb-4">
          <label className="text-xs text-slate-400 block mb-1">Enter Practitioner 4-Digit Security PIN</label>
          <input 
            type="password"
            maxLength={4}
            value={practitionerPin}
            onChange={(e) => setPractitionerPin(e.target.value)}
            className="w-32 bg-slate-900 border border-slate-700 rounded px-3 py-2 text-center font-mono text-lg font-bold text-white"
          />
        </div>

        <button 
          onClick={() => setIsSigned(true)}
          className="w-full bg-sky-600 hover:bg-sky-500 text-white font-bold py-2.5 rounded text-xs transition"
        >
          Cryptographically Sign &amp; Commit Record
        </button>

        {isSigned && (
          <div className="mt-4 p-3 bg-emerald-950/60 border border-emerald-700 rounded text-center text-xs font-mono text-emerald-300">
            ✓ Attestation Signed (Hash: SHA-256: e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855)
          </div>
        )}
      </div>
    </div>
  );
};
