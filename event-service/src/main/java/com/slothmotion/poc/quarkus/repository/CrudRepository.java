package com.slothmotion.poc.quarkus.repository;

import java.util.Optional;

public interface CrudRepository<T, I> {

	void save(T t);

	Optional<T> fetch(I id);

	void delete(T t);
}
