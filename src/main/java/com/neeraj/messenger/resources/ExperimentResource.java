package com.neeraj.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * This class is just for experimentation purposes.
 */

@Path("/experiment")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class ExperimentResource {

	@GET
	@Path("/annotations")
	public String getParamsUsingAnnotations(@MatrixParam("param1") String matrixParam,
											@HeaderParam("customerheader") String headerParam,
											@CookieParam("cookieParam") String cookieParam) {
		/**
		 * An example URL with query params: http://some.where/thing?paramA=1&paramB=6542
		 * An example URL with matrix params: http://some.where/thing;paramA=1;paramB=6542
		 * 
		 * GET localhost:8080/messenger-service-webapp/webapi/experiment/annotations;param1=jersey
		 * Response: "MatrixParam: jersey"
		 */
		return "MatrixParam: " + matrixParam + "  HeaderParam: " + headerParam + "  CookieParam: " + cookieParam;
	}
	
	@GET
	@Path("/context")
	public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders) {
		String path = uriInfo.getAbsolutePath().toString();
		return path;
	}
}
