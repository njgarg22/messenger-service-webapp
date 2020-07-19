package com.neeraj.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.neeraj.messenger.model.Message;
import com.neeraj.messenger.service.MessageService;

/**
 * Implementation of a simple JAX-RS resource.
 * A JAX-RS resource is an annotated POJO that provides so-called resource methods 
 * Those methods are able to handle HTTP requests for URI paths that the resource is bound to.
 * Instead of adding `@Produces` or `@Consumes` annotation on each method, just annotate it on the class itself.
 * 
 * Root resource (exposed at "messages" path)
 */
@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	/**
	 * Jersey creates a new instance of the MessageResource for every request. 
	 * So, the MessageService reference is instantiated time and time again.
	 */
	MessageService messageService = new MessageService();
	
	/**
	 * Method handling HTTP GET requests. 
	 * The returned object will be sent to the client as "application/json" media type.
	 * 
	 * @return Message that will be returned as a application/json response.
	 */
	@GET
	public List<Message> getMessages(@QueryParam("year") int year, @QueryParam("start") int start, @QueryParam("size") int size) {
		if(year > 0) {
			return messageService.getAllMessagesForYear(year);
		}
		
		if(start >=0 && size > 0) {
			return messageService.getAllMessagesPaginated(start, size);
		}
		return messageService.getAllMessages();
	}
	
	@POST
	public Message addMessage(Message message) {
		return messageService.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id, Message message) {
		message.setId(id);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long id) {
		messageService.removeMessage(id);
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long id) {
		return messageService.getMessage(id);
	}
}