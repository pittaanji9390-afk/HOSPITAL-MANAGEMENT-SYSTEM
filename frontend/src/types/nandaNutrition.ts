export interface NandaNutritionItem {
  code: string;
  diagnosisName: string;
  domain: string;
  classNumber: string;
  definingCharacteristics: string[];
  relatedFactors: string[];
  suggestedNicInterventions: string[];
  targetNocOutcomes: string[];
}

export const NANDA_NUTRITION_CATALOG: NandaNutritionItem[] = [
  {
    code: '00002',
    diagnosisName: 'Imbalanced Nutrition: Less than Body Requirements',
    domain: 'Nutrition',
    classNumber: '1. Ingestion',
    definingCharacteristics: ['Weight < 80% IBW', 'Albumin < 3.0 g/dL', 'Severe muscle wasting'],
    relatedFactors: ['Hypercatabolic stress', 'Malignancy cachexia', 'Malabsorption syndrome'],
    suggestedNicInterventions: ['Nutrition Therapy (1120)', 'Enteral Feeding (1056)', 'Calorie Count Tracking (1280)'],
    targetNocOutcomes: ['Nutritional Status (1004)', 'Nutrient Intake (1009)', 'Weight Gain (1014)']
  },
  {
    code: '00103',
    diagnosisName: 'Impaired Swallowing',
    domain: 'Nutrition',
    classNumber: '1. Ingestion',
    definingCharacteristics: ['Coughing with thin liquids', 'Wet voice post-swallow', 'Buccal pocketing'],
    relatedFactors: ['Post-stroke hemiparesis', 'Bulbar cranial nerve palsy', 'Recent extubation'],
    suggestedNicInterventions: ['Swallowing Therapy (1860)', 'Aspiration Precautions (3200)', 'Diet Texture Modification (1160)'],
    targetNocOutcomes: ['Swallowing Status (1015)', 'Aspiration Prevention (1918)', 'Airway Patency (0410)']
  },
  {
    code: '00027',
    diagnosisName: 'Deficient Fluid Volume',
    domain: 'Nutrition',
    classNumber: '5. Hydration',
    definingCharacteristics: ['Orthostatic drop >20 mmHg', 'Urine <0.5 mL/kg/h', 'Elevated hematocrit / BUN'],
    relatedFactors: ['Severe diarrhea / vomiting', 'GI hemorrhage', 'Diuretic overdiuresis'],
    suggestedNicInterventions: ['Fluid Resuscitation (4120)', 'IV Infusion Management (2120)', 'Central Venous Pressure Monitoring (4210)'],
    targetNocOutcomes: ['Fluid Balance (0601)', 'Hydration (0602)', 'Hemodynamic Stability (0401)']
  }
];
