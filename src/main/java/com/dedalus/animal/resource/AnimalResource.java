package com.dedalus.animal.resource;

import com.dedalus.animal.model.AnimalDetailedDto;
import com.dedalus.animal.model.OwnerDto;
import com.dedalus.animal.service.AnimalService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("animal")
public class AnimalResource {

    @Inject
    AnimalService animalService;

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
