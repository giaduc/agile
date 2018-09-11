package service;

import java.util.List;

public interface IRepository<E> {

	List<E> getAll();

	E findBy(String id);

	void insert(E e);

	void update(E e);

	void delete(E e);

}
