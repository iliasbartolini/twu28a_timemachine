package com.thoughtworks.twu.domain;

import javax.persistence.*;

@Entity
@Table( name = "countries" )
public class Country {

    @Id
    private String id;

    @Column(name = "COUNTRY_NAME")
    private String name;

    @Column(name = "COUNTRY_CODE")
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
