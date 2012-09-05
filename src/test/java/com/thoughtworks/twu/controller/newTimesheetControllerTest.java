package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.domain.NewTimesheetForm;
import com.thoughtworks.twu.domain.timesheet.forms.TimeSheetForm;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BindingResult;

import static org.mockito.Mockito.mock;
import static org.testng.Assert.assertEquals;


public class newTimesheetControllerTest {
    NewTimesheetController controller;

    @Before
    public void setUp() throws Exception {
        controller = new NewTimesheetController();
    }

    @Test
    public void shouldBeAbleToGetViewNameOfController() throws Exception {

        NewTimesheetForm newTimeSheetForm = new NewTimesheetForm();
        assertEquals("new_form", controller.displayTimeSheet(newTimeSheetForm).getViewName());
    }

}
