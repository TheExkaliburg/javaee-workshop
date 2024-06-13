package com.dedalus.animal.model.response;

import com.dedalus.ninja.model.NinjaAnimalResponse;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class SpeciesDetailedResponse {
    private UUID uuid;
    private String name;
    private NinjaAnimalResponse.Taxonomy taxonomy;
    private NinjaAnimalResponse.Characteristics characteristics;
}
