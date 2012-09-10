package com.thoughtworks.twu.persistence;

import com.thoughtworks.twu.domain.Country;
import org.hibernate.Session;

import java.util.List;

public class CountryRepository {


    public List<Country> loadCountries() {
        Session session= HibernateConnection.getInstance().getSession();
        return session.createCriteria(Country.class).list();

    }
}
