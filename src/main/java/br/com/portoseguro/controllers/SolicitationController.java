package br.com.portoseguro.controllers;

import br.com.portoseguro.dtos.solicitation.SolicitationRequestDto;
import br.com.portoseguro.services.SolicitationService;
import br.com.portoseguro.models.Solicitation;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/solicitation")
public class SolicitationController {
    private final SolicitationService solicitationService = new SolicitationService();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@Valid SolicitationRequestDto requestDto) throws Exception {
        solicitationService.create(new Solicitation(requestDto));

        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() throws Exception {
        List<Solicitation> solicitations = solicitationService.findAll();

        return Response.ok(solicitations).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findOneById(@PathParam("id") int id) throws Exception {
        Solicitation solicitation = solicitationService.findOneById(id);

        if (solicitation.getSolicitationId() == 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(solicitation).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, @Valid SolicitationRequestDto requestDto) throws Exception {
        Solicitation solicitation = solicitationService.update(id, new Solicitation(requestDto));

        return Response.ok(solicitation).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) throws Exception {
        solicitationService.delete(id);

        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
