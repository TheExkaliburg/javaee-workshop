package com.dedalus.animal.model.response;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class AnimalDetailedResponse {
    private UUID uuid;
    private String name;
    private SpeciesDto species;
    private String comment;
    private Boolean available;
}
