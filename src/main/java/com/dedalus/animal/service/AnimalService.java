package com.dedalus.animal.service;

import com.dedalus.animal.exceptions.AlreadyAdoptedException;
import com.dedalus.animal.exceptions.AnimalNotFoundException;
import com.dedalus.animal.model.request.AnimalAdoptionRequest;
import com.dedalus.animal.model.request.AnimalCreationRequest;
import com.dedalus.animal.model.response.AnimalDetailsResponse;
import com.dedalus.animal.model.response.AnimalListResponse;
import com.dedalus.animal.persistence.AnimalRepository;
import com.dedalus.animal.persistence.entity.AnimalEntity;
import com.dedalus.animal.service.mapper.AnimalMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.UUID;

@ApplicationScoped
public class AnimalService {

    @Inject
    SpeciesService speciesService;
    @Inject
    AnimalRepository repository;
    @Inject
    AnimalMapper animalMapper;

    public AnimalListResponse findOverview() {
        return animalMapper.mapToResponse(repository.listAll());
    }

    public AnimalDetailsResponse adopt(AnimalAdoptionRequest request) {
        AnimalEntity entity = repository.findByIdOptional(request.getAnimalUuid())
                .orElseThrow(() -> new AnimalNotFoundException("Animal with " + request.getAnimalUuid() + " was not found"));

        if (!entity.isAvailable()) {
            throw new AlreadyAdoptedException(String.format("%s (%s) is already adopted", entity.getName(), entity.getUuid()));
        }

        entity.setOwner(request.getName());
        repository.save(entity);
        return animalMapper.mapToDetailsResponse(entity);
    }

    public AnimalDetailsResponse findByUuid(UUID uuid) {
        AnimalEntity result = repository.findByIdOptional(uuid)
                .orElseThrow(() -> new AnimalNotFoundException("Animal with " + uuid + " was not found"));
        return animalMapper.mapToDetailsResponse(result);
    }

    public AnimalDetailsResponse create(AnimalCreationRequest request) {
        /*SpeciesEntity species = speciesService.findByName(request.getSpecies())
                .orElseGet(() -> speciesService.create(request.getSpecies()));
*/
        AnimalEntity entity = repository.save(animalMapper.mapFromCreationRequest(request));
        return animalMapper.mapToDetailsResponse(entity);
    }
    
}
