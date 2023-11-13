package br.com.portoseguro.controllers;

import br.com.portoseguro.dtos.user.LoginRequestDto;
import br.com.portoseguro.dtos.user.LoginResponseDto;
import br.com.portoseguro.services.UserService;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/login")
public class UserController {
    private final UserService userService = new UserService();

    @POST
    @Path("/auth")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@Valid LoginRequestDto requestDto) throws Exception {
        boolean result = userService.login(requestDto.phoneNumber(), requestDto.password());

        LoginResponseDto responseDto = new LoginResponseDto(result);

        return Response.status(Response.Status.OK).entity(responseDto).build();
    }
}
