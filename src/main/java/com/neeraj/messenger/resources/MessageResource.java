package com.neeraj.messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Implementation of a simple JAX-RS resource.
 * A JAX-RS resource is an annotated POJO that provides so-called resource methods 
 * Those methods are able to handle HTTP requests for URI paths that the resource is bound to.
 * 
 * Root resource (exposed at "myresource" path)
 */
@Path("/messages")
public class MessageResource {
	
    /**
     * Method handling HTTP GET requests. 
     * The returned object will be sent to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public static String getMessages() {
		return "Hello World";
	}
}