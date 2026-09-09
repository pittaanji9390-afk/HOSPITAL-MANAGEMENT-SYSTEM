package com.hospital.perinatal.nichd;

import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

/**
 * NICHD Fetal Deceleration Pattern and Uterine Tachysystole Analyzer
 * Analyzes Early (head compression), Late (uteroplacental insufficiency), Variable (cord compression), and Prolonged decelerations.
 */
@Service
public class NichdDecelerationAnalyzerService {

    public enum DecelerationType {
        EARLY_DECELERATION("Early Deceleration: Symmetrical gradual decrease with nadir matching peak of contraction (Head compression)"),
        LATE_DECELERATION("Late Deceleration: Symmetrical gradual decrease with nadir occurring after peak of contraction (Uteroplacental insufficiency)"),
        VARIABLE_DECELERATION("Variable Deceleration: Abrupt decrease (<30s onset to nadir), >=15 bpm drop for >=15s to <2min (Cord compression)"),
        PROLONGED_DECELERATION("Prolonged Deceleration: Decrease >=15 bpm lasting >=2 minutes but <10 minutes"),
        NONE("No recurrent decelerations detected");

        private final String details;
        DecelerationType(String details) { this.details = details; }
        public String getDetails() { return details; }
    }

    public static record DecelerationAssessment(
            String assessmentId,
            String patientId,
            DecelerationType dominantPattern,
            int contractionFrequencyIn10Min, // Normal <= 5 contractions in 10 minutes
            boolean tachysystolePresent, // > 5 contractions in 10 min averaged over 30 min
            int nadirDropBpm,
            int durationSeconds,
            String physiologicalMechanism,
            String nursingIntervention,
            Instant analyzedAt
    ) implements Serializable {}

    public DecelerationAssessment analyzePattern(
            String id,
            String patientId,
            DecelerationType type,
            int contractions10m,
            int nadirDrop,
            int durationSec
    ) {
        boolean tachysystole = contractions10m > 5;
        StringBuilder mechanism = new StringBuilder();
        StringBuilder nursing = new StringBuilder();

        switch (type) {
            case EARLY_DECELERATION -> {
                mechanism.append("Vagal reflex mediated by fetal head compression against cervix/pelvic floor during contraction. Benign physiological finding.");
                nursing.append("Perform sterile vaginal exam to assess cervical dilatation and fetal station. No oxygen or tocolysis indicated.");
            }
            case LATE_DECELERATION -> {
                mechanism.append("Fetal hypoxemia due to transient reduction in intervillous blood flow during uterine hypertonus or placental insufficiency.");
                nursing.append("Turn patient onto left lateral side. Increase primary IV infusion rate. Discontinue Oxytocin immediately. Administer O2 10L via NRB mask.");
            }
            case VARIABLE_DECELERATION -> {
                mechanism.append("Transient umbilical cord compression leading to increased fetal systemic vascular resistance followed by baroreceptor-mediated bradycardia.");
                nursing.append("Change maternal position (hands and knees or lateral). Consider amnioinfusion if recurrent variables during second stage of labor.");
            }
            case PROLONGED_DECELERATION -> {
                mechanism.append("Severe acute disruption of fetal oxygenation (e.g. maternal hypotension after epidural, uterine rupture, abruption, or cord prolapse).");
                nursing.append("STAT obstetrician and anesthesia notification. Check maternal blood pressure (administer Ephedrine/Phenylephrine if post-epidural hypotension). Prepare for immediate delivery.");
            }
            case NONE -> {
                mechanism.append("Adequate fetal oxygenation reserve without mechanical cord or placental compromise.");
                nursing.append("Continue routine labor progression surveillance.");
            }
        }

        if (tachysystole) {
            nursing.append(" TACHYSYSTOLE WARNING (>5 contractions/10min): Discontinue or titrate down Pitocin. Administer Terbutaline 0.25 mg SC if hypertonus persists.");
        }

        return new DecelerationAssessment(
                id,
                patientId,
                type,
                contractions10m,
                tachysystole,
                nadirDrop,
                durationSec,
                mechanism.toString(),
                nursing.toString(),
                Instant.now()
        );
    }
}
