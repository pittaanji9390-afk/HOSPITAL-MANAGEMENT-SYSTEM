package com.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BloodBankUnitDto {
    private String unitBagBarcode;
    private String bloodProductType; // PRBC, FFP, PLATELETS, CRYOPRECIPITATE
    private String bloodGroupAboRh; // A_POS, B_POS, AB_POS, O_NEG, etc.
    private LocalDate donationDate;
    private LocalDate expirationDate;
    private double currentStorageTemperatureCelsius;
    private boolean isColdChainCompromised;
    private String allocatedPatientMrn;
    private boolean isCrossmatchCompatible;
    private String dispensationStatus;
}
