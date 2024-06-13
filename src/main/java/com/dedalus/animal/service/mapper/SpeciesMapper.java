package com.dedalus.animal.service.mapper;

import com.dedalus.animal.model.response.SpeciesListResponse;
import com.dedalus.animal.persistence.entity.SpeciesEntity;
import com.dedalus.animal.service.SpeciesService;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(componentModel = "cdi")
@Named("SpeciesMapper")
public abstract class SpeciesMapper {

    @Inject
    SpeciesService speciesService;

    public SpeciesListResponse mapToListResponse(List<SpeciesEntity> entityList) {
        var builder = SpeciesListResponse.builder();
        builder.list(entityList.stream().map(this::mapToListResponseDto).collect(Collectors.toList()));
        return builder.build();
    }

    public abstract SpeciesListResponse.SpeciesDto mapToListResponseDto(SpeciesEntity entity);


    @Named("uuidToSpeciesName")
    public String mapSpeciesUuid(UUID speciesUuid) {
        return speciesService.findByUuid(speciesUuid).orElseThrow().getName();
    }
    @Named("nameToSpeciesUuid")
    public UUID mapNameToSpeciesReference(String name) {
        return speciesService.findByName(name)
                .orElseGet(() -> speciesService.create(name)).getUuid();
    }


}
