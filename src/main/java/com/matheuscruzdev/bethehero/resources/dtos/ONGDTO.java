package com.matheuscruzdev.bethehero.resources.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.matheuscruzdev.bethehero.domain.entities.ONG;

public class ONGDTO {

    public String id;
    public String name;
    public String email;
    public String whatsapp;
    public String city;
    public String uf;
    public List<IncidentDTO> incidents = new ArrayList<IncidentDTO>();

    public ONGDTO() {}

    public ONGDTO(String id, String name, String email, String whatsapp, String city, String uf) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.whatsapp = whatsapp;
        this.city = city;
        this.uf = uf;
    }

    public ONG convert() {
        var domainIncidents = incidents.stream()
            .map(incident -> incident.convert())
            .collect(Collectors.toList());

        return new ONG(id, name, email, whatsapp, city, uf, domainIncidents);
    }

	public static ONGDTO from(ONG oNG) {
		return new ONGDTO(
            oNG.getId(),
            oNG.getName(),
            oNG.getEmail(),
            oNG.getWhatsapp(),
            oNG.getCity(),
            oNG.getUf());
	}
}
