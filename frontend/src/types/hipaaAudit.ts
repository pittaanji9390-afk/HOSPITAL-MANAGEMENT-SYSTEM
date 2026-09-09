export interface HipaaAuditLogItem {
  eventId: string;
  timestamp: string;
  userId: string;
  userRole: string;
  patientId: string;
  actionType: 'VIEW' | 'EXPORT' | 'MODIFY' | 'DELETE' | 'OVERRIDE' | 'BREAK_GLASS';
  resourceUri: string;
  clientIpAddress: string;
  isPhiAccessed: boolean;
  justificationNote: string;
}

export const SAMPLE_AUDIT_LOGS: HipaaAuditLogItem[] = [
  {
    eventId: 'AUD-88B12A09',
    timestamp: '2026-09-08 18:25:01',
    userId: 'DR-7719',
    userRole: 'Interventional Cardiologist',
    patientId: 'PT-9941',
    actionType: 'VIEW',
    resourceUri: '/api/v1/patients/PT-9941/cath-lab-records',
    clientIpAddress: '10.240.12.45',
    isPhiAccessed: true,
    justificationNote: 'Routine inpatient pre-op assessment'
  },
  {
    eventId: 'AUD-99C44E11',
    timestamp: '2026-09-08 18:28:14',
    userId: 'RN-3021',
    userRole: 'ICU Staff Nurse',
    patientId: 'PT-8812',
    actionType: 'BREAK_GLASS',
    resourceUri: '/api/v1/patients/PT-8812/confidential-psych-notes',
    clientIpAddress: '10.240.14.88',
    isPhiAccessed: true,
    justificationNote: 'STAT Acute Delirium / Suicide Precautions Assessment'
  }
];
