package com.dedalus.animal.resource;

import com.dedalus.animal.model.AnimalDetailedDto;
import com.dedalus.animal.model.OwnerDto;
import com.dedalus.animal.service.AnimalService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("animal")
public class AnimalResource {

    @Inject
    AnimalService animalService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public AnimalDetailedDto post(AnimalDetailedDto request) {
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
    public Response find(@QueryParam(value = "uuid") UUID uuid) {
        if (uuid == null) {
            return Response.ok(animalService.findAll()).build();
        }

        return Response.ok(animalService.findByUuid(uuid)).build();
    }
}
