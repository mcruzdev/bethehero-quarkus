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
    public List<Incident> getAllByOngId(final String ongId) {

        return findAll().stream()
            .filter(incident -> incident.getOng().getId().equals(ongId))
            .collect(Collectors.toList());
    }

    @Override
    public void insert(final Incident incident) {

        persist(incident);
    }

    @Override
    public void delete(final Long id) {

        delete("id", id);
    }

    public long countIncidentsByOngId(String ongId) {

        return findAll().stream()
            .filter(incident -> incident.getOng().getId().equals(ongId))
            .count();
    }

    @Override
    public List<Incident> getAll(int page) {

        final var offset = ((page - 1) * 5);
        return findAll().stream()
            .skip(offset)
            .limit(5)
            .collect(Collectors.toList());
    }

    @Override
    public long countIncidents() {

        return findAll().count();
    }
}