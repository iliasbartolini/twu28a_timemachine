package com.thoughtworks.twu.persistence;

import com.thoughtworks.twu.domain.Country;
import com.thoughtworks.twu.domain.LocationPresences;
import org.hibernate.SessionFactory;
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
        return sessionFactory.getCurrentSession().createCriteria(Country.class).list();
    }

}
