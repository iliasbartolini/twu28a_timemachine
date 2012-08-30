package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.SetupTest;
import org.junit.Before;
import org.junit.Test;

import static org.testng.Assert.assertEquals;

public class FavoriteTimesheetControllerTest extends SetupTest {

    FavoriteTimesheetController controller;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        controller = new FavoriteTimesheetController();
    }

    @Test
    public void shouldBeAbleToGetViewNameOfController() throws Exception {
        assertEquals("ui/timesheet/favorite/new_form", controller.newFavorite().getViewName());
    }
}
