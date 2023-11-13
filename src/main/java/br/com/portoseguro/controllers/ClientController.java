package br.com.portoseguro.controllers;

import br.com.portoseguro.dtos.client.ClientRequestDto;
import br.com.portoseguro.services.ClientService;
import br.com.portoseguro.models.Client;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;


@Path("/client")
public class ClientController {
    private final ClientService clientService = new ClientService();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@Valid ClientRequestDto requestDto) throws Exception {
        clientService.create(new Client(requestDto));

        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() throws Exception {
        List<Client>  clients = clientService.findAll();

        return Response.ok(clients).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findOneById(@PathParam("id") int id) throws Exception {
        Client client = clientService.findOneById(id);

        if (client.getId() == 0) {
            return  Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(client).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, @Valid ClientRequestDto requestDto) throws Exception {
        Client client = clientService.update(id, new Client(requestDto));

        return Response.ok(client).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) throws Exception {
        clientService.delete(id);

        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
