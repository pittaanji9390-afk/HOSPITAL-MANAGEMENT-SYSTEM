export interface NicInterventionItem {
  code: string;
  interventionName: string;
  domain: string;
  className: string;
  clinicalActivities: string[];
  requiredCompetency: string;
}

export const NIC_INTERVENTIONS_CATALOG: NicInterventionItem[] = [
  {
    code: '3140',
    interventionName: 'Airway Management',
    domain: 'Physiological: Complex',
    className: 'K. Respiratory Management',
    clinicalActivities: [
      'Assess bilateral lung sounds and chest expansion',
      'Perform sterile in-line endotracheal suctioning',
      'Maintain HOB elevated 30-45 degrees to prevent VAP'
    ],
    requiredCompetency: 'Critical Care RN'
  },
  {
    code: '4150',
    interventionName: 'Hemodynamic Regulation',
    domain: 'Physiological: Complex',
    className: 'N. Tissue Perfusion Management',
    clinicalActivities: [
      'Calibrate arterial line at phlebostatic axis',
      'Titrate vasopressors to maintain MAP >= 65 mmHg',
      'Track hourly urine output and serum lactate clearance'
    ],
    requiredCompetency: 'ICU Staff Nurse'
  },
  {
    code: '2210',
    interventionName: 'Analgesic Administration',
    domain: 'Physiological: Basic',
    className: 'H. Drug Management',
    clinicalActivities: [
      'Independent double check for IV opioids',
      'Assess pre-pain score (NRS / CPOT)',
      'Mandatory 30-min post-administration reassessment'
    ],
    requiredCompetency: 'Registered Nurse (RN)'
  }
];
