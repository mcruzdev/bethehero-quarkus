package com.matheuscruzdev.bethehero.domain.entities;

import org.bson.types.ObjectId;
import io.quarkus.mongodb.panache.MongoEntity;

@MongoEntity(collection = "ongs")
public class ONG {

    private ObjectId id;
    private String name;
    private String email;
    private String whatsapp;
    private String city;
    private String uf;

    /**
     * @return the id
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the whatsapp
     */
    public String getWhatsapp() {
        return whatsapp;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @return the uf
     */
    public String getUf() {
        return uf;
    }
}