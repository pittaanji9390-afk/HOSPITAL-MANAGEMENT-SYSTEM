export interface ClinicalPermissionItem {
  permissionCode: string;
  module: string;
  description: string;
  isHighRiskAction: boolean;
  requiresTwoPersonVerification: boolean;
}

export const CLINICAL_PERMISSIONS_CATALOG: ClinicalPermissionItem[] = [
  {
    permissionCode: 'CLIN_ORDER_C2_NARCOTICS',
    module: 'Pharmacy',
    description: 'Prescribe Schedule II Controlled Substances with DEA EPCS signature',
    isHighRiskAction: true,
    requiresTwoPersonVerification: false
  },
  {
    permissionCode: 'CLIN_ORDER_CHEMO_ANTINEOPLASTIC',
    module: 'Oncology',
    description: 'Order cytotoxic chemotherapy regimens requiring dual oncologist signoff',
    isHighRiskAction: true,
    requiresTwoPersonVerification: true
  },
  {
    permissionCode: 'CLIN_RELEASE_BLOOD_EMERGENCY',
    module: 'Blood Bank',
    description: 'Order uncrossmatched O-negative emergency massive transfusion release',
    isHighRiskAction: true,
    requiresTwoPersonVerification: true
  }
];
