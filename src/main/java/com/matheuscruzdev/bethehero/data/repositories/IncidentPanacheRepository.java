package com.matheuscruzdev.bethehero.data.repositories;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.matheuscruzdev.bethehero.domain.entities.Incident;
import com.matheuscruzdev.bethehero.domain.repositories.contracts.IncidentRepository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@Named(value = "IncidentPanacheRepository")
@ApplicationScoped
public class IncidentPanacheRepository implements PanacheRepository<Incident>, IncidentRepository {

    @Override
    public List<Incident> page(int page) {
        var offset = ((page - 1) * 5);

        return findAll().stream()
            .skip(offset)
            .limit(5)
            .collect(Collectors.toList());
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