package com.matheuscruzdev.bethehero.domain.repositories;

import io.quarkus.mongodb.panache.PanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;
import com.matheuscruzdev.bethehero.domain.entities.ONG;

@ApplicationScoped
public class ONGRepository implements PanacheMongoRepository<ONG> {}