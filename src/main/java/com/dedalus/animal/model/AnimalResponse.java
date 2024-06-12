package com.dedalus.animal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnimalResponse {
    private UUID uuid;
    private String name;
    private SpeciesType type;
    private String comment;
    private Boolean available;
    private OwnerResponse owner;
}
