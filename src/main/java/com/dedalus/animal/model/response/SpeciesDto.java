package com.dedalus.animal.model.response;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class SpeciesDto {
    private UUID uuid;
    private String name;
}
