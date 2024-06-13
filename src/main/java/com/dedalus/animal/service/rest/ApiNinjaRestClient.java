package com.dedalus.animal.service.rest;

import com.dedalus.animal.model.ApiNinjaAnimalResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.List;

@RegisterRestClient(baseUri = "https://api.api-ninjas.com/v1/")
@ApplicationScoped
public interface ApiNinjaRestClient {

    @GET
    @Path("animals")
    List<ApiNinjaAnimalResponse> getAnimals(@QueryParam("name") String name,
                                            @HeaderParam("X-Api-Key") String apiKey
    );

}
