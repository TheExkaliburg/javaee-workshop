package com.dedalus.animal.persistence;

import com.dedalus.animal.model.OwnerEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class OwnerRepository implements PanacheRepositoryBase<OwnerEntity, UUID> {
}
