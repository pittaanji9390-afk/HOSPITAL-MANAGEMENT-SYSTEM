import React, { useState } from 'react';
import { Smartphone, Shield, Key, CheckCircle2 } from 'lucide-react';

export const SmartOnFhirAppRegistryConsole: React.FC = () => {
  return (
    <div className="p-6 space-y-6 max-w-7xl mx-auto">
      <div className="flex items-center justify-between border-b pb-4">
        <div className="flex items-center space-x-3">
          <div className="p-3 bg-purple-100 dark:bg-purple-900/30 text-purple-600 rounded-xl">
            <Smartphone className="w-8 h-8" />
          </div>
          <div>
            <h1 className="text-2xl font-bold text-gray-900 dark:text-white">SMART on FHIR Application Registry</h1>
            <p className="text-sm text-gray-500">OAuth2 authorization server, standalone/EHR launch context and FHIR R4 scope registry</p>
          </div>
        </div>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-4 shadow-sm">
          <h2 className="text-lg font-semibold text-gray-900 dark:text-white">Genomic Clinical Decision Support App</h2>
          <p className="text-xs text-gray-500">Client ID: app-genomics-cdss-991 • Scope: patient/Observation.read launch/patient</p>
          <span className="inline-block px-3 py-1 bg-green-100 text-green-800 rounded-full text-xs font-semibold">AUTHORIZED & ACTIVE</span>
        </div>
        <div className="bg-white dark:bg-gray-800 p-6 rounded-2xl border border-gray-200 dark:border-gray-700 space-y-4 shadow-sm">
          <h2 className="text-lg font-semibold text-gray-900 dark:text-white">Pediatric Growth Chart SMART App</h2>
          <p className="text-xs text-gray-500">Client ID: app-pediatric-growth • Scope: patient/Patient.read patient/Observation.read</p>
          <span className="inline-block px-3 py-1 bg-green-100 text-green-800 rounded-full text-xs font-semibold">AUTHORIZED & ACTIVE</span>
        </div>
      </div>
    </div>
  );
};

export default SmartOnFhirAppRegistryConsole;
