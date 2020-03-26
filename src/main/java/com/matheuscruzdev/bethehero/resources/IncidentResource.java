package com.matheuscruzdev.bethehero.resources;

import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.matheuscruzdev.bethehero.data.repositories.IncidentPanacheRepository;
import com.matheuscruzdev.bethehero.domain.entities.Incident;

@Path("/incidents")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class IncidentResource {

  @Inject
  IncidentPanacheRepository repository;

  @GET
  public List<Incident> listAll() {
    
    return repository.listAll();
  }

  @POST
  @Transactional
  public Response create(Incident incident) {

    repository.persist(incident);
    return Response.ok(incident).status(201).build();
  }
}