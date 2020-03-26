package com.matheuscruzdev.bethehero;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import com.github.database.rider.cdi.api.DBRider;
import com.github.database.rider.core.api.dataset.DataSet;
import com.matheuscruzdev.bethehero.data.repositories.ONGPanacheRepository;

import org.junit.Assert;

@DBRider
@QuarkusTestResource(DatabaseDockerInitializer.class)
@QuarkusTest
public class ONGResourceTest {

    @Inject
    ONGPanacheRepository repository;

    @Test
    @DataSet("ong.xml")
    public void listAll(){
        
        var count = repository.count();
        Assert.assertEquals(1, count);

        
    }
}