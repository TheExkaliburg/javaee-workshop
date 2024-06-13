package com.dedalus.ninja.client;

import com.dedalus.ninja.model.NinjaAnimalResponse;
import io.quarkus.cache.CacheResult;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ApiNinjaService {
    @Inject
    @RestClient
    ApiNinjaRestClient restClient;
    private static final String API_KEY = "";

    @CacheResult(cacheName = "animalApiCache")
    @Fallback(fallbackMethod = "getAnimalsFallback")
    public List<NinjaAnimalResponse> getAnimals(String name) {
        return restClient.getAnimals(name, API_KEY);
    }

    public Object getCountries(Integer limit) {
        return restClient.getCountries(limit, API_KEY);
    }

    protected List<NinjaAnimalResponse> getAnimalsFallback(String s) {
        return List.of();
    }
}
