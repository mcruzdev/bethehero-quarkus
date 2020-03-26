package com.matheuscruzdev.bethehero.domain.repositories.contracts;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

import com.matheuscruzdev.bethehero.domain.entities.ONG;

/**
 * ONGRepository
 */
@ApplicationScoped
public interface ONGRepository {
    ONG getById(String id);
    void insert(ONG ong);
    List<ONG> getAll();
    void delete(String id);
    Optional<ONG> getNameAndIdById(String id);
}