package edu.uci.ics.cs122b.service.frame.resources;


import edu.uci.ics.cs122b.service.frame.frame.Endpoint;
import edu.uci.ics.cs122b.service.frame.handlers.ExampleHandler;
import edu.uci.ics.cs122b.service.frame.models.ExampleRequestModel;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("example")
public class ExamplePage {

    @Path("post")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    // Example endpoint to add two numbers
    public Response examplePost(@Context HttpHeaders headers, String jsonText) {
        ExampleHandler handler = new ExampleHandler();

        return Endpoint.workflowPost(headers, jsonText, ExampleRequestModel.class, handler, "test a post example");
    }

    @Path("get")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    // Example endpoint to add 10 to a number
    public Response exampleGet(@Context HttpHeaders headers, @QueryParam("x") int x) {
        ExampleRequestModel request = new ExampleRequestModel(x, 10);
        ExampleHandler handler = new ExampleHandler();

        return Endpoint.workflowGet(headers, request, handler, "test a get example");
    }

}
