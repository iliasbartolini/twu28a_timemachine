package com.thoughtworks.twu.service;

import com.thoughtworks.twu.persistence.Country;
import com.thoughtworks.twu.persistence.HibernateConnection;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class CountryService {

    private List<Country> countryList = new ArrayList<Country>();

    public CountryService() {
    }

    public List<Country> getCountries() {
        HibernateConnection connection = HibernateConnection.getInstance();
        Session session = connection.getSession();

        countryList = session.createCriteria(Country.class).list();

        return countryList;
    }


}
