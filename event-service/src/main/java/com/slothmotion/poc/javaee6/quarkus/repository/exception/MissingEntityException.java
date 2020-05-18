package com.slothmotion.poc.javaee6.quarkus.repository.exception;

import lombok.Getter;

@Getter
public class MissingEntityException extends Exception {

	public MissingEntityException(String message) {
		super(message);
	}
}
