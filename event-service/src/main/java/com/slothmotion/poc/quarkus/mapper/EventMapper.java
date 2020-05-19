package com.slothmotion.poc.quarkus.mapper;

import com.slothmotion.poc.quarkus.repository.model.Event;
import com.slothmotion.poc.quarkus.rest.dto.EventDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface EventMapper {

	EventDTO toEvent(Event event);
}
