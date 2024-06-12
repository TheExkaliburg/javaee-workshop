package com.dedalus.animal.model.response;

import com.dedalus.animal.model.SpeciesType;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class AnimalDetailsResponse {
    private UUID uuid;
    private String name;
    private SpeciesType type;
    private String comment;
    private Boolean available;
}
