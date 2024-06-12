package com.dedalus.animal.service.mapper;

import com.dedalus.animal.model.AnimalRequest;
import com.dedalus.animal.model.AnimalResponse;
import com.dedalus.animal.model.AnimalSearchResults;
import com.dedalus.animal.model.AnimalEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {OwnerMapper.class})
public interface AnimalMapper {

    AnimalMapper INSTANCE = Mappers.getMapper(AnimalMapper.class);

    AnimalSearchResults mapToSearchResults(AnimalEntity entity);

    AnimalResponse mapToResponse(AnimalEntity entity);

    AnimalEntity mapFromRequest(AnimalRequest request);

}
