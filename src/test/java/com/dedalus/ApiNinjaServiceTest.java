package com.dedalus;

import com.dedalus.ninja.client.ApiNinjaService;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
class ApiNinjaServiceTest {
    @Inject
    ApiNinjaService ninjaService;

    @Test
    void test(){
        System.out.println(ninjaService.getAnimals("Axolotl"));
    }
}
