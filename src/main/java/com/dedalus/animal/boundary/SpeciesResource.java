package com.dedalus.animal.boundary;

import com.dedalus.animal.service.SpeciesService;
import com.dedalus.animal.service.mapper.SpeciesMapper;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("species")
public class SpeciesResource {
    @Inject
    SpeciesService speciesService;

    @Inject
    SpeciesMapper speciesMapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecies(@QueryParam("uuid") UUID uuid) {
        if (uuid == null) {
            return Response.ok(speciesMapper.mapToListResponse(speciesService.findAll())).build();
        }
        return Response.ok(speciesMapper.mapSpeciesUuidToDetailedDto(uuid)).build();
    }
}
