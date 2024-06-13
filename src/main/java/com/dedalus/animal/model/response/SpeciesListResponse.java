package com.dedalus.animal.model.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SpeciesListResponse {
    private List<SpeciesDto> list;

}
