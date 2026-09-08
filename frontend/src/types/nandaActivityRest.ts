export interface NandaActivityRestItem {
  code: string;
  diagnosisName: string;
  domain: string;
  classNumber: string;
  definingCharacteristics: string[];
  relatedFactors: string[];
  suggestedNicInterventions: string[];
  targetNocOutcomes: string[];
}

export const NANDA_ACTIVITY_REST_CATALOG: NandaActivityRestItem[] = [
  {
    code: '00029',
    diagnosisName: 'Decreased Cardiac Output',
    domain: 'Activity/Rest',
    classNumber: '4. Cardiovascular/Pulmonary',
    definingCharacteristics: ['Cardiac Index < 2.2 L/min/m2', 'MAP < 65 mmHg', 'Cold extremities', 'Elevated troponin/BNP'],
    relatedFactors: ['Acute coronary syndrome', 'Decompensated systolic failure', 'Cardiogenic shock'],
    suggestedNicInterventions: ['Hemodynamic Monitoring (4150)', 'Inotrope Infusion Titration (2300)', 'Intra-Aortic Balloon Pump Care (4066)'],
    targetNocOutcomes: ['Cardiac Pump Effectiveness (0400)', 'Vital Signs Stability (0802)', 'Tissue Perfusion (0416)']
  },
  {
    code: '00092',
    diagnosisName: 'Activity Intolerance',
    domain: 'Activity/Rest',
    classNumber: '2. Activity/Exercise',
    definingCharacteristics: ['Exertional desaturation', 'Tachycardia with repositioning', 'Severe post-COVID fatigue'],
    relatedFactors: ['Prolonged ICU immobilization', 'COPD exacerbation', 'Severe anemia Hb < 8 g/dL'],
    suggestedNicInterventions: ['Energy Management (0180)', 'Progressive Mobility Protocol (0221)', 'Oxygen Supplementation (3320)'],
    targetNocOutcomes: ['Activity Tolerance (0005)', 'Endurance (0001)', 'Self-Care: ADLs (0300)']
  }
];
