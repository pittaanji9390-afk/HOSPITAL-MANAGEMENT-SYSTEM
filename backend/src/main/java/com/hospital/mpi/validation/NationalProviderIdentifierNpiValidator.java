package com.hospital.mpi.validation;

import org.springframework.stereotype.Service;

@Service
public class NationalProviderIdentifierNpiValidator {

    public boolean isValidNpi(String npi) {
        if (npi == null || npi.length() != 10 || !npi.matches("\d{10}")) return false;
        // Prefix with 80840 (US health application prefix) for 15-digit Luhn check
        String full = "80840" + npi;
        int sum = 0;
        boolean doubleDigit = false;

        for (int i = full.length() - 1; i >= 0; i--) {
            int d = full.charAt(i) - '0';
            if (doubleDigit) {
                d *= 2;
                if (d > 9) d -= 9;
            }
            sum += d;
            doubleDigit = !doubleDigit;
        }
        return sum % 10 == 0;
    }
}
