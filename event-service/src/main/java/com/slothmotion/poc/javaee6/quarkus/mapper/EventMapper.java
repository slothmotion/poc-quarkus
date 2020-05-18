package com.slothmotion.poc.javaee6.quarkus.mapper;

import com.slothmotion.poc.javaee6.quarkus.repository.model.Event;
import com.slothmotion.poc.javaee6.quarkus.rest.dto.EventDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface EventMapper {

	EventDTO toEvent(Event event);
}
