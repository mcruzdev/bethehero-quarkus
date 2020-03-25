package com.matheuscruzdev.bethehero;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.matheuscruzdev.bethehero.domain.repositories.ONGRepository;
import com.matheuscruzdev.bethehero.domain.entities.ONG;

@Path("/ongs")
public class ONGResource {

    @Inject
    ONGRepository repository;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public List<ONG> hello() {

        return repository.listAll();
    }
}