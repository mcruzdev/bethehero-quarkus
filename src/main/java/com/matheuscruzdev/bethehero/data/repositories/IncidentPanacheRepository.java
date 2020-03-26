package com.matheuscruzdev.bethehero.data.repositories;

import javax.enterprise.context.ApplicationScoped;

import com.matheuscruzdev.bethehero.domain.entities.Incident;
import com.matheuscruzdev.bethehero.domain.repositories.contracts.IncidentRepository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;


@ApplicationScoped
public class IncidentPanacheRepository implements PanacheRepository<Incident>, IncidentRepository {}