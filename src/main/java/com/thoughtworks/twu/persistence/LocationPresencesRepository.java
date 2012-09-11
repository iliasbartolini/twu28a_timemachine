package com.thoughtworks.twu.persistence;

import com.thoughtworks.twu.domain.LocationPresences;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class LocationPresencesRepository {

    private SessionFactory sessionFactory;

    public LocationPresencesRepository() {
    }

    @Autowired
    public LocationPresencesRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<LocationPresences> getStates(String countryCode) {
        return sessionFactory.getCurrentSession().createCriteria(LocationPresences.class)
                .add(Restrictions.and(
                        Property.forName("state").isNotNull(),
                        Restrictions.eq("countryCode", countryCode)))
                .addOrder(Order.asc("state")).list();
    }
}