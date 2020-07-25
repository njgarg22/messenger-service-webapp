package com.neeraj.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import com.neeraj.messenger.model.ErrorMessage;

/**
 * As @Provider annotation is not added on this class, it's doesn't do anything.
 */
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable exception) {
		ErrorMessage errorMsg = new ErrorMessage(exception.getMessage(), 500, "https://www.neeraj.com");
		return Response
			.status(Status.INTERNAL_SERVER_ERROR)
			.entity(errorMsg)
			.build();
	}

}
