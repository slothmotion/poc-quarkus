package com.slothmotion.poc.javaee6.quarkus.configuration;

import java.util.List;

import io.quarkus.arc.config.ConfigProperties;
import lombok.Data;

@Data
@ConfigProperties(prefix = "event")
public class EventConfig {

	private List<EventServiceConfig> services;
}
