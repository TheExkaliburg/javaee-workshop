package com.dedalus.animal.model.response;

import com.dedalus.animal.model.SpeciesType;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class AnimalOverviewResponse {
    private List<AnimalDto> overview;

    @Data
    @Builder
    public static class AnimalDto {
        private UUID uuid;
        private String name;
        private SpeciesType type;
    }
}
