package com.dedalus.animal.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;

import com.dedalus.animal.model.AnimalDetailedDto;
import com.dedalus.animal.model.AnimalDto;
import com.dedalus.animal.model.AnimalEntity;
import com.dedalus.animal.model.OwnerDto;
import com.dedalus.animal.persistence.AnimalRepository;

@ApplicationScoped
public class AnimalService {

    @Inject
    AnimalRepository repository;

    public List<AnimalDto> findAll() {
        List<AnimalEntity> list = repository.listAll();
        return list.stream()
                .map(a -> AnimalDto.builder()
                        .name(a.getName())
                        .type(a.getType())
                        .uuid(a.getUuid())
                        .build()
                )
                .collect(Collectors.toList());
    }

    public AnimalDetailedDto adopt(UUID animalDto, OwnerDto owner) throws IllegalArgumentException {
        AnimalEntity entity = repository.findByIdOptional(animalDto).orElseThrow(NotFoundException::new);
        if (entity.getAvailable() != null && !entity.getAvailable()) {
            throw new IllegalArgumentException();
        }
        entity.setOwner(owner.getUuid());
        entity.setAvailable(false);
        repository.merge(entity);
        return mapDetail(entity);
    }

    public AnimalDetailedDto findByUuid(UUID uuid) {
        AnimalEntity result = repository.findByIdOptional(uuid).orElseThrow(NotFoundException::new);

        return mapDetail(result);
    }

    public AnimalDetailedDto createOrUpdate(AnimalDetailedDto dto) {
        AnimalEntity entity = repository.merge(mapDetail(dto));
        return mapDetail(entity);
    }

    private AnimalDetailedDto mapDetail(AnimalEntity entity) {
        return AnimalDetailedDto.builder()
            .name(entity.getName())
            .type(entity.getType())
            .uuid(entity.getUuid())
            .available(entity.getAvailable())
            .comment(entity.getComment())
            .build();
    }

    private AnimalEntity mapDetail(AnimalDetailedDto dto) {
        return AnimalEntity.builder()
            .uuid(dto.getUuid())
            .name(dto.getName())
            .available(dto.getAvailable())
            .type(dto.getType())
            .comment(dto.getComment())
            .build();
    }
    
}
