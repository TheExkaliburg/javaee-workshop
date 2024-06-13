package com.dedalus.animal.boundary;

import com.dedalus.animal.model.request.AnimalAdoptionRequest;
import com.dedalus.animal.model.request.AnimalCreationRequest;
import com.dedalus.animal.model.response.AnimalDetailsResponse;
import com.dedalus.animal.service.AnimalService;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.info.Info;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@OpenAPIDefinition(
        info = @Info(
                title = "Anime Resource",
                version = "1.0.0"
        )
)
@Path("animal")
public class AnimalResource {

    @Inject
    AnimalService animalService;

    @Operation(
            summary = "Creates a new and adoptable animal."
    )
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public AnimalDetailsResponse create(@Valid AnimalCreationRequest request) {
        return animalService.create(request);
    }

    @Path("adopt")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Transactional
    public Response adopt(@Valid AnimalAdoptionRequest request) {
        animalService.adopt(request);

        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@QueryParam(value = "uuid") UUID uuid) {
        if (uuid == null) {
            return Response.ok(animalService.findOverview()).build();
        }

        return Response.ok(animalService.findByUuid(uuid)).build();
    }
}
