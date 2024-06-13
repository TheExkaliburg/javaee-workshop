package com.dedalus.animal.boundary;

import com.dedalus.animal.service.SpeciesService;
import com.dedalus.animal.service.mapper.SpeciesMapper;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("species")
public class SpeciesResource {
    @Inject
    SpeciesService speciesService;

    @Inject
    SpeciesMapper speciesMapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecies() {
        var response = speciesMapper.mapToListResponse(speciesService.findAll());

        return Response.ok(response).build();
    }
}
