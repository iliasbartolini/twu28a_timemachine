package com.thoughtworks.twu.service;


import com.thoughtworks.twu.domain.Country;
import com.thoughtworks.twu.domain.LocationPresences;
import com.thoughtworks.twu.persistence.HibernateConnection;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryService {

    private CountryRepository repository;

    public CountryService() {
    }

    @Autowired
    public CountryService(CountryRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public List<Country> getCountries() {
        return repository.getCountries();
    }

    //    private HibernateConnection connection;
//    public Session session;
//
//    private List<Country> countries;
//    private List<LocationPresences> locationPresences;

//    public List<Country> getCountries() {
//
//        connection = HibernateConnection.getInstance();
//        session = connection.getSession();
//
//        countries = session.createCriteria(Country.class).
//                addOrder(Order.asc("name")).
//                list();
//
//        return countries;
//    }
//
    @Transactional
    public List<LocationPresences> getStates(String countryCode) {
        HibernateConnection connection = HibernateConnection.getInstance();
        Session session = connection.getSession();

        List locationPresences = session.createCriteria(LocationPresences.class)
                .add(Restrictions.and(
                        Property.forName("state").isNotNull(),
                        Restrictions.eq("countryCode", countryCode)))
                .addOrder(Order.asc("state")).list();

        return locationPresences;
    }
}
