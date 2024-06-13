package com.dedalus.animal.restclient;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "https://api.api-ninjas.com/v1")
@ApplicationScoped
public interface RestClientInterface {

    String API_KEY = "WdF0akMnBkwbj6MtEjMCOQ==QcWcwkXjjk89dWOK";

    @GET
    @Path("animals")
    List<RemoteAnimal> getAnimals(@QueryParam("name") String name, @HeaderParam("X-Api-Key") String apiKey);

}
