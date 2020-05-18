package com.slothmotion.poc.javaee6.quarkus.repository;

import java.util.Optional;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.slothmotion.poc.javaee6.quarkus.repository.model.Event;

@RequestScoped
public class EventRepository implements CrudRepository<Event, String> {

	private EntityManager em;

	@Inject
	public EventRepository(EntityManager em) {
		this.em = em;
	}

	@Override
	@Transactional
	public void save(Event event) {
		em.persist(event);
	}

	@Override
	public Optional<Event> fetch(String id) {
		return Optional.ofNullable(em.find(Event.class, id));
	}

	@Override
	@Transactional
	public void delete(Event event) {
		em.remove(event);
	}
}
