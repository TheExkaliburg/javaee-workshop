package com.dedalus.animal.model.request;

import com.dedalus.animal.model.SpeciesType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnimalCreationRequest {
    private String name;
    private SpeciesType type;
    private String comment;
}
