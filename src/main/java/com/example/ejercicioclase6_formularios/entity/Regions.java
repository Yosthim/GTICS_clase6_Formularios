package com.example.ejercicioclase6_formularios.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "regions")
public class Regions {

    @Id
    @Column(name = "region_id")
    private int id;
    @Column(name = "region_name")
    private String regioname;

    public int getid() {
        return id;
    }

    public void setRegionid(int id) {
        this.id = id;
    }

    public String getRegioname() {
        return regioname;
    }

    public void setRegioname(String regioname) {
        this.regioname = regioname;
    }
}
