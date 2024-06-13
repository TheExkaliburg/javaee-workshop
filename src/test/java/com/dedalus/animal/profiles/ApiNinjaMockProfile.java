package com.dedalus.animal.profiles;

import com.dedalus.animal.mock.ApiNinjaMockRestClient;
import io.quarkus.test.junit.QuarkusTestProfile;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class ApiNinjaMockProfile implements QuarkusTestProfile {

    @Override
    public Map<String, String> getConfigOverrides() {
        return Collections.singletonMap("ninja.api.key", "0815666");
    }

    @Override
    public Set<Class<?>> getEnabledAlternatives() {
        return Collections.singleton(ApiNinjaMockRestClient.class);
    }

}
