package com.dedalus.animal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnimalDetailedDto {
    private UUID uuid;
    @NotBlank
    @Size(min = 3)
    private String name;
    private SpeciesType type;
    private String comment;
    private Boolean available;
    private UUID owner;
}
