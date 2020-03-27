package com.matheuscruzdev.bethehero.resources;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import com.google.common.base.Strings;
import com.matheuscruzdev.bethehero.domain.repositories.contracts.IncidentRepository;

/**
 * ProfileResource
 */
@Path("/profile")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {

    @Inject
    @Named("IncidentPanacheRepository")
    IncidentRepository incidentRepository;
    
    @GET
    public Response listAll(@HeaderParam("Authorization") String authorization) {
  
      if (Strings.isNullOrEmpty(authorization)) {
        return Response.status(Response.Status.UNAUTHORIZED).build();
      }
      
      var incidents = incidentRepository.getAllByOngId(authorization);
      var count = incidentRepository.countIncidentsByOngId(authorization);

      return Response.status(Response.Status.OK).entity(incidents).header("X-Total-Count", count).build();
    }
}