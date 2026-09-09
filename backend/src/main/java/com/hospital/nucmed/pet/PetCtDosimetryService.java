package com.hospital.nucmed.pet;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * PET/CT F-18 Fludeoxyglucose (FDG) Quantitative SUV Engine & Deauville 5-Point Lymphoma Response Scale:
 * - Deauville 1: No uptake above background.
 * - Deauville 2: Uptake <= Mediastinum.
 * - Deauville 3: Uptake > Mediastinum but <= Liver. (Complete Metabolic Response in trials).
 * - Deauville 4: Uptake moderately > Liver.
 * - Deauville 5: Uptake markedly > Liver (> 2-3x SUVmax of liver) or new lesions.
 */
@Service
public class PetCtDosimetryService {

    public record PetScanParameters(double injectedActivityMci, double patientWeightKg, double postInjectionTimeMinutes, double bloodGlucoseMgDl) {}
    public record LymphomaLesionUptake(double lesionSuvMax, double mediastinumBloodPoolSuvMax, double liverSuvMax) {}
    public record DeauvilleAssessment(int deauvilleScore, boolean completeMetabolicResponse, String clinicalInterpretation) {}

    public DeauvilleAssessment scoreDeauville(LymphomaLesionUptake u) {
        int score;
        if (u.lesionSuvMax() <= 0.5) score = 1;
        else if (u.lesionSuvMax() <= u.mediastinumBloodPoolSuvMax()) score = 2;
        else if (u.lesionSuvMax() <= u.liverSuvMax()) score = 3;
        else if (u.lesionSuvMax() <= (u.liverSuvMax() * 2.0)) score = 4;
        else score = 5;

        boolean cmr = score <= 3;
        String interp = cmr ? "COMPLETE METABOLIC RESPONSE (CMR / Lugano Negative)" : "RESIDUAL METABOLIC DISEASE / PROGRESSION";

        return new DeauvilleAssessment(score, cmr, interp);
    }
}
