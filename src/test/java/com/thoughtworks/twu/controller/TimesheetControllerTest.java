package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.domain.timesheet.forms.TimeSheetForm;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BindingResult;

import static org.mockito.Mockito.mock;
import static org.testng.Assert.assertEquals;

public class TimesheetControllerTest {

    TimesheetController controller;

    @Before
    public void setUp() throws Exception {
        controller = new TimesheetController();
    }

    @Test
    public void shouldBeAbleToGetViewNameOfController() throws Exception {

        TimeSheetForm timeSheetForm = new TimeSheetForm();
        BindingResult bindingResult = mock(BindingResult.class);
        assertEquals("ui/timesheet/new_form", controller.newFavorite(timeSheetForm,bindingResult).getViewName());
    }
}
