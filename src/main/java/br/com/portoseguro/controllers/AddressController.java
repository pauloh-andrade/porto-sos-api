package br.com.portoseguro.controllers;

import br.com.portoseguro.dtos.address.AddressRequestDto;
import br.com.portoseguro.models.Address;
import br.com.portoseguro.services.AddressService;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/address")
public class AddressController {
    private final AddressService addressService = new AddressService();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@Valid AddressRequestDto requestDto) throws Exception {
        addressService.create(new Address(requestDto));

        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() throws Exception {
        List<Address> addresses = addressService.findAll();

        return Response.ok(addresses).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findOneById(@PathParam("id") int id) throws Exception {
        Address address = addressService.findOneById(id);

        if (address.getId() == 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(address).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, @Valid AddressRequestDto requestDto) throws Exception {
        Address address = addressService.update(id, new Address(requestDto));

        return Response.ok(address).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) throws Exception {
        addressService.delete(id);

        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
