package com.matheuscruzdev.bethehero;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import javax.inject.Inject;
import javax.inject.Named;

import com.github.database.rider.cdi.api.DBRider;
import com.github.database.rider.core.api.dataset.DataSet;
import com.matheuscruzdev.bethehero.domain.repositories.contracts.ONGRepository;

import org.junit.jupiter.api.Test;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;

@DBRider
@QuarkusTestResource(DatabaseDockerInitializer.class)
@QuarkusTest
public class ONGResourceTest {

    @Inject
    @Named("ONGPanacheRepository")
    ONGRepository repository;

    @Test
    @DataSet("ong.json")
    public void index(){
        
        given()
            .when()
                .get("/ongs")
            .then()
                .statusCode(200)
                .assertThat()
                .body("size()", is(3));
    }
}