package com.slothmotion.poc.quarkus.rest.resource;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.slothmotion.poc.quarkus.repository.exception.MissingEntityException;
import com.slothmotion.poc.quarkus.rest.dto.EventDTO;
import com.slothmotion.poc.quarkus.service.EventService;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/event")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class EventResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(EventResource.class);

	private EventService handlerService;

	@Inject
	public EventResource(EventService handlerService) {
		this.handlerService = handlerService;
	}

	@GET
	@Path("/{id}")
	public Response getEvent(@PathParam("id") String id) {
		try {
			return Response.ok(handlerService.fetchEvent(id)).build();
		}
		catch (MissingEntityException e) {
			return Response.status(HttpStatus.SC_NOT_FOUND).build();
		}
		catch (Exception e) {
			return Response.serverError().build();
		}
	}

	@PUT
	public Response putEvent(EventDTO event) {
		try {
			handlerService.saveEvent(event);
			return Response.accepted(event).build();
		}
		catch (Exception e) {
			LOGGER.error("Failed to put event: {}", event, e);
			return Response.serverError().build();
		}
	}

}
