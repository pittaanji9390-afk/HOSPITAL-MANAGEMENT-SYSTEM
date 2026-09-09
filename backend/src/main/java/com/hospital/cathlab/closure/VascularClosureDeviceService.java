package com.hospital.cathlab.closure;

import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

@Service
public class VascularClosureDeviceService {

    public enum AccessSite {
        RIGHT_COMMON_FEMORAL_ARTERY,
        LEFT_COMMON_FEMORAL_ARTERY,
        RIGHT_RADIAL_ARTERY,
        LEFT_RADIAL_ARTERY
    }

    public enum ClosureDeviceType {
        ANGIO_SEAL_VIP("Angio-Seal 6F/8F Collagen-Anchor Sandwich"),
        PERCLOSE_PROGLIDE("Perclose ProGlide Suture-Mediated Closure"),
        MANTA_LARGE_BORE("MANTA 14F/18F Large-Bore Collagen-Toggle Closure"),
        TR_BAND_COMPRESSION("TR Band Pneumatic Radial Compression Device");

        private final String label;
        ClosureDeviceType(String label) { this.label = label; }
        public String getLabel() { return label; }
    }

    public static record ClosureProcedure(
            String procedureId,
            String patientId,
            AccessSite site,
            int sheathSizeFrench,
            ClosureDeviceType deviceType,
            boolean femoralArteriogramDocumented,
            boolean successfulDeployment,
            int actSecondsAtDeployment,
            int bedRestDurationHours,
            String postCareProtocol,
            Instant deployedAt
    ) implements Serializable {}

    public ClosureProcedure recordClosure(
            String procId,
            String patientId,
            AccessSite site,
            int sheathFrench,
            ClosureDeviceType device,
            boolean arteriogramVerified,
            int actSeconds
    ) {
        int bedRestHours;
        StringBuilder protocol = new StringBuilder();

        if (site == AccessSite.RIGHT_RADIAL_ARTERY || site == AccessSite.LEFT_RADIAL_ARTERY) {
            bedRestHours = 0;
            protocol.append("TR Band: Apply with 13-15 mL air injection; bleed down 2 mL every 30 minutes. Monitor for patent radial artery flow.");
        } else if (device == ClosureDeviceType.MANTA_LARGE_BORE) {
            bedRestHours = 4;
            protocol.append("MANTA Large-Bore Closure: Verify depth locator on angiogram. Strict supine bed rest with leg extended for 4 hours.");
        } else {
            bedRestHours = 2;
            protocol.append("Femoral Closure Device deployed. Bed rest 2 hours. Re-puncture restricted at same site for 90 days.");
        }

        return new ClosureProcedure(
                procId,
                patientId,
                site,
                sheathFrench,
                device,
                arteriogramVerified,
                true,
                actSeconds,
                bedRestHours,
                protocol.toString(),
                Instant.now()
        );
    }
}
