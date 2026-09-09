export interface NandaCopingStressItem {
  code: string;
  diagnosisName: string;
  domain: string;
  classNumber: string;
  definingCharacteristics: string[];
  relatedFactors: string[];
  suggestedNicInterventions: string[];
  targetNocOutcomes: string[];
}

export const NANDA_COPING_STRESS_CATALOG: NandaCopingStressItem[] = [
  {
    code: '00049',
    diagnosisName: 'Decreased Intracranial Adaptive Capacity',
    domain: 'Coping/Stress Tolerance',
    classNumber: '3. Neurobehavioral Stress',
    definingCharacteristics: ['ICP sustained > 20 mmHg', 'CPP < 60 mmHg', 'Pupillary asymmetry / sluggishness'],
    relatedFactors: ['Subdural hematoma', 'Diffuse axonal injury', 'Cerebral edema post-craniotomy'],
    suggestedNicInterventions: ['ICP Monitoring Protocol (2590)', 'Hyperosmolar Therapy Osmotherapy (2540)', 'Strict Midline Head Position (0840)'],
    targetNocOutcomes: ['Cerebral Perfusion Status (0406)', 'Neurological Status (0900)', 'Intracranial Pressure Control (0911)']
  },
  {
    code: '00009',
    diagnosisName: 'Autonomic Dysreflexia',
    domain: 'Coping/Stress Tolerance',
    classNumber: '3. Neurobehavioral Stress',
    definingCharacteristics: ['Severe episodic hypertension', 'Facial flushing / diaphoresis above T6', 'Pounding headache'],
    relatedFactors: ['Spinal cord injury at/above T6', 'Obstructed urinary catheter', 'Rectal distention'],
    suggestedNicInterventions: ['Emergency Dysreflexia Protocol (2580)', 'Immediate Catheter Patency Check (0580)', 'Antihypertensive STAT Administration (2300)'],
    targetNocOutcomes: ['Autonomic Neurological Status (0920)', 'Blood Pressure Regulation (0802)', 'Symptom Relief (2100)']
  }
];
