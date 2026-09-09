package com.hospital.mpi.algorithms;

import org.springframework.stereotype.Service;

@Service
public class AddressGeocodingStandardizer {

    public String standardizeStreet(String street) {
        if (street == null) return "";
        return street.toUpperCase()
                .replaceAll("\bSTREET\b", "ST")
                .replaceAll("\bAVENUE\b", "AVE")
                .replaceAll("\bBOULEVARD\b", "BLVD")
                .replaceAll("\bROAD\b", "RD")
                .replaceAll("\bDRIVE\b", "DR")
                .replaceAll("\bSUITE\b", "STE")
                .replaceAll("\bAPARTMENT\b", "APT")
                .trim();
    }
}
