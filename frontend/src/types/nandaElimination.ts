export interface NandaEliminationItem {
  code: string;
  diagnosisName: string;
  domain: string;
  classNumber: string;
  definingCharacteristics: string[];
  relatedFactors: string[];
  suggestedNicInterventions: string[];
  targetNocOutcomes: string[];
}

export const NANDA_ELIMINATION_CATALOG: NandaEliminationItem[] = [
  {
    code: '00030',
    diagnosisName: 'Impaired Gas Exchange',
    domain: 'Elimination & Exchange',
    classNumber: '4. Respiratory Function',
    definingCharacteristics: ['PaO2/FiO2 < 300', 'SpO2 < 90% on room air', 'Accessory muscle use', 'Hypercapnia'],
    relatedFactors: ['Alveolar consolidation', 'Pulmonary shunt / ARDS', 'Severe bronchospasm'],
    suggestedNicInterventions: ['Oxygen Therapy (3320)', 'Mechanical Ventilation Titration (3300)', 'Prone Positioning (0840)'],
    targetNocOutcomes: ['Respiratory Status: Gas Exchange (0402)', 'Ventilation (0403)', 'Arterial Blood Gases (0408)']
  },
  {
    code: '00011',
    diagnosisName: 'Constipation',
    domain: 'Elimination & Exchange',
    classNumber: '2. Gastrointestinal Function',
    definingCharacteristics: ['Bristol Stool Type 1-2', 'No bowel movement in 72h', 'Abdominal fullness'],
    relatedFactors: ['High-dose opioid regimen', 'Spinal cord injury immobility', 'Dehydration'],
    suggestedNicInterventions: ['Bowel Protocol Administration (0430)', 'Osmotic Laxative Management (2300)', 'Fluid Hydration (4120)'],
    targetNocOutcomes: ['Bowel Elimination (0501)', 'Comfort Level (2100)', 'Gastrointestinal Function (1015)']
  }
];
