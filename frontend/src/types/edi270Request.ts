export interface EligibilityInquiry270Item {
  transactionSetControlNumber: string;
  payerId: string;
  providerNpi: string;
  patientMemberId: string;
  patientLastName: string;
  patientFirstName: string;
  patientDob: string;
  requestedServiceTypeCodes: string[];
}

export const SAMPLE_270_INQUIRY: EligibilityInquiry270Item = {
  transactionSetControlNumber: '0001',
  payerId: 'BCBS01',
  providerNpi: '1234567893',
  patientMemberId: 'W123456780',
  patientLastName: 'Vance',
  patientFirstName: 'Eleanor',
  patientDob: '1954-04-12',
  requestedServiceTypeCodes: ['30', '48']
};
