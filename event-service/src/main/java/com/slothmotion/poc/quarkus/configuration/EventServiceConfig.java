package com.slothmotion.poc.quarkus.configuration;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class EventServiceConfig {

	@NotNull
	private String name;

	@NotNull
	private boolean enabled;
}
