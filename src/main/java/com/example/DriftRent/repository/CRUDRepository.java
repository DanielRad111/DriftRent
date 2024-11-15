package com.example.DriftRent.repository;

public interface CRUDRepository<T, IdType> {

    T save(T entity);

    T update(T entity);

    T findById(IdType id);

    boolean delete(T entity);

}