package com.matheuscruzdev.bethehero;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import javax.inject.Inject;
import javax.inject.Named;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.database.rider.cdi.api.DBRider;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.matheuscruzdev.bethehero.domain.repositories.contracts.ONGRepository;
import com.matheuscruzdev.bethehero.resources.dtos.ONGDTO;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@DBRider
@QuarkusTestResource(DatabaseDockerInitializer.class)
@QuarkusTest
public class ONGResourceTest {

    @Inject
    @Named("ONGPanacheRepository")
    ONGRepository repository;

    @Test
    @Order(1)
    @DataSet("ong.json")
    public void index() {

        given().when().get("/ongs").then().statusCode(200).assertThat().body("size()", is(3));
    }

    @Test
    @Order(2)
    @DataSet("ong.json")
    @ExpectedDataSet(value = "ong-create.json", ignoreCols = "id")
    public void create() throws JsonProcessingException {

        var mapper = new ObjectMapper();
        var json = mapper.writeValueAsString(
                new ONGDTO(null, "NEW", "ong@newong.com.br", "21984444444", "Rio de Janeiro", "RJ"));

        given().contentType(ContentType.JSON).body(json).post("/ongs").then().statusCode(201);
    }
}