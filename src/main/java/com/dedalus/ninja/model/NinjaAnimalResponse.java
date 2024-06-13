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
        private String prey;
        @JsonbProperty("name_of_young")
        private String nameOfYoung;
        @JsonbProperty("group_behaviour")
        private String groupBehavior;
        @JsonbProperty("estimated_population_size")
        private String estimatedPopulationSize;
        @JsonbProperty("biggest_thread")
        private String biggestThread;
        @JsonbProperty("gestation_period")
        private String gestationPeriod;
        private String habitat;
        private String diet;
        @JsonbProperty("average_litter_size")
        private String averageLitterSize;
        private String lifestyle;
        @JsonbProperty("common_name")
        private String commonName;
        @JsonbProperty("number_of_species")
        private String numberOfSpecies;
        private String location;
        private String slogan;
        private String group;
        private String color;
        @JsonbProperty("skin_type")
        private String skinType;
        @JsonbProperty("top_speed")
        private String topSpeed;
        private String lifespan;
        private String weight;
        private String height;
        @JsonbProperty("age_of_sexual_maturity")
        private String ageOfSexualMaturity;
        @JsonbProperty("age_of_weaning")
        private String ageOfWeaning;
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
