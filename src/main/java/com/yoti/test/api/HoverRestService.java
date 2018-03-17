package com.yoti.test.api;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.yoti.test.model.Coordinates;
import com.yoti.test.service.HoverService;
import com.yoti.test.service.HoverServiceImpl;



/*
 * Rest API Class for
 * Consuming payload of Coordinates Java Objects 
 * */

@Path("/hover")
public class HoverRestService{
	
	HoverService hoverService = new HoverServiceImpl();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response moveHover(Coordinates input) {
		if(input == null){
	         throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		Map<String,Object> output = hoverService.takeInstruction(input);
		hoverService.insertPayload(input);
		return Response.status(Status.OK).entity(output).build();
	}

}
