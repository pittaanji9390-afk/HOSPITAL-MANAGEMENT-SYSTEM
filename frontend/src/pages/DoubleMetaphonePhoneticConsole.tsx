import React, { useState } from 'react';

export const DoubleMetaphonePhoneticConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">Soundex &amp; Double Metaphone Phonetic Index</h1>
          <p className="text-sm text-slate-400">Phonetic Grouping for Clinical Misspellings and Accents</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700 font-mono text-xs">
        <h2 className="text-base font-bold text-white mb-2">Soundex Code: S530 ("Smith" / "Schmidt")</h2>
        <p className="text-emerald-400">Phonetically Identical under Soundex Rules</p>
      </div>
    </div>
  );
};
