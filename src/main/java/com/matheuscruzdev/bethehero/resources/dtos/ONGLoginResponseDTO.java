package com.matheuscruzdev.bethehero.resources.dtos;

import com.matheuscruzdev.bethehero.domain.entities.ONG;

/**
 * ONGLoginResponseDTO
 */
public class ONGLoginResponseDTO {

    public String id;
    public String name;

    private ONGLoginResponseDTO(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
	public static Object from(ONG ong) {
        
        return new ONGLoginResponseDTO(ong.getId(), ong.getName());
	}
}