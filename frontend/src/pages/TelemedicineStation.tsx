import React, { useState } from 'react';
import {
  Video,
  Mic,
  MicOff,
  VideoOff,
  PhoneOff,
  MessageSquare,
  FileText,
  User,
  ShieldCheck,
  CheckCircle2,
  Lock,
} from 'lucide-react';

export const TelemedicineStation: React.FC = () => {
  const [micOn, setMicOn] = useState(true);
  const [videoOn, setVideoOn] = useState(true);
  const [inCall, setInCall] = useState(true);
  const [clinicalNotes, setClinicalNotes] = useState('Patient reports significant improvement in exertion tolerance since CABG stenting. No angina recurrence. Compliant with DAPT.');

  return (
    <div className="space-y-6">
      {/* Header */}
      <div className="flex flex-col sm:flex-row sm:items-center justify-between gap-4 bg-white p-6 rounded-3xl border border-slate-200 shadow-sm">
        <div>
          <h1 className="text-xl font-bold text-slate-900 tracking-tight flex items-center gap-2">
            <Video className="h-6 w-6 text-sky-600" />
            Telemedicine & Virtual Consultation Room
          </h1>
          <p className="text-xs text-slate-500 mt-1">
            HIPAA-compliant encrypted WebRTC peer-to-peer audio/video teleconsultation and EMR charting
          </p>
        </div>

        <div className="flex items-center gap-2 px-3 py-1.5 bg-emerald-50 border border-emerald-200 text-emerald-800 rounded-xl text-xs font-bold">
          <Lock className="h-4 w-4 text-emerald-600" />
          <span>AES-GCM-256 Encrypted Session</span>
        </div>
      </div>

      {/* Video & Charting Workspace */}
      <div className="grid grid-cols-1 lg:grid-cols-3 gap-6">
        {/* Video Simulation Box */}
        <div className="lg:col-span-2 bg-slate-950 rounded-3xl border border-slate-800 p-6 flex flex-col justify-between min-h-[480px] shadow-2xl relative overflow-hidden">
          <div className="flex items-center justify-between z-10">
            <div className="bg-slate-900/80 backdrop-blur px-3 py-1.5 rounded-xl border border-slate-700 text-xs text-slate-200">
              Patient: <strong className="text-white">Anand Patil (MRN-10001)</strong>
            </div>
            <span className="flex items-center gap-1.5 bg-rose-600/80 text-white text-[11px] font-bold px-2.5 py-1 rounded-full animate-pulse">
              <span className="h-2 w-2 rounded-full bg-white" /> REC 08:42
            </span>
          </div>

          {/* Central Video View Avatar */}
          <div className="flex flex-col items-center justify-center my-auto z-10">
            <div className="h-28 w-28 rounded-full bg-sky-950/80 border-4 border-sky-500/40 flex items-center justify-center text-sky-300 shadow-2xl">
              <User className="h-14 w-14" />
            </div>
            <h3 className="text-base font-bold text-white mt-3">Anand Patil</h3>
            <p className="text-xs text-slate-400">Cardiology Follow-Up Session</p>
          </div>

          {/* Call Controls Bar */}
          <div className="flex items-center justify-center gap-3 z-10 pt-4 border-t border-slate-800/80">
            <button
              onClick={() => setMicOn(!micOn)}
              className={`p-3.5 rounded-2xl transition-all ${
                micOn ? 'bg-slate-800 text-slate-200 hover:bg-slate-700' : 'bg-rose-600 text-white'
              }`}
            >
              {micOn ? <Mic className="h-5 w-5" /> : <MicOff className="h-5 w-5" />}
            </button>

            <button
              onClick={() => setVideoOn(!videoOn)}
              className={`p-3.5 rounded-2xl transition-all ${
                videoOn ? 'bg-slate-800 text-slate-200 hover:bg-slate-700' : 'bg-rose-600 text-white'
              }`}
            >
              {videoOn ? <Video className="h-5 w-5" /> : <VideoOff className="h-5 w-5" />}
            </button>

            <button
              onClick={() => setInCall(false)}
              className="px-6 py-3.5 bg-rose-600 hover:bg-rose-500 text-white rounded-2xl font-bold text-xs flex items-center gap-2 shadow-lg shadow-rose-600/30"
            >
              <PhoneOff className="h-4 w-4" /> End Call
            </button>
          </div>
        </div>

        {/* Side-by-Side Clinical Notes */}
        <div className="bg-white p-6 rounded-3xl border border-slate-200 shadow-sm flex flex-col justify-between text-xs space-y-4">
          <div className="space-y-3">
            <h3 className="text-sm font-bold text-slate-900 flex items-center gap-2">
              <FileText className="h-4 w-4 text-sky-600" />
              Concurrent Telehealth Clinical Notes
            </h3>

            <div>
              <label className="font-semibold text-slate-700 block mb-1">Subjective & Objective Findings</label>
              <textarea
                rows={6}
                value={clinicalNotes}
                onChange={(e) => setClinicalNotes(e.target.value)}
                className="w-full px-3 py-2 bg-slate-50 border border-slate-200 rounded-xl focus:bg-white focus:outline-none focus:ring-2 focus:ring-sky-500 leading-relaxed text-xs"
              />
            </div>
          </div>

          <button className="w-full py-3 bg-sky-600 hover:bg-sky-500 text-white rounded-xl font-bold text-xs shadow-md transition-colors">
            Save & Sign Telehealth Note
          </button>
        </div>
      </div>
    </div>
  );
};
