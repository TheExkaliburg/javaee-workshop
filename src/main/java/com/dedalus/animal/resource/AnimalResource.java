package com.dedalus.animal.resource;

import com.dedalus.animal.model.AdoptRequest;
import com.dedalus.animal.model.AnimalRequest;
import com.dedalus.animal.model.AnimalResponse;
import com.dedalus.animal.service.AnimalService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("animal")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AnimalResource {

    @Inject
    AnimalService animalService;

    @GET
    public Response find(@QueryParam(value = "uuid") UUID uuid) {
        if (uuid == null) {
            return Response.ok(animalService.findAll()).build();
        }
        return Response.ok(animalService.findByUuid(uuid)).build();
    }

    @Path("adopt")
    @POST
    @Transactional
    public AnimalResponse adopt(@Valid AdoptRequest request) {
        return animalService.adopt(request.getAnimalId(), request.getOwnerId());
    }

    @PUT
    @Transactional
    public AnimalResponse put(@Valid AnimalRequest request) {
        return animalService.createOrUpdate(request);
    }

    @GET
    @Path("ninja")
    public Response getFromApiNinja(@NotNull @QueryParam("name") String name) {
        return Response.ok(animalService.getFromApiNinja(name)).build();
    }
}
