package com.dedalus.animal.model.response;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class AnimalDetailsResponse {
    private UUID uuid;
    private String name;
    private String species;
    private String comment;
    private Boolean available;
}
