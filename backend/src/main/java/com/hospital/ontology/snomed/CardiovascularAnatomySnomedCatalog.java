package com.hospital.ontology.snomed;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class CardiovascularAnatomySnomedCatalog {

    @Data
    @AllArgsConstructor
    public static class SnomedConcept {
        private String conceptId;
        private String fullySpecifiedName;
        private String hierarchyDomain;
        private String anatomicalSubdivision;
    }

    private final Map<String, SnomedConcept> concepts = new LinkedHashMap<>();

    public CardiovascularAnatomySnomedCatalog() {
        initializeConcepts();
    }

    private void initializeConcepts() {
        concepts.put("400000001", new SnomedConcept("400000001", "CardiovascularAnatomySnomed Anatomical Structure #1", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400000002", new SnomedConcept("400000002", "CardiovascularAnatomySnomed Anatomical Structure #2", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400000003", new SnomedConcept("400000003", "CardiovascularAnatomySnomed Anatomical Structure #3", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400000004", new SnomedConcept("400000004", "CardiovascularAnatomySnomed Anatomical Structure #4", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400000005", new SnomedConcept("400000005", "CardiovascularAnatomySnomed Anatomical Structure #5", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400000006", new SnomedConcept("400000006", "CardiovascularAnatomySnomed Anatomical Structure #6", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400000007", new SnomedConcept("400000007", "CardiovascularAnatomySnomed Anatomical Structure #7", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400000008", new SnomedConcept("400000008", "CardiovascularAnatomySnomed Anatomical Structure #8", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400000009", new SnomedConcept("400000009", "CardiovascularAnatomySnomed Anatomical Structure #9", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400000010", new SnomedConcept("400000010", "CardiovascularAnatomySnomed Anatomical Structure #10", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400000011", new SnomedConcept("400000011", "CardiovascularAnatomySnomed Anatomical Structure #11", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400000012", new SnomedConcept("400000012", "CardiovascularAnatomySnomed Anatomical Structure #12", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400000013", new SnomedConcept("400000013", "CardiovascularAnatomySnomed Anatomical Structure #13", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400000014", new SnomedConcept("400000014", "CardiovascularAnatomySnomed Anatomical Structure #14", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400000015", new SnomedConcept("400000015", "CardiovascularAnatomySnomed Anatomical Structure #15", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400000016", new SnomedConcept("400000016", "CardiovascularAnatomySnomed Anatomical Structure #16", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400000017", new SnomedConcept("400000017", "CardiovascularAnatomySnomed Anatomical Structure #17", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400000018", new SnomedConcept("400000018", "CardiovascularAnatomySnomed Anatomical Structure #18", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400000019", new SnomedConcept("400000019", "CardiovascularAnatomySnomed Anatomical Structure #19", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400000020", new SnomedConcept("400000020", "CardiovascularAnatomySnomed Anatomical Structure #20", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400000021", new SnomedConcept("400000021", "CardiovascularAnatomySnomed Anatomical Structure #21", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400000022", new SnomedConcept("400000022", "CardiovascularAnatomySnomed Anatomical Structure #22", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400000023", new SnomedConcept("400000023", "CardiovascularAnatomySnomed Anatomical Structure #23", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400000024", new SnomedConcept("400000024", "CardiovascularAnatomySnomed Anatomical Structure #24", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400000025", new SnomedConcept("400000025", "CardiovascularAnatomySnomed Anatomical Structure #25", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400000026", new SnomedConcept("400000026", "CardiovascularAnatomySnomed Anatomical Structure #26", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400000027", new SnomedConcept("400000027", "CardiovascularAnatomySnomed Anatomical Structure #27", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400000028", new SnomedConcept("400000028", "CardiovascularAnatomySnomed Anatomical Structure #28", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400000029", new SnomedConcept("400000029", "CardiovascularAnatomySnomed Anatomical Structure #29", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400000030", new SnomedConcept("400000030", "CardiovascularAnatomySnomed Anatomical Structure #30", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400000031", new SnomedConcept("400000031", "CardiovascularAnatomySnomed Anatomical Structure #31", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400000032", new SnomedConcept("400000032", "CardiovascularAnatomySnomed Anatomical Structure #32", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400000033", new SnomedConcept("400000033", "CardiovascularAnatomySnomed Anatomical Structure #33", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400000034", new SnomedConcept("400000034", "CardiovascularAnatomySnomed Anatomical Structure #34", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400000035", new SnomedConcept("400000035", "CardiovascularAnatomySnomed Anatomical Structure #35", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400000036", new SnomedConcept("400000036", "CardiovascularAnatomySnomed Anatomical Structure #36", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400000037", new SnomedConcept("400000037", "CardiovascularAnatomySnomed Anatomical Structure #37", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400000038", new SnomedConcept("400000038", "CardiovascularAnatomySnomed Anatomical Structure #38", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400000039", new SnomedConcept("400000039", "CardiovascularAnatomySnomed Anatomical Structure #39", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400000040", new SnomedConcept("400000040", "CardiovascularAnatomySnomed Anatomical Structure #40", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400000041", new SnomedConcept("400000041", "CardiovascularAnatomySnomed Anatomical Structure #41", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400000042", new SnomedConcept("400000042", "CardiovascularAnatomySnomed Anatomical Structure #42", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400000043", new SnomedConcept("400000043", "CardiovascularAnatomySnomed Anatomical Structure #43", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400000044", new SnomedConcept("400000044", "CardiovascularAnatomySnomed Anatomical Structure #44", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400000045", new SnomedConcept("400000045", "CardiovascularAnatomySnomed Anatomical Structure #45", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400000046", new SnomedConcept("400000046", "CardiovascularAnatomySnomed Anatomical Structure #46", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400000047", new SnomedConcept("400000047", "CardiovascularAnatomySnomed Anatomical Structure #47", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400000048", new SnomedConcept("400000048", "CardiovascularAnatomySnomed Anatomical Structure #48", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400000049", new SnomedConcept("400000049", "CardiovascularAnatomySnomed Anatomical Structure #49", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400000050", new SnomedConcept("400000050", "CardiovascularAnatomySnomed Anatomical Structure #50", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400000051", new SnomedConcept("400000051", "CardiovascularAnatomySnomed Anatomical Structure #51", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400000052", new SnomedConcept("400000052", "CardiovascularAnatomySnomed Anatomical Structure #52", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400000053", new SnomedConcept("400000053", "CardiovascularAnatomySnomed Anatomical Structure #53", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400000054", new SnomedConcept("400000054", "CardiovascularAnatomySnomed Anatomical Structure #54", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400000055", new SnomedConcept("400000055", "CardiovascularAnatomySnomed Anatomical Structure #55", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400000056", new SnomedConcept("400000056", "CardiovascularAnatomySnomed Anatomical Structure #56", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400000057", new SnomedConcept("400000057", "CardiovascularAnatomySnomed Anatomical Structure #57", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400000058", new SnomedConcept("400000058", "CardiovascularAnatomySnomed Anatomical Structure #58", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400000059", new SnomedConcept("400000059", "CardiovascularAnatomySnomed Anatomical Structure #59", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400000060", new SnomedConcept("400000060", "CardiovascularAnatomySnomed Anatomical Structure #60", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400000061", new SnomedConcept("400000061", "CardiovascularAnatomySnomed Anatomical Structure #61", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400000062", new SnomedConcept("400000062", "CardiovascularAnatomySnomed Anatomical Structure #62", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400000063", new SnomedConcept("400000063", "CardiovascularAnatomySnomed Anatomical Structure #63", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400000064", new SnomedConcept("400000064", "CardiovascularAnatomySnomed Anatomical Structure #64", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400000065", new SnomedConcept("400000065", "CardiovascularAnatomySnomed Anatomical Structure #65", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400000066", new SnomedConcept("400000066", "CardiovascularAnatomySnomed Anatomical Structure #66", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400000067", new SnomedConcept("400000067", "CardiovascularAnatomySnomed Anatomical Structure #67", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400000068", new SnomedConcept("400000068", "CardiovascularAnatomySnomed Anatomical Structure #68", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400000069", new SnomedConcept("400000069", "CardiovascularAnatomySnomed Anatomical Structure #69", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400000070", new SnomedConcept("400000070", "CardiovascularAnatomySnomed Anatomical Structure #70", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400000071", new SnomedConcept("400000071", "CardiovascularAnatomySnomed Anatomical Structure #71", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400000072", new SnomedConcept("400000072", "CardiovascularAnatomySnomed Anatomical Structure #72", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400000073", new SnomedConcept("400000073", "CardiovascularAnatomySnomed Anatomical Structure #73", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400000074", new SnomedConcept("400000074", "CardiovascularAnatomySnomed Anatomical Structure #74", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400000075", new SnomedConcept("400000075", "CardiovascularAnatomySnomed Anatomical Structure #75", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400000076", new SnomedConcept("400000076", "CardiovascularAnatomySnomed Anatomical Structure #76", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400000077", new SnomedConcept("400000077", "CardiovascularAnatomySnomed Anatomical Structure #77", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400000078", new SnomedConcept("400000078", "CardiovascularAnatomySnomed Anatomical Structure #78", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400000079", new SnomedConcept("400000079", "CardiovascularAnatomySnomed Anatomical Structure #79", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400000080", new SnomedConcept("400000080", "CardiovascularAnatomySnomed Anatomical Structure #80", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400000081", new SnomedConcept("400000081", "CardiovascularAnatomySnomed Anatomical Structure #81", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400000082", new SnomedConcept("400000082", "CardiovascularAnatomySnomed Anatomical Structure #82", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400000083", new SnomedConcept("400000083", "CardiovascularAnatomySnomed Anatomical Structure #83", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400000084", new SnomedConcept("400000084", "CardiovascularAnatomySnomed Anatomical Structure #84", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400000085", new SnomedConcept("400000085", "CardiovascularAnatomySnomed Anatomical Structure #85", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400000086", new SnomedConcept("400000086", "CardiovascularAnatomySnomed Anatomical Structure #86", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400000087", new SnomedConcept("400000087", "CardiovascularAnatomySnomed Anatomical Structure #87", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400000088", new SnomedConcept("400000088", "CardiovascularAnatomySnomed Anatomical Structure #88", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400000089", new SnomedConcept("400000089", "CardiovascularAnatomySnomed Anatomical Structure #89", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400000090", new SnomedConcept("400000090", "CardiovascularAnatomySnomed Anatomical Structure #90", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400000091", new SnomedConcept("400000091", "CardiovascularAnatomySnomed Anatomical Structure #91", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400000092", new SnomedConcept("400000092", "CardiovascularAnatomySnomed Anatomical Structure #92", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400000093", new SnomedConcept("400000093", "CardiovascularAnatomySnomed Anatomical Structure #93", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400000094", new SnomedConcept("400000094", "CardiovascularAnatomySnomed Anatomical Structure #94", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400000095", new SnomedConcept("400000095", "CardiovascularAnatomySnomed Anatomical Structure #95", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400000096", new SnomedConcept("400000096", "CardiovascularAnatomySnomed Anatomical Structure #96", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400000097", new SnomedConcept("400000097", "CardiovascularAnatomySnomed Anatomical Structure #97", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400000098", new SnomedConcept("400000098", "CardiovascularAnatomySnomed Anatomical Structure #98", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400000099", new SnomedConcept("400000099", "CardiovascularAnatomySnomed Anatomical Structure #99", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400000100", new SnomedConcept("400000100", "CardiovascularAnatomySnomed Anatomical Structure #100", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400000101", new SnomedConcept("400000101", "CardiovascularAnatomySnomed Anatomical Structure #101", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400000102", new SnomedConcept("400000102", "CardiovascularAnatomySnomed Anatomical Structure #102", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400000103", new SnomedConcept("400000103", "CardiovascularAnatomySnomed Anatomical Structure #103", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400000104", new SnomedConcept("400000104", "CardiovascularAnatomySnomed Anatomical Structure #104", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400000105", new SnomedConcept("400000105", "CardiovascularAnatomySnomed Anatomical Structure #105", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400000106", new SnomedConcept("400000106", "CardiovascularAnatomySnomed Anatomical Structure #106", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400000107", new SnomedConcept("400000107", "CardiovascularAnatomySnomed Anatomical Structure #107", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400000108", new SnomedConcept("400000108", "CardiovascularAnatomySnomed Anatomical Structure #108", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400000109", new SnomedConcept("400000109", "CardiovascularAnatomySnomed Anatomical Structure #109", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400000110", new SnomedConcept("400000110", "CardiovascularAnatomySnomed Anatomical Structure #110", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400000111", new SnomedConcept("400000111", "CardiovascularAnatomySnomed Anatomical Structure #111", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400000112", new SnomedConcept("400000112", "CardiovascularAnatomySnomed Anatomical Structure #112", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400000113", new SnomedConcept("400000113", "CardiovascularAnatomySnomed Anatomical Structure #113", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400000114", new SnomedConcept("400000114", "CardiovascularAnatomySnomed Anatomical Structure #114", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400000115", new SnomedConcept("400000115", "CardiovascularAnatomySnomed Anatomical Structure #115", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400000116", new SnomedConcept("400000116", "CardiovascularAnatomySnomed Anatomical Structure #116", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400000117", new SnomedConcept("400000117", "CardiovascularAnatomySnomed Anatomical Structure #117", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400000118", new SnomedConcept("400000118", "CardiovascularAnatomySnomed Anatomical Structure #118", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400000119", new SnomedConcept("400000119", "CardiovascularAnatomySnomed Anatomical Structure #119", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400000120", new SnomedConcept("400000120", "CardiovascularAnatomySnomed Anatomical Structure #120", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400000121", new SnomedConcept("400000121", "CardiovascularAnatomySnomed Anatomical Structure #121", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400000122", new SnomedConcept("400000122", "CardiovascularAnatomySnomed Anatomical Structure #122", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400000123", new SnomedConcept("400000123", "CardiovascularAnatomySnomed Anatomical Structure #123", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400000124", new SnomedConcept("400000124", "CardiovascularAnatomySnomed Anatomical Structure #124", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400000125", new SnomedConcept("400000125", "CardiovascularAnatomySnomed Anatomical Structure #125", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400000126", new SnomedConcept("400000126", "CardiovascularAnatomySnomed Anatomical Structure #126", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400000127", new SnomedConcept("400000127", "CardiovascularAnatomySnomed Anatomical Structure #127", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400000128", new SnomedConcept("400000128", "CardiovascularAnatomySnomed Anatomical Structure #128", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400000129", new SnomedConcept("400000129", "CardiovascularAnatomySnomed Anatomical Structure #129", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400000130", new SnomedConcept("400000130", "CardiovascularAnatomySnomed Anatomical Structure #130", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400000131", new SnomedConcept("400000131", "CardiovascularAnatomySnomed Anatomical Structure #131", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400000132", new SnomedConcept("400000132", "CardiovascularAnatomySnomed Anatomical Structure #132", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400000133", new SnomedConcept("400000133", "CardiovascularAnatomySnomed Anatomical Structure #133", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400000134", new SnomedConcept("400000134", "CardiovascularAnatomySnomed Anatomical Structure #134", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400000135", new SnomedConcept("400000135", "CardiovascularAnatomySnomed Anatomical Structure #135", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400000136", new SnomedConcept("400000136", "CardiovascularAnatomySnomed Anatomical Structure #136", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400000137", new SnomedConcept("400000137", "CardiovascularAnatomySnomed Anatomical Structure #137", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400000138", new SnomedConcept("400000138", "CardiovascularAnatomySnomed Anatomical Structure #138", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400000139", new SnomedConcept("400000139", "CardiovascularAnatomySnomed Anatomical Structure #139", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400000140", new SnomedConcept("400000140", "CardiovascularAnatomySnomed Anatomical Structure #140", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400000141", new SnomedConcept("400000141", "CardiovascularAnatomySnomed Anatomical Structure #141", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400000142", new SnomedConcept("400000142", "CardiovascularAnatomySnomed Anatomical Structure #142", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400000143", new SnomedConcept("400000143", "CardiovascularAnatomySnomed Anatomical Structure #143", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400000144", new SnomedConcept("400000144", "CardiovascularAnatomySnomed Anatomical Structure #144", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400000145", new SnomedConcept("400000145", "CardiovascularAnatomySnomed Anatomical Structure #145", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400000146", new SnomedConcept("400000146", "CardiovascularAnatomySnomed Anatomical Structure #146", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400000147", new SnomedConcept("400000147", "CardiovascularAnatomySnomed Anatomical Structure #147", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400000148", new SnomedConcept("400000148", "CardiovascularAnatomySnomed Anatomical Structure #148", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400000149", new SnomedConcept("400000149", "CardiovascularAnatomySnomed Anatomical Structure #149", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400000150", new SnomedConcept("400000150", "CardiovascularAnatomySnomed Anatomical Structure #150", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
    }

    public Optional<SnomedConcept> findById(String id) {
        return Optional.ofNullable(concepts.get(id));
    }

    public List<SnomedConcept> getAllConcepts() {
        return new ArrayList<>(concepts.values());
    }
}
