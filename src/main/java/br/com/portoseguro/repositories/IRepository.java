package br.com.portoseguro.repositories;

import java.util.List;

public interface IRepository<T> {
    List<T> getAll() throws Exception;

    T getById(int id) throws Exception;

    void save(T item) throws Exception;

    T update(int id, T item) throws Exception;

    void delete(int id) throws Exception;
}
