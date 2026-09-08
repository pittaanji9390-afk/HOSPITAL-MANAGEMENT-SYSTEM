export interface NandaSafetyProtectionItem {
  code: string;
  diagnosisName: string;
  domain: string;
  classNumber: string;
  definingCharacteristics: string[];
  relatedFactors: string[];
  suggestedNicInterventions: string[];
  targetNocOutcomes: string[];
}

export const NANDA_SAFETY_PROTECTION_CATALOG: NandaSafetyProtectionItem[] = [
  {
    code: '00155',
    diagnosisName: 'Risk for Falls',
    domain: 'Safety/Protection',
    classNumber: '2. Physical Injury',
    definingCharacteristics: ['Morse Fall Score >= 45 (High Risk)', 'Gait ataxia', 'Sedative hypnotic infusions'],
    relatedFactors: ['Post-operative sedation', 'Orthostatic hypotension', 'Urgent nocturia'],
    suggestedNicInterventions: ['Fall Prevention Protocol (6490)', 'Yellow Fall Risk Wristband & Bed Alarm (6492)', 'Non-Skid Footwear & Low Bed (6486)'],
    targetNocOutcomes: ['Fall Occurrence (1912)', 'Safe Patient Handling (1909)', 'Balance (0202)']
  },
  {
    code: '00046',
    diagnosisName: 'Impaired Skin Integrity',
    domain: 'Safety/Protection',
    classNumber: '2. Physical Injury',
    definingCharacteristics: ['Braden Scale <= 12', 'Sacral Stage II partial thickness blister', 'Macerated perianal skin'],
    relatedFactors: ['Prolonged bedrest in ICU', 'Fecal incontinence', 'Severe hypoalbuminemia'],
    suggestedNicInterventions: ['Q2H Turning & Repositioning Schedule (0840)', 'Hydrocolloid / Barrier Cream Dressing (3520)', 'Dynamic Low Air Loss Mattress (0842)'],
    targetNocOutcomes: ['Skin Integrity (1101)', 'Wound Healing (1102)', 'Nutritional Status (1004)']
  }
];
