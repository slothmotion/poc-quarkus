package com.slothmotion.poc.javaee6.quarkus.repository.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Event {

	@Id
	private String id;

	private String message;
}
