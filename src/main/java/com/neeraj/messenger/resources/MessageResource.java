package com.neeraj.messenger.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.neeraj.messenger.model.Message;
import com.neeraj.messenger.service.MessageService;

/**
 * Implementation of a simple JAX-RS resource.
 * A JAX-RS resource is an annotated POJO that provides so-called resource methods 
 * Those methods are able to handle HTTP requests for URI paths that the resource is bound to.
 * 
 * Root resource (exposed at "myresource" path)
 */
@Path("/messages")
public class MessageResource {
	
	MessageService messageService = new MessageService();
	
    /**
     * Method handling HTTP GET requests. 
     * The returned object will be sent to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages() {
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long id) {
		return messageService.getMessage(id);
	}
}