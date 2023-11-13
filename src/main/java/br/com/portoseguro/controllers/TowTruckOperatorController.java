package br.com.portoseguro.controllers;

import br.com.portoseguro.dtos.towTruckOperator.TowTruckOperatorRequestDto;
import br.com.portoseguro.services.TowTruckOperatorService;
import br.com.portoseguro.models.TowTruckOperator;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/tow-truck-operator")
public class TowTruckOperatorController {
    private final TowTruckOperatorService towTruckOperatorService = new TowTruckOperatorService();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@Valid TowTruckOperatorRequestDto requestDto) throws Exception {
        towTruckOperatorService.create(new TowTruckOperator(requestDto));

        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() throws Exception {
        List<TowTruckOperator> towTruckOperators = towTruckOperatorService.findAll();

        return Response.ok(towTruckOperators).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findOneById(@PathParam("id") int id) throws Exception {
        TowTruckOperator towTruckOperator = towTruckOperatorService.findOneById(id);

        if (towTruckOperator.getId() == 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(towTruckOperator).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, @Valid TowTruckOperatorRequestDto requestDto) throws Exception {
        TowTruckOperator towTruckOperator = towTruckOperatorService.update(id, new TowTruckOperator(requestDto));

        return Response.ok(towTruckOperator).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) throws Exception {
        towTruckOperatorService.delete(id);

        return Response.status(Response.Status.NO_CONTENT).build();
    }
}