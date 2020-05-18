package com.slothmotion.poc.javaee6.quarkus.service.api;

import javax.enterprise.util.AnnotationLiteral;

public class EventTargetAnnotationLiteral extends AnnotationLiteral<EventTarget> implements EventTarget {

	private String value;

	private EventTargetAnnotationLiteral(String value) {
		this.value = value;
	}

	@Override
	public String value() {
		return value;
	}

	public static EventTargetAnnotationLiteral eventTarget(String value) {
		return new EventTargetAnnotationLiteral(value);
	}
}
