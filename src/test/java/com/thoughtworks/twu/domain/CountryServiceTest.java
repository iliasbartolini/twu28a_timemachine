package com.thoughtworks.twu.domain;

import com.thoughtworks.twu.persistence.HibernateConnection;
import com.thoughtworks.twu.service.CountryService;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.util.List;

import static junit.framework.Assert.assertEquals;

public class CountryServiceTest {

    @BeforeClass
    public static void beforeClass() throws Exception {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.H2).setName("test").
                addScript("/twu_database/cleanDB.sql").
                addScript("/twu_database/schema.sql").
                addScript("/twu_database/import.sql").build();
    }

    @AfterClass
    public static void afterClass() throws Exception {
        if (HibernateConnection.getInstance().getSession().isConnected())
            HibernateConnection.getInstance().getSession().close();
    }

    @Test
    public void shouldReturnListOfCountries() {

        CountryService service = new CountryService();

        List<Country> result = null;

        result = service.getCountries();

        assertEquals(239, result.size());
    }

    @Test
    public void shouldReturnUSStates() {

        CountryService service = new CountryService();
        List<State> result = service.getStates("USA");
        assertEquals(55, result.size());
    }

    @Test
    public void shouldReturnEmptyListForNonUS() {
        CountryService service = new CountryService();
        List<State> result = service.getStates("AUS");
        assertEquals(0, result.size());
    }
}
