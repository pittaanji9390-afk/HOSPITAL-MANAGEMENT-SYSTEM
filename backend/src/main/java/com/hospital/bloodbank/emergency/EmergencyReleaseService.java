package com.hospital.bloodbank.emergency;

import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Emergency Uncrossmatched Blood Release Protocol.
 * Facilitates immediate release of O-Negative (Females of childbearing potential <= 50y)
 * or O-Positive (Males & Females > 50y) units prior to completion of Type & Screen.
 */
@Service
public class EmergencyReleaseService {

    public record EmergencyReleaseAuthorization(
        String releaseId,
        String patientIdentifierOrTraumaName,
        String attendingPhysicianName,
        String clinicalIndication,
        List<String> releasedUnitDins,
        String bloodTypeSelected,
        Instant authorizedAt,
        boolean retrospectiveTypeAndScreenMandated
    ) {}

    private final List<EmergencyReleaseAuthorization> releaseLogs = Collections.synchronizedList(new ArrayList<>());

    public EmergencyReleaseAuthorization authorizeEmergencyRelease(
        String patientId,
        String physician,
        String indication,
        int femaleAge,
        boolean isFemale,
        List<String> unitDins
    ) {
        String bloodType = (isFemale && femaleAge <= 50) ? "O Rh-Negative (Anti-D Isoimmunization Prevention)" : "O Rh-Positive";
        EmergencyReleaseAuthorization auth = new EmergencyReleaseAuthorization(
            "EM-REL-" + UUID.randomUUID().toString().substring(0, 8),
            patientId,
            physician,
            indication,
            unitDins,
            bloodType,
            Instant.now(),
            true
        );
        releaseLogs.add(auth);
        return auth;
    }

    public List<EmergencyReleaseAuthorization> getReleaseLogs() {
        return new ArrayList<>(releaseLogs);
    }
}
