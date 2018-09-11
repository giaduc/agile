package service;

import java.util.List;
import java.util.Optional;

public interface IRepository<E> {

	List<E> getAll();

	Optional<E> findBy(String id);

	void insert(E e);

	void update(E e);

	void delete(E e);

}
