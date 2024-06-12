package com.dedalus.animal.mapper;

import com.dedalus.animal.model.request.AnimalCreationRequest;
import com.dedalus.animal.model.response.AnimalDetailsResponse;
import com.dedalus.animal.model.response.AnimalOverviewResponse;
import com.dedalus.animal.persistence.entity.AnimalEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface AnimalMapper {

    AnimalMapper INSTANCE = Mappers.getMapper(AnimalMapper.class);

    default AnimalOverviewResponse mapToResponse(List<AnimalEntity> entities) {
        var builder = AnimalOverviewResponse.builder();
        builder.overview(entities.stream().map(this::mapToDto).collect(Collectors.toList()));
        return builder.build();
    }

    AnimalOverviewResponse.AnimalDto mapToDto(AnimalEntity entity);

    AnimalDetailsResponse mapToDetailsResponse(AnimalEntity entity);

    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "owner", ignore = true)
    AnimalEntity mapFromCreationRequest(AnimalCreationRequest request);

}
