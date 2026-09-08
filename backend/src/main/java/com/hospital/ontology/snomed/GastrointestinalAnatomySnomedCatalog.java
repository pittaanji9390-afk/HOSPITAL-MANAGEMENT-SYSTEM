package com.hospital.ontology.snomed;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class GastrointestinalAnatomySnomedCatalog {

    @Data
    @AllArgsConstructor
    public static class SnomedConcept {
        private String conceptId;
        private String fullySpecifiedName;
        private String hierarchyDomain;
        private String anatomicalSubdivision;
    }

    private final Map<String, SnomedConcept> concepts = new LinkedHashMap<>();

    public GastrointestinalAnatomySnomedCatalog() {
        initializeConcepts();
    }

    private void initializeConcepts() {
        concepts.put("400030001", new SnomedConcept("400030001", "GastrointestinalAnatomySnomed Anatomical Structure #1", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400030002", new SnomedConcept("400030002", "GastrointestinalAnatomySnomed Anatomical Structure #2", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400030003", new SnomedConcept("400030003", "GastrointestinalAnatomySnomed Anatomical Structure #3", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400030004", new SnomedConcept("400030004", "GastrointestinalAnatomySnomed Anatomical Structure #4", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400030005", new SnomedConcept("400030005", "GastrointestinalAnatomySnomed Anatomical Structure #5", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400030006", new SnomedConcept("400030006", "GastrointestinalAnatomySnomed Anatomical Structure #6", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400030007", new SnomedConcept("400030007", "GastrointestinalAnatomySnomed Anatomical Structure #7", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400030008", new SnomedConcept("400030008", "GastrointestinalAnatomySnomed Anatomical Structure #8", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400030009", new SnomedConcept("400030009", "GastrointestinalAnatomySnomed Anatomical Structure #9", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400030010", new SnomedConcept("400030010", "GastrointestinalAnatomySnomed Anatomical Structure #10", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400030011", new SnomedConcept("400030011", "GastrointestinalAnatomySnomed Anatomical Structure #11", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400030012", new SnomedConcept("400030012", "GastrointestinalAnatomySnomed Anatomical Structure #12", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400030013", new SnomedConcept("400030013", "GastrointestinalAnatomySnomed Anatomical Structure #13", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400030014", new SnomedConcept("400030014", "GastrointestinalAnatomySnomed Anatomical Structure #14", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400030015", new SnomedConcept("400030015", "GastrointestinalAnatomySnomed Anatomical Structure #15", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400030016", new SnomedConcept("400030016", "GastrointestinalAnatomySnomed Anatomical Structure #16", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400030017", new SnomedConcept("400030017", "GastrointestinalAnatomySnomed Anatomical Structure #17", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400030018", new SnomedConcept("400030018", "GastrointestinalAnatomySnomed Anatomical Structure #18", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400030019", new SnomedConcept("400030019", "GastrointestinalAnatomySnomed Anatomical Structure #19", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400030020", new SnomedConcept("400030020", "GastrointestinalAnatomySnomed Anatomical Structure #20", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400030021", new SnomedConcept("400030021", "GastrointestinalAnatomySnomed Anatomical Structure #21", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400030022", new SnomedConcept("400030022", "GastrointestinalAnatomySnomed Anatomical Structure #22", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400030023", new SnomedConcept("400030023", "GastrointestinalAnatomySnomed Anatomical Structure #23", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400030024", new SnomedConcept("400030024", "GastrointestinalAnatomySnomed Anatomical Structure #24", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400030025", new SnomedConcept("400030025", "GastrointestinalAnatomySnomed Anatomical Structure #25", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400030026", new SnomedConcept("400030026", "GastrointestinalAnatomySnomed Anatomical Structure #26", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400030027", new SnomedConcept("400030027", "GastrointestinalAnatomySnomed Anatomical Structure #27", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400030028", new SnomedConcept("400030028", "GastrointestinalAnatomySnomed Anatomical Structure #28", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400030029", new SnomedConcept("400030029", "GastrointestinalAnatomySnomed Anatomical Structure #29", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400030030", new SnomedConcept("400030030", "GastrointestinalAnatomySnomed Anatomical Structure #30", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400030031", new SnomedConcept("400030031", "GastrointestinalAnatomySnomed Anatomical Structure #31", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400030032", new SnomedConcept("400030032", "GastrointestinalAnatomySnomed Anatomical Structure #32", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400030033", new SnomedConcept("400030033", "GastrointestinalAnatomySnomed Anatomical Structure #33", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400030034", new SnomedConcept("400030034", "GastrointestinalAnatomySnomed Anatomical Structure #34", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400030035", new SnomedConcept("400030035", "GastrointestinalAnatomySnomed Anatomical Structure #35", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400030036", new SnomedConcept("400030036", "GastrointestinalAnatomySnomed Anatomical Structure #36", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400030037", new SnomedConcept("400030037", "GastrointestinalAnatomySnomed Anatomical Structure #37", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400030038", new SnomedConcept("400030038", "GastrointestinalAnatomySnomed Anatomical Structure #38", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400030039", new SnomedConcept("400030039", "GastrointestinalAnatomySnomed Anatomical Structure #39", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400030040", new SnomedConcept("400030040", "GastrointestinalAnatomySnomed Anatomical Structure #40", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400030041", new SnomedConcept("400030041", "GastrointestinalAnatomySnomed Anatomical Structure #41", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400030042", new SnomedConcept("400030042", "GastrointestinalAnatomySnomed Anatomical Structure #42", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400030043", new SnomedConcept("400030043", "GastrointestinalAnatomySnomed Anatomical Structure #43", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400030044", new SnomedConcept("400030044", "GastrointestinalAnatomySnomed Anatomical Structure #44", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400030045", new SnomedConcept("400030045", "GastrointestinalAnatomySnomed Anatomical Structure #45", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400030046", new SnomedConcept("400030046", "GastrointestinalAnatomySnomed Anatomical Structure #46", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400030047", new SnomedConcept("400030047", "GastrointestinalAnatomySnomed Anatomical Structure #47", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400030048", new SnomedConcept("400030048", "GastrointestinalAnatomySnomed Anatomical Structure #48", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400030049", new SnomedConcept("400030049", "GastrointestinalAnatomySnomed Anatomical Structure #49", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400030050", new SnomedConcept("400030050", "GastrointestinalAnatomySnomed Anatomical Structure #50", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400030051", new SnomedConcept("400030051", "GastrointestinalAnatomySnomed Anatomical Structure #51", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400030052", new SnomedConcept("400030052", "GastrointestinalAnatomySnomed Anatomical Structure #52", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400030053", new SnomedConcept("400030053", "GastrointestinalAnatomySnomed Anatomical Structure #53", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400030054", new SnomedConcept("400030054", "GastrointestinalAnatomySnomed Anatomical Structure #54", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400030055", new SnomedConcept("400030055", "GastrointestinalAnatomySnomed Anatomical Structure #55", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400030056", new SnomedConcept("400030056", "GastrointestinalAnatomySnomed Anatomical Structure #56", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400030057", new SnomedConcept("400030057", "GastrointestinalAnatomySnomed Anatomical Structure #57", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400030058", new SnomedConcept("400030058", "GastrointestinalAnatomySnomed Anatomical Structure #58", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400030059", new SnomedConcept("400030059", "GastrointestinalAnatomySnomed Anatomical Structure #59", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400030060", new SnomedConcept("400030060", "GastrointestinalAnatomySnomed Anatomical Structure #60", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400030061", new SnomedConcept("400030061", "GastrointestinalAnatomySnomed Anatomical Structure #61", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400030062", new SnomedConcept("400030062", "GastrointestinalAnatomySnomed Anatomical Structure #62", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400030063", new SnomedConcept("400030063", "GastrointestinalAnatomySnomed Anatomical Structure #63", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400030064", new SnomedConcept("400030064", "GastrointestinalAnatomySnomed Anatomical Structure #64", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400030065", new SnomedConcept("400030065", "GastrointestinalAnatomySnomed Anatomical Structure #65", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400030066", new SnomedConcept("400030066", "GastrointestinalAnatomySnomed Anatomical Structure #66", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400030067", new SnomedConcept("400030067", "GastrointestinalAnatomySnomed Anatomical Structure #67", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400030068", new SnomedConcept("400030068", "GastrointestinalAnatomySnomed Anatomical Structure #68", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400030069", new SnomedConcept("400030069", "GastrointestinalAnatomySnomed Anatomical Structure #69", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400030070", new SnomedConcept("400030070", "GastrointestinalAnatomySnomed Anatomical Structure #70", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400030071", new SnomedConcept("400030071", "GastrointestinalAnatomySnomed Anatomical Structure #71", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400030072", new SnomedConcept("400030072", "GastrointestinalAnatomySnomed Anatomical Structure #72", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400030073", new SnomedConcept("400030073", "GastrointestinalAnatomySnomed Anatomical Structure #73", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400030074", new SnomedConcept("400030074", "GastrointestinalAnatomySnomed Anatomical Structure #74", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400030075", new SnomedConcept("400030075", "GastrointestinalAnatomySnomed Anatomical Structure #75", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400030076", new SnomedConcept("400030076", "GastrointestinalAnatomySnomed Anatomical Structure #76", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400030077", new SnomedConcept("400030077", "GastrointestinalAnatomySnomed Anatomical Structure #77", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400030078", new SnomedConcept("400030078", "GastrointestinalAnatomySnomed Anatomical Structure #78", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400030079", new SnomedConcept("400030079", "GastrointestinalAnatomySnomed Anatomical Structure #79", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400030080", new SnomedConcept("400030080", "GastrointestinalAnatomySnomed Anatomical Structure #80", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400030081", new SnomedConcept("400030081", "GastrointestinalAnatomySnomed Anatomical Structure #81", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400030082", new SnomedConcept("400030082", "GastrointestinalAnatomySnomed Anatomical Structure #82", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400030083", new SnomedConcept("400030083", "GastrointestinalAnatomySnomed Anatomical Structure #83", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400030084", new SnomedConcept("400030084", "GastrointestinalAnatomySnomed Anatomical Structure #84", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400030085", new SnomedConcept("400030085", "GastrointestinalAnatomySnomed Anatomical Structure #85", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400030086", new SnomedConcept("400030086", "GastrointestinalAnatomySnomed Anatomical Structure #86", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400030087", new SnomedConcept("400030087", "GastrointestinalAnatomySnomed Anatomical Structure #87", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400030088", new SnomedConcept("400030088", "GastrointestinalAnatomySnomed Anatomical Structure #88", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400030089", new SnomedConcept("400030089", "GastrointestinalAnatomySnomed Anatomical Structure #89", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400030090", new SnomedConcept("400030090", "GastrointestinalAnatomySnomed Anatomical Structure #90", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400030091", new SnomedConcept("400030091", "GastrointestinalAnatomySnomed Anatomical Structure #91", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400030092", new SnomedConcept("400030092", "GastrointestinalAnatomySnomed Anatomical Structure #92", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400030093", new SnomedConcept("400030093", "GastrointestinalAnatomySnomed Anatomical Structure #93", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400030094", new SnomedConcept("400030094", "GastrointestinalAnatomySnomed Anatomical Structure #94", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400030095", new SnomedConcept("400030095", "GastrointestinalAnatomySnomed Anatomical Structure #95", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400030096", new SnomedConcept("400030096", "GastrointestinalAnatomySnomed Anatomical Structure #96", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400030097", new SnomedConcept("400030097", "GastrointestinalAnatomySnomed Anatomical Structure #97", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400030098", new SnomedConcept("400030098", "GastrointestinalAnatomySnomed Anatomical Structure #98", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400030099", new SnomedConcept("400030099", "GastrointestinalAnatomySnomed Anatomical Structure #99", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400030100", new SnomedConcept("400030100", "GastrointestinalAnatomySnomed Anatomical Structure #100", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400030101", new SnomedConcept("400030101", "GastrointestinalAnatomySnomed Anatomical Structure #101", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400030102", new SnomedConcept("400030102", "GastrointestinalAnatomySnomed Anatomical Structure #102", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400030103", new SnomedConcept("400030103", "GastrointestinalAnatomySnomed Anatomical Structure #103", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400030104", new SnomedConcept("400030104", "GastrointestinalAnatomySnomed Anatomical Structure #104", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400030105", new SnomedConcept("400030105", "GastrointestinalAnatomySnomed Anatomical Structure #105", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400030106", new SnomedConcept("400030106", "GastrointestinalAnatomySnomed Anatomical Structure #106", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400030107", new SnomedConcept("400030107", "GastrointestinalAnatomySnomed Anatomical Structure #107", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400030108", new SnomedConcept("400030108", "GastrointestinalAnatomySnomed Anatomical Structure #108", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400030109", new SnomedConcept("400030109", "GastrointestinalAnatomySnomed Anatomical Structure #109", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400030110", new SnomedConcept("400030110", "GastrointestinalAnatomySnomed Anatomical Structure #110", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400030111", new SnomedConcept("400030111", "GastrointestinalAnatomySnomed Anatomical Structure #111", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400030112", new SnomedConcept("400030112", "GastrointestinalAnatomySnomed Anatomical Structure #112", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400030113", new SnomedConcept("400030113", "GastrointestinalAnatomySnomed Anatomical Structure #113", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400030114", new SnomedConcept("400030114", "GastrointestinalAnatomySnomed Anatomical Structure #114", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400030115", new SnomedConcept("400030115", "GastrointestinalAnatomySnomed Anatomical Structure #115", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400030116", new SnomedConcept("400030116", "GastrointestinalAnatomySnomed Anatomical Structure #116", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400030117", new SnomedConcept("400030117", "GastrointestinalAnatomySnomed Anatomical Structure #117", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400030118", new SnomedConcept("400030118", "GastrointestinalAnatomySnomed Anatomical Structure #118", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400030119", new SnomedConcept("400030119", "GastrointestinalAnatomySnomed Anatomical Structure #119", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400030120", new SnomedConcept("400030120", "GastrointestinalAnatomySnomed Anatomical Structure #120", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400030121", new SnomedConcept("400030121", "GastrointestinalAnatomySnomed Anatomical Structure #121", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400030122", new SnomedConcept("400030122", "GastrointestinalAnatomySnomed Anatomical Structure #122", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400030123", new SnomedConcept("400030123", "GastrointestinalAnatomySnomed Anatomical Structure #123", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400030124", new SnomedConcept("400030124", "GastrointestinalAnatomySnomed Anatomical Structure #124", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400030125", new SnomedConcept("400030125", "GastrointestinalAnatomySnomed Anatomical Structure #125", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400030126", new SnomedConcept("400030126", "GastrointestinalAnatomySnomed Anatomical Structure #126", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400030127", new SnomedConcept("400030127", "GastrointestinalAnatomySnomed Anatomical Structure #127", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400030128", new SnomedConcept("400030128", "GastrointestinalAnatomySnomed Anatomical Structure #128", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400030129", new SnomedConcept("400030129", "GastrointestinalAnatomySnomed Anatomical Structure #129", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400030130", new SnomedConcept("400030130", "GastrointestinalAnatomySnomed Anatomical Structure #130", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400030131", new SnomedConcept("400030131", "GastrointestinalAnatomySnomed Anatomical Structure #131", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400030132", new SnomedConcept("400030132", "GastrointestinalAnatomySnomed Anatomical Structure #132", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400030133", new SnomedConcept("400030133", "GastrointestinalAnatomySnomed Anatomical Structure #133", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400030134", new SnomedConcept("400030134", "GastrointestinalAnatomySnomed Anatomical Structure #134", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400030135", new SnomedConcept("400030135", "GastrointestinalAnatomySnomed Anatomical Structure #135", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400030136", new SnomedConcept("400030136", "GastrointestinalAnatomySnomed Anatomical Structure #136", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400030137", new SnomedConcept("400030137", "GastrointestinalAnatomySnomed Anatomical Structure #137", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400030138", new SnomedConcept("400030138", "GastrointestinalAnatomySnomed Anatomical Structure #138", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400030139", new SnomedConcept("400030139", "GastrointestinalAnatomySnomed Anatomical Structure #139", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400030140", new SnomedConcept("400030140", "GastrointestinalAnatomySnomed Anatomical Structure #140", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400030141", new SnomedConcept("400030141", "GastrointestinalAnatomySnomed Anatomical Structure #141", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400030142", new SnomedConcept("400030142", "GastrointestinalAnatomySnomed Anatomical Structure #142", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400030143", new SnomedConcept("400030143", "GastrointestinalAnatomySnomed Anatomical Structure #143", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400030144", new SnomedConcept("400030144", "GastrointestinalAnatomySnomed Anatomical Structure #144", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400030145", new SnomedConcept("400030145", "GastrointestinalAnatomySnomed Anatomical Structure #145", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400030146", new SnomedConcept("400030146", "GastrointestinalAnatomySnomed Anatomical Structure #146", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400030147", new SnomedConcept("400030147", "GastrointestinalAnatomySnomed Anatomical Structure #147", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400030148", new SnomedConcept("400030148", "GastrointestinalAnatomySnomed Anatomical Structure #148", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400030149", new SnomedConcept("400030149", "GastrointestinalAnatomySnomed Anatomical Structure #149", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400030150", new SnomedConcept("400030150", "GastrointestinalAnatomySnomed Anatomical Structure #150", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
    }

    public Optional<SnomedConcept> findById(String id) {
        return Optional.ofNullable(concepts.get(id));
    }

    public List<SnomedConcept> getAllConcepts() {
        return new ArrayList<>(concepts.values());
    }
}
