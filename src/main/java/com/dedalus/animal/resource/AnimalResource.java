package com.dedalus.animal.resource;

import com.dedalus.animal.model.AnimalDetailedDto;
import com.dedalus.animal.model.OwnerDto;
import com.dedalus.animal.restclient.RemoteAnimal;
import com.dedalus.animal.restclient.RestClientService;
import com.dedalus.animal.service.AnimalService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

@Path("animal")
public class AnimalResource {

    @Inject
    AnimalService animalService;

    @Inject
    RestClientService restClientService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public AnimalDetailedDto post(@Valid AnimalDetailedDto request) {
        return animalService.createOrUpdate(request);
    }

    @Path("adopt")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Transactional
    public Response adopt(@QueryParam("animal") UUID animalId, OwnerDto owner) {
//        try {
            var adoptedAnimal = animalService.adopt(animalId, owner);
            return Response.ok(adoptedAnimal).build();
//        } catch (IllegalArgumentException e) {
//            return Response.status(400).build();
//        } catch (NotFoundException e) {
//            return Response.status(404).build();
//        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@QueryParam(value = "uuid") UUID uuid) {
        if (uuid == null) {
            return Response.ok(animalService.findAll()).build();
        }

//        try {
            return Response.ok(animalService.findByUuid(uuid)).build();
//        } catch (NotFoundException e) {
//            return Response.status(404).build();
//        }
    }

    @Path("remote")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findRemote(@QueryParam("name") String name, @QueryParam("invalidatecache") Boolean invalidatecache) {
        if (invalidatecache != null && invalidatecache) {
            restClientService.invalidateCache();
        }
        List<RemoteAnimal> result = restClientService.callGetAnimals(name);
        return Response.ok(result).build();
    }
}
