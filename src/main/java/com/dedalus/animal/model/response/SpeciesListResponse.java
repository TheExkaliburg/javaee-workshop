package com.dedalus.animal.model.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class SpeciesListResponse {
    private List<SpeciesDto> list;

    @Data
    @Builder
    public static class SpeciesDto {
        private UUID uuid;
        private String name;
    }
}
