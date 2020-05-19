package com.slothmotion.poc.quarkus.service.api;

import com.slothmotion.poc.quarkus.rest.dto.EventDTO;

public interface EventHandler {

	void handle(EventDTO event);
}
