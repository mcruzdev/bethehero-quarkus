package com.matheuscruzdev.bethehero.resources.dtos;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.matheuscruzdev.bethehero.domain.entities.Incident;

/**
 * IncidentDTO
 */
public class IncidentDTO {

    public Long id;
    public String title;
    public String description;
    public BigDecimal value;
    @JsonIgnore
    public ONGDTO ong;

    public Incident convert() {

        var domainONG = ong.convert();
        return new Incident(id, title, description, value, domainONG);
    }
}   

