package com.thoughtworks.twu.persistence;

import javax.persistence.*;

@Entity
@Table(name="COUNTRIES")
public class Country {

    @Column(name = "COUNTRY_CODE")
    private String code;

    @Column(name="COUNTRY_NAME")
    private String name;

    @Id
    @Column(name="ID")
    private String id;

    public Country(String name) {
        this.name = name;
    }

    public Country() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
