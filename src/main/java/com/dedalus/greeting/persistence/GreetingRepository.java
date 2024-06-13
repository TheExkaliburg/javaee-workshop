package com.dedalus.greeting.persistence;

import com.dedalus.greeting.model.GreetingEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class GreetingRepository {
    @Inject
    EntityManager em;

    public GreetingEntity save(GreetingEntity entity) {
        em.persist(entity);
        return entity;
    }
}
