package com.thoughtworks.twu.integration.persistence;


import com.thoughtworks.twu.domain.LocationPresences;
import com.thoughtworks.twu.persistence.LocationPresencesRepository;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = LocationPresencesRepositoryTest.Config.class)
@TransactionConfiguration(transactionManager = "repoTransactionManager", defaultRollback = false)
@Transactional
public class LocationPresencesRepositoryTest {

    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void testGetStateForUsa() throws Exception {
        LocationPresencesRepository repository = new LocationPresencesRepository(sessionFactory);

        List<LocationPresences> states = repository.getStates("USA");

        assertThat(states.size(), is(55));
    }

    @Configuration
    static class Config extends RepositoryContextConfiguration {
        Config() {
            super("classpath:twu_database/te/LOCATION_PRESENCES_DATA_TABLE.sql");
        }
    }
}