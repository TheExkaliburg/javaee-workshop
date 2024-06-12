package com.dedalus.animal.model.request;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class AnimalAdoptionRequest {
    private UUID animalUuid;
    private String name;
}
