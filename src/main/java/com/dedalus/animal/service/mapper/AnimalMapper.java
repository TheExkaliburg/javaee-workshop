package com.dedalus.animal.service.mapper;

import com.dedalus.animal.model.AnimalDetailedDto;
import com.dedalus.animal.model.AnimalDto;
import com.dedalus.animal.model.AnimalEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnimalMapper {

    AnimalMapper INSTANCE = Mappers.getMapper(AnimalMapper.class);

    AnimalDto mapToDto(AnimalEntity entity);

    AnimalDetailedDto mapToDetailedDto(AnimalEntity entity);

    @Mapping(target = "uuid", ignore = true)
    AnimalEntity mapFromDetailedDto(AnimalDetailedDto dto);

}
