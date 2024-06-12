package com.dedalus.animal.service;

import com.dedalus.animal.model.AnimalDetailedDto;
import com.dedalus.animal.model.AnimalDto;
import com.dedalus.animal.model.AnimalEntity;
import com.dedalus.animal.model.OwnerDto;
import com.dedalus.animal.persistence.AnimalRepository;
import com.dedalus.animal.service.mapper.AnimalMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class AnimalService {

    @Inject
    AnimalRepository repository;

    public List<AnimalDto> findAll() {
        List<AnimalEntity> list = repository.listAll();
        return list.stream()
                .map(AnimalMapper.INSTANCE::mapToDto)
                .collect(Collectors.toList());
    }

    public AnimalDetailedDto adopt(UUID animalDto, OwnerDto owner) {
        AnimalEntity entity = repository.findByIdOptional(animalDto).orElseThrow(NotFoundException::new);
        entity.setOwner(owner.getUuid());
        repository.merge(entity);
        return AnimalMapper.INSTANCE.mapToDetailedDto(entity);
    }

    public AnimalDetailedDto findByUuid(UUID uuid) {
        AnimalEntity result = repository.findByIdOptional(uuid).orElseThrow(NotFoundException::new);
        return AnimalMapper.INSTANCE.mapToDetailedDto(result);
    }

    public AnimalDetailedDto createOrUpdate(AnimalDetailedDto dto) {
        AnimalEntity entity = repository.merge(AnimalMapper.INSTANCE.mapFromDetailedDto(dto));
        return AnimalMapper.INSTANCE.mapToDetailedDto(entity);
    }
    
}
