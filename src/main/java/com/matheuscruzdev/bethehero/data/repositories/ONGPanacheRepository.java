package com.matheuscruzdev.bethehero.data.repositories;

import javax.enterprise.context.ApplicationScoped;
import com.matheuscruzdev.bethehero.domain.entities.ONG;
import com.matheuscruzdev.bethehero.domain.repositories.contracts.ONGRepository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ONGPanacheRepository implements PanacheRepository<ONG>, ONGRepository {

    public ONG findById(String authorization) {
        return find("id", authorization).firstResult();
    }
}