package com.hospital.mpi.validation;

import org.springframework.stereotype.Service;

@Service
public class AbhaAddressIndianHealthcareIdValidator {

    public boolean isValidAbhaNumber(String abha) {
        if (abha == null) return false;
        String clean = abha.replaceAll("[^0-9]", "");
        return clean.length() == 14;
    }

    public boolean isValidAbhaAddress(String phrAddress) {
        if (phrAddress == null) return false;
        return phrAddress.matches("^[a-zA-Z0-9._-]{4,32}@sbx$") || phrAddress.matches("^[a-zA-Z0-9._-]{4,32}@abdm$");
    }
}
