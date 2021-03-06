package com.thoughtworks.twu.integration.persistence;

import com.thoughtworks.twu.domain.Country;
import com.thoughtworks.twu.persistence.CountryRepository;
import org.hibernate.SessionFactory;
import org.junit.Before;
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
@ContextConfiguration(classes = CountryRepositoryTest.Config.class)
@TransactionConfiguration(transactionManager = "repoTransactionManager", defaultRollback = false)
@Transactional
public class CountryRepositoryTest {

    @Autowired
    private SessionFactory sessionFactory;
    private CountryRepository repository;

    @Before
    public void setUp() throws Exception {
        repository = new CountryRepository(sessionFactory);
    }

    @Test
    public void testGetCountries() throws Exception {

        List<Country> countries = repository.loadCountries();

        assertThat(countries.size(), is(239));
    }

    @Test
    public void shouldLoadCountriesWithTWPresence() throws Exception {

        List<Country> countries = repository.loadCountriesWithTWPresence();
        assertThat(countries.size(), is(11));

    }

    @Configuration
    static class Config extends RepositoryContextConfiguration {
        Config() {
            super("classpath:twu_database/te/COUNTRIES_DATA_TABLE.sql", "classpath:twu_database/te/LOCATION_PRESENCES_DATA_TABLE.sql");
        }
    }
}