package com.dedalus.animal.persistence;

import com.dedalus.animal.model.AnimalEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class AnimalRepository implements PanacheRepositoryBase<AnimalEntity, UUID> {

    public AnimalEntity merge(AnimalEntity entity) {
        return getEntityManager().merge(entity);
    }
}
