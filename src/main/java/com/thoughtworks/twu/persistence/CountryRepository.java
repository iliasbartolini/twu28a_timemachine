package com.thoughtworks.twu.persistence;

import com.thoughtworks.twu.domain.Country;

import com.thoughtworks.twu.domain.LocationPresences;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CountryRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public CountryRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public CountryRepository() {
    }

    @Transactional
    public List<Country> loadCountries() {
        return sessionFactory.getCurrentSession().createCriteria(Country.class).addOrder(Order.asc("name")).list();
    }

    @Transactional
    public List<Country> loadCountriesWithTWPresence() {
        return sessionFactory.getCurrentSession().createQuery("select distinct c from Country c,LocationPresences lp " +
                "where c.code = lp.countryCode and lp.thoughtworksPresence=1 order by c.code").list();

    }
}
