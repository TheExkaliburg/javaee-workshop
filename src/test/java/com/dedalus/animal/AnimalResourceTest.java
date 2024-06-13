package com.dedalus.animal;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import javax.json.Json;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;

@QuarkusTest
public class AnimalResourceTest {

    private static final String BASE_PATH = "/animal";
    private static final String UUID_PUT = UUID.randomUUID().toString();
    private static final String UUID_RUPERT = "a63eccb7-5450-4bad-8516-9015b6300e8d";

    @Test
    public void testListAll() {
        given()
            .when()
                .get(BASE_PATH)
            .then()
                .statusCode(200)
                .body("uuid", hasSize(18))
                .body("uuid", hasItem(UUID_RUPERT))
                .body("name", hasItem("Rupert"));
    }

    @Test
    public void testGet() {
        given()
            .when()
            .queryParam("uuid", UUID_RUPERT)
            .get(BASE_PATH)
            .then()
            .statusCode(200)
            .body("name", equalTo("Rupert"))
            .body("type", equalTo("WALRUS"))
            .body("uuid", equalTo("a63eccb7-5450-4bad-8516-9015b6300e8d"));
    }

    @Test
    public void testGetNotFound() {
        given()
            .when()
            .queryParam("uuid", UUID.randomUUID())
            .get(BASE_PATH)
            .then()
            .statusCode(404)
            .body("message", equalTo("HTTP 404 Not Found"));
    }

    @Test
    public void testPutValid() {
        given()
            .when()
            .contentType(ContentType.JSON)
            .body(Json.createObjectBuilder()
                .add("uuid", UUID_PUT)
                .add("name", "Holger")
                .add("type", "BARN_OWL")
                .build()
                .toString()
            )
            .put(BASE_PATH)
            .then()
            .statusCode(200)
            .body("uuid", equalTo(UUID_PUT))
            .body("name", equalTo("Holger"))
            .body("type", equalTo("BARN_OWL"));
    }

    @Test
    public void testPutInvalid() {
        given()
            .when()
            .contentType(ContentType.JSON)
            .body(Json.createObjectBuilder()
                .add("uuid", UUID.randomUUID().toString())
                .build()
                .toString()
            )
            .put(BASE_PATH)
            .then()
            .statusCode(400);
    }

}