package com.dedalus.animal.persistence;

import com.dedalus.animal.model.AnimalEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class AnimalRepository {

    @Inject
    EntityManager em;

    public List<AnimalEntity> findAll() {
        return em.createQuery("SELECT a FROM AnimalEntity a", AnimalEntity.class).getResultList();
    }

    public AnimalEntity findById(UUID id) {
        return em.find(AnimalEntity.class, id);
    }

    public AnimalEntity edit(AnimalEntity entity) {
        return em.merge(entity);
    }

    public Optional<AnimalEntity> findByUuid(UUID uuid) {
        AnimalEntity animalEntity = em.find(AnimalEntity.class, uuid);
        return Optional.ofNullable(animalEntity);
    }
}
