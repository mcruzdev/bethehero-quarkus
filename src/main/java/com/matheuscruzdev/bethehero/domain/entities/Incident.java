package com.matheuscruzdev.bethehero.domain.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "incident")
public class Incident implements Serializable {

    private static final long serialVersionUID = -7639522141268374332L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private BigDecimal value;

    @ManyToOne
    private ONG ong;

    protected Incident() {}

    public Incident(final Long id, final String title, final String description, final BigDecimal value, final ONG ong) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.value = value;
        this.ong = ong;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the value
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    /**
     * @return the ong
     */
    public ONG getOng() {
        return ong;
    }

    /**
     * @param ong the ong to set
     */
    public void setOng(ONG ong) {
        this.ong = ong;
    }
}