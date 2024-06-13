package com.dedalus.animal.restclient;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class RestClientService {

    @Inject
    @RestClient
    RestClientInterface restClient;

    @Retry(maxRetries = 1)
//    @Fallback(fallbackMethod = "dunno")
    public List<RemoteAnimal> callGetAnimals(String name) {
//        int rnd = (int)(Math.random()*999);
//        if (rnd % 3 <= 1) {
//            System.out.println("Error " + rnd);
//            throw new IllegalArgumentException("blah!");
//        }
        return restClient.getAnimals(name, RestClientInterface.API_KEY);
    }

    public RemoteAnimal dunno(String name) {
        return RemoteAnimal.builder().name("I don't know " + name).build();
    }

}
