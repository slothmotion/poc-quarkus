package com.slothmotion.poc.quarkus.repository.model;

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
