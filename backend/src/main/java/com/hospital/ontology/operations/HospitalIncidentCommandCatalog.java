package com.hospital.ontology.operations;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class HospitalIncidentCommandCatalog {

    @Data
    @AllArgsConstructor
    public static class HicsRoleAssignment {
        private String roleTitle;
        private String assignedStaffName;
        private String operationalSection; // COMMAND, OPERATIONS, PLANNING, LOGISTICS, FINANCE
        private List<String> primaryJobActionSheetDirectives;
    }

    private final List<HicsRoleAssignment> commandStaff = new ArrayList<>();

    public HospitalIncidentCommandCatalog() {
        commandStaff.add(new HicsRoleAssignment("Incident Commander", "Dr. Rajesh Varma, MD (Chief Medical Officer)", "COMMAND", List.of("Activate Emergency Operations Center (EOC)", "Declare Hospital Disaster Status Code Black", "Authorize emergency resource allocation")));
        commandStaff.add(new HicsRoleAssignment("Operations Section Chief", "Dr. Priya Sharma, MD (Chief of Surgery)", "OPERATIONS", List.of("Cancel elective surgeries", "Expand Emergency Department surge capacity by 50 beds", "Establish field triage outside ambulance bay")));
        commandStaff.add(new HicsRoleAssignment("Logistics Section Chief", "Mr. Anand Rao (Director of Facilities)", "LOGISTICS", List.of("Procure emergency oxygen cylinders and backup diesel generators", "Establish secure transportation staging")));
    }

    public List<HicsRoleAssignment> getStaff() { return commandStaff; }
}
