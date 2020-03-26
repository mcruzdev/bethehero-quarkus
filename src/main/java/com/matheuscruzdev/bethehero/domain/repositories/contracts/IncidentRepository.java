package com.matheuscruzdev.bethehero.domain.repositories.contracts;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.matheuscruzdev.bethehero.domain.entities.Incident;

/**
 * IncidentRepository
 */
@ApplicationScoped
public interface IncidentRepository {
    List<Incident> list();
    void insert(Incident incident);
}