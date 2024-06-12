package com.dedalus.animal.service.mapper;

import com.dedalus.animal.model.OwnerResponse;
import com.dedalus.animal.model.OwnerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OwnerMapper {

    OwnerMapper INSTANCE = Mappers.getMapper(OwnerMapper.class);

    OwnerResponse mapToResponse(OwnerEntity entity);

}
