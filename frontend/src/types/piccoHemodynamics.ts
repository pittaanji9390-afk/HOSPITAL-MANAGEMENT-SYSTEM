export interface PiccoHemodynamicItem {
  patientId: string;
  cardiacIndexCi: number;
  extravascularLungWaterIndexEvlwi: number;
  globalEndDiastolicVolumeIndexGedvi: number;
  strokeVolumeVariationSvv: number;
  pulmonaryVascularPermeabilityIndexPvpi: number;
  isFluidResponsive: boolean;
  hasPulmonaryEdema: boolean;
  clinicalGuidance: string;
}

export const SAMPLE_PICCO_PROFILE: PiccoHemodynamicItem = {
  patientId: 'PT-ICU-8821',
  cardiacIndexCi: 2.1,
  extravascularLungWaterIndexEvlwi: 14.2,
  globalEndDiastolicVolumeIndexGedvi: 840,
  strokeVolumeVariationSvv: 8.5,
  pulmonaryVascularPermeabilityIndexPvpi: 3.4,
  isFluidResponsive: false,
  hasPulmonaryEdema: true,
  clinicalGuidance: 'Permeability Pulmonary Edema (ARDS): Fluid restrict & titrate PEEP'
};
