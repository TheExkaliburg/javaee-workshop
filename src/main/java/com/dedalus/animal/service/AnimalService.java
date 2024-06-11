package com.dedalus.animal.service;

import com.dedalus.animal.model.AnimalDetailedDto;
import com.dedalus.animal.model.AnimalDto;
import com.dedalus.animal.model.AnimalEntity;
import com.dedalus.animal.persistence.AnimalRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
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
