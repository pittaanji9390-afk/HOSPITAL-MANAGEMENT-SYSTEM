import React, { useState } from 'react';

export const DamerauLevenshteinConsole: React.FC = () => {
  return (
    <div className="p-6 bg-slate-900 text-slate-100 min-h-screen">
      <header className="mb-6 flex justify-between items-center border-b border-slate-800 pb-4">
        <div>
          <h1 className="text-2xl font-bold text-sky-400">Damerau-Levenshtein Edit Distance Matrix</h1>
          <p className="text-sm text-slate-400">Adjacent Transposition, Insertion &amp; Deletion Cost Calculation</p>
        </div>
      </header>

      <div className="p-5 bg-slate-800/80 rounded-xl border border-slate-700 font-mono text-xs">
        <h2 className="text-base font-bold text-white mb-2">Edit Distance: 1 Operation</h2>
        <p className="text-slate-300">"Smith" ➔ "Smyth" (Substitution: 1 cost)</p>
      </div>
    </div>
  );
};
