package com.slothmotion.poc.quarkus.service;

import javax.enterprise.context.RequestScoped;

import com.slothmotion.poc.quarkus.rest.dto.EventDTO;
import com.slothmotion.poc.quarkus.service.api.EventHandler;
import com.slothmotion.poc.quarkus.service.api.EventTarget;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestScoped
@EventTarget("queue")
class EventQueueHandler implements EventHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(EventQueueHandler.class);

	//https://quarkus.io/guides/amqp

	@Override
	public void handle(EventDTO event) {
		LOGGER.debug("Submitting event: {}", event);
	}
}
