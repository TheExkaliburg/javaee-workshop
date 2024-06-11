package com.dedalus.animal.persistence;

import com.dedalus.animal.model.AnimalDetailedDto;
import com.dedalus.animal.model.AnimalDto;
import com.dedalus.animal.model.AnimalEntity;
import com.dedalus.animal.model.OwnerDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;
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

    public void edit(AnimalEntity entity) {
        em.merge(entity);
    }
}
