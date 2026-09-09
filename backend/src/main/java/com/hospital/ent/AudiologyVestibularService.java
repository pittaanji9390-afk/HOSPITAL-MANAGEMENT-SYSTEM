package com.hospital.ent;

import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

@Service
public class AudiologyVestibularService {

    public enum TympanogramType { TYPE_A_NORMAL, TYPE_B_FLUID_EFFUSION, TYPE_C_EUSTACHIAN_TUBE_DYSFUNCTION }

    public static record VestibularExam(
            String examId,
            String patientId,
            double ptaThresholdRightDb,
            double ptaThresholdLeftDb,
            boolean dixHallpikePositive,
            String affectedCanal, // Posterior, Horizontal, Anterior
            TympanogramType tympanogram,
            String vestibularRehabProtocol,
            Instant testedAt
    ) implements Serializable {}

    public VestibularExam evaluateHearingAndVestibular(String id, String patientId, double rightPta, double leftPta, boolean dixHallpike, String canal, TympanogramType tymp) {
        String rehab = dixHallpike
                ? "BPPV Confirmed (" + canal + " Canal): Perform Epley Canalith Repositioning Maneuver immediately."
                : "Vestibular ocular reflex (VOR) intact; no acute otolith repositioning needed.";

        return new VestibularExam(id, patientId, rightPta, leftPta, dixHallpike, canal, tymp, rehab, Instant.now());
    }
}
