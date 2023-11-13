package br.com.portoseguro.controllers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/")
public class HealthController {
    @GET
    @Produces({"text/plain"})
    public String getStatus() {
        return "Server is running";
    }
}