export interface NandaHealthPromotionItem {
  code: string;
  diagnosisName: string;
  domain: string;
  classNumber: string;
  definingCharacteristics: string[];
  relatedFactors: string[];
  suggestedNicInterventions: string[];
  targetNocOutcomes: string[];
}

export const NANDA_HEALTH_PROMOTION_CATALOG: NandaHealthPromotionItem[] = [
  {
    code: '00097',
    diagnosisName: 'Deficient Diversional Activity',
    domain: 'Health Promotion',
    classNumber: '1. Health Awareness',
    definingCharacteristics: ['Boredom statements', 'Usual hobbies restricted', 'Flat affect during bedrest'],
    relatedFactors: ['Prolonged inpatient stay', 'Strict contact isolation', 'Physical immobilization'],
    suggestedNicInterventions: ['Recreation Therapy (5360)', 'Music Therapy (4400)', 'Environmental Management (6480)'],
    targetNocOutcomes: ['Leisure Participation (1604)', 'Quality of Life (2000)', 'Mood Equilibrium (1204)']
  },
  {
    code: '00257',
    diagnosisName: 'Frail Elderly Syndrome',
    domain: 'Health Promotion',
    classNumber: '2. Health Management',
    definingCharacteristics: ['Muscle sarcopenia', 'Unintentional weight loss >5%', 'Walking speed <0.8 m/s'],
    relatedFactors: ['Age >= 75', 'Multiple chronic comorbid conditions', 'Nutritional depletion'],
    suggestedNicInterventions: ['Fall Prevention (6490)', 'Nutrition Management (1100)', 'Physical Therapy Assistance (0221)'],
    targetNocOutcomes: ['Frailty Health Status (2012)', 'Physical Mobility (0208)', 'Nutritional Status (1004)']
  },
  {
    code: '00078',
    diagnosisName: 'Ineffective Health Management',
    domain: 'Health Promotion',
    classNumber: '2. Health Management',
    definingCharacteristics: ['Non-compliance with therapy', 'Frequent preventable admissions', 'Unmanaged blood sugars'],
    relatedFactors: ['Polypharmacy complexity', 'Health literacy barriers', 'Socioeconomic constraints'],
    suggestedNicInterventions: ['Medication Management (2380)', 'Health Coaching (5305)', 'Discharge Planning (7370)'],
    targetNocOutcomes: ['Compliance Behavior (1601)', 'Treatment Regimen Knowledge (1813)', 'Self-Direction of Care (1613)']
  }
];
