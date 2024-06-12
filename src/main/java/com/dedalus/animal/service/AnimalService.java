package com.dedalus.animal.service;

import com.dedalus.animal.exceptions.AlreadyAdoptedException;
import com.dedalus.animal.exceptions.AnimalNotFoundException;
import com.dedalus.animal.mapper.AnimalMapper;
import com.dedalus.animal.model.request.AnimalAdoptionRequest;
import com.dedalus.animal.model.request.AnimalCreationRequest;
import com.dedalus.animal.model.response.AnimalDetailsResponse;
import com.dedalus.animal.model.response.AnimalOverviewResponse;
import com.dedalus.animal.persistence.AnimalRepository;
import com.dedalus.animal.persistence.entity.AnimalEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.UUID;

@ApplicationScoped
public class AnimalService {

    @Inject
    AnimalRepository repository;

    public AnimalOverviewResponse findOverview() {
        return AnimalMapper.INSTANCE.mapToResponse(repository.listAll());
    }

    public AnimalDetailsResponse adopt(AnimalAdoptionRequest request) {
        AnimalEntity entity = repository.findByIdOptional(request.getAnimalUuid())
                .orElseThrow(() -> new AnimalNotFoundException("Animal with " + request.getAnimalUuid() + " was not found"));

        if (!entity.isAvailable()) {
            throw new AlreadyAdoptedException(String.format("%s (%s) is already adopted", entity.getName(), entity.getUuid()));
        }

        entity.setOwner(request.getName());
        repository.save(entity);
        return AnimalMapper.INSTANCE.mapToDetailsResponse(entity);
    }

    public AnimalDetailsResponse findByUuid(UUID uuid) {
        AnimalEntity result = repository.findByIdOptional(uuid)
                .orElseThrow(() -> new AnimalNotFoundException("Animal with " + uuid + " was not found"));
        return AnimalMapper.INSTANCE.mapToDetailsResponse(result);
    }

    public AnimalDetailsResponse createOrUpdate(AnimalCreationRequest request) {
        AnimalEntity entity = repository.save(AnimalMapper.INSTANCE.mapFromCreationRequest(request));
        return AnimalMapper.INSTANCE.mapToDetailsResponse(entity);
    }
    
}
