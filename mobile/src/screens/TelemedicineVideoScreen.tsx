import React, { useState } from 'react';
import {
  Video,
  Mic,
  MicOff,
  VideoOff,
  PhoneOff,
  User,
  MessageSquare,
  ShieldCheck,
} from 'lucide-react';

export const TelemedicineVideoScreen: React.FC = () => {
  const [mic, setMic] = useState(true);
  const [cam, setCam] = useState(true);

  return (
    <div className="space-y-4 pb-20">
      <div className="p-4 bg-slate-800 rounded-2xl border border-slate-700 flex items-center justify-between">
        <div>
          <span className="text-[10px] font-bold text-sky-400 block">ENCRYPTED TELEHEALTH</span>
          <h3 className="text-sm font-bold text-white">Dr. Rajesh Sharma (Cardiologist)</h3>
        </div>
        <span className="px-2.5 py-1 rounded-full text-[10px] font-bold bg-emerald-950 text-emerald-300 border border-emerald-800">
          Connected
        </span>
      </div>

      <div className="bg-slate-950 rounded-3xl border border-slate-800 p-6 flex flex-col items-center justify-center min-h-[360px] text-center space-y-3 relative shadow-2xl">
        <div className="h-24 w-24 rounded-full bg-sky-900/60 border-2 border-sky-400 flex items-center justify-center text-sky-300 shadow-xl">
          <User className="h-12 w-12" />
        </div>
        <div>
          <h4 className="text-sm font-bold text-white">Dr. Rajesh Sharma</h4>
          <p className="text-[11px] text-slate-400">Chief Interventional Cardiologist</p>
        </div>

        <div className="flex items-center justify-center gap-3 pt-4">
          <button
            onClick={() => setMic(!mic)}
            className={`p-3 rounded-xl ${mic ? 'bg-slate-800 text-white' : 'bg-rose-600 text-white'}`}
          >
            {mic ? <Mic className="h-4 w-4" /> : <MicOff className="h-4 w-4" />}
          </button>
          <button
            onClick={() => setCam(!cam)}
            className={`p-3 rounded-xl ${cam ? 'bg-slate-800 text-white' : 'bg-rose-600 text-white'}`}
          >
            {cam ? <Video className="h-4 w-4" /> : <VideoOff className="h-4 w-4" />}
          </button>
          <button className="p-3 bg-rose-600 text-white rounded-xl">
            <PhoneOff className="h-4 w-4" />
          </button>
        </div>
      </div>
    </div>
  );
};
