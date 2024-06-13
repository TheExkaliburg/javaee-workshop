package com.dedalus.animal.model.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class AnimalListResponse {
    private List<AnimalDto> list;

    @Data
    @Builder
    public static class AnimalDto {
        private UUID uuid;
        private String name;
        private String species;
    }
}
