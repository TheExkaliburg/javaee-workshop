package com.dedalus.animal.resource;

import com.dedalus.animal.model.AnimalDetailedDto;
import com.dedalus.animal.model.AnimalDto;
import com.dedalus.animal.service.AnimalService;

import java.util.List;
import java.util.UUID;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.dedalus.animal.model.OwnerDto;

@Path("animal")
public class AnimalResource {

    @Inject
    AnimalService animalService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AnimalDto> listAll() {
        return animalService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public AnimalDetailedDto insert(AnimalDetailedDto request) {
        return animalService.createOrUpdate(request);
    }

    @Path("adopt")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public AnimalDetailedDto adopt(@QueryParam("animal") UUID animalId, OwnerDto owner) {
        return animalService.adopt(animalId, owner);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public AnimalDetailedDto find(@QueryParam(value = "uuid") UUID uuid) {
        return animalService.findByUuid(uuid);
    }
}
