package com.dedalus.animal.service.mapper;

import com.dedalus.animal.model.request.AnimalCreationRequest;
import com.dedalus.animal.model.response.AnimalDetailedResponse;
import com.dedalus.animal.model.response.AnimalListResponse;
import com.dedalus.animal.persistence.entity.AnimalEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "cdi", uses = {SpeciesMapper.class})
public abstract class AnimalMapper {

    public AnimalListResponse mapToResponse(List<AnimalEntity> entities) {
        var builder = AnimalListResponse.builder();
        builder.list(entities.stream().map(this::mapToDto).collect(Collectors.toList()));
        return builder.build();
    }

    @Mapping(target = "species", source = "entity.speciesUuid", qualifiedByName = "uuidToSpeciesDto")
    public abstract AnimalDetailedResponse mapToDetailedResponse(AnimalEntity entity);


    @Mapping(target = "species", source = "entity.speciesUuid", qualifiedByName = "uuidToSpeciesName")
    public abstract AnimalListResponse.AnimalDto mapToDto(AnimalEntity entity);

    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "owner", ignore = true)
    @Mapping(target = "speciesUuid", source = "request.species", qualifiedByName = "nameToSpeciesUuid")
    public abstract AnimalEntity mapFromCreationRequest(AnimalCreationRequest request);
}
