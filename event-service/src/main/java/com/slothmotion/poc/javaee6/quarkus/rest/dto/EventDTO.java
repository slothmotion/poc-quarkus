package com.slothmotion.poc.javaee6.quarkus.rest.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class EventDTO implements Serializable {

	private String id;

	private String message;
}
