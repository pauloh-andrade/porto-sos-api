package br.com.portoseguro.controllers;

import br.com.portoseguro.dtos.vehicle.VehicleRequestDto;
import br.com.portoseguro.models.Vehicle;
import br.com.portoseguro.services.VehicleService;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;


@Path("/vehicle")
public class VehicleController {
    private final VehicleService vehicleService = new VehicleService();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@Valid VehicleRequestDto requestDto) throws Exception {
        vehicleService.create(new Vehicle(requestDto));

        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() throws Exception {
        List<Vehicle> clients = vehicleService.findAll();

        return Response.ok(clients).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findOneById(@PathParam("id") int id) throws Exception {
        Vehicle vehicle = vehicleService.findOneById(id);

        if (vehicle.getId() == 0) {
            return  Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(vehicle).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, @Valid VehicleRequestDto requestDto) throws Exception {
        Vehicle vehicle = vehicleService.update(id, new Vehicle(requestDto));

        return Response.ok(vehicle).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) throws Exception {
        vehicleService.delete(id);

        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
