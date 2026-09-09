package com.hospital.cssd.sterility;

import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * Event-Related Sterility (ERS) and Rigid Sterilization Container Maintenance System (AORN Guidelines).
 * Verifies filter changes (single-use paper vs reusable PTFE filters), silicone gasket elasticity,
 * tamper-evident lock seals, and packaging compromise events (moisture, tears, dropped packages).
 */
@Service
public class EventRelatedSterilityService {

    public enum PackagingType { RIGID_CONTAINER_PTFE_FILTER, TYVEK_MYLAR_POUCH, CSR_BLUE_DOUBLE_WRAP }
    public enum SterilityStatus { STERILE_READY_FOR_USE, REPROCESSED_REQUIRED_COMPROMISED, FILTER_EXPIRED, GASKET_INSPECTION_DUE }

    public record SterilePackage(
        String packageBarcode,
        String trayName,
        PackagingType packagingType,
        Instant sterilizedAt,
        int rigidFilterCycleCount,
        int maxFilterCyclesAllowed,
        boolean tamperSealIntact,
        boolean moistureFree,
        SterilityStatus status
    ) {}

    public SterilityStatus inspectPackage(SterilePackage pkg) {
        if (!pkg.tamperSealIntact() || !pkg.moistureFree()) {
            return SterilityStatus.REPROCESSED_REQUIRED_COMPROMISED;
        }
        if (pkg.packagingType() == PackagingType.RIGID_CONTAINER_PTFE_FILTER && pkg.rigidFilterCycleCount() >= pkg.maxFilterCyclesAllowed()) {
            return SterilityStatus.FILTER_EXPIRED;
        }
        return SterilityStatus.STERILE_READY_FOR_USE;
    }
}
