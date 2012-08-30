package com.thoughtworks.twu.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table( name = "location_presences" )
public class LocationPresences {

    @Id
    private int id;

    @Column(name="COUNTRY_CODE")
    private String countryCode;

    @Column(name="state")
    private String state;

    @Column(name="thoughtworks_presence")
    private int thoughtworksPresence;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getThoughtworksPresence() {
        return thoughtworksPresence;
    }

    public void setThoughtworksPresence(int thoughtworksPresence) {
        this.thoughtworksPresence = thoughtworksPresence;
    }
}

