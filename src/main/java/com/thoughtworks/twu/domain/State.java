package com.thoughtworks.twu.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "location_presences" )
public class State {
    public int id;
    public String country_code;
    private String state;
    private int thoughtworks_presence;

    @Id
    @GeneratedValue(generator="id")
    @GenericGenerator(name="id", strategy = "increment")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String countryCode) {
        this.country_code = countryCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getThoughtworks_presence() {
        return thoughtworks_presence;
    }

    public void setThoughtworks_presence(int thoughtworks_presence) {
        this.thoughtworks_presence = thoughtworks_presence;
    }
}
