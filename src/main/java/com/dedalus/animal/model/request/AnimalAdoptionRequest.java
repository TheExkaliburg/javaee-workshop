package com.dedalus.animal.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnimalAdoptionRequest {
    @NotNull(message = "AnimalUUID cannot be null")
    private UUID animalUuid;
    @NotNull(message = "Name cannot be null")
    @Size(min = 3, max = 128, message = "Name must be between 3 and 128 characters")
    private String name;
}
