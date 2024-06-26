package com.dedalus.animal.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class AnimalDto {
    private UUID uuid;
    private String name;
    private SpeciesType type;
}
