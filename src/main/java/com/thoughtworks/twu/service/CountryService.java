package com.thoughtworks.twu.service;


import com.thoughtworks.twu.domain.Country;
import com.thoughtworks.twu.domain.State;

import com.thoughtworks.twu.persistence.HibernateConnection;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountryService {

    private HibernateConnection connection;
    public Session session;

    private List<Country> countries;
    private List<State> states;
    private HashMap<String, List<State>> countryStates = new HashMap<String, List<State>>();

    public CountryService() {

        connection = HibernateConnection.getInstance();
        session = connection.getSession();

        countries = session.createQuery("from com.thoughtworks.twu.domain.Country").list();
        states = session.createQuery("from com.thoughtworks.twu.domain.State").list();
        for(State state : states) {
            if(!countryStates.containsKey(state.getCountry_code())) {
                countryStates.put(state.getCountry_code(), new ArrayList<State>());
            }
            if(state.getState() != null) {
                countryStates.get(state.getCountry_code()).add(state);
            }

        }

    }

    public List<Country> getCountries() {
        return countries;

    }

    public List<State> getStates(String countryCode) {
        return countryStates.get(countryCode);

    }


    public Country getCountry(String countryCode) {
        for(Country country : countries) {
            if(country.getCountry_code().equals(countryCode)) {
                return country;
            }
        }
        return null;
    }
}
