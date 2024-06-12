package com.dedalus.animal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdoptRequest {

    @NotNull
    private UUID animalId;

    @NotNull
    private UUID ownerId;

}
