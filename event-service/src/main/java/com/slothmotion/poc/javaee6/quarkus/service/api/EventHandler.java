package com.slothmotion.poc.javaee6.quarkus.service.api;

import com.slothmotion.poc.javaee6.quarkus.rest.dto.EventDTO;

public interface EventHandler {

	void handle(EventDTO event);
}
