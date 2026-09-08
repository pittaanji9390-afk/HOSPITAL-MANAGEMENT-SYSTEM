export interface FhirPatientResource {
  resourceType: 'Patient';
  id: string;
  identifier: { system: string; value: string; use?: string }[];
  active: boolean;
  name: { use: string; family: string; given: string[] }[];
  telecom: { system: string; value: string; use?: string }[];
  gender: 'male' | 'female' | 'other' | 'unknown';
  birthDate: string;
  address: { use: string; line: string[]; city: string; state: string; postalCode: string; country: string }[];
}

export const SAMPLE_FHIR_PATIENT: FhirPatientResource = {
  resourceType: 'Patient',
  id: 'PT-9941',
  identifier: [{ system: 'http://hospital.metro.org/mrn', value: 'MRN-9941-8812', use: 'usual' }],
  active: true,
  name: [{ use: 'official', family: 'Vance', given: ['Eleanor'] }],
  telecom: [{ system: 'phone', value: '+1-555-019-2834', use: 'mobile' }],
  gender: 'female',
  birthDate: '1954-04-12',
  address: [{ use: 'home', line: ['742 Evergreen Terrace'], city: 'Springfield', state: 'IL', postalCode: '62704', country: 'USA' }]
};
