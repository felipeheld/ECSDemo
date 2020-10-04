package com.example.demo.repository;

import java.util.Optional;

import com.example.demo.model.BaseClient;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository<T extends BaseClient> extends CrudRepository<T, Long> {
    
    Optional<T> findById(Long id);
    T findByName(String name);
    Iterable<T> findAll();
    <S extends T> S save(S entity);
    void delete(T entity);
    void deleteById(Long id);
}
