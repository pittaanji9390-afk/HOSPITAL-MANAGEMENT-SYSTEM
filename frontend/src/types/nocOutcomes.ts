export interface NocOutcomeItem {
  code: string;
  outcomeName: string;
  domain: string;
  className: string;
  likertScaleType: string;
  keyIndicators: string[];
}

export const NOC_OUTCOMES_CATALOG: NocOutcomeItem[] = [
  {
    code: '0402',
    outcomeName: 'Respiratory Status: Gas Exchange',
    domain: 'Physiologic Health',
    className: 'E. Cardiopulmonary',
    likertScaleType: '1 (Severely Compromised) to 5 (Not Compromised)',
    keyIndicators: ['PaO2 in normal limits', 'SpO2 >= 95%', 'Normal end-tidal CO2', 'Absence of accessory muscle retractions']
  },
  {
    code: '2102',
    outcomeName: 'Pain Level',
    domain: 'Functional Health',
    className: 'V. Symptom Status',
    likertScaleType: '1 (Severe >=8) to 5 (None 0)',
    keyIndicators: ['Subjective NRS Pain Score', 'Facial relaxation', 'Physiological vital sign normalization']
  },
  {
    code: '1912',
    outcomeName: 'Fall Occurrence',
    domain: 'Safe Care Environment',
    className: 'V. Risk Control',
    likertScaleType: '1 (>3 Falls) to 5 (Zero Falls)',
    keyIndicators: ['Zero fall incidents', 'Adherence to call bell use', 'Safe transfer compliance']
  }
];
