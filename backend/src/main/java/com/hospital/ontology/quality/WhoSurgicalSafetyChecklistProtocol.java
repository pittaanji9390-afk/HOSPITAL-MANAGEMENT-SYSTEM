package com.hospital.ontology.quality;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class WhoSurgicalSafetyChecklistProtocol {

    @Data
    @AllArgsConstructor
    public static class SurgicalSafetyRecord {
        private String surgicalCaseId;
        private boolean signInCompletedBeforeAnesthesia;
        private boolean timeOutCompletedBeforeIncision;
        private boolean signOutCompletedBeforePatientLeavesOr;
        private boolean isSafetyVerification100Percent;
    }

    public SurgicalSafetyRecord verifyCase(String caseId, boolean signIn, boolean timeOut, boolean signOut) {
        return new SurgicalSafetyRecord(caseId, signIn, timeOut, signOut, signIn && timeOut && signOut);
    }
}
