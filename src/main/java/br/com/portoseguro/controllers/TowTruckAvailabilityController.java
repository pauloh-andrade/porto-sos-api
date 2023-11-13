package br.com.portoseguro.controllers;

import br.com.portoseguro.dtos.towTruckAvailability.TowTruckAvailabilityRequestDto;
import br.com.portoseguro.services.TowTruckAvailabilityService;
import br.com.portoseguro.models.TowTruckAvailability;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/towtruck")
public class TowTruckAvailabilityController {
    private final TowTruckAvailabilityService towTruckService = new TowTruckAvailabilityService();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@Valid TowTruckAvailabilityRequestDto requestDto) throws Exception {
        towTruckService.create(new TowTruckAvailability(requestDto));

        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() throws Exception {
        List<TowTruckAvailability> towTrucks = towTruckService.findAll();

        return Response.ok(towTrucks).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findOneById(@PathParam("id") int id) throws Exception {
        TowTruckAvailability towTruck = towTruckService.findOneById(id);

        if (towTruck.getId() == 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(towTruck).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, @Valid TowTruckAvailabilityRequestDto requestDto) throws Exception {
        TowTruckAvailability towTruck = towTruckService.update(id, new TowTruckAvailability(requestDto));

        return Response.ok(towTruck).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) throws Exception {
        towTruckService.delete(id);

        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
