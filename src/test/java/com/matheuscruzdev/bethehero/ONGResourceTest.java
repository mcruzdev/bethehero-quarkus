package com.matheuscruzdev.bethehero;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.*;

import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import com.github.database.rider.cdi.api.DBRider;
import com.github.database.rider.core.api.dataset.DataSet;
import com.matheuscruzdev.bethehero.data.repositories.ONGPanacheRepository;

import static org.hamcrest.Matchers.is;
import org.junit.Assert;

@DBRider
@QuarkusTestResource(DatabaseDockerInitializer.class)
@QuarkusTest
public class ONGResourceTest {

    @Inject
    ONGPanacheRepository repository;

    @Test
    @DataSet("ong.json")
    public void listAll(){
        
        given()
            .when()
                .get("/ongs")
            .then()
                .statusCode(200)
                .assertThat()
                .body("size()", is(3));
    }
}