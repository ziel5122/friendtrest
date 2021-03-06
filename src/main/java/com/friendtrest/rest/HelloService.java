package com.friendtrest.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.friendtrest.DayOfWeek;

/**
 * REST service that greets requests.
 *
 * This is a "root resource class" as explained in
 * https://jersey.java.net/documentation/latest/jaxrs-resources.html
 */
@Path("/")
public class HelloService {
    @GET
    @Path("/today")
    public String today() {
	return DayOfWeek.today();
    }

    @GET
    @Path("/hello")
    public Response hello(@QueryParam("name") String name) {
        if (name == null || name.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            return Response.ok("hello " + name).build();
        }
    }
}
