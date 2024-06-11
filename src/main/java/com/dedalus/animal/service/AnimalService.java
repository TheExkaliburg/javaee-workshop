package com.dedalus.animal.service;

import com.dedalus.animal.model.AnimalDetailedDto;
import com.dedalus.animal.model.AnimalDto;
import com.dedalus.animal.model.AnimalEntity;
import com.dedalus.animal.model.OwnerDto;
import com.dedalus.animal.persistence.AnimalRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class AnimalService {

    @Inject
    AnimalRepository repository;

    public List<AnimalDto> findAll() {
        List<AnimalEntity> list = repository.findAll();
        return list.stream()
                .map(a -> AnimalDto.builder()
                        .name(a.getName())
                        .type(a.getType())
                        .uuid(a.getUuid())
                        .build()
                )
                .collect(Collectors.toList());
    }

    public AnimalDetailedDto adopt(UUID animalDto, OwnerDto owner) {
        AnimalEntity entity = repository.findById(animalDto);
        entity.setOwner(owner.getUuid());
        repository.edit(entity);
        return toDetailedDto(entity);
    }

    public AnimalDetailedDto toDetailedDto(AnimalEntity entity) {
        return AnimalDetailedDto.builder()
                .name(entity.getName())
                .type(entity.getType())
                .uuid(entity.getUuid())
                .owner(entity.getOwner())
                .comment(entity.getComment())
                .build();
    }
}
