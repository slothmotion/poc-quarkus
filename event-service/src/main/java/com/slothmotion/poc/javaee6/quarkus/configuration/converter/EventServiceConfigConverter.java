package com.slothmotion.poc.javaee6.quarkus.configuration.converter;

import com.slothmotion.poc.javaee6.quarkus.configuration.EventServiceConfig;
import org.eclipse.microprofile.config.spi.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventServiceConfigConverter implements Converter<EventServiceConfig> {

	private static final Logger LOGGER = LoggerFactory.getLogger(EventServiceConfigConverter.class);

	@Override
	public EventServiceConfig convert(String value) {
		LOGGER.info("Converting value: {}", value);
		// this is really weird, quarkus is not able to handle array of yaml objects properly,
		// it concatenates the whole thing into a single string object
		String[] split = value.split("=");
		EventServiceConfig config = new EventServiceConfig();
		config.setName(split[1].substring(0, split[1].length() - "enabled".length()));
		config.setEnabled(Boolean.parseBoolean(split[2]));
		LOGGER.info("Conversion result: {}",  config);
		return config;
	}
}
