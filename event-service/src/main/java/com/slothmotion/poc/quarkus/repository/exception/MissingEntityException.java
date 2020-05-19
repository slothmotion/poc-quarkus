package com.slothmotion.poc.quarkus.repository.exception;

import lombok.Getter;

@Getter
public class MissingEntityException extends Exception {

	public MissingEntityException(String message) {
		super(message);
	}
}
