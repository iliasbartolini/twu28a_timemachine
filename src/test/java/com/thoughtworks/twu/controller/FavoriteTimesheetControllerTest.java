package com.thoughtworks.twu.controller;

import org.junit.Before;
import org.junit.Test;

import static org.testng.Assert.assertEquals;

public class FavoriteTimesheetControllerTest {

    FavoriteTimesheetController controller;

    @Before
    public void setUp() throws Exception {
        controller = new FavoriteTimesheetController();
    }

    @Test
    public void shouldBeAbleToGetViewNameOfController() throws Exception {
        assertEquals("ui/timesheet/favorite/new_form", controller.newFavorite().getViewName());
    }
}
