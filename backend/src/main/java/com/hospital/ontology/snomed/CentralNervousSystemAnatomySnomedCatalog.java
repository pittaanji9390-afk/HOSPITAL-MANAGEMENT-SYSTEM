package com.hospital.ontology.snomed;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class CentralNervousSystemAnatomySnomedCatalog {

    @Data
    @AllArgsConstructor
    public static class SnomedConcept {
        private String conceptId;
        private String fullySpecifiedName;
        private String hierarchyDomain;
        private String anatomicalSubdivision;
    }

    private final Map<String, SnomedConcept> concepts = new LinkedHashMap<>();

    public CentralNervousSystemAnatomySnomedCatalog() {
        initializeConcepts();
    }

    private void initializeConcepts() {
        concepts.put("400010001", new SnomedConcept("400010001", "CentralNervousSystemAnatomySnomed Anatomical Structure #1", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400010002", new SnomedConcept("400010002", "CentralNervousSystemAnatomySnomed Anatomical Structure #2", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400010003", new SnomedConcept("400010003", "CentralNervousSystemAnatomySnomed Anatomical Structure #3", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400010004", new SnomedConcept("400010004", "CentralNervousSystemAnatomySnomed Anatomical Structure #4", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400010005", new SnomedConcept("400010005", "CentralNervousSystemAnatomySnomed Anatomical Structure #5", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400010006", new SnomedConcept("400010006", "CentralNervousSystemAnatomySnomed Anatomical Structure #6", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400010007", new SnomedConcept("400010007", "CentralNervousSystemAnatomySnomed Anatomical Structure #7", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400010008", new SnomedConcept("400010008", "CentralNervousSystemAnatomySnomed Anatomical Structure #8", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400010009", new SnomedConcept("400010009", "CentralNervousSystemAnatomySnomed Anatomical Structure #9", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400010010", new SnomedConcept("400010010", "CentralNervousSystemAnatomySnomed Anatomical Structure #10", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400010011", new SnomedConcept("400010011", "CentralNervousSystemAnatomySnomed Anatomical Structure #11", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400010012", new SnomedConcept("400010012", "CentralNervousSystemAnatomySnomed Anatomical Structure #12", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400010013", new SnomedConcept("400010013", "CentralNervousSystemAnatomySnomed Anatomical Structure #13", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400010014", new SnomedConcept("400010014", "CentralNervousSystemAnatomySnomed Anatomical Structure #14", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400010015", new SnomedConcept("400010015", "CentralNervousSystemAnatomySnomed Anatomical Structure #15", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400010016", new SnomedConcept("400010016", "CentralNervousSystemAnatomySnomed Anatomical Structure #16", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400010017", new SnomedConcept("400010017", "CentralNervousSystemAnatomySnomed Anatomical Structure #17", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400010018", new SnomedConcept("400010018", "CentralNervousSystemAnatomySnomed Anatomical Structure #18", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400010019", new SnomedConcept("400010019", "CentralNervousSystemAnatomySnomed Anatomical Structure #19", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400010020", new SnomedConcept("400010020", "CentralNervousSystemAnatomySnomed Anatomical Structure #20", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400010021", new SnomedConcept("400010021", "CentralNervousSystemAnatomySnomed Anatomical Structure #21", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400010022", new SnomedConcept("400010022", "CentralNervousSystemAnatomySnomed Anatomical Structure #22", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400010023", new SnomedConcept("400010023", "CentralNervousSystemAnatomySnomed Anatomical Structure #23", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400010024", new SnomedConcept("400010024", "CentralNervousSystemAnatomySnomed Anatomical Structure #24", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400010025", new SnomedConcept("400010025", "CentralNervousSystemAnatomySnomed Anatomical Structure #25", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400010026", new SnomedConcept("400010026", "CentralNervousSystemAnatomySnomed Anatomical Structure #26", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400010027", new SnomedConcept("400010027", "CentralNervousSystemAnatomySnomed Anatomical Structure #27", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400010028", new SnomedConcept("400010028", "CentralNervousSystemAnatomySnomed Anatomical Structure #28", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400010029", new SnomedConcept("400010029", "CentralNervousSystemAnatomySnomed Anatomical Structure #29", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400010030", new SnomedConcept("400010030", "CentralNervousSystemAnatomySnomed Anatomical Structure #30", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400010031", new SnomedConcept("400010031", "CentralNervousSystemAnatomySnomed Anatomical Structure #31", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400010032", new SnomedConcept("400010032", "CentralNervousSystemAnatomySnomed Anatomical Structure #32", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400010033", new SnomedConcept("400010033", "CentralNervousSystemAnatomySnomed Anatomical Structure #33", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400010034", new SnomedConcept("400010034", "CentralNervousSystemAnatomySnomed Anatomical Structure #34", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400010035", new SnomedConcept("400010035", "CentralNervousSystemAnatomySnomed Anatomical Structure #35", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400010036", new SnomedConcept("400010036", "CentralNervousSystemAnatomySnomed Anatomical Structure #36", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400010037", new SnomedConcept("400010037", "CentralNervousSystemAnatomySnomed Anatomical Structure #37", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400010038", new SnomedConcept("400010038", "CentralNervousSystemAnatomySnomed Anatomical Structure #38", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400010039", new SnomedConcept("400010039", "CentralNervousSystemAnatomySnomed Anatomical Structure #39", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400010040", new SnomedConcept("400010040", "CentralNervousSystemAnatomySnomed Anatomical Structure #40", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400010041", new SnomedConcept("400010041", "CentralNervousSystemAnatomySnomed Anatomical Structure #41", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400010042", new SnomedConcept("400010042", "CentralNervousSystemAnatomySnomed Anatomical Structure #42", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400010043", new SnomedConcept("400010043", "CentralNervousSystemAnatomySnomed Anatomical Structure #43", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400010044", new SnomedConcept("400010044", "CentralNervousSystemAnatomySnomed Anatomical Structure #44", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400010045", new SnomedConcept("400010045", "CentralNervousSystemAnatomySnomed Anatomical Structure #45", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400010046", new SnomedConcept("400010046", "CentralNervousSystemAnatomySnomed Anatomical Structure #46", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400010047", new SnomedConcept("400010047", "CentralNervousSystemAnatomySnomed Anatomical Structure #47", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400010048", new SnomedConcept("400010048", "CentralNervousSystemAnatomySnomed Anatomical Structure #48", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400010049", new SnomedConcept("400010049", "CentralNervousSystemAnatomySnomed Anatomical Structure #49", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400010050", new SnomedConcept("400010050", "CentralNervousSystemAnatomySnomed Anatomical Structure #50", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400010051", new SnomedConcept("400010051", "CentralNervousSystemAnatomySnomed Anatomical Structure #51", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400010052", new SnomedConcept("400010052", "CentralNervousSystemAnatomySnomed Anatomical Structure #52", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400010053", new SnomedConcept("400010053", "CentralNervousSystemAnatomySnomed Anatomical Structure #53", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400010054", new SnomedConcept("400010054", "CentralNervousSystemAnatomySnomed Anatomical Structure #54", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400010055", new SnomedConcept("400010055", "CentralNervousSystemAnatomySnomed Anatomical Structure #55", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400010056", new SnomedConcept("400010056", "CentralNervousSystemAnatomySnomed Anatomical Structure #56", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400010057", new SnomedConcept("400010057", "CentralNervousSystemAnatomySnomed Anatomical Structure #57", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400010058", new SnomedConcept("400010058", "CentralNervousSystemAnatomySnomed Anatomical Structure #58", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400010059", new SnomedConcept("400010059", "CentralNervousSystemAnatomySnomed Anatomical Structure #59", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400010060", new SnomedConcept("400010060", "CentralNervousSystemAnatomySnomed Anatomical Structure #60", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400010061", new SnomedConcept("400010061", "CentralNervousSystemAnatomySnomed Anatomical Structure #61", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400010062", new SnomedConcept("400010062", "CentralNervousSystemAnatomySnomed Anatomical Structure #62", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400010063", new SnomedConcept("400010063", "CentralNervousSystemAnatomySnomed Anatomical Structure #63", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400010064", new SnomedConcept("400010064", "CentralNervousSystemAnatomySnomed Anatomical Structure #64", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400010065", new SnomedConcept("400010065", "CentralNervousSystemAnatomySnomed Anatomical Structure #65", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400010066", new SnomedConcept("400010066", "CentralNervousSystemAnatomySnomed Anatomical Structure #66", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400010067", new SnomedConcept("400010067", "CentralNervousSystemAnatomySnomed Anatomical Structure #67", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400010068", new SnomedConcept("400010068", "CentralNervousSystemAnatomySnomed Anatomical Structure #68", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400010069", new SnomedConcept("400010069", "CentralNervousSystemAnatomySnomed Anatomical Structure #69", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400010070", new SnomedConcept("400010070", "CentralNervousSystemAnatomySnomed Anatomical Structure #70", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400010071", new SnomedConcept("400010071", "CentralNervousSystemAnatomySnomed Anatomical Structure #71", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400010072", new SnomedConcept("400010072", "CentralNervousSystemAnatomySnomed Anatomical Structure #72", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400010073", new SnomedConcept("400010073", "CentralNervousSystemAnatomySnomed Anatomical Structure #73", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400010074", new SnomedConcept("400010074", "CentralNervousSystemAnatomySnomed Anatomical Structure #74", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400010075", new SnomedConcept("400010075", "CentralNervousSystemAnatomySnomed Anatomical Structure #75", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400010076", new SnomedConcept("400010076", "CentralNervousSystemAnatomySnomed Anatomical Structure #76", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400010077", new SnomedConcept("400010077", "CentralNervousSystemAnatomySnomed Anatomical Structure #77", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400010078", new SnomedConcept("400010078", "CentralNervousSystemAnatomySnomed Anatomical Structure #78", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400010079", new SnomedConcept("400010079", "CentralNervousSystemAnatomySnomed Anatomical Structure #79", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400010080", new SnomedConcept("400010080", "CentralNervousSystemAnatomySnomed Anatomical Structure #80", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400010081", new SnomedConcept("400010081", "CentralNervousSystemAnatomySnomed Anatomical Structure #81", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400010082", new SnomedConcept("400010082", "CentralNervousSystemAnatomySnomed Anatomical Structure #82", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400010083", new SnomedConcept("400010083", "CentralNervousSystemAnatomySnomed Anatomical Structure #83", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400010084", new SnomedConcept("400010084", "CentralNervousSystemAnatomySnomed Anatomical Structure #84", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400010085", new SnomedConcept("400010085", "CentralNervousSystemAnatomySnomed Anatomical Structure #85", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400010086", new SnomedConcept("400010086", "CentralNervousSystemAnatomySnomed Anatomical Structure #86", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400010087", new SnomedConcept("400010087", "CentralNervousSystemAnatomySnomed Anatomical Structure #87", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400010088", new SnomedConcept("400010088", "CentralNervousSystemAnatomySnomed Anatomical Structure #88", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400010089", new SnomedConcept("400010089", "CentralNervousSystemAnatomySnomed Anatomical Structure #89", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400010090", new SnomedConcept("400010090", "CentralNervousSystemAnatomySnomed Anatomical Structure #90", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400010091", new SnomedConcept("400010091", "CentralNervousSystemAnatomySnomed Anatomical Structure #91", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400010092", new SnomedConcept("400010092", "CentralNervousSystemAnatomySnomed Anatomical Structure #92", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400010093", new SnomedConcept("400010093", "CentralNervousSystemAnatomySnomed Anatomical Structure #93", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400010094", new SnomedConcept("400010094", "CentralNervousSystemAnatomySnomed Anatomical Structure #94", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400010095", new SnomedConcept("400010095", "CentralNervousSystemAnatomySnomed Anatomical Structure #95", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400010096", new SnomedConcept("400010096", "CentralNervousSystemAnatomySnomed Anatomical Structure #96", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400010097", new SnomedConcept("400010097", "CentralNervousSystemAnatomySnomed Anatomical Structure #97", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400010098", new SnomedConcept("400010098", "CentralNervousSystemAnatomySnomed Anatomical Structure #98", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400010099", new SnomedConcept("400010099", "CentralNervousSystemAnatomySnomed Anatomical Structure #99", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400010100", new SnomedConcept("400010100", "CentralNervousSystemAnatomySnomed Anatomical Structure #100", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400010101", new SnomedConcept("400010101", "CentralNervousSystemAnatomySnomed Anatomical Structure #101", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400010102", new SnomedConcept("400010102", "CentralNervousSystemAnatomySnomed Anatomical Structure #102", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400010103", new SnomedConcept("400010103", "CentralNervousSystemAnatomySnomed Anatomical Structure #103", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400010104", new SnomedConcept("400010104", "CentralNervousSystemAnatomySnomed Anatomical Structure #104", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400010105", new SnomedConcept("400010105", "CentralNervousSystemAnatomySnomed Anatomical Structure #105", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400010106", new SnomedConcept("400010106", "CentralNervousSystemAnatomySnomed Anatomical Structure #106", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400010107", new SnomedConcept("400010107", "CentralNervousSystemAnatomySnomed Anatomical Structure #107", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400010108", new SnomedConcept("400010108", "CentralNervousSystemAnatomySnomed Anatomical Structure #108", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400010109", new SnomedConcept("400010109", "CentralNervousSystemAnatomySnomed Anatomical Structure #109", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400010110", new SnomedConcept("400010110", "CentralNervousSystemAnatomySnomed Anatomical Structure #110", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400010111", new SnomedConcept("400010111", "CentralNervousSystemAnatomySnomed Anatomical Structure #111", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400010112", new SnomedConcept("400010112", "CentralNervousSystemAnatomySnomed Anatomical Structure #112", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400010113", new SnomedConcept("400010113", "CentralNervousSystemAnatomySnomed Anatomical Structure #113", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400010114", new SnomedConcept("400010114", "CentralNervousSystemAnatomySnomed Anatomical Structure #114", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400010115", new SnomedConcept("400010115", "CentralNervousSystemAnatomySnomed Anatomical Structure #115", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400010116", new SnomedConcept("400010116", "CentralNervousSystemAnatomySnomed Anatomical Structure #116", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400010117", new SnomedConcept("400010117", "CentralNervousSystemAnatomySnomed Anatomical Structure #117", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400010118", new SnomedConcept("400010118", "CentralNervousSystemAnatomySnomed Anatomical Structure #118", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400010119", new SnomedConcept("400010119", "CentralNervousSystemAnatomySnomed Anatomical Structure #119", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400010120", new SnomedConcept("400010120", "CentralNervousSystemAnatomySnomed Anatomical Structure #120", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400010121", new SnomedConcept("400010121", "CentralNervousSystemAnatomySnomed Anatomical Structure #121", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400010122", new SnomedConcept("400010122", "CentralNervousSystemAnatomySnomed Anatomical Structure #122", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400010123", new SnomedConcept("400010123", "CentralNervousSystemAnatomySnomed Anatomical Structure #123", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400010124", new SnomedConcept("400010124", "CentralNervousSystemAnatomySnomed Anatomical Structure #124", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400010125", new SnomedConcept("400010125", "CentralNervousSystemAnatomySnomed Anatomical Structure #125", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400010126", new SnomedConcept("400010126", "CentralNervousSystemAnatomySnomed Anatomical Structure #126", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400010127", new SnomedConcept("400010127", "CentralNervousSystemAnatomySnomed Anatomical Structure #127", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400010128", new SnomedConcept("400010128", "CentralNervousSystemAnatomySnomed Anatomical Structure #128", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400010129", new SnomedConcept("400010129", "CentralNervousSystemAnatomySnomed Anatomical Structure #129", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400010130", new SnomedConcept("400010130", "CentralNervousSystemAnatomySnomed Anatomical Structure #130", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400010131", new SnomedConcept("400010131", "CentralNervousSystemAnatomySnomed Anatomical Structure #131", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400010132", new SnomedConcept("400010132", "CentralNervousSystemAnatomySnomed Anatomical Structure #132", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400010133", new SnomedConcept("400010133", "CentralNervousSystemAnatomySnomed Anatomical Structure #133", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400010134", new SnomedConcept("400010134", "CentralNervousSystemAnatomySnomed Anatomical Structure #134", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400010135", new SnomedConcept("400010135", "CentralNervousSystemAnatomySnomed Anatomical Structure #135", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400010136", new SnomedConcept("400010136", "CentralNervousSystemAnatomySnomed Anatomical Structure #136", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400010137", new SnomedConcept("400010137", "CentralNervousSystemAnatomySnomed Anatomical Structure #137", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400010138", new SnomedConcept("400010138", "CentralNervousSystemAnatomySnomed Anatomical Structure #138", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400010139", new SnomedConcept("400010139", "CentralNervousSystemAnatomySnomed Anatomical Structure #139", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400010140", new SnomedConcept("400010140", "CentralNervousSystemAnatomySnomed Anatomical Structure #140", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400010141", new SnomedConcept("400010141", "CentralNervousSystemAnatomySnomed Anatomical Structure #141", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400010142", new SnomedConcept("400010142", "CentralNervousSystemAnatomySnomed Anatomical Structure #142", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400010143", new SnomedConcept("400010143", "CentralNervousSystemAnatomySnomed Anatomical Structure #143", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400010144", new SnomedConcept("400010144", "CentralNervousSystemAnatomySnomed Anatomical Structure #144", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400010145", new SnomedConcept("400010145", "CentralNervousSystemAnatomySnomed Anatomical Structure #145", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400010146", new SnomedConcept("400010146", "CentralNervousSystemAnatomySnomed Anatomical Structure #146", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400010147", new SnomedConcept("400010147", "CentralNervousSystemAnatomySnomed Anatomical Structure #147", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400010148", new SnomedConcept("400010148", "CentralNervousSystemAnatomySnomed Anatomical Structure #148", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400010149", new SnomedConcept("400010149", "CentralNervousSystemAnatomySnomed Anatomical Structure #149", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400010150", new SnomedConcept("400010150", "CentralNervousSystemAnatomySnomed Anatomical Structure #150", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
    }

    public Optional<SnomedConcept> findById(String id) {
        return Optional.ofNullable(concepts.get(id));
    }

    public List<SnomedConcept> getAllConcepts() {
        return new ArrayList<>(concepts.values());
    }
}
