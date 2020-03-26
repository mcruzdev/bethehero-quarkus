package com.matheuscruzdev.bethehero.resources;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.matheuscruzdev.bethehero.domain.entities.ONG;
import com.matheuscruzdev.bethehero.domain.repositories.contracts.ONGRepository;
import com.matheuscruzdev.bethehero.resources.dtos.ONGDTO;

@Path("/ongs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ONGResource {

    @Inject
    @Named("ONGPanacheRepository") 
    ONGRepository repository;

    @GET
    public List<ONG> listAll() {
        
        return repository.getAll();
    }

    @POST
    @Transactional
    public Response create(ONGDTO ong) {

        repository.insert(ong.convert());
        return Response.ok(ong).status(201).build();
    }
}