export interface FacilityBranchItem {
  facilityId: string;
  facilityName: string;
  tenantId: string;
  facilityType: string;
  totalLicensedBeds: number;
  icuBedCapacity: number;
  traumaCenterLevel: string;
  cliaLicenseNumber: string;
}

export const FACILITY_BRANCH_CATALOG: FacilityBranchItem[] = [
  {
    facilityId: 'FAC-MAIN',
    facilityName: 'Metro General Academic Hospital',
    tenantId: 'TEN-METRO-01',
    facilityType: 'Tertiary Acute Care Hospital',
    totalLicensedBeds: 650,
    icuBedCapacity: 96,
    traumaCenterLevel: 'Level 1 Trauma Center',
    cliaLicenseNumber: 'CLIA-99D0882104'
  },
  {
    facilityId: 'FAC-NORTH',
    facilityName: 'Metro North Community Medical Center',
    tenantId: 'TEN-METRO-01',
    facilityType: 'Community Hospital',
    totalLicensedBeds: 220,
    icuBedCapacity: 24,
    traumaCenterLevel: 'Level 3 Trauma Center',
    cliaLicenseNumber: 'CLIA-99D0554120'
  }
];
