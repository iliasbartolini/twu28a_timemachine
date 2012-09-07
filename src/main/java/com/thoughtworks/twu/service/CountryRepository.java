package com.thoughtworks.twu.service;

import com.thoughtworks.twu.domain.Country;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryRepository {


    private SessionFactory sessionFactory;

    @Autowired
    public CountryRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Country> getCountries() {
        return sessionFactory.getCurrentSession().createCriteria(Country.class).list();
    }
}
