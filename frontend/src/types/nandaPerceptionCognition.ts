export interface NandaPerceptionCognitionItem {
  code: string;
  diagnosisName: string;
  domain: string;
  classNumber: string;
  definingCharacteristics: string[];
  relatedFactors: string[];
  suggestedNicInterventions: string[];
  targetNocOutcomes: string[];
}

export const NANDA_PERCEPTION_COGNITION_CATALOG: NandaPerceptionCognitionItem[] = [
  {
    code: '00128',
    diagnosisName: 'Acute Confusion (Delirium)',
    domain: 'Perception/Cognition',
    classNumber: '4. Cognition',
    definingCharacteristics: ['CAM-ICU Positive', 'Fluctuating alertness', 'Restlessness / agitation', 'Disorientation to time/place'],
    relatedFactors: ['ICU polypharmacy', 'Sepsis encephalopathy', 'Sleep deprivation in ICU', 'Hypoxemia'],
    suggestedNicInterventions: ['Delirium Bundle Management ABCDEF (6440)', 'Day-Night Light Cycle Control (6482)', 'Family Presence Protocol (7110)'],
    targetNocOutcomes: ['Cognitive Orientation (0901)', 'Neurological Status (0900)', 'Agitation Level (1214)']
  },
  {
    code: '00051',
    diagnosisName: 'Impaired Verbal Communication',
    domain: 'Perception/Cognition',
    classNumber: '5. Communication',
    definingCharacteristics: ['Inability to vocalize with ETT', 'Receptive/expressive dysphasia', 'Motor dysarthria'],
    relatedFactors: ['Endotracheal intubation', 'Cerebrovascular accident', 'Laryngeal nerve injury'],
    suggestedNicInterventions: ['Communication Picture Board (4978)', 'Speech-Language Pathologist Consult (7620)', 'Nonverbal Signal Agreement (4920)'],
    targetNocOutcomes: ['Communication: Expressive (0903)', 'Communication Ability (0902)', 'Coping (1302)']
  }
];
