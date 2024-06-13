package com.dedalus.ninja.client;

import com.dedalus.ninja.model.NinjaAnimalResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.List;

@RegisterRestClient(baseUri = "https://api.api-ninjas.com/v1")
@ApplicationScoped
public interface ApiNinjaRestClient {

    @GET
    @Path("animals")
    List<NinjaAnimalResponse> getAnimals(@QueryParam("name") String name, @HeaderParam("X-Api-Key") String apiKey);

    @GET
    @Path("country")
    Object getCountries(@QueryParam("limit") Integer limit, @HeaderParam("X-Api-Key") String apiKey);

}
