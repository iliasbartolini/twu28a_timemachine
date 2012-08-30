package com.thoughtworks.twu;

import com.thoughtworks.twu.persistence.HibernateConnection;
import org.junit.AfterClass;
import org.junit.Before;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

public class SetupTest {

    @AfterClass
    public static void afterClass() throws Exception {
        if ( HibernateConnection.getInstance().getSession().isConnected() )
            HibernateConnection.getInstance().getSession().close();
    }

    @Before
    public void setUp() throws Exception {
        setupDB();
    }

    public void setupDB() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.H2).setName("test").
                addScript("/twu_database/cleanDB.sql").
                addScript("/twu_database/schema.sql").
                addScript("/twu_database/import.sql").build();
    }
}
