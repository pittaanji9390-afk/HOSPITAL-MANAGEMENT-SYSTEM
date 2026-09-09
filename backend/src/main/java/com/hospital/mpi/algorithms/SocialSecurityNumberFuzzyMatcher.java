package com.hospital.mpi.algorithms;

import org.springframework.stereotype.Service;

@Service
public class SocialSecurityNumberFuzzyMatcher {

    public boolean isSsnMatch(String ssn1, String ssn2) {
        if (ssn1 == null || ssn2 == null) return false;
        String clean1 = ssn1.replaceAll("[^0-9]", "");
        String clean2 = ssn2.replaceAll("[^0-9]", "");

        if (clean1.equals(clean2)) return true;
        if (clean1.length() == 9 && clean2.length() == 9) {
            // Check 1 transposition or 1 digit mismatch
            int diff = 0;
            for (int i = 0; i < 9; i++) {
                if (clean1.charAt(i) != clean2.charAt(i)) diff++;
            }
            return diff <= 1;
        }
        return false;
    }
}
