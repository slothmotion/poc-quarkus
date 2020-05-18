package com.slothmotion.poc.javaee6.quarkus.service;

import javax.enterprise.context.RequestScoped;

import com.slothmotion.poc.javaee6.quarkus.rest.dto.EventDTO;
import com.slothmotion.poc.javaee6.quarkus.service.api.EventHandler;
import com.slothmotion.poc.javaee6.quarkus.service.api.EventTarget;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestScoped
@EventTarget("queue")
class EventQueueHandler implements EventHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(EventQueueHandler.class);

	//https://quarkus.io/guides/amqp

	@Override
	public void handle(EventDTO event) {
		LOGGER.info("Submitting event: {}", event);
	}
}
