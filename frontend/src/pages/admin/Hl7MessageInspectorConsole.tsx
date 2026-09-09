import React, { useState } from 'react';
import { Terminal, Activity, RefreshCw, CheckCircle2, AlertTriangle } from 'lucide-react';

export const Hl7MessageInspectorConsole: React.FC = () => {
  const [selectedMsg, setSelectedMsg] = useState<string>('ADT^A01');
  const rawHl7 = `MSH|^~\&|EMR_SOURCE|WARD_01|CORE_HMS|CENTRAL|20260908164000||ADT^A01|MSG-94820|P|2.5EVN|A01|20260908164000PID|1||MRN-94820^^^HOSP||DOE^JOHN^^^^^L||19850612|MPV1|1|I|ICU^BED-04^01||||DR-7719^GUPTA^ANANYA^^^MD`;

  return (
    <div className="p-6 space-y-6 max-w-7xl mx-auto">
      <div className="flex items-center justify-between border-b pb-4">
        <div className="flex items-center space-x-3">
          <div className="p-3 bg-blue-100 dark:bg-blue-900/30 text-blue-600 rounded-xl">
            <Terminal className="w-8 h-8" />
          </div>
          <div>
            <h1 className="text-2xl font-bold text-gray-900 dark:text-white">HL7 v2 MLLP Message Inspector</h1>
            <p className="text-sm text-gray-500">Real-time inspection of ADT (Admissions), ORU (Lab Results), and ORM (Pharmacy Orders)</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-3 gap-6">
        <div className="lg:col-span-2 bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-4 shadow-sm">
          <h2 className="text-lg font-semibold flex items-center space-x-2 text-gray-900 dark:text-white">
            <Activity className="w-5 h-5 text-blue-500" />
            <span>Raw HL7 Transmission Stream</span>
          </h2>
          <pre className="p-4 bg-gray-900 text-green-400 rounded-xl font-mono text-xs overflow-x-auto whitespace-pre-wrap leading-relaxed">
            {rawHl7}
          </pre>
        </div>

        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-4 shadow-sm">
          <h2 className="text-lg font-semibold text-gray-900 dark:text-white">Message Parser Status</h2>
          <div className="p-4 bg-green-50 dark:bg-green-900/20 rounded-xl space-y-2">
            <div className="flex items-center space-x-2 text-green-700 dark:text-green-300 font-bold text-xs">
              <CheckCircle2 className="w-4 h-4" />
              <span>PARSED & ACK RETURNED (AA)</span>
            </div>
            <p className="text-xs text-green-800 dark:text-green-400">Control ID: MSG-94820 matched. Inpatient admission record created successfully.</p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Hl7MessageInspectorConsole;
