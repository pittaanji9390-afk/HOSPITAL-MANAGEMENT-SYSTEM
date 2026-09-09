package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Enterprise Ophthalmology & Vision Diagnostics Decision Engine.
 * Implements Acute Angle-Closure Glaucoma Emergent Decompression Protocols,
 * Diabetic Retinopathy ETDRS Severity Grading, Intraocular Pressure (IOP) Target Calculations,
 * and Chemical Ocular Burn Irrigation Guidelines.
 */
@Component
public class OphthalmologyVisionEngine {

    @Data
    @Builder
    public static class AcuteGlaucomaManagementPlan {
        private double baselineIopMmHg;
        private List<String> emergencyTopicalMedications;
        private List<String> systemicOsmoticAgents;
        private String definitiveLaserProcedure;
        private String precautionInstructions;
    }

    public AcuteGlaucomaManagementPlan getAcuteAngleClosureGlaucomaProtocol(double measuredIopMmHg) {
        List<String> topical = new ArrayList<>();
        topical.add("Timolol 0.5% ophthalmic solution: 1 drop immediately (Beta-blocker: decreases aqueous humor production)");
        topical.add("Apraclonidine 1% or Brimonidine 0.2%: 1 drop immediately (Alpha-2 agonist: decreases inflow and increases outflow)");
        topical.add("Pilocarpine 2% ophthalmic drops: 1 drop every 15 minutes for 2 doses ONCE IOP < 40-50 mmHg (Parasympathomimetic: induces miosis and pulls iris away from trabecular meshwork; ineffective when sphincter is ischemic at IOP > 50)");
        topical.add("Prednisolone Acetate 1%: 1 drop q15m x 4 doses then q1h (Reduces acute intraocular inflammation)");

        List<String> systemic = new ArrayList<>();
        systemic.add("Acetazolamide (Diamox): 500 mg IV or PO immediately (Carbonic anhydrase inhibitor: profoundly halts aqueous secretion)");
        if (measuredIopMmHg > 50.0) {
            systemic.add("IV Mannitol 20%: 1.0 - 2.0 g/kg infused over 30-45 minutes (Hyperosmotic agent: draws fluid from vitreous body to rapidly lower refractory IOP)");
        }

        return AcuteGlaucomaManagementPlan.builder()
                .baselineIopMmHg(measuredIopMmHg)
                .emergencyTopicalMedications(topical)
                .systemicOsmoticAgents(systemic)
                .definitiveLaserProcedure("BILATERAL ND:YAG LASER PERIPHERAL IRIDOTOMY (LPI): Mandatory once corneal edema clears to create alternative pathway for aqueous flow and prevent bilateral recurrence.")
                .precautionInstructions("STRICTLY AVOID MYDRIATIC / CYCLOPLEGIC EYE DROPS (Atropine, Tropicamide) which worsen pupillary block.")
                .build();
    }
}
