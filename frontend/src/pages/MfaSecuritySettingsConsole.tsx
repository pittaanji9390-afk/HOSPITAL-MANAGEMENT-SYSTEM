import React, { useState } from 'react';

export const MfaSecuritySettingsConsole: React.FC = () => {
  const [totpCode, setTotpCode] = useState('');
  const [isEnrolled, setIsEnrolled] = useState(true);

  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">Two-Factor Authentication &amp; Hardware Key Settings</h1>
          <p className="text-sm text-slate-400">DEA EPCS Compliant FIDO2 / WebAuthn &amp; Time-Based One-Time Password (TOTP)</p>
        </div>
      </header>

      <div className="max-w-2xl space-y-6">
        <div className="bg-slate-800/80 p-5 rounded-xl border border-slate-700">
          <h2 className="text-base font-bold text-white mb-2">Authenticator App (TOTP)</h2>
          <p className="text-xs text-slate-400 mb-4">Use Google Authenticator, Microsoft Authenticator, or Yubico Authenticator.</p>
          
          <div className="flex gap-4 items-center mb-4">
            <div className="bg-white p-3 rounded-lg text-slate-900 font-mono text-center text-xs font-bold">
              [QR CODE SIMULATION]
            </div>
            <div className="flex-1 text-xs text-slate-300">
              <p className="font-mono text-sky-300 font-bold mb-1">SECRET KEY: JBSWY3DPEHPK3PXP</p>
              <p>Scan this QR code in your authenticator application to generate 6-digit one-time passcodes.</p>
            </div>
          </div>

          <div className="flex gap-3">
            <input 
              type="text" 
              maxLength={6}
              placeholder="000000"
              value={totpCode}
              onChange={(e) => setTotpCode(e.target.value)}
              className="w-32 bg-slate-900 border border-slate-700 rounded px-3 py-2 text-center font-mono text-lg font-bold text-white"
            />
            <button className="bg-emerald-600 hover:bg-emerald-500 text-white px-4 py-2 rounded text-xs font-semibold">
              Verify &amp; Save TOTP
            </button>
          </div>
        </div>
      </div>
    </div>
  );
};
