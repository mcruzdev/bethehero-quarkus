package com.matheuscruzdev.bethehero.data.repositories;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.matheuscruzdev.bethehero.domain.entities.Incident;
import com.matheuscruzdev.bethehero.domain.repositories.contracts.IncidentRepository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@Named(value = "IncidentPanacheRepository")
@ApplicationScoped
public class IncidentPanacheRepository implements PanacheRepository<Incident>, IncidentRepository {

    @Override
    public List<Incident> list() {

        return findAll().list();
    }

    @Override
    public void insert(Incident incident) {
        
        persist(incident);

    }

    @Override
    public void delete(Long id) {
        delete("id", id);
    }
}