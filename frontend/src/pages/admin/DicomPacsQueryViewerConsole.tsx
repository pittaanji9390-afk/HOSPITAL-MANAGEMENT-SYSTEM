import React, { useState } from 'react';
import { Film, Search, Download, Eye, Layers } from 'lucide-react';

export const DicomPacsQueryViewerConsole: React.FC = () => {
  const [patientId, setPatientId] = useState<string>('PAT-94820');
  const [modality, setModality] = useState<string>('CT');

  return (
    <div className="p-6 space-y-6 max-w-7xl mx-auto">
      <div className="flex items-center justify-between border-b pb-4">
        <div className="flex items-center space-x-3">
          <div className="p-3 bg-indigo-100 dark:bg-indigo-900/30 text-indigo-600 rounded-xl">
            <Film className="w-8 h-8" />
          </div>
          <div>
            <h1 className="text-2xl font-bold text-gray-900 dark:text-white">DICOM PACS Query & Retrieve (DIMSE) Console</h1>
            <p className="text-sm text-gray-500">C-FIND study metadata queries and C-MOVE retrieve bridge for CT, MRI, X-Ray & PET</p>
          </div>
        </div>
      </div>

      <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-6 shadow-sm">
        <div className="flex items-center space-x-4">
          <input type="text" value={patientId} onChange={(e) => setPatientId(e.target.value)} placeholder="Patient MRN / ID" className="px-4 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600" />
          <select value={modality} onChange={(e) => setModality(e.target.value)} className="px-4 py-2 border rounded-lg dark:bg-gray-700 dark:border-gray-600">
            <option value="CT">CT (Computed Tomography)</option>
            <option value="MRI">MRI (Magnetic Resonance)</option>
            <option value="XRAY">X-Ray (Digital Radiography)</option>
          </select>
          <button className="px-4 py-2 bg-indigo-600 hover:bg-indigo-700 text-white rounded-lg text-sm font-semibold flex items-center space-x-2">
            <Search className="w-4 h-4" />
            <span>Query PACS C-FIND</span>
          </button>
        </div>

        <div className="overflow-x-auto">
          <table className="w-full text-left text-xs">
            <thead className="bg-gray-50 dark:bg-gray-700/50 uppercase text-gray-500">
              <tr>
                <th className="p-3">Study Date</th>
                <th className="p-3">Modality</th>
                <th className="p-3">Description</th>
                <th className="p-3">Series / Instances</th>
                <th className="p-3">Dose (mSv)</th>
                <th className="p-3">Action</th>
              </tr>
            </thead>
            <tbody className="divide-y dark:divide-gray-700">
              <tr>
                <td className="p-3">2026-09-08 14:15</td>
                <td className="p-3 font-semibold text-indigo-600">CT</td>
                <td className="p-3">CT CHEST WITH IV CONTRAST (PE PROTOCOL)</td>
                <td className="p-3">4 series / 512 images</td>
                <td className="p-3">7.50 mSv</td>
                <td className="p-3">
                  <button className="px-3 py-1 bg-indigo-100 text-indigo-700 rounded-lg hover:bg-indigo-200">Launch Viewer</button>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
};

export default DicomPacsQueryViewerConsole;
