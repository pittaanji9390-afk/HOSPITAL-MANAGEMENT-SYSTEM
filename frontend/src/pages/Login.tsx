import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { Stethoscope, Lock, User, Shield, AlertCircle, ArrowRight } from 'lucide-react';
import { useAuth, DEMO_PERSONAS } from '../context/AuthContext';

export const Login: React.FC = () => {
  const { login, isLoading, switchUser } = useAuth();
  const [username, setUsername] = useState('superadmin');
  const [password, setPassword] = useState('Hospital@123');
  const [error, setError] = useState<string | null>(null);
  const navigate = useNavigate();

  const handleLogin = async (e: React.FormEvent) => {
    e.preventDefault();
    setError(null);
    try {
      await login(username, password);
      navigate('/');
    } catch (err: any) {
      setError(err?.response?.data?.message || 'Invalid username or password. Please try again.');
    }
  };

  const handleQuickLogin = (roleKey: string) => {
    const persona = DEMO_PERSONAS[roleKey];
    if (persona) {
      switchUser(roleKey);
      navigate('/');
    }
  };

  return (
    <div className="min-h-screen bg-slate-950 flex flex-col justify-center items-center p-4 relative overflow-hidden">
      {/* Background glow highlights */}
      <div className="absolute -top-40 -left-40 w-96 h-96 bg-sky-500/20 rounded-full blur-3xl pointer-events-none" />
      <div className="absolute -bottom-40 -right-40 w-96 h-96 bg-teal-500/20 rounded-full blur-3xl pointer-events-none" />

      <div className="w-full max-w-md bg-slate-900 border border-slate-800 rounded-3xl p-8 shadow-2xl relative z-10">
        {/* Brand Header */}
        <div className="text-center mb-8">
          <div className="inline-flex h-14 w-14 rounded-2xl bg-gradient-to-tr from-sky-500 to-teal-400 items-center justify-center text-white shadow-lg shadow-sky-500/30 mb-4">
            <Stethoscope className="h-8 w-8" />
          </div>
          <h1 className="text-2xl font-bold text-white tracking-tight">Apex Memorial</h1>
          <p className="text-xs text-sky-400 font-semibold tracking-wider uppercase mt-1">
            Enterprise Hospital Platform
          </p>
        </div>

        {error && (
          <div className="mb-6 p-3.5 bg-rose-500/10 border border-rose-500/30 rounded-2xl flex items-center gap-3 text-rose-300 text-xs">
            <AlertCircle className="h-5 w-5 shrink-0" />
            <p>{error}</p>
          </div>
        )}

        {/* Credentials Form */}
        <form onSubmit={handleLogin} className="space-y-4">
          <div>
            <label className="text-xs font-semibold text-slate-300 block mb-1.5">
              Username or Email
            </label>
            <div className="relative">
              <User className="absolute left-3.5 top-1/2 -translate-y-1/2 h-4 w-4 text-slate-500" />
              <input
                type="text"
                required
                value={username}
                onChange={(e) => setUsername(e.target.value)}
                placeholder="Enter staff username"
                className="w-full pl-10 pr-4 py-2.5 bg-slate-800/80 border border-slate-700 text-white rounded-xl text-xs focus:outline-none focus:ring-2 focus:ring-sky-500 placeholder:text-slate-500"
              />
            </div>
          </div>

          <div>
            <label className="text-xs font-semibold text-slate-300 block mb-1.5">Password</label>
            <div className="relative">
              <Lock className="absolute left-3.5 top-1/2 -translate-y-1/2 h-4 w-4 text-slate-500" />
              <input
                type="password"
                required
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                placeholder="Enter security password"
                className="w-full pl-10 pr-4 py-2.5 bg-slate-800/80 border border-slate-700 text-white rounded-xl text-xs focus:outline-none focus:ring-2 focus:ring-sky-500 placeholder:text-slate-500"
              />
            </div>
          </div>

          <button
            type="submit"
            disabled={isLoading}
            className="w-full mt-2 py-3 bg-gradient-to-r from-sky-600 to-sky-500 hover:from-sky-500 hover:to-sky-400 text-white text-xs font-bold rounded-xl shadow-lg shadow-sky-600/30 transition-all flex items-center justify-center gap-2"
          >
            {isLoading ? 'Authenticating...' : 'Sign In to Clinical Portal'}
            <ArrowRight className="h-4 w-4" />
          </button>
        </form>

        {/* Quick Workstation Persona Presets */}
        <div className="mt-8 pt-6 border-t border-slate-800">
          <p className="text-[11px] font-semibold text-slate-400 uppercase tracking-wider mb-3 text-center">
            One-Click Workstation Access
          </p>
          <div className="grid grid-cols-2 gap-2">
            {Object.entries(DEMO_PERSONAS).map(([key, item]) => (
              <button
                key={key}
                type="button"
                onClick={() => handleQuickLogin(key)}
                className="p-2.5 bg-slate-800/60 hover:bg-slate-800 border border-slate-700/60 hover:border-sky-500/50 rounded-xl text-left transition-all group"
              >
                <p className="text-[11px] font-semibold text-slate-200 group-hover:text-sky-300 capitalize">
                  {key}
                </p>
                <p className="text-[10px] text-slate-400 truncate">{item.desc}</p>
              </button>
            ))}
          </div>
        </div>

        <div className="mt-6 flex items-center justify-center gap-2 text-[11px] text-slate-500">
          <Shield className="h-3.5 w-3.5" />
          <span>256-Bit TLS & Encrypted Healthcare Records</span>
        </div>
      </div>
    </div>
  );
};
