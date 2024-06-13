package com.dedalus.animal.mock;

import com.dedalus.animal.model.ApiNinjaAnimalResponse;
import com.dedalus.animal.service.rest.ApiNinjaRestClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.util.List;

@ApplicationScoped
@RestClient
@Alternative
public class ApiNinjaMockRestClient implements ApiNinjaRestClient {

    public static final List<ApiNinjaAnimalResponse> DEFAULT = List.of(
        ApiNinjaAnimalResponse.builder()
            .name("Kitty")
            .build(),
        ApiNinjaAnimalResponse.builder()
            .name("Waldi")
            .build()
    );

    @Override
    public List<ApiNinjaAnimalResponse> getAnimals(String name, String apiKey) {
        return DEFAULT;
    }

}
