export interface Cyp2d6GuidanceItem {
  patientId: string;
  diplotype: string;
  activityScore: number;
  metabolizerPhenotype: 'POOR_METABOLIZER' | 'INTERMEDIATE_METABOLIZER' | 'NORMAL_METABOLIZER' | 'ULTRARAPID_METABOLIZER';
  codeineRecommendation: string;
  tamoxifenRecommendation: string;
}

export const SAMPLE_CYP2D6_GUIDANCE: Cyp2d6GuidanceItem = {
  patientId: 'PT-9941',
  diplotype: '*4/*4 (Null / Null)',
  activityScore: 0.0,
  metabolizerPhenotype: 'POOR_METABOLIZER',
  codeineRecommendation: 'CONTRAINDICATED: Zero analgesia with codeine/tramadol.',
  tamoxifenRecommendation: 'Switch to Aromatase Inhibitor (Anastrozole / Letrozole).'
};
