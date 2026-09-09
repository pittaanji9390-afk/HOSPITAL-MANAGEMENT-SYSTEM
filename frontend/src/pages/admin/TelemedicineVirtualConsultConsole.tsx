import React, { useState } from 'react';
import { Video, Mic, MicOff, VideoOff, PhoneOff, FileText, Send } from 'lucide-react';

export const TelemedicineVirtualConsultConsole: React.FC = () => {
  const [micOn, setMicOn] = useState<boolean>(true);
  const [videoOn, setVideoOn] = useState<boolean>(true);

  return (
    <div className="p-6 space-y-6 max-w-7xl mx-auto">
      <div className="flex items-center justify-between border-b pb-4">
        <div className="flex items-center space-x-3">
          <div className="p-3 bg-red-100 dark:bg-red-900/30 text-red-600 rounded-xl">
            <Video className="w-8 h-8" />
          </div>
          <div>
            <h1 className="text-2xl font-bold text-gray-900 dark:text-white">Telemedicine WebRTC Clinical Suite</h1>
            <p className="text-sm text-gray-500">Encrypted DTLS-SRTP 1080p video consultation with live SOAP clinical documentation</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-3 gap-6">
        <div className="lg:col-span-2 bg-gray-900 h-96 rounded-2xl flex flex-col justify-between p-6 relative">
          <div className="text-white text-sm font-semibold">Patient: John Doe (MRN-94820)</div>
          <div className="flex justify-center space-x-4">
            <button onClick={() => setMicOn(!micOn)} className={`p-3 rounded-full ${micOn ? 'bg-gray-700 text-white' : 'bg-red-600 text-white'}`}>
              {micOn ? <Mic className="w-6 h-6" /> : <MicOff className="w-6 h-6" />}
            </button>
            <button onClick={() => setVideoOn(!videoOn)} className={`p-3 rounded-full ${videoOn ? 'bg-gray-700 text-white' : 'bg-red-600 text-white'}`}>
              {videoOn ? <Video className="w-6 h-6" /> : <VideoOff className="w-6 h-6" />}
            </button>
            <button className="p-3 rounded-full bg-red-600 text-white hover:bg-red-700">
              <PhoneOff className="w-6 h-6" />
            </button>
          </div>
        </div>

        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-4 shadow-sm">
          <h2 className="text-lg font-semibold text-gray-900 dark:text-white">Tele-SOAP Notes</h2>
          <textarea rows={8} placeholder="Document Subjective, Objective, Assessment, Plan..." className="w-full p-3 border rounded-xl dark:bg-gray-700 dark:border-gray-600 text-xs"></textarea>
          <button className="w-full py-2 bg-indigo-600 text-white rounded-lg text-xs font-semibold">Sign & E-Prescribe</button>
        </div>
      </div>
    </div>
  );
};

export default TelemedicineVirtualConsultConsole;
