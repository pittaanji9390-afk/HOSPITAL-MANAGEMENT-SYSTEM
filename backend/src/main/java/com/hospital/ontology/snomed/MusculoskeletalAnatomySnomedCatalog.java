package com.hospital.ontology.snomed;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class MusculoskeletalAnatomySnomedCatalog {

    @Data
    @AllArgsConstructor
    public static class SnomedConcept {
        private String conceptId;
        private String fullySpecifiedName;
        private String hierarchyDomain;
        private String anatomicalSubdivision;
    }

    private final Map<String, SnomedConcept> concepts = new LinkedHashMap<>();

    public MusculoskeletalAnatomySnomedCatalog() {
        initializeConcepts();
    }

    private void initializeConcepts() {
        concepts.put("400040001", new SnomedConcept("400040001", "MusculoskeletalAnatomySnomed Anatomical Structure #1", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400040002", new SnomedConcept("400040002", "MusculoskeletalAnatomySnomed Anatomical Structure #2", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400040003", new SnomedConcept("400040003", "MusculoskeletalAnatomySnomed Anatomical Structure #3", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400040004", new SnomedConcept("400040004", "MusculoskeletalAnatomySnomed Anatomical Structure #4", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400040005", new SnomedConcept("400040005", "MusculoskeletalAnatomySnomed Anatomical Structure #5", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400040006", new SnomedConcept("400040006", "MusculoskeletalAnatomySnomed Anatomical Structure #6", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400040007", new SnomedConcept("400040007", "MusculoskeletalAnatomySnomed Anatomical Structure #7", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400040008", new SnomedConcept("400040008", "MusculoskeletalAnatomySnomed Anatomical Structure #8", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400040009", new SnomedConcept("400040009", "MusculoskeletalAnatomySnomed Anatomical Structure #9", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400040010", new SnomedConcept("400040010", "MusculoskeletalAnatomySnomed Anatomical Structure #10", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400040011", new SnomedConcept("400040011", "MusculoskeletalAnatomySnomed Anatomical Structure #11", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400040012", new SnomedConcept("400040012", "MusculoskeletalAnatomySnomed Anatomical Structure #12", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400040013", new SnomedConcept("400040013", "MusculoskeletalAnatomySnomed Anatomical Structure #13", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400040014", new SnomedConcept("400040014", "MusculoskeletalAnatomySnomed Anatomical Structure #14", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400040015", new SnomedConcept("400040015", "MusculoskeletalAnatomySnomed Anatomical Structure #15", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400040016", new SnomedConcept("400040016", "MusculoskeletalAnatomySnomed Anatomical Structure #16", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400040017", new SnomedConcept("400040017", "MusculoskeletalAnatomySnomed Anatomical Structure #17", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400040018", new SnomedConcept("400040018", "MusculoskeletalAnatomySnomed Anatomical Structure #18", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400040019", new SnomedConcept("400040019", "MusculoskeletalAnatomySnomed Anatomical Structure #19", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400040020", new SnomedConcept("400040020", "MusculoskeletalAnatomySnomed Anatomical Structure #20", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400040021", new SnomedConcept("400040021", "MusculoskeletalAnatomySnomed Anatomical Structure #21", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400040022", new SnomedConcept("400040022", "MusculoskeletalAnatomySnomed Anatomical Structure #22", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400040023", new SnomedConcept("400040023", "MusculoskeletalAnatomySnomed Anatomical Structure #23", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400040024", new SnomedConcept("400040024", "MusculoskeletalAnatomySnomed Anatomical Structure #24", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400040025", new SnomedConcept("400040025", "MusculoskeletalAnatomySnomed Anatomical Structure #25", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400040026", new SnomedConcept("400040026", "MusculoskeletalAnatomySnomed Anatomical Structure #26", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400040027", new SnomedConcept("400040027", "MusculoskeletalAnatomySnomed Anatomical Structure #27", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400040028", new SnomedConcept("400040028", "MusculoskeletalAnatomySnomed Anatomical Structure #28", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400040029", new SnomedConcept("400040029", "MusculoskeletalAnatomySnomed Anatomical Structure #29", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400040030", new SnomedConcept("400040030", "MusculoskeletalAnatomySnomed Anatomical Structure #30", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400040031", new SnomedConcept("400040031", "MusculoskeletalAnatomySnomed Anatomical Structure #31", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400040032", new SnomedConcept("400040032", "MusculoskeletalAnatomySnomed Anatomical Structure #32", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400040033", new SnomedConcept("400040033", "MusculoskeletalAnatomySnomed Anatomical Structure #33", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400040034", new SnomedConcept("400040034", "MusculoskeletalAnatomySnomed Anatomical Structure #34", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400040035", new SnomedConcept("400040035", "MusculoskeletalAnatomySnomed Anatomical Structure #35", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400040036", new SnomedConcept("400040036", "MusculoskeletalAnatomySnomed Anatomical Structure #36", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400040037", new SnomedConcept("400040037", "MusculoskeletalAnatomySnomed Anatomical Structure #37", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400040038", new SnomedConcept("400040038", "MusculoskeletalAnatomySnomed Anatomical Structure #38", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400040039", new SnomedConcept("400040039", "MusculoskeletalAnatomySnomed Anatomical Structure #39", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400040040", new SnomedConcept("400040040", "MusculoskeletalAnatomySnomed Anatomical Structure #40", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400040041", new SnomedConcept("400040041", "MusculoskeletalAnatomySnomed Anatomical Structure #41", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400040042", new SnomedConcept("400040042", "MusculoskeletalAnatomySnomed Anatomical Structure #42", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400040043", new SnomedConcept("400040043", "MusculoskeletalAnatomySnomed Anatomical Structure #43", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400040044", new SnomedConcept("400040044", "MusculoskeletalAnatomySnomed Anatomical Structure #44", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400040045", new SnomedConcept("400040045", "MusculoskeletalAnatomySnomed Anatomical Structure #45", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400040046", new SnomedConcept("400040046", "MusculoskeletalAnatomySnomed Anatomical Structure #46", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400040047", new SnomedConcept("400040047", "MusculoskeletalAnatomySnomed Anatomical Structure #47", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400040048", new SnomedConcept("400040048", "MusculoskeletalAnatomySnomed Anatomical Structure #48", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400040049", new SnomedConcept("400040049", "MusculoskeletalAnatomySnomed Anatomical Structure #49", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400040050", new SnomedConcept("400040050", "MusculoskeletalAnatomySnomed Anatomical Structure #50", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400040051", new SnomedConcept("400040051", "MusculoskeletalAnatomySnomed Anatomical Structure #51", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400040052", new SnomedConcept("400040052", "MusculoskeletalAnatomySnomed Anatomical Structure #52", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400040053", new SnomedConcept("400040053", "MusculoskeletalAnatomySnomed Anatomical Structure #53", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400040054", new SnomedConcept("400040054", "MusculoskeletalAnatomySnomed Anatomical Structure #54", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400040055", new SnomedConcept("400040055", "MusculoskeletalAnatomySnomed Anatomical Structure #55", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400040056", new SnomedConcept("400040056", "MusculoskeletalAnatomySnomed Anatomical Structure #56", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400040057", new SnomedConcept("400040057", "MusculoskeletalAnatomySnomed Anatomical Structure #57", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400040058", new SnomedConcept("400040058", "MusculoskeletalAnatomySnomed Anatomical Structure #58", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400040059", new SnomedConcept("400040059", "MusculoskeletalAnatomySnomed Anatomical Structure #59", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400040060", new SnomedConcept("400040060", "MusculoskeletalAnatomySnomed Anatomical Structure #60", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400040061", new SnomedConcept("400040061", "MusculoskeletalAnatomySnomed Anatomical Structure #61", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400040062", new SnomedConcept("400040062", "MusculoskeletalAnatomySnomed Anatomical Structure #62", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400040063", new SnomedConcept("400040063", "MusculoskeletalAnatomySnomed Anatomical Structure #63", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400040064", new SnomedConcept("400040064", "MusculoskeletalAnatomySnomed Anatomical Structure #64", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400040065", new SnomedConcept("400040065", "MusculoskeletalAnatomySnomed Anatomical Structure #65", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400040066", new SnomedConcept("400040066", "MusculoskeletalAnatomySnomed Anatomical Structure #66", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400040067", new SnomedConcept("400040067", "MusculoskeletalAnatomySnomed Anatomical Structure #67", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400040068", new SnomedConcept("400040068", "MusculoskeletalAnatomySnomed Anatomical Structure #68", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400040069", new SnomedConcept("400040069", "MusculoskeletalAnatomySnomed Anatomical Structure #69", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400040070", new SnomedConcept("400040070", "MusculoskeletalAnatomySnomed Anatomical Structure #70", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400040071", new SnomedConcept("400040071", "MusculoskeletalAnatomySnomed Anatomical Structure #71", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400040072", new SnomedConcept("400040072", "MusculoskeletalAnatomySnomed Anatomical Structure #72", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400040073", new SnomedConcept("400040073", "MusculoskeletalAnatomySnomed Anatomical Structure #73", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400040074", new SnomedConcept("400040074", "MusculoskeletalAnatomySnomed Anatomical Structure #74", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400040075", new SnomedConcept("400040075", "MusculoskeletalAnatomySnomed Anatomical Structure #75", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400040076", new SnomedConcept("400040076", "MusculoskeletalAnatomySnomed Anatomical Structure #76", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400040077", new SnomedConcept("400040077", "MusculoskeletalAnatomySnomed Anatomical Structure #77", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400040078", new SnomedConcept("400040078", "MusculoskeletalAnatomySnomed Anatomical Structure #78", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400040079", new SnomedConcept("400040079", "MusculoskeletalAnatomySnomed Anatomical Structure #79", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400040080", new SnomedConcept("400040080", "MusculoskeletalAnatomySnomed Anatomical Structure #80", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400040081", new SnomedConcept("400040081", "MusculoskeletalAnatomySnomed Anatomical Structure #81", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400040082", new SnomedConcept("400040082", "MusculoskeletalAnatomySnomed Anatomical Structure #82", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400040083", new SnomedConcept("400040083", "MusculoskeletalAnatomySnomed Anatomical Structure #83", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400040084", new SnomedConcept("400040084", "MusculoskeletalAnatomySnomed Anatomical Structure #84", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400040085", new SnomedConcept("400040085", "MusculoskeletalAnatomySnomed Anatomical Structure #85", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400040086", new SnomedConcept("400040086", "MusculoskeletalAnatomySnomed Anatomical Structure #86", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400040087", new SnomedConcept("400040087", "MusculoskeletalAnatomySnomed Anatomical Structure #87", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400040088", new SnomedConcept("400040088", "MusculoskeletalAnatomySnomed Anatomical Structure #88", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400040089", new SnomedConcept("400040089", "MusculoskeletalAnatomySnomed Anatomical Structure #89", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400040090", new SnomedConcept("400040090", "MusculoskeletalAnatomySnomed Anatomical Structure #90", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400040091", new SnomedConcept("400040091", "MusculoskeletalAnatomySnomed Anatomical Structure #91", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400040092", new SnomedConcept("400040092", "MusculoskeletalAnatomySnomed Anatomical Structure #92", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400040093", new SnomedConcept("400040093", "MusculoskeletalAnatomySnomed Anatomical Structure #93", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400040094", new SnomedConcept("400040094", "MusculoskeletalAnatomySnomed Anatomical Structure #94", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400040095", new SnomedConcept("400040095", "MusculoskeletalAnatomySnomed Anatomical Structure #95", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400040096", new SnomedConcept("400040096", "MusculoskeletalAnatomySnomed Anatomical Structure #96", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400040097", new SnomedConcept("400040097", "MusculoskeletalAnatomySnomed Anatomical Structure #97", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400040098", new SnomedConcept("400040098", "MusculoskeletalAnatomySnomed Anatomical Structure #98", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400040099", new SnomedConcept("400040099", "MusculoskeletalAnatomySnomed Anatomical Structure #99", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400040100", new SnomedConcept("400040100", "MusculoskeletalAnatomySnomed Anatomical Structure #100", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400040101", new SnomedConcept("400040101", "MusculoskeletalAnatomySnomed Anatomical Structure #101", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400040102", new SnomedConcept("400040102", "MusculoskeletalAnatomySnomed Anatomical Structure #102", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400040103", new SnomedConcept("400040103", "MusculoskeletalAnatomySnomed Anatomical Structure #103", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400040104", new SnomedConcept("400040104", "MusculoskeletalAnatomySnomed Anatomical Structure #104", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400040105", new SnomedConcept("400040105", "MusculoskeletalAnatomySnomed Anatomical Structure #105", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400040106", new SnomedConcept("400040106", "MusculoskeletalAnatomySnomed Anatomical Structure #106", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400040107", new SnomedConcept("400040107", "MusculoskeletalAnatomySnomed Anatomical Structure #107", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400040108", new SnomedConcept("400040108", "MusculoskeletalAnatomySnomed Anatomical Structure #108", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400040109", new SnomedConcept("400040109", "MusculoskeletalAnatomySnomed Anatomical Structure #109", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400040110", new SnomedConcept("400040110", "MusculoskeletalAnatomySnomed Anatomical Structure #110", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400040111", new SnomedConcept("400040111", "MusculoskeletalAnatomySnomed Anatomical Structure #111", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400040112", new SnomedConcept("400040112", "MusculoskeletalAnatomySnomed Anatomical Structure #112", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400040113", new SnomedConcept("400040113", "MusculoskeletalAnatomySnomed Anatomical Structure #113", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400040114", new SnomedConcept("400040114", "MusculoskeletalAnatomySnomed Anatomical Structure #114", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400040115", new SnomedConcept("400040115", "MusculoskeletalAnatomySnomed Anatomical Structure #115", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400040116", new SnomedConcept("400040116", "MusculoskeletalAnatomySnomed Anatomical Structure #116", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400040117", new SnomedConcept("400040117", "MusculoskeletalAnatomySnomed Anatomical Structure #117", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400040118", new SnomedConcept("400040118", "MusculoskeletalAnatomySnomed Anatomical Structure #118", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400040119", new SnomedConcept("400040119", "MusculoskeletalAnatomySnomed Anatomical Structure #119", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400040120", new SnomedConcept("400040120", "MusculoskeletalAnatomySnomed Anatomical Structure #120", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400040121", new SnomedConcept("400040121", "MusculoskeletalAnatomySnomed Anatomical Structure #121", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400040122", new SnomedConcept("400040122", "MusculoskeletalAnatomySnomed Anatomical Structure #122", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400040123", new SnomedConcept("400040123", "MusculoskeletalAnatomySnomed Anatomical Structure #123", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400040124", new SnomedConcept("400040124", "MusculoskeletalAnatomySnomed Anatomical Structure #124", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400040125", new SnomedConcept("400040125", "MusculoskeletalAnatomySnomed Anatomical Structure #125", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400040126", new SnomedConcept("400040126", "MusculoskeletalAnatomySnomed Anatomical Structure #126", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400040127", new SnomedConcept("400040127", "MusculoskeletalAnatomySnomed Anatomical Structure #127", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400040128", new SnomedConcept("400040128", "MusculoskeletalAnatomySnomed Anatomical Structure #128", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400040129", new SnomedConcept("400040129", "MusculoskeletalAnatomySnomed Anatomical Structure #129", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400040130", new SnomedConcept("400040130", "MusculoskeletalAnatomySnomed Anatomical Structure #130", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400040131", new SnomedConcept("400040131", "MusculoskeletalAnatomySnomed Anatomical Structure #131", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400040132", new SnomedConcept("400040132", "MusculoskeletalAnatomySnomed Anatomical Structure #132", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400040133", new SnomedConcept("400040133", "MusculoskeletalAnatomySnomed Anatomical Structure #133", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400040134", new SnomedConcept("400040134", "MusculoskeletalAnatomySnomed Anatomical Structure #134", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400040135", new SnomedConcept("400040135", "MusculoskeletalAnatomySnomed Anatomical Structure #135", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400040136", new SnomedConcept("400040136", "MusculoskeletalAnatomySnomed Anatomical Structure #136", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400040137", new SnomedConcept("400040137", "MusculoskeletalAnatomySnomed Anatomical Structure #137", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400040138", new SnomedConcept("400040138", "MusculoskeletalAnatomySnomed Anatomical Structure #138", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400040139", new SnomedConcept("400040139", "MusculoskeletalAnatomySnomed Anatomical Structure #139", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400040140", new SnomedConcept("400040140", "MusculoskeletalAnatomySnomed Anatomical Structure #140", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400040141", new SnomedConcept("400040141", "MusculoskeletalAnatomySnomed Anatomical Structure #141", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400040142", new SnomedConcept("400040142", "MusculoskeletalAnatomySnomed Anatomical Structure #142", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400040143", new SnomedConcept("400040143", "MusculoskeletalAnatomySnomed Anatomical Structure #143", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400040144", new SnomedConcept("400040144", "MusculoskeletalAnatomySnomed Anatomical Structure #144", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400040145", new SnomedConcept("400040145", "MusculoskeletalAnatomySnomed Anatomical Structure #145", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400040146", new SnomedConcept("400040146", "MusculoskeletalAnatomySnomed Anatomical Structure #146", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
        concepts.put("400040147", new SnomedConcept("400040147", "MusculoskeletalAnatomySnomed Anatomical Structure #147", "BODY_STRUCTURE", "Lateral / Medial Segment 4"));
        concepts.put("400040148", new SnomedConcept("400040148", "MusculoskeletalAnatomySnomed Anatomical Structure #148", "BODY_STRUCTURE", "Lateral / Medial Segment 1"));
        concepts.put("400040149", new SnomedConcept("400040149", "MusculoskeletalAnatomySnomed Anatomical Structure #149", "BODY_STRUCTURE", "Lateral / Medial Segment 2"));
        concepts.put("400040150", new SnomedConcept("400040150", "MusculoskeletalAnatomySnomed Anatomical Structure #150", "BODY_STRUCTURE", "Lateral / Medial Segment 3"));
    }

    public Optional<SnomedConcept> findById(String id) {
        return Optional.ofNullable(concepts.get(id));
    }

    public List<SnomedConcept> getAllConcepts() {
        return new ArrayList<>(concepts.values());
    }
}
