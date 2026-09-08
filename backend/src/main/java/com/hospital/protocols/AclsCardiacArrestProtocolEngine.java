package com.hospital.protocols;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class AclsCardiacArrestProtocolEngine {

    @Data
    @Builder
    public static class CodeBlueEventLog {
        private String codeEncounterId;
        private String initialRhythm; // VF, PULSELESS_VT, ASYSTOLE, PEA
        private boolean isShockable;
        private int totalDefibrillationShocks;
        private int totalEpinephrineDoses1mg;
        private int totalAmiodaroneDosesMg;
        private double totalCprDurationMinutes;
        private boolean returnOfSpontaneousCirculationRosc;
        private List<String> reversibleCausesHsAndTs;
    }

    public CodeBlueEventLog recordCodeIntervention(String codeId, String rhythm, int shocks, int epiCount, int amiodaroneMg, double durationMins, boolean rosc) {
        boolean shockable = rhythm.equals("VF") || rhythm.equals("PULSELESS_VT");
        return CodeBlueEventLog.builder()
                .codeEncounterId(codeId)
                .initialRhythm(rhythm)
                .isShockable(shockable)
                .totalDefibrillationShocks(shocks)
                .totalEpinephrineDoses1mg(epiCount)
                .totalAmiodaroneDosesMg(amiodaroneMg)
                .totalCprDurationMinutes(durationMins)
                .returnOfSpontaneousCirculationRosc(rosc)
                .reversibleCausesHsAndTs(List.of("Hypovolemia", "Hypoxia", "Hydrogen ion (acidosis)", "Hypo/Hyperkalemia", "Hypothermia", "Tension pneumothorax", "Tamponade (cardiac)", "Toxins", "Thrombosis (pulmonary)", "Thrombosis (coronary)"))
                .build();
    }
}
