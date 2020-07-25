package com.neeraj.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.neeraj.messenger.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException exception) {
		ErrorMessage errorMssg = new ErrorMessage(exception.getMessage(), 404, "https://www.neeraj.com");
		return Response
			.status(Status.NOT_FOUND)
			.entity(errorMssg)
			.build();
	}

}
