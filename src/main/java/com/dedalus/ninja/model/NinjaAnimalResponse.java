package com.dedalus.ninja.model;

import lombok.Data;

import javax.json.bind.annotation.JsonbProperty;
import java.util.List;

@Data
public class NinjaAnimalResponse {
    private String name;
    private Taxonomy taxonomy;
    private List<String> locations;
    private Characteristics characteristics;

    @Data
    public static class Characteristics {
        private String slogan;
        private String weight;
        private String height;
        private String length;
    }

    @Data
    public static class Taxonomy {
        private String kingdom;
        private String phylum;
        private String order;
        private String family;
        private String genus;
        @JsonbProperty("scientific_name")
        private String scientificName;
    }
}
