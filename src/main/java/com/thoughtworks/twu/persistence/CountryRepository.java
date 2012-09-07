package com.thoughtworks.twu.persistence;

import com.thoughtworks.twu.domain.Country;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
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
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Country.class);
        criteria.addOrder(Order.asc("name"));
        return criteria.list();
    }
}
