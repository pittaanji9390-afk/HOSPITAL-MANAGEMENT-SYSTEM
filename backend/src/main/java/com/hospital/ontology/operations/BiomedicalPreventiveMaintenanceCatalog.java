package com.hospital.ontology.operations;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.*;

@Component
public class BiomedicalPreventiveMaintenanceCatalog {

    @Data
    @AllArgsConstructor
    public static class EquipmentPmSchedule {
        private String assetTag;
        private String equipmentType;
        private String department;
        private LocalDate lastCalibrationDate;
        private LocalDate nextDuePmDate;
        private boolean isElectricalSafetyCertified;
    }

    private final List<EquipmentPmSchedule> fleet = new ArrayList<>();

    public BiomedicalPreventiveMaintenanceCatalog() {
        fleet.add(new EquipmentPmSchedule("DEFIB-OR-01", "Zoll R-Series Defibrillator", "Operating Room 1", LocalDate.now().minusMonths(3), LocalDate.now().plusMonths(3), true));
        fleet.add(new EquipmentPmSchedule("VENT-ICU-04", "Hamilton G5 Ventilator", "ICU Bed 04", LocalDate.now().minusMonths(5), LocalDate.now().plusMonths(1), true));
        fleet.add(new EquipmentPmSchedule("ANESTH-OR-03", "Drager Perseus A500 Anesthesia Machine", "Operating Room 3", LocalDate.now().minusMonths(2), LocalDate.now().plusMonths(4), true));
    }

    public List<EquipmentPmSchedule> getFleet() { return fleet; }
}
