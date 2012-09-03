package com.thoughtworks.twu.controller;

import org.junit.Before;
import org.junit.Test;

import static org.testng.Assert.assertEquals;

public class TimesheetControllerTest {

    TimesheetController controller;

    @Before
    public void setUp() throws Exception {
        controller = new TimesheetController();
    }

    @Test
    public void shouldBeAbleToGetViewNameOfController() throws Exception {
        assertEquals("ui/timesheet/new_form", controller.newTimesheet().getViewName());
    }
}
