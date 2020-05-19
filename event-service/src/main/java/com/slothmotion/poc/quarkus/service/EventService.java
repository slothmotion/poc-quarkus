package com.slothmotion.poc.quarkus.service;

import java.util.Optional;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import com.slothmotion.poc.quarkus.configuration.EventConfig;
import com.slothmotion.poc.quarkus.configuration.EventServiceConfig;
import com.slothmotion.poc.quarkus.mapper.EventMapper;
import com.slothmotion.poc.quarkus.repository.EventRepository;
import com.slothmotion.poc.quarkus.repository.exception.MissingEntityException;
import com.slothmotion.poc.quarkus.rest.dto.EventDTO;
import com.slothmotion.poc.quarkus.service.api.EventHandler;
import com.slothmotion.poc.quarkus.service.api.EventTargetAnnotationLiteral;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestScoped
public class EventService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EventService.class);

	@Inject @Any
	Instance<EventHandler> handlers;

	private final EventRepository eventRepository;

	private final EventMapper eventMapper;

	private final EventConfig config;

	@Inject
	public EventService(EventRepository eventRepository, EventMapper eventMapper, EventConfig config) {
		this.eventRepository = eventRepository;
		this.eventMapper = eventMapper;
		this.config = config;
	}

	public void saveEvent(EventDTO event) {
		LOGGER.debug("Processing event: {}", event);

		Optional.ofNullable(config.getServices()).ifPresent(list ->	list.stream()
				.filter(EventServiceConfig::isEnabled)
				.map(it -> handlers.select(EventTargetAnnotationLiteral.eventTarget(it.getName())).get())
				.forEach(it -> it.handle(event)));
	}

	public EventDTO fetchEvent(String id) throws MissingEntityException {
		return eventRepository.fetch(id)
				.map(eventMapper::toEvent)
				.orElseThrow(() -> new MissingEntityException("Failed to find event with id: " + id));
	}
}
