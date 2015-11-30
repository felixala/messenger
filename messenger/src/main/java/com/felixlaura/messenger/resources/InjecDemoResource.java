package com.felixlaura.messenger.resources;

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

@Path("/injecdemo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InjecDemoResource {
	
	@GET
	@Path("annotation")
	public String getParamsUsingAnnotation(@MatrixParam ("matrix") String matrixParam,
										   @HeaderParam("headerParam") String header,
										   @CookieParam("cookie") String name){
		return "Matrix param: " + matrixParam + " Header Param: " + header + " Cookie Value: " + name;
	}

	@GET
	@Path("context")
	public String getParamUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders headers){
		String path = uriInfo.getAbsolutePath().toString();
		String cookies = headers.getCookies().toString();
		return "Path: " + path + "Cookies: " + cookies;
	}
}
