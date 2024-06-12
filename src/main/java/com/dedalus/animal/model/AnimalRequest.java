package com.dedalus.animal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnimalRequest {
    @NotNull
    private UUID uuid;
    @NotBlank
    private String name;
    private SpeciesType type;
    private String comment;
    private Boolean available;
}
