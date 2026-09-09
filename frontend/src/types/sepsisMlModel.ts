export interface SepsisPredictionResult {
  patientId: string;
  predictedSepsisProbabilityPercent: number;
  riskTier: 'LOW' | 'MODERATE' | 'HIGH' | 'IMMINENT_SEPTIC_SHOCK';
  topContributingFeatures: string[];
  qSofaScore: number;
  lactateVelocityMmPerHr: number;
  clinicalRecommendation: string;
}

export const SAMPLE_SEPSIS_PREDICTIONS: SepsisPredictionResult[] = [
  {
    patientId: 'PT-9941',
    predictedSepsisProbabilityPercent: 84.5,
    riskTier: 'IMMINENT_SEPTIC_SHOCK',
    topContributingFeatures: ['Elevated Serum Lactate (3.8 mmol/L)', 'Tachypnea RR 26 bpm', 'MAP 62 mmHg'],
    qSofaScore: 2,
    lactateVelocityMmPerHr: +0.6,
    clinicalRecommendation: 'STAT 30 mL/kg Crystalloid Bolus + Blood Cultures + Broad Spectrum Abx'
  }
];
