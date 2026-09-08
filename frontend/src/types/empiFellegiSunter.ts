export interface LinkageDecisionResult {
  candidateRecordIdA: string;
  candidateRecordIdB: string;
  totalMatchWeightScore: number;
  lowerThreshold: number;
  upperThreshold: number;
  matchClassification: 'DEFINITE_MATCH' | 'PROBABLE_MATCH_MANUAL_REVIEW' | 'DEFINITE_NON_MATCH';
}

export const SAMPLE_LINKAGE_RESULT: LinkageDecisionResult = {
  candidateRecordIdA: 'PT-9941',
  candidateRecordIdB: 'PT-8812',
  totalMatchWeightScore: 19.4,
  lowerThreshold: 12.0,
  upperThreshold: 24.0,
  matchClassification: 'PROBABLE_MATCH_MANUAL_REVIEW'
};
