package com.matheuscruzdev.bethehero.resources;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.matheuscruzdev.bethehero.domain.repositories.contracts.ONGRepository;
import com.matheuscruzdev.bethehero.resources.dtos.ONGDTO;
import com.matheuscruzdev.bethehero.resources.dtos.ONGLoginResponseDTO;

/**
 * LoginResource
 */
@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginResource {

    @Inject
    @Named("ONGPanacheRepository")
    ONGRepository ONGRepository;

    @POST
    public Response login(final ONGDTO ongdto) {
        
        final var ONG = ONGRepository.getNameAndIdById(ongdto.id);
        
        if (ONG.isPresent()) {
            
            return Response.ok(ONGLoginResponseDTO.from(ONG.get())).build();

        } else {

            final var statusCode = Response.Status.BAD_REQUEST.getStatusCode();
            return Response.status(statusCode).build();
        }
    }
}