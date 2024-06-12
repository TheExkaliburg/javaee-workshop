package com.dedalus.animal.model.request;

import com.dedalus.animal.model.SpeciesType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnimalCreationRequest {
    @NotNull(message = "Name cannot be null")
    @Size(min = 3, max = 128, message = "Name must be between 3 and 128 characters")
    private String name;
    @NotNull
    private SpeciesType type;
    @Size(min = 100, message = "Name must be between 1 and 100 characters")
    private String comment;
}