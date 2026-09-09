package com.hospital.ontology.snomed;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class RespiratoryAnatomySnomedCatalog {

    @Data
    @AllArgsConstructor
    public static class SnomedConcept {
        private String conceptId;
        private String fullySpecifiedName;
        private String hierarchyDomain;
        private String anatomicalSubdivision;
    }

    private final Map<String, SnomedConcept> concepts = new LinkedHashMap<>();

    public RespiratoryAnatomySnomedCatalog() {
        initializeConcepts();
    }

    private void initializeConcepts() {
        concepts.put("400020001", new SnomedConcept("400020001", "RespiratoryAnatomySnomed Anatomical Structure #1", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400020002", new SnomedConcept("400020002", "RespiratoryAnatomySnomed Anatomical Structure #2", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400020003", new SnomedConcept("400020003", "RespiratoryAnatomySnomed Anatomical Structure #3", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400020004", new SnomedConcept("400020004", "RespiratoryAnatomySnomed Anatomical Structure #4", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400020005", new SnomedConcept("400020005", "RespiratoryAnatomySnomed Anatomical Structure #5", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400020006", new SnomedConcept("400020006", "RespiratoryAnatomySnomed Anatomical Structure #6", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400020007", new SnomedConcept("400020007", "RespiratoryAnatomySnomed Anatomical Structure #7", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400020008", new SnomedConcept("400020008", "RespiratoryAnatomySnomed Anatomical Structure #8", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400020009", new SnomedConcept("400020009", "RespiratoryAnatomySnomed Anatomical Structure #9", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400020010", new SnomedConcept("400020010", "RespiratoryAnatomySnomed Anatomical Structure #10", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400020011", new SnomedConcept("400020011", "RespiratoryAnatomySnomed Anatomical Structure #11", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400020012", new SnomedConcept("400020012", "RespiratoryAnatomySnomed Anatomical Structure #12", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400020013", new SnomedConcept("400020013", "RespiratoryAnatomySnomed Anatomical Structure #13", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400020014", new SnomedConcept("400020014", "RespiratoryAnatomySnomed Anatomical Structure #14", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400020015", new SnomedConcept("400020015", "RespiratoryAnatomySnomed Anatomical Structure #15", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400020016", new SnomedConcept("400020016", "RespiratoryAnatomySnomed Anatomical Structure #16", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400020017", new SnomedConcept("400020017", "RespiratoryAnatomySnomed Anatomical Structure #17", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400020018", new SnomedConcept("400020018", "RespiratoryAnatomySnomed Anatomical Structure #18", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400020019", new SnomedConcept("400020019", "RespiratoryAnatomySnomed Anatomical Structure #19", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400020020", new SnomedConcept("400020020", "RespiratoryAnatomySnomed Anatomical Structure #20", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400020021", new SnomedConcept("400020021", "RespiratoryAnatomySnomed Anatomical Structure #21", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400020022", new SnomedConcept("400020022", "RespiratoryAnatomySnomed Anatomical Structure #22", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400020023", new SnomedConcept("400020023", "RespiratoryAnatomySnomed Anatomical Structure #23", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400020024", new SnomedConcept("400020024", "RespiratoryAnatomySnomed Anatomical Structure #24", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400020025", new SnomedConcept("400020025", "RespiratoryAnatomySnomed Anatomical Structure #25", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400020026", new SnomedConcept("400020026", "RespiratoryAnatomySnomed Anatomical Structure #26", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400020027", new SnomedConcept("400020027", "RespiratoryAnatomySnomed Anatomical Structure #27", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400020028", new SnomedConcept("400020028", "RespiratoryAnatomySnomed Anatomical Structure #28", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400020029", new SnomedConcept("400020029", "RespiratoryAnatomySnomed Anatomical Structure #29", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400020030", new SnomedConcept("400020030", "RespiratoryAnatomySnomed Anatomical Structure #30", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400020031", new SnomedConcept("400020031", "RespiratoryAnatomySnomed Anatomical Structure #31", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400020032", new SnomedConcept("400020032", "RespiratoryAnatomySnomed Anatomical Structure #32", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400020033", new SnomedConcept("400020033", "RespiratoryAnatomySnomed Anatomical Structure #33", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400020034", new SnomedConcept("400020034", "RespiratoryAnatomySnomed Anatomical Structure #34", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400020035", new SnomedConcept("400020035", "RespiratoryAnatomySnomed Anatomical Structure #35", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400020036", new SnomedConcept("400020036", "RespiratoryAnatomySnomed Anatomical Structure #36", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400020037", new SnomedConcept("400020037", "RespiratoryAnatomySnomed Anatomical Structure #37", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400020038", new SnomedConcept("400020038", "RespiratoryAnatomySnomed Anatomical Structure #38", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400020039", new SnomedConcept("400020039", "RespiratoryAnatomySnomed Anatomical Structure #39", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400020040", new SnomedConcept("400020040", "RespiratoryAnatomySnomed Anatomical Structure #40", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400020041", new SnomedConcept("400020041", "RespiratoryAnatomySnomed Anatomical Structure #41", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400020042", new SnomedConcept("400020042", "RespiratoryAnatomySnomed Anatomical Structure #42", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400020043", new SnomedConcept("400020043", "RespiratoryAnatomySnomed Anatomical Structure #43", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400020044", new SnomedConcept("400020044", "RespiratoryAnatomySnomed Anatomical Structure #44", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400020045", new SnomedConcept("400020045", "RespiratoryAnatomySnomed Anatomical Structure #45", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400020046", new SnomedConcept("400020046", "RespiratoryAnatomySnomed Anatomical Structure #46", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400020047", new SnomedConcept("400020047", "RespiratoryAnatomySnomed Anatomical Structure #47", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400020048", new SnomedConcept("400020048", "RespiratoryAnatomySnomed Anatomical Structure #48", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400020049", new SnomedConcept("400020049", "RespiratoryAnatomySnomed Anatomical Structure #49", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400020050", new SnomedConcept("400020050", "RespiratoryAnatomySnomed Anatomical Structure #50", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400020051", new SnomedConcept("400020051", "RespiratoryAnatomySnomed Anatomical Structure #51", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400020052", new SnomedConcept("400020052", "RespiratoryAnatomySnomed Anatomical Structure #52", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400020053", new SnomedConcept("400020053", "RespiratoryAnatomySnomed Anatomical Structure #53", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400020054", new SnomedConcept("400020054", "RespiratoryAnatomySnomed Anatomical Structure #54", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400020055", new SnomedConcept("400020055", "RespiratoryAnatomySnomed Anatomical Structure #55", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400020056", new SnomedConcept("400020056", "RespiratoryAnatomySnomed Anatomical Structure #56", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400020057", new SnomedConcept("400020057", "RespiratoryAnatomySnomed Anatomical Structure #57", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400020058", new SnomedConcept("400020058", "RespiratoryAnatomySnomed Anatomical Structure #58", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400020059", new SnomedConcept("400020059", "RespiratoryAnatomySnomed Anatomical Structure #59", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400020060", new SnomedConcept("400020060", "RespiratoryAnatomySnomed Anatomical Structure #60", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400020061", new SnomedConcept("400020061", "RespiratoryAnatomySnomed Anatomical Structure #61", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400020062", new SnomedConcept("400020062", "RespiratoryAnatomySnomed Anatomical Structure #62", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400020063", new SnomedConcept("400020063", "RespiratoryAnatomySnomed Anatomical Structure #63", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400020064", new SnomedConcept("400020064", "RespiratoryAnatomySnomed Anatomical Structure #64", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400020065", new SnomedConcept("400020065", "RespiratoryAnatomySnomed Anatomical Structure #65", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400020066", new SnomedConcept("400020066", "RespiratoryAnatomySnomed Anatomical Structure #66", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400020067", new SnomedConcept("400020067", "RespiratoryAnatomySnomed Anatomical Structure #67", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400020068", new SnomedConcept("400020068", "RespiratoryAnatomySnomed Anatomical Structure #68", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400020069", new SnomedConcept("400020069", "RespiratoryAnatomySnomed Anatomical Structure #69", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400020070", new SnomedConcept("400020070", "RespiratoryAnatomySnomed Anatomical Structure #70", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400020071", new SnomedConcept("400020071", "RespiratoryAnatomySnomed Anatomical Structure #71", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400020072", new SnomedConcept("400020072", "RespiratoryAnatomySnomed Anatomical Structure #72", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400020073", new SnomedConcept("400020073", "RespiratoryAnatomySnomed Anatomical Structure #73", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400020074", new SnomedConcept("400020074", "RespiratoryAnatomySnomed Anatomical Structure #74", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400020075", new SnomedConcept("400020075", "RespiratoryAnatomySnomed Anatomical Structure #75", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400020076", new SnomedConcept("400020076", "RespiratoryAnatomySnomed Anatomical Structure #76", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400020077", new SnomedConcept("400020077", "RespiratoryAnatomySnomed Anatomical Structure #77", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400020078", new SnomedConcept("400020078", "RespiratoryAnatomySnomed Anatomical Structure #78", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400020079", new SnomedConcept("400020079", "RespiratoryAnatomySnomed Anatomical Structure #79", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400020080", new SnomedConcept("400020080", "RespiratoryAnatomySnomed Anatomical Structure #80", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400020081", new SnomedConcept("400020081", "RespiratoryAnatomySnomed Anatomical Structure #81", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400020082", new SnomedConcept("400020082", "RespiratoryAnatomySnomed Anatomical Structure #82", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400020083", new SnomedConcept("400020083", "RespiratoryAnatomySnomed Anatomical Structure #83", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400020084", new SnomedConcept("400020084", "RespiratoryAnatomySnomed Anatomical Structure #84", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400020085", new SnomedConcept("400020085", "RespiratoryAnatomySnomed Anatomical Structure #85", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400020086", new SnomedConcept("400020086", "RespiratoryAnatomySnomed Anatomical Structure #86", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400020087", new SnomedConcept("400020087", "RespiratoryAnatomySnomed Anatomical Structure #87", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400020088", new SnomedConcept("400020088", "RespiratoryAnatomySnomed Anatomical Structure #88", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400020089", new SnomedConcept("400020089", "RespiratoryAnatomySnomed Anatomical Structure #89", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400020090", new SnomedConcept("400020090", "RespiratoryAnatomySnomed Anatomical Structure #90", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400020091", new SnomedConcept("400020091", "RespiratoryAnatomySnomed Anatomical Structure #91", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400020092", new SnomedConcept("400020092", "RespiratoryAnatomySnomed Anatomical Structure #92", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400020093", new SnomedConcept("400020093", "RespiratoryAnatomySnomed Anatomical Structure #93", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400020094", new SnomedConcept("400020094", "RespiratoryAnatomySnomed Anatomical Structure #94", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400020095", new SnomedConcept("400020095", "RespiratoryAnatomySnomed Anatomical Structure #95", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400020096", new SnomedConcept("400020096", "RespiratoryAnatomySnomed Anatomical Structure #96", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400020097", new SnomedConcept("400020097", "RespiratoryAnatomySnomed Anatomical Structure #97", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400020098", new SnomedConcept("400020098", "RespiratoryAnatomySnomed Anatomical Structure #98", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400020099", new SnomedConcept("400020099", "RespiratoryAnatomySnomed Anatomical Structure #99", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400020100", new SnomedConcept("400020100", "RespiratoryAnatomySnomed Anatomical Structure #100", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400020101", new SnomedConcept("400020101", "RespiratoryAnatomySnomed Anatomical Structure #101", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400020102", new SnomedConcept("400020102", "RespiratoryAnatomySnomed Anatomical Structure #102", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400020103", new SnomedConcept("400020103", "RespiratoryAnatomySnomed Anatomical Structure #103", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400020104", new SnomedConcept("400020104", "RespiratoryAnatomySnomed Anatomical Structure #104", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400020105", new SnomedConcept("400020105", "RespiratoryAnatomySnomed Anatomical Structure #105", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400020106", new SnomedConcept("400020106", "RespiratoryAnatomySnomed Anatomical Structure #106", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400020107", new SnomedConcept("400020107", "RespiratoryAnatomySnomed Anatomical Structure #107", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400020108", new SnomedConcept("400020108", "RespiratoryAnatomySnomed Anatomical Structure #108", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400020109", new SnomedConcept("400020109", "RespiratoryAnatomySnomed Anatomical Structure #109", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400020110", new SnomedConcept("400020110", "RespiratoryAnatomySnomed Anatomical Structure #110", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400020111", new SnomedConcept("400020111", "RespiratoryAnatomySnomed Anatomical Structure #111", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400020112", new SnomedConcept("400020112", "RespiratoryAnatomySnomed Anatomical Structure #112", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400020113", new SnomedConcept("400020113", "RespiratoryAnatomySnomed Anatomical Structure #113", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400020114", new SnomedConcept("400020114", "RespiratoryAnatomySnomed Anatomical Structure #114", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400020115", new SnomedConcept("400020115", "RespiratoryAnatomySnomed Anatomical Structure #115", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400020116", new SnomedConcept("400020116", "RespiratoryAnatomySnomed Anatomical Structure #116", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400020117", new SnomedConcept("400020117", "RespiratoryAnatomySnomed Anatomical Structure #117", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400020118", new SnomedConcept("400020118", "RespiratoryAnatomySnomed Anatomical Structure #118", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400020119", new SnomedConcept("400020119", "RespiratoryAnatomySnomed Anatomical Structure #119", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400020120", new SnomedConcept("400020120", "RespiratoryAnatomySnomed Anatomical Structure #120", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400020121", new SnomedConcept("400020121", "RespiratoryAnatomySnomed Anatomical Structure #121", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400020122", new SnomedConcept("400020122", "RespiratoryAnatomySnomed Anatomical Structure #122", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400020123", new SnomedConcept("400020123", "RespiratoryAnatomySnomed Anatomical Structure #123", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400020124", new SnomedConcept("400020124", "RespiratoryAnatomySnomed Anatomical Structure #124", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400020125", new SnomedConcept("400020125", "RespiratoryAnatomySnomed Anatomical Structure #125", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400020126", new SnomedConcept("400020126", "RespiratoryAnatomySnomed Anatomical Structure #126", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400020127", new SnomedConcept("400020127", "RespiratoryAnatomySnomed Anatomical Structure #127", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400020128", new SnomedConcept("400020128", "RespiratoryAnatomySnomed Anatomical Structure #128", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400020129", new SnomedConcept("400020129", "RespiratoryAnatomySnomed Anatomical Structure #129", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400020130", new SnomedConcept("400020130", "RespiratoryAnatomySnomed Anatomical Structure #130", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400020131", new SnomedConcept("400020131", "RespiratoryAnatomySnomed Anatomical Structure #131", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400020132", new SnomedConcept("400020132", "RespiratoryAnatomySnomed Anatomical Structure #132", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400020133", new SnomedConcept("400020133", "RespiratoryAnatomySnomed Anatomical Structure #133", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400020134", new SnomedConcept("400020134", "RespiratoryAnatomySnomed Anatomical Structure #134", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400020135", new SnomedConcept("400020135", "RespiratoryAnatomySnomed Anatomical Structure #135", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400020136", new SnomedConcept("400020136", "RespiratoryAnatomySnomed Anatomical Structure #136", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400020137", new SnomedConcept("400020137", "RespiratoryAnatomySnomed Anatomical Structure #137", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400020138", new SnomedConcept("400020138", "RespiratoryAnatomySnomed Anatomical Structure #138", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400020139", new SnomedConcept("400020139", "RespiratoryAnatomySnomed Anatomical Structure #139", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400020140", new SnomedConcept("400020140", "RespiratoryAnatomySnomed Anatomical Structure #140", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400020141", new SnomedConcept("400020141", "RespiratoryAnatomySnomed Anatomical Structure #141", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400020142", new SnomedConcept("400020142", "RespiratoryAnatomySnomed Anatomical Structure #142", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400020143", new SnomedConcept("400020143", "RespiratoryAnatomySnomed Anatomical Structure #143", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400020144", new SnomedConcept("400020144", "RespiratoryAnatomySnomed Anatomical Structure #144", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400020145", new SnomedConcept("400020145", "RespiratoryAnatomySnomed Anatomical Structure #145", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400020146", new SnomedConcept("400020146", "RespiratoryAnatomySnomed Anatomical Structure #146", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400020147", new SnomedConcept("400020147", "RespiratoryAnatomySnomed Anatomical Structure #147", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400020148", new SnomedConcept("400020148", "RespiratoryAnatomySnomed Anatomical Structure #148", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400020149", new SnomedConcept("400020149", "RespiratoryAnatomySnomed Anatomical Structure #149", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400020150", new SnomedConcept("400020150", "RespiratoryAnatomySnomed Anatomical Structure #150", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
    }

    public Optional<SnomedConcept> findById(String id) {
        return Optional.ofNullable(concepts.get(id));
    }

    public List<SnomedConcept> getAllConcepts() {
        return new ArrayList<>(concepts.values());
    }
}
