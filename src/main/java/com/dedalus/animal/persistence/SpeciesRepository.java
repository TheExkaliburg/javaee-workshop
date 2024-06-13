package com.dedalus.animal.persistence;

import com.dedalus.animal.persistence.entity.SpeciesEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class SpeciesRepository implements PanacheRepositoryBase<SpeciesEntity, UUID> {
    public SpeciesEntity save(SpeciesEntity entity) {
        return getEntityManager().merge(entity);
    }
}
