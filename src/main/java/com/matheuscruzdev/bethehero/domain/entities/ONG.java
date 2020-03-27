package com.matheuscruzdev.bethehero.domain.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ong") 
public class ONG {

    @Id
    @GenericGenerator(strategy = "com.matheuscruzdev.bethehero.data.CodeIdentifierGenerator", name = "code")
    @GeneratedValue(generator = "code")
    private String id;
    private String name;
    private String email;
    private String whatsapp;
    private String city;
    private String uf;
    
    @OneToMany
    @JsonIgnore
    @JoinColumn(name = "ong_id")
    private List<Incident> incidents = new ArrayList<>();

    protected ONG() {}

    public ONG(String id, String name, String email, String whatsapp, String city, String uf, List<Incident> incidents) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.whatsapp = whatsapp;
        this.city = city;
        this.uf = uf;
        this.incidents = incidents;
    }

    private ONG(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public static ONG from(String id, String name) {
        return new ONG(id, name);
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the whatsapp
     */
    public String getWhatsapp() {
        return whatsapp;
    }

    /**
     * @param whatsapp the whatsapp to set
     */
    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the uf
     */
    public String getUf() {
        return uf;
    }

    /**
     * @param uf the uf to set
     */
    public void setUf(String uf) {
        this.uf = uf;
    }

    /**
     * @return the incidents
     */
    public List<Incident> getIncidents() {
        return incidents;
    }

    /**
     * @param incidents the incidents to set
     */
    public void setIncidents(List<Incident> incidents) {
        this.incidents = incidents;
    }
}