package com.matheuscruzdev.bethehero.resources;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.matheuscruzdev.bethehero.data.repositories.IncidentPanacheRepository;
import com.matheuscruzdev.bethehero.data.repositories.ONGPanacheRepository;
import com.matheuscruzdev.bethehero.domain.entities.Incident;
import com.matheuscruzdev.bethehero.resources.dtos.IncidentDTO;
import com.matheuscruzdev.bethehero.resources.dtos.ONGDTO;

@Path("/incidents")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class IncidentResource {

  @Inject
  IncidentPanacheRepository incidentRepository;

  @Inject
  ONGPanacheRepository ONGRepository;

  @GET
  public List<Incident> listAll() {
    
    return incidentRepository.listAll();
  }

  @POST
  @Transactional
  public Response create(IncidentDTO incident, @HeaderParam("Authorization") final String authorization) {

    var ONG = ONGRepository.findById(authorization);
    
    incident.ong = ONGDTO.from(ONG);
    incidentRepository.persist(incident.convert());

    return Response.ok(incident).status(201).build();
  }
}