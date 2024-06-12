package com.dedalus.animal.service;

import com.dedalus.animal.model.AnimalRequest;
import com.dedalus.animal.model.AnimalResponse;
import com.dedalus.animal.model.AnimalSearchResults;
import com.dedalus.animal.model.AnimalEntity;
import com.dedalus.animal.model.OwnerEntity;
import com.dedalus.animal.persistence.AnimalRepository;
import com.dedalus.animal.persistence.OwnerRepository;
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
    AnimalRepository animalRepository;

    @Inject
    OwnerRepository ownerRepository;

    public List<AnimalSearchResults> findAll() {
        List<AnimalEntity> list = animalRepository.listAll();
        return list.stream()
                .map(AnimalMapper.INSTANCE::mapToSearchResults)
                .collect(Collectors.toList());
    }

    public AnimalResponse adopt(UUID animalId, UUID ownerId) {
        AnimalEntity entity = animalRepository.findByIdOptional(animalId).orElseThrow(NotFoundException::new);
        OwnerEntity owner = ownerRepository.findByIdOptional(ownerId).orElseThrow(NotFoundException::new);
        entity.setOwner(owner);
        animalRepository.merge(entity);
        return AnimalMapper.INSTANCE.mapToResponse(entity);
    }

    public AnimalResponse findByUuid(UUID uuid) {
        AnimalEntity result = animalRepository.findByIdOptional(uuid).orElseThrow(NotFoundException::new);
        return AnimalMapper.INSTANCE.mapToResponse(result);
    }

    public AnimalResponse createOrUpdate(AnimalRequest request) {
        AnimalEntity entity = animalRepository.merge(AnimalMapper.INSTANCE.mapFromRequest(request));
        AnimalResponse response = AnimalMapper.INSTANCE.mapToResponse(entity);
        return response;
    }

}
