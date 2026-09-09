export interface NandaComfortPainItem {
  code: string;
  diagnosisName: string;
  domain: string;
  classNumber: string;
  definingCharacteristics: string[];
  relatedFactors: string[];
  suggestedNicInterventions: string[];
  targetNocOutcomes: string[];
}

export const NANDA_COMFORT_PAIN_CATALOG: NandaComfortPainItem[] = [
  {
    code: '00132',
    diagnosisName: 'Acute Pain',
    domain: 'Comfort',
    classNumber: '1. Physical Comfort',
    definingCharacteristics: ['NRS pain score 8/10', 'Splinting surgical incision', 'Tachycardia HR 112', 'Facial grimacing'],
    relatedFactors: ['Exploratory laparotomy surgical incision', 'Acute bone fracture trauma'],
    suggestedNicInterventions: ['Multimodal Analgesia Administration (2210)', 'Patient Controlled Analgesia PCA Setup (2214)', 'Guided Imagery & Repositioning (5860)'],
    targetNocOutcomes: ['Pain Level (2102)', 'Pain Control (1605)', 'Comfort Level (2100)']
  },
  {
    code: '00134',
    diagnosisName: 'Nausea',
    domain: 'Comfort',
    classNumber: '1. Physical Comfort',
    definingCharacteristics: ['Severe gagging urge', 'Inability to keep liquids down', 'Excessive salivation'],
    relatedFactors: ['Cisplatin chemotherapy infusion', 'General volatile anesthesia recovery'],
    suggestedNicInterventions: ['Ondansetron / Metoclopramide STAT (2300)', 'Aromatherapy Peppermint (5430)', 'Frequent Cool Water Mouth Swabs (1720)'],
    targetNocOutcomes: ['Nausea & Vomiting Severity (2107)', 'Hydration (0602)', 'Appetite (1014)']
  }
];
