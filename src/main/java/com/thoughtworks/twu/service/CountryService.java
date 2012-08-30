package com.thoughtworks.twu.service;


import com.thoughtworks.twu.domain.Country;
import com.thoughtworks.twu.domain.LocationPresences;
import com.thoughtworks.twu.persistence.HibernateConnection;
import org.hibernate.Session;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class CountryService {

    private HibernateConnection connection;
    public Session session;

    private List<Country> countries;
    private List<LocationPresences> locationPresenceses;

    public List<Country> getCountries() {

        connection = HibernateConnection.getInstance();
        session = connection.getSession();

        countries = session.createCriteria(Country.class).list();

        return countries;
    }

    public List<LocationPresences> getStates(String countryCode) {
        connection = HibernateConnection.getInstance();
        session = connection.getSession();

        locationPresenceses = session.createCriteria(LocationPresences.class)
                .add(Restrictions.and(
                        Property.forName("state").isNotNull(),
                        Restrictions.eq("countryCode", countryCode)
                )).list();

        return locationPresenceses;
    }
}
