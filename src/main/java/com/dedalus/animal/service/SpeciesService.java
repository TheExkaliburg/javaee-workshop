package com.dedalus.animal.service;

import com.dedalus.animal.exceptions.SpeciesNotKnownException;
import com.dedalus.animal.persistence.SpeciesRepository;
import com.dedalus.animal.persistence.entity.SpeciesEntity;
import com.dedalus.ninja.client.ApiNinjaService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class SpeciesService {
    @Inject
    SpeciesRepository repository;
    @Inject
    ApiNinjaService ninjaService;

    public List<SpeciesEntity> findAll() {
        return repository.listAll();
    }

    public Optional<SpeciesEntity> findByName(String name) {
        return repository.find("name", name).firstResultOptional();
    }

    public SpeciesEntity create(String name) {
        var animals = ninjaService.getAnimals(name);
        var result = animals.stream()
                .filter(a -> findByName(a.getName()).isEmpty())
                .map(a -> SpeciesEntity.builder().name(a.getName()).build())
                .map(a -> repository.save(a))
                .filter(a -> a.getName().equalsIgnoreCase(name))
                .findFirst();
        repository.flush();

        return result.orElseThrow(() -> new SpeciesNotKnownException(String.format("Species %s is not known.", name)));
    }

    public Optional<SpeciesEntity> findByUuid(UUID uuid) {
        return repository.findByIdOptional(uuid);
    }
}
