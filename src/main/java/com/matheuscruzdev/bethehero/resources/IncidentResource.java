package com.matheuscruzdev.bethehero.resources;

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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.common.base.Strings;
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
  public Response listAll(@QueryParam(value = "page") Integer page,
      @HeaderParam("Authorization") String authorization) {

    if (Strings.isNullOrEmpty(authorization)) {
      
      return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    if (page == null) {
      page = Integer.valueOf(1);
    }

    var incidents = incidentRepository.getPageByOngId(page, authorization);

    var count = incidentRepository.countIncidentsByOngId(authorization);

    return Response.status(Response.Status.OK).entity(incidents).header("X-Total-Count", count).build();
  }

  @POST
  @Transactional
  public Response create(IncidentDTO incident, @HeaderParam("Authorization") final String authorization) {

    final var ONG = ONGRepository.getById(authorization);

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