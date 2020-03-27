package com.matheuscruzdev.bethehero.data.repositories;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.matheuscruzdev.bethehero.domain.entities.ONG;
import com.matheuscruzdev.bethehero.domain.repositories.contracts.ONGRepository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@Named(value = "ONGPanacheRepository")
@ApplicationScoped
public class ONGPanacheRepository implements PanacheRepository<ONG>, ONGRepository {

    @Override
    public ONG getById(final String id) {

        return find("id", id).firstResult();
    }

    @Override
    public void insert(final ONG ong) {

        persist(ong);
    }

    @Override
    public List<ONG> getAll() {

        return findAll().list();
    }

    @Override
    public void delete(String id) {

        delete("id", id);
    }

    public Optional<ONG> getNameAndIdById(String id) {

        return findAll().stream()
            .filter(ong -> ong.getId().equals(id))
            .map(ong -> ONG.from(ong.getId(), ong.getName()))
            .findFirst();
    }
}