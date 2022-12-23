package com.practice.customer_manager.model;

import javax.persistence.*;

@Entity
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProvince;
    private String name;

    public Province() {
    }

    public Province(String name) {
        this.name = name;
    }

    public Integer getIdProvince() {
        return idProvince;
    }

    public void setIdProvince(Integer id) {
        this.idProvince = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
