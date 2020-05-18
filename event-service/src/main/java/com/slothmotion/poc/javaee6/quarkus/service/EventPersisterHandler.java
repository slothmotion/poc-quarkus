package com.slothmotion.poc.javaee6.quarkus.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.slothmotion.poc.javaee6.quarkus.repository.EventRepository;
import com.slothmotion.poc.javaee6.quarkus.repository.model.Event;
import com.slothmotion.poc.javaee6.quarkus.rest.dto.EventDTO;
import com.slothmotion.poc.javaee6.quarkus.service.api.EventHandler;
import com.slothmotion.poc.javaee6.quarkus.service.api.EventTarget;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestScoped
@EventTarget("database")
class EventPersisterHandler implements EventHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(EventPersisterHandler.class);

	private EventRepository eventRepository;

	@Inject
	public EventPersisterHandler(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

	@Override
	public void handle(EventDTO event) {
		LOGGER.info("Persisting event: {}", event);

		Event eventEntity = new Event();
		eventEntity.setId(event.getId());
		eventEntity.setMessage(event.getMessage());
		eventRepository.save(eventEntity);
	}
}
