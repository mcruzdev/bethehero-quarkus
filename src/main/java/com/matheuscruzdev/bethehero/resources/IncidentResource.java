package com.matheuscruzdev.bethehero.resources;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.matheuscruzdev.bethehero.domain.entities.Incident;
import com.matheuscruzdev.bethehero.domain.repositories.contracts.IncidentRepository;
import com.matheuscruzdev.bethehero.domain.repositories.contracts.ONGRepository;
import com.matheuscruzdev.bethehero.resources.dtos.IncidentDTO;
import com.matheuscruzdev.bethehero.resources.dtos.ONGDTO;

@Path("/incidents")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class IncidentResource {

  @Inject
  @Named("IncidentPanacheRepository") 
  IncidentRepository incidentRepository;

  @Inject
  @Named("ONGPanacheRepository")
  ONGRepository ONGRepository;

  @GET
  public List<Incident> listAll() {
    
    return incidentRepository.list();
  }

  @POST
  @Transactional
  public Response create(IncidentDTO incident, @HeaderParam("Authorization") final String authorization) {

    var ONG = ONGRepository.getById(authorization);
    
    incident.ong = ONGDTO.from(ONG);
    incidentRepository.insert(incident.convert());

    return Response.ok(incident).status(201).build();
  }

  @DELETE
  @Transactional
  @Path("{id}")
  public Response delete(@PathParam("id") final Long id) {

    incidentRepository.delete(id);
    return Response.noContent().build();
  }
}