package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.domain.timesheet.forms.TimeSheetForm;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BindingResult;

import static org.mockito.Mockito.mock;
import static org.testng.Assert.assertEquals;

public class TimesheetControllerTest {

    TimesheetController controller;
    private TimeSheetForm timeSheetForm;
    private BindingResult bindingResult;

    @Before
    public void setUp() throws Exception {
        controller = new TimesheetController();
        timeSheetForm = new TimeSheetForm();
        bindingResult = mock(BindingResult.class);
    }



    @Test
    public void shouldBeAbleToGetViewNameOfController() throws Exception {
        assertEquals("ui/timesheet/new_form", controller.newTimesheet(timeSheetForm,bindingResult).getViewName());
    }
}
