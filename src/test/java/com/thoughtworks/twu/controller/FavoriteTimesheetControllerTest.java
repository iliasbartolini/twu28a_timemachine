package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.persistence.HibernateConnection;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.web.servlet.ModelAndView;

import java.sql.DriverManager;

import static org.testng.Assert.*;

public class FavoriteTimesheetControllerTest {

    private static EmbeddedDatabase db;

    @BeforeClass
    public static void beforeClass() throws Exception {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        db = builder.setType(EmbeddedDatabaseType.H2).setName("test").
                addScript("/twu_database/schema.sql").
                addScript("/twu_database/import.sql").build();
    }



    FavoriteTimesheetController controller;

    @Before
    public void init() {
        controller = new FavoriteTimesheetController();

    }

    @Test
    public void shouldBeAbleToGetViewNameOfController() throws Exception {
        assertEquals("ui/timesheet/favorite/new_form", controller.newFavorite().getViewName());
    }

    @Test
    public void shouldBeAbleToCreateNewFavoriteTimeSheet() throws Exception {


    }

}
